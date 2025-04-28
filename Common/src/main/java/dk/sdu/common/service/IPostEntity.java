package dk.sdu.common.service;


import dk.sdu.common.data.World;
import dk.sdu.common.data.GameData;

/**
 *
 * @author jcs
 */
public interface IPostEntity {

    void process(GameData gameData, World world);
}
