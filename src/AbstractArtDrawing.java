import biuoop.GUI;
import biuoop.DrawSurface;

import java.util.Random;
import java.awt.Color;

public class AbstractArtDrawing {

    //generate a random line making sure the start point <= end point
    public Line generateRandomLine(){
        Random rand = new Random(); // create a random-number generator

        int startX = rand.nextInt(400) + 1; // get integer in range 1-400
        int startY = rand.nextInt(300) + 1; // get integer in range 1-300
        int endX = rand.nextInt(400 - startX) + startX; // get integer in range startx-400
        int endY = rand.nextInt(300) + 1; // get integer in range 1-300

        Point start = new Point(startX,startY);
        Point end = new Point(endX,endY);
        Line line = new Line(start,end);

        return line;
    }

    //draws lines in a draw surface
    public void drawLine(Line l, DrawSurface d){
        d.setColor(Color.BLACK);
        d.drawLine((int) l.getStart().getX(), (int) l.getStart().getY(), (int) l.getEnd().getX(), (int) l.getEnd().getY());
    }


    public void drawRandomCircles() {

        // Create a window with the title "Random Circles Example"
        // which is 400 pixels wide and 300 pixels high.
        GUI gui = new GUI("Random Circles Example", 400, 300);
        DrawSurface d = gui.getDrawSurface();
        Line[] lines = new Line[10];
        int count = 0;
        for (int i = 0; i < 10; ++i) {
            Line line = generateRandomLine();
            lines[count] = line;
            count++;
            drawLine(line,d);

            int x = (int) line.middle().getX(); // creates the red middle point
            int y = (int) line.middle().getY();
            int r = 3;
            d.setColor(Color.RED);
            d.fillCircle(x,y,r);
        }

        for (int i = 0 ; i < 9; i++){ // checks if there's an intersection point between any of the array lines.
            for (int j = i+1; j < 10; j++){
                if (lines[i].isIntersecting(lines[j])){
                    Point intersection = (lines[i].intersectionWith(lines[j]));

                    int x = (int) intersection.getX(); //creates the blue intersection point
                    int y = (int) intersection.getY();
                    int r = 3;
                    d.setColor(Color.BLUE);
                    d.fillCircle(x,y,r);
                }

            }
        }

        gui.show(d);
    }

    public static void main(String[] args) {
        AbstractArtDrawing example = new AbstractArtDrawing();
        example.drawRandomCircles();
    }
}
