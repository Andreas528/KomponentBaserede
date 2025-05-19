module Asteroid {
    requires Common;
    requires CommonAsteroids;

    provides dk.sdu.common.service.IGamePlugin with dk.sdu.asteroids.AsteroidPlugin;
    provides dk.sdu.common.service.IEntityProcessor with dk.sdu.asteroids.AsteroidProcessor;
    provides dk.sdu.common.service.IPostEntity with dk.sdu.asteroids.AsteroidSplitter;
}
