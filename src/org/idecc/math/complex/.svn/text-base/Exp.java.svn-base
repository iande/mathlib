package org.idecc.math.complex;

public class Exp extends OneVariableComplexFunction
{
	public void evaluateAt(Complex var, Complex res)
	{
		double u1 = var.getReal(), u2 = var.getImaginary();
		u1 = Math.exp(u1);
		res.setValue(u1*Math.cos(u2),u1*Math.sin(u2));
	}

/*	public void performUnaryOperation(Phasor p, Phasor res)
	{
		double r = p.getRadius();
		double t = p.getTheta();
		res.setValue(Math.exp(r*Math.cos(t)), r*Math.sin(t));
	}*/
}
