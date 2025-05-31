import dk.sdu.common.service.IScoreSPI;

module ScoreClient{
    requires spring.web;
    requires Common;
    provides IScoreSPI with dk.sdu.scoreclient.ScoreClient;
}