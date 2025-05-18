package dk.sdu.enemy;

import dk.sdu.common.data.GameData;
import dk.sdu.common.data.World;
import dk.sdu.common.service.IGamePlugin;

public class EnemyPlugin implements IGamePlugin {

    @Override
    public void start(GameData gameData, World world) {
        System.out.println("It works :)");
    }

    @Override
    public void stop(GameData gameData, World world) {

    }
}
