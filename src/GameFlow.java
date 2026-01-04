import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import biuoop.KeyboardSensor;

public class GameFlow {
    //private KeyboardSensor keyboardSensor;
    private AnimationRunner animationRunner;
    private Counter score;
    private KeyboardSensor keyboard;

    public GameFlow(AnimationRunner ar, KeyboardSensor ks) {
        this.keyboard = ks;
        this.animationRunner = ar;
    }

    public void runLevels(List<LevelInformation> levels) {
        this.score = new Counter(0);
        for (LevelInformation levelInfo : levels) {
            GameLevel level = new GameLevel(this.animationRunner,levelInfo, this.score);
            level.initialize();

            while (level.getCounter().getValue() != 0 && level.getBallCount().getValue() != 0) {//has more blocks and balls
                level.run();
            }

            if (level.getBallCount().getValue() == 0) {
                break;
            }
        }
        //if the player gets here - he wins - he finished level 4 successfully
        this.animationRunner.run(new WinScreen(this.keyboard, this.score));
    }
}
