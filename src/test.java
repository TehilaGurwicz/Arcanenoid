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
    ball.setVelocity(-1,-1);
    Rectangle rectangle = new Rectangle(new Point(0,0),800,40);
    Block block = new Block(rectangle);
    environmant.addCollidable(block);
    Sleeper sleeper = new Sleeper();

    while(true){
        DrawSurface drawSurface = gui.getDrawSurface();
        block.drawOn(drawSurface);
        ball.drawOn(drawSurface);
        ball.moveOneStep();
        sleeper.sleepFor(10);
        gui.show(drawSurface);
    }
    }
}
