package org.idecc.math.complex;

public class ArcCosine extends OneVariableComplexFunction {
	public void evaluateAt(Complex c, Complex res) {
		double rc = c.getReal();
		double ic = c.getImaginary();
		// set res = z + sqrt(c^2 - 1)
		res.setValue(rc*rc + ic*ic - 1, 2*rc*ic);
		double a = res.getReal();
		double b = res.getImaginary();
		double newTheta = res.getTheta()*0.5;
		double r = Math.sqrt(Math.sqrt(a*a + b*b));
		res.setValue(r*Math.cos(newTheta) + rc, r*Math.sin(newTheta) + ic);
		
		// set res = -i*ln(res)
		res.setValue(res.getTheta(), -0.5*Math.log(res.magnitudeSquared()));
	}
}
