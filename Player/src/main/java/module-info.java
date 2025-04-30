import dk.sdu.common.service.*;

module Player {
    requires Common;
    requires CommonPlayer;
    provides IGamePlugin with dk.sdu.playersystem.PlayerPlugin;
    provides IEntityProcessor with dk.sdu.playersystem.PlayerControl;
}