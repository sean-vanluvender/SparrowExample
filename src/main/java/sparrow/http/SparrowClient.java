package sparrow.http;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class SparrowClient {

    private String endpoint;
    private String roomName;
    private HttpClient client;

    public SparrowClient(String endpoint, String name) {
        this.endpoint = endpoint;
        this.roomName = name;
        this.client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();
    }

    public boolean raiseAlert() {
        String body = String.format("{\"room\":\"%s\", \"type\":\"emergency\"}", roomName);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endpoint))
                .header("Content-Type", "application/json")
                .POST(BodyPublishers.ofString(body))
                .build();
        try {
            HttpResponse<Void> response = client.send(request, BodyHandlers.discarding());
            return response.statusCode() == 201;
        } catch(IOException | InterruptedException e) {
            return false;
        }
    }

}
