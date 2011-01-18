/*
 * CFLayer.java
 *
 * Created on June 10, 2006, 9:45 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.idecc.image;

import java.awt.image.BufferedImage;
import org.idecc.math.graphics.CFContext;
import org.idecc.math.graphics.GraphBounds;
import org.idecc.math.complex.fractal.ComplexFractal;

/**
 *
 * @author chaos
 */
public class CFLayer extends Layer {
    
    /** Creates a new instance of CFLayer */
    public CFLayer(int w, int h) {
        super(w,h);
        _context = new CFContext(w,h,new GraphBounds(0,0,0,0));
    }
    
    public void setFractal(ComplexFractal f) {
        _fract = f;
        _context.setBoundsByFractal(f);
    }
    public ComplexFractal getFractal() { return _fract; }
    
    public void render() {
        _context.drawComplexFractal(_fract);
    }
    
    public CFContext getCFContext() { return _context; }
    
    public void dispose() {
    }
    
    public BufferedImage asUnmodifiedImage() {
        return _context;
    }
    
    
    protected CFContext _context;
    protected ComplexFractal _fract;
}
