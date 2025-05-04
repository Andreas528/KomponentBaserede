import dk.sdu.common.service.IEntityProcessor;
import dk.sdu.common.service.IGamePlugin;

module Enemy {
    requires Common;
    requires CommonEnemy;
    provides IGamePlugin with dk.sdu.enemy.EnemyPlugin;
    provides IEntityProcessor with dk.sdu.enemy.EnemyProcessor;
}