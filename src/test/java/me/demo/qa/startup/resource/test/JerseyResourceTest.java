package me.demo.qa.startup.resource.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

import me.demo.qa.startup.resource.config.AppResourceConfig;
import me.demo.qa.startup.resource.entity.PostData;
import me.demo.qa.startup.resource.entity.PostItem;
import me.demo.qa.startup.resource.entity.PostParamWrapper;
import me.demo.qa.startup.resource.entity.ResultWrapper;

import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lt.util.ConsoleUtil;

/**
 * jersey resouce调用示例
 * 
 * @author geosmart
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class JerseyResourceTest extends JerseyTest {

  final static String token = UUID.randomUUID().toString();

  /**
   * 加载resource资源
   */
  @Override
  protected Application configure() {
    return new AppResourceConfig(); 
  }

  @Test
  public void get() {
    String url = "/rest/v100/obj/get";
    ResultWrapper result = target(url).queryParam("userName", "geosmart").queryParam("token", token).request().get(ResultWrapper.class);
    ConsoleUtil.ConsoleObject(result);
  }

  @Test
  public void post() {
    String url = "/rest/v100/obj/post";
    Entity<PostParamWrapper> paramEntity = Entity.entity(getTestPostParam(), MediaType.APPLICATION_JSON);
    ResultWrapper result = target(url).request(MediaType.APPLICATION_JSON).post(paramEntity, ResultWrapper.class);
    ConsoleUtil.ConsoleObject(result);
  }

  /**
   * 获取测试参数
   * 
   * @return
   */
  private PostParamWrapper getTestPostParam() {
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
    return paramWrapper;
  }
}
