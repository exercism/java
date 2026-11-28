package exercism.testgenerator.model;

import com.fasterxml.jackson.databind.JsonNode;
import java.util.Map;

public record RenderedTestCase(
    String uuid,
    String description,
    String methodName,
    boolean disabled,
    boolean expectedError,
    String expectedException,
    String expectedErrorMessage,
    boolean isNullExpected,
    boolean isBooleanExpected,
    boolean booleanValue,
    boolean isFloatingPointExpected,
    String expectedValue,
    String invocationCode,
    String property,
    Map<String, String> formattedInputs,
    Map<String, JsonNode> inputNodes,
    JsonNode rawInput,
    CanonicalCase rawCase
) {
    public String assertionCode() {
        if (expectedError) {
            String msg = (expectedErrorMessage != null && !expectedErrorMessage.isBlank())
                ? "\n                .withMessage(\"" + exercism.testgenerator.service.JavaTypeFormatter.escapeJavaString(expectedErrorMessage) + "\")"
                : "";
            return "assertThatExceptionOfType(" + expectedException + ".class)\n"
                + "                .isThrownBy(() -> " + invocationCode + ")"
                + msg + ";";
        }
        if (isNullExpected) {
            return "assertThat(" + invocationCode + ")\n                .isNull();";
        }
        if (isBooleanExpected) {
            return "assertThat(" + invocationCode + ")\n                ." + (booleanValue ? "isTrue" : "isFalse") + "();";
        }
        if (isFloatingPointExpected) {
            return "assertThat(" + invocationCode + ")\n                .isEqualTo(" + expectedValue + ", offset(0.01));";
        }
        return "assertThat(" + invocationCode + ")\n                .isEqualTo(" + expectedValue + ");";
    }

    public String displayNameAnnotation() {
        if (description == null || description.isBlank()) {
            return "@DisplayName(\"\")";
        }
        String escaped = exercism.testgenerator.service.JavaTypeFormatter.escapeJavaString(description);
        if (escaped.length() <= 85) {
            return "@DisplayName(\"" + escaped + "\")";
        }
        java.util.List<String> chunks = new java.util.ArrayList<>();
        int start = 0;
        while (start < escaped.length()) {
            int end = Math.min(start + 70, escaped.length());
            if (end < escaped.length()) {
                int lastSpace = escaped.lastIndexOf(' ', end);
                if (lastSpace > start + 30) {
                    end = lastSpace + 1;
                }
            }
            chunks.add("\"" + escaped.substring(start, end) + "\"");
            start = end;
        }
        return "@DisplayName(" + String.join("\n            + ", chunks) + ")";
    }
}
