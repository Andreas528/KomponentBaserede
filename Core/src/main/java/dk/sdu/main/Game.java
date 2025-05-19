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
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;


public class Game {

    private final Pane gameWindow = new Pane();
    private final GameData gameData = new GameData();
    private final World world = new World();
    private final Map<Entity, Polygon> polygons = new ConcurrentHashMap<>();

    @Autowired
    private List<IGamePlugin> gamePlugins;
    @Autowired
    private List<IPostEntity> postEntities;
    @Autowired
    private List<IEntityProcessor> entityProcessors;
    @Autowired
    private List<IInput> inputs;
    @Autowired
    private List<ScoreSPI> scoreSPI;

    public void start(Stage primaryStage) throws Exception {
        // Scene and Score Text
        Scene scene = new Scene(gameWindow, gameData.getDisplayWidth(), gameData.getDisplayHeight());
        scene.setFill(Color.BLACK);
        if (!scoreSPI.isEmpty()) {
            gameWindow.getChildren().add(scoreSPI.getFirst().getScoreText());
        }

        // Input
        for (IInput input : inputs) {
            scene.addEventHandler(input.getInputEvent(), input.getInputHandler(gameData));
        }

        // Game Plugin (ServiceLoader)
        for (IGamePlugin iGamePlugin : gamePlugins) {
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
        for (IEntityProcessor proc : entityProcessors) {
            proc.process(gameData, world);
        }
        for (IPostEntity post : postEntities) {
            post.process(gameData, world);
        }
        if (!scoreSPI.isEmpty()) {
            scoreSPI.getFirst().update(gameData);
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

        }
    }
}
