package org.idecc.math.complex.fractal;

import org.idecc.math.complex.Complex;

public abstract class ComplexFractal {
	protected Complex _center;
	protected double _minx, _maxx;
	
	public ComplexFractal() {
		_center = new Complex();
		_minx = -2.0;
		_maxx = 2.0;
	}
	
	public abstract void initializeFractal();
	public abstract void initializeRendering();
	public abstract void iterate(Complex z, Complex c);
	public abstract boolean test(Complex z);
	
	public void setCenter(double r, double i) { _center.setValue(r,i); }
	public Complex getCenter() { return _center; }
	public double getDefaultMinimumX() { return _minx; }
	public double getDefaultMaximumX() { return _maxx; }
	public void setDefaultMinimumX(double minx) { _minx = minx; }
	public void setDefaultMaximumX(double maxx) { _maxx = maxx; }
	public void setDefaultRange(double minx, double maxx) { _minx = minx; _maxx = maxx; }
}
