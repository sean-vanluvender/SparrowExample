package sparrow.http;

import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.time.ZoneId;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class SparrowClient {

    private String endpoint;
    private String token;
    private String exception;
    private HttpClient client;

    public SparrowClient(String endpoint, String token) {
        this.endpoint = endpoint;
        this.token = token;
        this.client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();
    }
    public static void createFile(int i) throws IOException {
        String date = java.time.LocalDate.now().toString();
        String time = java.time.LocalTime.now(ZoneId.of("America/New_York")).toString();
        String timereplaced = time.replaceAll(":","-");
        File error = new File("C:\\Users\\seanv\\Documents\\Sparrow\\diagnostics\\" + date + "+" + timereplaced + ".txt");
        error.createNewFile();

        FileWriter write = new FileWriter("C:\\Users\\seanv\\Documents\\Sparrow\\diagnostics\\" + date + "+" + timereplaced + ".txt");
        write.write("Sparrow Diagnostics File\nDATE: " + date + "\nTIME: " + time + "\n\n====================\n\nAdvanced status code recognition coming in future version. Your error status code was: " + i);
        write.flush();
        write.close();
    }
    public boolean raiseAlert() throws IOException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endpoint))
                .header("Content-Type", "application/json")
                .header("Authorization", "Token " + token)
                .POST(BodyPublishers.ofString("{\"type\":\"emergency\"}"))
                .build();
        try {
            HttpResponse<Void> response = client.send(request, BodyHandlers.discarding());
            if (response.statusCode() != 201) {
                createFile(response.statusCode());
                return false;
            }else{
                return true;
            }
        } catch (IOException | InterruptedException e) {
            createFile(7);
            return false;
        }
    }
}
