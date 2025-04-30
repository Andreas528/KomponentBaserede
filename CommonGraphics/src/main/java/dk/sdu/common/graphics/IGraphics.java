package dk.sdu.common.graphics;

import dk.sdu.common.data.GameData;
import dk.sdu.common.data.World;
import javafx.scene.Node;

public interface IGraphics {
    Node createComponent(GameData gameData, World world);
    void updateComponent(GameData gameData, World world);
    void showComponent(Boolean shouldShow);
}
