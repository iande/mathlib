package org.idecc.image.modes;

public class Difference implements ImageMode {
	public void performPixelMode(short[] top, short[] bottom) {
		top[0] = (short)Math.abs(top[0] - bottom[0]);
		top[1] = (short)Math.abs(top[1] - bottom[1]);
		top[2] = (short)Math.abs(top[2] - bottom[2]);
		top[3] = (short)Math.min(top[3],bottom[3]);
	}
}

