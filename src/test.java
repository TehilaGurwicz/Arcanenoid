import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;
import org.ietf.jgss.GSSContext;

import java.awt.*;

public class test {
    public static void main(String[] args){
////    GUI gui = new GUI("gui",800,600);
////    GameEnvironmant environmant = new GameEnvironmant();
////    Ball ball = new Ball(new Point(300,300),10, Color.BLACK,environmant);
////    ball.setVelocity(1 ,1);
////
////    Rectangle rectangle = new Rectangle(new Point(0,0),800,40);
////    Block block = new Block(rectangle);
////    environmant.addCollidable(block);
////
////    Rectangle rectangleD = new Rectangle(new Point(0,560),800,40);
////    Block blockD = new Block(rectangleD);
////    environmant.addCollidable(blockD);
////
////    Rectangle rectangleL = new Rectangle(new Point(0,0),40,600);
////    Block blockL = new Block(rectangleL);
////    environmant.addCollidable(blockL);
////
////    Rectangle rectangleR = new Rectangle(new Point(760,0),40,600);
////    Block blockR = new Block(rectangleR);
////    environmant.addCollidable(blockR);
////
////    Sleeper sleeper = new Sleeper();
////
////    while(true){
////        DrawSurface drawSurface = gui.getDrawSurface();
////
////        block.drawOn(drawSurface);
////        blockD.drawOn(drawSurface);
////        blockL.drawOn(drawSurface);
////        blockR.drawOn(drawSurface);
////
////        ball.drawOn(drawSurface);
////        ball.moveOneStep();
////
////        sleeper.sleepFor(10);
////        gui.show(drawSurface);
////    }
//        SpriteCollection sprites = new SpriteCollection();
//        GameEnvironmant environment = new GameEnvironmant();
//        Game game = new Game(sprites,environment);
//            game.initialize();
//            game.run();
//
//    }
//}




//        // צור אוסף ספרייטים ואובייקט GameEnvironment
//        SpriteCollection sprites = new SpriteCollection();
//        GameEnvironmant environment = new GameEnvironmant();
//
//        // צור את המשחק
//        Game game = new Game(sprites, environment);
//
//        // אתחל את המשחק
//        game.initialize();
//
//        // --- הוספת בלוקים נוספים פנימיים ---
//        // לדוגמה, בלוק 3x3 במרכז המסך
//        int blockWidth = 60;
//        int blockHeight = 20;
//        int startX = 200;
//        int startY = 200;
//
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 3; j++) {
//                Rectangle rect = new Rectangle(
//                        new Point(startX + i * (blockWidth + 10), startY + j * (blockHeight + 10)),
//                        blockWidth,
//                        blockHeight
//                );
//                Block block = new Block(rect);
//                block.addToGame(game); // מוסיף גם ל-sprites וגם ל-collidables
//            }
//        }
//
//        // הרץ את הלולאת אנימציה
//        game.run();

//        GUI gui = new GUI("game",
        Game game = new Game();
        game.initialize();
            game.run();
   }
}
