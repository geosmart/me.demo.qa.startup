package me.demo.qa.startup.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import me.demo.qa.startup.resource.entity.PostData;
import me.demo.qa.startup.resource.entity.PostParamWrapper;
import me.demo.qa.startup.resource.entity.ResponseMessage;
import me.demo.qa.startup.resource.entity.ResultWrapper;
import me.demo.qa.startup.service.IAppService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lt.util.SpringContextUtil;

/***
 * Resource-测试
 * 
 * @author geosmart
 */
@Path("/rest")
public class AppResource {
  private static Logger log = LoggerFactory.getLogger(AppResource.class);

  IAppService appService = SpringContextUtil.getBean("appService");

  /**
   * get测试：hello World
   * 
   * @param userName 用户名
   * @param token 请求标识
   * @return
   */
  @Path("/v100/obj/get")
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response get(@QueryParam("userName") String userName, @QueryParam("token") String token) {
    ResultWrapper resultWrapper = new ResultWrapper(token);
    try {
      String result = appService.sayHelloWord(userName);
      log.debug(result);
      resultWrapper.setResult(result);
      ResponseMessage message = new ResponseMessage(Response.Status.OK);
      resultWrapper.setMessage(message);
    } catch (Exception e) {
      e.printStackTrace();
      ResponseMessage message = new ResponseMessage(Response.Status.INTERNAL_SERVER_ERROR);
      resultWrapper.setMessage(message);
    }
    return Response.ok().entity(resultWrapper).build();
  }

  /**
   * post测试：返回postData请求对象
   * 
   * @return
   */
  @Path("/v100/obj/post")
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  public Response post(PostParamWrapper paramWrapper) {
    String token = paramWrapper.getToken();
    ResultWrapper resultWrapper = new ResultWrapper(token);
    PostData postData = paramWrapper.getData();
    try {
      resultWrapper.setResult(postData);
      ResponseMessage message = new ResponseMessage(Response.Status.OK);
      resultWrapper.setMessage(message);
    } catch (Exception e) {
      e.printStackTrace();
      ResponseMessage message = new ResponseMessage(Response.Status.INTERNAL_SERVER_ERROR);
      resultWrapper.setMessage(message);
    }
    return Response.ok().entity(resultWrapper).build();
  }
  
}
