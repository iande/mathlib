package org.idecc.math.complex;

public class ArcSine extends OneVariableComplexFunction {
	public void evaluateAt(Complex c, Complex res) {
		double rc = c.getReal();
		double ic = c.getImaginary();
		// set res = ic + sqrt(1 - c^2)
		res.setValue(1 - rc*rc + ic*ic,-2*rc*ic);
		double a = res.getReal();
		double b = res.getImaginary();
		double newTheta = res.getTheta()*0.5;
		double r = Math.sqrt(Math.sqrt(a*a + b*b));
		res.setValue(r*Math.cos(newTheta) - ic, r*Math.sin(newTheta) + rc);
		
		// set res = -i*ln(res)
		res.setValue(res.getTheta(), -0.5*Math.log(res.magnitudeSquared()));
	}
}
