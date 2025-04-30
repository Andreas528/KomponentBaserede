package dk.sdu.playersystem;

import dk.sdu.common.data.Entity;
import dk.sdu.common.data.GameData;
import dk.sdu.common.data.World;
import dk.sdu.common.player.Player;
import dk.sdu.common.service.IGamePlugin;

public class PlayerPlugin implements IGamePlugin {


    private Entity player;

    @Override
    public void start(GameData gameData, World world) {
        player = createPlayer(gameData);
        world.addEntity(player);
    }

    @Override
    public void stop(GameData gameData, World world) {
        world.removeEntity(player);
    }

    private Entity createPlayer(GameData gameData) {
        Entity player = new Player();
        player.setPolygonCoordinates(-5,-5,10,0,-5,5);

        player.setX(gameData.getDisplayHeight()/2);
        player.setY(gameData.getDisplayHeight()/2);

        player.setColor(0,191,255);

        return player;
    }
}
