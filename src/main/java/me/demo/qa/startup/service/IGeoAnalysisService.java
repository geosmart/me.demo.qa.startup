package me.demo.qa.startup.service;

import me.demo.qa.startup.entity.城市代码表;

import com.lt.util.page.Pager;

/**
 * 地理解析-服务接口
 * 
 * @author DreamCatcher
 * 
 */
public interface IGeoAnalysisService {
  /**
   * 解析位置所在的城市代码 必须先将获取到的位置点使用setCoordinate方法进行初始化后才能使用此方法
   * 
   * @return 城市代码
   */
  public Pager<城市代码表> getCityCode();

  /**
   * 根据城市名查询城市代码
   * 
   * @param city 城市名
   * @return 城市代码
   */
  public Pager<城市代码表> queryCityCode(String city);

  /**
   * 传入微信经纬点进行百度坐标转换和地理编码
   * 
   * @param latitude 纬度
   * @param longitude 经度
   */
  public void setCoordinate(double latitude, double longitude);

}
