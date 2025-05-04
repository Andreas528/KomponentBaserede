package dk.sdu.enemy;
import dk.sdu.common.data.Entity;
import dk.sdu.common.data.GameData;
import dk.sdu.common.data.World;
import dk.sdu.common.enemy.Enemy;
import dk.sdu.common.service.IEntityProcessor;

import java.util.Random;

public class EnemyProcessor implements IEntityProcessor {

    @Override
    public void process(GameData gameData, World world) {


        Random rnd = new Random();
        for (Entity enemy : world.getEntities(Enemy.class)) {
            double changeX = Math.cos(Math.toRadians(enemy.getRotation()));
            double changeY = Math.sin(Math.toRadians(enemy.getRotation()));


            enemy.setX(enemy.getX() + changeX * 0.5);
            enemy.setY(enemy.getY() + changeY * 0.5);

            // Horizontal Wrapping
            if (enemy.getX() < 0) {
                enemy.setX(gameData.getDisplayWidth());
            }

            if (enemy.getX() > gameData.getDisplayWidth()) {
                enemy.setX(0);
            }

            // Vertical Wrapping
            if (enemy.getY() < 0) {
                enemy.setY(gameData.getDisplayHeight());
            }

            if (enemy.getY() > gameData.getDisplayHeight()) {
                enemy.setY(0);
            }

            if (rnd.nextInt(90) < 2){
                enemy.setRotation(-20);
            }
            if (rnd.nextInt(90) < 1){
                enemy.setRotation(15);
            }
        }
    }
}
