package dk.sdu.playersystem;

import dk.sdu.common.data.Entity;
import dk.sdu.common.data.GameData;
import dk.sdu.common.data.World;
import dk.sdu.common.service.IEntityProcessor;
import dk.sdu.common.data.GameData;
import dk.sdu.common.player.Player;
import dk.sdu.common.data.EGameInputs;


public class PlayerControl implements IEntityProcessor {

    @Override
    public void process(GameData gameData, World world) {
        for (Entity player : world.getEntities(Player.class)) {
            if (gameData.getInputs().isDown(EGameInputs.Left)) {
                player.setRotation(player.getRotation() - 2);
            }

            if (gameData.getInputs().isDown(EGameInputs.Right)) {
                player.setRotation(player.getRotation() - 2);
            }

            if (gameData.getInputs().isDown(EGameInputs.Up)) {
                double changeX = Math.cos(Math.toRadians(player.getRotation()));
                double changeY = Math.sin(Math.toRadians(player.getRotation()));
                player.setX(player.getX() + changeX);
                player.setY(player.getY() + changeY);
            }


            if (player.getX() < 0) {
                player.setX(1);
            }

            if (player.getX() > gameData.getDisplayWidth()) {
                player.setX(gameData.getDisplayWidth()-1);
            }

            if (player.getY() < 0) {
                player.setY(1);
            }

            if (player.getY() > gameData.getDisplayHeight()) {
                player.setY(gameData.getDisplayHeight()-1);
            }
        }
    }
}
