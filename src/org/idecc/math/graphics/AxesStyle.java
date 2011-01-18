package org.idecc.math.graphics;

import java.awt.Color;
import java.awt.Stroke;
import java.awt.Font;

public class AxesStyle
{
	public static final int IN_PLACE=1;
	public static final int ABOVE=2;
	public static final int BELOW=3;
	public static final int NONE=4;

// Global settings
	public int axis_placement = IN_PLACE;
	public boolean antialias = false;
	public Stroke stroke = null;
	public int tic_length = 4;
	public Font tic_font = null;

// X-Axis settings
	public double x_tic_placement = 2.0;
	public boolean x_label = false;
	public Color x_color = Color.black;

// Y-Axis settings
	public double y_tic_placement = 2.0;
	public boolean y_label = false;
	public Color y_color = Color.black;
}