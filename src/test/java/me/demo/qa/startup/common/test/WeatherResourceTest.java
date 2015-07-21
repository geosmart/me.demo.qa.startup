package me.demo.qa.startup.common.test;

import java.util.UUID;

import javax.ws.rs.core.Response;

import me.demo.qa.startup.resource.WeatherResource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lt.util.ConsoleUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class WeatherResourceTest { 

  @Autowired
  WeatherResource weatherResource;

  String token = UUID.randomUUID().toString();

  @Before
  public void startup() {
    System.out.println("---startup");
  }

  @Test
  public void getWeatherTest() {
    Response result = weatherResource.getWeatherStatis(token, "101221101");
    ConsoleUtil.ConsoleObject(result.getEntity());
  }

  @Test
  public void getArgriInfo() {
    Response result = weatherResource.getTravelInfo(token);
    ConsoleUtil.ConsoleObject(result.getEntity());
  }

  @After
  public void teardown() {
    System.out.println("---teardown");
  }
}
