package org.idecc.math.complex;


public class Power extends TwoVariableComplexFunction
{
	public void evaluateAt(Complex var1, Complex var2, Complex res)
	{
		double u1 = var1.getReal(), u2 = var1.getImaginary();
		double v1 = var2.getReal(), v2 = var2.getImaginary();
		if(u1 == 0 && u2 == 0 && (v1 != 0 || v2 != 0))
		{
			res.setValue(0,0);
			return;
		}
		double lnr = 0.5*Math.log(u1*u1 + u2*u2);
		double theta = var1.getTheta();
		u1 = Math.exp(v1*lnr - v2*theta);
		u2 = v2*lnr + v1*theta;
		res.setValue(u1*Math.cos(u2),u1*Math.sin(u2));
	}

/*	public void performBinaryOperation(Phasor p1, Phasor p2, Phasor res)
	{
		double lnr = Math.log(p1.getRadius());
		double the = p1.getTheta();
		double rp = p2.getRadius()*Math.sqrt(lnr*lnr+the*the);
		double tp = p2.getTheta() + Math.atan(the/lnr);
		res.setValue( Math.exp(rp*Math.cos(tp)), rp*Math.sin(tp) );
	}*/
}
