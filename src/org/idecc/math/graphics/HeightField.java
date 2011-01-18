package org.idecc.math.graphics;

public class HeightField {
	protected HeightStyle _style;
	protected double _field[][];
	protected double _min_h, _max_h;
	protected boolean _h_set;
	protected GraphBounds _domain;
	protected int _idx_h, _idx_w;
	
	public HeightField(int hsteps, int vsteps, GraphBounds domain) {
		_field = new double[hsteps][vsteps];
		_domain = domain;
		_h_set = false;
		_idx_w = hsteps;
		_idx_h = vsteps;
	}
	
	public void setHeightRange(double minh, double maxh) {
		_h_set = true;
		_min_h = minh;
		_max_h = maxh;
	}
	
	public void setHeight(double x, double y, double h) {
		if(_domain.outOfBounds(x,y)) return;
		int xi = (int) (_idx_w * (x - _domain.x_min) / _domain.width);
		int yi = (int) (_idx_h * (y - _domain.y_min) / _domain.height);
		setHeight(xi,yi,h);
	}
	
	public void setHeight(int i, int j, double h) {
		if(i < 0 || i > _idx_w || j < 0 || j > _idx_h) return;
		_field[i][j] = h;
	}
	
	public double getHeight(double x, double y) {
		if(_domain.outOfBounds(x,y)) return _min_h;
		int xi = (int) (_idx_w * (x - _domain.x_min) / _domain.width);
		int yi = (int) (_idx_h * (y - _domain.y_min) / _domain.height);
		if(xi >= _idx_w || yi >= _idx_h) {
			return (_h_set) ? _min_h : 0.0;
		}
		return _field[xi][yi];
	}
	
	public float getRelativeHeight(double x, double y) {
		double bh = getHeight(x,y);
		if(!_h_set) return (float)bh;
		return (float)Math.min(Math.max((bh - _min_h) / (_max_h - _min_h),0.0),1.0);
	}
	
	public void setStyle(HeightStyle hs) { _style = hs; }
	public HeightStyle getStyle() { return _style; }
}
