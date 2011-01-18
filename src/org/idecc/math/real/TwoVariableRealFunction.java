package org.idecc.math.real;

public abstract class TwoVariableRealFunction implements RealFunction
{
	public int numberOfVariables() { return 2; }
	public abstract double evaluateAt(double val, double val2);
	public double evaluateAt(double vals[]) { return evaluateAt(vals[0],vals[1]); }
	public boolean isOperator() { return true; }
	public double performStackOperation(RealStack st) {
		double op2 = st.pop();
		double op1 = st.pop();
		return evaluateAt(op1,op2);
	}
}