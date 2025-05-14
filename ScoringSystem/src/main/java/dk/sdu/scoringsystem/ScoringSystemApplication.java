package dk.sdu.scoringsystem;
import dk.sdu.common.data.GameData;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ScoringSystemApplication {

    private Long totalScore = 0L;

    public static void main(String[] args) {
        SpringApplication.run(ScoringSystemApplication.class, args);
    }

    @GetMapping("/score")
    public Long score(@RequestParam Long score) {
        totalScore += score;
        return totalScore;
    }
}
