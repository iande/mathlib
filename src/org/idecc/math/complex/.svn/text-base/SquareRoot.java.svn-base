package org.idecc.math.complex;

public class SquareRoot extends UnaryOperator
{
	public void performUnaryOperation(Complex c, Complex res)
	{
		// Taking a sqrt of a sqrt is cheaper than Math.pow(x,0.25), hence this code;
		double r = Math.sqrt(c.getRadius());
		double newTheta = c.getTheta()*0.5;
		res.setValue(r*Math.cos(newTheta), r*Math.sin(newTheta));
	}
}
