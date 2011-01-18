package org.idecc.math.graphics;

import org.idecc.math.complex.OneVariableComplexFunction;
import org.idecc.math.complex.TwoVariableComplexFunction;
import org.idecc.math.complex.Complex;
import org.idecc.math.complex.fractal.ComplexFractal;
import org.idecc.math.real.OneVariableRealFunction;
import org.idecc.math.real.TwoVariableRealFunction;
import org.idecc.math.real.ODESystem;

public final class PlotFactory
{
	public static final int PLOT_REAL=1;
	public static final int PLOT_IMAGINARY=2;

	// Not to be instantiated.
	protected PlotFactory() { }

	public static Path createFractalIterationPath(ComplexFractal f, int var, Complex init, Complex param,
		int iters)
	{
		Path p = new Path();
		for(int i=0; i <= iters; i++)
		{
			if(var == PLOT_REAL)
			{
				p.addPoint(i,init.getReal());
			} else {
				p.addPoint(i,init.getImaginary());
			}
			f.iterate(init,param);
		}
		return p;
	}

	public static Path createFractalVariationPath(ComplexFractal f, int var, Complex init, int iters,
		double min, double max, int steps)
	{
		Path p = new Path();
		Complex cstor = new Complex();
		Complex para = new Complex();
		double incr = (max-min) / steps;
		double curt = min;
		for(int i=0; i <= steps; i++)
		{
			cstor.setValue(init);
			if(var == PLOT_REAL) para.setValue(curt,0);
			else para.setValue(0,curt);
			for(int j=0; j < iters; j++)
			{
				f.iterate(cstor,para);
			}
			if(var == PLOT_REAL) p.addPoint(curt,cstor.getReal());
			else p.addPoint(curt,cstor.getImaginary());
			curt+= incr;
		}
		return p;
	}

	public static Path createFractalVariationPoints(ComplexFractal f, int var, Complex init, int iters,
		double min, double max, int steps)
	{
		Path p = new Path();
		Complex cstor = new Complex();
		Complex para = new Complex();
		double incr = (max-min) / steps;
		double curt = min;
		for(int i=0; i <= steps; i++)
		{
			cstor.setValue(init);
			if(var == PLOT_REAL) para.setValue(curt,0);
			else para.setValue(0,curt);
			for(int j=0; j < iters; j++)
			{
				if(var == PLOT_REAL)
				{
					p.addPoint(curt,cstor.getReal());
				} else {
					p.addPoint(curt,cstor.getImaginary());
				}
				f.iterate(cstor,para);
			}
			curt+= incr;
		}
		return p;
	}

	public static Path createRealFunctionPath(OneVariableRealFunction sfr, double min, double max, int steps)
	{
		Path p = new Path();
		double incr = (max - min) / steps;
		double curt = min;
		for(int i=0; i <= steps; i++)
		{
			p.addPoint(curt,sfr.evaluateAt(curt));
			curt += incr;
		}
		return p;
	}

	public static Path createRealParametricPath(OneVariableRealFunction x, OneVariableRealFunction y, double min, double max, int steps)
	{
		Path p = new Path();
		double incr = (max - min) / steps;
		double curt = min;
		for(int i=0; i <= steps; i++)
		{
			p.addPoint(x.evaluateAt(curt),y.evaluateAt(curt));
			curt += incr;
		}
		return p;
	}

	public static Flow createRealFunctionFlow(OneVariableRealFunction sfr, double xmin, double xmax, double ymin, double ymax, int xsteps, int ysteps)
	{
		Flow f = new Flow();
		double incr = (xmax - xmin) / xsteps;
		double incry = (ymax - ymin) / ysteps;
		double cury,curt,m;
		curt = xmin;
		for(int i=0; i <= xsteps; i++)
		{
			m = sfr.evaluateAt(curt);
			cury = ymin;
			for(int j=0; j <= ysteps; j++)
			{
				f.addPoint(curt,cury,m);
				cury += incry;
			}
			curt += incr;
		}
		return f;
	}

	public static Path createODESystemPath(ODESystem sys, String axes[])
	{
		Path p = new Path();
		sys.buildTable();
		double store[][] = new double[2][sys.getSteps()];
		sys.getTable(axes,store);
		for(int i=0; i < store[0].length; i++)
		{
			p.addPoint(store[0][i],store[1][i]);
		}
		return p;
	}
	
