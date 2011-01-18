package org.idecc.math.graphics;

import org.idecc.image.Gradient;
import java.awt.Color;
import java.awt.Point;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.BasicStroke;
import java.awt.RenderingHints;
import java.util.Vector;
import java.util.Hashtable;
import org.idecc.math.complex.Complex;
import org.idecc.math.complex.fractal.ComplexFractal;
import org.idecc.math.event.ProgressEvent;
import org.idecc.math.event.ProgressListener;

public class CFContext extends java.awt.image.BufferedImage
{
	public static final int JULIA_FRACTAL = 1;
	public static final int MANDELBROT_FRACTAL = 2;
	
	public static final int RENDER_SKETCH = 1;
	public static final int RENDER_LINEAR = 2;
	public static final int RENDER_MULTILINEAR = 3;
	
	protected Vector _proglist;
	protected CFRenderThread _render_t;
	protected GraphBounds _bounds;
	protected boolean _rend_test[][];
	protected boolean _is_in_set[][];
	protected int _width, _height, _max_iters, _min_iters, _rend_priority, _int_col, _ext_col;
	protected Gradient _int_grad, _ext_grad;
	protected CFColoringMethod _int_col_meth, _ext_col_meth;
	//protected Complex[] _periodtest;
	protected int _fract_type, _rend_meth;
        protected long _render_tstamp;

	public CFContext(int w, int h, GraphBounds bounds) {
		super(w,h,TYPE_INT_ARGB);
		_max_iters = 100;
		_rend_priority = Thread.NORM_PRIORITY;
		_width = w;
		_height = h;
		_bounds = bounds;
		_proglist = new Vector();
		_is_in_set = new boolean[w][h];
		_fract_type = MANDELBROT_FRACTAL;
		_int_col = 0xff000000;
		_ext_col = 0xffffffff;
		_rend_meth = RENDER_SKETCH;
		_min_iters = 0;
	}
	
	public GraphBounds getBounds() { return _bounds; }
        public void setBounds(GraphBounds b) { _bounds = b; }
	
	public void setRenderPriority(int r) { _rend_priority = r; }
	public int getRenderPriority() { return _rend_priority; }
	public void setRenderMethod(int m) { _rend_meth = m; }
	public int getRenderMethod() { return _rend_meth; }
	public void setFractalType(int f) { _fract_type = f; }
	public int getFractalType() { return _fract_type; }
	public void setIterations(int i) { _max_iters = i; }
	public int getIterations() { return _max_iters; }
	public void setMinimumIterations(int i) { _min_iters = i; }
	public int getMinimumIterations() { return _min_iters; }
	

	protected void translatePoint(double x, double y, Point pt) {
		int xs = (int) ((x - _bounds.x_min) * _width / _bounds.width);
		int ys = (int) ((_bounds.y_max - y) * _height / _bounds.height);
		pt.setLocation(xs,ys);
	}
	protected void reverseTranslatePoint(int i, int j, org.idecc.math.Point pt) {
		double xs = i*_bounds.width / _width + _bounds.x_min;
		double ys = _bounds.y_max - j*_bounds.height / _height;
		pt.setValue(xs,ys);
	}
	
	public void setBoundsByFractal(ComplexFractal cf) {
		double minx = cf.getDefaultMinimumX(), maxx = cf.getDefaultMaximumX();
		double dx = maxx - minx;
		double maxy = ( dx*_height / _width ) / 2.0;
		double miny = -maxy;
		_bounds = new GraphBounds(minx,miny,maxx,maxy);
	}

	public void drawComplexFractal(ComplexFractal cf) {
		if(_render_t != null && _render_t.isActive()) {
			_render_t.kill();
			try {
				_render_t.join();
			} catch (Throwable t) {
			}
		}
		switch(_rend_meth) {
			case RENDER_LINEAR: _render_t = new CFLinear(cf); break;
			case RENDER_MULTILINEAR: _render_t = new CFMultiLinear(cf); break;
			default: _render_t = new CFBorderSketch(cf); break;
		}
		_render_t.start();
	}
	
	public void setInteriorGradient(Gradient g) { _int_grad = g; }
	public void setExteriorGradient(Gradient g) { _ext_grad = g; }
	public void setInteriorFillColor(int i) { _int_col = i; }
	public void setExteriorFillColor(int i) { _ext_col = i; }
	public void setInteriorColoringMethod(CFColoringMethod m) { _int_col_meth = m; }
        public CFColoringMethod getInteriorColoringMethod() { return _ext_col_meth; }
	public void setExteriorColoringMethod(CFColoringMethod m) { _ext_col_meth = m; }
        public CFColoringMethod getExteriorColoringMethod() { return _ext_col_meth; }

	protected void fillSquare(int i, int j, int w, int col, boolean inset) {
		if(w > 1) {
			int mi = Math.min(i+w,_width);
			int mj = Math.min(j+w,_height);
			for(int k=i; k < mi; k++) {
				for(int l=j; l < mj; l++) {
					setRGB(k,l,col);
					_is_in_set[k][l] = inset;
				}
			}
		} else {
			setRGB(i,j,col);
			_is_in_set[i][j] = inset;
		}
	}

