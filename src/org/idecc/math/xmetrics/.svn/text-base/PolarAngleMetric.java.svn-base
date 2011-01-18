package org.idecc.math.xmetrics;

public class PolarAngleMetric extends org.idecc.math.MetricCalculator
{
	public double calculateMetric(org.idecc.math.Point c)
	{
		double r = c.x;
		double i = c.y;
		double toadd = 0.0;
		if(r < 0)
		{
			toadd = Math.PI;
		} else if(i < 0) {
			toadd = Math.PI*2;
		}
		double theta = Math.atan(i/r)+toadd;
		return 4* theta / Math.PI;
	}
}
