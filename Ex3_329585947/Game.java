import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.KeyboardSensor;
import biuoop.Sleeper;

import java.awt.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;


public class Game {
    private SpriteCollection sprites;
    private GameEnvironmant environment;
    private GUI gui;
    private biuoop.KeyboardSensor keyboard;
    private Counter counter;
    private Counter ballCount;
    private Counter score;
    private ScoreTrackingListener scoreTracking;
    private ScoreIndicator scoreIndicator;


    public void addCollidable(Collidable c) {this.environment.addCollidable(c);}
    public void removeCollidable(Collidable c) {this.environment.removeCollidable(c);}

    public void addSprite(Sprite s){this.sprites.addSprite(s);}
    public void removeSprite(Sprite s){this.sprites.removeSprite(s);}

//    public static java.awt.Color getRandomColor() {
//        Random rand = new Random();
//        int red = rand.nextInt(255);
//        int green = rand.nextInt(255);
//        int blue = rand.nextInt(255);
//        return new java.awt.Color(red,green,blue);
//    }

    public static java.awt.Color[] getColor(){
        java.awt.Color[] colors = new java.awt.Color[6];
        colors[0] = Color.RED;
        colors[1] = Color.ORANGE;
        colors[2] = Color.YELLOW;
        colors[3] = Color.GREEN;
        colors[4] = Color.CYAN;
        colors[5] = Color.BLUE;
        return colors;
    }

    // Initialize a new game: create the Blocks and Ball (and Paddle)
    // and add them to the game.
    public void initialize(){
        this.gui = new GUI("game",800,600);
        this.environment = new GameEnvironmant();
        this.sprites = new SpriteCollection();
        this.counter = new Counter(0);
        this.ballCount = new Counter(0);
        this.score = new Counter(0);

        BlockRemover blockRemover = new BlockRemover(this, this.counter);
        BallRemover ballRemover = new BallRemover(this,this.ballCount);

        this.scoreTracking = new ScoreTrackingListener(this.score);

        this.scoreIndicator = new ScoreIndicator(this.scoreTracking.getScore());
        this.scoreIndicator.addToGame(this);


        Ball ball1 = new Ball(new Point(100,100),10,Color.MAGENTA, this.environment);
        ball1.addToGame(this);
        this.ballCount.increase(1);
        ball1.setVelocity(2,3);

        Ball ball2 = new Ball(new Point(99,300),10, Color.PINK, this.environment);
        ball2.addToGame(this);
        this.ballCount.increase(1);
        ball2.setVelocity(1,1);

        Ball ball3 = new Ball(new Point(99,300),10, Color.CYAN, this.environment);
        ball3.addToGame(this);
        this.ballCount.increase(1);
        ball3.setVelocity(4,5);

//        Rectangle scoreRect = new Rectangle(new Point(370,0),60,20);
//        Block score1 = new Block(scoreRect);
//        score1.addToGame(this);
//        score1.setColor(Color.WHITE);


        //Setting the frame surrounding blocks
        Rectangle rectangle = new Rectangle(new Point(0,0),800,20);
        Block block = new Block(rectangle);
        block.addToGame(this);

        Rectangle rectangleD = new Rectangle(new Point(0,580),800,20);
        Block deathRegion = new Block(rectangleD);
        deathRegion.addToGame(this);
        deathRegion.addHitListener(ballRemover);

        Rectangle rectangleL = new Rectangle(new Point(0,0),20,600);
        Block blockL = new Block(rectangleL);
        blockL.addToGame(this);

        Rectangle rectangleR = new Rectangle(new Point(780,0),20,600);
        Block blockR = new Block(rectangleR);
        blockR.addToGame(this);

        Point upperLeft = new Point(400,550);
        Rectangle rectangleP= new Rectangle(upperLeft,60,20);
        KeyboardSensor keyboard = this.gui.getKeyboardSensor();
        Paddle paddle = new Paddle(rectangleP,keyboard);
        paddle.addToGame(this);

        java.awt.Color[] color = getColor();
        int count = 6;
        int yPoint = 200;
        for(int i = 0; i < 6; i++){
            count++;
            yPoint += 20;
            int xPoint = 725;
            for(int j = count; j <19; j++){
                Rectangle rect = new Rectangle(new Point(xPoint,yPoint),55,20);
                Block block1 = new Block(rect);
                block1.addToGame(this);
                block1.setColor(color[i]);
                this.counter.increase(1);
                block1.addHitListener(blockRemover);
                block1.addHitListener(this.scoreTracking);
                xPoint -= 55;
            }
        }
    }

    // Run the game -- start the animation loop.
    public void run() {
        Sleeper sleeper = new Sleeper();
        int framesPerSecond = 60;
        int millisecondsPerFrame = 1000 / framesPerSecond;
        while (true) {
            long startTime = System.currentTimeMillis(); // timing
            DrawSurface d = this.gui.getDrawSurface();

            if(this.counter.getValue() == 0){
                this.score.increase(100);
                this.scoreIndicator.increase(this.scoreTracking.getScore());
                this.scoreIndicator.drawOn(d);
                break;
            }

            if(this.ballCount.getValue() == 0)
                break;

            this.scoreIndicator.drawOn(d);
            scoreIndicator.update(scoreTracking.getScore());
            this.sprites.drawAllOn(d);
            this.sprites.notifyAllTimePassed();
            this.gui.show(d);

            // timing
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
        this.gui.close();
    }


    public SpriteCollection getSprites() {return this.sprites;}
    public GameEnvironmant getEnvironment() {return this.environment;}
}
