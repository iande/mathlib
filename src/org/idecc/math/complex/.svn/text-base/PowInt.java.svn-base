package org.idecc.math.complex;


public class PowInt extends TwoVariableComplexFunction
{
	public static final void mutatePower(int n, Complex res)
	{
		if(n < 0)
		{
			mutatePower(-n,res);
			double u1 = res.getReal(), u2 = res.getImaginary();
			double denom = u1*u1 + u2*u2;
			res.setValue(u1/denom, -u2/denom);
			return;
		}
		if(n == 0)
		{
			res.setValue(1,0);
			return;
		}
		if(n == 1) return;

		if( (n % 2) == 0)
		{
			mutatePower(n/2,res);
			double u1 = res.getReal(), u2 = res.getImaginary();
			res.setValue(u1*u1 - u2*u2, 2*u1*u2);
		} else {
			double v1 = res.getReal(), v2 = res.getImaginary();
			mutatePower((n-1)/2, res);
			double u1 = res.getReal(), u2 = res.getImaginary();
			double re = u1*u1 - u2*u2;
			double im = 2*u1*u2;

			res.setValue(re*v1 - im*v2, im*v1 + re*v2);
		}
	}
	public void evaluateAt(Complex var1, Complex var2, Complex res)
	{
		int exp = (int)var2.getReal();
		res.setValue(var1);
		mutatePower(exp,res);
	}

	/*public static final double quickpower(double r, int n)
	{
		if(n < 0) return (1.0 / quickpower(r,-n));
		if(n == 0) return 1.0;
		if(n == 1) return r;
		if( (n % 2) == 0)
		{
			double p = quickpower(r,n/2);
			return p*p;
		} else {
			double p = quickpower(r,(n-1)/2);
			return p*p*r;
		}
	}
	public void performBinaryOperation(Phasor p1, Phasor p2, Phasor res)
	{
		int exp = (p2.getTheta() == Math.PI) ? -1 * (int)p2.getRadius() : (int)p2.getRadius();
		double rn = quickpower(p1.getRadius(),exp);
		res.setValue(rn, exp*p1.getTheta());
	}*/
}
