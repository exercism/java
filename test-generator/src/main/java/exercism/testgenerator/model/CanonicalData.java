package exercism.testgenerator.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CanonicalData(
    String exercise,
    List<JsonNode> cases,
    List<String> comments
) {}
