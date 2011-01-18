package org.idecc.math.real;

public class RealVariable implements org.idecc.math.real.rpn.RPNElement
{
	protected double _def_val;
	protected String _var_name;
	protected int _vnum;


	public RealVariable(int vn)
	{
		this(vn,null,0.0);
	}
	public RealVariable(int vn, String nm)
	{
		this(vn,nm,0.0);
	}
	public RealVariable(int vn, String nm, double val)
	{
		_vnum = vn;
		_var_name = nm; _def_val = val;
	}

	public void setName(String name) { _var_name = name; }
	public String getName() { return _var_name; }
	public void setValue(double v) { _def_val = v; }
	public double getValue() { return _def_val; }
	public int getVariableIndex() { return _vnum; }
	
	public double performStackOperation(RealStack st)
	{
		return _def_val;
	}
	public boolean isOperator() { return false; }
}