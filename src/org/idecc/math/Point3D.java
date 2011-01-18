package org.idecc.math;

public class Point3D
{
	public double x, y, z;

	public Point3D(double x, double y, double z) { this.x = x; this.y = y; this.z = z; }
	public Point3D() { this.x = this.y = this.z = 0.0; }
	public double getX() { return this.x; }
	public double getY() { return this.y; }
	public double getZ() { return this.z; }
	public void setValue(double x, double y, double z) { this.x = x; this.y = y; this.z = z; }
	public void setValue(Point3D p) { this.x = p.x; this.y = p.y; this.z = p.z; }
	public double magnitude() { return Math.sqrt(x*x + y*y + z*z); }
	public double magnitudeSquared() { return (x*x + y*y + z*z); }
}
