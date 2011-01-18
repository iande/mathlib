package org.idecc.math.real;

public class PowInt extends TwoVariableRealFunction
{
	public double quickpower(double r, int n)
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

	public double evaluateAt(double val1, double val2)
	{
		int exp = (int)val2;
		return quickpower(val1,exp);
	}
}