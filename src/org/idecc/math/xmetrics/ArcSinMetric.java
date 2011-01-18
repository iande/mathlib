package org.idecc.math.xmetrics;

public class ArcSinMetric extends org.idecc.math.MetricCalculator
{
	public double calculateMetric(org.idecc.math.Point c)
	{
		return Math.abs(Math.asin(c.magnitudeSquared()));
	}
}