package org.idecc.math;

public class MaximumMetric extends MetricCalculator
{
	public double calculateMetric(Point pt)
	{
		return Math.max(Math.abs(pt.x),Math.abs(pt.y));
	}
}
