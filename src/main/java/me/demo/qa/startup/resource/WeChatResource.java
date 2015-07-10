package me.demo.qa.startup.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import me.chanjar.weixin.mp.bean.WxMpXmlMessage;
import me.demo.qa.startup.service.IWxMessageService;
import me.demo.qa.startup.util.SignUtil;

import com.lt.util.ConsoleUtil;
import com.lt.util.SpringContextUtil;

/***
 * Resource-微信验证
 * 
 * @author geosmart
 */
@Path("/rest")
public class WeChatResource {
  IWxMessageService wxMessageService = SpringContextUtil.getBean("wxMessageService");

  /**
   * 微信公众服务-开发者身份验证
   * 
   * 
   * @param signature 微信加密签名
   * @param timestamp 时间戮
   * @param nonce 随机数
   * @param echostr 随机字符串
   * @return
   */
  @Path("/v100/wechat/validate")
  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public Response validate(@QueryParam("signature") String signature, @QueryParam("timestamp") String timestamp, @QueryParam("nonce") String nonce,
      @QueryParam("echostr") String echostr) {
    // 通过检验 signature 对请求进行校验，若校验成功则原样返回 echostr，表示接入成功，否则接入失败
    if (SignUtil.checkSignature(signature, timestamp, nonce)) {
      System.out.println(echostr);
      return Response.ok().entity(echostr).build();
    } else {
      return null;
    }
  }

  @Path("/v100/wechat/validate")
  @POST
  @Consumes(MediaType.TEXT_XML)
  @Produces(MediaType.TEXT_XML)
  public Response MessageProcess(String message) {
    if (message == null) {
      return Response.ok().entity("error").build();
    }
    WxMpXmlMessage wxMpXmlMessage = WxMpXmlMessage.fromXml(message);
    String echoMessageString = wxMessageService.getEchoMessageString(wxMpXmlMessage);
    // 如果是异步消息
    if (echoMessageString == null)
      echoMessageString = "";
    ConsoleUtil.ConsoleObject(echoMessageString);
    return Response.ok().entity(echoMessageString).build();
  }



}
