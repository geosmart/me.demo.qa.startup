package me.demo.qa.startup.entity;

import java.io.Serializable;


/**
 * 实况天气表 entity. @author MyEclipse Persistence Tools
 */

public class 实况天气表 implements Serializable {

  private static final long serialVersionUID = 1L;
    // Fields    
     private String guid;
     private Float cityX;
     private Float cityY;
  private String cityname;
  private String centername;
     private String fontColor;
     private String pyName;
     private Float state1;
     private Float state2;
     private String stateDetailed;
     private String tem1;
     private String tem2;
     private String temNow;
     private String windState;
     private String windDir;
     private String windPower;
     private String humidity;
  private String time;
     private String url;


    // Constructors

    /** default constructor */
  public 实况天气表() {
    }

	/** minimal constructor */
  public 实况天气表(String guid) {
        this.guid = guid;
    }
    


   
    // Property accessors

    public String getGuid() {
        return this.guid;
    }
    
    public void setGuid(String guid) {
        this.guid = guid;
    }

    public Float getCityX() {
        return this.cityX;
    }
    
    public void setCityX(Float cityX) {
        this.cityX = cityX;
    }

    public Float getCityY() {
        return this.cityY;
    }
    
    public void setCityY(Float cityY) {
        this.cityY = cityY;
    }

  public String getCityname() {
    return this.cityname;
    }
    
  public void setCityname(String cityname) {
    this.cityname = cityname;
    }

  public String getCentername() {
    return this.centername;
    }
    
  public void setCentername(String centername) {
    this.centername = centername;
    }

    public String getFontColor() {
        return this.fontColor;
    }
    
    public void setFontColor(String fontColor) {
        this.fontColor = fontColor;
    }

    public String getPyName() {
        return this.pyName;
    }
    
    public void setPyName(String pyName) {
        this.pyName = pyName;
    }

    public Float getState1() {
        return this.state1;
    }
    
    public void setState1(Float state1) {
        this.state1 = state1;
    }

    public Float getState2() {
        return this.state2;
    }
    
    public void setState2(Float state2) {
        this.state2 = state2;
    }

    public String getStateDetailed() {
        return this.stateDetailed;
    }
    
    public void setStateDetailed(String stateDetailed) {
        this.stateDetailed = stateDetailed;
    }

    public String getTem1() {
        return this.tem1;
    }
    
    public void setTem1(String tem1) {
        this.tem1 = tem1;
    }

    public String getTem2() {
        return this.tem2;
    }
    
    public void setTem2(String tem2) {
        this.tem2 = tem2;
    }

    public String getTemNow() {
        return this.temNow;
    }
    
    public void setTemNow(String temNow) {
        this.temNow = temNow;
    }

    public String getWindState() {
        return this.windState;
    }
    
    public void setWindState(String windState) {
        this.windState = windState;
    }

    public String getWindDir() {
        return this.windDir;
    }
    
    public void setWindDir(String windDir) {
        this.windDir = windDir;
    }

    public String getWindPower() {
        return this.windPower;
    }
    
    public void setWindPower(String windPower) {
        this.windPower = windPower;
    }

    public String getHumidity() {
        return this.humidity;
    }
    
    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

  public String getTime() {
        return this.time;
    }
    
  public void setTime(String time) {
        this.time = time;
    }

    public String getUrl() {
        return this.url;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }
   








}