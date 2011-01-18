package org.idecc.math.graphics;


public class SecondOrbitTrapMethod extends OrbitTrapMethod
{
	protected float _use_dist;
	protected boolean _use_dist_set;
	protected boolean _cont_dist;
	protected boolean _get_second;
	
	public void initializeMethod() {
		_use_dist_set = false;
		_cont_dist = true;
		_get_second = false;
	}
	public void addDistance(float d) {
		if(!_cont_dist) return;
		if(!_use_dist_set)
		{
			_use_dist_set = true;
			_use_dist = d;
		} else if(d < _threshold) {
			if(_get_second)
			{
				_use_dist = d;
				_cont_dist = false;
			} else {
				_use_dist = d;
				_get_second = true;
			}
		}
	}
	public float getFinalDistance() { return _use_dist; }	
	public boolean continueCalculating() { return _cont_dist; }
}
