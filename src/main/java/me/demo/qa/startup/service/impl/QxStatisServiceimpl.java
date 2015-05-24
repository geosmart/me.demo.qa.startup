package me.demo.qa.startup.service.impl;

import java.io.StringReader;
import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import me.demo.qa.startup.dao.IQxStatisDao;
import me.demo.qa.startup.entity.实况天气统计表;
import me.demo.qa.startup.entity.xsd.weather.Qw;
import me.demo.qa.startup.entity.xsd.weather.Sktq;
import me.demo.qa.startup.service.IQxStatisService;
import me.demo.qa.startup.util.ConstantUtil;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lt.util.DateUtil;
import com.lt.util.page.Pager;

/**
 * Service-气象统计
 * 
 * @author geosmart
 */
public class QxStatisServiceImpl implements IQxStatisService {

  private static Logger log = LoggerFactory.getLogger(QxStatisServiceImpl.class);


  IQxStatisDao qxStatisDao;
  ConstantUtil constantUtil;

  /**
   * 将xml字符串通过jaxb转换为java bean
   * 
   * @param dataStr
   */
  public Sktq getStatisData() {
    Sktq sktq = null;
    try {
      Client client = ClientBuilder.newClient();
      WebTarget target = client.target(constantUtil.getWeather_statis());

      String dataStr = target.request(MediaType.APPLICATION_XML).get(String.class);
      log.debug(dataStr);
      if (StringUtils.isNotEmpty(dataStr)) {
        // 读取xml，转换成jaxb实体，转换成json实体
        JAXBContext ctx = JAXBContext.newInstance(Sktq.class);
        Unmarshaller um = ctx.createUnmarshaller();
        sktq = (Sktq) um.unmarshal(new StringReader(dataStr));
      }
    } catch (JAXBException e) {
      e.printStackTrace();
    }
    return sktq;
  }

  @Override
  public Pager<实况天气统计表> queryStatis() {
    Pager<实况天气统计表> result = null;
    try {
      String hql = "from 实况天气统计表";
      result = qxStatisDao.find(hql);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return result;
  }

  @Override
  public void saveStatis() {
    try {
      Sktq sktq = getStatisData();
      Date date = DateUtils.parseDate(sktq.getPtime(), DateUtil.DATETIME_PATTERN);
      Timestamp timestamp = new Timestamp(date.getTime());
      String city = sktq.getCity();
      String id = sktq.getId();
      for (Qw qw : sktq.getQw()) {
        实况天气统计表 bean = new 实况天气统计表(UUID.randomUUID().toString(), id, city, timestamp);
        BeanUtils.copyProperties(bean, qw);
        qxStatisDao.save(bean);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public IQxStatisDao getQxStatisDao() {
    return qxStatisDao;
  }

  public void setQxStatisDao(IQxStatisDao qxStatisDao) {
    this.qxStatisDao = qxStatisDao;
  }

  public ConstantUtil getConstantUtil() {
    return constantUtil;
  }

  public void setConstantUtil(ConstantUtil constantUtil) {
    this.constantUtil = constantUtil;
  }
}
