package org.idecc.math.real;

import java.util.Hashtable;
import java.util.Vector;

// Now that this works, I want to refine it.

// I want to take it out of .graphics and put it in .real.
// Moreover, we're going to build a fully 2d array of the point data,
// and keep the path stuff separate from all of this.
// Also, you're a total douche.  You don't need ODESelf, ODELookup will work exactly
// the same way.

public class ODESystem
{
	public static final int RUNGE_KUTTA = 1;
	public static final int EULER = 2;

	protected double[][] _eval_steps;
	protected Hashtable _lookups;
	protected Vector _des;
	protected int _num_solve, _steps, _cur_valstep;
	protected double _min,_max;
	protected boolean _sys_final;
	protected RealVariable _time;


	public ODESystem()
	{
		_lookups = new Hashtable();
		_des = new Vector();
		_num_solve = RUNGE_KUTTA;
		_steps = 100;
		_sys_final = false;
		_cur_valstep = 0;
		_time = new RealVariable(0,"t");
	}

	public void setSteps(int t)
	{
		_steps = t;
	}
	public int getSteps() { return _steps; }
	public void setInterval(double min, double max)
	{
		_min = min; _max = max;
	}
	public void setMinimum(double min)
	{
		_min = min;
	}
	public void setMaximum(double max)
	{
		_max = max;
	}
	public double getMinimum() { return _min; }
	public double getMaximum() { return _max; }

	public ODEFunction reserveFunction(String fnname)
	{
		_lookups.put(fnname,new ODELookup(_des.size()));
		_des.add(new ODEFunction(this));
		return (ODEFunction)_des.get(_des.size()-1);
	}
	public RealVariable getTimeVariable() { return _time; }
	public ODELookup getODELookup(String fname)
	{
		return (ODELookup)_lookups.get(fname);
	}
	public void finalizeSystem()
	{
		_eval_steps = new double[_des.size()+1][_steps+1];
		_sys_final = true;
	}
	public double valueLookup(ODELookup de)
	{
		return _eval_steps[de.getFunctionIndex()+1][_cur_valstep-1];
	}

	public void setSolver(int sol)
	{
		_num_solve = sol;
	}

	public void setInitialConditions(double initconds[])
	{
		if(!_sys_final) finalizeSystem();
		if(initconds.length == (_eval_steps.length-1))
		{
			for(int i=0; i < initconds.length; i++)
			{
				_eval_steps[i+1][0] = initconds[i];
			}
		}
	}

	public void buildTable()
	{
		if(!_sys_final) finalizeSystem();

		double dt = (_max - _min) / _steps;
		double yp;
		double curt;
		_eval_steps[0][0] = curt = _min;


		switch (_num_solve)
		{
			case EULER:
				for(_cur_valstep=1; _cur_valstep <= _steps; _cur_valstep++)
				{
					_eval_steps[0][_cur_valstep] = curt;
					for(int j=0; j < _des.size(); j++)
					{
						ODEFunction de = (ODEFunction)_des.get(j);
						yp = _eval_steps[j+1][_cur_valstep-1];
						_eval_steps[j+1][_cur_valstep] = yp + dt*de.evaluateAt(curt,yp);
					}
					curt += dt;
				}
				break;
			default:
				double k1,k2,k3,k4;
				for(_cur_valstep=1; _cur_valstep <= _steps; _cur_valstep++)
				{
					_eval_steps[0][_cur_valstep] = curt;
					for(int j=0; j < _des.size(); j++)
					{
						ODEFunction de = (ODEFunction)_des.get(j);
						yp = _eval_steps[j+1][_cur_valstep-1];
						k1 = dt*de.evaluateAt(curt,yp);
						k2 = dt*de.evaluateAt(curt+0.5*dt,yp+0.5*k1);
						k3 = dt*de.evaluateAt(curt+0.5*dt,yp+0.5*k2);
						k4 = dt*de.evaluateAt(curt+dt,yp+k3);
						_eval_steps[j+1][_cur_valstep] = yp + k1/6.0 + k2/3.0 + k3/3.0 + k4/6.0;
					}
					curt += dt;
				}
				break;
		}
	}

	public double[][] getRawTable() { return _eval_steps; }
	public double[][] getTable(String[] vars, double[][] store)
	{
		if(store.length == vars.length)
		{
			for(int i=0; i < vars.length; i++)
			{
				ODELookup look = getODELookup(vars[i]);
				int idx = (look == null) ? 0 : look.getFunctionIndex()+1;
				for(int j=0; j < store[i].length; j++)
				{
					store[i][j] = _eval_steps[idx][j];
				}
			}
		}
		return store;
	}

	public class ODELookup
	{
		protected int _fn_id;


		public ODELookup(int id)
		{
			_fn_id = id;
		}
		public int getFunctionIndex() { return _fn_id; }
	}
}