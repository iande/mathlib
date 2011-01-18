package org.idecc.math.graphics;

public class GraphTools
{
	// Do not instantiate
	protected GraphTools() { }



/*	public static PathCollection splitPathAtBounds(Path p, GraphBounds bnds, PathCollection pc)
	{
		// Do the clipping here.
		if(!bnds.outOfBounds(x,y))
		{
			if(_last_point.type == PathPoint.UNSET || _last_point.type == PathPoint.POINT)
			{
				PathPoint p = new PathPoint(x,y);
				p.type = PathPoint.POINT;
				_vect.add(p);
				_last_point.x = x;
				_last_point.y = y;
				_last_point.type = PathPoint.POINT;
			} else {
				PathPoint e = new PathPoint(x,y);
				e.type = PathPoint.POINT;
				// We need to triangulate a point between the previous point and here.
				// lp out of bounds, np in bounds
				int intr = getFirstIntersection(_last_point.x,_last_point.y,x,y,bnds.x_min,bnds.y_min,bnds.x_max,bnds.y_max);
				// s.x = e.x - dx'
				// s.y = e.y - dy'
				double dx = e.x - _last_point.x;
				double dy = e.y - _last_point.y;
				double nx = 0, ny = 0;
				double dxp,dyp;

				switch(intr)
				{
					case INT_MINX:
						dxp = e.x - bnds.x_min;
						dyp = dxp*dy/dx;
						nx = bnds.x_min;
						ny = e.y - dyp;
						break;
					case INT_MAXX:
						dxp = e.x - bnds.x_max;
						dyp = dxp*dy/dx;
						nx = bnds.x_max;
						ny = e.y - dyp;
						break;
					case INT_MINY:
						dyp = e.y - bnds.y_min;
						dxp = dyp*dx/dy;
						nx = e.x - dxp;
						ny = bnds.y_min;
						break;
					default:
						// Why this is safe: If one point is in the interior of a rectangle, and the other is outside the interior,
						// the line connecting these two points MUST intersect at least one edge of the rectangle.
						dyp = e.y - bnds.y_max;
						dxp = dyp*dx/dy;
						nx = e.x - dxp;
						ny = bnds.y_max;
						break;
				}

				PathPoint p = new PathPoint(nx,ny);
				p.type = PathPoint.POINT;
				if(_vect.size() < 1 || ((PathPoint)_vect.get(_vect.size()-1)).type != PathPoint.BREAK)
				{
					// Add the break, and then the rest.
					PathPoint b = new PathPoint();
					b.type = PathPoint.BREAK;
					_vect.add(b);
					_vect.add(p);
					_vect.add(e);
				} else {
					// Either the vector's empty or a break is already the last item present, so,
					// don't add a break.
					_vect.add(p);
					_vect.add(e);
				}
				_last_point.x = x;
				_last_point.y = y;
				_last_point.type = PathPoint.POINT;
			}
		} else {
			if(_last_point.type == PathPoint.UNSET || _last_point.type == PathPoint.BREAK)
			{
				_last_point.x = x;
				_last_point.y = y;
				_last_point.type = PathPoint.BREAK;
			} else {
				// We need to triangulate a point between the previous point and here.
				// lp in bounds, np out of bounds.
				int intr = getFirstIntersection(_last_point.x,_last_point.y,x,y,bnds.x_min,bnds.y_min,bnds.x_max,bnds.y_max);

				// s.x = e.x - dx'
				// s.y = e.y - dy'
				double dx = x - _last_point.x;
				double dy = y - _last_point.y;
				double nx = 0, ny = 0;
				double dxp,dyp;

				switch(intr)
				{
					case INT_MINX:
						dxp = bnds.x_min - _last_point.x;
						dyp = dxp*dy/dx;
						nx = bnds.x_min;
						ny = _last_point.y + dyp;
						break;
					case INT_MAXX:
						dxp = bnds.x_max - _last_point.x;
						dyp = dxp*dy/dx;
						nx = bnds.x_max;
						ny = _last_point.y + dyp;
						break;
					case INT_MINY:
						dyp = bnds.y_min - _last_point.y;
						dxp = dyp*dx/dy;
						nx = _last_point.x + dxp;
						ny = bnds.y_min;
						break;
					default:
						// Why this is safe: If one point is in the interior of a rectangle, and the other is outside the interior,
						// the line connecting these two points MUST intersect at least one edge of the rectangle.
						dyp = bnds.y_max - _last_point.y;
						dxp = dyp*dx/dy;
						nx = _last_point.x + dxp;
						ny = bnds.y_max;
						break;
				}

				PathPoint p = new PathPoint(nx,ny);
				p.type = PathPoint.POINT;
				PathPoint b = new PathPoint();
				b.type = PathPoint.BREAK;
				_vect.add(p);
				_vect.add(b);
				_last_point.x = x;
				_last_point.y = y;
				_last_point.type = PathPoint.BREAK;
			}
		}
	}*/
}