package dk.sdu.common.service;
import dk.sdu.common.data.GameData;
import dk.sdu.common.data.World;

public interface IEntityProcessor {

    /**
     *
     *
     *
     * @param gameData
     * @param world
     * @throws
     */
    void process(GameData gameData, World world);
}