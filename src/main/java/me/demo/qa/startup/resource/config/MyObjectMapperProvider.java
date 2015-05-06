package me.demo.qa.startup.resource.config;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import org.codehaus.jackson.map.AnnotationIntrospector;
import org.codehaus.jackson.map.AnnotationIntrospector.Pair;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.SerializationConfig.Feature;
import org.codehaus.jackson.map.introspect.JacksonAnnotationIntrospector;
import org.codehaus.jackson.xc.JaxbAnnotationIntrospector;

/**
 * TODO javadoc.
 * 
 * @author Jakub Podlesak (jakub.podlesak at oracle.com)
 */
@Provider
public class MyObjectMapperProvider implements ContextResolver<ObjectMapper>
{

	final ObjectMapper defaultObjectMapper;
	final ObjectMapper combinedObjectMapper;

	public MyObjectMapperProvider()
	{
		defaultObjectMapper = createDefaultMapper();
		combinedObjectMapper = createCombinedObjectMapper();
	}

	@Override
	public ObjectMapper getContext(Class<?> type)
	{
		// if (type == PageQueryBean.class)
		// {
		// return combinedObjectMapper;
		// } else
		// {
		return defaultObjectMapper;
		// }
	}

	private static ObjectMapper createCombinedObjectMapper()
	{
		Pair combinedIntrospector = createJaxbJacksonAnnotationIntrospector();
		ObjectMapper standard = new ObjectMapper();
		standard.configure(SerializationConfig.Feature.WRAP_ROOT_VALUE, true);
		standard.configure(DeserializationConfig.Feature.UNWRAP_ROOT_VALUE, true);
		standard.setDeserializationConfig(standard.getDeserializationConfig().withAnnotationIntrospector(combinedIntrospector));
		standard.setSerializationConfig(standard.getSerializationConfig().withAnnotationIntrospector(combinedIntrospector));

		return standard;
	}

	private static ObjectMapper createDefaultMapper()
	{

		ObjectMapper standard = new ObjectMapper();
		standard.configure(Feature.INDENT_OUTPUT, true);

		return standard;
	}

	private static Pair createJaxbJacksonAnnotationIntrospector()
	{

		AnnotationIntrospector jaxbIntrospector = new JaxbAnnotationIntrospector();
		AnnotationIntrospector jacksonIntrospector = new JacksonAnnotationIntrospector();

		return new AnnotationIntrospector.Pair(jacksonIntrospector, jaxbIntrospector);
	}
}
