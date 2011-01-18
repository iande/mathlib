package org.idecc.math.complex;


public class PowImaginary extends TwoVariableComplexFunction
{
	public void evaluateAt(Complex var1, Complex var2, Complex res)
	{
		double exp = var2.getImaginary();
		double r, rn, theta;
		r = var1.magnitudeSquared();
		theta = var1.getTheta();
		theta = Math.exp(-1*theta*exp);
		rn = Math.log(r)*0.5*exp;
		res.setValue(theta*Math.cos(rn),theta*Math.sin(rn));
	}
}
