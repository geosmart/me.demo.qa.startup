package me.demo.qa.startup.service.impl;


import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpServiceImpl;
import me.chanjar.weixin.mp.bean.WxMpCustomMessage;
import me.chanjar.weixin.mp.bean.WxMpXmlMessage;
import me.demo.qa.startup.service.IWxMessageService;
import me.demo.qa.startup.service.entity.WxQxMessageUtil;

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

  private WxQxMessageUtil wxQxMessageUtil;

  public WxServiceThread(WxMpServiceImpl wxMpService, WxMpXmlMessage message) {
    this.wxMpService = wxMpService;
    this.message = message;
    this.wxQxMessageUtil = new WxQxMessageUtil(message);
  }

  @Override
  public void run() {
    WxMpCustomMessage customMessage = null;
    // 匹配规则
    if (message.getMsgType().equals(WxConsts.XML_MSG_EVENT)) {
      if (message.getEvent().equals(WxConsts.EVT_CLICK)) {
        if (message.getEventKey().equals("B21_WDQX"))
          customMessage = wxQxMessageUtil.getWDQX_New();

        if (message.getEventKey().equals("B31_NYQX"))
          customMessage = wxQxMessageUtil.getNYQX_New();
      } else if (message.getEvent().equals(WxConsts.EVT_SUBSCRIBE)) {
        customMessage = wxQxMessageUtil.getText_Menu();
      }
    } else if (message.getMsgType().equals(WxConsts.XML_MSG_TEXT)) {
      if (message.getContent().equals("1")) {
        customMessage = wxQxMessageUtil.getReponseOf1();
      } else if (message.getContent().equals("2")) {
        customMessage = wxQxMessageUtil.getReponseOf2();
      } else {
        customMessage = wxQxMessageUtil.getText_Menu();
      }
    } else if (message.getMsgType().equals(WxConsts.XML_MSG_LOCATION)) {
      customMessage = wxQxMessageUtil.getLocationReponse();
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
