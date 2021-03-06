package me.demo.qa.startup.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import me.demo.qa.startup.entity.实况天气统计表;
import me.demo.qa.startup.resource.entity.ResponseMessage;
import me.demo.qa.startup.resource.entity.ResultWrapper;
import me.demo.qa.startup.service.IAgriInfoService;
import me.demo.qa.startup.service.IQxStatisService;
import me.demo.qa.startup.service.ISatelliteService;
import me.demo.qa.startup.service.ITravelInfoService;

import com.lt.util.SpringContextUtil;
import com.lt.util.page.Pager;

/***
 * Resource-天气查询
 * 
 * @author DreamCathcer
 */

@Path("/rest")
public class WeatherResource {

  IQxStatisService qxStatisService = SpringContextUtil.getBean("qxStatisService");

  ISatelliteService satelliteService = SpringContextUtil.getBean("satelliteService");

  IAgriInfoService agriInfoService = SpringContextUtil.getBean("agriInfoService");

  ITravelInfoService travelInfoService = SpringContextUtil.getBean("travelInfoService");


  @Path("/v100/tq/statis")
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response getWeatherStatis(@QueryParam("token") String token, @QueryParam("citycode") String citycode) {
    ResultWrapper resultWrapper = new ResultWrapper(token);
    try {
      // 访问即更新数据
      qxStatisService.saveStatis(citycode);

      Pager<实况天气统计表> result = qxStatisService.queryStatis(citycode);
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

  @Path("/v100/qxyt/statis")
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response getSatalliteUrl(@QueryParam("token") String token) {

    // 调取卫星服务接口获取最新云图的url
    ResultWrapper resultWrapper = new ResultWrapper(token, satelliteService.getSatellitePhotoUrl());
    try {
      ResponseMessage message = new ResponseMessage(Response.Status.OK);
      resultWrapper.setMessage(message);
    } catch (Exception e) {
      e.printStackTrace();
      ResponseMessage message = new ResponseMessage(Response.Status.INTERNAL_SERVER_ERROR);
      resultWrapper.setMessage(message);
    }

    return Response.ok().entity(resultWrapper).build();
  }

  @Path("/v100/nyqx/statis")
  @GET
  @Produces(MediaType.TEXT_HTML)
  public Response getArgriInfo(@QueryParam("index") int index) {
    // 根据下标获取农业旬报
    String argriInfo = agriInfoService.getArigInfo(index);

    return Response.ok().entity(argriInfo).build();
  }

  @Path("/v100/lyqx/statis")
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response getTravelInfo(@QueryParam("token") String token) {
    ResultWrapper resultWrapper = new ResultWrapper(token);
    try {
      resultWrapper.setResult(travelInfoService.getTravelInfo());
      ResponseMessage message = new ResponseMessage(Response.Status.OK);
      resultWrapper.setMessage(message);
    } catch (Exception e) {
      e.printStackTrace();
      ResponseMessage message = new ResponseMessage(Response.Status.INTERNAL_SERVER_ERROR);
      resultWrapper.setMessage(message);
    }
    return Response.ok().entity(resultWrapper).build();

  }

  public IQxStatisService getQxStatisService() {
    return qxStatisService;
  }

  public void setQxStatisService(IQxStatisService qxStatisService) {
    this.qxStatisService = qxStatisService;
  }
}
