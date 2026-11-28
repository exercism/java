package exercism.testgenerator.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record TestCaseConfig(
    String description,
    @JsonProperty("include") Boolean include,
    String reimplements,
    String comment
) {
    public boolean isIncluded() {
        return include == null || Boolean.TRUE.equals(include);
    }
}
