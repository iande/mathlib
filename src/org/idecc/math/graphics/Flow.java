package org.idecc.math.graphics;

import org.idecc.math.Point;

public class Flow
{
	protected java.util.Vector _vect;
	protected PathStyle _style;

	public Flow()
	{
		_vect = new java.util.Vector();
	}

	public void clear() { _vect.clear(); }
	public void addPoint(double x, double y, double slope)
	{
		_vect.add(new FlowPoint(x,y,slope));
	}
	public int size() { return _vect.size(); }
	public FlowPoint getPoint(int i) { return ((FlowPoint)_vect.get(i)); }

	public void setStyle(PathStyle ps) { _style = ps; }
	public PathStyle getStyle() { return _style; }

	public class FlowPoint extends Point
	{
		public double slope;

		public FlowPoint(double x, double y, double slope)
		{
			super(x,y);
			this.slope = slope;
		}
	}
}