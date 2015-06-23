package me.demo.qa.startup.resource.entity;

import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 返回消息
 * 
 * @参考1：http://www.w3.org/Protocols/rfc2616/rfc2616-sec6.html
 * @参考2：http://open.weibo.com/wiki/Error_code
 * @author geosmart
 */
public class ResponseMessage {
  /**
   * rest请求
   */
  private String request;
  /**
   * 状态码
   */
  private int statusCode;
  /**
   * 原因短语
   */
  private String reasonPhrase;

  @JsonIgnore
  public static UriInfo CurrentUriInfo;

  public ResponseMessage() {
    super();
  }

  public ResponseMessage(String request, int statusCode, String reasonPhrase) {
    super();
    this.request = request;
    this.statusCode = statusCode;
    this.reasonPhrase = reasonPhrase;
  }

  public ResponseMessage(Status status) {
    if (CurrentUriInfo == null) {
      this.request = "http://<host>:<port>/{domain}/rest/{version}/{object}/{operation}";
    } else {
      this.request = CurrentUriInfo.getRequestUri().toASCIIString();
    }
    if (status == Status.OK) {
      this.statusCode = Status.OK.getStatusCode();
      this.reasonPhrase = Status.OK.getReasonPhrase();
    }
    if (status == Status.INTERNAL_SERVER_ERROR) {
      this.statusCode = Status.INTERNAL_SERVER_ERROR.getStatusCode();
      this.reasonPhrase = Status.INTERNAL_SERVER_ERROR.getReasonPhrase();
    }
  }

  public String getRequest() {
    return request;
  }

  public void setRequest(String request) {
    this.request = request;
  }

  public int getStatusCode() {
    return statusCode;
  }

  public void setStatusCode(int statusCode) {
    this.statusCode = statusCode;
  }

  public String getReasonPhrase() {
    return reasonPhrase;
  }

  public void setReasonPhrase(String reasonPhrase) {
    this.reasonPhrase = reasonPhrase;
  }

}
