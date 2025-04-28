package dk.sdu.asteroids;

import dk.sdu.common.service.IEntity;
import dk.sdu.common.data.GameData;
import dk.sdu.common.data.Entity;
import dk.sdu.common.data.World;
import dk.sdu.commonasteroids.Asteroid;

public class AsteroidProcessor implements IEntity {

    @Override
    public void process(GameData gameData, World world) {

        for (Entity asteroid : world.getEntities(Asteroid.class)) {
            double changeX = Math.cos(Math.toRadians(asteroid.getRotation()));
            double changeY = Math.sin(Math.toRadians(asteroid.getRotation()));

            asteroid.setX(asteroid.getX() + changeX * 0.5);
            asteroid.setY(asteroid.getY() + changeY * 0.5);

            // Horizontal Wrapping
            if (asteroid.getX() < 0) {
                asteroid.setX(gameData.getDisplayWidth());
            }

            if (asteroid.getX() > gameData.getDisplayWidth()) {
                asteroid.setX(0);
            }

            // Vertical Wrapping
            if (asteroid.getY() < 0) {
                asteroid.setY(gameData.getDisplayHeight());
            }

            if (asteroid.getY() > gameData.getDisplayHeight()) {
                asteroid.setY(0);
            }


        }
    }
}
