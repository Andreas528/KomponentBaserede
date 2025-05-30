import dk.sdu.common.service.IPostEntityProcessing;

module Collision {
    requires Common;
    requires CommonAsteroids;
    requires CommonPlayer;
    provides IPostEntityProcessing with dk.sdu.collision.CollisionChecker;
}