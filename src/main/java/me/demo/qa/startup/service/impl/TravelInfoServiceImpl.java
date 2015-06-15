package me.demo.qa.startup.service.impl;

import me.demo.qa.startup.resource.entity.TravelInfo;
import me.demo.qa.startup.service.ITravelInfoService;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class TravelInfoServiceImpl implements ITravelInfoService {

  final String travelDomain = "http://ah.weather.com.cn";

  String travelRootUrl = "/ahly/index.shtml";

  public TravelInfo getTravelInfo() {
    TravelInfo travelInfo = null;
    try {
      Document doc = Jsoup.connect(travelDomain + travelRootUrl).get();
      Elements rootDom = doc.select(".weatherMain").select(".travelBox").select("dl:eq(10)");
      String photoUrl = travelDomain + rootDom.select("img").attr("src");
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
}
