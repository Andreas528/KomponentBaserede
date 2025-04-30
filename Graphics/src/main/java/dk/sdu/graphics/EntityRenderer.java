package dk.sdu.graphics;

import dk.sdu.common.data.Entity;
import dk.sdu.common.data.GameData;
import dk.sdu.common.data.World;
import dk.sdu.common.graphics.IGraphics;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class EntityRenderer implements IGraphics {
    private final Pane pane = new Pane();

    @Override
    public Node createComponent(GameData gameData, World world) {
        // no need to populate here—updateComponent will do it
        return pane;
    }

    @Override
    public void updateComponent(GameData gameData, World world) {
        pane.getChildren().clear();

        for (Entity e : world.getEntities()) {
            // build from guaranteed-valid data
            Polygon p = new Polygon(e.getPolygonCoordinates());
            p.setTranslateX(e.getX());
            p.setTranslateY(e.getY());
            p.setRotate(e.getRotation());

            int[] col = e.getColor();
            p.setFill(Color.rgb(col[0], col[1], col[2]));

            pane.getChildren().add(p);
        }
    }

    @Override
    public void showComponent(Boolean shouldShow) {
        pane.setVisible(shouldShow);
    }
}
