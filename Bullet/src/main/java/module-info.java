import dk.sdu.common.bullet.IBulletSPI;
import dk.sdu.common.service.IEntityProcessor;
import dk.sdu.common.service.IGamePlugin;

module Bullet {
    requires Common;
    requires CommonBullet;
    provides IGamePlugin with dk.sdu.bullet.BulletPlugin;
    provides IBulletSPI with dk.sdu.bullet.BulletProcessor;
    provides IEntityProcessor with dk.sdu.bullet.BulletProcessor;
}