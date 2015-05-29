package me.demo.qa.startup.resource.test;

import java.io.File;
import java.io.FileInputStream;
import java.util.UUID;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.DefaultHandler;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.webapp.WebAppContext;
import org.eclipse.jetty.xml.XmlConfiguration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * Resource-Test
 * 
 * @author geosmart
 */
public class JettyTest {

  private static final String domain = "http://localhost:8080/qa.startup";

  String token = UUID.randomUUID().toString();

  @Before
  public void startup() {
    System.out.println("---startup");
  }

  private Server server;

  @Test
  public void startServer() throws Exception {
    server = new Server(8080);
    server.setStopAtShutdown(true);
    WebAppContext webAppContext = new WebAppContext();
    webAppContext.setContextPath("/qa.startup");
    webAppContext.setResourceBase("src/main/webapp");
    webAppContext.setClassLoader(getClass().getClassLoader());
    server.insertHandler(webAppContext);
    server.start();
  }

  public void configServer() {
    Server server = new Server(8080);
    server.setHandler(new DefaultHandler());
    XmlConfiguration configuration = null;
    try {
      configuration = new XmlConfiguration(new FileInputStream("C:/development/Jetty/jetty-6.1.6rc0/etc/jetty.xml"));
    } catch (Exception e1) {
      e1.printStackTrace();
    } 
    try {
      configuration.configure(server);
      server.start();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void fileServer() throws Exception {
    Server server = new Server(8080);

    ResourceHandler resource_handler = new ResourceHandler();
    resource_handler.setDirectoriesListed(true);
    resource_handler.setWelcomeFiles(new String[] {"index.html"});
    resource_handler.setResourceBase(".");

    // Add the ResourceHandler to the server.
    HandlerList handlers = new HandlerList();
    handlers.setHandlers(new Handler[] {resource_handler, new DefaultHandler()});
    server.setHandler(handlers);
    server.start();
    server.join();
  }

  @Test
  public void warServer() throws Exception {
    Server server = new Server(8080);

    WebAppContext webapp = new WebAppContext();
    webapp.setContextPath("/");
    webapp.setWar("D:/JavaWorkSpace/git_workspace/me.demo.qa.startup/target/qa.startup.war");
    File file = new File("D:/JavaWorkSpace/git_workspace/me.demo.qa.startup/target/qa.startup.war");
    server.setHandler(webapp);

    server.start();
    server.join();
  }

  @Test
  public void test() throws Exception {
    Client client = ClientBuilder.newClient();
    WebTarget target = client.target(domain + "/rest/v100/obj/get?userName=geosmart&&token=test");

    String callResult = target.request(MediaType.APPLICATION_JSON).get(String.class);

    System.out.println("Test case name: get, Result: " + callResult);
  }

  @After
  public void shutdownServer() throws Exception {
    server.stop();
  }

  @Test
  public void deploy() {



    // Server server = new Server(8080);
    // WebAppContext webapp = new
    // WebAppContext("D:\\JavaWorkSpace\\git_workspace\\me.demo.qa.startup\\target\\qa.startup",
    // "/");
    // ResourceHandler resource_handler = new ResourceHandler();
    // resource_handler.setWelcomeFiles(new String[] {"index.html"});
    //
    // // 访问上下文路径
    // webapp.setContextPath("/");
    // HandlerList handlers = new HandlerList();
    // handlers.setHandlers(new Handler[] {resource_handler, webapp});
    // server.setHandler(handlers);
    // try {
    // server.start();
    // server.join();
    // } catch (Exception ex) {
    // ex.printStackTrace();
    // }
  }


  @After
  public void teardown() throws Exception {
    System.out.println("---teardown");
    server.stop();
  }
}
