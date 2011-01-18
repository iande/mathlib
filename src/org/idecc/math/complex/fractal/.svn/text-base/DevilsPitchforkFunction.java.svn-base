package org.idecc.math.complex.fractal;

import org.idecc.math.complex.Complex;
import org.idecc.math.complex.TwoVariableComplexFunction;
import org.idecc.math.complex.PowInt;

public class DevilsPitchforkFunction extends TwoVariableComplexFunction
{
	protected Complex _z4;
	public DevilsPitchforkFunction() { _z4 = new Complex(); }
	public void evaluateAt(Complex z, Complex c, Complex res)
	{
		double re = z.getReal();
		double im = z.getImaginary();
		_z4.setValue(z);
		PowInt.mutatePower(4,_z4);
		double mag = _z4.magnitudeSquared();
		_z4.setValue(_z4.getReal()/mag * 0.2,-1*_z4.getImaginary()/mag * 0.2);
		res.setValue(re * 0.8 + _z4.getReal() + c.getReal(), im * 0.8 + _z4.getImaginary() + c.getImaginary());
	}
}