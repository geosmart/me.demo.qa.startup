package me.demo.qa.startup.service.test;

import me.demo.qa.startup.entity.城市代码表;
import me.demo.qa.startup.service.IGeoAnalysisService;

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
 * 百度API服务测试
 * 
 * @author DreamCatcher
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class GeoAnalysisServiceTest {

  @Autowired
  IGeoAnalysisService geoAnalysisService;

  @Before
  public void startup() {
    System.out.println("---startup");
  }

  @Test
  public void cityCodeQuery() {
    Pager<城市代码表> result = geoAnalysisService.queryCityCode("滁州");
    ConsoleUtil.ConsoleObject(result);
  }

  @Test
  public void getCityCode() {
    geoAnalysisService.setCoordinate(32.416006, 118.426016);
    Pager<城市代码表> resultPager = geoAnalysisService.getCityCode();
    ConsoleUtil.ConsoleObject(resultPager);
  }

  @After
  public void teardown() {
    System.out.println("---teardown");
  }
}
