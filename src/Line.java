public class Line {

    private Point start;
    private Point end;
    //private double slope;

    // constructors
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
        //this.slope = (this.start.getY() - this.end.getY()) / (this.start.getX() - this.end.getX());
    }

    public Line(double x1, double y1, double x2, double y2) {
        Point p_start = new Point(x1, y1);
        Point p_end = new Point(x2, y2);
        this.start = p_start;
        this.end = p_end;
    }

    // Return the length of the line
    public double length() {
        return this.start.distance(this.end);
    }

    // Returns the middle point of the line
    public Point middle() {
        Point middle = new Point((this.start.getX() + this.end.getX()) / 2, (this.start.getY() + this.end.getY()) / 2);
        return middle;
    }

    // Returns the start point of the line
    public Point getStart() {
        return this.start;
    }

    // Returns the end point of the line
    public Point getEnd() {
        return this.end;
    }

    // calculate a line slope considering the aligned with the axes lines.
    public double getSlope() {
        if (this.start.getX() == this.end.getX()) {return Double.POSITIVE_INFINITY;}
        else {return (this.start.getY() - this.end.getY()) / (this.start.getX() - this.end.getX());}
    }

    // finds the equation of a line(helper method to the isIntersecting method)
    public double yIntersection() {
        return this.start.getY() - this.getSlope() * this.start.getX();
    }

    // equals -- return true is the lines are equal, false otherwise
    public boolean equals(Line other) {
        return this.start.equals(other.start) && this.end.equals(other.end);
    }

    // If this line does not intersect with the rectangle, return null.
    // Otherwise, return the closest intersection point to the
    // start of the line.
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        Line line = new Line(this.start,this.end);
        double dist = 0;
        Point ans = new Point(0,0);
        if (!(rect.intersectionPoints(line).isEmpty())){
            for(Point point:rect.intersectionPoints(line)){
                if (this.start.distance(point) < dist){
                    dist = this.start.distance(point);
                    ans = point;
                }
            }
            return ans;
        }
        return null;
    }


    public Point intersectionWith(Line other){

        //both are Vertical
        if(Double.isInfinite(this.getSlope())&&Double.isInfinite(other.getSlope())){
            return null;
        }
        //this is vertical
        else if(Double.isInfinite(this.getSlope())){
            return new Point(this.start.getX(),this.start.getX()*other.getSlope()+ other.yIntersection());

        }//other is vertical
        else if(Double.isInfinite(other.getSlope())){
            return new Point(other.start.getX(),other.start.getX()*this.getSlope()+ this.yIntersection());
        }
        //both "regular" lines
        else{
            double minusSlope = this.getSlope() - other.getSlope();
            double minusY_intersect = other.yIntersection() - this.yIntersection();
            double intersect_x_point = minusY_intersect / minusSlope;
            double intersect_y_point = this.getSlope() * intersect_x_point + this.yIntersection();
            return new Point(intersect_x_point, intersect_y_point);
        }
    }
    public boolean isIntersecting(Line other) {
        Point p = this.intersectionWith(other);
        if (p == null) {
            return false;
        }
        return this.isPointOnLine(p) && other.isPointOnLine(p);
    }
    private boolean isPointOnLine(Point p) {
        double minX = Math.min(this.start.getX(), this.end.getX());
        double maxX = Math.max(this.start.getX(), this.end.getX());
        double minY = Math.min(this.start.getY(), this.end.getY());
        double maxY = Math.max(this.start.getY(), this.end.getY());
        return p.getX() >= minX - 0.0001 && p.getX() <= maxX + 0.0001 && p.getY() >= minY-0.0001 && p.getY() <= maxY + 0.0001;
    }




}