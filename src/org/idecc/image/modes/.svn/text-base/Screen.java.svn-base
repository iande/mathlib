package org.idecc.image.modes;

import org.idecc.image.PixelManipulation;

public class Screen implements ImageMode {
	public void performPixelMode(short[] top, short[] bottom) {
		top[0] = (short)(255 - PixelManipulation.multiplyChannels( (255 - top[0]), (255 - bottom[0]) ));
		top[1] = (short)(255 - PixelManipulation.multiplyChannels( (255 - top[1]), (255 - bottom[1]) ));
		top[2] = (short)(255 - PixelManipulation.multiplyChannels( (255 - top[2]), (255 - bottom[2]) ));
		top[3] = (short)Math.min(top[3],bottom[3]);
	}
}

