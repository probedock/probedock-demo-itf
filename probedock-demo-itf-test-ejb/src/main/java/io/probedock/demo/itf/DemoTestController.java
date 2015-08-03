package io.probedock.demo.itf;

import io.probedock.jee.itf.TestController;

import javax.ejb.Local;

/**
 * Interface to create the Session Bean to start the integration tests
 * 
 * @author Laurent Prevost <laurent.prevost@probedock.io>
 */
@Local
public interface DemoTestController extends TestController {
}
