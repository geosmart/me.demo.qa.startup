package me.demo.qa.startup.resource.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * post协议查询对象
 * 
 * @author geosmart
 */
@XmlRootElement
public class PostData
{
	/**
	 * 控制参数
	 */
	private Map<String, Object> param;
	/**
	 * 过滤参数，如spatial空间过滤条件
	 */
	private Map<String, Object> filter;
	/**
	 * 请求对象
	 */
	private List<Object> items;
	
	public PostData()
	{
		super();
	}
	
	public PostData(Map<String, Object> param, Map<String, Object> filter, List<Object> items)
	{
		super();
		this.param = param;
		this.filter = filter;
		this.items = items;
	}
	
	public Map<String, Object> getParam()
	{
		if (param == null)
		{
			param = new HashMap<String, Object>();
		}
		return param;
	}
	
	public void setParam(Map<String, Object> param)
	{
		this.param = param;
	}
	
	public Map<String, Object> getFilter()
	{
		if (filter == null)
		{
			filter = new HashMap<String, Object>();
		}
		return filter;
	}
	
	public void setFilter(Map<String, Object> filter)
	{
		this.filter = filter;
	}
	
	public List<Object> getItems()
	{
		if (items == null)
		{
			items = new ArrayList<Object>();
		}
		return items;
	}
	
	public void setItems(List<Object> items)
	{
		this.items = items;
	}
}
