package org.idecc.math.real;

public abstract class OneVariableRealFunction implements RealFunction
{
	public int numberOfVariables() { return 1; }
	public abstract double evaluateAt(double val);
	public double evaluateAt(double vals[]) { return evaluateAt(vals[0]); }
	public boolean isOperator() { return true; }
	public double performStackOperation(RealStack st) {
		double op1 = st.pop();
		return evaluateAt(op1);
	}
}