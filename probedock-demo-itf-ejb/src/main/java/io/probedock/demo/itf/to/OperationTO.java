package io.probedock.demo.itf.to;

/**
 * Operation
 *
 * @author Laurent Prevost <laurent.prevost@probedock.io>
 */
public class OperationTO {
	private String op;
	private int left;
	private int right;

	public String getOp() {
		return op;
	}

	public void setOp(String op) {
		this.op = op;
	}

	public int getLeft() {
		return left;
	}

	public void setLeft(int left) {
		this.left = left;
	}

	public int getRight() {
		return right;
	}

	public void setRight(int right) {
		this.right = right;
	}
}
