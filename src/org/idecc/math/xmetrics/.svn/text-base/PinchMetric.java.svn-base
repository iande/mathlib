package org.idecc.math.xmetrics;

public class PinchMetric extends org.idecc.math.MetricCalculator
{
	public double calculateMetric(org.idecc.math.Point c)
	{
		double atan2 = Math.atan2(c.y,c.x);
		return Math.sqrt(c.magnitude()) / Math.abs(Math.sin(atan2*2));
	}
	
	/*
	double atan2 = Math.atan2(c.y,c.x);
		return c.magnitudeSquared() / Math.abs(Math.sin(atan2*2));
	*/
}