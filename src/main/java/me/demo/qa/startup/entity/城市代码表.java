package me.demo.qa.startup.entity;



/**
 * 城市代码表 entity. @author MyEclipse Persistence Tools
 */

public class 城市代码表 implements java.io.Serializable {


    // Fields    

     private String citycode;
     private String cityname;


    // Constructors

    /** default constructor */
  public 城市代码表() {
    }

    
    /** full constructor */
  public 城市代码表(String citycode, String cityname) {
        this.citycode = citycode;
        this.cityname = cityname;
    }

   
    // Property accessors

    public String getCitycode() {
        return this.citycode;
    }
    
    public void setCitycode(String citycode) {
        this.citycode = citycode;
    }

    public String getCityname() {
        return this.cityname;
    }
    
    public void setCityname(String cityname) {
        this.cityname = cityname;
    }
   








}