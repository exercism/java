package exercism.testgenerator.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.toml.TomlMapper;
import exercism.testgenerator.model.TestCaseConfig;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TestsTomlService {

    private final TomlMapper tomlMapper;

    public TestsTomlService() {
        this.tomlMapper = new TomlMapper();
    }

    public Map<String, TestCaseConfig> parseTestsToml(Path tomlPath) throws IOException {
        if (!Files.exists(tomlPath)) {
            return Collections.emptyMap();
        }
        return parseTestsToml(Files.readString(tomlPath));
    }

    public Map<String, TestCaseConfig> parseTestsToml(String tomlContent) throws IOException {
        if (tomlContent == null || tomlContent.isBlank()) {
            return Collections.emptyMap();
        }
        return tomlMapper.readValue(tomlContent, new TypeReference<Map<String, TestCaseConfig>>() {});
    }

    public boolean isCaseIncluded(Map<String, TestCaseConfig> configs, String uuid) {
        if (configs == null || configs.isEmpty()) {
            return true;
        }
        if (!configs.containsKey(uuid)) {
            // If tests.toml exists and has entries, omitted UUIDs are unsynced/unimplemented
            return false;
        }
        TestCaseConfig config = configs.get(uuid);
        return config == null || config.isIncluded();
    }
}
