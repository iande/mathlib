package org.idecc.math.complex.fractal;

import org.idecc.math.complex.Complex;

public class NovaFractal extends ComplexFractal
{
	protected Complex _z2,_zold;
	public NovaFractal() {
		initializeFractal();
	}
	public void iterate(Complex z, Complex c)
	{
		_zold.setValue(z);
		double re = z.getReal();
		double im = z.getImaginary();
		_z2.setValue(re*re - im*im,2*im*re);
		double mag = _z2.magnitudeSquared();
		_z2.setValue(_z2.getReal()/mag * 1.0/3.0,_z2.getImaginary()/mag * -1.0/3.0);
		z.setValue(re * 2.0/3.0 + _z2.getReal() + c.getReal(), im * 2.0/3.0 + _z2.getImaginary() + c.getImaginary());
	}
	public void initializeFractal()
	{
		setCenter(1,0);
		setDefaultRange(-2,1);
		_z2 = new Complex();
		_zold = new Complex();
	}
	public void initializeRendering() { }
	public boolean test(Complex c) {
		_zold.setValue(c.getReal() - _zold.getReal(), c.getImaginary() - _zold.getImaginary());
		return _zold.magnitudeSquared() > 0.00002;
	}
}

// 0.00001