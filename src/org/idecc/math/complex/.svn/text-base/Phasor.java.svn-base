package org.idecc.math.complex;

import org.idecc.math.Point;

public class Phasor extends Point
{
	public Phasor() { super(0,0); }
	public Phasor(double r, double theta) { super(r,theta); }
	public Phasor(Phasor p) { super(p.getRadius(),p.getTheta()); }
	
	public void setValue(Phasor c) { this.x = c.x; this.y = c.y; }
	public double getRadius() { return x; }
	public double getTheta() { return y; }
	public void setRadius(double r) { x = r; }
	public void setTheta(double t) { y = t; }

	public void setValue(Complex c) {
		x = c.getRadius();
		y = c.getTheta();
	}
	public double getReal() {
		return x*Math.cos(y);
	}
	public double getImaginary() {
		return x*Math.sin(y);
	}
}
