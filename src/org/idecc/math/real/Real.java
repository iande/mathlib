package org.idecc.math.real;

public class Real implements org.idecc.math.real.rpn.RPNElement {
	protected double _val;
	
	public Real(double v) {
		_val = v;
	}
	public Real() { this(0.0); }
	
	public void setValue(double v) { _val = v; }
	public double getValue() { return _val; }
	
	public double magnitude() { return Math.abs(_val); }
	public double magnitudeSquared() { return _val*_val; }
	
	public double performStackOperation(RealStack st)
	{
		return _val;
	}
	public boolean isOperator() { return false; }
}
