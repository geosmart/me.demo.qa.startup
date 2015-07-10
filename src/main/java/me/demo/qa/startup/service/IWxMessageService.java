package me.demo.qa.startup.service;

import me.chanjar.weixin.mp.bean.WxMpXmlMessage;

/**
 * 微信消息服务
 * 
 * @author DreamCatcher
 * 
 */
public interface IWxMessageService {

  /**
   * 处理消息并返回回复消息的字符串
   * 
   * @param message
   * @return
   */
  public String getEchoMessageString(WxMpXmlMessage message);

}
