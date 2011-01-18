package org.idecc.math.complex.fractal;

import org.idecc.math.complex.Complex;

public class EvenPowersFractal extends ComplexFractal
{
	public void iterate(Complex z, Complex c)
	{
		double a = z.getReal();
		double b = z.getImaginary();
		double ap = a*a - b*b;
		double bp = 2*a*b;
		double app = ap*ap - bp*bp;
		double bpp = 2*ap*bp;

		z.setValue( ap - app - app*ap + bpp*bp + app*app - bpp*bpp + c.getReal(),
					bp - bpp - ap*bpp - app*bp + 2*app*bpp + c.getImaginary());
	}
	public void initializeFractal() { }
	public void initializeRendering() { }
	public boolean test(Complex c) {
		return c.magnitudeSquared() <= 4;
	}
}

