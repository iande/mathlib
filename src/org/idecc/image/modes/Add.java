package org.idecc.image.modes;

public class Add implements ImageMode {
	public void performPixelMode(short[] top, short[] bottom) {
		top[0] = (short)Math.min(top[0] + bottom[0],255);
		top[1] = (short)Math.min(top[1] + bottom[1],255);
		top[2] = (short)Math.min(top[2] + bottom[2],255);
		top[3] = (short)Math.min(top[3],bottom[3]);
	}
}

