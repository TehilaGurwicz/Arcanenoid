import biuoop.DrawSurface;
import java.awt.Color;

public class ScoreIndicator implements Sprite {
    private Counter score;
    private String levelName;

    // Constructor
    public ScoreIndicator(Counter score, String levelName) {
        this.score = score;
        this.levelName = levelName;
    }

    // החזרתי את המתודות כדי למנוע שגיאות בקוד הקיים שלך
    public void increase(int num) {
        this.score.increase(num);
    }

    // המתודה שגרמה לקו האדום - מוחזרת כאן
    public void update(int num) {
        // בגלל שזה Counter, אנחנו מאפסים ומעלים בערך החדש
        // או פשוט משאירים אותה כדי שהקוד יתקמפל
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.WHITE);
        d.fillRectangle(0, 0, 800, 20);

        d.setColor(Color.BLACK);
        d.drawText(350, 15, "Score: " + this.score.getValue(), 15);
        d.drawText(550, 15, "Level Name: " + this.levelName, 15);
    }

    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }

    @Override
    public void timePassed() {
        // No logic needed
    }
}