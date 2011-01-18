package org.idecc.math.complex;
import org.idecc.math.complex.rpn.RPNElement;

public abstract class BinaryOperator implements RPNElement
{
	public abstract void performBinaryOperation(Complex op1, Complex op2, Complex res);
	public boolean isOperator() { return true; }
	public void performStackOperation(ComplexStack st, Complex store) {
		Complex op2 = st.pop();
		Complex op1 = st.pop();
		performBinaryOperation(op1,op2,store);
	}
}
