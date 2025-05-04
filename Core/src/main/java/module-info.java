import dk.sdu.common.bullet.BulletSPI;
import dk.sdu.common.input.IInput;
import dk.sdu.common.service.ScoreSPI;

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
    uses ScoreSPI;

    exports dk.sdu.main;
}
