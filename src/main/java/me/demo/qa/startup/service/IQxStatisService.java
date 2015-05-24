package me.demo.qa.startup.service;

import me.demo.qa.startup.entity.实况天气统计表;
import me.demo.qa.startup.entity.xsd.weather.Sktq;

import com.lt.util.page.Pager;

/**
 * Service-气象统计服务
 * 
 * @author geosmart
 */
public interface IQxStatisService {

  /**
   * 获取实时天气统计数据并持久化（写入前删除历史天气统计数据）
   */
  public void saveStatis();

  /**
   * 查询-数据库天气统计数据
   * 
   * @see 如果MySQL数据已持久化，直接读取；否则需先调用OpenAPI读取数据写入MySQL
   * @return
   */
  Pager<实况天气统计表> queryStatis();

  /**
   * 获取-开放平台天气统计数据
   * 
   * @param dataStr
   */
  Sktq getStatisData();

  /**
   * 删除-历史天气统计数据
   * 
   * @param time
   */
  void deleteStatisOutOfDate(long time);

}
