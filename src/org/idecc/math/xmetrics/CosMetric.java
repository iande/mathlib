package org.idecc.math.xmetrics;

public class CosMetric extends org.idecc.math.MetricCalculator
{
	public double calculateMetric(org.idecc.math.Point c)
	{
		return Math.abs(Math.cos(c.magnitudeSquared()));
	}
}