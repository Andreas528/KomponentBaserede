package dk.sdu.common.data;
public class GameData {

    private int displayWidth  = 800 ;
    private int displayHeight = 800;
    private final GameInputs inputs = new GameInputs();
    private int score = 0;

    public synchronized GameInputs getInputs() {
        return inputs;
    }

    public void setDisplayWidth(int width) {
        this.displayWidth = width;
    }

    public int getDisplayWidth() {
        return displayWidth;
    }

    public void setDisplayHeight(int height) {
        this.displayHeight = height;
    }

    public int getDisplayHeight() {
        return displayHeight;
    }


    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
