package io.probedock.demo.itf.service;

import io.probedock.client.annotations.ProbeTest;
import io.probedock.client.annotations.ProbeTestClass;
import io.probedock.demo.itf.to.OperationTO;
import io.probedock.demo.junit.*;
import io.probedock.jee.itf.TestGroup;
import io.probedock.jee.itf.annotations.Test;
import io.probedock.jee.itf.model.Description;

import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * Tests for the {@link OperationConverterService}
 *
 * @author Laurent Prevost <laurent.prevost@probedock.io>
 */
@Stateless
@ProbeTestClass(contributors = "laurent.prevost@probedock.io", tickets = "feature-1", tags = "converter")
public class OperationConverterServiceTestImpl implements OperationConverterServiceTest {
    @EJB
    private OperationConverterService operationConverterService;

    @Test
    @ProbeTest(tags = "add")
    public Description itShouldBePossibleToConvertSingleAddOperation(Description description) {
        Operation op = operationConverterService.convert(new OperationTO("add", 5, 6));

        if (!(op instanceof OperationAdd)) {
            return description.fail("The operation is not of the right type");
        }

        if (op.getLeftOperand() != 5) {
            return description.fail("The left operand is not correct");
        }

        if (op.getRightOperand() != 6) {
            return description.fail("The right operand is not correct");
        }

        return description.pass();
    }

    @Test
    @ProbeTest(tags = "sub")
    public Description itShouldBePossibleToConvertSingleSubOperation(Description description) {
        Operation op = operationConverterService.convert(new OperationTO("sub", 5, 6));

        if (!(op instanceof OperationSub)) {
            return description.fail("The operation is not of the right type");
        }

        if (op.getLeftOperand() != 5) {
            return description.fail("The left operand is not correct");
        }

        if (op.getRightOperand() != 6) {
            return description.fail("The right operand is not correct");
        }

        return description.pass();
    }

    @Test
    @ProbeTest(tags = "mul")
    public Description itShouldBePossibleToConvertSingleMulOperation(Description description) {
        Operation op = operationConverterService.convert(new OperationTO("mul", 5, 6));

        if (!(op instanceof OperationMul)) {
            return description.fail("The operation is not of the right type");
        }

        if (op.getLeftOperand() != 5) {
            return description.fail("The left operand is not correct");
        }

        if (op.getRightOperand() != 6) {
            return description.fail("The right operand is not correct");
        }

        return description.pass();
    }

    @Test
    @ProbeTest(tags = "div")
    public Description itShouldBePossibleToConvertSingleDivOperation(Description description) {
        Operation op = operationConverterService.convert(new OperationTO("div", 5, 6));

        if (!(op instanceof OperationDiv)) {
            return description.fail("The operation is not of the right type");
        }

        if (op.getLeftOperand() != 5) {
            return description.fail("The left operand is not correct");
        }

        if (op.getRightOperand() != 6) {
            return description.fail("The right operand is not correct");
        }

        return description.pass();
    }

    @Test
    @ProbeTest(tags = "composed", name = "It should be possible to convert this operation: 3 + (5 - (7 * (12 / 2)))")
    public Description itShouldBePossibleToConvertComplexOperation(Description description) {
        Operation op = operationConverterService.convert(
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

        if (!(op instanceof OperationAdd)) {
            return description.fail("The add operation is not of the right type");
        }

        if (op.getLeftOperand() != 3) {
            return description.fail("The add operation must have left operand equal to 3");
        }

        Operation opSub = op.getRightOperation();
        if (opSub == null || !(opSub instanceof OperationSub)) {
            return description.fail("The add operation must have a sub operation for right side");
        }

        if (opSub.getLeftOperand() != 5) {
            return description.fail("The sub operation must have left operand equal to 5");
        }

        Operation opMul = opSub.getRightOperation();
        if (opMul == null || !(opMul instanceof OperationMul)) {
            return description.fail("The add operation must have a mul operation for right side");
        }

        if (opMul.getLeftOperand() != 7) {
            return description.fail("The sub operation must have left operand equal to 7");
        }

        Operation opDiv = opMul.getRightOperation();
        if (opDiv == null || !(opDiv instanceof OperationDiv)) {
            return description.fail("The add operation must have a div operation for right side");
        }

        if (opDiv.getLeftOperand() != 12) {
            return description.fail("The sub operation must have left operand equal to 12");
        }

        if (opDiv.getRightOperand() != 2) {
            return description.fail("The sub operation must have right operand equal to 2");
        }

        return description.pass();
    }

    @Override
    public TestGroup getTestGroup() {
        return this;
    }
}
