package org.idecc.math.real;

public class RealStack {
	protected double[] _darr;
	protected int _sptr;
	
	public RealStack(int reserve) {
		_darr = new double[reserve];
		_sptr = 0;
	}
	public double pop() {
		return _darr[--_sptr];
	}
	public void push(double d) {
		_darr[_sptr++] = d;
	}
	public double top() { return _darr[_sptr-1]; }
	public boolean isEmpty() { return (_sptr == 0); }
}
