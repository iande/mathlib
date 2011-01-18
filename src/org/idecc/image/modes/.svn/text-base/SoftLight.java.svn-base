package org.idecc.image.modes;

import org.idecc.image.PixelManipulation;

public class SoftLight implements ImageMode {
	public void performPixelMode(short[] top, short[] bottom) {
		int tmp1 = PixelManipulation.multiplyChannels(top[0],bottom[0]);
		int tmp2 = 255 - PixelManipulation.multiplyChannels((255-top[0]),(255-bottom[0]));
		top[0] = (short) (PixelManipulation.multiplyChannels((255-bottom[0]),tmp1) + PixelManipulation.multiplyChannels(bottom[0],tmp2));
		tmp1 = PixelManipulation.multiplyChannels(top[1],bottom[1]);
		tmp2 = 255 - PixelManipulation.multiplyChannels((255-top[1]),(255-bottom[1]));
		top[1] = (short) (PixelManipulation.multiplyChannels((255-bottom[1]),tmp1) + PixelManipulation.multiplyChannels(bottom[1],tmp2));
		tmp1 = PixelManipulation.multiplyChannels(top[2],bottom[2]);
		tmp2 = 255 - PixelManipulation.multiplyChannels((255-top[2]),(255-bottom[2]));
		top[2] = (short) (PixelManipulation.multiplyChannels((255-bottom[2]),tmp1) + PixelManipulation.multiplyChannels(bottom[2],tmp2));
		top[3] = (short)Math.min(top[3],bottom[3]);
	}
}

