import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class Level3 implements LevelInformation {

    @Override
    public int numberOfBalls(){return 2;}

    // The initial velocity of each ball
    // Note that initialBallVelocities().size() == numberOfBalls()
    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocities = new ArrayList<>();

        // Ball 1: heading slightly to the right and up
        velocities.add(new Velocity(4, -4));

        // Ball 2: heading slightly to the left and up
        velocities.add(new Velocity(-4, -4));

        return velocities;
    }
    @Override
    public int paddleSpeed(){return 5;}
    @Override
    public int paddleWidth(){return 100;}

    // the level name will be displayed at the top of the screen.
    @Override
    public String levelName(){return "Green 3";}

    // Returns a sprite with the background of the level
    @Override
    public Sprite getBackground(){return new Background(Color.GREEN);}

    // The Blocks that make up this level, each block contains
    // its size, color and location.
    // Here I just copied what I had in GameLevel.initialize before we added levels
    // The Blocks that make up this level, each block contains
    // its size, color and location.
    @Override
    public List<Block> blocks() {
        List<Block> blockList = new ArrayList<>(); // Creating the local list
        java.awt.Color[] colors = new java.awt.Color[5];
        colors[0] = Color.RED;
        colors[1] = Color.ORANGE;
        colors[2] = Color.YELLOW;
        colors[3] = Color.PINK;
        colors[4] = Color.CYAN;

        int count = 5;
        int yPoint = 150; // Starting height

        for (int i = 0; i < 5; i++) {
            count++;
            yPoint += 20;
            // 800 (screen width) - 20 (border) - 55 (block width) = 725
            int xPoint = 725;

            for (int j = count; j < 16; j++) {
                Rectangle rect = new Rectangle(new Point(xPoint, yPoint), 55, 20);
                Block block1 = new Block(rect);
                block1.setColor(colors[i]);

                // Add to the local list to avoid recursion
                blockList.add(block1);

                xPoint -= 55;
            }
        }
        return blockList; // Return the full list
    }
    // Number of blocks that should be removed
    // before the level is considered to be "cleared".
    // This number should be <= blocks.size();
    @Override
    public int numberOfBlocksToRemove(){return 40;}
}
