package org.idecc.math.complex.fractal;

import org.idecc.math.complex.Complex;
import org.idecc.math.complex.TwoVariableComplexFunction;

public class AlternatingEvenFunction extends TwoVariableComplexFunction
{
	public void evaluateAt(Complex z, Complex c, Complex res)
	{
		double a = z.getReal();
		double b = z.getImaginary();
		double aprime = a*a - b*b;
		double bprime = 2*a*b;
		double adprime = aprime*aprime - bprime*bprime;
		double bdprime = 2*aprime*bprime;
		res.setValue(aprime - adprime + aprime*adprime - bprime*bdprime - adprime*adprime + bdprime*bdprime + c.getReal(),
					bprime - bdprime + adprime*bprime + aprime*bdprime - 2*adprime*bdprime + c.getImaginary());
	}
}
