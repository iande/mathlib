package org.idecc.math.complex.fractal;

import org.idecc.math.complex.Complex;

public class MuInverseFractal extends ComplexFractal
{
	public MuInverseFractal() {
		initializeFractal();
	}
	public void iterate(Complex z, Complex c)
	{
		double r = z.getReal();
		double i = z.getImaginary();
		double rc = c.getReal();
		double ic = c.getImaginary();
		double cmag = rc*rc + ic*ic;

		z.setValue(r*r - i*i + rc/cmag, 2*r*i - ic/cmag);
	}
	public void initializeFractal() { setDefaultRange(-1.5,4.25); }
	public void initializeRendering() { }
	public boolean test(Complex c) {
		return c.magnitudeSquared() <= 4;
	}
}
