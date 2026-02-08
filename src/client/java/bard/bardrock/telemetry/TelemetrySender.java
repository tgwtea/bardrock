package bard.bardrock.telemetry;

import bard.bardrock.BardrockClient;
import bard.bardrock.net.HttpClient;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class TelemetrySender {
    private static final Gson GSON = new GsonBuilder().create();
    private static final String ENDPOINT = "http://localhost:8000/telemetry";

    private final HttpClient httpClient;
    private final ExecutorService executor = Executors.newSingleThreadExecutor();

    public TelemetrySender() {
        this.httpClient = new HttpClient();
    }

    public void queueSend(TelemetrySample sample) {
        executor.submit(() ->
            send(sample)
        );
    }

    private void send(TelemetrySample sample) {
        try {
            String jsonBody = GSON.toJson(sample);
            httpClient.postJson(ENDPOINT, jsonBody, 5000);
        } catch (Exception e) {
            BardrockClient.LOGGER.warn("Failed to send telemetry data: {}", e.getMessage());
        }
    }
}
