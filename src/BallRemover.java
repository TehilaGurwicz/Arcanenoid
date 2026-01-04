public class BallRemover implements HitListener{
    private GameLevel gameLevel;
    private Counter remainBall;

    public BallRemover(GameLevel gameLevel, Counter count){
        this.gameLevel = gameLevel;
        this.remainBall = count;
    }

    @Override
    public void hitEvent(Block beingHit, Ball hitter){
        hitter.removeFromGame(this.gameLevel);
        remainBall.decrease(1);
    }
}
