package io.probedock.demo.itf.rest;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Path;
import javax.ws.rs.core.Application;

import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.reflections.Reflections;
import org.reflections.scanners.TypeAnnotationsScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.FilterBuilder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Rest application for the API
 * 
 * @author Laurent Prevost <laurent.prevost@probedock.io>
 */
@ApplicationPath("api")
public class ApiRestApplication extends Application {
	private static final Logger LOG = LoggerFactory.getLogger(ApiRestApplication.class);
	private Set<Class<?>> classes;

	public ApiRestApplication() {
		classes = new HashSet<>();

		classes.add(JacksonFeature.class);
		classes.add(JsonObjectMapper.class);

		// Scan every packages to get @Path annotated classes
		for (String pckg : new String[] { getClass().getPackage().getName() }) {
			classes.addAll(new Reflections(
				ClasspathHelper.forPackage(pckg), new TypeAnnotationsScanner(), new FilterBuilder().includePackage(pckg)).
				getTypesAnnotatedWith(Path.class));
		}

		if (LOG.isTraceEnabled()) {
			for (Class cl : classes) {
				LOG.trace("Class registered: {}", cl.getCanonicalName());
			}
		}
	}

	@Override
	public Set<Class<?>> getClasses() {
		return classes;
	}

	@Override
	public Set<Object> getSingletons() {
		final Set<Object> singletons = new HashSet<>(2);
		singletons.add(new JacksonJsonProvider());
		return singletons;
	}
}
