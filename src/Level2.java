import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class Level2 implements LevelInformation {
    @Override
    public int numberOfBalls(){return 10;}

    // The initial velocity of each ball
    // Note that initialBallVelocities().size() == numberOfBalls()
    public List<Velocity> initialBallVelocities(){
        List<Velocity> velocities = new ArrayList<>();
        //We create 10 velocities.
        //To make them spread like a fan, we change the angle/DX.
        //Negative DX goes left, positive DX goes right.
        //All DY are negative (-5) to make them go UP.
        for (int i = 0; i < 10; i++) {
            // This will create a spread of DX values: -5, -4, -3, -2, -1, 1, 2, 3, 4, 5
            int dx = -5 + i;
            if (dx >= 0) {
                dx++; // Skip 0 so no ball goes perfectly vertical if you want variety
            }

            velocities.add(new Velocity(dx, -5));
        }

        return velocities;
    }
    @Override
    public int paddleSpeed() {
        return 2; // Slow and steady movement for a giant paddle
    }

    @Override
    public int paddleWidth() {
        return 600; // Covers 75% of the screen width
    }

    public String levelName(){return "Wide Easy";}

    // Returns a sprite with the background of the level
    public Sprite getBackground(){
        return new Background(Color.WHITE);
    }

    // The Blocks that make up this level, each block contains
    // its size, color and location.
    @Override
    public List<Block> blocks() {
        List<Block> blocksList = new ArrayList<>();

        // Defining the colors for the 15 blocks
        Color[] colors = {Color.RED, Color.RED, Color.ORANGE, Color.ORANGE, Color.YELLOW, Color.YELLOW, Color.GREEN, Color.GREEN, Color.GREEN, Color.BLUE, Color.BLUE, Color.PINK, Color.PINK, Color.CYAN, Color.CYAN};

        int blockWidth = 50;
        // Creating the 15 blocks in a single row
        for (int i = 0; i < 15; i++) {
            Point p = new Point(25 + (i * blockWidth), 250);
            Block b = new Block(new Rectangle(p, blockWidth, 20));
            b.setColor(colors[i]);
            blocksList.add(b);
        }
        return blocksList;
    }

    // Number of blocks that should be removed
    // before the level is considered to be "cleared".
    // This number should be <= blocks.size();
    public int numberOfBlocksToRemove(){return 15;}
}
