package me.demo.qa.startup.resource.test;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 网页抽取Jsoup测试
 *  
 * @author geosmart
 */
public class HttpExtractTest {

  final String domain = "http://www.ahnyqx.cn/";

  String rootUrl = "show.asp?cid=d5da3535-36bd-4d28-9551-fb841423e359";

  @Before
  public void startup() {
    System.out.println("---JerseyClentTest startup");
  }

  @Test
  public void htmlParserTest() throws IOException {
    Document doc = Jsoup.connect(domain + rootUrl).get();
    // 最新农业气象旬报
    Elements rootDom = doc.select(".list_content").select("li").first().select(".list_content_title").select("a");

    String argriNewsUrl = rootDom.attr("href");

    Document argriInfoPage = Jsoup.connect(domain + argriNewsUrl).get();
    Elements argriInfoDom = argriInfoPage.select(".content");
    argriInfoDom.select(".content_title_k,.content_xg_news,.content_print").remove();
    argriInfoDom.select("div.clear").remove();
    // TODO 调用微信接口生成图文素材（农业气象标题List），返回
    System.out.println(argriInfoDom);
  }

  @After
  public void teardown() {
    System.out.println("---JerseyClentTest teardown");
  }
}
