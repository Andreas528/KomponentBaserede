package dk.sdu.main;

import dk.sdu.common.data.Entity;
import dk.sdu.common.data.GameData;
import dk.sdu.common.data.World;
import dk.sdu.common.service.IEntity;
import dk.sdu.common.service.IGamePlugin;
import dk.sdu.common.service.IPostEntity;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Collection;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.concurrent.ConcurrentHashMap;
import java.util.*;

import static java.util.stream.Collectors.toList;


public class Main extends Application {

    private final Pane gameWindow = new Pane();
    private final GameData gameData = new GameData();
    private final World world = new World();
    private final Map<Entity, Polygon> polygons = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        launch(Main.class);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        for (IGamePlugin plugin : getPluginServices()) {
            plugin.start(gameData, world);
        }

        Text text = new Text(10, 20,"Destroyed asteroids: 0");
        text.setFill(Color.GREEN);

        Scene scene = new Scene(gameWindow, gameData.getDisplayWidth(), gameData.getDisplayHeight());
        scene.setFill(Color.WHITE);
        gameWindow.getChildren().add(text);


        for (Entity entity : world.getEntities()) {
            Polygon polygon = new Polygon(entity.getPolygonCoordinates());
            polygons.put(entity, polygon);
            gameWindow.getChildren().add(polygon);
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
                update();
                draw();
                gameData.getKeys().update();

            }

        }.start();
    }

    private void draw() {
        for (Entity entity : world.getEntities()) {
            Polygon polygon = polygons.get(entity);
            polygon.setTranslateX(entity.getX());
            polygon.setTranslateY(entity.getY());
            polygon.setRotate(entity.getRotation());
        }
    }

    private void update() {
        for (IEntity entityProcessorService : getIEntityServices()) {
            entityProcessorService.process(gameData, world);
        }
        for (IPostEntity postEntityProcessorService : getPostServices()) {
            postEntityProcessorService.process(gameData, world);
        }
    }

    private Collection<? extends IGamePlugin> getPluginServices() {
        return ServiceLoader.load(IGamePlugin.class).stream().map(ServiceLoader.Provider::get).collect( toList());
    }
    private Collection<? extends IPostEntity> getPostServices() {
        return ServiceLoader.load(IPostEntity.class).stream().map(ServiceLoader.Provider::get).collect( toList());
    }
    private Collection<? extends IEntity> getIEntityServices() {
        return ServiceLoader.load(IEntity.class).stream().map(ServiceLoader.Provider::get).collect( toList());
    }
}
