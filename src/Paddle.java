import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.KeyboardSensor;


public class Paddle implements Sprite, Collidable {
    private biuoop.KeyboardSensor keyboard;
    private GUI gui;
    private Rectangle rectangle;
    private int speed = 10;

    //constructor
    public Paddle(Rectangle rectangle,biuoop.KeyboardSensor keyboard){
        this.rectangle = rectangle;
        this.keyboard = keyboard;
    }


    //moves  the paddle, makes sure it doesn't go out of the frame blocks
    public void moveLeft(){
        if(this.rectangle.getUpperLeft().getX() - this.speed >= 0) {
        this.rectangle = new Rectangle(new Point(this.rectangle.getUpperLeft().getX() - this.speed, this.rectangle.getUpperLeft().getY()),this.rectangle.getWidth(),this.rectangle.getHeight());
        }
    }

    //moves  the paddle, makes sure it doesn't go out of the frame blocks
    public void moveRight(){
        if(this.rectangle.getUpperLeft().getX() + this.rectangle.getWidth() + this.speed <= 780) {
            this.rectangle = new Rectangle(new Point(this.rectangle.getUpperLeft().getX() + this.speed,this.rectangle.getUpperLeft().getY()),this.rectangle.getWidth(),this.rectangle.getHeight());
        }
    }

    // Sprite
    @Override
    public void timePassed(){
        if(this.keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {this.moveLeft();}
        if(this.keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {this.moveRight();}
    }

    @Override
    public void drawOn(DrawSurface d){
        d.fillRectangle((int)this.rectangle.getUpperLeft().getX(),(int)this.rectangle.getUpperLeft().getY(),(int)this.rectangle.getWidth(),(int)this.rectangle.getHeight());
    }

    // Collidable
    @Override
    public Rectangle getCollisionRectangle() {return this.rectangle;}

    @Override
    public Velocity hit(Point collisionPoint, Velocity currentVelocity){

        //holds the X value that each of the 5 paddle parts starts in.
        double[] paddleParts = new double[5];
        for(int i = 0; i < 5; i++){
            paddleParts[i] = this.rectangle.getUpperLeft().getX() + i*(this.rectangle.getWidth()/5);
        }
        if(collisionPoint.getX() >= paddleParts[0] && collisionPoint.getX() < paddleParts[1]) {
            return Velocity.fromAngleAndSpeed(300,5);
        }
        else if(collisionPoint.getX() >= paddleParts[1] && collisionPoint.getX() < paddleParts[2]) {
            return Velocity.fromAngleAndSpeed(330,5);
        }
        else if(collisionPoint.getX() >= paddleParts[2] && collisionPoint.getX() < paddleParts[3]) {
            return Velocity.fromAngleAndSpeed(0,5);
        }
        else if(collisionPoint.getX() >= paddleParts[3] && collisionPoint.getX() < paddleParts[4]) {
            return Velocity.fromAngleAndSpeed(30,5);
        }
        else if(collisionPoint.getX() >= paddleParts[4]) {
            return Velocity.fromAngleAndSpeed(60,5);
        }
        return null;
        }


    // Add this paddle to the game.
    public void addToGame(Game g){
        g.getSprites().addSprite(this);
        g.getEnvironment().addCollidable(this);
    }
}