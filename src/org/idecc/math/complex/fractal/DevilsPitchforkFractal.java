package org.idecc.math.complex.fractal;

import org.idecc.math.complex.Complex;
import org.idecc.math.complex.PowInt;

public class DevilsPitchforkFractal extends ComplexFractal
{
	protected Complex _z4,_zold;
	public DevilsPitchforkFractal() {
		initializeFractal();
	}
	public void iterate(Complex z, Complex c)
	{
		_zold.setValue(z);
		double re = z.getReal();
		double im = z.getImaginary();
		_z4.setValue(z);
		PowInt.mutatePower(4,_z4);
		double mag = _z4.magnitudeSquared();
		_z4.setValue(_z4.getReal()/mag * 0.2,-1*_z4.getImaginary()/mag * 0.2);
		z.setValue(re * 0.8 + _z4.getReal() + c.getReal(), im * 0.8 + _z4.getImaginary() + c.getImaginary());
	}
	public void initializeFractal() {
		setCenter(1,0);
		setDefaultRange(-2,1);
		_z4 = new Complex();
		_zold = new Complex();
	}
	public void initializeRendering() { _zold.setValue(0,0); }
	public boolean test(Complex c) {
		_zold.setValue(c.getReal() - _zold.getReal(), c.getImaginary() - _zold.getImaginary());
		return _zold.magnitudeSquared() > 0.00002;
	}
}