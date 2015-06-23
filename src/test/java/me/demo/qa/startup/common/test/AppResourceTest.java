package me.demo.qa.startup.common.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.ws.rs.core.Response;

import me.demo.qa.startup.resource.AppResource;
import me.demo.qa.startup.resource.entity.PostData;
import me.demo.qa.startup.resource.entity.PostItem;
import me.demo.qa.startup.resource.entity.PostParamWrapper;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lt.util.ConsoleUtil;

/**
 * Jersey-Resource-Test
 * 
 * @author geosmart
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class AppResourceTest { 

  @Autowired
  AppResource appResource;

  String token = UUID.randomUUID().toString();

  @Before
  public void startup() {
    System.out.println("---startup");
  }
 
  @Test
  public void get() {
    Response result = appResource.get("geosmart", token);
    ConsoleUtil.ConsoleObject(result.getEntity());
  }

  @Test
  public void post() {
    Map<String, Object> paramMap = new HashMap<String, Object>();
    paramMap.put("param1", "param1");
    paramMap.put("param2", "param2");
    Map<String, Object> filterMap = new HashMap<String, Object>();
    filterMap.put("filter1", "filter1");
    filterMap.put("filter2", "filter2");

    List<Object> itemMapList = new ArrayList<Object>();
    Map<String, Object> itemMap = new HashMap<String, Object>();
    itemMap.put("prop1", "prop1");
    itemMap.put("prop2", "prop2");
    PostItem postItem = new PostItem(token, itemMap);
    itemMapList.add(postItem);

    PostData data = new PostData(paramMap, filterMap, itemMapList);
    PostParamWrapper paramWrapper = new PostParamWrapper(token, data);
    ConsoleUtil.ConsoleObject(paramWrapper);
    Response result = appResource.post(paramWrapper);
    ConsoleUtil.ConsoleObject(result.getEntity());
  }

  @After
  public void teardown() {
    System.out.println("---teardown");
  }
}
