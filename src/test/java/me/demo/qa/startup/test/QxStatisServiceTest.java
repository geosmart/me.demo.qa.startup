package me.demo.qa.startup.test;

import java.text.ParseException;

import me.demo.qa.startup.service.IQxStatisService;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * App Test
 * 
 * @author geosmart
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class QxStatisServiceTest {

  @Autowired
  IQxStatisService qxStatisService;

  @Before
  public void startup() {
    System.out.println("---startup");
  }

  @Test
  public void queryStatis() {
    qxStatisService.queryStatis();
  }

  @Test
  public void saveStatis() throws ParseException {
    qxStatisService.saveStatis();
  }

  @After
  public void teardown() {
    System.out.println("---teardown");
  }
}
