import biuoop.DrawSurface;
import biuoop.GUI;
import java.awt.*;
import java.lang.Math;
import java.awt.Color;

/*This class was necessary in order to manage to draw 2 squares on the same time  */

public class Frame {

    private Point leftUp;
    private int height;
    private int width;
    private java.awt.Color color;
    //private DrawSurface surface;

    // constructor
    public Frame(Point leftUp, int height, int width , Color color){
        this.leftUp = leftUp;
        this.height = height;
        this.width = width;
        this.color = color;
    }
    public void drawFrame(DrawSurface d){
        d.setColor(this.color);
        d.fillRectangle((int) this.leftUp.getX(), (int) this.leftUp.getY(), this.width, this.height);
    }


    public int getLeftUpX() {return (int)(this.leftUp.getX());}
    public int getLeftUpY() {return (int)(this.leftUp.getY());}
    public int getHeight() {return this.height;}
    public int getWidth() {return this.width;}
}
