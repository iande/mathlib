package org.idecc.math.xmetrics;

import org.idecc.math.complex.Complex;

public class EyeMetric extends org.idecc.math.MetricCalculator
{
	protected Complex _c1,_c2;
	protected Complex _f1,_f2;

	public EyeMetric()
	{
		_f1 = new Complex(0,-0.5);
		_f2 = new Complex(0,0.5);
		_c1 = new Complex(); _c2 = new Complex();
	}

	public double calculateMetric(org.idecc.math.Point c)
	{
		_c1.setValue(c.x,c.y + 0.5); _c2.setValue(c.x, c.y - 0.5);
		return Math.max(_c1.magnitude(),_c2.magnitude());
	}
}
