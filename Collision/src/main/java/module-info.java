import dk.sdu.common.service.IPostEntity;

module Collision {
    requires Common;
    requires CommonAsteroids;
    requires CommonPlayer;
    provides IPostEntity with dk.sdu.collision.CollisionChecker;
}