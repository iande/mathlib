package org.idecc.image.modes;

public class GrainMerge implements ImageMode {
	public void performPixelMode(short[] top, short[] bottom) {
		int ge = bottom[0] + top[0] - 128;
		top[0] = (ge < 255) ? (ge > 0) ? (short)ge : 0 : 255 ;
		ge = bottom[1] + top[1] - 128;
		top[1] = (ge < 255) ? (ge > 0) ? (short)ge : 0 : 255 ;
		ge = bottom[2] + top[2] - 128;
		top[2] = (ge < 255) ? (ge > 0) ? (short)ge : 0 : 255 ;
		top[3] = (short)Math.min(top[3],bottom[3]);
	}
}

