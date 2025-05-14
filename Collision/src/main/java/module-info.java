import dk.sdu.common.service.IPostEntity;

module Collision {
    requires Common;
    requires CommonAsteroids;
    requires ScoreClient;
    provides IPostEntity with dk.sdu.collision.CollisionChecker;
}