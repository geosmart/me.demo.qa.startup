package me.demo.qa.startup.entity;

import java.sql.Timestamp;


/**
 * 用户信息表 entity. @author MyEclipse Persistence Tools
 */

public class 用户信息表 implements java.io.Serializable {


    // Fields    

     private String username;
     private Double longitude;
     private Double latitude;
     private Timestamp timestamp;
     private String cityname;
     private String citycode;


    // Constructors

    /** default constructor */
  public 用户信息表() {
    }

	/** minimal constructor */
  public 用户信息表(String username) {
        this.username = username;
    }
    
    /** full constructor */
  public 用户信息表(String username, Double longitude, Double latitude, Timestamp timestamp, String cityname, String citycode) {
        this.username = username;
        this.longitude = longitude;
        this.latitude = latitude;
        this.timestamp = timestamp;
        this.cityname = cityname;
        this.citycode = citycode;
    }

   
    // Property accessors

    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }

    public Double getLongitude() {
        return this.longitude;
    }
    
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return this.latitude;
    }
    
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Timestamp getTimestamp() {
        return this.timestamp;
    }
    
    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getCityname() {
        return this.cityname;
    }
    
    public void setCityname(String cityname) {
        this.cityname = cityname;
    }

    public String getCitycode() {
        return this.citycode;
    }
    
    public void setCitycode(String citycode) {
        this.citycode = citycode;
    }


}