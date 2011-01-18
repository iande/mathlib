package org.idecc.math.xmetrics;

public class SpiralMetric extends org.idecc.math.MetricCalculator
{
	public double calculateMetric(org.idecc.math.Point c)
	{
		double ntheta = Math.atan(c.y/c.x) + Math.PI / (2 * c.magnitude());
		if(ntheta > Math.PI/2) {
			ntheta -= (((int) ( (ntheta - Math.PI/2) / Math.PI) + 1)*Math.PI);
		}
		return ntheta;
	}
}