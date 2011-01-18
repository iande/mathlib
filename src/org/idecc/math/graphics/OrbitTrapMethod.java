package org.idecc.math.graphics;

public abstract class OrbitTrapMethod
{
	protected float _threshold;
	public OrbitTrapMethod() { _threshold = 0.5f; }
	public void setThreshold(float d) { _threshold = d; }
	public float getThreshold() { return _threshold; }
	public abstract void addDistance(float d);
	public abstract float getFinalDistance();
	public abstract void initializeMethod();
	public abstract boolean continueCalculating();
}
