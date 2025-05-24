package dk.sdu.common.service;

import dk.sdu.common.data.GameData;
import dk.sdu.common.data.World;

/**
 * Interface for game plugins that handle setup and teardown of game features or entities.
 */

public interface IGamePlugin {
    void start(GameData gameData, World world);

    void stop(GameData gameData, World world);

}
