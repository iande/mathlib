package org.idecc.math.complex.fractal;

import org.idecc.math.complex.Complex;
import org.idecc.math.EuclideanSquaredMetric;
import org.idecc.math.MetricCalculator;

public class ConvergenceTest implements FractalTest
{
	protected double _mdelta;
	protected Complex _z_last;
	protected boolean _z_isset;
	protected MetricCalculator _metric;

	public ConvergenceTest(double mdelta)
	{
		_mdelta = mdelta;
		_z_isset = false;
		_z_last = new Complex();
		_metric = new EuclideanSquaredMetric();
	}

	public boolean test(Complex z)
	{
		boolean converges = true;
		if(_z_isset)
		{
			converges = _metric.calculateMetric(z,_z_last) > _mdelta;
		} else {
			_z_isset = true;
		}
		if(!converges)
		{
			_z_isset = false;
		} else {
			_z_last.setValue(z);
		}
		return converges;

		//return (_metric.calculateMetric(z,_z_old) > 0.00001);
	}

}