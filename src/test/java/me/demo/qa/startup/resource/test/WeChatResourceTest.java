package me.demo.qa.startup.resource.test;

import java.util.UUID;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 微信REST服务-Test
 * 
 * @author geosmart
 */
public class WeChatResourceTest {

  private static final String domain = "http://localhost:8080/qa.startup/rest/v100";

  String token = UUID.randomUUID().toString();

  @Before
  public void startup() {
    System.out.println("---startup");
  }


  @Test
  public void validate() {
    Client client = ClientBuilder.newClient();
    String restUrl = domain + "/wechat/validate?";
    String signare="DC23735DC63E708C9A38FF20EAF7CC4553D6B05E";
    restUrl += "signature="+signare+"&&timestamp=2015-05-29&&nonce=100&&echostr=myechostr";
    System.out.println(restUrl);
    WebTarget target = client.target(restUrl);
 
    String callResult = target.request(MediaType.TEXT_PLAIN).get(String.class);

    System.out.println("Test case name: get, Result: " + callResult);
  }


  @After
  public void teardown() {
    System.out.println("---teardown");
  }
}
