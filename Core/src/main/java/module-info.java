import dk.sdu.common.input.IInput;

module Core {
    requires javafx.controls;
    requires Common;
    requires CommonGraphics;
    requires CommonInput;

    uses dk.sdu.common.service.IGamePlugin;
    uses dk.sdu.common.service.IPostEntity;
    uses dk.sdu.common.service.IEntityProcessor;
    uses dk.sdu.common.graphics.IGraphics;
    uses IInput;

    exports dk.sdu.main;
}
