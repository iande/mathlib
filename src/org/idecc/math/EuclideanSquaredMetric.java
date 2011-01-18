package org.idecc.math;

public class EuclideanSquaredMetric extends MetricCalculator
{
	public double calculateMetric(Point pt)
	{
		return pt.magnitudeSquared();
	}
}
