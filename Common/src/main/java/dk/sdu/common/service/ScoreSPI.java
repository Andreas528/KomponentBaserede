package dk.sdu.common.service;
import dk.sdu.common.data.GameData;
import javafx.scene.text.Text;


public interface ScoreSPI {
    Text getScoreText();
    void update(GameData gameData);
}
