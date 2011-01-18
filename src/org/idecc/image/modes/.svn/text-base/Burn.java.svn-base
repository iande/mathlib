package org.idecc.image.modes;

public class Burn implements ImageMode {
	public void performPixelMode(short[] top, short[] bottom) {
		int tmp = (255 - top[0]) << 8;
		tmp /= bottom[0] + 1;
		tmp = 255 - tmp;
		top[0] = (tmp > 0) ? (tmp < 255) ? (short)tmp : 255 : 0;
		tmp = (255 - top[1]) << 8;
		tmp /= bottom[1] + 1;
		tmp = 255 - tmp;
		top[1] = (tmp > 0) ? (tmp < 255) ? (short)tmp : 255 : 0;
		tmp = (255 - top[2]) << 8;
		tmp /= bottom[2] + 1;
		tmp = 255 - tmp;
		top[2] = (tmp > 0) ? (tmp < 255) ? (short)tmp : 255 : 0;
		top[3] = (short)Math.min(top[3],bottom[3]);
	}
}

