package exercism.testgenerator.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CanonicalCase(
    String uuid,
    String description,
    String property,
    JsonNode input,
    JsonNode expected,
    List<String> scenarios,
    List<String> comments
) {
    public boolean isErrorExpected() {
        return expected != null && expected.isObject() && expected.has("error");
    }

    public String getExpectedErrorMessage() {
        if (isErrorExpected()) {
            return expected.get("error").asText();
        }
        return null;
    }
}
