package dk.sdu.scoringsystem;


import org.springframework.stereotype.Service;

@Service
public class ScoreService {
    private int totalScore = 0;

    public synchronized int addScore(int score) {
        totalScore += score;
        return totalScore;
    }

    public int getScore() {
        return totalScore;
    }
}
