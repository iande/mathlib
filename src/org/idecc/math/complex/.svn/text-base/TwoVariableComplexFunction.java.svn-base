package org.idecc.math.complex;

public abstract class TwoVariableComplexFunction implements ComplexFunction
{
	public int numberOfVariables() { return 2; }
	public void evaluateAt(Complex[] vars, Complex res) { evaluateAt(vars[0],vars[1],res); }
	public abstract void evaluateAt(Complex var1, Complex var2, Complex res);
	public void performStackOperation(ComplexStack st, Complex store)
	{
		Complex op2 = st.pop();
		Complex op1 = st.pop();
		evaluateAt(op1,op2,store);
	}
	public boolean isOperator() { return true; }
}
