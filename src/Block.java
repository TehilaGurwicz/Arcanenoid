import biuoop.DrawSurface;
import java.util.List;
import java.util.ArrayList;
import java.awt.*;

public class Block implements Collidable,Sprite,HitNotifier {

    private Rectangle rectangle;
    private java.awt.Color color = new Color(0,0,0);
    private List<HitListener> hitListenerList = new ArrayList<>();

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
    // Notice that we changed the hit method to include a "Ball hitter" parameter -- update the
    // Collidable interface accordingly.
    public Velocity hit(Ball hitter,Point collisionPoint, Velocity currentVelocity){
        this.notifyHit(hitter);
        if(collisionPoint.getX() == rectangle.getUpperLeft().getX()){return new Velocity(-currentVelocity.getDx(),currentVelocity.getDy());}
        else if(collisionPoint.getY() == rectangle.getUpperLeft().getY()){return new Velocity(currentVelocity.getDx(),-currentVelocity.getDy());}
        else if(collisionPoint.getX() == rectangle.getUpperLeft().getX() + rectangle.getWidth()){return new Velocity(-currentVelocity.getDx(), currentVelocity.getDy());}
        else if(collisionPoint.getY() == rectangle.getUpperLeft().getY() + rectangle.getHeight()){return new Velocity(currentVelocity.getDx(), -currentVelocity.getDy());}
        return null;
    }

    public void drawOn(DrawSurface drawSurface){
        drawSurface.setColor(Color.black);
        drawSurface.drawRectangle((int)this.rectangle.getUpperLeft().getX(),(int)this.rectangle.getUpperLeft().getY(),(int)this.rectangle.getWidth(),(int)this.rectangle.getHeight());
        drawSurface.setColor(this.color);
        drawSurface.fillRectangle((int)this.rectangle.getUpperLeft().getX(),(int)this.rectangle.getUpperLeft().getY(),(int)this.rectangle.getWidth(),(int)this.rectangle.getHeight());
    }

    @Override
    public void timePassed(){}

    public void addToGame(GameLevel g){
        g.getSprites().addSprite(this);
        g.getEnvironment().addCollidable(this);
    }

    public void removeFromGame(GameLevel g){
       g.getSprites().removeSprite(this);
       g.getEnvironment().removeCollidable(this);
    }

    public void setColor(Color color) {this.color = color;}

    @Override
    // Add hl as a listener to hit events.
    public void addHitListener(HitListener hl){
        this.hitListenerList.add(hl);
    }

    @Override
    // Remove hl from the list of listeners to hit events.
    public void removeHitListener(HitListener hl){
        this.hitListenerList.remove(hl);
    }

    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListenerList);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }
}
