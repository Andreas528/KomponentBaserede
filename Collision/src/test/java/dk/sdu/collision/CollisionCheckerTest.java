package dk.sdu.collision;

import dk.sdu.common.data.Entity;
import dk.sdu.common.data.GameData;
import dk.sdu.common.data.World;
import dk.sdu.common.player.Player;
import dk.sdu.commonasteroids.Asteroid;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
class CollisionCheckerTest {
    private static GameData gameData;
    private static World world;
    private static CollisionChecker collisionChecker;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        gameData = new GameData();
        world = new World();
        collisionChecker = new CollisionChecker();

    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        for (Entity entity : world.getEntities()) {
            world.removeEntity(entity);
        }
    }

    @org.junit.jupiter.api.Test
    void checkCollision() {
        Asteroid asteroid = new Asteroid();
        asteroid.setX(100);
        asteroid.setY(100);
        asteroid.setHealth(1);
        asteroid.setAlive(true);
        asteroid.setRadius(10);

        Player player = new Player();
        player.setX(100);
        player.setY(100);
        player.setHealth(1);
        player.setAlive(true);
        player.setRadius(10);

        world.addEntity(asteroid);
        world.addEntity(player);

        assertTrue(world.getEntities().contains(asteroid));
        assertTrue(world.getEntities().contains(player));

        collisionChecker.process(gameData, world);

        for (Entity entity : new ArrayList<>(world.getEntities())) {
            if (!entity.getAlive()) {
                world.removeEntity(entity);
            }
        }

        assertFalse(world.getEntities().contains(asteroid));
        assertFalse(world.getEntities().contains(player));
    }
}