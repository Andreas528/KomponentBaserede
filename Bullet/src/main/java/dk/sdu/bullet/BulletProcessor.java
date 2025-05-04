package dk.sdu.bullet;

import dk.sdu.common.bullet.Bullet;
import dk.sdu.common.bullet.BulletSPI;
import dk.sdu.common.data.Entity;
import dk.sdu.common.data.GameData;
import dk.sdu.common.data.World;
import dk.sdu.common.service.IEntityProcessor;


public class BulletProcessor implements IEntityProcessor, BulletSPI {

    @Override
    public Entity createBullet(Entity firing, GameData gameData) {

        Entity bullet = new Bullet();
        bullet.setPolygonCoordinates(1, -1, 1, 1, -1, 1, -1, -1);
        double changeX = Math.cos(Math.toRadians(firing.getRotation()));
        double changeY = Math.sin(Math.toRadians(firing.getRotation()));
        bullet.setX(firing.getX() + changeX * 10);
        bullet.setY(firing.getY() + changeY * 10);
        bullet.setRotation(firing.getRotation());
        bullet.setRadius(1);
        bullet.setColor(255, 0, 0);
        return bullet;
    }

    @Override
    public void process(GameData gameData, World world) {
        for (Entity bullet : world.getEntities(Bullet.class)) {
            double changeX = Math.cos(Math.toRadians(bullet.getRotation()));
            double changeY = Math.sin(Math.toRadians(bullet.getRotation()));
            bullet.setX(bullet.getX() + changeX * 3);
            bullet.setY(bullet.getY() + changeY * 3);

            // Removes bullets if outside of Width/Height
            if (bullet.getX() < 0 || bullet.getX() > gameData.getDisplayWidth()
                    || bullet.getY() < 0 || bullet.getY() > gameData.getDisplayHeight()) {
                world.removeEntity(bullet);
            }
        }
    }
}
