module Core {
    requires javafx.controls;
    requires Common;
    requires CommonGraphics;

    uses dk.sdu.common.service.IGamePlugin;
    uses dk.sdu.common.service.IPostEntity;
    uses dk.sdu.common.service.IEntityProcessor;
    uses dk.sdu.common.graphics.IGraphics;

    exports dk.sdu.main;
}
