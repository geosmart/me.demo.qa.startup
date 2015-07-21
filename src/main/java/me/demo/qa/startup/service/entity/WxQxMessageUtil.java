package me.demo.qa.startup.service.entity;

import me.chanjar.weixin.mp.bean.WxMpCustomMessage;
import me.chanjar.weixin.mp.bean.WxMpXmlMessage;
import me.demo.qa.startup.service.IAgriInfoService;
import me.demo.qa.startup.service.IGeoAnalysisService;
import me.demo.qa.startup.service.IUserInfoService;

import org.springframework.test.context.ContextConfiguration;

import com.lt.util.SpringContextUtil;

@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class WxQxMessageUtil {

  IAgriInfoService agriInfoService = SpringContextUtil.getBean("agriInfoService");

  IGeoAnalysisService geoAnalysisService = SpringContextUtil.getBean("geoAnalysisService");

  IUserInfoService userInfoService = SpringContextUtil.getBean("userInfoService");

  private WxMpXmlMessage message;


  public WxQxMessageUtil(WxMpXmlMessage message) {
    this.message = message;
  }

  /**
   * 获取农业气象图文消息内容
   * 
   * @return
   */
  public WxMpCustomMessage getNYQX_New() {

    WxMpCustomMessage customMessage = null;

    WxMpCustomMessage.WxArticle article1 = new WxMpCustomMessage.WxArticle();
    article1.setUrl("http://dreamcatcher.tunnel.mobi/qa.startup/rest/v100/nyqx/statis?index=0");
    article1.setPicUrl(agriInfoService.getArigInfoImgUrl(0));
    article1.setDescription(agriInfoService.getArigInfoDescribtion(0));
    article1.setTitle(agriInfoService.getArigInfoTitle(0));

    WxMpCustomMessage.WxArticle article2 = new WxMpCustomMessage.WxArticle();
    article2.setUrl("http://dreamcatcher.tunnel.mobi/qa.startup/rest/v100/nyqx/statis?index=1");
    article2.setPicUrl(agriInfoService.getArigInfoImgUrl(1));
    article2.setDescription(agriInfoService.getArigInfoDescribtion(1));
    article2.setTitle(agriInfoService.getArigInfoTitle(1));

    WxMpCustomMessage.WxArticle article3 = new WxMpCustomMessage.WxArticle();
    article3.setUrl("http://dreamcatcher.tunnel.mobi/qa.startup/rest/v100/nyqx/statis?index=2");
    article3.setPicUrl(agriInfoService.getArigInfoImgUrl(2));
    article3.setDescription(agriInfoService.getArigInfoDescribtion(2));
    article3.setTitle(agriInfoService.getArigInfoTitle(2));

    WxMpCustomMessage.WxArticle article4 = new WxMpCustomMessage.WxArticle();
    article4.setUrl("http://dreamcatcher.tunnel.mobi/qa.startup/rest/v100/nyqx/statis?index=3");
    article4.setPicUrl(agriInfoService.getArigInfoImgUrl(3));
    article4.setDescription(agriInfoService.getArigInfoDescribtion(3));
    article4.setTitle(agriInfoService.getArigInfoTitle(3));

    WxMpCustomMessage.WxArticle article5 = new WxMpCustomMessage.WxArticle();
    article5.setUrl("http://dreamcatcher.tunnel.mobi/qa.startup/rest/v100/nyqx/statis?index=4");
    article5.setPicUrl(agriInfoService.getArigInfoImgUrl(4));
    article5.setDescription(agriInfoService.getArigInfoDescribtion(4));
    article5.setTitle(agriInfoService.getArigInfoTitle(4));

    WxMpCustomMessage.WxArticle article6 = new WxMpCustomMessage.WxArticle();
    article6.setUrl("http://dreamcatcher.tunnel.mobi/qa.startup/rest/v100/nyqx/statis?index=5");
    article6.setPicUrl(agriInfoService.getArigInfoImgUrl(5));
    article6.setDescription(agriInfoService.getArigInfoDescribtion(5));
    article6.setTitle(agriInfoService.getArigInfoTitle(5));

    customMessage =
        WxMpCustomMessage.NEWS().toUser(message.getFromUserName()).addArticle(article1).addArticle(article2).addArticle(article3)
            .addArticle(article4).addArticle(article5).addArticle(article6).build();

    return customMessage;
  }

  public WxMpCustomMessage getText_Menu() {
    return WxMpCustomMessage.TEXT().toUser(message.getFromUserName()).content("请回复以下数字： \n1  获取此公众号介绍\n2  查询天气\n").build();
  }

  public WxMpCustomMessage getReponseOf1() {
    return WxMpCustomMessage.TEXT().toUser(message.getFromUserName()).content("本公众号是旅图公司菜鸟吴凯鹏的微信测试号，提供简单的气象服务").build();
  }

  public WxMpCustomMessage getReponseOf2() {
    return WxMpCustomMessage.TEXT().toUser(message.getFromUserName()).content("今天天气阴").build();
  }

  public WxMpCustomMessage getLocationReponse() {
    IGeoAnalysisService geoAnalysisService = SpringContextUtil.getBean("geoAnalysisService");
    geoAnalysisService.setCoordinate(message.getLocationX(), message.getLocationY());
    return WxMpCustomMessage.TEXT().toUser(message.getFromUserName())
        .content(
            "您的位置:" + message.getLabel() + "\n纬度:" + message.getLocationX() + "\n经度:" + message.getLocationY() + "\n微信号：" + message.getFromUserName())
        .build();
  }
  
  public WxMpCustomMessage getWDQX_New() {
    WxMpCustomMessage customMessage = null;
    if (userInfoService.isUserInfoValid(message.getFromUserName())) {
      WxMpCustomMessage.WxArticle article = new WxMpCustomMessage.WxArticle();
      article.setUrl("http://dreamcatcher.tunnel.mobi/qa.startup/rest/v100/nyqx/statis?index=0");
      article.setPicUrl(agriInfoService.getArigInfoImgUrl(0));
      article.setDescription(agriInfoService.getArigInfoDescribtion(0));
      article.setTitle(agriInfoService.getArigInfoTitle(0));

      customMessage = WxMpCustomMessage.NEWS().toUser(message.getFromUserName()).addArticle(article).build();
    } else {
      customMessage = WxMpCustomMessage.TEXT().toUser(message.getFromUserName()).content("对不起，您的位置信息为空或已过期，请点击右下角的加号，点击发送“位置”再进行查询").build();
    }
    return customMessage;
  }

}