	protected int getFractalPointColor(int i) {
		if(i == _max_iters) {
			if(_int_grad == null || _int_col_meth == null) return _int_col;
			return _int_grad.getColor(_int_col_meth.getFinalMeasurement());
		}
		if(_ext_grad == null) return _ext_col;
		if(_ext_col_meth == null) return _ext_grad.getColor( 1.0f * i / _max_iters );
		return _ext_grad.getColor(_ext_col_meth.getFinalMeasurement());
	}

	public void addProgressListener(ProgressListener p) {
		_proglist.add(p);
	}
	public void removeProgressListener(ProgressListener p) {
		_proglist.remove(p);
	}

	protected void fireProgressStarted() {
		ProgressEvent evn = new ProgressEvent(this,0.0);
                _render_tstamp = evn.getTimeStamp();
		for(int i=0; i < _proglist.size(); i++)
			((ProgressListener)_proglist.get(i)).progressStarted(evn);
	}
	protected void fireProgressUpdated(double per) {
		ProgressEvent evn = new ProgressEvent(this,per);
                evn.setStartTime(_render_tstamp);
		for(int i=0; i < _proglist.size(); i++)
			((ProgressListener)_proglist.get(i)).progressUpdated(evn);
	}
	protected void fireProgressCompleted() {
		ProgressEvent evn = new ProgressEvent(this,1.0);
                evn.setStartTime(_render_tstamp);
		for(int i=0; i < _proglist.size(); i++)
			((ProgressListener)_proglist.get(i)).progressCompleted(evn);
	}
	
	/*
	There's no benefit here, at least not doing it this way.
	Try again another time!
	protected void initPeriodChecking(int sz)
	{
		if(_periodtest == null || _periodtest.length < sz)
		{
			_periodtest = new Complex[sz];
			for(int i=0; i < sz; i++) _periodtest[i] = new Complex();
		}
	}
	protected boolean checkPeriod(Complex c, int iters)
	{
		int maxi = Math.min(_periodtest.length,iters);
		Complex t;
		for(int i=0; i < maxi; i++)
		{
			t = _periodtest[i];
			if(c.getReal() == t.getReal() && c.getImaginary() == t.getImaginary()) return true;
		}
		_periodtest[iters % _periodtest.length].setValue(c);
		return false;
	}
	*/

	protected abstract class CFRenderThread extends Thread
	{
		protected ComplexFractal _fractal;
		protected boolean _active;
		protected Complex _z, _c;

		public CFRenderThread(ComplexFractal f)
		{
			_fractal = f;
			_active = false;
			_z = new Complex();
			_c = new Complex();
			setPriority(_rend_priority);
		}

		public void kill() { _active = false; }
		public boolean isActive() { return _active; }
		
		protected void iterateFractal(Complex z, Complex c) {
			if(CFContext.this._fract_type == CFContext.JULIA_FRACTAL) {
				_fractal.iterate(c,z);
				if(CFContext.this._int_col_meth != null) CFContext.this._int_col_meth.measurePoint(c);
				if(CFContext.this._ext_col_meth != null) CFContext.this._ext_col_meth.measurePoint(c);
			} else {
				_fractal.iterate(z,c);
				if(CFContext.this._int_col_meth != null) CFContext.this._int_col_meth.measurePoint(z);
				if(CFContext.this._ext_col_meth != null) CFContext.this._ext_col_meth.measurePoint(z);
			}
		}
		
		protected void initColoringMethods() {
			if(CFContext.this._int_col_meth != null) CFContext.this._int_col_meth.initializeColoring();
			if(CFContext.this._ext_col_meth != null) CFContext.this._ext_col_meth.initializeColoring();
		}
	}

	protected class CFLinear extends CFRenderThread
	{
		public CFLinear(ComplexFractal f) { super(f); }

		public void run()
		{
			//initPeriodChecking(_fractal.getIterations()/10);
			_fractal.initializeRendering();
			_active = true;
			int iters;
			boolean dorun = true;
			int i=0, j=0;
			boolean inset;
			fireProgressStarted();
			while(dorun && _active)
			{
				_z.setValue(_fractal.getCenter());
				reverseTranslatePoint(i,j,_c);
				initColoringMethods();
				inset = true;
				for(iters = 0; iters < _max_iters; iters++)
				{
					iterateFractal(_z,_c);
					if(!_fractal.test(_z))
					{
						inset = false;
						if(iters > _min_iters) break;
					}
				}
				fillSquare(i,j,1,getFractalPointColor(iters),inset);
				i++;
				if(i >= _width)
				{
					i = 0;
					j++;
					if(j >= _height) dorun = false;
				}
			}
			_active = false;
			fireProgressCompleted();
		}
	}

