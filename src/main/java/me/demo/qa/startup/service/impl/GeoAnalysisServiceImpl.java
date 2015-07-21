package me.demo.qa.startup.service.impl;

import java.io.StringReader;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import me.demo.qa.startup.dao.ICityCodeDao;
import me.demo.qa.startup.entity.城市代码表;
import me.demo.qa.startup.entity.xsd.geocoding.GeocoderSearchResponse;
import me.demo.qa.startup.service.IGeoAnalysisService;
import me.demo.qa.startup.service.entity.GeoConvertResult;
import me.demo.qa.startup.util.ConstantUtil;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.lt.util.ConsoleUtil;
import com.lt.util.page.Pager;

public class GeoAnalysisServiceImpl implements IGeoAnalysisService {

  private ICityCodeDao cityCodeDao;

  private ConstantUtil constantUtil;


  private static Logger log = LoggerFactory.getLogger(GeoAnalysisServiceImpl.class);

  // 纬度
  private double latitude = 0;

  // 经度
  private double longitude = 0;

  // 逆地理编码数据
  private GeocoderSearchResponse geoResponse = null;

  public GeoAnalysisServiceImpl() {

  }


  @Override
  public Pager<城市代码表> getCityCode() {
    Pager<城市代码表> resultPager1 = null;
    Pager<城市代码表> resultPager2 = null;
    resultPager1 = queryCityCode(getDistrictFromResponse());
    resultPager2 = queryCityCode(getCityFromResponse());
    // 尽量将尺度拉小到区县一级，如果区县一级没有对应的天气代码，则使用市级的天气代码
    if (resultPager1.getDatas().isEmpty()) {
      return resultPager2;
    } else {
      return resultPager1;
    }
  }

  @Override
  public Pager<城市代码表> queryCityCode(String city) {
    Pager<城市代码表> result = null;
    try {
      String hql = "from 城市代码表 where cityname='地区'";
      hql = hql.replace("地区", city);
      result = cityCodeDao.find(hql);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return result;
  }

  @Override
  public void setCoordinate(double latitude, double longitude) {
    convToBaiduPoint(latitude, longitude);
    setGeocoder();
  }


  /**
   * 将微信经纬点转换为百度经纬点
   * 
   * @param latitude 纬度
   * @param longitude 经度
   */
  public void convToBaiduPoint(double latitude, double longitude) {
    try {
      Client client = ClientBuilder.newClient();
      String targetUrl =
          constantUtil.getBaiduGeoConvUrl().replace("longitude", String.valueOf(longitude)).replace("latitude", String.valueOf(latitude))
              .replaceAll("amp;", "&");
      ConsoleUtil.ConsoleObject(targetUrl);
      WebTarget target = client.target(targetUrl);

      String dataString = target.request(MediaType.APPLICATION_JSON).get(String.class);
      log.debug(dataString);

      if (StringUtils.isNotEmpty(dataString)) {
        Gson gson = new Gson();
        GeoConvertResult result = gson.fromJson(dataString, GeoConvertResult.class);
        this.latitude = result.getResult().get(0).getY();
        this.longitude = result.getResult().get(0).getX();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return;
  }

  /**
   * 根据百度API接口获取经纬度的地理编码信息，如所在城市，地区等 地理编码信息存在于geoResponse中
   */
  public void setGeocoder() {
    try {
      Client client = ClientBuilder.newClient();
      String targetUrl =
          constantUtil.getBaiduGeocoding().replace("longitude", String.valueOf(this.longitude)).replace("latitude", String.valueOf(this.latitude))
              .replaceAll("amp;", "&");
      ConsoleUtil.ConsoleObject(targetUrl);
      WebTarget target = client.target(targetUrl);

      String dataString = target.request(MediaType.APPLICATION_XML).get(String.class);
      log.debug(dataString);

      if (StringUtils.isNotBlank(dataString)) {
        JAXBContext ctx = JAXBContext.newInstance(GeocoderSearchResponse.class);
        Unmarshaller um = ctx.createUnmarshaller();
        this.geoResponse = (GeocoderSearchResponse) um.unmarshal(new StringReader(dataString));
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return ;
  }

  /**
   * 从地理编码结果中获取城市名
   * 
   * @return 返回城市名 如“滁州”
   */
  public String getCityFromResponse() {

    if (geoResponse == null) {
      ConsoleUtil.ConsoleObject("地理编码为空，请先调用setCoordnate方法");
      return null;
    }

    String cityNameString = geoResponse.getResult().getAddressComponent().getCity();
    return cityNameString.substring(0, cityNameString.length() - 1);
  }

  /**
   * 从地理编码结果中获取地区名
   * 
   * @return 返回地区名，如“琅琊”
   */
  public String getDistrictFromResponse() {

    if (geoResponse == null) {
      ConsoleUtil.ConsoleObject("地理编码为空，请先调用setCoordnate方法");
      return null;
    }

    String cityNameString = geoResponse.getResult().getAddressComponent().getDistrict();
    return cityNameString.substring(0, cityNameString.length() - 1);
  }


  public ICityCodeDao getCityCodeDao() {
    return cityCodeDao;
  }

  public void setCityCodeDao(ICityCodeDao cityCodeDao) {
    this.cityCodeDao = cityCodeDao;
  }

  public ConstantUtil getConstantUtil() {
    return constantUtil;
  }

  public void setConstantUtil(ConstantUtil constantUtil) {
    this.constantUtil = constantUtil;
  }

}
