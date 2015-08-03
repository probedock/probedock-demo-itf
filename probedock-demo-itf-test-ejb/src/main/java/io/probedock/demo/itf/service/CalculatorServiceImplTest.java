package io.probedock.demo.itf.service;

import io.probedock.demo.itf.to.ResultTO;
import io.probedock.jee.itf.TestGroup;
import io.probedock.jee.itf.annotations.Test;
import io.probedock.jee.itf.model.Description;

import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * Tests for the {@link CalculatorService}
 *
 * @author Laurent Prevost <laurent.prevost@probedock.io>
 */
@Stateless
public class CalculatorServiceImplTest implements CalculatorServiceTest {
	@EJB
	private CalculatorService calculatorService;

	@Test
	public Description addOperationShouldReturnCorrectValue(Description description) {

		ResultTO res = calculatorService.add(2, 4);

		if (res.getResult() == 6) {
			return description.pass();
		}
		else {
			return description.fail("The result must be equal to 6");
		}
	}

	@Override
	public TestGroup getTestGroup() {
		return this;
	}
}
