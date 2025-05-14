package dk.sdu.common.data;
public class GameData {

    private int displayWidth  = 800 ;
    private int displayHeight = 800;
    private int score = 0;
    private final GameInputs inputs = new GameInputs();

    public int getScore() {
        return score;
    }

    public void addScore () {
        score++;
    }

    public void addScore (int score) {
        this.score += score;
    }


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


}
