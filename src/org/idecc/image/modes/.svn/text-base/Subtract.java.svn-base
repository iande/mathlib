package org.idecc.image.modes;

public class Subtract implements ImageMode {
	public void performPixelMode(short[] top, short[] bottom) {
		top[0] = (short)Math.max(bottom[0] - top[0],0);
		top[1] = (short)Math.max(bottom[1] - top[1],0);
		top[2] = (short)Math.max(bottom[2] - top[2],0);
		top[3] = (short)Math.min(top[3],bottom[3]);
	}
}

