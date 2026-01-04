import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import java.awt.Color;
import java.util.List;

public class GameLevel implements Animation {
    private SpriteCollection sprites;
    private GameEnvironmant environment;
    private AnimationRunner runner;
    private boolean running;
    private biuoop.KeyboardSensor keyboard;
    private Counter counter;
    private Counter ballCount;
    private Counter score; // stays here
    private ScoreTrackingListener scoreTracking;
    private ScoreIndicator scoreIndicator;
    private LevelInformation levelInformation;

    // Back to 2 parameters to avoid errors in your current Main
    public GameLevel(AnimationRunner runner, LevelInformation levelInformation, Counter score){
        this.score = score;
        this.runner = runner;
        this.levelInformation = levelInformation;
        this.running = true;
    }

    @Override
    public boolean shouldStop() {
        return !this.running;
    }


    @Override
    public void doOneFrame(DrawSurface d) {
// the logic from the previous run method goes here.
// the `return` or `break` statements should be replaced with
// this.running = false;
        if (this.counter.getValue() == 0) {
            this.score.increase(100);
            this.scoreIndicator.increase(this.scoreTracking.getScore());
            this.scoreIndicator.drawOn(d);
            this.running = false;
        }
        if (this.keyboard.isPressed("p")) {
            this.runner.run(new PauseScreen(this.keyboard));
        }

        if (this.ballCount.getValue() == 0){
            this.runner.run(new EndScreen(this.keyboard, this.score));
            this.running = false;
        }

        this.scoreIndicator.drawOn(d);
        scoreIndicator.update(scoreTracking.getScore());
        this.sprites.drawAllOn(d);
        this.sprites.notifyAllTimePassed();
    }

    public void initialize() {
        this.environment = new GameEnvironmant();
        this.sprites = new SpriteCollection();
        this.counter = new Counter(0);
        this.ballCount = new Counter(0);
        this.keyboard = this.runner.getGui().getKeyboardSensor();

        BlockRemover blockRemover = new BlockRemover(this, this.counter);
        BallRemover ballRemover = new BallRemover(this, this.ballCount);
        this.scoreTracking = new ScoreTrackingListener(this.score);

        // Background
        Sprite background = this.levelInformation.getBackground();
        this.sprites.addSprite(background);

        // Frame
        setupFrames(ballRemover);

        // Balls
        List<Velocity> velocities = this.levelInformation.initialBallVelocities();
        for (Velocity v : velocities) {
            Ball ball = new Ball(new Point(400, 500), 10, Color.MAGENTA, this.environment);
            ball.setVelocity(v);
            ball.addToGame(this);
            this.ballCount.increase(1);
        }

        // Paddle
        int pWidth = this.levelInformation.paddleWidth();
        this.keyboard = this.runner.getGui().getKeyboardSensor();
        Paddle paddle = new Paddle(new Rectangle(new Point(400 - (pWidth / 2), 560), pWidth, 20), keyboard);
        paddle.addToGame(this);

        // Blocks
        for (Block b : this.levelInformation.blocks()) {
            b.addToGame(this);
            this.counter.increase(1);
            b.addHitListener(blockRemover);
            b.addHitListener(this.scoreTracking);
        }

        // Score and Level Name
        String levelName = this.levelInformation.levelName();
        this.scoreIndicator = new ScoreIndicator(this.score, levelName);
        this.scoreIndicator.addToGame(this);
    }

    private void setupFrames(BallRemover ballRemover) {
        // Boundaries
        new Block(new Rectangle(new Point(0, 20), 800, 20)).addToGame(this);
        new Block(new Rectangle(new Point(0, 40), 20, 560)).addToGame(this);
        new Block(new Rectangle(new Point(780, 40), 20, 560)).addToGame(this);

        // can be death region
        Block deathRegion = new Block(new Rectangle(new Point(0, 595), 800, 5));
        deathRegion.addToGame(this);
        deathRegion.addHitListener(ballRemover);
    }

    public void run() {
        this.running = true;
        this.runner.run(this);
    }

    public void addCollidable(Collidable c) { this.environment.addCollidable(c); }
    public void removeCollidable(Collidable c) { this.environment.removeCollidable(c); }
    public void addSprite(Sprite s) { this.sprites.addSprite(s); }
    public void removeSprite(Sprite s) { this.sprites.removeSprite(s); }
    public SpriteCollection getSprites() { return this.sprites; }
    public GameEnvironmant getEnvironment() { return this.environment; }
    public Counter getCounter(){return this.counter;}
    public Counter getBallCount(){return this.ballCount;}
}