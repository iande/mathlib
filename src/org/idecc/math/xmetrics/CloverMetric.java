package org.idecc.math.xmetrics;

public class CloverMetric extends org.idecc.math.MetricCalculator
{
	public double calculateMetric(org.idecc.math.Point c)
	{
		double atan2 = Math.atan2(c.y,c.x);
		return c.magnitudeSquared() / Math.abs(Math.sin(atan2*2));
	}
}