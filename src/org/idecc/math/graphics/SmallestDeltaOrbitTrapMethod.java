package org.idecc.math.graphics;


public class SmallestDeltaOrbitTrapMethod extends OrbitTrapMethod
{
	protected float _use_dist;
	protected boolean _use_dist_set;
	protected float _last_dist;

	public void initializeMethod() {
		_use_dist_set = false;
	}
	public void addDistance(float d) {
		if(!_use_dist_set)
		{
			_use_dist_set = true;
			_use_dist = d;
			_last_dist = d;
		} else {
			float tmp = Math.abs(d - _last_dist);
			if(tmp < _use_dist) _use_dist = tmp;
			_last_dist = d;
		}
	}
	public float getFinalDistance() { return _use_dist; }
	public boolean continueCalculating() { return true; }
}
