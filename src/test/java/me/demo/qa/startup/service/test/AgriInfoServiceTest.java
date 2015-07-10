package me.demo.qa.startup.service.test;

import me.demo.qa.startup.service.IAgriInfoService;
import me.demo.qa.startup.service.impl.AgriInfoServiceImpl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AgriInfoServiceTest {

  @Before
  public void startup() {
    System.out.println("---startup");
  }

  @Test
  public void getAgriInfo() {
    IAgriInfoService agriInfoService = new AgriInfoServiceImpl();
    System.out.println(agriInfoService.getArigInfoTitle(3));
    System.out.println(agriInfoService.getArigInfoDescribtion(3));
    System.out.println(agriInfoService.getArigInfoImgUrl(3));
  }

  @After
  public void teardown() {
    System.out.println("---teardown");
  }
}
