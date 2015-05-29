package me.demo.qa.startup.service;


import me.demo.qa.startup.entity.实况天气表;
import me.demo.qa.startup.entity.xsd.skweather.Chuzhou;

import com.lt.util.page.Pager;

/**
 * Service-滁州市县区级实况天气服务
 * 
 * @author DreamCatcher
 */

public interface ISkWeatherService {
  /**
   * 获取县区级天气数据并持久化（写入前删除历史天气统计数据）
   */
  public void saveWeather();

  /**
   * 查询-数据库天气数据
   * 
   * @see 如果MySQL数据已持久化，直接读取；否则需先调用OpenAPI读取数据写入MySQL
   * @return
   */
  Pager<实况天气表> queryWeather();

  /**
   * 获取-开放平台天气数据
   * 
   * @param dataStr
   */
  Chuzhou getWeatherData();

  /**
   * 删除-历史天气数据
   * 
   * @param time
   */
  void deleteWeatherOutOfDate();
}
