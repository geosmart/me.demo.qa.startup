package me.demo.qa.startup.service.impl;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import me.chanjar.weixin.mp.bean.WxMpXmlMessage;
import me.demo.qa.startup.dao.IUserInfoDao;
import me.demo.qa.startup.entity.城市代码表;
import me.demo.qa.startup.entity.用户信息表;
import me.demo.qa.startup.service.IGeoAnalysisService;
import me.demo.qa.startup.service.IUserInfoService;

import com.lt.util.page.Pager;

public class UserInfoServiceImpl implements IUserInfoService {

  private IUserInfoDao userInfoDao;

  private IGeoAnalysisService geoAnalysisService;

  @Override
  public void saveUserInfo(WxMpXmlMessage message) {
    try {
      deleteOldUserInfo(message.getFromUserName());
      geoAnalysisService.setCoordinate(message.getLocationX(), message.getLocationY());
      List<城市代码表> cityPager = geoAnalysisService.getCityCode().getDatas();
      Timestamp timestamp = new Timestamp(System.currentTimeMillis());
      用户信息表 bean =
          new 用户信息表(message.getFromUserName(), message.getLocationX(), message.getLocationY(), timestamp, cityPager.get(0).getCityname(), cityPager
              .get(0).getCitycode());
      userInfoDao.saveOrUpdate(bean);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public Pager<用户信息表> queryUserInfo(String username) {
    Pager<用户信息表> result = null;
    try {
      String hql = "from 用户信息表 where username='" + username + "'";
      result = userInfoDao.find(hql);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return result;
  }

  @Override
  public void deleteOldUserInfo(String username) {
    String hql = "delete from 用户信息表 where username='" + username + "'";
    userInfoDao.updateByHql(hql);
  }

  @Override
  public boolean isUserInfoValid(String userName) {
    boolean isValid = false;
    Pager<用户信息表> resultPager = null;
    try {
      String hql = "from 用户信息表 where username='" + userName + "'";
      resultPager = userInfoDao.find(hql);
      if (resultPager.getDatas().isEmpty()) {
        isValid = false;
      } else {
        用户信息表 userInfo = resultPager.getDatas().get(0);
        Timestamp timestamp = userInfo.getTimestamp();

        if (isTimeValid(timestamp)) {
          isValid = true;
        } else {
          isValid = false;
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return isValid;
  }

  /**
   * 检查时间是否过期
   * 
   * @param timestamp 用户数据表中的时间戳
   * @return
   */
  public boolean isTimeValid(Timestamp timestamp) {
    Calendar oldCal = Calendar.getInstance();
    oldCal.setTime(timestamp);
    Calendar currentCal = Calendar.getInstance();
    currentCal.add(Calendar.DAY_OF_MONTH, -7);
    if (oldCal.compareTo(currentCal) >= 0) {
      return true;
    } else {
      return false;
    }
  }

  public IUserInfoDao getUserInfoDao() {
    return userInfoDao;
  }

  public void setUserInfoDao(IUserInfoDao userInfoDao) {
    this.userInfoDao = userInfoDao;
  }

  public IGeoAnalysisService getGeoAnalysisService() {
    return geoAnalysisService;
  }

  public void setGeoAnalysisService(IGeoAnalysisService geoAnalysisService) {
    this.geoAnalysisService = geoAnalysisService;
  }

}
