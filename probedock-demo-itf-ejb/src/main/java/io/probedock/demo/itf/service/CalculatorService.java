package io.probedock.demo.itf.service;

import io.probedock.demo.itf.to.ResultTO;

import javax.ejb.Local;

/**
 * Calculator service.
 *
 * @author Laurent Prevost <laurent.prevost@probedock.io>
 */
@Local
public interface CalculatorService {
	/**
	 * Addition
	 *
	 * @param left
	 * @param right
	 * @return left + right
	 */
	ResultTO add(int left, int right);

	/**
	 * Subtraction
	 *
	 * @param left
	 * @param right
	 * @return left - right
	 */
	ResultTO sub(int left, int right);

	/**
	 * Multiplication
	 *
	 * @param left
	 * @param right
	 * @return left * right
	 */
	ResultTO mul(int left, int right);

	/**
	 * Division
	 *
	 * @param left
	 * @param right
	 * @return left / right
	 */
	ResultTO div(int left, int right);
}
