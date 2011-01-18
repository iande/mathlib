package org.idecc.math;

public class EuclideanMetric extends MetricCalculator
{
	public double calculateMetric(Point pt)
	{
		return pt.magnitude();
	}
}
