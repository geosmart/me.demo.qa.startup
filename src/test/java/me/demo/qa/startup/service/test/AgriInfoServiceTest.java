package me.demo.qa.startup.service.test;

import me.demo.qa.startup.service.IAgriInfoService;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class AgriInfoServiceTest {

  @Autowired
  IAgriInfoService agriInfoService;

  @Before
  public void startup() {
    System.out.println("---startup");
  }

  @Test
  public void getAgriInfo() {
    System.out.println(agriInfoService.getArigInfoTitle(3));
    System.out.println(agriInfoService.getArigInfoDescribtion(3));
    System.out.println(agriInfoService.getArigInfoImgUrl(3));
  }

  @After
  public void teardown() {
    System.out.println("---teardown");
  }
}
