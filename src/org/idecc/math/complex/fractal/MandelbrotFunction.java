package org.idecc.math.complex.fractal;

import org.idecc.math.complex.Complex;
import org.idecc.math.complex.TwoVariableComplexFunction;

public class MandelbrotFunction extends TwoVariableComplexFunction
{
	public void evaluateAt(Complex z, Complex c, Complex res)
	{
		double r = z.getReal();
		double i = z.getImaginary();
		res.setValue(r*r - i*i + c.getReal(), 2*r*i + c.getImaginary());
	}
}