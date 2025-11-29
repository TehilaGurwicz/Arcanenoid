import biuoop.DrawSurface;

import java.util.ArrayList;
import java.util.List;

public class SpriteCollection {
    private List<Sprite> sprites;

    //constructor
    public SpriteCollection() {
        this.sprites = new ArrayList<Sprite>();
    }

    public void addSprite(Sprite s){
        this.sprites.add(s);
    }

    // call timePassed() on all sprites.
    public void notifyAllTimePassed(){
        for(Sprite sprite : this.sprites){
            sprite.timePassed();
        }
    }

    // call drawOn(d) on all sprites.
    public void drawAllOn(DrawSurface d){
        for(Sprite sprite : this.sprites){
            sprite.drawOn(d);
        }
    }
}
