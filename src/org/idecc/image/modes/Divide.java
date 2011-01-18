package org.idecc.image.modes;

public class Divide implements ImageMode {
	public void performPixelMode(short[] top, short[] bottom) {
		top[0] = (short)Math.min(bottom[0]*256 / (1+top[0]),255);
		top[1] = (short)Math.min(bottom[1]*256 / (1+top[1]),255);
		top[2] = (short)Math.min(bottom[2]*256 / (1+top[2]),255);
		top[3] = (short)Math.min(top[3],bottom[3]);
	}
}

