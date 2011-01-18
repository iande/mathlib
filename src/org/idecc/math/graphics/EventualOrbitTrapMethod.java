package org.idecc.math.graphics;


public class EventualOrbitTrapMethod extends OrbitTrapMethod
{
	protected float _use_dist;

	public void initializeMethod()
	{
	}
	public void addDistance(float d)
	{
		_use_dist = d;
	}
	public float getFinalDistance() { return _use_dist; }
	public boolean continueCalculating() { return true; }
}
