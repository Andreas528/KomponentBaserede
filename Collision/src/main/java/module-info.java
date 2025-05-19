import dk.sdu.common.service.IPostEntity;

module Collision {
    requires Common;
    requires CommonAsteroids;
    provides IPostEntity with dk.sdu.collision.CollisionChecker;
    uses dk.sdu.common.service.IScore;
}