import biuoop.DrawSurface;

public class Block implements Collidable {

    private Rectangle rectangle;

    //constructor
    public Block(Rectangle rect){
        this.rectangle = rect;
    }

    // Return the "collision shape" of the object.
    @Override
    public Rectangle getCollisionRectangle(){
        return this.rectangle;
    }

    // Notify the object that we collided with it at collisionPoint with
    // a given velocity.
    // The return is the new velocity expected after the hit (based on
    // the force the object inflicted on us).
    public Velocity hit(Point collisionPoint, Velocity currentVelocity){
        if(collisionPoint.getX() == rectangle.getUpperLeft().getX()){return new Velocity(-currentVelocity.getDx(),currentVelocity.getDy());}
        else if(collisionPoint.getY() == rectangle.getUpperLeft().getY()){return new Velocity(currentVelocity.getDx(),-currentVelocity.getDy());}
        else if(collisionPoint.getX() == rectangle.getUpperLeft().getX() + rectangle.getWidth()){return new Velocity(-currentVelocity.getDx(), currentVelocity.getDy());}
        else if(collisionPoint.getY() == rectangle.getUpperLeft().getY() + rectangle.getHeight()){return new Velocity(currentVelocity.getDx(), -currentVelocity.getDy());}
        return null;
    }

    public void drawOn(DrawSurface drawSurface){
        drawSurface.fillRectangle((int)this.rectangle.getUpperLeft().getX(),(int)this.rectangle.getUpperLeft().getY(),(int)this.rectangle.getWidth(),(int)this.rectangle.getHeight());
    }

}
