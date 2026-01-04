import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class Level4 implements LevelInformation {
    @Override
    public int numberOfBalls(){return 3;}
    // The initial velocity of each ball
    // Note that initialBallVelocities().size() == numberOfBalls()
    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocities = new ArrayList<>();
        velocities.add(new Velocity(-4, -4)); // Left and up
        velocities.add(new Velocity(0, -5));  // Straight up
        velocities.add(new Velocity(4, -4));  // Right and up
        return velocities;
    }
    @Override
    public int paddleSpeed(){return 5;}
    @Override
    public int paddleWidth(){return 100;}

    // the level name will be displayed at the top of the screen.
    @Override
    public String levelName(){return "Final Four";}

    // Returns a sprite with the background of the level
    @Override
    public Sprite getBackground(){return new Background(new Color(0, 153, 255));}

    // The Blocks that make up this level, each block contains
    // its size, color and location.
    @Override
    public List<Block> blocks() {
        List<Block> blockList = new ArrayList<>();
        Color[] colors = {Color.GRAY, Color.RED, Color.YELLOW, Color.GREEN, Color.WHITE, Color.PINK, Color.CYAN};

        int startY = 100;
        int blockWidth = 50; // Each row will have about 15-16 blocks
        int blockHeight = 20;

        for (int i = 0; i < 7; i++) { // 7 Rows
            for (int j = 0; j < 15; j++) { // Blocks that fill the row
                int x = 25 + (j * blockWidth);
                int y = startY + (i * blockHeight);

                Block b = new Block(new Rectangle(new Point(x, y), blockWidth, blockHeight));
                b.setColor(colors[i]);
                blockList.add(b);
            }
        }
        return blockList;
    }

    // Number of blocks that should be removed
    // before the level is considered to be "cleared".
    // This number should be <= blocks.size();
    public int numberOfBlocksToRemove() {return 105;}
}