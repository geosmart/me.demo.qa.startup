package me.demo.qa.startup.service;

import me.demo.qa.startup.entity.实况天气统计表;

import com.lt.util.page.Pager;

/**
 * 气象统计服务
 * 
 * @author geosmart
 */
public interface IQxStatisService {

  public void saveStatis();

  Pager<实况天气统计表> queryStatis();
}
