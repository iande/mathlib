package org.idecc.math.complex;

public abstract class OneVariableComplexFunction implements ComplexFunction
{
	public int numberOfVariables() { return 1; }
	public void evaluateAt(Complex[] vars, Complex res) { evaluateAt(vars[0],res); }
	public abstract void evaluateAt(Complex var, Complex res);
	public void performStackOperation(ComplexStack st, Complex store)
	{
		Complex op1 = st.pop();
		evaluateAt(op1,store);
	}
	public boolean isOperator() { return true; }
}
