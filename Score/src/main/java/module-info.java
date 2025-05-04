module Score {
    requires Common;
    requires javafx.graphics;

    provides dk.sdu.common.service.ScoreSPI with dk.sdu.score.Score;
}