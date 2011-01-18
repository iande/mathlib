package org.idecc.math.complex;

public class Tangent extends OneVariableComplexFunction
{
	public void evaluateAt(Complex var, Complex res)
	{
		double u1 = var.getReal(), u2 = var.getImaginary();
		double ex1 = Math.exp(u2);
		double ex2 = Math.exp(-u2);
		double cosh = (ex1+ex2);
		double sinh = (ex1-ex2);
		double sinhcosh = sinh*cosh;
		double cos = Math.cos(u1);
		double sin = Math.sin(u1);
		double sincos = sin*cos;
		cosh *= cosh;
		sinh *= sinh;
		sin *= sin;
		cos *= cos;

		double denom = 1.0 / (cos*cosh + sin*sinh);
		double numr = sincos*(cosh - sinh);
		double numi = sinhcosh;

		res.setValue(numr*denom,numi*denom);
	}
}
