package me.demo.qa.startup.test;

import java.text.ParseException;

import me.demo.qa.startup.entity.实况天气表;
import me.demo.qa.startup.service.ISkWeatherService;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lt.util.ConsoleUtil;
import com.lt.util.page.Pager;

/**
 * Service-气象统计服务Test
 * 
 * @author DreamCatcher
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class SkWeatherServiceTest {
  @Autowired
  ISkWeatherService skWeatherService;

  @Before
  public void startup() {
    System.out.println("---startup");
  }

  @Test
  public void saveWeatherTest() throws ParseException {
    skWeatherService.saveWeather();
  }

  @Test
  public void queryWeatherTest() {
    Pager<实况天气表> resultPager = skWeatherService.queryWeather();
    ConsoleUtil.ConsoleObject(resultPager);
  }

  @After
  public void teardown() {
    System.out.println("---teardown");
  }
}
