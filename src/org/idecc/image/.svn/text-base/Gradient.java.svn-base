package org.idecc.image;

import java.util.Vector;
import org.idecc.math.real.OneVariableRealFunction;

public class Gradient {
        public static short HSB_SPACE = 2;
        public static short RGB_SPACE = 1;
	protected Vector _gpoints;
	protected boolean _repeat_gradient;
        protected short _colspace;
	protected OneVariableRealFunction _uni;

	public Gradient(boolean repeat) {
		_gpoints = new Vector();
		_uni = null;
		_repeat_gradient = repeat;
                _colspace = RGB_SPACE;
	}

	public Gradient() { this(false); }
	
	public void dispose() {
		_gpoints.clear();
		_uni = null;
	}
        public void setColorSpace(int i) {
            if(i == HSB_SPACE) _colspace = HSB_SPACE;
            else _colspace = RGB_SPACE;
        }
        public short getColorSpace() { return _colspace; }
	public void setRepeated(boolean t) { _repeat_gradient = t; }
	public boolean getRepeated() { return _repeat_gradient; }
	public void addColor(float loc, int c) {
		if(loc < 0.0f || loc > 1.0f) {
			throw new IllegalArgumentException();
		}
		GradientPoint gp = new GradientPoint(loc,c);
		if(_gpoints.size() == 0) {
			_gpoints.add(gp);
		} else {
			boolean didinsert = false;
			for(int i=0; i < _gpoints.size(); i++) {
				GradientPoint gp2 = (GradientPoint)_gpoints.get(i);
				if(loc < gp2.location) {
					_gpoints.add(i,gp);
					didinsert = true;
					break;
				}
			}
			if(!didinsert) {
				_gpoints.add(_gpoints.size(),gp);
			}
		}
	}
	public void addColor(double loc, int c) { addColor((float)loc,c); }
	public void addColor(float loc, java.awt.Color c) { addColor(loc,c.getRGB()); }
	public void setTransferFunction(OneVariableRealFunction u) { _uni = u; }
	public OneVariableRealFunction getTransferFunction() { return _uni; }
	public int getColor(float loc) {
		if(_uni != null) loc = (float)_uni.evaluateAt(loc);
		if(loc < 0.0f) {
			if(!_repeat_gradient) {
				loc = 0.0f;
			} else {
				loc = loc - (int)loc + 1.0f;
				if(loc < 0.0f) loc = 0.0f;
			}
		}
		if(loc > 1.0f) {
			if(!_repeat_gradient) {
				loc = 1.0f;
			} else {
				loc = loc - (int)loc;
				if(loc > 1.0f) loc = 1.0f;
			}
		}
		return getColorManual(loc);
	}
	public int getColorWithoutTransfer(float loc) {
		if(loc < 0.0f) {
			if(!_repeat_gradient) {
				loc = 0.0f;
			} else {
				loc = loc - (int)loc + 1.0f;
				if(loc < 0.0f) loc = 0.0f;
			}
		}
		if(loc > 1.0f) {
			if(!_repeat_gradient) {
				loc = 1.0f;
			} else {
				loc = loc - (int)loc;
				if(loc > 1.0f) loc = 1.0f;
			}
		}
		return getColorManual(loc);
	}
	protected int getColorManual(float loc) {
		if(_gpoints.size() == 0) return 0xff000000;
		if(Float.isNaN(loc) || loc > 1.0f) loc = 1.0f;
		else if(loc < 0.0f) loc = 0.0f;
		if(_gpoints.size() == 1) return ((GradientPoint)_gpoints.get(0)).color;
		GradientPoint above = null;
		GradientPoint below = null;
		for(int i=0; i < _gpoints.size(); i++) {
			GradientPoint gp = (GradientPoint)_gpoints.get(i);
			if(loc >= gp.location) {
				below = gp;
			}
			if(loc < gp.location) {
				above = gp;
				break;
			}
		}
		float dist,delta;
		if(above == null) {
			above = (GradientPoint)_gpoints.get(0);
			dist = 1.0f - below.location + above.location;
			if(dist <= 0.0f) dist = 1.0f;
			delta = (loc - below.location) / dist;
		} else if(below == null) {
			below = (GradientPoint)_gpoints.get(_gpoints.size()-1);
			dist = 1.0f - below.location + above.location;
			delta = (loc + (1.0f - below.location)) / dist;
		} else {
			dist = above.location - below.location;
			delta = (loc - below.location) / dist;
		}
		return (_colspace == RGB_SPACE) ? PixelManipulation.getMidColorRGB(below.color,above.color,delta) :
                        PixelManipulation.getMidColorHSB(below.color,above.color,delta);
	}
	public void removeColor(int idx) {
		_gpoints.remove(idx);
	}
	public boolean isRepeated() { return _repeat_gradient; }
	public Vector getGradientPoints() { return _gpoints; }
	public class GradientPoint {
		public float location;
		public int color;
		public GradientPoint(float loc, int c) { location = loc; color = c; }
		public GradientPoint() { }
	}
}