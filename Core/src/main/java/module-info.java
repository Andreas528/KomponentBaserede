module Core {
    requires javafx.controls;
    requires javafx.graphics;

    requires Common;

    uses dk.sdu.common.service.IGamePlugin;
    uses dk.sdu.common.service.IPostEntity;
    uses dk.sdu.common.service.IEntity;

    exports dk.sdu.main;
}
