package org.idecc.math.complex;

public class Gamma extends OneVariableComplexFunction
{
	private static final double _P[] = { 2.50662827563479526904, 225.525584619175212544, -268.295973841304927459, 80.9030806934622512966, -5.00757863970517583837, 0.0114684895434781459556 };
	private static final double _g = 5.15;
	private Complex _z, _zg, _z_05, _ln_zg, _zpfin, _lnGz;
	private Complex _ZP[];

	public Gamma()
	{
		_ZP = new Complex[_P.length];
		_ZP[0] = new Complex(_P[0],0);
		for(int i=1; i < _ZP.length; i++) _ZP[i] = new Complex();
		_zpfin = new Complex();
		_z = new Complex();
		_zg = new Complex();
		_z_05 = new Complex();
		_ln_zg = new Complex();
		_lnGz = new Complex();
	}

	public void evaluateAt(Complex op1, Complex res)
	{
		double a = op1.getReal(), b = op1.getImaginary();
		double nr, conj, mult;
		
		_z.setValue(op1);
		_z_05.setValue(_z.getReal() - 0.5, _z.getImaginary());
		_zg.setValue(_z_05.getReal() + _g, _z_05.getImaginary());

		for(int i=1; i < _ZP.length; i++)
		{
			nr = a+i-1;
			conj = nr*nr + b*b;
			mult = _P[i] / conj;
			_ZP[i].setValue(mult*nr, -mult*b);
		}
		_zpfin.setValue(_ZP[0]);
		for(int i=1; i < _ZP.length; i++) _zpfin.setValue(_zpfin.getReal()+_ZP[i].getReal(), _zpfin.getImaginary()+_ZP[i].getImaginary());
		_zpfin.setValue( 0.5*Math.log( _zpfin.magnitudeSquared() ), _zpfin.getTheta() );
		_ln_zg.setValue( 0.5*Math.log( _zg.magnitudeSquared() ), _zg.getTheta() );

		_lnGz.setValue(
			_z_05.getReal()*_ln_zg.getReal() - _z_05.getImaginary()*_ln_zg.getImaginary() + _zpfin.getReal() - _zg.getReal(),
			_z_05.getReal()*_ln_zg.getImaginary() + _ln_zg.getReal()*_z_05.getImaginary() + _zpfin.getImaginary() - _zg.getImaginary()
		);
		a = _lnGz.getReal();
		b = _lnGz.getImaginary();
		res.setValue(Math.exp(a)*Math.cos(b), Math.exp(a)*Math.sin(b));
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