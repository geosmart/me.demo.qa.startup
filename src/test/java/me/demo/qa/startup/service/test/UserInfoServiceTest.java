package me.demo.qa.startup.service.test;

import me.chanjar.weixin.mp.bean.WxMpXmlMessage;
import me.demo.qa.startup.entity.用户信息表;
import me.demo.qa.startup.service.IUserInfoService;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lt.util.ConsoleUtil;
import com.lt.util.page.Pager;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class UserInfoServiceTest {

  @Autowired
  IUserInfoService userInfoService;

  @Before
  public void startup() {
    System.out.println("---startup");
  }

  @Test
  public void saveUserInfoTest() {
    WxMpXmlMessage message = new WxMpXmlMessage();
    message.setFromUserName("wrtx52g");
    message.setLocationX(32.269679);
    message.setLocationY(118.980544);

    userInfoService.saveUserInfo(message);
  }

  @Test
  public void queryUserInfoTest() {
    Pager<用户信息表> resultPager = userInfoService.queryUserInfo("wrtx52g");
    ConsoleUtil.ConsoleObject(resultPager);
  }

  @After
  public void teardown() {
    System.out.println("---teardown");
  }


}
