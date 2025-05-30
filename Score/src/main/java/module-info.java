import dk.sdu.common.service.IScoreSPI;

module Score {
    requires Common;
    requires javafx.graphics;

    provides IScoreSPI with dk.sdu.score.Score;
}