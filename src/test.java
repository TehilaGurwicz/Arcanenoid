import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;
import org.ietf.jgss.GSSContext;

import java.awt.*;

public class test {
    public static void main(String[] args){
    GUI gui = new GUI("gui",800,600);
    GameEnvironmant environmant = new GameEnvironmant();
    Ball ball = new Ball(new Point(300,300),10, Color.BLACK,environmant);
    ball.setVelocity(1,1);

    Rectangle rectangle = new Rectangle(new Point(0,0),800,40);
    Block block = new Block(rectangle);
    environmant.addCollidable(block);

    Rectangle rectangleD = new Rectangle(new Point(0,560),800,40);
    Block blockD = new Block(rectangleD);
    environmant.addCollidable(blockD);

    Rectangle rectangleL = new Rectangle(new Point(0,0),40,600);
    Block blockL = new Block(rectangleL);
    environmant.addCollidable(blockL);

    Rectangle rectangleR = new Rectangle(new Point(760,0),40,600);
    Block blockR = new Block(rectangleR);
    environmant.addCollidable(blockR);

    Sleeper sleeper = new Sleeper();

    while(true){
        DrawSurface drawSurface = gui.getDrawSurface();
        block.drawOn(drawSurface);
        blockD.drawOn(drawSurface);
        blockL.drawOn(drawSurface);
        blockR.drawOn(drawSurface);
        ball.drawOn(drawSurface);
        ball.moveOneStep();
        sleeper.sleepFor(10);
        gui.show(drawSurface);
    }
    }
}
