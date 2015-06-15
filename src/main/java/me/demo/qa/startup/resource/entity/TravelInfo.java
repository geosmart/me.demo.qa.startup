package me.demo.qa.startup.resource.entity;

/**
 * 旅游景点信息
 * 
 * @author DreamCatcher
 */
public class TravelInfo {
  public TravelInfo(String photoUrl, String date, String weatherStatus, String temperature, String description) {
    super();
    this.photoUrl = photoUrl;
    this.date = date;
    this.weatherStatus = weatherStatus;
    this.temperature = temperature;
    this.description = description;
  }

  /**
   * 景点图片Url
   */
  private String photoUrl;
  /**
   * 预报日期
   */
  private String date;
  /**
   * 天气状况
   */
  private String weatherStatus;
  /**
   * 气温
   */
  private String temperature;
  /**
   * 景点描述
   */
  private String description;

  public String getPhotoUrl() {
    return photoUrl;
  }

  public void setPhotoUrl(String photoUrl) {
    this.photoUrl = photoUrl;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public String getWeatherStatus() {
    return weatherStatus;
  }

  public void setWeatherStatus(String weatherStatus) {
    this.weatherStatus = weatherStatus;
  }

  public String getTemperature() {
    return temperature;
  }

  public void setTemperature(String temperature) {
    this.temperature = temperature;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

}
