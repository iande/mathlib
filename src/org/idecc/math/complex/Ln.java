package org.idecc.math.complex;

public class Ln extends OneVariableComplexFunction
{
	public void evaluateAt(Complex var, Complex res)
	{
		res.setValue(0.5*Math.log(var.magnitudeSquared()), var.getTheta() );
	}

/*	public void performUnaryOperation(Phasor p, Phasor res)
	{
		double r = p.getRadius();
		double t = p.getTheta();
		double lnr = Math.log(r);
		res.setValue(Math.sqrt(lnr*lnr + t*t), Math.atan(t/lnr));
	}
*/
}
