package org.idecc.math.graphics;


public class TrapOnlyOrbitTrapMethod extends OrbitTrapMethod
{
	protected float _use_dist;
	protected boolean _use_dist_set;
	
	public void initializeMethod() {
		_use_dist_set = false;
	}
	public void addDistance(float d) {
		if(!_use_dist_set)
		{
			_use_dist = d;
			_use_dist_set = true;
		}
	}
	public float getFinalDistance() { return _use_dist; }
	public boolean continueCalculating() { return !_use_dist_set; }
}
