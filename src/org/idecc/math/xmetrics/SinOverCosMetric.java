package org.idecc.math.xmetrics;

public class SinOverCosMetric extends org.idecc.math.MetricCalculator
{
	public double calculateMetric(org.idecc.math.Point c)
	{
		double mag = c.magnitude();
		return Math.abs(Math.sin(mag)/Math.cos(mag));
	}
}