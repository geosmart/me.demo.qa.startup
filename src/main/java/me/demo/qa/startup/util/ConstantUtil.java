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

  // 安徽农网-根域名
  private String domain_agriculture;

  // 滁州农业旬报
  private String agri_chuzhou;

  // 百度地理编码-根域名
  private String baidu_geocoderDomain;

  // 百度地理编码
  private String baiduGeocoding;

  // 百度坐标转换
  private String baiduGeoConvUrl;

  // 卫星云图域名
  private String satelliteDomain;

  // 旅游气象网根域名
  private String travelDomain;

  // 旅游气象网域名
  private String travelUrl;



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

  public String getDomain_agriculture() {
    return domain_agriculture;
  }

  public void setDomain_agriculture(String domain_agriculture) {
    this.domain_agriculture = domain_agriculture;
  }

  public String getAgri_chuzhou() {
    return domain_agriculture + agri_chuzhou;
  }

  public void setAgri_chuzhou(String agri_chuzhou) {
    this.agri_chuzhou = agri_chuzhou;
  }

  public String getBaidu_geocoderDomain() {
    return baidu_geocoderDomain;
  }

  public void setBaidu_geocoderDomain(String baidu_geocoderDomain) {
    this.baidu_geocoderDomain = baidu_geocoderDomain;
  }

  public String getBaiduGeocoding() {
    return baidu_geocoderDomain + baiduGeocoding;
  }

  public void setBaiduGeocoding(String baiduGeocoding) {
    this.baiduGeocoding = baiduGeocoding;
  }

  public String getBaiduGeoConvUrl() {
    return baiduGeoConvUrl;
  }

  public void setBaiduGeoConvUrl(String baiduGeoConvUrl) {
    this.baiduGeoConvUrl = baiduGeoConvUrl;
  }

  public String getSatelliteDomain() {
    return satelliteDomain;
  }

  public void setSatelliteDomain(String satelliteDomain) {
    this.satelliteDomain = satelliteDomain;
  }

  public String getTravelUrl() {
    return travelDomain + travelUrl;
  }

  public void setTravelUrl(String travelUrl) {
    this.travelUrl = travelUrl;
  }

  public String getTravelDomain() {
    return travelDomain;
  }

  public void setTravelDomain(String travelDomain) {
    this.travelDomain = travelDomain;
  }

}
