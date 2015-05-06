package me.demo.qa.startup.resource.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 分页对象
 * 
 * @author geosmart
 * @param <T>
 */ 
public class Pager<T>
{
	/**
	 * 分页起始页，当前是第几页
	 */
	private int pageNumber;
	/**
	 * 分页大小，每页的记录数
	 */
	private int pageSize;
	/**
	 * 总记录数
	 */
	private long total;
	/**
	 * 总页数
	 */
	private int totalPage;
	
	/**
	 * 分页列表、分页数据集
	 */
	private List<T> datas;
	
	public Pager()
	{
		super();
	}
	
	// 复制分页参数
	@SuppressWarnings("rawtypes")
	public Pager(Pager sourcePage)
	{
		super();
		this.pageNumber = sourcePage.getPageNumber();
		this.pageSize = sourcePage.getPageSize();
		this.total = sourcePage.getTotal();
		this.totalPage = sourcePage.getTotalPage();
	}
	
	public Pager(int pageNumber, int pageSize)
	{
		super();
		this.pageNumber = pageNumber;
		this.pageSize = pageSize;
	}
	
	public Pager(int pageNumber, int pageSize, long total, int totalPage)
	{
		super();
		this.pageNumber = pageNumber;
		this.pageSize = pageSize;
		this.total = total;
		this.totalPage = totalPage;
	}
	
	public Pager(int pageNumber, int pageSize, long total, int totalPage, List<T> datas)
	{
		super();
		this.pageNumber = pageNumber;
		this.pageSize = pageSize;
		this.total = total;
		this.totalPage = totalPage;
		this.datas = datas;
	}
	
	public List<T> getDatas()
	{
		if (datas == null)
		{
			datas = new ArrayList<T>();
		}
		return datas;
	}
	
	public void setDatas(List<T> datas)
	{
		this.datas = datas;
	}
	
	public void addEntity(T data)
	{
		getDatas().add(data);
	}
	
	public void addCollection(Collection<? extends T> c)
	{
		getDatas().addAll(c);
	}
	
	public long getTotal()
	{
		return total;
	}
	
	public void setTotal(long total)
	{
		this.total = total;
	}
	
	// 计算totalPage
	public int getDataTotalPage(int pageSize)
	{
		int dataSize = datas.size();
		int _totalPage = 0;
		if (pageSize > 0)
		{
			if (dataSize == 0)
			{
				_totalPage = 0;
			} else
			{
				if (dataSize % pageSize > 0)
				{// 有余数+1页
					_totalPage = dataSize / pageSize + 1;
				} else
				{// 整页
					_totalPage = dataSize / pageSize;
				}
			}
		}
		return _totalPage;
	}
	
	// 获取当前totalPage
	public int getTotalPage()
	{
		setTotalPage();
		return totalPage;
	}
	
	public void setTotalPage()
	{
		if (pageSize > 0)
		{
			if (total == 0)
			{
				this.totalPage = 0;
			} else
			{
				if (total % pageSize > 0)
				{// 有余数+1页
					totalPage = (int) (total / pageSize + 1);
				} else
				{// 整页
					totalPage = (int) (total / pageSize);
				}
			}
		}
	}
	
	public void setTotalPage(int totalPage)
	{
		this.totalPage = totalPage;
	}
	
	public int getPageNumber()
	{
		return pageNumber;
	}
	
	public void setPageNumber(int pageNumber)
	{
		this.pageNumber = pageNumber;
	}
	
	public int getPageSize()
	{
		return pageSize;
	}
	
	public void setPageSize(int pageSize)
	{
		this.pageSize = pageSize;
	}
	
}
