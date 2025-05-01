package dk.sdu.main;

import dk.sdu.common.data.Entity;
import dk.sdu.common.data.GameData;
import dk.sdu.common.data.World;
import dk.sdu.common.graphics.IGraphics;
import dk.sdu.common.service.IEntityProcessor;
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

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import static java.util.stream.Collectors.toList;


public class Main extends Application {

    private final Pane gameWindow = new Pane();
    private final GameData gameData = new GameData();
    private final World world = new World();
    private List<IGraphics> graphicsServices;



    public static void main(String[] args) {
        launch(Main.class);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {


        // Game Plugin (ServiceLoader)
        for (IGamePlugin iGamePlugin : ModuleConfig.getPluginServices()) {
            iGamePlugin.start(gameData, world);
        }

        graphicsServices = new ArrayList<>(ModuleConfig.getGraphicComponents());
        for (IGraphics graphics : graphicsServices) {
            gameWindow.getChildren().add(graphics.createComponent(gameData, world));
        }

        //Scene, background and text
        Text text = new Text(10, 20,"Destroyed asteroids: 0");
        text.setFill(Color.GREEN);

        Scene scene = new Scene(gameWindow, gameData.getDisplayWidth(), gameData.getDisplayHeight());
        scene.setFill(Color.BLACK);
        gameWindow.getChildren().add(text);

        render();
        primaryStage.setTitle("Asteroids");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void render() {
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                updateGameLogic();
                updateGraphics();
            }

        }.start();
    }

    //Draws the entities
    private void updateGraphics() {
        for (IGraphics graphics : graphicsServices) {
            graphics.updateComponent(gameData, world);
        }
    }

    //Runs all the processors, which makes Asteroids move
    private void updateGameLogic() {
        for (IEntityProcessor proc : ModuleConfig.getIEntityServices()) {
            proc.process(gameData, world);
        }
        for (IPostEntity post : ModuleConfig.getPostServices()) {
            post.process(gameData, world);
        }
    }
}
