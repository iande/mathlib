package org.idecc.math.complex;

public class RiemannZeta extends OneVariableComplexFunction
{
	protected Power _pow_op1;
	protected Complex _stor1,_stor2,_sum1;

	protected static final int MAX_ITERATIONS = 500;

	public RiemannZeta()
	{
		_pow_op1 = new Power();
		_stor1 = new Complex();
		_stor2 = new Complex();
		_sum1 = new Complex();
	}
	
/*
	This all seems very messy, I'm sure it can be improved; however, it works, and that's what I'm after right now.
*/

	public void evaluateAt(Complex op, Complex res)
	{
		if(op.getReal() <= 0)
		{
			Complex tmp = new Complex(op.getReal()*-1+1,op.getImaginary());

			Complex tmp1 = new Complex();
			evaluateAt(tmp,tmp1);
			Complex tmp2 = new Complex();
			new Gamma().evaluateAt(tmp,tmp2);
			// tmp1 = Zeta(s), tmp2 = Gamma(s)
			Complex tmp3 = new Complex(tmp.getReal()*Math.PI*0.5,tmp.getImaginary()*Math.PI*0.5);
			new Cosine().evaluateAt(tmp3,tmp3);
			// tmp3 = cos(1/2 * s * pi)
			Complex tmp4 = new Complex(2*Math.PI,0);
			Complex tmp5 = new Complex(tmp.getReal()*-1,tmp.getImaginary()*-1);
			new Power().evaluateAt(tmp4,tmp5,tmp4);
			tmp4.setValue(2*tmp4.getReal(),2*tmp4.getImaginary());
			tmp4.setValue(tmp4.getReal()*tmp1.getReal() - tmp4.getImaginary()*tmp1.getImaginary(), tmp4.getReal()*tmp1.getImaginary() + tmp1.getReal()*tmp4.getImaginary());
			tmp4.setValue(tmp4.getReal()*tmp2.getReal() - tmp4.getImaginary()*tmp2.getImaginary(), tmp4.getReal()*tmp2.getImaginary() + tmp2.getReal()*tmp4.getImaginary());
			tmp4.setValue(tmp4.getReal()*tmp3.getReal() - tmp4.getImaginary()*tmp3.getImaginary(), tmp4.getReal()*tmp3.getImaginary() + tmp3.getReal()*tmp4.getImaginary());
			res.setValue(tmp4);
			return;

		}
		_sum1.setValue(0,0);
		_stor1.setValue(op.getReal()*-1+1,op.getImaginary()*-1);
		_stor2.setValue(2,0);
		_pow_op1.evaluateAt(_stor2,_stor1,_stor2);
		_stor2.setValue(_stor2.getReal()*-1+1,_stor2.getImaginary()*-1);
		double conj = _stor2.getReal()*_stor2.getReal() + _stor2.getImaginary()*_stor2.getImaginary();
		_stor1.setValue(_stor2.getReal()/conj,-_stor2.getImaginary()/conj);

		int cur_num = 1;
		for(int n=1; n < MAX_ITERATIONS; n++)
		{
			_stor2.setValue(n,0);
			_pow_op1.evaluateAt(_stor2,op,_stor2);
			conj = _stor2.getReal()*_stor2.getReal() + _stor2.getImaginary()*_stor2.getImaginary();
			_stor2.setValue(_stor2.getReal()/conj, -_stor2.getImaginary()/conj);
			if(cur_num == -1) _stor2.setValue(_stor2.getReal()*cur_num,_stor2.getImaginary()*cur_num);
			cur_num *= -1;
			_sum1.setValue(_sum1.getReal() + _stor2.getReal(), _sum1.getImaginary() + _stor2.getImaginary());
		}

		res.setValue(_stor1.getReal()*_sum1.getReal() - _stor1.getImaginary()*_sum1.getImaginary(), _stor1.getReal()*_sum1.getImaginary() + _sum1.getReal()*_stor1.getImaginary());

	}
}