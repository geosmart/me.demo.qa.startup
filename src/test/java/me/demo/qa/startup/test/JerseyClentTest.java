package me.demo.qa.startup.test;

import java.io.StringReader;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import me.demo.qa.startup.entity.xsd.weather.Sktq;

import org.apache.commons.lang3.StringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.lt.util.ConsoleUtil;

/**
 * JerseyClent调用rest服务Test
 * 
 * @sample http://www.tutorialspoint.com/restful/restful_quick_guide.htm
 * @author geosmart
 */
public class JerseyClentTest {
  // 天中国气网开放接口-根域名
  private static final String domain_weather = "http://flash.weather.com.cn";
  // 获取实时天气和城镇代码
  private static final String url_weather_predict = domain_weather + "/wmaps/xml/chuzhou.xml";
  // 获取天气统计数据
  // 在线统计图效果：http://flash.weather.com.cn/dsk/
  private static final String url_weather_statis = domain_weather + "/dsk/101221101.xml";
  private static final String FAIL = "fail";

  @Before
  public void startup() {
    System.out.println("---JerseyClentTest startup");
  }

  @Test
  public void get_weather_predict() {
    Client client = ClientBuilder.newClient();
    WebTarget target = client.target(url_weather_predict);

    String callResult = target.request(MediaType.APPLICATION_XML).get(String.class);
    if (StringUtils.isEmpty(callResult)) {
      callResult = FAIL;
    }
    // jaxb转换后获取并存储城市代码，获取城镇天气
    System.out.println("Test case name: get, Result: " + callResult);
  }

  /**
   * 前端实现效果参考：http://www.weather.com.cn/weather1d/101221101.shtml
   */
  @Test
  public void get_weather_statis() {
    Client client = ClientBuilder.newClient();
    WebTarget target = client.target(url_weather_statis);

    String callResult = target.request(MediaType.APPLICATION_XML).get(String.class);
    if (StringUtils.isEmpty(callResult)) {
      callResult = FAIL;
    }
    System.out.println("Test case name: get, Result: " + callResult);
    Sktq sktq = deserial_statis(callResult);
    ConsoleUtil.ConsoleObject(sktq);
    // TODO mysql CRUD:实体映射成数据表，存储实时天气(小时)
  }

  /**
   * 将xml字符串通过jaxb转换为java bean
   * 
   * @param dataStr
   */
  public Sktq deserial_statis(String dataStr) {
    Sktq sktq = null;
    try {
      if (StringUtils.isNotEmpty(dataStr)) {
        // 读取xml，转换成jaxb实体，转换成json实体
        JAXBContext ctx = JAXBContext.newInstance(Sktq.class);
        Unmarshaller um = ctx.createUnmarshaller();
        sktq = (Sktq) um.unmarshal(new StringReader(dataStr));
      }
    } catch (JAXBException e) {
      e.printStackTrace();
    }
    return sktq;
  }

  @Test
  public void post() {
    String restURL = "http://flash.weather.com.cn/wmaps/xml/chuzhou.xml";
    Client client = ClientBuilder.newClient();
    WebTarget target = client.target(restURL);

    Response response = target.request(MediaType.APPLICATION_JSON).post(Entity.text("payload"));
    ConsoleUtil.ConsoleObject(response.getEntity());
  }

  @After
  public void teardown() {
    System.out.println("---JerseyClentTest teardown");
  }
}
