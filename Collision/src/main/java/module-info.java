import dk.sdu.common.service.IPostEntity;
import dk.sdu.common.service.IScoreSPI;

module Collision {
    requires Common;
    requires CommonAsteroids;
    provides IPostEntity with dk.sdu.collision.CollisionChecker;
    uses IScoreSPI;
}