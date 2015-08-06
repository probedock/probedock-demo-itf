package io.probedock.demo.itf.service;

import io.probedock.client.annotations.ProbeTest;
import io.probedock.client.annotations.ProbeTestClass;
import io.probedock.demo.itf.to.OperationTO;
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
@ProbeTestClass(contributors = "laurent.prevost@probedock.io", tickets = "feature-2", tags = "calculator")
public class CalculatorServiceTestImpl implements CalculatorServiceTest {
    @EJB
    private CalculatorService calculatorService;

    @Test
    @ProbeTest(tags = "add")
    public Description itShouldBePossibleToProcessSingleAdditionOperation(Description description) throws Exception {
        ResultTO res = calculatorService.process(new OperationTO("add", 3, 5));

        if (res.getResult() != 8) {
            return description.fail("The addition operation result is not correct");
        }

        return description.pass();
    }

    @Test
    @ProbeTest(tags = "sub")
    public Description itShouldBePossibleToProcessSingleSubtractionOperation(Description description) throws Exception {
        ResultTO res = calculatorService.process(new OperationTO("sub", 8, 5));

        if (res.getResult() != 3) {
            return description.fail("The subtraction operation result is not correct");
        }

        return description.pass();
    }

    @Test
    @ProbeTest(tags = "mul")
    public Description itShouldBePossibleToProcessSingleMultiplicationOperation(Description description) throws Exception {
        ResultTO res = calculatorService.process(new OperationTO("mul", 3, 5));

        if (res.getResult() != 15) {
            return description.fail("The multiplication operation result is not correct");
        }

        return description.pass();
    }

    @Test
    @ProbeTest(tags = "div")
    public Description itShouldBePossibleToProcessSingleDivisionOperation(Description description) throws Exception {
        ResultTO res = calculatorService.process(new OperationTO("div", 15, 5));

        if (res.getResult() != 3) {
            return description.fail("The division operation result is not correct");
        }

        return description.pass();
    }

    @Test
    @ProbeTest(tags = "add")
    public Description itShouldNotBePossibleToProcessDivisionOperationWhenRightOperandIsZero(Description description) {
        try {
            calculatorService.process(new OperationTO("div", 3, 0));
            return description.fail("It should throw an CalculationException when right operand is zero");
        }
        catch (CalculationException ce) {
            return description.pass();
        }
    }

    @Test
    @ProbeTest(tags = "composed", name = "It should be possible to process this operation: 3 + (5 - (7 * (12 / 2)))")
    public Description itShouldBePossibleToProcessComplexOperation(Description description) throws Exception {
        ResultTO res = calculatorService.process(
            new OperationTO(
                "add",
                3,
                new OperationTO(
                    "sub",
                    5,
                    new OperationTO(
                        "mul",
                        7,
                        new OperationTO("div", 12, 2)
                    )
                )
            )
        );

        if (res.getResult() != -34) {
            return description.fail("The operation result should be -34");
        } else {
            return description.pass();
        }
    }

    @Override
    public TestGroup getTestGroup() {
        return this;
    }
}
