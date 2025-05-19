package dk.sdu.asteroids;

import dk.sdu.common.data.Entity;
import dk.sdu.common.data.GameData;
import dk.sdu.common.data.World;
import dk.sdu.common.service.IPostEntity;
import dk.sdu.commonasteroids.Asteroid;

public class AsteroidSplitter implements IPostEntity {
    private final AsteroidPlugin asteroidPlugin = new AsteroidPlugin();

    @Override
    public void process(GameData gameData, World world) {
        for (Entity asteroid : world.getEntities(Asteroid.class)) {
            if (asteroid.getHealth() < 3 && !((Asteroid)asteroid).isSplit()) {
                world.addEntity(asteroidPlugin.createAsteroid(gameData, true, asteroid.getX(), asteroid.getY()));
                world.addEntity(asteroidPlugin.createAsteroid(gameData, true, asteroid.getX(), asteroid.getY()));
                world.removeEntity(asteroid);
            }
        }
    }
}
