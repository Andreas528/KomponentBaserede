package dk.sdu.asteroids;

import dk.sdu.common.service.IEntityProcessor;
import dk.sdu.common.data.GameData;
import dk.sdu.common.data.Entity;
import dk.sdu.common.data.World;
import dk.sdu.commonasteroids.Asteroid;

public class AsteroidProcessor implements IEntityProcessor {

    @Override
    public void process(GameData gameData, World world) {
        for (Entity asteroid : world.getEntities(Asteroid.class)) {
            double dx = Math.cos(Math.toRadians(asteroid.getRotation())) * 0.5;
            double dy = Math.sin(Math.toRadians(asteroid.getRotation())) * 0.5;

            asteroid.setX(asteroid.getX() + dx);
            asteroid.setY(asteroid.getY() + dy);

            // Screen wrapping
            if (asteroid.getX() < 0) asteroid.setX(gameData.getDisplayWidth());
            if (asteroid.getX() > gameData.getDisplayWidth()) asteroid.setX(0);
            if (asteroid.getY() < 0) asteroid.setY(gameData.getDisplayHeight());
            if (asteroid.getY() > gameData.getDisplayHeight()) asteroid.setY(0);
        }
    }
}
