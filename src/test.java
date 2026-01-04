import biuoop.GUI;
import biuoop.KeyboardSensor;
import biuoop.Sleeper;

import java.util.ArrayList;
import java.util.List;

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
        int framePerSecond = 60;
        GUI gui = new GUI("game", 800, 600);
        Sleeper sleeper = new Sleeper();
        AnimationRunner runner = new AnimationRunner(framePerSecond,sleeper,gui);
        KeyboardSensor keyboardSensor = runner.getGui().getKeyboardSensor();
        LevelInformation levelInformation1 = new Level1();
        LevelInformation levelInformation2 = new Level2();
        LevelInformation levelInformation3 = new Level3();
        LevelInformation levelInformation4 = new Level4();
        List<LevelInformation> levels = new ArrayList<>();
        levels.add(levelInformation1);
        levels.add(levelInformation2);
        levels.add(levelInformation3);
        levels.add(levelInformation4);

        GameFlow gameFlow = new GameFlow(runner, keyboardSensor);
        gameFlow.runLevels(levels);
        gui.close();
   }
}
