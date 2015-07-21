package me.demo.qa.startup.service.impl;

import me.demo.qa.startup.resource.entity.TravelInfo;
import me.demo.qa.startup.service.ITravelInfoService;
import me.demo.qa.startup.util.ConstantUtil;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class TravelInfoServiceImpl implements ITravelInfoService {

  private ConstantUtil constantUtil;

  @Override
  public TravelInfo getTravelInfo() {
    TravelInfo travelInfo = null;
    try {
      Document doc = Jsoup.connect(constantUtil.getTravelUrl()).get();
      Elements rootDom = doc.select(".weatherMain").select(".travelBox").select("dl:eq(10)");
      String photoUrl = constantUtil.getTravelDomain() + rootDom.select("img").attr("src");
      String date = rootDom.select("span:eq(0)").text();
      String weatherStatus = rootDom.select("span:eq(1)").text();
      String temperature = rootDom.select("span:eq(2)").text();
      String description = rootDom.select(".travelTxt").text();

      travelInfo = new TravelInfo(photoUrl, date, weatherStatus, temperature, description);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return travelInfo;
  }

  public ConstantUtil getConstantUtil() {
    return constantUtil;
  }

  public void setConstantUtil(ConstantUtil constantUtil) {
    this.constantUtil = constantUtil;
  }
}
