import dk.sdu.common.input.IInput;

module Core {
    requires javafx.controls;
    requires Common;
    requires CommonInput;

    uses dk.sdu.common.service.IGamePlugin;
    uses dk.sdu.common.service.IPostEntity;
    uses dk.sdu.common.service.IEntityProcessor;
    uses IInput;

    exports dk.sdu.main;
}
