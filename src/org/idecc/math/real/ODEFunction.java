package org.idecc.math.real;

import java.util.Hashtable;
import java.util.Vector;


// This class serves to merely evaluate the Derivative of a function.
// The ODE System will take the evaluated value here and use some Numerical Integration Technique to
// actually determine the Functional value.
public class ODEFunction
{
	// This will store the actual stack.  Important point: we do NOT want this to ever actually be modified.
	// When we perform an operation, we merely store the item on the top of the stack and move the stack pointer.
	// we do NOT actually pop anything off this stack!
	protected Vector _raw_stack;

	// The stack where all operands and the evaluation of operands with operators are stored.
	// To be safe, this should be allocated to the total number of non-operators contained in the stack.
	protected double _eval_stack[];

	protected int _non_op_count;
	protected boolean _stack_finalized;

	protected ODESystem _sys;

	// Variables to permit functions of functions
	protected double _var_arr[];
	protected int _max_numvars;

	protected ODESelf _myself;


	public ODEFunction(ODESystem sys)
	{
		_eval_stack = null;
		_raw_stack = new Vector();
		_non_op_count = 0;
		_stack_finalized = false;
		_max_numvars = 0;
		_sys = sys;
		_myself = new ODESelf();
	}

	public ODESelf getSelf() { return _myself; }


	public void pushOntoStack(Object o)
	{
		// Create generic ODEObject class and adapters to convert
		// existing data types into ODEObjects, then we can remove all of these instanceof's.
		if(_stack_finalized) throw new IllegalArgumentException("this stack has been finalized, it may not be altered further.");
		if(o instanceof BinaryOperator || o instanceof UnaryOperator)
		{
			_raw_stack.add(o);
		} else if(o instanceof RealFunction) {
			int nv = ((RealFunction)o).numberOfVariables();
			if (nv > _max_numvars) _max_numvars = nv;
			_raw_stack.add(o);
		} else if(o instanceof Double || o instanceof RealVariable || o instanceof RealParameter || o instanceof ODESystem.ODELookup || o instanceof ODESelf) {
			_raw_stack.add(o);
			_non_op_count++;
		} else {
			throw new IllegalArgumentException("the supplied parameter is not allowed in an ODE stack");
		}
	}

	public void finalizeStack()
	{
		_stack_finalized = true;
		_eval_stack = new double[_non_op_count];
		_var_arr = new double[_max_numvars];
	}

	public double evaluateAt(double val, double self)
	{
		if(!_stack_finalized) finalizeStack();
		int estack_ptr = 0;
		for(int stack_ptr = 0; stack_ptr < _raw_stack.size(); stack_ptr++)
		{
		// Create generic ODEObject class and adapters to convert
		// existing data types into ODEObjects, then we can remove all of these instanceof's.
			Object o = _raw_stack.get(stack_ptr);
			if(o instanceof RealVariable)
			{
				_eval_stack[estack_ptr++] = val;
			} else if(o instanceof RealParameter) {
				_eval_stack[estack_ptr++] = ((RealParameter)o).getValue();
			} else if(o instanceof Double) {
				_eval_stack[estack_ptr++] = ((Double)o).doubleValue();
			} else if(o instanceof ODESystem.ODELookup) {
				_eval_stack[estack_ptr++] = _sys.valueLookup((ODESystem.ODELookup)o);
			} else if(o instanceof ODESelf) {
				_eval_stack[estack_ptr++] = self;
			} else if(o instanceof BinaryOperator) {
				double op2 = _eval_stack[--estack_ptr];
				double op1 = _eval_stack[--estack_ptr];
				_eval_stack[estack_ptr] = ((BinaryOperator)o).performBinaryOperation(op1,op2);
				estack_ptr++;
			} else if(o instanceof UnaryOperator) {
				double op1 = _eval_stack[--estack_ptr];
				_eval_stack[estack_ptr++] = ((UnaryOperator)o).performUnaryOperation(op1);
			} else if(o instanceof RealFunction) {
				RealFunction rf = (RealFunction)o;
				int nv = rf.numberOfVariables();
				for(int k=0; k < nv; k++)
				{
					_var_arr[(nv-1)-k] = _eval_stack[--estack_ptr];
				}
				_eval_stack[estack_ptr] = rf.evaluateAt(_var_arr);
				estack_ptr++;
			}
		}
		return _eval_stack[--estack_ptr];
	}

	public class ODESelf
	{
		public ODESelf()
		{
		}
	}
}