package exercism.testgenerator.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import exercism.testgenerator.model.CanonicalCase;
import java.util.ArrayList;
import java.util.List;

public class CaseFlattener {

    private final ObjectMapper objectMapper;

    public CaseFlattener() {
        this(new ObjectMapper());
    }

    public CaseFlattener(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public List<CanonicalCase> flatten(List<JsonNode> rawCases) {
        List<CanonicalCase> flattened = new ArrayList<>();
        if (rawCases == null) {
            return flattened;
        }

        for (JsonNode node : rawCases) {
            collectCases(node, new ArrayList<>(), flattened);
        }
        return flattened;
    }

    private void collectCases(JsonNode node, List<String> parentDescriptions, List<CanonicalCase> result) {
        if (node == null || node.isNull()) {
            return;
        }

        if (node.hasNonNull("uuid")) {
            try {
                CanonicalCase rawCase = objectMapper.treeToValue(node, CanonicalCase.class);
                String fullDescription;
                if (!parentDescriptions.isEmpty()) {
                    String desc = (rawCase.description() != null && !rawCase.description().isBlank())
                        ? rawCase.description()
                        : "";
                    fullDescription = String.join(" -> ", parentDescriptions) + (!desc.isEmpty() ? " -> " + desc : "");
                } else {
                    fullDescription = rawCase.description();
                }

                CanonicalCase canonicalCase = new CanonicalCase(
                    rawCase.uuid(),
                    fullDescription,
                    rawCase.property(),
                    rawCase.input(),
                    rawCase.expected(),
                    rawCase.scenarios(),
                    rawCase.comments()
                );
                result.add(canonicalCase);
            } catch (JsonProcessingException e) {
                throw new RuntimeException("Failed to parse canonical case: " + node, e);
            }
        } else if (node.has("cases") && node.get("cases").isArray()) {
            List<String> nextParents = new ArrayList<>(parentDescriptions);
            if (node.hasNonNull("description") && !node.get("description").asText().isBlank()) {
                nextParents.add(node.get("description").asText().trim());
            }
            for (JsonNode subNode : node.get("cases")) {
                collectCases(subNode, nextParents, result);
            }
        }
    }
}