	protected class CFMultiLinear extends CFRenderThread
	{
		public CFMultiLinear(ComplexFractal f) { super(f); }

		public void run()
		{
			if(_rend_test == null || _rend_test.length != _width || _rend_test[0].length != _height)
			{
				_rend_test = new boolean[_width][_height];
			} else {
				for(int i=0; i < _width; i++)
					for(int j=0; j < _height; j++) _rend_test[i][j] = false;
			}
			_fractal.initializeRendering();
			_active = true;
			int iters;
			boolean dorun = true;
			int i=0, j=0;
			int prevsize = 8;
			int stepsize = 8;
			int rendsteps = _width*_height;
			int curcnt=0;
			boolean inset;
			fireProgressStarted();
			while(dorun && _active)
			{
				if(!_rend_test[i][j])
				{
					inset = true;
					_z.setValue(_fractal.getCenter());
					reverseTranslatePoint(i,j,_c);
					initColoringMethods();
					for(iters = 0; iters < _max_iters; iters++)
					{
						iterateFractal(_z,_c);
						if(!_fractal.test(_z))
						{
							inset = false;
							if(iters > _min_iters) break;
						}
					}
					fillSquare(i,j,stepsize,getFractalPointColor(iters),inset);
					_rend_test[i][j] = true;
					curcnt++;
				}
				i+= stepsize;
				if(i >= _width)
				{
					i = 0;
					j+= stepsize;
					if(j >= _height)
					{
						if(stepsize == 1) dorun = false;
						else {
							prevsize = stepsize;
							stepsize /= 2;
							fireProgressUpdated(curcnt/(double)rendsteps);
							j = 0;
						}
					}
				}
			}
			_active = false;
			fireProgressCompleted();
		}
	}

	protected class CFBorderSketch extends CFRenderThread
	{
		public CFBorderSketch(ComplexFractal f) { super(f); }

		public void run()
		{
			if(_rend_test == null || _rend_test.length != _width || _rend_test[0].length != _height)
			{
				_rend_test = new boolean[_width][_height];
			} else {
				for(int i=0; i < _width; i++)
					for(int j=0; j < _height; j++) _rend_test[i][j] = false;
			}
			_fractal.initializeRendering();
			_active = true;
			int iters;
			boolean dorun = true;
			int i=0, j=0;
			int initstepsize = 8;
			int stepsize = initstepsize;
			int rendsteps = _width*_height;
			int curcnt=0;
			boolean inset;
			fireProgressStarted();
			while(dorun && _active)
			{
				inset = true;
				if(stepsize == initstepsize)
				{
					_z.setValue(_fractal.getCenter());
					reverseTranslatePoint(i,j,_c);
					initColoringMethods();
					for(iters = 0; iters < _max_iters; iters++)
					{
						iterateFractal(_z,_c);
						if(!_fractal.test(_z))
						{
							inset = false;
							if(iters > _min_iters) break;
						}
					}
					_rend_test[i][j] = true;
					curcnt++;
					fillSquare(i,j,stepsize,getFractalPointColor(iters),inset);
				} else {
					if(!_rend_test[i][j])
					{
						int left = i - (stepsize+1);
						int right = i + (stepsize+1);
						int top = j - (stepsize+1);
						int bottom = j + (stepsize+1);
						int gposLast = getRGB(i,j);
						boolean dotest = (left < 0) || (gposLast != getRGB(left,j)) || (right >= _width) ||
									(gposLast != getRGB(right,j)) || (top < 0) ||
									(gposLast != getRGB(i,top)) || (bottom >= _height) ||
									(gposLast != getRGB(i,bottom));
						if(dotest)
						{
							_z.setValue(_fractal.getCenter());
							reverseTranslatePoint(i,j,_c);
							initColoringMethods();
							for(iters = 0; iters < _max_iters; iters++)
							{
								iterateFractal(_z,_c);
								if(!_fractal.test(_z))
								{
									inset = false;
									if(iters > _min_iters) break;
								}
							}
							int gpos = getFractalPointColor(iters);
							if(left >= 0 && !_rend_test[left][j]) setRGB(left,j,gpos);
							if(right < _width && !_rend_test[right][j]) setRGB(right,j,gpos);
							if(top >= 0 && !_rend_test[i][top]) setRGB(i,top,gpos);
							if(bottom < _height && !_rend_test[i][bottom]) setRGB(i,bottom,gpos);
							curcnt++;
							_rend_test[i][j] = true;
							fillSquare(i,j,stepsize,gpos,inset);
						}
					}
				}
				i+= stepsize;
				if(i >= _width)
				{
					i = 0;
					j+= stepsize;
					if(j >= _height)
					{
						if(stepsize == 1)
						{
							fireProgressUpdated(curcnt/(double)rendsteps);
							dorun = false;
						} else {
							stepsize /= 2;
							fireProgressUpdated(curcnt/(double)rendsteps);
							j = 0;
						}
					}
				}
			}
			_active = false;
			fireProgressCompleted();
		}
	}
}