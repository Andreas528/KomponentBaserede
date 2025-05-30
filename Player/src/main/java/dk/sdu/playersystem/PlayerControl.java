package dk.sdu.playersystem;

import dk.sdu.common.data.Entity;
import dk.sdu.common.data.GameData;
import dk.sdu.common.data.World;
import dk.sdu.common.service.IEntityProcessor;
import dk.sdu.common.player.Player;
import dk.sdu.common.data.EGameInputs;
import dk.sdu.common.bullet.IBulletSPI;

import java.util.Collection;
import java.util.ServiceLoader;

import static java.util.stream.Collectors.toList;


public class PlayerControl implements IEntityProcessor {

    // time since last shot
    private static long lastShotTime = 0;
    // milliseconds
    private static final long COOLDOWN = 250;

    @Override
    public void process(GameData gameData, World world) {
        for (Entity player : world.getEntities(Player.class)) {
            //Input keys for player
            if (gameData.getInputs().isDown(EGameInputs.Left)) {
                player.setRotation(player.getRotation() - 2);
            }

            if (gameData.getInputs().isDown(EGameInputs.Right)) {
                player.setRotation(player.getRotation() + 2);
            }

            if (gameData.getInputs().isDown(EGameInputs.Up)) {
                double changeX = Math.cos(Math.toRadians(player.getRotation()));
                double changeY = Math.sin(Math.toRadians(player.getRotation()));
                player.setX(player.getX() + changeX);
                player.setY(player.getY() + changeY);
            }


            //Checks if player is holding space
            if (gameData.getInputs().isDown(EGameInputs.Space)) {
                long currentTime = System.currentTimeMillis();

                //Check time since last shot
                if (currentTime - lastShotTime >= COOLDOWN) {
                    //Calls BulletSPI and creates bullet
                    getBulletSPIs().stream().findFirst().ifPresent(spi -> {
                        Entity bullet = spi.createBullet(player, gameData);
                        if (bullet != null) {
                            world.addEntity(bullet);
                        }
                    });
                    //Updates time for last shot
                    lastShotTime = currentTime;
                }
            }

            player.setX(Math.min(Math.max(player.getX(), 1), gameData.getDisplayWidth() - 1));
            player.setY(Math.min(Math.max(player.getY(), 1), gameData.getDisplayHeight() - 1));
        }
    }
    private Collection<? extends IBulletSPI> getBulletSPIs() {
        return ServiceLoader.load(IBulletSPI.class).stream().map(ServiceLoader.Provider::get).collect(toList());
    }

}

