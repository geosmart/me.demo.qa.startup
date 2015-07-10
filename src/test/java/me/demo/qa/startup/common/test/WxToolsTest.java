package me.demo.qa.startup.common.test;

import me.chanjar.weixin.common.bean.WxMenu;
import me.chanjar.weixin.common.bean.WxMenu.WxMenuButton;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpServiceImpl;
import me.chanjar.weixin.mp.bean.WxMpCustomMessage;
import me.demo.qa.startup.service.IAgriInfoService;
import me.demo.qa.startup.service.impl.AgriInfoServiceImpl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * 测试微信工具类
 * 
 * @author DreamCathcer
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class WxToolsTest {
  @Autowired
  private WxMpServiceImpl wxMpServiceImpl;



  @Before
  public void startup() {
    System.out.println("---startup");
  }


  /**
   * 微信工具-给指定用户发送消息
   * 
   * @throws WxErrorException
   */
  @Test
  public void helloWorld() throws WxErrorException {
    String openidString = "oQyZEs1mxlgIp-tJbjbfZ2NI0wdw";
    IAgriInfoService agriInfoService = new AgriInfoServiceImpl();

    WxMpCustomMessage.WxArticle article1 = new WxMpCustomMessage.WxArticle();
    article1.setUrl("http://dreamcatcher.tunnel.mobi/qa.startup/rest/v100/nyqx/statis?index=0");
    article1.setPicUrl(agriInfoService.getArigInfoImgUrl(0));
    article1.setDescription(agriInfoService.getArigInfoDescribtion(0));
    article1.setTitle(agriInfoService.getArigInfoTitle(0));

    WxMpCustomMessage.WxArticle article2 = new WxMpCustomMessage.WxArticle();
    article2.setUrl("http://dreamcatcher.tunnel.mobi/qa.startup/rest/v200/nyqx/statis?index=1");
    article2.setPicUrl(agriInfoService.getArigInfoImgUrl(1));
    article2.setDescription(agriInfoService.getArigInfoDescribtion(1));
    article2.setTitle(agriInfoService.getArigInfoTitle(1));

    WxMpCustomMessage.WxArticle article3 = new WxMpCustomMessage.WxArticle();
    article3.setUrl("http://dreamcatcher.tunnel.mobi/qa.startup/rest/v300/nyqx/statis?index=2");
    article3.setPicUrl(agriInfoService.getArigInfoImgUrl(2));
    article3.setDescription(agriInfoService.getArigInfoDescribtion(2));
    article3.setTitle(agriInfoService.getArigInfoTitle(2));

    WxMpCustomMessage.WxArticle article4 = new WxMpCustomMessage.WxArticle();
    article4.setUrl("http://dreamcatcher.tunnel.mobi/qa.startup/rest/v400/nyqx/statis?index=3");
    article4.setPicUrl(agriInfoService.getArigInfoImgUrl(3));
    article4.setDescription(agriInfoService.getArigInfoDescribtion(3));
    article4.setTitle(agriInfoService.getArigInfoTitle(3));

    WxMpCustomMessage.WxArticle article5 = new WxMpCustomMessage.WxArticle();
    article5.setUrl("http://dreamcatcher.tunnel.mobi/qa.startup/rest/v500/nyqx/statis?index=4");
    article5.setPicUrl(agriInfoService.getArigInfoImgUrl(4));
    article5.setDescription(agriInfoService.getArigInfoDescribtion(4));
    article5.setTitle(agriInfoService.getArigInfoTitle(4));

    WxMpCustomMessage.WxArticle article6 = new WxMpCustomMessage.WxArticle();
    article6.setUrl("http://dreamcatcher.tunnel.mobi/qa.startup/rest/v600/nyqx/statis?index=5");
    article6.setPicUrl(agriInfoService.getArigInfoImgUrl(5));
    article6.setDescription(agriInfoService.getArigInfoDescribtion(5));
    article6.setTitle(agriInfoService.getArigInfoTitle(5));

    WxMpCustomMessage message =
        WxMpCustomMessage.NEWS().toUser(openidString).addArticle(article1).addArticle(article2).addArticle(article3).addArticle(article4)
            .addArticle(article5).addArticle(article6).build();
    wxMpServiceImpl.customMessageSend(message);
  }

  /**
   * 微信工具-菜单创建
   * 
   * @throws WxErrorException
   */
  @Test
  public void menu() throws WxErrorException {
    WxMenu menu = new WxMenu();
    // 设置一级菜单
    WxMenuButton button1 = new WxMenuButton();
    button1.setName("天气");
  
    WxMenuButton button2 = new WxMenuButton();
    button2.setName("实况");
  
    WxMenuButton button3 = new WxMenuButton();
    button3.setName("服务");
  
    menu.getButtons().add(button1);
    menu.getButtons().add(button2);
    menu.getButtons().add(button3);
  
    // 设置天气菜单的二级菜单
    WxMenuButton button11 = new WxMenuButton();
    button11.setType("click");
    button11.setName("短期预报");
    button11.setKey("B11_DQYB");
  
    WxMenuButton button12 = new WxMenuButton();
    button12.setType("click");
    button12.setName("五天预报");
    button12.setKey("B12_WTYB");
  
    WxMenuButton button13 = new WxMenuButton();
    button13.setType("click");
    button13.setName("语言预报");
    button13.setKey("B13_YYYB");
  
    WxMenuButton button14 = new WxMenuButton();
    button14.setType("click");
    button14.setName("生活指数");
    button14.setKey("B14_SHZS");
  
    WxMenuButton button15 = new WxMenuButton();
    button15.setType("click");
    button15.setName("空气质量");
    button15.setKey("B15_KQZL");
  
    button1.getSubButtons().add(button11);
    button1.getSubButtons().add(button12);
    button1.getSubButtons().add(button13);
    button1.getSubButtons().add(button14);
    button1.getSubButtons().add(button15);


    // 设置实况菜单的二级菜单
    WxMenuButton button21 = new WxMenuButton();
    button21.setType("view");
    button21.setName("温度曲线");
    button21.setUrl("http://dreamcatcher.tunnel.mobi/test/view/wd.html");

    WxMenuButton button22 = new WxMenuButton();
    button22.setType("view");
    button22.setName("湿度曲线");
    button22.setUrl("http://dreamcatcher.tunnel.mobi/test/view/sd.html");

    WxMenuButton button23 = new WxMenuButton();
    button23.setType("view");
    button23.setName("风力风向");
    button23.setUrl("http://dreamcatcher.tunnel.mobi/test/view/fl.html");

    WxMenuButton button24 = new WxMenuButton();
    button24.setType("view");
    button24.setName("降水图表");
    button24.setUrl("http://dreamcatcher.tunnel.mobi/test/view/js.html");

    WxMenuButton button25 = new WxMenuButton();
    button25.setType("click");
    button25.setName("卫星云图");
    button25.setKey("B25_WXYT");

    button2.getSubButtons().add(button21);
    button2.getSubButtons().add(button22);
    button2.getSubButtons().add(button23);
    button2.getSubButtons().add(button24);
    button2.getSubButtons().add(button25);

    // 设置服务菜单的二级菜单
    WxMenuButton button31 = new WxMenuButton();
    button31.setType("click");
    button31.setName("农业气象");
    button31.setKey("B31_NYQX");

    WxMenuButton button32 = new WxMenuButton();
    button32.setType("click");
    button32.setName("交通气象");
    button32.setKey("B32_JTQX");

    WxMenuButton button33 = new WxMenuButton();
    button33.setType("click");
    button33.setName("旅游气象");
    button33.setKey("B33_LYQX");

    WxMenuButton button34 = new WxMenuButton();
    button34.setType("click");
    button34.setName("气象科普");
    button34.setKey("B34_QXKP");

    button3.getSubButtons().add(button31);
    button3.getSubButtons().add(button32);
    button3.getSubButtons().add(button33);
    button3.getSubButtons().add(button34);

    wxMpServiceImpl.menuCreate(menu);
  }


  @After
  public void teardown() {
    System.out.println("---teardown");
  }
}
