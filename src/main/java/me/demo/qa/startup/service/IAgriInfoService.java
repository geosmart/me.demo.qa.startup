package me.demo.qa.startup.service;

/**
 * Service-农业旬报服务
 * 
 * @author DreamCatcher
 */
public interface IAgriInfoService {
  /**
   * 获取农业旬报地址
   * 
   * @param index
   */
  public String getArigInfo(int index);

  /**
   * 获取农业旬报的标题
   * 
   * @param index 从0到6指定旬报下标
   * @return
   */
  public String getArigInfoTitle(int index);

  /**
   * 获取农业旬报的描述
   * 
   * @param index 从0到6指定旬报下标
   * @return
   */
  public String getArigInfoDescribtion(int index);
  
  /**
   * 获取农业旬报图片
   * 
   * @param index
   * @return
   */
  public String getArigInfoImgUrl(int index);
}
