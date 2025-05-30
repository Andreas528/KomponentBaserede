package dk.sdu.enemy;

import dk.sdu.common.data.Entity;
import dk.sdu.common.data.GameData;
import dk.sdu.common.data.World;
import dk.sdu.common.enemy.Enemy;
import dk.sdu.common.service.IEntityProcessor;
import dk.sdu.common.bullet.IBulletSPI;

import java.util.Collection;
import java.util.ServiceLoader;
import java.util.stream.Collectors;

public class EnemyProcessor implements IEntityProcessor {

    //Time since last shot and milliseconds for cooldown
    private static long lastShotTime = 0;
    private static final long COOLDOWN = 250;

    @Override
    public void process(GameData gameData, World world) {
        for (Entity enemy : world.getEntities(Enemy.class)) {
            double dx = Math.cos(Math.toRadians(enemy.getRotation()));
            double dy = Math.sin(Math.toRadians(enemy.getRotation()));
            enemy.setX(enemy.getX() + dx * 0.5);
            enemy.setY(enemy.getY() + dy * 0.5);

            //Wrap around the width/height
            if (enemy.getX() < 0) enemy.setX(gameData.getDisplayWidth());
            if (enemy.getX() > gameData.getDisplayWidth()) enemy.setX(0);
            if (enemy.getY() < 0) enemy.setY(gameData.getDisplayHeight());
            if (enemy.getY() > gameData.getDisplayHeight()) enemy.setY(0);

            //Bullet Cooldown
            long currentTime = System.currentTimeMillis();
            if (currentTime - lastShotTime >= COOLDOWN) {
                getBulletSPIs().stream().findFirst().ifPresent(spi -> {
                    Entity bullet = spi.createBullet(enemy, gameData);
                    if (bullet != null) {
                        world.addEntity(bullet);
                    }
                });
                lastShotTime = currentTime;
            }
        }
    }

    private Collection<? extends IBulletSPI> getBulletSPIs() {
        return ServiceLoader.load(IBulletSPI.class).stream()
                .map(ServiceLoader.Provider::get)
                .collect(Collectors.toList());
    }

}
