package me.demo.qa.startup.resource.test;

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

  private static final String domain = "http://localhost:8080/qa.startup";

  @Autowired
  WeatherResource weatherResource;

  String token = UUID.randomUUID().toString();

  @Before
  public void startup() {
    System.out.println("---startup");
  }

  @Test
  public void getWeatherTest() {
    Response result = weatherResource.getWeatherStatis(token);
    ConsoleUtil.ConsoleObject(result.getEntity());
  }

  @After
  public void teardown() {
    System.out.println("---teardown");
  }
}
