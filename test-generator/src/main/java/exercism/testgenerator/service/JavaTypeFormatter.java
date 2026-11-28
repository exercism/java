package exercism.testgenerator.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class JavaTypeFormatter {

    public static String format(JsonNode node) {
        if (node == null || node.isNull()) {
            return "null";
        }

        if (node.isBoolean()) {
            return Boolean.toString(node.asBoolean());
        }

        if (node.isTextual()) {
            String text = node.asText();
            String escaped = escapeJavaString(text);
            if (escaped.length() > 70) {
                List<String> chunks = new ArrayList<>();
                int start = 0;
                while (start < escaped.length()) {
                    int end = Math.min(start + 65, escaped.length());
                    if (end < escaped.length()) {
                        int lastSpace = escaped.lastIndexOf(' ', end);
                        if (lastSpace > start + 30) {
                            end = lastSpace + 1;
                        }
                    }
                    chunks.add("\"" + escaped.substring(start, end) + "\"");
                    start = end;
                }
                return String.join("\n                        + ", chunks);
            }
            return "\"" + escaped + "\"";
        }

        if (node.isLong() || (node.isIntegralNumber() && (node.asLong() > Integer.MAX_VALUE || node.asLong() < Integer.MIN_VALUE))) {
            return node.asText() + "L";
        }

        if (node.isInt()) {
            return node.asText();
        }

        if (node.isFloatingPointNumber()) {
            double val = node.asDouble();
            // ensure there is a decimal or scientific notation
            String s = Double.toString(val);
            return s;
        }

        if (node.isArray()) {
            ArrayNode arrayNode = (ArrayNode) node;
            if (arrayNode.isEmpty()) {
                return "List.of()";
            }
            boolean hasNull = false;
            for (JsonNode elem : arrayNode) {
                if (elem.isNull()) {
                    hasNull = true;
                    break;
                }
            }

            if (hasNull && arrayNode.size() == 1) {
                return "java.util.Collections.singletonList(null)";
            }

            String factory = hasNull ? "java.util.Arrays.asList" : "List.of";
            List<String> elements = new ArrayList<>();
            for (JsonNode elem : arrayNode) {
                elements.add(format(elem));
            }
            String joined = String.join(", ", elements);
            if (joined.length() > 60 || elements.size() > 8) {
                return factory + "(\n"
                    + "                        " + String.join(",\n                        ", elements)
                    + "\n                )";
            }
            return factory + "(" + joined + ")";
        }

        if (node.isObject()) {
            ObjectNode objNode = (ObjectNode) node;
            if (objNode.isEmpty()) {
                return "Map.of()";
            }
            List<String> entries = new ArrayList<>();
            Iterator<Map.Entry<String, JsonNode>> fields = objNode.fields();
            while (fields.hasNext()) {
                Map.Entry<String, JsonNode> entry = fields.next();
                entries.add("\"" + escapeJavaString(entry.getKey()) + "\", " + format(entry.getValue()));
            }
            if (entries.size() <= 10) {
                String joined = String.join(", ", entries);
                if (joined.length() > 60 || entries.size() > 3) {
                    return "Map.of(\n"
                        + "                        " + String.join(",\n                        ", entries)
                        + "\n                )";
                }
                return "Map.of(" + joined + ")";
            } else {
                return "Map.ofEntries(\n"
                    + "                        " + String.join(",\n                        ", entries.stream().map(e -> "Map.entry(" + e + ")").toList())
                    + "\n                )";
            }
        }

        return node.asText();
    }

    public static String escapeJavaString(String input) {
        if (input == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (char c : input.toCharArray()) {
            switch (c) {
                case '"':
                    sb.append("\\\"");
                    break;
                case '\\':
                    sb.append("\\\\");
                    break;
                case '\b':
                    sb.append("\\b");
                    break;
                case '\f':
                    sb.append("\\f");
                    break;
                case '\n':
                    sb.append("\\n");
                    break;
                case '\r':
                    sb.append("\\r");
                    break;
                case '\t':
                    sb.append("\\t");
                    break;
                default:
                    if (Character.isISOControl(c)) {
                        sb.append(String.format("\\u%04x", (int) c));
                    } else {
                        sb.append(c);
                    }
                    break;
            }
        }
        return sb.toString();
    }
}
