import java.awt.Color;
import java.util.ArrayList;
import java.util.List;



public class Level1 implements LevelInformation {

    @Override
    public int numberOfBalls() {
        return 1;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocities = new ArrayList<>();
        velocities.add(new Velocity(0, -5));
        return velocities;
    }

    @Override
    public int paddleSpeed() {
        return 5;
    }

    @Override
    public int paddleWidth() {
        return 80;
    }

    @Override
    public String levelName() {
        return "Direct Hit";
    }

    @Override
    public Sprite getBackground() {
        return new Background(Color.BLACK);
    }

    @Override
    public List<Block> blocks() {
        List<Block> blocksList = new ArrayList<>();
        // Creating the block directly inside the method
        Rectangle rect = new Rectangle(new Point(380, 150), 40, 40);
        Block block = new Block(rect);
        block.setColor(Color.RED);
        blocksList.add(block);
        return blocksList;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 1;
    }
}