package io.probedock.demo.itf.service;

import io.probedock.demo.itf.to.ResultTO;

import javax.ejb.Stateless;

/**
 * Implementation of {@link CalculatorService}.
 *
 * @author Laurent Prevost <laurent.prevost@probedock.io>
 */
@Stateless
public class CalculatorServiceImpl implements CalculatorService {
    @Override
    public ResultTO add(int left, int right) {
        return new ResultTO(left + right);
    }

    @Override
    public ResultTO sub(int left, int right) {
        return new ResultTO(left - right);
    }

    @Override
    public ResultTO mul(int left, int right) {
        return new ResultTO(left * right);
    }

    @Override
    public ResultTO div(int left, int right) {
        if (right == 0) {
            throw new IllegalArgumentException("Right operand must be different from 0.");
        }
        else {
            return new ResultTO(left / right);
        }
    }
}
