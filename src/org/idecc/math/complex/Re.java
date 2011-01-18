package org.idecc.math.complex;

public class Re extends OneVariableComplexFunction
{
	public void evaluateAt(Complex var, Complex res)
	{
		res.setValue(var.getReal(),0.0);
	}
}
