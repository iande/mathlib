package org.idecc.math.real;

public interface RealFunction extends org.idecc.math.real.rpn.RPNElement
{
	public int numberOfVariables();
	public double evaluateAt(double vars[]);
}