import dk.sdu.common.bullet.BulletSPI;
import dk.sdu.common.input.IInput;

module Core {
    requires javafx.controls;
    requires Common;
    requires CommonInput;
    requires CommonBullet;

    uses dk.sdu.common.service.IGamePlugin;
    uses dk.sdu.common.service.IPostEntity;
    uses dk.sdu.common.service.IEntityProcessor;
    uses IInput;
    uses BulletSPI;

    exports dk.sdu.main;
}
