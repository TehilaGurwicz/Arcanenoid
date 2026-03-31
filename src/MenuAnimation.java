import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class MenuAnimation<T> implements Menu<T> {
    private String title;
    private KeyboardSensor keyboard;
    private List<String> keys;
    private List<String> messages;
    private List<T> returnVals;
    private T status;
    private boolean stop;

    public MenuAnimation(String title, KeyboardSensor keyboard) {
        this.title = title;
        this.keyboard = keyboard;
        this.keys = new ArrayList<>();
        this.messages = new ArrayList<>();
        this.returnVals = new ArrayList<>();
        this.stop = false;
    }

    @Override
    public void addSelection(String key, String message, T returnVal) {
        this.keys.add(key);
        this.messages.add(message);
        this.returnVals.add(returnVal);
    }

    @Override
    public T getStatus() {
        return this.status;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        d.setColor(Color.decode("#FFF0F5")); // Lavender background
        d.fillRectangle(0, 0, d.getWidth(), d.getHeight());

        d.setColor(Color.BLACK);
        d.drawText(50, 50, this.title, 32);

        for (int i = 0; i < this.keys.size(); i++) {
            String text = "(" + this.keys.get(i) + ") " + this.messages.get(i);
            d.drawText(100, 120 + i * 40, text, 24);
        }

        for (int i = 0; i < this.keys.size(); i++) {
            if (this.keyboard.isPressed(this.keys.get(i))) {
                this.status = this.returnVals.get(i);
                this.stop = true;
                break;
            }
        }
    }

    @Override
    public boolean shouldStop() {
        return this.stop;
    }

    public void reset() {
        this.stop = false;
        this.status = null;
    }
}