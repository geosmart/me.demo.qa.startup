package me.demo.qa.startup.service.entity;

import java.util.List;

/**
 * 百度API-坐标转换结果
 * 
 * @author DreamCatcher
 */
public class GeoConvertResult {

  private int status;

  private List<Location> result;

  public GeoConvertResult(int status, List<Location> result) {
    super();
    this.status = status;
    this.result = result;
  }

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  public List<Location> getResult() {
    return result;
  }

  public void setResult(List<Location> result) {
    this.result = result;
  }
}
