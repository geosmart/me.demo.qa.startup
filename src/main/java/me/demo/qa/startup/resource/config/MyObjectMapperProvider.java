package me.demo.qa.startup.resource.config;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationIntrospector;


/**
 * Jersey自定义jackson序列化ObjectMapper
 * 
 * @author geosmart
 */
@Provider
public class MyObjectMapperProvider implements ContextResolver<ObjectMapper> {
  final ObjectMapper defaultObjectMapper;
  final ObjectMapper combinedObjectMapper;

  public MyObjectMapperProvider() {
    defaultObjectMapper = createDefaultMapper();
    combinedObjectMapper = createCombinedObjectMapper();
  }

  @Override
  public ObjectMapper getContext(Class<?> type) {
    // if (type == CombinedAnnotationBean.class) {
    // return combinedObjectMapper;
    // } else {
    return defaultObjectMapper;
    // }
  }

  private static ObjectMapper createCombinedObjectMapper() {
    return new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, true).configure(DeserializationFeature.UNWRAP_ROOT_VALUE, true)
        .setAnnotationIntrospector(createJaxbJacksonAnnotationIntrospector());
  }

  private static ObjectMapper createDefaultMapper() {
    final ObjectMapper mapper = new ObjectMapper();
    mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
    mapper.enable(SerializationFeature.INDENT_OUTPUT);

    return mapper;
  }

  private static AnnotationIntrospector createJaxbJacksonAnnotationIntrospector() {
    final AnnotationIntrospector jaxbIntrospector = new JaxbAnnotationIntrospector(TypeFactory.defaultInstance());
    final AnnotationIntrospector jacksonIntrospector = new JacksonAnnotationIntrospector();

    return AnnotationIntrospector.pair(jacksonIntrospector, jaxbIntrospector);
  }
}
