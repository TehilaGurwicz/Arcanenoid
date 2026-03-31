// Velocity specifies the change in position on the `x` and the `y` axes.
public class Velocity {
    private double dx;
    private double dy;

    // constructor
    public Velocity(double dx, double dy){
        this.dx = dx;
        this.dy = dy;
    }

    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        double radians = Math.toRadians(angle);
        double dx =  speed * Math.sin(radians);
        double dy = -speed * Math.cos(radians); ;
        return new Velocity(dx, dy);
    }


    // Take a point with position (x,y) and return a new point
    // with position (x+dx, y+dy)
    public Point applyToPoint(Point p){
        return new Point(p.getX() + this.dx, p.getY() + this.dy);
    }

    //access
    public double getDx() {return this.dx;}
    public double getDy() {return this.dy;}

}