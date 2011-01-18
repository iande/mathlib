package org.idecc.math.complex.fractal;

import org.idecc.math.complex.Complex;
import org.idecc.math.complex.TwoVariableComplexFunction;
import org.idecc.math.complex.PowInt;

public class Z3Function extends TwoVariableComplexFunction
{
	public void evaluateAt(Complex z, Complex c, Complex res)
	{
		PowInt.mutatePower(3,z);
		res.setValue(z.getReal() + c.getReal(),z.getImaginary() + c.getImaginary());
	}
}