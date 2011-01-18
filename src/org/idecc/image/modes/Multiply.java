package org.idecc.image.modes;

import org.idecc.image.PixelManipulation;

public class Multiply implements ImageMode {
	public void performPixelMode(short[] top, short[] bottom) {
		top[0] = PixelManipulation.multiplyChannels(top[0],bottom[0]);
		top[1] = PixelManipulation.multiplyChannels(top[1],bottom[1]);
		top[2] = PixelManipulation.multiplyChannels(top[2],bottom[2]);
		top[3] = (short)Math.min(top[3],bottom[3]);
	}
}

