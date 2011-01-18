package org.idecc.math.graphics;

import org.idecc.math.complex.Complex;
import org.idecc.math.MetricCalculator;

public class OrbitTrapColoringMethod implements CFColoringMethod
{
	protected OrbitTrapMethod _cur_meth;
	protected MetricCalculator _distance;
	protected Complex _center,_tmp_op;

	public OrbitTrapColoringMethod(MetricCalculator dist, OrbitTrapMethod trapmeth)
	{
		_cur_meth = trapmeth;
		_distance = dist;
		_tmp_op = new Complex();
		_center = new Complex(0,0);
	}

	public void setThreshold(float d)
	{
		_cur_meth.setThreshold(d);
	}
	public double getThreshold() { return _cur_meth.getThreshold(); }
	public void setCenter(double r, double i) { _center.setValue(r,i); };
	public Complex getCenter() { return _center; }
	public void setTrappingMethod(OrbitTrapMethod orb) { _cur_meth = orb; }
	public void setDistanceCalculator(MetricCalculator c) { _distance = c; }
	public OrbitTrapMethod getTrappingMethod() { return _cur_meth; }
	public MetricCalculator getDistanceCalculator() { return _distance; }

	public void measurePoint(Complex c)
	{
		if(!_cur_meth.continueCalculating()) return;
		_tmp_op.setValue(c.getReal() - _center.getReal(),c.getImaginary() - _center.getImaginary());
		float d = (float)_distance.calculateMetric(_tmp_op);
		_cur_meth.addDistance(d);
	}

	public float getFinalMeasurement() { return _cur_meth.getFinalDistance(); }

	public void initializeColoring() { _cur_meth.initializeMethod(); }
}