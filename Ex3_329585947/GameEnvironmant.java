import java.util.List;
import java.util.ArrayList;

public class GameEnvironmant {

    private List<Collidable> collidables;

    // constructor
    public GameEnvironmant(){this.collidables = new ArrayList<Collidable>();}


    // add the given collidable to the environment.
    public void addCollidable(Collidable c) {this.collidables.add(c);}
    public void removeCollidable(Collidable c) {this.collidables.remove(c);}



    // Assume an object moving from line.start() to line.end().
    // If this object will not collide with any of the collidables
    // in this collection, return null. Else, return the information
    // about the closest collision that is going to occur.
    public CollisionInfo getClosestCollision(Line trajectory){
        Point closest_Point =null;
        Collidable closestCollidable = null;
        for(Collidable collidable:this.collidables){
            List<Point>collisionPoints = collidable.getCollisionRectangle().intersectionPoints(trajectory);
            for(Point point:collisionPoints){
                if(closest_Point==null){
                    closest_Point=point;
                    closestCollidable = collidable;
                }
                else if(trajectory.getStart().distance(point) < trajectory.getStart().distance(closest_Point)){
                    closest_Point = point;
                    closestCollidable = collidable;
                }
            }
        }
        if (closest_Point == null) {return null;}
        return new CollisionInfo(closestCollidable,closest_Point);

    }

}
