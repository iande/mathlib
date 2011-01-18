package org.idecc.math.complex;


public class Division extends BinaryOperator
{
	public void performBinaryOperation(Complex c1, Complex c2, Complex res)
	{
		double u1 = c1.getReal(), u2 = c1.getImaginary();
		double v1 = c2.getReal(), v2 = c2.getImaginary();
		double conj = v1*v1 + v2*v2;

		res.setValue((u1*v1 + u2*v2) / conj, (u2*v1 - u1*v2) / conj);
	}
}
