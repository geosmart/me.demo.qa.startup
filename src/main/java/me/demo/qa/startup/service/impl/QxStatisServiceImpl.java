package me.demo.qa.startup.service.impl;

import java.io.StringReader;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Calendar;
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
 * Service-气象统计服务
 * 
 * @author geosmart
 */
public class QxStatisServiceImpl implements IQxStatisService {

  private static Logger log = LoggerFactory.getLogger(QxStatisServiceImpl.class);
 
  IQxStatisDao qxStatisDao;
  ConstantUtil constantUtil;

  @Override
  public Pager<实况天气统计表> queryStatis() {
    Pager<实况天气统计表> result = null;
    try {
      String hql = "from 实况天气统计表 order by timeOrder desc";
      result = qxStatisDao.find(hql);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return result;
  }

  @Override
  public void saveStatis() {
    try {
      // 获取实时数据
      int timeOrder = 0;
      Sktq sktq = getStatisData();
      if (sktq.checkFistLine() == false) {
        return;
      }
      Timestamp timestamp = handleSktqDateTime(sktq);
      // 删除过期数据
      deleteStatisOutOfDate(timestamp.getTime());

      String city = sktq.getCity();
      String id = sktq.getId();

      for (Qw qw : sktq.getQw()) {
        实况天气统计表 bean = new 实况天气统计表(UUID.randomUUID().toString(), id, city, timestamp);
        BeanUtils.copyProperties(bean, qw);
        bean.setTimeOrder(timeOrder);
        timeOrder++;
        qxStatisDao.saveOrUpdate(bean);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void deleteStatisOutOfDate(long time) {
    String hql = "delete from 实况天气统计表 where ptime >  " + time;
    qxStatisDao.updateByHql(hql);
  }

  @Override
  public Sktq getStatisData() {
    Sktq sktq = null;
    try {
      Client client = ClientBuilder.newClient();
      WebTarget target = client.target(constantUtil.getWeather_statis());

      String dataStr = target.request(MediaType.APPLICATION_XML).get(String.class);
      log.debug(dataStr);
      if (StringUtils.isNotEmpty(dataStr)) {
        // 将xml字符串通过jaxb转换为java pojo
        JAXBContext ctx = JAXBContext.newInstance(Sktq.class);
        Unmarshaller um = ctx.createUnmarshaller();
        sktq = (Sktq) um.unmarshal(new StringReader(dataStr));
      }
    } catch (JAXBException e) {
      e.printStackTrace();
    }
    return sktq;
  }

  /**
   * 实况天气-时间处理
   * 
   * @see 原始格式"15-05-24 19:00"
   * @see 目标格式"2015-05-24 19:00:00"
   * @param sktq
   * @return Timestamp
   */
  private Timestamp handleSktqDateTime(Sktq sktq) {
    Timestamp timestamp = null;
    try {
      String[] dateArray = sktq.getPtime().split("-");
      dateArray[0] = new Integer(Calendar.getInstance().get(Calendar.YEAR)).toString();
      String dateStr = StringUtils.join(dateArray, "-") + ":00";
      Date date;
      date = DateUtils.parseDate(dateStr, DateUtil.DATETIME_PATTERN);
      timestamp = new Timestamp(date.getTime());
    } catch (ParseException e) {
      e.printStackTrace();
    }
    return timestamp;
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
