package org.idecc.math;

/**
 * An interface for computing the "distance" between two <code>Point</code>s.
 * There are some properties a metric, <code>m(x,y)</code>, must satisfy to be considered a true metric:
 * <ol><li>The triangle inequality: <code>m(x,y) + m(y,z) &ge; m(x,z)</code></li>
 * <li>Symmetry: <code>m(x,y) = m(y,x)</code></li>
 * <li><code>m(x,x) = 0</code></li>
 * <li>If <code>m(x,y) = 0</code> then <code>x = y</code></li></ol>
 * There is nothing specified in the code that these properties have to be obeyed. The presented material
 * is merely the formal definition of a metric.
 */

public abstract class MetricCalculator
{
	protected Point _delta;

	/**
	 * Calculates the "distance" between <code>pt</code> and the origin.
	 * The origin refers to the point (0,0,...,0)
	 *
	 * @param pt the point whose distance one wishes to calculate.
	 * @return the "distance" between <code>pt</code> and the origin.
 	*/
	public abstract double calculateMetric(Point pt);
	/**
	 * Calculates the "distance" between two "points".
	 *
	 * @param pt1 the starting point
	 * @param pt2 the ending point.
	 * @return the "distance" between <code>pt1</code> and <code>pt2</code>.
 	*/
	public double calculateMetric(Point pt1, Point pt2) {
		_delta.setValue(pt2.x - pt1.x,pt2.y - pt1.y);
		return calculateMetric(_delta);
	}
}
