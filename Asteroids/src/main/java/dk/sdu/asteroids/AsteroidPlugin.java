package dk.sdu.asteroids;

import dk.sdu.common.data.Entity;
import dk.sdu.common.data.World;
import dk.sdu.common.data.GameData;
import dk.sdu.common.service.IEntityProcessor;
import dk.sdu.common.service.IGamePlugin;
import dk.sdu.commonasteroids.Asteroid;


import java.util.Random;

public class AsteroidPlugin implements IGamePlugin {
    private final Random rnd = new Random();
    private final int MIN_ASTEROIDS = 20;

    @Override
    public void start(GameData gameData, World world) {
        // Spawns 20 asteroid and adds one everytime you kill one

        for (int i = 0; i < MIN_ASTEROIDS; i++) {
            double x = rnd.nextInt(gameData.getDisplayWidth());
            double y = rnd.nextInt(gameData.getDisplayHeight());
            System.out.println(x);
            world.addEntity(createAsteroid(gameData, false, x, y));

        }

    }

    @Override
    public void stop(GameData gameData, World world) {
        // Remove asteroid entity
        for (Entity asteroid : world.getEntities(Asteroid.class)) {
            world.removeEntity(asteroid);
        }
    }

    // Sets variables for Asteroid Entity
    protected Entity createAsteroid(GameData gameData, boolean isSplit, double x, double y) {
        Asteroid asteroid = new Asteroid();
        int size = rnd.nextInt(10) + 8;

        // Set random polygon shape
        asteroid.setPolygonCoordinates(size, -size, -size, -size, -size, size, size, size);

        // Set position and rotation
        asteroid.setRadius(size);
        asteroid.setRotation(rnd.nextInt(360));
        asteroid.setAlive(true);
        asteroid.setHealth(6);
        asteroid.setSplit(isSplit);
        asteroid.setX(x);
        asteroid.setY(y);

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
