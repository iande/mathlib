package org.idecc.math.xmetrics;

public class ImaginaryProportionMetric extends org.idecc.math.MetricCalculator
{
	public double calculateMetric(org.idecc.math.Point c)
	{
		return Math.abs(c.y) / c.magnitude();
	}
}
