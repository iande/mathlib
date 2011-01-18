package org.idecc.math.complex;

public class Sine extends OneVariableComplexFunction
{
	public void evaluateAt(Complex var, Complex res)
	{
		double u1 = var.getReal(), u2 = var.getImaginary();
		double ex1 = Math.exp(u2);
		double ex2 = Math.exp(-u2);
		res.setValue(Math.sin(u1)*(ex1+ex2)*0.5,Math.cos(u1)*(ex1-ex2)*0.5);
	}
}
