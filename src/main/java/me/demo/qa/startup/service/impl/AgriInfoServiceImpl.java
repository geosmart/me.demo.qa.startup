package me.demo.qa.startup.service.impl;

import me.demo.qa.startup.service.IAgriInfoService;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class AgriInfoServiceImpl implements IAgriInfoService {
  // FIXME 参考ConstantUtil静态变量配置外部化
  final String domain = "http://www.ahnyqx.cn/";
 
  String rootUrl = "show.asp?cid=d5da3535-36bd-4d28-9551-fb841423e359";

  @Override
  public String getArigInfoUrl(int index) {
    if (index > 5)
      return "";
    Elements argriInfoDom = null;
    try {
      Document doc = Jsoup.connect(domain + rootUrl).get();
      // 根据下标获取旬报
      String liString = "li:eq(" + index + ")";
      Elements rootDom = doc.select(".list_content").select(liString).select(".list_content_title").select("a");

      String argriNewsUrl = rootDom.attr("href");

      Document argriInfoPage = Jsoup.connect(domain + argriNewsUrl).get();
      argriInfoDom = argriInfoPage.select(".content");
      argriInfoDom.select(".content_title_k,.content_xg_news,.content_print").remove();
      argriInfoDom.select("div.clear").remove();

    } catch (Exception e) {
      // TODO: handle exception
    }
    return argriInfoDom.toString();
  }
}
