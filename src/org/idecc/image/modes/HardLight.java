package org.idecc.image.modes;

public class HardLight implements ImageMode {
	public void performPixelMode(short[] top, short[] bottom) {
		top[0] = (top[0] > 128) ? (short)Math.min( 255 - ((255-bottom[0])*(255-((top[0]-128)<<1)) >> 8),255) : (short)Math.min((bottom[0] * (top[0] << 1)) >> 8, 255);
		top[1] = (top[1] > 128) ? (short)Math.min( 255 - ((255-bottom[1])*(255-((top[1]-128)<<1)) >> 8),255) : (short)Math.min((bottom[1] * (top[1] << 1)) >> 8, 255);
		top[2] = (top[2] > 128) ? (short)Math.min( 255 - ((255-bottom[2])*(255-((top[2]-128)<<1)) >> 8),255) : (short)Math.min((bottom[2] * (top[2] << 1)) >> 8, 255);
		top[3] = (short)Math.min(top[3],bottom[3]);
	}
}

