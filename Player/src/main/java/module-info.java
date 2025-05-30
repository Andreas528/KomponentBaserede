import dk.sdu.common.bullet.IBulletSPI;
import dk.sdu.common.service.*;

module Player {
    requires Common;
    requires CommonPlayer;
    requires CommonBullet;
    provides IGamePlugin with dk.sdu.playersystem.PlayerPlugin;
    provides IEntityProcessor with dk.sdu.playersystem.PlayerControl;
    uses IBulletSPI;
}