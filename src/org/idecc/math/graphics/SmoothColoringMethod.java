package org.idecc.math.graphics;

public class SmoothColoringMethod implements CFColoringMethod
{
	/*
		Thanks to Ron Barnett for the formula to this coloring method:
			s_{n+1} = s_{n} + e^{-||z_{n+1}||}
	*/
	protected float _cur_val;
	public SmoothColoringMethod() { _cur_val = 0.0f; }
	public void measurePoint(org.idecc.math.complex.Complex c) { _cur_val += Math.exp(-1.0*c.magnitude()) * 0.08; }
	public float getFinalMeasurement() { return _cur_val; }
	public void initializeColoring() { _cur_val = 0.0f; }
}