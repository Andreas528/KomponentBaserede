import dk.sdu.common.bullet.IBulletSPI;
import dk.sdu.common.service.IInputSPI;
import dk.sdu.common.service.IPostEntityProcessing;
import dk.sdu.common.service.IScoreSPI;

module Core {
    requires javafx.controls;
    requires Common;
    requires CommonBullet;

    uses dk.sdu.common.service.IGamePlugin;
    uses IPostEntityProcessing;
    uses dk.sdu.common.service.IEntityProcessor;
    uses IInputSPI;
    uses IBulletSPI;
    uses IScoreSPI;

    exports dk.sdu.main;
}
