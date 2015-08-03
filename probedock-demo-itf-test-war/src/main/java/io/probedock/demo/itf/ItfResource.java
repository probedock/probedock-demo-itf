package io.probedock.demo.itf;

import io.probedock.jee.itf.TestController;
import io.probedock.rt.client.itf.ProbeDockRTAbstractTestResource;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Path;

/**
 * Implementation of the resource to start the integration tests
 * 
 * @author Laurent Prevost <laurent.prevost@probedock.io>
 */
@Stateless
@Path("start")
public class ItfResource extends ProbeDockRTAbstractTestResource {
	@EJB
	private DemoTestController demoTestController;
	
	@Override
	public TestController getController() {
		return demoTestController;
	}
}
