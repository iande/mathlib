package org.idecc.math.complex.rpn;
import org.idecc.math.complex.ComplexStack;
import org.idecc.math.complex.Complex;

public interface RPNElement {
	public boolean isOperator();
	public void performStackOperation(ComplexStack st, Complex store);
}
