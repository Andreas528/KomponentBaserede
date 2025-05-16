package dk.sdu.asteroids;

import dk.sdu.common.data.Entity;
import dk.sdu.common.data.World;
import dk.sdu.common.data.GameData;
import dk.sdu.common.service.IEntityProcessor;
import dk.sdu.common.service.IGamePlugin;
import dk.sdu.commonasteroids.Asteroid;


import java.util.Random;

public class AsteroidPlugin implements IGamePlugin, IEntityProcessor {
    private final Random rnd = new Random();
    private final int MIN_ASTEROIDS = 20;

    @Override
    public void start(GameData gameData, World world) {
        // Spawns 20 asteroid and adds one everytime you kill one
        for (int i = 0; i < MIN_ASTEROIDS; i++) {
            world.addEntity(createAsteroid(gameData));
        }

    }

    @Override
    public void stop(GameData gameData, World world) {
        // Remove asteroid entity
        for (Entity asteroid : world.getEntities(Asteroid.class)) {
            world.removeEntity(asteroid);
        }
    }

    @Override
    public void process(GameData gameData, World world) {
        int currentCount = world.getEntities(Asteroid.class).size();
        if (currentCount < MIN_ASTEROIDS) {
            world.addEntity(createAsteroid(gameData));
        }
    }

    // Sets variables for Asteroid Entity
    private Entity createAsteroid(GameData gameData) {
        Entity asteroid = new Asteroid();
        int size = rnd.nextInt(10) + 8;

        // Set random polygon shape
        asteroid.setPolygonCoordinates(size, -size, -size, -size, -size, size, size, size);

        // Set position and rotation
        asteroid.setX(rnd.nextInt(gameData.getDisplayWidth()));
        asteroid.setY(rnd.nextInt(gameData.getDisplayHeight()));
        asteroid.setRadius(size);
        asteroid.setRotation(rnd.nextInt(360));

        // Generate random RGB color - RAINBOW ASTEROIDS :>
        // int r = rnd.nextInt(256);
        // int g = rnd.nextInt(256);
        // int b = rnd.nextInt(256);
        // asteroid.setColor(r, g, b); // Store R, G, B separately

        //Sets the color on Asteroids
        asteroid.setColor(101, 67, 33);

        return asteroid;
    }


}
