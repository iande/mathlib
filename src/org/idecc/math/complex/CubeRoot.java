package org.idecc.math.complex;

public class CubeRoot extends UnaryOperator
{
	public void performUnaryOperation(Complex c, Complex res)
	{
		double a = c.getReal();
		double b = c.getImaginary();
		double newTheta = c.getTheta()/3.0;
		double r = Math.pow(a*a + b*b,1.0/6.0);
		res.setReal(r*Math.cos(newTheta));
		res.setImaginary(r*Math.sin(newTheta));
	}
}
