module ScoreClient{
    requires spring.web;
    requires Common;
    provides dk.sdu.common.service.IScore with dk.sdu.scoreclient.ScoreClient;
}