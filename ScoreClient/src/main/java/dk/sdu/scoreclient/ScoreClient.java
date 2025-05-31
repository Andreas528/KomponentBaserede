package dk.sdu.scoreclient;

import dk.sdu.common.service.IScoreSPI;
import org.springframework.web.client.RestTemplate;

public class ScoreClient implements IScoreSPI {

    private final RestTemplate restTemplate;

    public ScoreClient() {
        this.restTemplate = new RestTemplate();
    }

    public void addScore(int value) {
        {
            // Sends the request.
            String response = restTemplate.getForObject(
                    "http://localhost:8080/score?score=" + value,
                    String.class
            );


            System.out.println("Score now: " + Integer.parseInt(response));
        }
    }
}
