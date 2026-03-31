public class BallRemover implements HitListener{
    private Game game;
    private Counter remainBall;

    public BallRemover(Game game, Counter count){
        this.game = game;
        this.remainBall = count;
    }

    @Override
    public void hitEvent(Block beingHit, Ball hitter){
        hitter.removeFromGame(this.game);
        remainBall.decrease(1);
    }
}
