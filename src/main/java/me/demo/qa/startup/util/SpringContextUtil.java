package me.demo.qa.startup.util;

import java.util.Locale;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * SpringApplicationContext-Util
 * 
 * @author wanggang
 * @createDate 2013.2.25
 * @modifyDate 2013.02.25
 */
public final class SpringContextUtil implements ApplicationContextAware
{
	public static ApplicationContext context;
	
	@SuppressWarnings("static-access")
	@Override
	public void setApplicationContext(ApplicationContext contex) throws BeansException
	{
		this.context = contex;
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T getBean(String beanName)
	{
		T bean = null;
		try
		{
			bean = (T) context.getBean(beanName);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return bean;
	}
	
	public static String getMessage(String key)
	{
		return context.getMessage(key, null, Locale.getDefault());
	}
	
}
