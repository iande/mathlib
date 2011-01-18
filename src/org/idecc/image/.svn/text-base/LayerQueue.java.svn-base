package org.idecc.image;

import java.util.Vector;
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.awt.Color;

public class LayerQueue extends BufferedImage {
	protected Vector _queue;

        public LayerQueue(int w, int h) {
            super(w,h,TYPE_INT_ARGB);
            _queue = new Vector();
           initBuffer();
	}
	
	public void renderLayers() {
            if(_queue.size() > 0) {
                initBuffer();
                Layer ly = (Layer)_queue.get(0);
                getGraphics().drawImage(ly.asUnmodifiedImage(),ly.getX(),ly.getY(),ly.getWidth(),ly.getHeight(),null);
                for(int i=1; i < _queue.size(); i++) {
                    ly = (Layer)_queue.get(i);
                    if(ly.isVisible()) {
                        ly.renderLayerToBuffer(this,getWidth(),getHeight());
                    }
                }
            }
	}

        public void initBuffer() {
            int mx = getWidth() / 8;
            int my = getHeight() / 8;
            boolean alt=false;
            for(int i=0; i < mx; i++) {
                for(int j=0; j < my; j++) {
                    if(alt) getGraphics().setColor(Color.DARK_GRAY);
                    else getGraphics().setColor(Color.LIGHT_GRAY);
                    getGraphics().fillRect(i*8,j*8,8,8);
                }
            }
        }
}
