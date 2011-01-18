package org.idecc.math.real;

public abstract class BinaryOperator implements org.idecc.math.real.rpn.RPNElement
{
	public abstract double performBinaryOperation(double op1, double op2);
	public boolean isOperator() { return true; }
	public double performStackOperation(RealStack st)
	{
		double op2 = st.pop();
		double op1 = st.pop();
		return performBinaryOperation(op1,op2);
	}

}