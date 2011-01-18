package org.idecc.math.xmetrics;

public class GaussianNumberMetric extends org.idecc.math.MetricCalculator
{
	public double calculateMetric(org.idecc.math.Point c)
	{
		double dx = (Math.round(c.x) - c.x);
		double dy = (Math.round(c.y) - c.y);
		return Math.sqrt(dx*dx + dy*dy)*2;
	}
}