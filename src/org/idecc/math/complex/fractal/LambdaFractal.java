package org.idecc.math.complex.fractal;

import org.idecc.math.complex.Complex;

public class LambdaFractal extends ComplexFractal
{
	public LambdaFractal() {
		initializeFractal();
	}
	public void iterate(Complex z, Complex c)
	{
		double r = z.getReal();
		double i = z.getImaginary();
		double rc = c.getReal();
		double ic = c.getImaginary();
		double a = r - (r*r - i*i);
		double b = i - 2*i*r;
		z.setValue(rc*a - ic*b, a*ic + b*rc);
	}
	public void initializeFractal() {
		setCenter(0.5,0);
		setDefaultRange(1,5);
	}
	public void initializeRendering() { }
	public boolean test(Complex c) {
		return c.magnitudeSquared() <= 4;
	}
}
// c = 0.5,0
