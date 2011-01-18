package org.idecc.math.complex;

public class Im extends OneVariableComplexFunction
{
	public void evaluateAt(Complex var, Complex res)
	{
		res.setValue(var.getImaginary(),0.0);
	}
}
