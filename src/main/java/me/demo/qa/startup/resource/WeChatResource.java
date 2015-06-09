package me.demo.qa.startup.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import me.demo.qa.startup.service.IAppService;
import me.demo.qa.startup.util.SignUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lt.util.SpringContextUtil;

/***
 * Resource-微信验证
 * 
 * @author geosmart
 */
@Path("/rest")
public class WeChatResource {
  private static Logger log = LoggerFactory.getLogger(WeChatResource.class);

  IAppService appService = SpringContextUtil.getBean("appService");


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
}
