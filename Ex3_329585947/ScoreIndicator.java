import biuoop.DrawSurface;

public class ScoreIndicator implements Sprite {
    private int score;


    //constructor
    public ScoreIndicator(int score){
        this.score = score;
    }

    public void increase(int num) {this.score += num;}
    public void update(int num){this.score=num;}

    @Override
    public void drawOn(DrawSurface d){
        d.drawText(400,50,"Score: " + this.score,20);
    }

    public void addToGame(Game g) {g.getSprites().addSprite(this);}

    // notify the sprite that time has passed
    @Override
    public void timePassed(){


    }
}
