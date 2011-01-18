package org.idecc.math.complex.fractal;

import org.idecc.math.complex.Complex;
import org.idecc.math.complex.TwoVariableComplexFunction;

public class NovaFunction extends TwoVariableComplexFunction
{
	protected Complex _z2;
	public NovaFunction() { _z2 = new Complex(); }
	public void evaluateAt(Complex z, Complex c, Complex res)
	{
		double re = z.getReal();
		double im = z.getImaginary();
		_z2.setValue(re*re - im*im,2*im*re);
		double mag = _z2.magnitudeSquared();
		_z2.setValue(_z2.getReal()/mag * 1.0/3.0,_z2.getImaginary()/mag * -1.0/3.0);
		res.setValue(re * 2.0/3.0 + _z2.getReal() + c.getReal(), im * 2.0/3.0 + _z2.getImaginary() + c.getImaginary());
	}
}

// 0.00001