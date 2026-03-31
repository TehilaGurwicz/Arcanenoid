import biuoop.GUI;
import biuoop.KeyboardSensor;
import biuoop.Sleeper;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int framesPerSecond = 60;
        GUI gui = new GUI("Arkanoid Game", 800, 600);
        Sleeper sleeper = new Sleeper();
        AnimationRunner runner = new AnimationRunner(framesPerSecond, sleeper, gui);
        KeyboardSensor keyboardSensor = runner.getGui().getKeyboardSensor();

        // Initialize levels
        List<LevelInformation> levels = new ArrayList<>();
        levels.add(new Level1());
        levels.add(new Level2());
        levels.add(new Level3());
        levels.add(new Level4());

        // Run the game
        GameFlow gameFlow = new GameFlow(runner, keyboardSensor);
        gameFlow.runLevels(levels);

        gui.close();
    }
}

