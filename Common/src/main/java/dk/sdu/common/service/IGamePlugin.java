package dk.sdu.common.service;

import dk.sdu.common.data.GameData;
import dk.sdu.common.data.World;

public interface IGamePlugin {
    void start(GameData gameData, World world);

    void stop(GameData gameData, World world);

}
