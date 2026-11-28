package exercism.testgenerator.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import exercism.testgenerator.model.CanonicalCase;
import exercism.testgenerator.model.CanonicalData;
import exercism.testgenerator.model.CanonicalDataNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;

public class ProblemSpecService {

    private static final String RAW_CONTENT_URL_FORMAT =
        "https://raw.githubusercontent.com/exercism/problem-specifications/main/exercises/%s/canonical-data.json";

    private final HttpClient httpClient;
    private final ObjectMapper objectMapper;
    private final Path cacheDir;

    public ProblemSpecService() {
        this(
            HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(10))
                .followRedirects(HttpClient.Redirect.NORMAL)
                .build(),
            new ObjectMapper(),
            Paths.get(System.getProperty("user.home"), ".exercism", "cache", "problem-specifications")
        );
    }

    public ProblemSpecService(HttpClient httpClient, ObjectMapper objectMapper) {
        this(
            httpClient,
            objectMapper,
            Paths.get(System.getProperty("user.home"), ".exercism", "cache", "problem-specifications")
        );
    }

    public ProblemSpecService(HttpClient httpClient, ObjectMapper objectMapper, Path cacheDir) {
        this.httpClient = httpClient;
        this.objectMapper = objectMapper;
        this.cacheDir = cacheDir;
    }

    public CanonicalData fetchCanonicalData(String exerciseSlug) throws IOException, InterruptedException {
        // 1. Check environment variable for local problem-specifications repo
        String envPath = System.getenv("PROBLEM_SPECIFICATIONS_PATH");
        if (envPath != null && !envPath.isBlank()) {
            Path candidate = Paths.get(envPath, "exercises", exerciseSlug, "canonical-data.json");
            if (Files.isRegularFile(candidate)) {
                return parseCanonicalData(Files.readString(candidate, StandardCharsets.UTF_8));
            }
        }

        // 2. Check sibling repository: ../problem-specifications
        Path siblingPath = Paths.get("..", "problem-specifications", "exercises", exerciseSlug, "canonical-data.json");
        if (Files.isRegularFile(siblingPath)) {
            return parseCanonicalData(Files.readString(siblingPath, StandardCharsets.UTF_8));
        }

        // 3. Check two levels up: ../../problem-specifications
        Path twoLevelsUp = Paths.get("..", "..", "problem-specifications", "exercises", exerciseSlug, "canonical-data.json");
        if (Files.isRegularFile(twoLevelsUp)) {
            return parseCanonicalData(Files.readString(twoLevelsUp, StandardCharsets.UTF_8));
        }

        // 4. Check local cache directory
        if (cacheDir != null) {
            Path cachedFile = cacheDir.resolve(exerciseSlug).resolve("canonical-data.json");
            if (Files.isRegularFile(cachedFile)) {
                return parseCanonicalData(Files.readString(cachedFile, StandardCharsets.UTF_8));
            }
        }

        // 5. Fetch from GitHub raw content
        String url = String.format(RAW_CONTENT_URL_FORMAT, exerciseSlug);
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .header("User-Agent", "Exercism-Java-Test-Generator")
            .timeout(Duration.ofSeconds(15))
            .GET()
            .build();

        IOException lastException = null;
        for (int attempt = 1; attempt <= 3; attempt++) {
            try {
                HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

                if (response.statusCode() == 404) {
                    throw new CanonicalDataNotFoundException(exerciseSlug,
                        "Canonical data not found for exercise '" + exerciseSlug + "' at: " + url);
                }

                if (response.statusCode() != 200) {
                    throw new IOException("Failed to fetch canonical data for '" + exerciseSlug + "'. HTTP "
                        + response.statusCode() + " from " + url);
                }

                String body = response.body();

                // Save to local cache for future offline / fast runs
                if (cacheDir != null) {
                    try {
                        Path cachedFile = cacheDir.resolve(exerciseSlug).resolve("canonical-data.json");
                        Files.createDirectories(cachedFile.getParent());
                        Files.writeString(cachedFile, body, StandardCharsets.UTF_8);
                    } catch (Exception ignored) {
                        // Caching failure shouldn't fail the execution
                    }
                }

                return parseCanonicalData(body);
            } catch (CanonicalDataNotFoundException e) {
                throw e;
            } catch (IOException e) {
                lastException = e;
                if (attempt < 3) {
                    Thread.sleep(1000L * attempt);
                }
            }
        }

        throw lastException != null ? lastException : new IOException("Failed to fetch: " + url);
    }

    public CanonicalData parseCanonicalData(String jsonContent) throws IOException {
        return objectMapper.readValue(jsonContent, CanonicalData.class);
    }
}
