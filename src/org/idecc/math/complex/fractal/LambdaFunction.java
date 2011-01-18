package org.idecc.math.complex.fractal;

import org.idecc.math.complex.Complex;
import org.idecc.math.complex.TwoVariableComplexFunction;

public class LambdaFunction extends TwoVariableComplexFunction
{
	public void evaluateAt(Complex z, Complex c, Complex res)
	{
		double r = z.getReal();
		double i = z.getImaginary();
		double rc = c.getReal();
		double ic = c.getImaginary();
		double a = r - (r*r - i*i);
		double b = i - 2*i*r;
		res.setValue(rc*a - ic*b, a*ic + b*rc);
	}
}
// c = 0.5,0
