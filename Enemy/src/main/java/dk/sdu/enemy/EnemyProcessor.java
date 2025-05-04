package dk.sdu.enemy;

import dk.sdu.common.data.Entity;
import dk.sdu.common.data.GameData;
import dk.sdu.common.data.World;
import dk.sdu.common.enemy.Enemy;
import dk.sdu.common.service.IEntityProcessor;

public class EnemyProcessor implements IEntityProcessor {

    @Override
    public void process(GameData gameData, World world) {
        for (Entity enemy : world.getEntities(Enemy.class)) {
            double dx = Math.cos(Math.toRadians(enemy.getRotation()));
            double dy = Math.sin(Math.toRadians(enemy.getRotation()));
            enemy.setX(enemy.getX() + dx * 0.5);
            enemy.setY(enemy.getY() + dy * 0.5);

            if (enemy.getX() < 0) enemy.setX(gameData.getDisplayWidth());
            if (enemy.getX() > gameData.getDisplayWidth()) enemy.setX(0);
            if (enemy.getY() < 0) enemy.setY(gameData.getDisplayHeight());
            if (enemy.getY() > gameData.getDisplayHeight()) enemy.setY(0);
        }

    }
}
