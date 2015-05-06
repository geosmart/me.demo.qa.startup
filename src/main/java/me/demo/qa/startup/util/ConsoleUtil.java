package me.demo.qa.startup.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.codehaus.jackson.annotate.JsonAutoDetect.Visibility;
import org.codehaus.jackson.annotate.JsonMethod;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 打印对象工具
 * @author geosmart
 *
 */
public class ConsoleUtil
{
	
	private static Logger logger = LoggerFactory.getLogger("输出Json格式数据:");
	
	/**
	 * 将对象n打印成json字符串
	 * 
	 * @param object
	 */
	public static void ConsoleObject(Object object)
	{
		String formData = null;
		try
		{
			ObjectMapper objectMapper = getObjectMapperWithNull();
			formData = objectMapper.writeValueAsString(object);
			logger.debug(formData);
		} catch (Exception e)
		{
			logger.error(e.toString());
		}
	}
	
	/**
	 * 将对象n打印成json字符串
	 * 
	 * @param object
	 */
	public static void ConsoleObject(Object object, boolean isUserAnnotations)
	{
		String formData = null;
		try
		{
			ObjectMapper objectMapper = getObjectMapperWithNull();
			objectMapper.configure(SerializationConfig.Feature.USE_ANNOTATIONS, isUserAnnotations);
			formData = objectMapper.writeValueAsString(object);
			logger.debug(formData);
		} catch (Exception e)
		{
			logger.error(e.toString());
		}
	}
	
	/***
	 * 保留空值的ObjectMapper
	 * 
	 * @return ObjectMapper
	 */
	public static ObjectMapper getObjectMapperWithNull()
	{
		ObjectMapper objectMapper = new ObjectMapper().setVisibility(JsonMethod.FIELD, Visibility.ANY);
		objectMapper.setSerializationInclusion(Inclusion.ALWAYS);
		// 去除不存在的属性
		objectMapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		// 空字符串转换null对象
		objectMapper.configure(DeserializationConfig.Feature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);
		// 不去除值为null的值
		objectMapper.configure(SerializationConfig.Feature.WRITE_NULL_MAP_VALUES, true);
		// 默认时间戳改成自定义日期格式
		objectMapper.configure(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS, false);
		DateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		objectMapper.setDateFormat(dFormat);
		return objectMapper;
	}
}
