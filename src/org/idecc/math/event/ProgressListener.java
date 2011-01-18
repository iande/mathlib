package org.idecc.math.event;

public interface ProgressListener extends java.util.EventListener
{
	public void progressStarted(ProgressEvent e);
	public void progressUpdated(ProgressEvent e);
	public void progressCompleted(ProgressEvent e);
}