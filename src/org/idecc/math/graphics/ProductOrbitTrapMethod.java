package org.idecc.math.graphics;


public class ProductOrbitTrapMethod extends OrbitTrapMethod
{
	protected float _use_dist;
	protected boolean _use_dist_set;

	public void initializeMethod() {
		_use_dist_set = false;
	}
	public void addDistance(float d)
	{
		if(!_use_dist_set)
		{
			_use_dist = Math.abs(d);
			_use_dist_set = true;
		} else if(d <= _threshold) {
			_use_dist = _use_dist * d;
		}
	}
	public float getFinalDistance() { return Math.abs(_use_dist); }
	public boolean continueCalculating() { return true; }
}
