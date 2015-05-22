package me.demo.qa.startup.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import me.demo.qa.startup.service.IAppService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lt.util.SpringContextUtil;

/***
 * 公共查询-rest
 * 
 * @author geosmart
 */
@Path("/rest")
public class WeixinValidateResource {
  private static Logger log = LoggerFactory.getLogger(WeixinValidateResource.class);

  IAppService appService = SpringContextUtil.getBean("appService");


  /**
   * 微信公众服务validate
   * 
   * @return
   */
  @Path("/v100/weixin/validate")
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response validate(@QueryParam("signature") String userName, @QueryParam("timestamp") String timestamp, @QueryParam("nonce") String nonce,
      @QueryParam("echostr") String echostr) {
    return Response.ok().entity(echostr).build();
  }
}
