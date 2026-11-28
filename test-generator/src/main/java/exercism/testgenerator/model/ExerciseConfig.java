package exercism.testgenerator.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ExerciseConfig(
    Map<String, List<String>> files,
    String blurb
) {
    public String getTestFilePath() {
        if (files != null && files.containsKey("test") && !files.get("test").isEmpty()) {
            return files.get("test").get(0);
        }
        return null;
    }

    public String getSolutionFilePath() {
        if (files != null && files.containsKey("solution") && !files.get("solution").isEmpty()) {
            return files.get("solution").get(0);
        }
        return null;
    }

    public String getTestClassName() {
        String testPath = getTestFilePath();
        if (testPath == null) {
            return null;
        }
        Path path = Paths.get(testPath);
        String fileName = path.getFileName().toString();
        if (fileName.endsWith(".java")) {
            return fileName.substring(0, fileName.length() - 5);
        }
        return fileName;
    }

    public String getSolutionClassName() {
        String solPath = getSolutionFilePath();
        if (solPath == null) {
            return null;
        }
        Path path = Paths.get(solPath);
        String fileName = path.getFileName().toString();
        if (fileName.endsWith(".java")) {
            return fileName.substring(0, fileName.length() - 5);
        }
        return fileName;
    }
}
