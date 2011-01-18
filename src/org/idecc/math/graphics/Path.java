package org.idecc.math.graphics;

import org.idecc.math.Point;

public class Path
{
	protected java.util.Vector _vect;
	protected PathStyle _style;

	public Path()
	{
		_vect = new java.util.Vector();
	}

	public void clear() { _vect.clear(); }
	public void addPoint(double x, double y)
	{
		Point p = new Point(x,y);
		_vect.add(p);
	}
	public int size() { return _vect.size(); }
	public Point getPoint(int i) { return ((Point)_vect.get(i)); }

	public void setStyle(PathStyle ps) { _style = ps; }
	public PathStyle getStyle() { return _style; }
}