module Core {
    requires javafx.controls;
    requires javafx.graphics;

    requires Common;

    uses dk.sdu.common.service.IGamePlugin;

    exports dk.sdu.main;
}
