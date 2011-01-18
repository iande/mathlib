package org.idecc.math.graphics;


public class FirstOrbitTrapMethod extends OrbitTrapMethod
{
	protected float _use_dist;
	protected boolean _use_dist_set;
	protected boolean _cont_dist;
	
	public void initializeMethod()
	{
		_use_dist_set = false;
		_cont_dist = true;
	}
	public void addDistance(float d)
	{
		if(!_cont_dist) return;
		if(!_use_dist_set)
		{
			_use_dist_set = true;
			_use_dist = d;
		} else if(d <= _threshold) {
			_use_dist = d;
			_cont_dist = false;
		}
	}
	public float getFinalDistance() { return _use_dist; }
	public boolean continueCalculating() { return _cont_dist; }
}
