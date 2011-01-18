package org.idecc.math.xmetrics;

public class RealProportionMetric extends org.idecc.math.MetricCalculator
{
	public double calculateMetric(org.idecc.math.Point c)
	{
		return Math.abs(c.x) / c.magnitude();
	}
}
