public class CollisionInfo {

    private Collidable collidable;
    private Point collisionPoint;

    // constructor
    public CollisionInfo(Collidable collidable, Point point){
        this.collidable = collidable;
        this.collisionPoint = point;
    }

    // The point at which the collision occurs.
    public Point collisionPoint(){return this.collisionPoint;}

    // The collidable object involved in the collision.
    public Collidable collisionObject(){return this.collidable;}
}
