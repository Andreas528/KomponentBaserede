import dk.sdu.common.graphics.IGraphics;
import dk.sdu.common.service.IGamePlugin;
import dk.sdu.graphics.EntityRenderer;

module Graphics {
    requires Common;
    requires CommonGraphics;
    requires CommonPlayer;
    requires CommonAsteroids;
    requires javafx.graphics;

    uses IGraphics;
    uses IGamePlugin;

    provides IGraphics with EntityRenderer;
}