package org.idecc.math.complex;

public class HyperbolicSine extends OneVariableComplexFunction
{
	public void evaluateAt(Complex var, Complex res)
	{
		double u1 = var.getReal(), u2 = var.getImaginary();
		double ex1 = Math.exp(u1);
		double ex2 = Math.exp(-u1);
		res.setValue((ex1 - ex2)*Math.cos(u2)*0.5,(ex1+ex2)*Math.sin(u2)*0.5);
	}
}
