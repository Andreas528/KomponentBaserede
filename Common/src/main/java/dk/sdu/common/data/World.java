package dk.sdu.common.data;

import javafx.scene.layout.Pane;

public class World {
    public static final int WIDTH = 800;
    public static final int HEIGHT = 800;

    private final Pane root = new Pane();

    public Pane getRoot() {
        return root;
    }
}
