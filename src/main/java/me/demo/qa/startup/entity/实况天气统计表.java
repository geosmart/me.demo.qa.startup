package me.demo.qa.startup.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Entity-实况天气统计表
 * 
 * @author MyEclipse Persistence Tools
 */

public class 实况天气统计表 implements Serializable {

  private static final long serialVersionUID = 1L;
  // Fields
  private String guid;
  private String id;
  private String city;
  private Timestamp ptime;
  private String h;
  private float wd;
  private float fx;
  private float fl;
  private float js;
  private float sd;


  // Constructors

  /** default constructor */
  public 实况天气统计表() {}


  public 实况天气统计表(String guid, String id, String city, Timestamp ptime) {
    super();
    this.guid = guid;
    this.id = id;
    this.city = city;
    this.ptime = ptime;
  }


  /** minimal constructor */
  public 实况天气统计表(String guid) {
    this.guid = guid;
  }

  // Property accessors

  public String getGuid() {
    return this.guid;
  }

  public void setGuid(String guid) {
    this.guid = guid;
  }

  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getCity() {
    return this.city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public Timestamp getPtime() {
    return this.ptime;
  }

  public void setPtime(Timestamp ptime) {
    this.ptime = ptime;
  }

  public String getH() {
    return this.h;
  }

  public void setH(String h) {
    this.h = h;
  }

  public float getWd() {
    return this.wd;
  }

  public void setWd(float wd) {
    this.wd = wd;
  }

  public float getFx() {
    return this.fx;
  }

  public void setFx(float fx) {
    this.fx = fx;
  }

  public float getFl() {
    return this.fl;
  }

  public void setFl(float fl) {
    this.fl = fl;
  }

  public float getJs() {
    return this.js;
  }

  public void setJs(float js) {
    this.js = js;
  }

  public float getSd() {
    return this.sd;
  }

  public void setSd(float sd) {
    this.sd = sd;
  }



}
