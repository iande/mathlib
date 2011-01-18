/*
 * ProgressAdapter.java
 *
 * Created on June 8, 2006, 3:21 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.idecc.math.event;

/**
 *
 * @author chaos
 */
public class ProgressAdapter implements ProgressListener {
    
    /** Creates a new instance of ProgressAdapter */
    public ProgressAdapter() {
    }
    
    public void progressStarted(ProgressEvent e) { }
    public void progressUpdated(ProgressEvent e) { }
    public void progressCompleted(ProgressEvent e) { }
}
