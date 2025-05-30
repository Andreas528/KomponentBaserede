package dk.sdu.common.bullet;
import dk.sdu.common.data.Entity;
import dk.sdu.common.data.GameData;

/**
 * Interface for creating bullet entities in the game.
 */

public interface IBulletSPI {
    Entity createBullet(Entity e, GameData gameData);
}
