package dk.sdu.scoreclient;

import dk.sdu.common.service.IScore;
import org.springframework.web.client.RestTemplate;

public class ScoreClient implements IScore {

    private final RestTemplate restTemplate;

    public ScoreClient() {
        this.restTemplate = new RestTemplate();
    }

    // Sends a score increment to the scoring server, and logs the updated score.
    public void addScore(int value) {
        {
            // Sends the request.
            String response = restTemplate.getForObject(
                    "http://localhost:8080/score?score=" + value,
                    String.class
            );


            // Parse and log the updated score returned by the server.
            System.out.println("Score now: " + Integer.parseInt(response));
        }
    }
}
