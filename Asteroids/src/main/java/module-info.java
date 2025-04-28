import dk.sdu.common.service.*;
import dk.sdu.asteroids.AsteroidProcessor;
import dk.sdu.asteroids.AsteroidPlugin;

module Asteroid {
    requires Common;
    requires CommonAsteroids;
    provides IGamePlugin with AsteroidPlugin;
    provides IEntity with AsteroidProcessor;
}