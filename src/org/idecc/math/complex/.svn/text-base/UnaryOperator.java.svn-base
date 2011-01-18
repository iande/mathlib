package org.idecc.math.complex;
import org.idecc.math.complex.rpn.RPNElement;

public abstract class UnaryOperator implements RPNElement
{
	public abstract void performUnaryOperation(Complex op, Complex res);
	public boolean isOperator() { return true; }
	public void performStackOperation(ComplexStack st, Complex store)
	{
		Complex op1 = st.pop();
		performUnaryOperation(op1,store);
	}
}
