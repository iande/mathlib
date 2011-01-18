package org.idecc.math.complex.fractal;

import org.idecc.math.complex.Complex;
import org.idecc.math.complex.TwoVariableComplexFunction;
import org.idecc.math.complex.PowInt;

public class Z5Function extends TwoVariableComplexFunction
{
	public void evaluateAt(Complex z, Complex c, Complex res)
	{
		PowInt.mutatePower(5,z);
		res.setValue(z.getReal() + c.getReal(),z.getImaginary() + c.getImaginary());
	}
}