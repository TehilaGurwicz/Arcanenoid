import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;


public class AnimationRunner {
    private GUI gui;
    private int framesPerSecond;
    private Sleeper sleeper;

    public AnimationRunner(int framesPerSecond, Sleeper sleeper, GUI gui){
        this.gui = gui;
        this.framesPerSecond = framesPerSecond;
        this.sleeper = sleeper;
    }
    public void run(Animation animation) {
        int millisecondsPerFrame = 1000 / this.framesPerSecond;
        while (!animation.shouldStop()) {
            long startTime = System.currentTimeMillis(); // timing
            DrawSurface d = this.gui.getDrawSurface();

            animation.doOneFrame(d);

            this.gui.show(d);
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                this.sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
    }

    public GUI getGui() {return this.gui;}
}