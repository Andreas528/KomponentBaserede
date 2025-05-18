package dk.sdu.main;

import dk.sdu.common.data.Entity;
import dk.sdu.common.data.GameData;
import dk.sdu.common.data.World;
import dk.sdu.common.service.IEntityProcessor;
import dk.sdu.common.service.IGamePlugin;
import dk.sdu.common.service.IPostEntity;
import dk.sdu.common.input.IInput;
import dk.sdu.common.service.ScoreSPI;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;


import java.util.*;
import java.util.concurrent.ConcurrentHashMap;


public class Main extends Application {

    private final Pane gameWindow = new Pane();
    private final GameData gameData = new GameData();
    private final World world = new World();
    private final Map<Entity, Polygon> polygons = new ConcurrentHashMap<>();
    private List<ScoreSPI> scoreServices;



    public static void main(String[] args) {
        launch(Main.class);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Scene and Score Text
        Scene scene = new Scene(gameWindow, gameData.getDisplayWidth(), gameData.getDisplayHeight());
        scene.setFill(Color.BLACK);

        scoreServices = new ArrayList<>(ModuleConfig.getScoreServices());
        for (ScoreSPI score : scoreServices) {
            gameWindow.getChildren().add(score.getScoreText());
        }

        // Input
        for (IInput input : ModuleConfig.getIInputServices()) {
            scene.addEventHandler(input.getInputEvent(), input.getInputHandler(gameData));
        }

        // Game Plugin (ServiceLoader)
        for (IGamePlugin iGamePlugin : ModuleConfig.getPluginServices()) {
            iGamePlugin.start(gameData, world);
        }

        render();
        primaryStage.setTitle("Asteroids");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void render() {
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                draw();
                updateGameLogic();
            }

        }.start();
    }

    // Updates service loaders (for movement)
    private void updateGameLogic() {
        for (IEntityProcessor proc : ModuleConfig.getIEntityServices()) {
            proc.process(gameData, world);
        }

        for (Entity entity : world.getEntities()) {
            if (!entity.getAlive()) {
                world.removeEntity(entity);
            }
        }

        for (IPostEntity post : ModuleConfig.getPostServices()) {
            post.process(gameData, world);
        }
    }

    // Draws entities
    private void draw() {
        for (Entity polygonEntity : polygons.keySet()) {
            if (!world.getEntities().contains(polygonEntity)) {
                Polygon removedPolygon = polygons.get(polygonEntity);
                polygons.remove(polygonEntity);
                gameWindow.getChildren().remove(removedPolygon);
            }
        }
        for (Entity entity : world.getEntities()) {
            Polygon polygon = polygons.get(entity);
            if (polygon == null) {
                polygon = new Polygon(entity.getPolygonCoordinates());
                int[] col = entity.getColor();
                polygon.setFill(Color.rgb(col[0], col[1], col[2]));
                polygons.put(entity, polygon);
                gameWindow.getChildren().add(polygon);
            }
            polygon.setTranslateX(entity.getX());
            polygon.setTranslateY(entity.getY());
            polygon.setRotate(entity.getRotation());

            for (ScoreSPI score : scoreServices) {
                score.update(gameData);
            }

        }
    }
}
