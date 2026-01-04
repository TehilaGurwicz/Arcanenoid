import biuoop.DrawSurface;
import java.awt.Color;

public class Background implements Sprite {
    private Color color;

    public Background(Color color) {
        this.color = color;
    }

    @Override
    public void drawOn(DrawSurface d) {
        // Paints the entire screen with the chosen color
        d.setColor(this.color);
        d.fillRectangle(0, 0, 800, 600);
    }

    @Override
    public void timePassed() {
        // Do nothing
    }
}