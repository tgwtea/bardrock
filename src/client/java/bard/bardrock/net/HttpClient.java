
package bard.bardrock.net;

import bard.bardrock.BardrockClient;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class HttpClient {

    public void postJson(String url, String jsonBody, int timeoutMillis) throws Exception {
        URL endpoint = new URL(url);
        HttpURLConnection conn = (HttpURLConnection) endpoint.openConnection();
        conn.setConnectTimeout(timeoutMillis);
        conn.setReadTimeout(timeoutMillis);
        conn.setRequestMethod("POST");
        conn.setDoOutput(true);
        conn.setRequestProperty("Content-Type", "application/json");

        byte[] bytes = jsonBody.getBytes(StandardCharsets.UTF_8);
        conn.setFixedLengthStreamingMode(bytes.length);

        try (OutputStream os = conn.getOutputStream()) {
            os.write(bytes);
        }

        BardrockClient.LOGGER.info("Sent telemetry data: {}", jsonBody);

        int code = conn.getResponseCode();
        // Optional: inspect code or read response stream
        conn.disconnect();
    }
}
