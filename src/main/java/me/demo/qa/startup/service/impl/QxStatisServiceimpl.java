package me.demo.qa.startup.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

import me.demo.qa.startup.dao.IQxStatisDao;
import me.demo.qa.startup.entity.实况天气统计表;
import me.demo.qa.startup.service.IQxStatisService;

import org.apache.commons.lang3.time.DateUtils;

import com.lt.util.DateUtil;
import com.lt.util.page.Pager;

/**
 * TODO JavaDoc
 * 
 * @author geosmart
 */
public class QxStatisServiceimpl implements IQxStatisService {

  IQxStatisDao qxStatisDao;

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
      实况天气统计表 bean = new 实况天气统计表(UUID.randomUUID().toString());
      bean.setFl(10);
      Date date = DateUtils.parseDate("2015-05-18 12:12:12", DateUtil.DATETIME_PATTERN);
      Timestamp timestamp = new Timestamp(date.getTime());
      bean.setPtime(timestamp);
      qxStatisDao.save(bean);
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
}
