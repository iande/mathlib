package org.idecc.math.real;

public abstract class UnaryOperator implements org.idecc.math.real.rpn.RPNElement
{
	public abstract double performUnaryOperation(double op);
	public boolean isOperator() { return true; }
	public double performStackOperation(RealStack st)
	{
		double op1 = st.pop();
		return performUnaryOperation(op1);
	}
}