import java.lang.Math;
import biuoop.DrawSurface;
import biuoop.GUI;
import java.awt.Color;


public class Ball {
    private Point center;
    private double r;
    private java.awt.Color color;
    private Velocity velocity;
    private Point point;
    private GameEnvironmant gameEnvironmant;


    // constructor
    public Ball(Point center, int r, java.awt.Color color,GameEnvironmant gameEnvironmant){
        this.center = center;
        this.r = r;
        this.color = color;
        this.gameEnvironmant = gameEnvironmant;
    }



    // accessors
    public int getX() {return (int) this.center.getX();}
    public int getY() {return (int) this.center.getY();}
    public int getR() {return (int) this.r;}
    public int getSize() {return (int) (Math.PI*r*r);}

    public java.awt.Color getColor() {return this.color;}

    // draw the ball on the given DrawSurface
    public void drawOn(DrawSurface surface){
        surface.setColor(this.color);
        surface.fillCircle((int) this.center.getX(), (int) this.center.getY(),(int) r);
    }


    public void setVelocity(Velocity v) {this.velocity = v;}
    public void setVelocity(double dx, double dy) {
        this.velocity= new Velocity(dx,dy);
    }


    public Velocity getVelocity() {
        return new Velocity (this.velocity.getDx(), this.velocity.getDy());
    }

    //gets the direction of the ball according to it's velocity, the *5 is a comfortable way to define the
    //direction, could be any other number.
    public Line getTrajectory(){
        return new Line(this.center,new Point(5*this.velocity.getDx(),5*this.velocity.getDy()));
    }

    //checks where the ball is coming from in order to know where i should stop it before it hits the block


    // moves the ball by adding dx/y to the center and stopping the ball before it hits a block
    public void moveOneStep(){
          CollisionInfo collisionInfo = this.gameEnvironmant.getClosestCollision(this.getTrajectory());
          if (collisionInfo != null){
              //if (collisionInfo.collisionPoint() != null){
              this.center = new Point(collisionInfo.collisionPoint().getX() - this.velocity.getDx(),collisionInfo.collisionPoint().getY() -this.velocity.getDy());
              this.setVelocity(collisionInfo.collisionObject().hit(collisionInfo.collisionPoint(),this.velocity));
          }
          else{this.center = this.velocity.applyToPoint(this.center);}
    }

//    public void moveOneStep() {
//        CollisionInfo collisionInfo = this.gameEnvironmant.getClosestCollision(this.getTrajectory());
//
//        if (collisionInfo == null) {
//            System.out.println("NO COLLISION");
//            this.center = this.velocity.applyToPoint(this.center);
//        } else {
//            System.out.println("COLLISION at " + collisionInfo.collisionPoint());
//        }
//    }

}
