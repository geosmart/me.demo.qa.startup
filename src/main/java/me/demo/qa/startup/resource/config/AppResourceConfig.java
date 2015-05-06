package me.demo.qa.startup.resource.config;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.RequestContextFilter;
import org.springframework.web.filter.ServletContextRequestLoggingFilter;
import org.springframework.web.multipart.support.MultipartFilter;

/**
 * Jersey初始化
 * 
 * @author geosmart
 */
public class AppResourceConfig extends ResourceConfig
{
	
	private static Logger log = LoggerFactory.getLogger(AppResourceConfig.class);
	
	/**
	 * 注册JAX-RS组件
	 */
	public AppResourceConfig()
	{
		log.debug("---------注册业务Resource package--------");
		packages("me.demo.qa.startup.resource"); 
		
		log.debug("---------注册JAX-RS组件--------"); 
		register(AuthorizationRequestFilter.class);
		register(PoweredByResponseFilter.class);
		register(RequestContextFilter.class);
		register(ServletContextRequestLoggingFilter.class);
		register(MultipartFilter.class);
		register(JacksonFeature.class);
	}
}
