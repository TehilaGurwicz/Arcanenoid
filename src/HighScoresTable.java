import java.io.*;

public class HighScoresTable {
    private int size;
    private int highScore;

    public HighScoresTable(int size) {
        this.size = size;
        this.highScore = 0;
    }

    public void add(int score) {
        if (score > this.highScore) {
            this.highScore = score;
        }
    }

    public int getHighScore() {
        return this.highScore;
    }

    // Load table data from file
    public void load(File filename) throws IOException {
        if (!filename.exists()) {
            return;
        }

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(filename));
            String line = reader.readLine();
            // Format expected: "The highest score so far is: X"
            if (line != null && line.startsWith("The highest score so far is:")) {
                String scoreStr = line.split(":")[1].trim();
                this.highScore = Integer.parseInt(scoreStr);
            }
        } catch (Exception e) {
            System.err.println("Failed to load high score");
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
    }

    // Save table data to file
    public void save(File filename) throws IOException {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(new FileWriter(filename));
            writer.println("The highest score so far is: " + this.highScore);
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }

    public static HighScoresTable loadFromFile(File filename) {
        HighScoresTable table = new HighScoresTable(5);
        try {
            table.load(filename);
        } catch (IOException e) {
            // Start with empty table
        }
        return table;
    }
}