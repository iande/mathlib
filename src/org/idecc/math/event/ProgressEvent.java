package org.idecc.math.event;

public class ProgressEvent extends java.util.EventObject
{
	protected double _perc;
        protected long _tstamp, _sstamp;
	public ProgressEvent(Object src, double perc)
	{
		super(src);
		_perc = perc;
                _sstamp = 0;
                _tstamp = new java.util.Date().getTime();
	}
	public double getPercentCompleted() { return _perc; }
	public int getProgress() { return (int)(_perc*100); }
	public int getProgress(int max) { return (int)(_perc*max); }
        public long getTimeStamp() { return _tstamp; }
        public long getETA() { return (long)((_tstamp - _sstamp) / _perc); }
        public void setStartTime(long tstamp) { _sstamp = tstamp; }
        public long getDeltaTime() { return (_tstamp - _sstamp); }
}