	public static HeightField createRealHeightField(TwoVariableRealFunction r, double min, double max, int steps) {
		return createRealHeightField(r,min,min,max,max,steps,steps);
	}
	
	public static HeightField createRealHeightField(TwoVariableRealFunction r, double minx, double miny, double maxx, double maxy, int hsteps, int vsteps) {
		HeightField hf = new HeightField(hsteps,vsteps,new GraphBounds(minx,miny,maxx,maxy));
		double incrx = (maxx - minx) / hsteps;
		double curx = minx;
		double incry = (maxy - miny) / vsteps;
		double cury = miny;
		for(int i=0; i < hsteps; i++) {
			for(int j=0; j < vsteps; j++) {
				hf.setHeight(i,j,r.evaluateAt(curx,cury));
				cury += incry;
			}
			curx += incrx;
			cury = miny;
		}
		return hf;
	}
	
	public static HeightField createComplexRealHeightField(OneVariableComplexFunction c, double min, double max, int steps) {
		return createComplexRealHeightField(c,min,min,max,max,steps,steps);
	}
	public static HeightField createComplexImaginaryHeightField(OneVariableComplexFunction c, double min, double max, int steps) {
		return createComplexImaginaryHeightField(c,min,min,max,max,steps,steps);
	}
	public static HeightField createComplexMagnitudeHeightField(OneVariableComplexFunction c, double min, double max, int steps) {
		return createComplexMagnitudeHeightField(c,min,min,max,max,steps,steps);
	}
	public static HeightField createComplexRealHeightField(OneVariableComplexFunction c, double minx, double miny, double maxx, double maxy, int hsteps, int vsteps) {
		HeightField hf = new HeightField(hsteps,vsteps,new GraphBounds(minx,miny,maxx,maxy));
		double incrx = (maxx - minx) / hsteps;
		double curx = minx;
		double incry = (maxy - miny) / vsteps;
		double cury = miny;
		Complex res = new Complex();
		Complex eval = new Complex(curx,cury);
		for(int i=0; i < hsteps; i++) {
			for(int j=0; j < vsteps; j++) {
				c.evaluateAt(eval,res);
				hf.setHeight(i,j,res.getReal());
				cury += incry;
				eval.setValue(curx,cury);
			}
			curx += incrx;
			cury = miny;
		}
		return hf;
	}
	public static HeightField createComplexImaginaryHeightField(OneVariableComplexFunction c, double minx, double miny, double maxx, double maxy, int hsteps, int vsteps) {
		HeightField hf = new HeightField(hsteps,vsteps,new GraphBounds(minx,miny,maxx,maxy));
		double incrx = (maxx - minx) / hsteps;
		double curx = minx;
		double incry = (maxy - miny) / vsteps;
		double cury = miny;
		Complex res = new Complex();
		Complex eval = new Complex(curx,cury);
		for(int i=0; i < hsteps; i++) {
			for(int j=0; j < vsteps; j++) {
				c.evaluateAt(eval,res);
				hf.setHeight(i,j,res.getImaginary());
				cury += incry;
				eval.setValue(curx,cury);
			}
			curx += incrx;
			cury = miny;
		}
		return hf;
	}
	public static HeightField createComplexMagnitudeHeightField(OneVariableComplexFunction c, double minx, double miny, double maxx, double maxy, int hsteps, int vsteps) {
		HeightField hf = new HeightField(hsteps,vsteps,new GraphBounds(minx,miny,maxx,maxy));
		double incrx = (maxx - minx) / hsteps;
		double curx = minx;
		double incry = (maxy - miny) / vsteps;
		double cury = miny;
		Complex res = new Complex();
		Complex eval = new Complex(curx,cury);
		for(int i=0; i < hsteps; i++) {
			for(int j=0; j < vsteps; j++) {
				c.evaluateAt(eval,res);
				hf.setHeight(i,j,res.magnitude());
				cury += incry;
				eval.setValue(curx,cury);
			}
			curx += incrx;
			cury = miny;
		}
		return hf;
	}
}