package org.idecc.math.complex.fractal;

import org.idecc.math.complex.Complex;
import org.idecc.math.complex.TwoVariableComplexFunction;

public class MuInverseFunction extends TwoVariableComplexFunction
{
	public void evaluateAt(Complex z, Complex c, Complex res)
	{
		double r = z.getReal();
		double i = z.getImaginary();
		double rc = c.getReal();
		double ic = c.getImaginary();
		double cmag = rc*rc + ic*ic;

		res.setValue(r*r - i*i + rc/cmag, 2*r*i - ic/cmag);
	}
}
