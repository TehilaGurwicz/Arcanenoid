import biuoop.DrawSurface;

import java.util.List;

public class Rectangle {
    private Point upperLeft;
    private double width;
    private double height;
    private Line upperLine;
    private Line downLine;
    private Line leftLine;
    private Line rightLine;

    // Create a new rectangle with location and width/height.
    public Rectangle(Point upperLeft, double width, double height){
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;

        this.upperLine = new Line(this.upperLeft, new Point(this.upperLeft.getX() + (int) this.width, this.upperLeft.getY()));
        this.leftLine = new Line(new Point(this.upperLeft.getX(),this.upperLeft.getY() - (int) this.height), this.upperLeft);
        this.downLine = new Line(this.leftLine.getStart(),new Point(this.upperLine.getEnd().getX(),this.leftLine.getStart().getY()));
        this.rightLine = new Line(this.downLine.getEnd(), this.upperLine.getEnd());
    }

    // Return a (possibly empty) List of intersection points
    // with the specified line.
    public java.util.List<Point> intersectionPoints(Line line){
        java.util.List<Point> pointList = new java.util.ArrayList<Point>();
        Line[] thisLines = new Line[4];
        thisLines[0] = this.downLine;
        thisLines[1] = this.leftLine;
        thisLines[2] = this.rightLine;
        thisLines[3] = this.upperLine;

        for(int i = 0; i < 4; i++){
            if(thisLines[i].isIntersecting(line)) {pointList.add(thisLines[i].intersectionWith(line));}
        }
        return pointList;
    }

    // Return the width and height of the rectangle
    public double getWidth() {return this.width;}
    public double getHeight() {return this.height;}

    // Returns the upper-left point of the rectangle.
    public Point getUpperLeft() {return this.upperLeft;}
}