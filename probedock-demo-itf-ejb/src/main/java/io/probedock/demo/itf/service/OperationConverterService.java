package io.probedock.demo.itf.service;

import io.probedock.demo.itf.to.OperationTO;
import io.probedock.demo.junit.Operation;

import javax.ejb.Local;

/**
 * Converter service to convert {@link OperationTO} to {@link Operation}.
 *
 * The {@link Operation} class comes from the Demo implementation of Junit Probe Dock client.
 *
 * @author Laurent Prevost <laurent.prevost@probedock.io>
 */
@Local
public interface OperationConverterService {
    /**
     * Convert a transfer object to real operation implementation
     *
     * @param operation The operation to convert
     * @return The operation converted
     */
    Operation convert(OperationTO operation);
}
