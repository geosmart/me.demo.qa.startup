package me.demo.qa.startup.resource.entity;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 通用批量操作-item对象
 * 
 * @author geosmart
 */
@XmlRootElement
public class PostItem implements Serializable
{
	private static final long serialVersionUID = 1L;
	/**
	 * 请求标识
	 */
	private String id;
	/**
	 * （数组/单个）
	 */
	private Object item;
	
	public PostItem()
	{
		super();
	}
	
	public PostItem(String id, Object item)
	{
		super();
		this.id = id;
		this.item = item;
	}
	
	public PostItem(String id)
	{
		super();
		this.id = id;
	}
	
	public String getId()
	{
		return id;
	}
	
	public void setId(String id)
	{
		this.id = id;
	}

	public Object getItem()
	{
		return item;
	}

	public void setItem(Object item)
	{
		this.item = item;
	}

	
}
