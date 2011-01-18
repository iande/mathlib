package org.idecc.image;

public class PixelManipulation {
	protected PixelManipulation() { }
	public static short multiplyChannels(int a1, int a2) { return multiplyChannels((short)a1,(short)a2); }
	public static short multiplyChannels(short a1, short a2) {
		/*
			HUGE props to the people working on the Gimp for this function:
			#define INT_MULT(a,b,t)  ((t) = (a) * (b) + 0x80, ((((t) >> 8) + (t)) >> 8))
			It is incredibly simple and clever, something I never would've come up with on my own.
		*/
		/*
		 * This function takes two color channel values int[0,255] and effectively converts them to
		 * percentages real[0,1], multiplies them, then converts them back to proper channel values int[0,255].
		 */
		 int t = a1 * a2 + 0x80;
		 return (short) (( (t >> 8) + t ) >> 8);
	}
	// Do this because we may decide to not use an alpha if one of the channels is missing it.
	public static int selectAlpha(int a1, int a2) { return Math.min(a1, a2); }
	public static void alphaBlend(short[] top, short[] bottom) {
		short aprime = multiplyChannels(top[3],bottom[3]);
		short newalph = (short)( top[3] + bottom[3] - aprime );
		if(newalph > 0) {
			top[0] = (short) ((255 * (multiplyChannels(top[3],top[0]) + multiplyChannels(bottom[0],bottom[3]-aprime))) / newalph);
			top[1] = (short) ((255 * (multiplyChannels(top[3],top[1]) + multiplyChannels(bottom[1],bottom[3]-aprime))) / newalph);
			top[2] = (short) ((255 * (multiplyChannels(top[3],top[2]) + multiplyChannels(bottom[2],bottom[3]-aprime))) / newalph);
		} else {
			top[0] = top[1] = top[2] = 0;
		}
		top[3] = newalph;
	}
	public static short[] splitChannels(int argb, short[] arr) {
		if(arr == null || arr.length < 4) arr = new short[4];
		// Split to R.G.B (and alpha, if arr is long enough)
		for(int i=0; i < 3; i++) {
			arr[2-i] = (short) (argb&0xff);
			argb = argb >> 8;
		}
		arr[3] = (short) (argb&0xff);
                return arr;
	}
	public static int combineChannels(short[] arr) {
		if(arr.length < 3) return 0;
		int rgb = (arr[0] << 16) + (arr[1] << 8) + arr[2];
		if(arr.length > 3) rgb += (arr[3] << 24);
		return rgb;
	}
        
        public static int getMidColorRGB(int c1, int c2, double delta) {
            int fcol = 0;
            short cval1 = (short)((c1) & 255);
            short cval2 = (short)((c2) & 255);
            fcol = (int)(cval1 - delta*(cval1 - cval2));
            cval1 = (short)((c1 >> 8) & 0xff);
            cval2 = (short)((c2 >> 8) & 0xff);
            fcol = fcol | ((int)(cval1 - delta*(cval1 - cval2)) << 8);
            cval1 = (short)((c1 >> 16) & 0xff);
            cval2 = (short)((c2 >> 16) & 0xff);
            fcol = fcol | ((int)(cval1 - delta*(cval1 - cval2)) << 16);
            cval1 = (short)((c1 >> 24) & 0xff);
            cval2 = (short)((c2 >> 24) & 0xff);
            fcol = fcol | ((int)(cval1 - delta*(cval1 - cval2)) << 24);
            return fcol;
        }
        
        public static int getMidColorHSB(int c1, int c2, double delta) {
            int a1 = (short)((c1 >> 24) & 0xff);
            int a2 = (short)((c2 >> 24) & 0xff);
            float hsb1[] = java.awt.Color.RGBtoHSB( (c1 >> 16) & 0xff, (c1 >> 8) & 0xff, c1 & 0xff, null );
            float hsb2[] = java.awt.Color.RGBtoHSB( (c2 >> 16) & 0xff, (c2 >> 8) & 0xff, c2 & 0xff, null );
            float h = (float)(hsb1[0] - delta*(hsb1[0] - hsb2[0]));
            float s = (float)(hsb1[1] - delta*(hsb1[1] - hsb2[1]));
            float b = (float)(hsb1[2] - delta*(hsb1[2] - hsb2[2]));
            int fcol = java.awt.Color.HSBtoRGB(h,s,b);
            return fcol | ((int)(a1 - delta*(a1-a2)) << 24);
        }
}

