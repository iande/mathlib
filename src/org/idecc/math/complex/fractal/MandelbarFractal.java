package org.idecc.math.complex.fractal;

import org.idecc.math.complex.Complex;

public class MandelbarFractal extends ComplexFractal
{
	public void iterate(Complex z, Complex c)
	{
		double r = z.getReal();
		double i = z.getImaginary();
		z.setValue(r*r - i*i + c.getReal(), -2*r*i + c.getImaginary());
	}
	public void initializeFractal() { }
	public void initializeRendering() { }
	public boolean test(Complex c) {
		return c.magnitudeSquared() <= 4;
	}
}
