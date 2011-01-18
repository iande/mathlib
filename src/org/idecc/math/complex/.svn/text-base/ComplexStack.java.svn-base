package org.idecc.math.complex;

public class ComplexStack {
	protected Complex[] _darr;
	protected int _sptr;
	
	public ComplexStack(int reserve) {
		_darr = new Complex[reserve];
		for(int i=0; i < reserve; i++) {
			_darr[i] = new Complex();
		}
		_sptr = 0;
	}
	public Complex pop() {
		return _darr[--_sptr];
	}
	public void push(Complex d) {
		_darr[_sptr++].setValue(d);
	}
	public Complex top() { return _darr[_sptr-1]; }
	public boolean isEmpty() { return (_sptr == 0); }
}
