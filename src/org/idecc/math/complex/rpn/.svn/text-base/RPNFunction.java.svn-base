package org.idecc.math.complex.rpn;

import org.idecc.math.complex.ComplexFunction;
import org.idecc.math.complex.Complex;
import org.idecc.math.complex.ComplexVariable;
import org.idecc.math.complex.ComplexStack;
import java.util.Hashtable;
import java.util.Vector;

public class RPNFunction implements ComplexFunction
{
	// This will store the actual stack.  Important point: we do NOT want this to ever actually be modified.
	// When we perform an operation, we merely store the item on the top of the stack and move the stack pointer.
	// we do NOT actually pop anything off this stack!
	protected Vector _raw_stack;

	// The stack where all operands and the evaluation of operands with operators are stored.
	// To be safe, this should be allocated to the total number of non-operators contained in the stack.
	protected ComplexStack _eval_stack;
	protected Complex _res_store;

	protected int _non_op_count, _num_vars;
	protected boolean _stack_finalized;
	protected ComplexVariable[] _vt_arr;
	protected Complex[] _var_arr;

	//protected String _expr;


	public RPNFunction(int numvars)
	{
		_eval_stack = null;
		_raw_stack = new Vector();
		_non_op_count = 0;
		_stack_finalized = false;
		_num_vars = numvars;
		_res_store = new Complex();
		_vt_arr = new ComplexVariable[numvars];
		_var_arr = new Complex[numvars];
		for(int i=0; i < numvars; i++) {
			_var_arr[i] = new Complex();
		}
	}

	public void pushOntoStack(RPNElement o)
	{
		if(_stack_finalized) throw new IllegalArgumentException("this stack has been finalized, it may not be altered further.");
		if(o instanceof ComplexVariable) {
			ComplexVariable v = (ComplexVariable)o;
			if(v.getVariableIndex() < _num_vars) {
				_vt_arr[v.getVariableIndex()] = v;
			} else {
				throw new IllegalArgumentException("variable index exceeds alloted number of variables.");
			}
		}
		_raw_stack.add(o);
		if(!o.isOperator()) { _non_op_count++; }
	}

	public void finalizeStack()
	{
		_stack_finalized = true;
		_eval_stack = new ComplexStack(_non_op_count);
	}

	public int numberOfVariables() { return _num_vars; }

	public void evaluateAt(Complex[] vals, Complex res)
	{
		if(!_stack_finalized) finalizeStack();
		if(vals.length != _num_vars) return;
		for(int i=0; i < _num_vars; i++) {
			if(_vt_arr[i] != null) {
				_vt_arr[i].setValue(vals[i]);
			}
		}
		int rss = _raw_stack.size();
		for(int stack_ptr = 0; stack_ptr < rss; stack_ptr++) {
			RPNElement o = (RPNElement)_raw_stack.get(stack_ptr);
			o.performStackOperation(_eval_stack,_res_store);
			_eval_stack.push(_res_store);
		}
		res.setValue(_eval_stack.pop());
	}
	
	public boolean isOperator() { return true; }
	public void performStackOperation(ComplexStack st, Complex store) {
		int idx;
		for(int i=0; i < _num_vars; i++) {
			idx = _num_vars - 1 - i;
			_var_arr[idx].setValue(st.pop());
		}
		evaluateAt(_var_arr,store);
	}
}