package org.idecc.math.real.rpn;

import java.util.Hashtable;
import java.util.Vector;
import org.idecc.math.real.RealVariable;
import org.idecc.math.real.Real;
import org.idecc.math.real.RealStack;
import org.idecc.math.real.RealFunction;

public class RPNFunction implements RealFunction
{
	// This will store the actual stack.  Important point: we do NOT want this to ever actually be modified.
	// When we perform an operation, we merely store the item on the top of the stack and move the stack pointer.
	// we do NOT actually pop anything off this stack!
	protected Vector _raw_stack;

	// The stack where all operands and the evaluation of operands with operators are stored.
	// To be safe, this should be allocated to the total number of non-operators contained in the stack.
	protected RealStack _eval_stack;

	protected int _non_op_count, _num_vars;
	protected boolean _stack_finalized;
	protected double[] _var_arr;
	protected RealVariable[] _vt_arr;

	//protected String _expr;


	public RPNFunction(int numvars)
	{
		_eval_stack = null;
		_raw_stack = new Vector();
		_non_op_count = 0;
		_stack_finalized = false;
		_num_vars = numvars;
		_var_arr = new double[numvars];
		_vt_arr = new RealVariable[numvars];
	}
	
	public void pushOntoStack(double d) {
		if(_stack_finalized) throw new IllegalArgumentException("this stack has been finalized, it may not be altered further.");
		pushOntoStack(new Real(d));
	}


	public void pushOntoStack(RPNElement o)
	{
		if(_stack_finalized) throw new IllegalArgumentException("this stack has been finalized, it may not be altered further.");
		if(o instanceof RealVariable) {
			RealVariable v = (RealVariable)o;
			if(v.getVariableIndex() < _num_vars) {
				_vt_arr[v.getVariableIndex()] = v;
			} else {
				throw new IllegalArgumentException("variable index exceeds alloted number of variables.");
			}
		}
		_raw_stack.add(o);
		if(!o.isOperator()) {
			_non_op_count++;
		}
	}

	public void finalizeStack()
	{
		_stack_finalized = true;
		_eval_stack = new RealStack(_non_op_count);
	}

	public int numberOfVariables() { return _num_vars; }

	public double evaluateAt(double[] vals)
	{
		if(!_stack_finalized) finalizeStack();
		if(vals.length != _num_vars) return Double.NaN;
		for(int i=0; i < _num_vars; i++) {
			if(_vt_arr[i] != null) {
				_vt_arr[i].setValue(vals[i]);
			}
		}
		int rss = _raw_stack.size();
		for(int stack_ptr = 0; stack_ptr < rss; stack_ptr++)
		{

			//Object o = _raw_stack.get(stack_ptr);
			RPNElement o = (RPNElement)_raw_stack.get(stack_ptr);
			_eval_stack.push( o.performStackOperation(_eval_stack) );
		}
		//return _eval_stack[--estack_ptr];
		return _eval_stack.pop();
	}
	
	public boolean isOperator() { return true; }
	public double performStackOperation(RealStack st) {
		int idx;
		for(int i=0; i < _num_vars; i++) {
			idx = _num_vars - 1 - i;
			_var_arr[idx] = st.pop();
		}
		return evaluateAt(_var_arr);
	}
}