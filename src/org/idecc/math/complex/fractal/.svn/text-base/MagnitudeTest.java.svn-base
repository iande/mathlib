package org.idecc.math.complex.fractal;

import org.idecc.math.complex.Complex;

public class MagnitudeTest implements FractalTest
{
	protected double _mmag;

	public MagnitudeTest(double mag) { _mmag = mag*mag; }

	public boolean test(Complex z)
	{
		return (z.magnitudeSquared() <= _mmag);
	}

}