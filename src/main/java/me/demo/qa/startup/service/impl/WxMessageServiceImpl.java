package me.demo.qa.startup.service.impl;


import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpServiceImpl;
import me.chanjar.weixin.mp.bean.WxMpCustomMessage;
import me.chanjar.weixin.mp.bean.WxMpXmlMessage;
import me.demo.qa.startup.service.IAgriInfoService;
import me.demo.qa.startup.service.IWxMessageService;

public class WxMessageServiceImpl implements IWxMessageService {

  private WxMpServiceImpl wxMpService;



  @Override
  public String getEchoMessageString(WxMpXmlMessage message) {
    WxServiceThread thread = new WxServiceThread(this.wxMpService, message);
    thread.start();
    return null;
  }


  public WxMpServiceImpl getWxMpService() {
    return wxMpService;
  }


  public void setWxMpService(WxMpServiceImpl wxMpService) {
    this.wxMpService = wxMpService;
  }



}


/**
 * 微信图文消息线程类
 * 
 * @author DreamCatcher
 * 
 */
class WxServiceThread extends Thread {


  private WxMpServiceImpl wxMpService;

  private WxMpXmlMessage message;

  public WxServiceThread(WxMpServiceImpl wxMpService, WxMpXmlMessage message) {
    this.wxMpService = wxMpService;
    this.message = message;
  }

  @Override
  public void run() {
    WxMpCustomMessage customMessage = null;
    // 匹配规则
    if (message.getMsgType().equals(WxConsts.XML_MSG_EVENT)) {
      if (message.getEvent().equals(WxConsts.EVT_CLICK)) {
        if (message.getEventKey().equals("B31_NYQX")) {
          IAgriInfoService agriInfoService = new AgriInfoServiceImpl();

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
        }
      } else if (message.getEvent().equals(WxConsts.EVT_SUBSCRIBE)) {
        customMessage = WxMpCustomMessage.TEXT().toUser(message.getFromUserName()).content("请回复以下数字： \n1  获取此公众号介绍\n2  查询天气\n").build();
      }
    } else if (message.getMsgType().equals(WxConsts.XML_MSG_TEXT)) {
      if (message.getContent().equals("1")) {
        customMessage = WxMpCustomMessage.TEXT().toUser(message.getFromUserName()).content("本公众号是旅图公司菜鸟吴凯鹏的微信测试号，提供简单的气象服务").build();
      } else if (message.getContent().equals("2")) {
        customMessage = WxMpCustomMessage.TEXT().toUser(message.getFromUserName()).content("今天天气阴").build();
      } else {
        customMessage = WxMpCustomMessage.TEXT().toUser(message.getFromUserName()).content("请回复以下数字： \n1  获取此公众号介绍\n2  查询天气\n").build();
      }
    } else if (message.getMsgType().equals(WxConsts.XML_MSG_LOCATION)) {
      customMessage =
          WxMpCustomMessage.TEXT().toUser(message.getFromUserName())
              .content("您的位置:" + message.getLabel() + "\n纬度:" + message.getLocationX() + "\n经度:" + message.getLocationY() + "").build();
    }
    // 如果无匹配规则
    if (customMessage == null)
      return;
    // 主动发送消息
    try {
      wxMpService.customMessageSend(customMessage);
    } catch (WxErrorException e) {
      e.printStackTrace();
    }
  }

}
