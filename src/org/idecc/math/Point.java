package org.idecc.math;

public class Point
{
	public double x;
	public double y;

	public Point(double x, double y) { this.x = x; this.y = y; }
	public Point() { this.x = this.y = 0.0; }
	public double getX() { return this.x; }
	public double getY() { return this.y; }
	public void setValue(double x, double y) { this.x = x; this.y = y; }
	public void setValue(Point p) { this.x = p.x; this.y = p.y; }
	public double magnitude() { return Math.sqrt(x*x + y*y); }
	public double magnitudeSquared() { return (x*x + y*y); }
}
