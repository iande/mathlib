package org.idecc.math.complex.fractal;

import org.idecc.math.complex.TwoVariableComplexFunction;
import org.idecc.math.complex.Complex;

public class FunctionalComplexFractal extends ComplexFractal
{
	protected TwoVariableComplexFunction _rpn_eval;
	protected FractalTest _test;

	public FunctionalComplexFractal() { super(); }
	
	public void setFunction(TwoVariableComplexFunction f) { _rpn_eval = f; }
	public TwoVariableComplexFunction getFunction() { return _rpn_eval; }
	public FractalTest getTest() { return _test; }
	public void setTest(FractalTest t) { _test = t; }
	
	public void initializeFractal() { }
	public void initializeRendering() { }
	
	public void iterate(Complex z, Complex c) {
		if(_rpn_eval == null) { return; }
		_rpn_eval.evaluateAt(z,c,z);
	}
	public boolean test(Complex z) {
		if(_test == null) return false;
		return _test.test(z);
	}
}