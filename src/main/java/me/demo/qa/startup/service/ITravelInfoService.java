package me.demo.qa.startup.service;

import me.demo.qa.startup.resource.entity.TravelInfo;

/**
 * Service-旅游气象服务
 * 
 * @author DreamCatcher
 */
public interface ITravelInfoService {
  /**
   * 获取琅琊山气象信息
   */
  public TravelInfo getTravelInfo();
}
