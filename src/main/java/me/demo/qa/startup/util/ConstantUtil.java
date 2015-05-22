package me.demo.qa.startup.util;


/**
 * 常数配置
 * 
 * @author geosmart
 */
public class ConstantUtil {

  // 天中国气网开放接口-根域名
  private String domain_weather;

  // 获取实时天气和城镇代码
  private String weather_predict;

  // 获取天气统计数据
  // 在线统计图效果：http://flash.weather.com.cn/dsk/
  private String weather_statis;

  public String getDomain_weather() {
    return domain_weather;
  }

  public void setDomain_weather(String domain_weather) {
    this.domain_weather = domain_weather;
  }

  public String getWeather_predict() {
    return weather_predict;
  }

  public void setWeather_predict(String weather_predict) {
    this.weather_predict = domain_weather + weather_predict;
  }

  public String getWeather_statis() {
    return weather_statis;
  }

  public void setWeather_statis(String weather_statis) {
    this.weather_statis = domain_weather + weather_statis;
  }



}
