package org.idecc.math.complex.fractal;

import org.idecc.math.complex.Complex;
import org.idecc.math.complex.PowInt;

public class Z3Fractal extends ComplexFractal
{
	public void iterate(Complex z, Complex c)
	{
		PowInt.mutatePower(3,z);
		z.setValue(z.getReal() + c.getReal(),z.getImaginary() + c.getImaginary());
	}
	public void initializeFractal() { }
	public void initializeRendering() { }
	public boolean test(Complex c) {
		return c.magnitudeSquared() <= 4;
	}
}