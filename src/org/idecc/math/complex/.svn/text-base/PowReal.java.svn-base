package org.idecc.math.complex;


public class PowReal extends TwoVariableComplexFunction
{
	public void evaluateAt(Complex var1, Complex var2, Complex res)
	{
		double exp = var2.getReal();
		double u1 = var1.getReal(), u2 = var1.getImaginary();
		double r, rn, theta;
		r = u1*u1 + u2*u2;
		theta = var1.getTheta();
		rn = Math.pow(r,exp/2.0);
		res.setValue(rn*Math.cos(exp*theta),rn*Math.sin(exp*theta));
	}
}
