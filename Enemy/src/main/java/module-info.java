import dk.sdu.common.service.*;

module Enemy {
    requires Common;
    requires CommonBullet;
    requires CommonEnemy;
    provides IGamePlugin with dk.sdu.enemy.EnemyPlugin;
    provides IEntityProcessor with dk.sdu.enemy.EnemyProcessor;
    uses dk.sdu.common.bullet.BulletSPI;

}