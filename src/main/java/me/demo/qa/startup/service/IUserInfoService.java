package me.demo.qa.startup.service;

import me.chanjar.weixin.mp.bean.WxMpXmlMessage;
import me.demo.qa.startup.entity.用户信息表;

import com.lt.util.page.Pager;

/**
 * Service-用户信息服务
 * 
 * @author DreamCatcher
 */
public interface IUserInfoService {
  /**
   * 将用户的信息持久化到Mysql中（写入前删除旧数据）
   * 
   * @param message
   */
  public void saveUserInfo(WxMpXmlMessage message);
  
  /**
   * 查询-根据用户名查询信息
   * 
   * @return
   */
  public Pager<用户信息表> queryUserInfo(String username);

  /**
   * 根据用户名删除旧数据
   * 
   * @param username
   */
  public void deleteOldUserInfo(String username);

  /**
   * 检查用户信息是否有效 主要检查是否之前有保存位置信息，其次是检查信息的时效性
   * 
   * @param userName 用户名
   * @return 如果有效则返回true
   */
  public boolean isUserInfoValid(String userName);
  
}
