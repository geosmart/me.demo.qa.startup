package me.demo.qa.startup.service.impl;

import me.demo.qa.startup.service.IAgriInfoService;
import me.demo.qa.startup.util.ConstantUtil;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class AgriInfoServiceImpl implements IAgriInfoService {

  ConstantUtil constantUtil;

  @Override
  public String getArigInfo(int index) {
    if (index > 5)
      return "";
    Elements argriInfoDom = null;
    try {
      Document argriInfoPage = Jsoup.connect(constantUtil.getDomain_agriculture() + getArigInfoUrl(index)).get();
      argriInfoDom = argriInfoPage.select(".content");
      argriInfoDom.select(".content_title_k,.content_xg_news,.content_print").remove();
      argriInfoDom.select("div.clear").remove();

    } catch (Exception e) {
      e.printStackTrace();
    }
    return argriInfoDom.toString();
  }

  @Override
  public String getArigInfoTitle(int index) {
    if (index > 5)
      return "";
    String argriInfoTitle = null;
    try {
      Document doc = Jsoup.connect(constantUtil.getAgri_chuzhou()).get();
      // 根据下标获取旬报
      String liString = "li:eq(" + index + ")";
      Elements rootDom = doc.select(".list_content").select(liString).select(".list_content_title").select("a");
      argriInfoTitle = rootDom.attr("title");
    } catch (Exception e) {
      e.printStackTrace();
    }
    return argriInfoTitle;
  }

  @Override
  public String getArigInfoDescribtion(int index) {
    if (index > 5)
      return "";
    String argriInfoDescribtion = null;
    try {
      Document doc = Jsoup.connect(constantUtil.getAgri_chuzhou()).get();
      // 根据下标获取旬报
      String liString = "li:eq(" + index + ")";
      Elements rootDom = doc.select(".list_content").select(liString).select(".list_content_txt1").select("a");

      argriInfoDescribtion = rootDom.text();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return argriInfoDescribtion;
  }
  
  @Override
  public String getArigInfoImgUrl(int index){
    if (index > 5)
      return "";
    String imgUrl = null;
    try {
      Document argriInfoPage = Jsoup.connect(constantUtil.getDomain_agriculture() + getArigInfoUrl(index)).get();
      Elements argriInfoDom = argriInfoPage.select(".content").select("img");
      imgUrl = argriInfoDom.attr("src");
    } catch (Exception e) {
      e.printStackTrace();
    }
    return imgUrl;
  }
  
  /**
   * 根据下标获取旬报的地址
   * 
   * @param index 从0到6指定旬报下标
   * @return 返回旬报的url
   */
  public String getArigInfoUrl(int index){
    if (index > 5)
      return "";
    String argriNewsUrl = null;
    try {
      Document doc = Jsoup.connect(constantUtil.getAgri_chuzhou()).get();
      // 根据下标获取旬报
      String liString = "li:eq(" + index + ")";
      Elements rootDom = doc.select(".list_content").select(liString).select(".list_content_title").select("a");

      argriNewsUrl = rootDom.attr("href");

    } catch (Exception e) {
      e.printStackTrace();
    }
    return argriNewsUrl;
  }

  public ConstantUtil getConstantUtil() {
    return constantUtil;
  }

  public void setConstantUtil(ConstantUtil constantUtil) {
    this.constantUtil = constantUtil;
  }
}
