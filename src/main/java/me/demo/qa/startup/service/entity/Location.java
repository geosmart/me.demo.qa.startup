package me.demo.qa.startup.service.entity;

/**
 * 百度API坐标转换 - result类
 * 
 * @author DreamCatcher
 */
public class Location {

  private double x;

  private double y;

  public Location(double x, double y) {
    super();
    this.x = x;
    this.y = y;
  }

  public double getX() {
    return x;
  }

  public void setX(double x) {
    this.x = x;
  }

  public double getY() {
    return y;
  }

  public void setY(double y) {
    this.y = y;
  }


}
