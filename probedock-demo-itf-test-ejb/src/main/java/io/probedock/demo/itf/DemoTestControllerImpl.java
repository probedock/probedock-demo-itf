package io.probedock.demo.itf;

import io.probedock.demo.itf.service.CalculatorServiceTest;
import io.probedock.jee.itf.AbstractTestController;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

/**
 * @author Laurent Prevost <laurent.prevost@probedock.io>
 */
@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class DemoTestControllerImpl extends AbstractTestController implements DemoTestController {
	@EJB
	public CalculatorServiceTest calculatorServiceTest;
}
