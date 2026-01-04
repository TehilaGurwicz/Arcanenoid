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

    public void removeSprite(Sprite s){
        this.sprites.remove(s);
    }

    // call timePassed() on all sprites.
    public void notifyAllTimePassed(){
        List<Sprite> spritesCopy = new ArrayList<>(this.sprites);
        for(Sprite sprite : spritesCopy){
            sprite.timePassed();
        }
    }

    // call drawOn(d) on all sprites.
    //copied the this.sprites to a new arrayList so it won't make trouble went the blockRemover
    //erases one of the sprites.
    public void drawAllOn(DrawSurface d){
        List<Sprite> spritesCopy = new ArrayList<>(this.sprites);
        for(Sprite sprite : spritesCopy){
            sprite.drawOn(d);
        }
    }
}
