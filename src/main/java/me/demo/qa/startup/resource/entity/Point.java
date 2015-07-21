package me.demo.qa.startup.resource.entity;

/**
 * 经纬点
 * 
 * @author DreamCatcher
 * 
 */
public class Point {
  // 纬度
  private double latitude;

  // 经度
  private double longitude;

  public double getLatitude() {
    return latitude;
  }

  public void setLatitude(double latitude) {
    this.latitude = latitude;
  }

  public double getLongitude() {
    return longitude;
  }

  public void setLongitude(double longitude) {
    this.longitude = longitude;
  }
}
