import biuoop.DrawSurface;

public class HighScoresAnimation implements Animation {
    private HighScoresTable scores;

    public HighScoresAnimation(HighScoresTable scores) {
        this.scores = scores;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        d.setColor(java.awt.Color.ORANGE);
        d.fillRectangle(0, 0, d.getWidth(), d.getHeight());

        d.setColor(java.awt.Color.BLACK);
        d.drawText(50, 50, "High Scores", 32);
        d.drawText(100, 150, "The Highest Score is: " + scores.getHighScore(), 24);
        d.drawText(200, 400, "Press space to continue", 20);
    }

    @Override
    public boolean shouldStop() { return false; }
}