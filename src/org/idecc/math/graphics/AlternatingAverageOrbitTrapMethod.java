package org.idecc.math.graphics;

public class AlternatingAverageOrbitTrapMethod extends OrbitTrapMethod
{
	protected float _use_dist;
	protected boolean _use_dist_set;
	protected int _pt_cnt;
	protected int _sign_mod;

	public void initializeMethod()
	{
		_sign_mod = 1;
		_use_dist_set = false;
		_pt_cnt = 0;
	}
	public void addDistance(float d)
	{
		if(!_use_dist_set)
		{
			_use_dist = d;
			_use_dist_set = true;
			_pt_cnt = 1;
		} else if(d <= _threshold) {
			_sign_mod *= -1;
			_use_dist = (_use_dist*_pt_cnt + _sign_mod*d) / (_pt_cnt+1);
			_pt_cnt++;
		}
	}
	public float getFinalDistance() { return Math.abs(_use_dist); }
	public boolean continueCalculating() { return true; }
}
