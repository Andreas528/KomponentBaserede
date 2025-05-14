package dk.sdu.scoreclient;

import org.springframework.web.client.RestTemplate;

public class ScoreClient {

    private final RestTemplate restTemplate;

    public ScoreClient() {
        this.restTemplate = new RestTemplate();
    }

    // Sends a score increment to the scoring server, and logs the updated score.
    public void addScore(int value) {
        try {
            // Sends the request.
            String response = restTemplate.getForObject(
                    "http://localhost:8080/score?score=" + value,
                    String.class
            );

            System.out.println("Sending score: " + value);

            // Parse and log the updated score returned by the server.
            int score = Integer.parseInt(response);
            System.out.println("Score now: " + score);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("FAILED" + e.getMessage());
        }
    }
}
