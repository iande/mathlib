package org.idecc.math.xmetrics;

public class CrossMetric extends org.idecc.math.MetricCalculator
{
	public double calculateMetric(org.idecc.math.Point c)
	{
		double absReal = Math.abs(c.x);
		double absImag = Math.abs(c.y);
		return (absReal < absImag) ? absReal : absImag;
	}
}