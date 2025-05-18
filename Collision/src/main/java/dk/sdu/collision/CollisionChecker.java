package dk.sdu.collision;

import dk.sdu.common.data.Entity;
import dk.sdu.common.data.GameData;
import dk.sdu.common.data.World;
import dk.sdu.commonasteroids.Asteroid;
import dk.sdu.common.service.IPostEntity;



public class CollisionChecker implements IPostEntity {
    @Override
    public void process(GameData gameData, World world) {
        for (Entity entity1 : world.getEntities()) {
            for (Entity entity2 : world.getEntities()) {

                // If the two entities are identical, skip the iteration
                if (entity1.getID().equals(entity2.getID())) {
                    continue;
                }

                // Checks if the collision was between 2 Asteroids
                if (entity1 instanceof Asteroid && entity2 instanceof Asteroid) {
                    continue;
                }

                // CollisionDetection
                if (this.collides(entity1, entity2)) {

                    entity1.setHealth(entity1.getHealth() - 1);
                    entity2.setHealth(entity2.getHealth() - 1);

                    // Only adds a point to the score if the Asteroid fully dies
                    if (entity1.getHealth() <= 0) {
                        entity1.setAlive(false);
                        if (entity1 instanceof Asteroid) {
                            gameData.addScore();
                        }
                    }
                    if (entity2.getHealth() <= 0) {
                        entity2.setAlive(false);
                        if (entity2 instanceof Asteroid) {
                            gameData.addScore();
                        }
                    }
                }
            }
        }
    }
    public Boolean collides(Entity entity1, Entity entity2) {
        float dx = (float) entity1.getX() - (float) entity2.getX();
        float dy = (float) entity1.getY() - (float) entity2.getY();
        float distance = (float) Math.sqrt(dx * dx + dy * dy);
        return distance < (entity1.getRadius() + entity2.getRadius());
    }
}
