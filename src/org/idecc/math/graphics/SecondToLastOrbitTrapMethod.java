package org.idecc.math.graphics;


public class SecondToLastOrbitTrapMethod extends OrbitTrapMethod
{
	protected float _use_dist;
	protected float _last;
	protected boolean _use_dist_set;
	
	public void initializeMethod()
	{
		_use_dist_set = false;
	}
	public void addDistance(float d)
	{
		if(!_use_dist_set)
		{
			_use_dist_set = true;
			_use_dist = d;
			_last = d;
		} else if(d < _threshold) {
			_use_dist = _last;
			_last = d;
		}
	}
	public float getFinalDistance() { return _use_dist; }
	public boolean continueCalculating() { return true; }
}
