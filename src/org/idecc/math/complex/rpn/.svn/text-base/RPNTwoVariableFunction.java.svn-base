package org.idecc.math.complex.rpn;

import org.idecc.math.complex.TwoVariableComplexFunction;
import org.idecc.math.complex.Complex;
import org.idecc.math.complex.ComplexVariable;
import org.idecc.math.complex.ComplexStack;
import java.util.Hashtable;
import java.util.Vector;

public class RPNTwoVariableFunction extends TwoVariableComplexFunction
{
	// This will store the actual stack.  Important point: we do NOT want this to ever actually be modified.
	// When we perform an operation, we merely store the item on the top of the stack and move the stack pointer.
	// we do NOT actually pop anything off this stack!
	protected Vector _raw_stack;

	// The stack where all operands and the evaluation of operands with operators are stored.
	// To be safe, this should be allocated to the total number of non-operators contained in the stack.
	protected ComplexStack _eval_stack;
	protected Complex _res_store;

	protected int _non_op_count;
	protected boolean _stack_finalized;
	protected ComplexVariable _vt_1, _vt_2;

	//protected String _expr;


	public RPNTwoVariableFunction()
	{
		_eval_stack = null;
		_raw_stack = new Vector();
		_non_op_count = 0;
		_stack_finalized = false;
		_res_store = new Complex();
	}

	public void pushOntoStack(RPNElement o)
	{
		if(_stack_finalized) throw new IllegalArgumentException("this stack has been finalized, it may not be altered further.");
		if(o instanceof ComplexVariable) {
			ComplexVariable v = (ComplexVariable)o;
			if(v.getVariableIndex() == 0) {
				_vt_1 = v;
			} else {
				_vt_2 = v;
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

	public int numberOfVariables() { return 2; }

	public void evaluateAt(Complex val1, Complex val2, Complex res)
	{
		if(!_stack_finalized) finalizeStack();
		_vt_1.setValue(val1);
		_vt_2.setValue(val2);
		int rss = _raw_stack.size();
		for(int stack_ptr = 0; stack_ptr < rss; stack_ptr++)
		{
			RPNElement o = (RPNElement)_raw_stack.get(stack_ptr);
			o.performStackOperation(_eval_stack,_res_store);
			_eval_stack.push(_res_store);
		}
		res.setValue(_eval_stack.pop());
	}
}