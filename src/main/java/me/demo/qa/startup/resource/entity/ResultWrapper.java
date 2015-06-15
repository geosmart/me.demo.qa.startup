package me.demo.qa.startup.resource.entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 查询结果对象
 * 
 * @author geosmart
 */
@XmlRootElement
public class ResultWrapper implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * 请求标识
	 */
	private String token;
	/**
	 * 返回消息
	 */
	private ResponseMessage message;
	/**
	 * 返回数据
	 */
	private Object result;

	public ResultWrapper(String token) {
		super();
		this.token = token;
		this.result = null;
	}

  public ResultWrapper(String token, Object result) {
    super();
    this.token = token;
    this.result = result;
  }

	public ResultWrapper(String token, ResponseMessage message, Pager<?> result) {
		super();
		this.token = token;
		this.message = message;
		this.result = result;
	}

	public void setResult(List<Object> items) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("items", items);
		result = resultMap;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public ResponseMessage getMessage() {
		return message;
	}

	public void setMessage(ResponseMessage message) {
		this.message = message;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}
}
