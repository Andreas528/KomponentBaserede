package dk.sdu.score;

import dk.sdu.common.data.GameData;
import dk.sdu.common.service.ScoreSPI;
import javafx.scene.text.Text;

public class Score implements ScoreSPI {

    private final Text scoreText;

    public Score() {
        scoreText = new Text(10, 20, "Destroyed asteroids: 0");
        scoreText.setFill(javafx.scene.paint.Color.GREEN);
    }

    @Override
    public Text getScoreText() {
        return scoreText;
    }

    @Override
    public void update(GameData gameData) {
        scoreText.setText("Destroyed asteroids: " + gameData.getScore());
    }
}
