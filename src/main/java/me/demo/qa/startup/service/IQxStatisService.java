package me.demo.qa.startup.service;

import me.demo.qa.startup.entity.实况天气统计表;

import com.lt.util.page.Pager;

/**
 * Service-气象统计服务
 * 
 * @author geosmart
 */
public interface IQxStatisService {

  /**
   * 新增天气统计数据
   */
  public void saveStatis();

  /**
   * 查询天气统计数据
   * 
   * @see 如果MySQL数据已持久化，直接读取；否则需先调用OpenAPI读取数据写入MySQL
   * @return
   */
  Pager<实况天气统计表> queryStatis();
}
