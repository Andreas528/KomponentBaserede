import dk.sdu.common.service.IGamePlugin;
import dk.sdu.enemy.EnemyPlugin;

module Enemy2{
    requires Common;
    provides IGamePlugin with dk.sdu.enemy.EnemyPlugin;
}