package org.idecc.math.xmetrics;

public class TraversedMetric extends org.idecc.math.MetricCalculator
{
    protected double _x, _y;
    protected boolean _pset;
    
    public TraversedMetric() {
        _pset = false;
        _x = _y = 0.0;
    }
    
    public double calculateMetric(org.idecc.math.Point c)
    {
        if(!_pset) {
            _pset = true;
            _x = c.x;
            _y = c.y;
            return Double.POSITIVE_INFINITY;
        }
        return Math.abs(c.x - _x) + Math.abs(c.y - _y);
    }
}