package me.demo.qa.startup.service.impl;

import java.io.StringReader;
import java.util.UUID;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import me.demo.qa.startup.dao.ISkWeatherDao;
import me.demo.qa.startup.entity.实况天气表;
import me.demo.qa.startup.entity.xsd.skweather.Chuzhou;
import me.demo.qa.startup.entity.xsd.skweather.City;
import me.demo.qa.startup.service.ISkWeatherService;
import me.demo.qa.startup.util.ConstantUtil;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lt.util.page.Pager;

public class SkWeatherServiceImpl implements ISkWeatherService {
  private static Logger log = LoggerFactory.getLogger(SkWeatherServiceImpl.class);

  ISkWeatherDao skWeatherDao;
  ConstantUtil constantUtil;

  @Override
  public void saveWeather() {
    try {
      Chuzhou chuzhou = getWeatherData();
      deleteWeatherOutOfDate();
      for (City city : chuzhou.getCity()) {
        实况天气表 bean = new 实况天气表(UUID.randomUUID().toString());
        BeanUtils.copyProperties(bean, city);
        skWeatherDao.saveOrUpdate(bean);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public Pager<实况天气表> queryWeather() {
    Pager<实况天气表> result = null;
    try {
      String hql = "from 实况天气表";
      result = skWeatherDao.find(hql);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return result;
  }

  @Override
  public Chuzhou getWeatherData() {
    Chuzhou chuzhou = null;
    try {
      Client client = ClientBuilder.newClient();
      WebTarget target = client.target(constantUtil.getWeather_predict());

      String dataStr = target.request(MediaType.APPLICATION_XML).get(String.class);
      log.debug(dataStr);

      if (StringUtils.isNotEmpty(dataStr)) {
        // 将xml字符串通过jaxb转换为java pojo
        JAXBContext ctx = JAXBContext.newInstance(Chuzhou.class);
        Unmarshaller um = ctx.createUnmarshaller();
        chuzhou = (Chuzhou) um.unmarshal(new StringReader(dataStr));
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    return chuzhou;
  }

  @Override
  public void deleteWeatherOutOfDate() {
    String hql = "delete from 实况天气表 where guid is not null";
    skWeatherDao.updateByHql(hql);
  }

  public ISkWeatherDao getQxStatisDao() {
    return skWeatherDao;
  }

  public void setSkWeatherDao(ISkWeatherDao skWeatherDao) {
    this.skWeatherDao = skWeatherDao;
  }

  public ConstantUtil getConstantUtil() {
    return constantUtil;
  }

  public void setConstantUtil(ConstantUtil constantUtil) {
    this.constantUtil = constantUtil;
  }
}
