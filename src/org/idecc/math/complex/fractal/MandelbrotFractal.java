package org.idecc.math.complex.fractal;

import org.idecc.math.complex.Complex;

public class MandelbrotFractal extends ComplexFractal {

	public MandelbrotFractal() {
		initializeFractal();
	}
	
	public void initializeFractal() {
		setDefaultRange(-2.5,1.5);
	}
	public void initializeRendering() { }
	public void iterate(Complex z, Complex c) {
		double x = z.x;
		double y = z.y;
		// Relies on the fact that Complex is a subclass of Point.
		z.x = x*x - y*y + c.x;
		z.y = 2*x*y + c.y;
	}
	public boolean test(Complex z) {
		return (z.magnitudeSquared() <= 4);
	}
}
