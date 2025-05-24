package dk.sdu.common.service;
import dk.sdu.common.data.GameData;
import dk.sdu.common.data.World;

public interface IEntityProcessor {

    /**
     * Interface for processing game entities each frame.
     */

    void process(GameData gameData, World world);
}