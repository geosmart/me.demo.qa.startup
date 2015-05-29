package me.demo.qa.startup.resource.test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * JerseyClent调用rest服务Test
 * 
 * @sample http://www.tutorialspoint.com/restful/restful_quick_guide.htm
 * @author geosmart
 */
public class JerseyClentTest { 
  private static final String domain = "http://localhost:8080/qa.startup";

  @Before
  public void startup() {
    System.out.println("---JerseyClentTest startup");
  }

  @Test
  public void test() throws Exception {
    Client client = ClientBuilder.newClient();
    WebTarget target = client.target(domain + "/rest/v100/obj/get?userName=geosmart&&token=test");

    String callResult = target.request(MediaType.APPLICATION_JSON).get(String.class);

    System.out.println("Test case name: get, Result: " + callResult);
  }

  @After
  public void teardown() {
    System.out.println("---JerseyClentTest teardown");
  }
}
