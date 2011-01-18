package org.idecc.math.complex;
import org.idecc.math.complex.rpn.RPNElement;

public class ComplexParameter implements RPNElement
{
	protected Complex _def_val;
	protected String _var_name;


	public ComplexParameter()
	{
		this(null,null);
	}
	public ComplexParameter(String nm)
	{
		this(nm,null);
	}
	public ComplexParameter(String nm, Complex val)
	{
		_var_name = nm;
		_def_val = new Complex();
		if(val != null) _def_val.setValue(val);
	}

	public void setName(String name) { _var_name = name; }
	public String getName() { return _var_name; }
	public void setValue(Complex v) { _def_val.setValue(v); }
	public void setValue(double a, double b) { _def_val.setValue(a,b); }
	public Complex getValue() { return _def_val; }
	
	public void performStackOperation(ComplexStack st, Complex store)
	{
		store.setValue(_def_val);
	}
	public boolean isOperator() { return false; }
}