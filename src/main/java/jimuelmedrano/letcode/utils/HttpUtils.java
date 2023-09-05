package jimuelmedrano.letcode.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import jimuelmedrano.letcode.constants.FrameworkConstants;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;

public class HttpUtils {

    public static JSONObject GET(String baseUrl, String endpoint) throws IOException, InterruptedException {
        JSONObject jsonResponse;
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(baseUrl+endpoint))
                    .build();

            HttpResponse<String> response = client.send(request,
                    HttpResponse.BodyHandlers.ofString());

            jsonResponse = new JSONObject(response.body());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return jsonResponse;
    }

    public static JSONObject POST(String baseUrl, String endpoint, HashMap<String, String> body) throws IOException, InterruptedException {
        JSONObject jsonResponse;
        try {

            var objectMapper = new ObjectMapper();
            String requestBody = objectMapper
                    .writeValueAsString(body);

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(baseUrl+endpoint))
                    .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                    .build();

            HttpResponse<String> response = client.send(request,
                    HttpResponse.BodyHandlers.ofString());

            jsonResponse = new JSONObject(response.body());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return jsonResponse;
    }
}
