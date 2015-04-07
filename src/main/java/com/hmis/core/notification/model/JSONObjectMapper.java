package com.hmis.core.notification.model;

import org.codehaus.jackson.map.AnnotationIntrospector;import org.codehaus.jackson.map.ObjectMapper;import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;import org.codehaus.jackson.map.introspect.JacksonAnnotationIntrospector;import org.codehaus.jackson.xc.JaxbAnnotationIntrospector;
/**
 * JSONObjectMapper enables Jaxb annotation when serializing and deserializing objects in json format
 */
public class JSONObjectMapper extends ObjectMapper {
	public JSONObjectMapper() {		// by default jackson write out null fields we do not want to do that		this.getSerializationConfig().setSerializationInclusion(Inclusion.NON_NULL);		AnnotationIntrospector primary = new JacksonAnnotationIntrospector();		AnnotationIntrospector secondary = new JaxbAnnotationIntrospector();		AnnotationIntrospector pair = new AnnotationIntrospector.Pair(primary, secondary);		this.getDeserializationConfig().setAnnotationIntrospector(pair);		this.getSerializationConfig().setAnnotationIntrospector(pair);	}
}
