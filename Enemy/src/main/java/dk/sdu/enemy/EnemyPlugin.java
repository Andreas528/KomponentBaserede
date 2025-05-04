package dk.sdu.enemy;
import dk.sdu.common.data.Entity;
import dk.sdu.common.data.GameData;
import dk.sdu.common.data.World;
import dk.sdu.common.enemy.Enemy;
import dk.sdu.common.service.IGamePlugin;


import java.util.Random;

public class EnemyPlugin implements IGamePlugin {

    private Entity enemy;

    @Override
    public void start(GameData gameData, World world) {
        //Spawns enemy
        enemy = createEnemy(gameData);
        world.addEntity(enemy);
    }

    @Override
    public void stop(GameData gameData, World world) {
        //Removes enemy
        world.removeEntity(enemy);
    }


    private Entity createEnemy(GameData gameData) {
        Entity enemy = new Enemy();
        Random rnd = new Random();
        enemy.setPolygonCoordinates(-5,-5,10,0,-5,5);
        enemy.setX(gameData.getDisplayHeight()/3);
        enemy.setY(gameData.getDisplayWidth()/3);
        enemy.setRadius(5);
        enemy.setRotation(rnd.nextInt(90));

        enemy.setColor(255,0,0);

        return enemy;
    }
}
