import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

public class WinScreen implements Animation{
    private KeyboardSensor keyboard;
    private boolean stop;
    private Counter score;

    public WinScreen (KeyboardSensor k, Counter s){
        this.keyboard = k;
        this.score = s;
        this.stop = false;
    }
    @Override
    public void doOneFrame(DrawSurface d){
        d.drawText(10, d.getHeight() / 2, "You Win! Your score is " + this.score.getValue(), 32);
        if (this.keyboard.isPressed(KeyboardSensor.SPACE_KEY)) { this.stop = true; }
    }

    @Override
    public boolean shouldStop(){return this.stop;}
}
