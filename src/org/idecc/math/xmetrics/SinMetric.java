package org.idecc.math.xmetrics;

public class SinMetric extends org.idecc.math.MetricCalculator
{
	public double calculateMetric(org.idecc.math.Point c)
	{
		return Math.abs(Math.sin(c.magnitudeSquared()));
	}
}