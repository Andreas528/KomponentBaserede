package dk.sdu.common.service;
import dk.sdu.common.data.GameData;
import javafx.scene.text.Text;

/**
 * Interface for managing and displaying the game score.
 */

public interface ScoreSPI {
    Text getScoreText();
    void update(GameData gameData);
}
