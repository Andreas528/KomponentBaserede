module Score {
    requires Common;
    requires javafx.graphics;
    requires spring.context;
    provides dk.sdu.common.service.ScoreSPI with dk.sdu.score.Score;

    exports dk.sdu.score to spring.beans;
}