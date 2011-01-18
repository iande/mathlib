package org.idecc.math.real;

public class RealParameter implements org.idecc.math.real.rpn.RPNElement
{
	protected double _def_val;
	protected String _var_name;


	public RealParameter()
	{
		this(null,0.0);
	}
	public RealParameter(String nm)
	{
		this(nm,0.0);
	}
	public RealParameter(String nm, double val)
	{
		_var_name = nm; _def_val = val;
	}

	public void setName(String name) { _var_name = name; }
	public String getName() { return _var_name; }
	public void setValue(double v) { _def_val = v; }
	public double getValue() { return _def_val; }
	
	public double performStackOperation(RealStack st)
	{
		return _def_val;
	}
	public boolean isOperator() { return false; }
}