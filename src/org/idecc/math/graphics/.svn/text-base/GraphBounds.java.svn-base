package org.idecc.math.graphics;

import org.idecc.math.Point;

public class GraphBounds
{
	public double x_min,y_min,x_max,y_max;
	public double width,height;

	public GraphBounds(double xmin, double ymin, double xmax, double ymax)
	{
		x_min = xmin;
		y_min = ymin;
		x_max = xmax;
		y_max = ymax;
		width = x_max - x_min;
		height = y_max - y_min;
	}

	public boolean outOfBounds(double x, double y)
	{
		return (Double.isNaN(x) || Double.isNaN(y) || x < this.x_min || x > this.x_max || y < this.y_min || y > this.y_max);
	}
	public boolean outOfBounds(Point p)
	{
		return outOfBounds(p.x,p.y);
	}
}