package dk.sdu.scoringsystem;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


// Responsible for handling score HTTP requests.
@RestController
public class ScoreController {

    private final ScoreService scoreService;


    // Injects scoreService used to manage the game's score.
    public ScoreController(ScoreService scoreService) {
        this.scoreService = scoreService;
    }

    // Increases the score by 1 if a Collision has happened between an asteroid and a bullet,
    // then returns the updated score as plain text.
    @GetMapping("/score")
    public ResponseEntity<String> score(@RequestParam(name = "score", required = true) Integer score) {
        if (score == null) {
            return ResponseEntity.badRequest().body("Missing 'score' parameter");
        }

        int newScore = scoreService.addScore(score);
        return ResponseEntity.ok(String.valueOf(newScore));
    }

    @GetMapping(value = "/score/current", produces = "text/plain")
    public String currentScore() {
        return String.valueOf(scoreService.getScore());
    }

    @PostMapping("/score/reset")
    public void resetScore() {
        scoreService.resetScore();
    }
}
