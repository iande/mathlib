package org.idecc.math.graphics;

import java.awt.Color;
import java.awt.Point;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.BasicStroke;
import java.awt.RenderingHints;
import java.util.Vector;

import org.idecc.math.event.ProgressEvent;
import org.idecc.math.event.ProgressListener;

/*
	This class wraps around a generic Graphics context
	and provides methods for treating it as if it were a cartesian plane.

	By default, the origin is centered to the graphics context.
*/

public class CartesianContext
{
	public static final int BOUNDS_MIN_X = 1;
	public static final int BOUNDS_MIN_Y = 2;
	public static final int BOUNDS_MAX_X = 3;
	public static final int BOUNDS_MAX_Y = 4;

	protected GraphBounds _bounds;
	protected int _width, _height;
	protected Graphics2D _gc;
	protected Point _trans;
	protected Color _axes_color;

	public CartesianContext(int w, int h, GraphBounds bounds, Graphics2D g)
	{
		_gc = g;
		_width = w;
		_height = h;
		_bounds = bounds;
		_trans = new Point();
		_gc.setColor(Color.white);
		_gc.fillRect(0,0,w,h);
		//_gc.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BICUBIC);
		//_gc.setRenderingHint(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);

	}
	/*public void enableAntiAliasing(boolean t)
	{
		if(t) _gc.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
		else _gc.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_OFF);
	}*/
	public GraphBounds getBounds() { return _bounds; }

