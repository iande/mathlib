package org.idecc.math.complex;

public class Cube extends UnaryOperator
{
	public void performUnaryOperation(Complex c, Complex res)
	{
		double u1 = c.getReal(), u2 = c.getImaginary();
		double v1 = u1*u1 - u2*u2;
		double v2 = 2*u1*u2;
		
		res.setValue(u1*v1 - u2*v2,u1*v2 + u2*v1);
	}
}
