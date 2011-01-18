package org.idecc.image;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public abstract class Layer {
	protected boolean _vis;
	protected int _width, _height, _x, _y;
        protected org.idecc.image.modes.ImageMode _mode;
        
        public Layer() {
            this(0,0,0,0);
        }
        
        public Layer(int w, int h) {
            this(0,0,w,h);
        }
        
        public Layer(int x, int y, int w, int h) {
            _x = x; _y = y;
            _width = w; _height = h;
        }
	
	public int getWidth() { return _width; }
	public int getHeight() { return _height; }
	public int getX() { return _x; }
	public int getY() { return _y; }
	public boolean isVisible() { return _vis; }
	public void setVisible(boolean vis) { _vis = vis; }
        public void setMode(org.idecc.image.modes.ImageMode m) { _mode = m; }
        public org.idecc.image.modes.ImageMode getMode() { return _mode; }
	
	public void renderLayerToBuffer(BufferedImage buff,int w, int h) {
            Rectangle r1 = new Rectangle(_x,_y,_width,_height);
            Rectangle r2 = new Rectangle(w,h);
            Rectangle inter = r2.intersection(r1);
            if(inter.width > 0 && inter.height > 0) {
                BufferedImage bi = this.asUnmodifiedImage();
                int mx = inter.width + inter.x, my = inter.height + inter.y;
                for(int i=inter.x; i < mx; i++) {
                    for(int j=inter.y; j < my; j++) {
                        int tRGB = bi.getRGB(i - _x, j - _y);
                        if(_mode != null) {
                            int bRGB = buff.getRGB(i,j);
                            short[] tchan = PixelManipulation.splitChannels(tRGB,null);
                            short[] bchan = PixelManipulation.splitChannels(bRGB,null);
                            _mode.performPixelMode(tchan,bchan);
                            buff.setRGB(i,j,PixelManipulation.combineChannels(tchan));
                        } else {
                            buff.setRGB(i,j,tRGB);
                        }
                    }
                }
            }
	}
	
	public abstract BufferedImage asUnmodifiedImage();
	public abstract void dispose();
}
