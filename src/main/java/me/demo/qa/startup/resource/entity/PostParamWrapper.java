package me.demo.qa.startup.resource.entity;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 查询参数封装对象
 * 
 * @author geosmart
 */
@XmlRootElement
public class PostParamWrapper implements Serializable
{
	private static final long serialVersionUID = 1L;
	/**
	 * 请求标识
	 */
	private String token;
	/**
	 * 请求数据
	 */
	private PostData data;

	public PostParamWrapper()
	{
		super();
	}

	public PostParamWrapper(String token, PostData data)
	{
		super();
		this.token = token;
		this.data = data;
	}

	public String getToken()
	{
		return token;
	}

	public void setToken(String token)
	{
		this.token = token;
	}

	public PostData getData()
	{
		return data;
	}

	public void setData(PostData data)
	{
		this.data = data;
	}
}
