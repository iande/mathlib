package org.idecc.math.complex.fractal;

import org.idecc.math.complex.Complex;
import org.idecc.math.complex.TwoVariableComplexFunction;

public class EvenPowersFunction extends TwoVariableComplexFunction
{
	public void evaluateAt(Complex z, Complex c, Complex res)
	{
		double a = z.getReal();
		double b = z.getImaginary();
		double ap = a*a - b*b;
		double bp = 2*a*b;
		double app = ap*ap - bp*bp;
		double bpp = 2*ap*bp;

		res.setValue( ap - app - app*ap + bpp*bp + app*app - bpp*bpp + c.getReal(),
					bp - bpp - ap*bpp - app*bp + 2*app*bpp + c.getImaginary());
	}
}

