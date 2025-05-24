package dk.sdu.common.service;


import dk.sdu.common.data.World;
import dk.sdu.common.data.GameData;

/**
 * Interface for processing logic that should run after all entities have been updated.
 * Used for collision and AsteroidSplitter
 */
public interface IPostEntity {
    void process(GameData gameData, World world);
}
