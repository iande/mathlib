package org.idecc.math.complex;
import org.idecc.math.complex.rpn.RPNElement;
import org.idecc.math.Point;

public class Complex extends Point implements RPNElement
{
	public Complex() { super(0,0); }
	public Complex(double r, double i) { super(r,i); }
	public Complex(Complex c) { super(c.getReal(),c.getImaginary()); }

	public void setValue(Complex c) { this.x = c.x; this.y = c.y; }
	public double getReal() { return this.x; }
	public double getImaginary() { return this.y; }
	public void setReal(double r) { this.x = r; }
	public void setImaginary(double i) { this.y = i; }
	public void setValue(Phasor p) {
		this.x = p.getReal();
		this.y = p.getImaginary();
	}

	public double getRadius() { return magnitude(); }
	public double getTheta()
	{
		// We want to a range of: -pi <= theta <= pi
		if(x == 0 && y == 0) return 0.0;
		if(x < 0 && y < 0) {
			return Math.atan(y/x)-Math.PI;
		} else if(x < 0) {
			return Math.atan(y/x)+Math.PI;
		}
		return Math.atan(y/x);
	}
	
	public void performStackOperation(ComplexStack st, Complex store) {
		store.setValue(this);
	}
	public boolean isOperator() { return false; }
}
