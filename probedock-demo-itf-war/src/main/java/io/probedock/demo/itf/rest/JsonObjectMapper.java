package io.probedock.demo.itf.rest;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * Configuration of Jackson serialization and deserialization.
 *
 * @author Laurent Prevost <laurent.prevost@probedock.io>
 */
@Provider
@Produces(MediaType.APPLICATION_JSON)
public class JsonObjectMapper implements ContextResolver<ObjectMapper> {

	private ObjectMapper jacksonObjectMapper;

	public JsonObjectMapper() {
		jacksonObjectMapper = new ObjectMapper();
		jacksonObjectMapper.setSerializationInclusion(JsonSerialize.Inclusion.NON_NULL);
		jacksonObjectMapper.configure(SerializationConfig.Feature.WRAP_ROOT_VALUE, false);
	}

	@Override
	public ObjectMapper getContext(Class<?> arg0) {
		return jacksonObjectMapper;
	}
}
