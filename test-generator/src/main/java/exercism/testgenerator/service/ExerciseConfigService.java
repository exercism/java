package exercism.testgenerator.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import exercism.testgenerator.model.ExerciseConfig;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ExerciseConfigService {

    private final ObjectMapper objectMapper;

    public ExerciseConfigService() {
        this(new ObjectMapper());
    }

    public ExerciseConfigService(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public ExerciseConfig parseConfig(Path configPath) throws IOException {
        if (!Files.exists(configPath)) {
            throw new IOException("Exercise config file not found at: " + configPath);
        }
        return parseConfig(Files.readString(configPath));
    }

    public ExerciseConfig parseConfig(String jsonContent) throws IOException {
        return objectMapper.readValue(jsonContent, ExerciseConfig.class);
    }
}
