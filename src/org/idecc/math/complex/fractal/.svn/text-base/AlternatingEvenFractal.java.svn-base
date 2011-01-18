package org.idecc.math.complex.fractal;

import org.idecc.math.complex.Complex;

public class AlternatingEvenFractal extends ComplexFractal
{
	public void iterate(Complex z, Complex c)
	{
		double a = z.getReal();
		double b = z.getImaginary();
		double aprime = a*a - b*b;
		double bprime = 2*a*b;
		double adprime = aprime*aprime - bprime*bprime;
		double bdprime = 2*aprime*bprime;
		z.setValue(aprime - adprime + aprime*adprime - bprime*bdprime - adprime*adprime + bdprime*bdprime + c.getReal(),
					bprime - bdprime + adprime*bprime + aprime*bdprime - 2*adprime*bdprime + c.getImaginary());
	}
	public void initializeFractal() { }
	public void initializeRendering() { }
	public boolean test(Complex c) {
		return c.magnitudeSquared() <= 4;
	}
}
