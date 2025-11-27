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


    // Returns true if the lines intersect, false otherwise
    // The methods handles separately with the case that this.slope or other.slope is infinity.
    // The doubles represent a way to fine an intersection point, to solve an equation.
    // The last "if" is to confirm that the lines contain the intersection point.
//    public boolean isIntersecting(Line other) {
//        if (this.getSlope() != other.getSlope() && !(this.getSlope() == Double.POSITIVE_INFINITY && other.getSlope() == Double.POSITIVE_INFINITY)) {
//            if (this.getSlope() == Double.POSITIVE_INFINITY)
//            {
//                double intersect_x_point = this.start.getX();
//                double intersect_y_point = other.getSlope() * intersect_x_point + other.yIntersection();
//                Point intersectPoint = new Point(intersect_x_point,intersect_y_point);
//
////                if (intersectPoint.getX() > this.start.getX() && intersectPoint.getX() > other.start.getX() && intersectPoint.getX() < this.end.getX() && intersectPoint.getX() < other.end.getX()) {
////                    return true;
////                }
//                if (intersectPoint.getX() > Math.min(this.start.getX(),this.end.getX()) && intersectPoint.getX() > Math.min(other.start.getX(),other.end.getX()) && intersectPoint.getX() < Math.max(this.start.getX(),this.end.getX()) && intersectPoint.getX() < Math.max(other.start.getX(), other.end.getX()))
//                {return true;}
//            }
//            if (other.getSlope() == Double.POSITIVE_INFINITY)
//            {
//                double intersect_x_point = other.start.getX();
//                double intersect_y_point = this.getSlope() * intersect_x_point + this.yIntersection();
//                Point intersectPoint = new Point(intersect_x_point,intersect_y_point);
//
////                if (intersectPoint.getX() > this.start.getX() && intersectPoint.getX() > other.start.getX() && intersectPoint.getX() < this.end.getX() && intersectPoint.getX() < other.end.getX()) {
////                    return true;
////                }
//                if (intersectPoint.getX() > Math.min(this.start.getX(),this.end.getX()) && intersectPoint.getX() > Math.min(other.start.getX(),other.end.getX()) && intersectPoint.getX() < Math.max(this.start.getX(),this.end.getX()) && intersectPoint.getX() < Math.max(other.start.getX(), other.end.getX()))
//                {return true;}
//            }
//            else
//            {
//                double minusSlope = this.getSlope() - other.getSlope();
//                double minusY_intersect = other.yIntersection() - this.yIntersection();
//                double intersect_x_point = minusY_intersect / minusSlope;
//                double intersect_y_point = this.getSlope() * intersect_x_point + this.yIntersection();
//                Point intersectPoint = new Point(intersect_x_point, intersect_y_point);
//
////                if (intersectPoint.getX() > Math.min(this.start.getX() , other.start.getX()) && intersectPoint.getX() < Math.max(this.end.getX() ,other.end.getX())) {
////                    return true;
////                }
//                if (intersectPoint.getX() > Math.min(this.start.getX(),this.end.getX()) && intersectPoint.getX() > Math.min(other.start.getX(),other.end.getX()) && intersectPoint.getX() < Math.max(this.start.getX(),this.end.getX()) && intersectPoint.getX() < Math.max(other.start.getX(), other.end.getX()))
//                    {return true;}
//            }
//        }
//        return false;
//    }



    // Returns the intersection point if the lines intersect,
    // and null otherwise.
    // So long and repeating the same calculations from isIntersect method but it is what it is
//    public Point intersectionWith(Line other) {
//        if (this.isIntersecting(other)) {
//            if (this.getSlope() == Double.POSITIVE_INFINITY) {
//                double intersect_x_point = this.start.getX();
//                double intersect_y_point = other.getSlope() * intersect_x_point + other.yIntersection();
//                return new Point(intersect_x_point, intersect_y_point);
//            }
//
//            if (other.getSlope() == Double.POSITIVE_INFINITY) {
//                double intersect_x_point = other.start.getX();
//                double intersect_y_point = this.getSlope() * intersect_x_point + this.yIntersection();
//                return new Point(intersect_x_point, intersect_y_point);
//            } else {
//                double minusSlope = this.getSlope() - other.getSlope();
//                double minusY_intersect = other.yIntersection() - this.yIntersection();
//                double intersect_x_point = minusY_intersect / minusSlope;
//                double intersect_y_point = this.getSlope() * intersect_x_point + this.yIntersection();
//                return new Point(intersect_x_point, intersect_y_point);
//            }
//        }
//        return null;
//    }

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
        if(this.getSlope() != other.getSlope() && !(this.getSlope() == Double.POSITIVE_INFINITY && other.getSlope() == Double.POSITIVE_INFINITY)){
            if(this.getSlope() == Double.POSITIVE_INFINITY){
                if(other.getSlope() == 0) {return new Point(this.start.getX(), other.start.getY());}
                else{return new Point(this.start.getX(),this.start.getX() * other.getSlope() + other.yIntersection());}
            }
            if(other.getSlope() == Double.POSITIVE_INFINITY){
                if(this.getSlope() == 0){return new Point(other.start.getX(), this.start.getY());}
                else{return new Point(other.start.getX(),other.start.getX() * this.getSlope() + this.yIntersection());}
            }
            if(this.getSlope() == 0){return new Point((this.start.getY() - other.yIntersection())/other.getSlope(),this.start.getY());}
            if(other.getSlope() == 0){return new Point((other.start.getY() - this.yIntersection())/this.getSlope(), other.start.getY());}
            double minusSlope = this.getSlope() - other.getSlope();
            double minusY_intersect = other.yIntersection() - this.yIntersection();
            double intersect_x_point = minusY_intersect / minusSlope;
            double intersect_y_point = this.getSlope() * intersect_x_point + this.yIntersection();
            return new Point(intersect_x_point, intersect_y_point);
        }
        return null;
    }


    public boolean isIntersecting(Line other){
        if(this.intersectionWith(other) != null){
            if (this.intersectionWith(other).getX() > Math.min(this.start.getX(),this.end.getX()) && this.intersectionWith(other).getX() > Math.min(other.start.getX(),other.end.getX()) && this.intersectionWith(other).getX() < Math.max(this.start.getX(),this.end.getX()) && this.intersectionWith(other).getX() < Math.max(other.start.getX(), other.end.getX()))
            {return true;}
        }
        return false;
    }



}

