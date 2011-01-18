package org.idecc.math.complex.fractal;

import org.idecc.math.complex.Complex;
import org.idecc.math.complex.TwoVariableComplexFunction;

public class OddPowersFunction extends TwoVariableComplexFunction
{
	public void evaluateAt(Complex z, Complex c, Complex res)
	{
		double a = z.getReal();
		double b = z.getImaginary();
		double ap = a*a - b*b;
		double bp = 2*a*b;
		double app = a*ap - b*bp;
		double bpp = a*bp + b*ap;
		double af = 1 - ap - ap*ap + bp*bp + app*app - bpp*bpp;
		double bf = -bp - 2*ap*bp + 2*app*bpp;

		res.setValue(app*af - bpp*bf + c.getReal(), app*bf + bpp*af + c.getImaginary());
	}
}