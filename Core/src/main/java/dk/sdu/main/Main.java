package dk.sdu.main;

import dk.sdu.common.data.GameData;
import dk.sdu.common.data.World;
import dk.sdu.common.service.IGamePlugin;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ServiceLoader;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        GameData gameData = new GameData();
        World world = new World();

        // Load all plugins dynamically
        for (IGamePlugin plugin : ServiceLoader.load(IGamePlugin.class)) {
            plugin.start(gameData, world);
        }

        Scene scene = new Scene(world.getRoot(), World.WIDTH, World.HEIGHT);
        primaryStage.setTitle("Asteroids");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
