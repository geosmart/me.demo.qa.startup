package me.demo.qa.startup.resource.test;

import java.io.IOException;

import me.demo.qa.startup.resource.entity.TravelInfo;
import me.demo.qa.startup.service.IAgriInfoService;
import me.demo.qa.startup.service.ISatelliteService;
import me.demo.qa.startup.service.ITravelInfoService;
import me.demo.qa.startup.service.impl.AgriInfoServiceImpl;
import me.demo.qa.startup.service.impl.SatelliteServiceImpl;
import me.demo.qa.startup.service.impl.TravelInfoServiceImpl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
/**
 * 网页抽取Jsoup测试
 *  
 * @author geosmart
 */
public class HttpExtractTest {

  final String domain = "http://www.ahnyqx.cn/";

  String rootUrl = "show.asp?cid=d5da3535-36bd-4d28-9551-fb841423e359";

  final String travelDomain = "http://ah.weather.com.cn";

  String travelRootUrl = "/ahly/index.shtml";


  @Before
  public void startup() {
    System.out.println("---JerseyClentTest startup");
  }

  @Test
  public void getTravelInfoTest() {
    ITravelInfoService travelInfoService = new TravelInfoServiceImpl();
    TravelInfo travelInfo = travelInfoService.getTravelInfo();
    System.out.println(travelInfo.getDescription());
  }

  @Test
  public void htmlParserTest() throws IOException {
    IAgriInfoService agriIndoService = new AgriInfoServiceImpl();
    String argriInfo = agriIndoService.getArigInfo(0);
    System.out.println(argriInfo);
  }

  @Test
  public void getSatellitePhotoUrl() throws IOException {
    ISatelliteService satelliteService = new SatelliteServiceImpl();
    System.out.println(satelliteService.getSatellitePhotoUrl());
  }

  @After
  public void teardown() {
    System.out.println("---JerseyClentTest teardown");
  }
}
