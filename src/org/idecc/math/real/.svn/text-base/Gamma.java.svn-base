package org.idecc.math.real;

public class Gamma extends OneVariableRealFunction
{
	private static final double _P[] = { 2.50662827563479526904, 225.525584619175212544, -268.295973841304927459, 80.9030806934622512966, -5.00757863970517583837, 0.0114684895434781459556 };
	private static final double _g = 5.15;

	public double evaluateAt(double op1)
	{
		double z = op1 - 1;
		double z05 = z + 0.5;
		double zg = z05 + _g;
		double ZP = _P[0];

		for(int i=1; i < _P.length; i++) {
			ZP += _P[i] / (z+i);
		}
		return (ZP*Math.pow(zg,z05) / Math.exp(zg));
	}
}

/*
This works well.


Let's try something new:
ln Gamma(z+1) = ln ZP + (z+0.5) ln(z+g+0.5) - (z+g+0.5)
with:

	Z = [1, 1/(z+1), 1/(z+2), 1/(z+3), 1/(z+4), 1/(z+5)]
	P = [ 2.50662827563479526904 ]
		[ 225.525584619175212544 ]
		[-268.295973841304927459 ]
		[ 80.9030806934622512966 ]
		[-5.00757863970517583837 ]
		[0.0114684895434781459556]
	g = 5.15


	ZP = 2.50662827563479526904 + 225.525584619175212544 / (z + 1) - 268.295973841304927459 / (z + 2) ...
*/