	public void drawAxes(AxesStyle sty)
	{
		if(sty.axis_placement != AxesStyle.NONE)
		{
			Stroke cur = _gc.getStroke();
			Font curf = _gc.getFont();
			if(sty.stroke != null) _gc.setStroke(sty.stroke);
			if(sty.tic_font != null) _gc.setFont(sty.tic_font);
			double xaxis, yaxis;
			if(sty.antialias) _gc.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
			if(sty.axis_placement == AxesStyle.IN_PLACE)
			{
				// We want to draw the axes "in place", but we must first be sure we can actually do that.
				xaxis = (_bounds.y_min < 0 && _bounds.y_max > 0) ? 0.0 : _bounds.y_min;
				yaxis = (_bounds.x_min < 0 && _bounds.x_max > 0) ? 0.0 : _bounds.x_min;
			} else if(sty.axis_placement == AxesStyle.ABOVE) {
				// We want to draw the axis above (y-axis to left)
				xaxis = _bounds.y_max;
				yaxis = _bounds.x_min;
			} else {
				// We want to draw the axis below (y-axis to left)
				xaxis = _bounds.y_min;
				yaxis = _bounds.x_min;
			}

			_gc.setColor(sty.x_color);
			translatePoint(_bounds.x_min,xaxis,_trans);
			int x0 = _trans.x, y0 = _trans.y;
			translatePoint(_bounds.x_max,xaxis,_trans);
			int x1 = _trans.x;
			_gc.drawLine(x0,y0,x1,y0);
			if(sty.x_tic_placement > 0)
			{
				double ticxmin = Math.ceil(_bounds.x_min/sty.x_tic_placement)*sty.x_tic_placement;
				while(ticxmin <= _bounds.x_max)
				{
					translatePoint(ticxmin,xaxis,_trans);
					if((sty.axis_placement != AxesStyle.IN_PLACE || ticxmin != 0.0) && _trans.x > 0 && _trans.x < (_width-1))
					{
						_gc.drawLine(_trans.x,_trans.y-sty.tic_length,_trans.x,_trans.y+sty.tic_length);
						if(sty.x_label)
						{
							int deltah = sty.tic_length + _gc.getFontMetrics().getHeight()/2;
							String xd = Double.toString(ticxmin);
							int indp = xd.indexOf(".");
							int deltaw = 0;
							if(indp > 0)
							{
								char[] chrs = xd.substring(0,indp).toCharArray();
								deltaw = _gc.getFontMetrics().charsWidth(chrs,0,chrs.length) + _gc.getFontMetrics().charWidth('.')/2;
							}
							if(sty.axis_placement == AxesStyle.ABOVE)
							{
								_gc.drawString(xd,_trans.x-deltaw,_trans.y+deltah);
							} else {
								_gc.drawString(xd,_trans.x-deltaw,_trans.y-deltah);
							}
						}
					}
					ticxmin += sty.x_tic_placement;
				}
			}

			_gc.setColor(sty.y_color);
			translatePoint(yaxis,_bounds.y_min,_trans);
			x0 = _trans.x; y0 = _trans.y;
			translatePoint(yaxis,_bounds.y_max,_trans);
			int y1 = _trans.y;
			_gc.drawLine(x0,y0,x0,y1);
			if(sty.y_tic_placement > 0)
			{
				double ticymin = Math.ceil(_bounds.y_min/sty.y_tic_placement)*sty.y_tic_placement;
				while(ticymin <= _bounds.y_max)
				{
					translatePoint(yaxis,ticymin,_trans);
					if((sty.axis_placement != AxesStyle.IN_PLACE || ticymin != 0.0) && _trans.y > 0 && _trans.y < (_height-1))
					{
						_gc.drawLine(_trans.x-sty.tic_length,_trans.y,_trans.x+sty.tic_length,_trans.y);
						if(sty.y_label)
						{
							int deltah = _gc.getFontMetrics().getHeight()/4;
							int deltaw = sty.tic_length + 8;
							_gc.drawString(Double.toString(ticymin),_trans.x+deltaw,_trans.y+deltah);
						}
					}
					ticymin += sty.y_tic_placement;
				}
			}

			if(sty.stroke != null) _gc.setStroke(cur);
			if(sty.tic_font != null) _gc.setFont(curf);
			if(sty.antialias) _gc.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_OFF);
		}
	}

	public void drawPoint(org.idecc.math.Point px, PointStyle sty)
	{
		double x = px.getX(), y = px.getY();
		if(sty != null && !_bounds.outOfBounds(x,y))
		{
			_gc.setStroke(sty.stroke);
			_gc.setColor(sty.color);
			translatePoint(x,y,_trans);
			int d = sty.diameter;
			int r = d/2;
			if(sty.filled) _gc.fillOval(_trans.x-r,_trans.y-r,d,d);
			else _gc.drawOval(_trans.x-r,_trans.y-r,d,d);
		}
	}
	public void drawPoint(GraphicPoint px)
	{
		drawPoint(px,px.getStyle());
	}

	public void drawPath(Path p)
	{
		org.idecc.math.Point last = null;
		PathStyle ps = p.getStyle();
		PointStyle pts = ps.point_style;
		for(int i=0; i < p.size(); i++)
		{
			org.idecc.math.Point pp = p.getPoint(i);
			if(last != null)
			{
				translatePoint(last.x,last.y,_trans);
				int x0 = _trans.x, y0 = _trans.y;
				if(pts != null)
				{
					drawPoint(last,pts);
				}
				if(ps != null)
				{
					translatePoint(pp.x,pp.y,_trans);
					_gc.setStroke(ps.stroke);
					_gc.setColor(ps.color);
					_gc.drawLine(x0,y0,_trans.x,_trans.y);
				}
			}
			last = pp;
		}
	}
	
	public void drawHeightField(HeightField hf) {
		HeightStyle hs = hf.getStyle();
		if(hs == null) return;
		if(hs.gradient == null) return;
		
		double incrx = _bounds.width / _width;
		double incry = _bounds.height / _height;
		double curx = _bounds.x_min;
		double cury = _bounds.y_min;
		for(int i=0; i < _width; i++) {
			for(int j=0; j < _height; j++) {
				// Holy Waste!
				Color c = new Color(hs.gradient.getColor(hf.getRelativeHeight(curx,cury)));
				_gc.setColor(c);
				_gc.drawRect(i,j,0,0);
				cury += incry;
			}
			cury = _bounds.y_min;
			curx += incrx;
		}
	}

	/*public void drawPointCollection(PointCollection p)
	{
		for(int i=0; i < p.size(); i++)
		{
			drawPoint(p.getPoint(i));
		}
	}*/

	/*public void drawFlowLine(double x, double y, double slope, int vlen, int ptw)
	{
		if(_bounds.outOfBounds(x,y) || Double.isNaN(slope) || Double.isInfinite(slope)) return;
		drawPoint(x,y,ptw,false);
		int dx = (int)(vlen / Math.sqrt(slope*slope + 1));
		int dy = (int)Math.sqrt(vlen*vlen - dx*dx);
		dy = (slope < 0) ? dy : -1*dy;
		Color c = _gc.getColor();
		_gc.drawLine(_trans.x,_trans.y,_trans.x+dx,_trans.y+dy);
	}*/

	protected void translatePoint(double x, double y, Point pt)
	{
		int xs = (int) ((x - _bounds.x_min) * (_width-1) / _bounds.width);
		int ys = (int) ((_bounds.y_max - y) * (_height-1) / _bounds.height);
		pt.setLocation(xs,ys);
	}
	protected void reverseTranslatePoint(int i, int j, org.idecc.math.Point pt)
	{
		double xs = i*_bounds.width / (_width-1) + _bounds.x_min;
		double ys = _bounds.y_max - j*_bounds.height / (_height-1);

		pt.setValue(xs,ys);
	}
}