package org.idecc.math.complex;

public class Reciprocal extends UnaryOperator
{
	public void performUnaryOperation(Complex c, Complex res)
	{
		double u1 = c.getReal(), u2 = c.getImaginary();
		double mag = u1*u1 + u2*u2;
		res.setValue(u1/mag,-u2/mag);
	}
}
