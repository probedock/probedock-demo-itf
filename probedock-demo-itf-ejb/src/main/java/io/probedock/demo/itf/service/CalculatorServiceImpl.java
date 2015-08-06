package io.probedock.demo.itf.service;

import io.probedock.demo.itf.to.OperationTO;
import io.probedock.demo.itf.to.ResultTO;

import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * Implementation of {@link CalculatorService}.
 *
 * @author Laurent Prevost <laurent.prevost@probedock.io>
 */
@Stateless
public class CalculatorServiceImpl implements CalculatorService {
    @EJB
    private OperationConverterService operationConverterService;

    @Override
    public ResultTO process(OperationTO operation) throws CalculationException {
        try {
            return new ResultTO(operationConverterService.convert(operation).process());
        }
        catch (IllegalStateException ise) {
            throw new CalculationException(ise);
        }
    }
}
