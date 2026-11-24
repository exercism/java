package exercism.testgenerator.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.jknack.handlebars.Context;
import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Helper;
import com.github.jknack.handlebars.Options;
import com.github.jknack.handlebars.Template;
import com.github.jknack.handlebars.JsonNodeValueResolver;
import com.github.jknack.handlebars.context.FieldValueResolver;
import com.github.jknack.handlebars.context.JavaBeanValueResolver;
import com.github.jknack.handlebars.context.MapValueResolver;
import com.github.jknack.handlebars.context.MethodValueResolver;
import com.github.jknack.handlebars.io.ClassPathTemplateLoader;
import com.github.jknack.handlebars.io.TemplateLoader;
import exercism.testgenerator.model.CanonicalCase;
import exercism.testgenerator.model.RenderedExercise;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class TemplateRenderer {

    private final Handlebars handlebars;

    public TemplateRenderer() {
        TemplateLoader loader = new ClassPathTemplateLoader("/templates", ".hbs");
        this.handlebars = new Handlebars(loader);
        registerHelpers();
    }

    private void registerHelpers() {
        handlebars.registerHelper("eq", (a, options) -> {
            Object b = options.param(0, null);
            if (a == null && b == null) {
                return true;
            }
            if (a != null && b != null) {
                // If both are numbers, compare their string forms or numerical values
                if (a.toString().equals(b.toString())) return true;
            }
            return a != null && a.equals(b);
        });

        handlebars.registerHelper("not", (a, options) -> {
            return a == null || Boolean.FALSE.equals(a) || "false".equalsIgnoreCase(a.toString());
        });

        handlebars.registerHelper("and", (a, options) -> {
            boolean first = a != null && !Boolean.FALSE.equals(a) && !"false".equalsIgnoreCase(a.toString());
            if (!first) return false;
            for (Object param : options.params) {
                boolean val = param != null && !Boolean.FALSE.equals(param) && !"false".equalsIgnoreCase(param.toString());
                if (!val) return false;
            }
            return true;
        });

        handlebars.registerHelper("or", (a, options) -> {
            boolean first = a != null && !Boolean.FALSE.equals(a) && !"false".equalsIgnoreCase(a.toString());
            if (first) return true;
            for (Object param : options.params) {
                boolean val = param != null && !Boolean.FALSE.equals(param) && !"false".equalsIgnoreCase(param.toString());
                if (val) return true;
            }
            return false;
        });

        handlebars.registerHelper("contains", (a, options) -> {
            if (a == null) return false;
            Object b = options.param(0, null);
            if (b == null) return false;
            return a.toString().contains(b.toString());
        });

        handlebars.registerHelper("lte", (context, options) -> {
            if (context == null) return false;
            try {
                long val = Long.parseLong(context.toString());
                long limit = Long.parseLong(options.param(0).toString());
                return val <= limit;
            } catch (Exception e) {
                return false;
            }
        });

        handlebars.registerHelper("camelCase", (context, options) -> {
            if (context == null) return "";
            return JavaNamingHelper.toMethodName(context.toString());
        });

        handlebars.registerHelper("pascalCase", (context, options) -> {
            if (context == null) return "";
            return JavaNamingHelper.toPascalCase(context.toString());
        });

        handlebars.registerHelper("escapeJava", (context, options) -> {
            if (context == null) return "";
            String text = context instanceof JsonNode node ? node.asText() : context.toString();
            return JavaTypeFormatter.escapeJavaString(text);
        });

        handlebars.registerHelper("formatJava", (context, options) -> {
            if (context instanceof JsonNode node) {
                return JavaTypeFormatter.format(node);
            }
            return context == null ? "null" : context.toString();
        });

        handlebars.registerHelper("formatElements", (context, options) -> {
            if (context instanceof JsonNode node && node.isArray()) {
                java.util.List<String> list = new java.util.ArrayList<>();
                for (JsonNode item : node) {
                    list.add(JavaTypeFormatter.format(item));
                }
                String joined = String.join(", ", list);
                if (joined.length() > 50 || list.size() > 5) {
                    return "\n                        " + String.join(",\n                        ", list);
                }
                return joined;
            }
            return "";
        });

        handlebars.registerHelper("asIntArray", (context, options) -> {
            if (context instanceof JsonNode node && node.isArray()) {
                java.util.List<String> list = new java.util.ArrayList<>();
                for (JsonNode item : node) {
                    list.add(item.asText());
                }
                String joined = String.join(", ", list);
                if (joined.length() > 50 || list.size() > 8) {
                    return "new int[]{\n                        " + String.join(",\n                        ", list) + "\n                }";
                }
                return "new int[]{" + joined + "}";
            }
            return "new int[]{}";
        });

        handlebars.registerHelper("asStringArray", (context, options) -> {
            if (context instanceof JsonNode node && node.isArray()) {
                java.util.List<String> list = new java.util.ArrayList<>();
                for (JsonNode item : node) {
                    list.add("\"" + JavaTypeFormatter.escapeJavaString(item.asText()) + "\"");
                }
                String joined = String.join(", ", list);
                if (joined.length() > 50 || list.size() > 5) {
                    return "new String[]{\n            "
                        + String.join(",\n            ", list)
                        + "\n        }";
                }
                return "new String[]{" + joined + "}";
            }
            return "new String[]{}";
        });

        handlebars.registerHelper("joinLines", (context, options) -> {
            if (context instanceof JsonNode node && node.isArray()) {
                if (node.isEmpty()) {
                    return "\"\"";
                }
                if (node.size() == 1) {
                    return "\"" + JavaTypeFormatter.escapeJavaString(node.get(0).asText()) + "\"";
                }
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < node.size(); i++) {
                    String line = JavaTypeFormatter.escapeJavaString(node.get(i).asText());
                    if (i > 0) {
                        sb.append("\n                        + ");
                    }
                    sb.append("\"").append(line);
                    if (i < node.size() - 1) {
                        sb.append("\\n\"");
                    } else {
                        sb.append("\"");
                    }
                }
                return sb.toString();
            }
            return "\"\"";
        });

        handlebars.registerHelper("asLong", (context, options) -> {
            if (context == null) return "0L";
            String s = context.toString();
            return s.endsWith("L") || s.endsWith("l") ? s : s + "L";
        });

        handlebars.registerHelper("asLongList", (context, options) -> {
            if (context instanceof JsonNode node && node.isArray()) {
                if (node.isEmpty()) {
                    return "List.of()";
                }
                java.util.List<String> list = new java.util.ArrayList<>();
                for (JsonNode item : node) {
                    list.add(item.asText() + "L");
                }
                String joined = String.join(", ", list);
                if (joined.length() > 50 || list.size() > 8) {
                    return "List.of(\n                        " + String.join(",\n                        ", list) + "\n                )";
                }
                return "List.of(" + joined + ")";
            }
            return "List.of()";
        });

        handlebars.registerHelper("asSignals", (context, options) -> {
            if (context instanceof JsonNode node && node.isArray()) {
                if (node.isEmpty()) {
                    return "";
                }
                java.util.List<String> list = new java.util.ArrayList<>();
                for (JsonNode item : node) {
                    String text = item.asText();
                    String enumName = switch (text) {
                        case "wink" -> "Signal.WINK";
                        case "double blink" -> "Signal.DOUBLE_BLINK";
                        case "close your eyes" -> "Signal.CLOSE_YOUR_EYES";
                        case "jump" -> "Signal.JUMP";
                        default -> "Signal." + text.toUpperCase().replace(" ", "_");
                    };
                    list.add(enumName);
                }
                String joined = String.join(", ", list);
                if (joined.length() > 50) {
                    return "\n                        " + String.join(",\n                        ", list);
                }
                return joined;
            }
            return "";
        });

        handlebars.registerHelper("formatResistorLabel", (context, options) -> {
            if (context instanceof JsonNode node && node.isObject()) {
                return "\"" + node.path("value").asText() + " " + node.path("unit").asText() + "\"";
            }
            return "\"\"";
        });

        handlebars.registerHelper("spaceAgeMethod", (context, options) -> {
            if (context == null) return "onEarth";
            String planet = context instanceof JsonNode node ? node.asText() : context.toString();
            return "on" + Character.toUpperCase(planet.charAt(0)) + planet.substring(1);
        });

        handlebars.registerHelper("isIllegalTriangle", (context, options) -> {
            if (context instanceof JsonNode node && node.isArray() && node.size() == 3) {
                double a = node.get(0).asDouble();
                double b = node.get(1).asDouble();
                double c = node.get(2).asDouble();
                return (a <= 0 || b <= 0 || c <= 0 || a + b <= c || a + c <= b || b + c <= a);
            }
            return false;
        });

        handlebars.registerHelper("allYourBaseErrorMessage", (context, options) -> {
            CanonicalCase c = toCanonicalCase(context);
            if (c == null) return "Bases must be at least 2.";
            int inBase = c.input().path("inputBase").asInt(2);
            int outBase = c.input().path("outputBase").asInt(2);
            if (inBase < 2 || outBase < 2) {
                return "Bases must be at least 2.";
            }
            JsonNode digits = c.input().path("digits");
            if (digits.isArray()) {
                for (JsonNode d : digits) {
                    if (d.asInt() < 0) {
                        return "Digits may not be negative.";
                    }
                }
                for (JsonNode d : digits) {
                    if (d.asInt() >= inBase) {
                        return "All digits must be strictly less than the base.";
                    }
                }
            }
            return "Bases must be at least 2.";
        });

        handlebars.registerHelper("largestSeriesProductExpectedMessage", (context, options) -> {
            CanonicalCase c = toCanonicalCase(context);
            if (c == null) return "";
            String digits = c.input().path("digits").asText();
            int span = c.input().path("span").asInt();
            if (!digits.chars().allMatch(Character::isDigit)) {
                return "String to search may only contain digits.";
            }
            if (span < 0) {
                return "Series length must be non-negative.";
            }
            return "Series length must be less than or equal to the length of the string to search.";
        });

        handlebars.registerHelper("asAllergens", (context, options) -> {
            if (context instanceof JsonNode node && node.isArray()) {
                if (node.isEmpty()) return "";
                java.util.List<String> list = new java.util.ArrayList<>();
                for (JsonNode item : node) {
                    list.add("Allergen." + item.asText().toUpperCase());
                }
                String joined = String.join(", ", list);
                if (joined.length() > 50 || list.size() > 4) {
                    return "\n                        " + String.join(",\n                        ", list);
                }
                return joined;
            }
            return "";
        });

        handlebars.registerHelper("toAllergen", (context, options) -> {
            if (context == null) return "Allergen.EGGS";
            String s = context instanceof JsonNode node ? node.asText() : context.toString();
            return "Allergen." + s.toUpperCase().replace("\"", "");
        });

        handlebars.registerHelper("toChar", (context, options) -> {
            if (context == null) return "' '";
            String s = context.toString().replace("\"", "").replace("'", "");
            return "'" + (s.isEmpty() ? ' ' : s.charAt(0)) + "'";
        });

        handlebars.registerHelper("as2DIntArray", (context, options) -> {
            if (context instanceof JsonNode node && node.isArray()) {
                if (node.isEmpty()) {
                    return "new int[][]{}";
                }
                int baseIndent = 16;
                int elemIndent = 24;
                if (options.params.length > 0 && options.param(0) != null) {
                    try {
                        baseIndent = Integer.parseInt(options.param(0).toString());
                        elemIndent = baseIndent == 8 ? 12 : baseIndent + 8;
                    } catch (Exception ignored) {}
                }
                String elemSpaces = " ".repeat(elemIndent);
                String rcurlySpaces = " ".repeat(baseIndent);

                java.util.List<String> rows = new java.util.ArrayList<>();
                for (JsonNode row : node) {
                    java.util.List<String> elements = new java.util.ArrayList<>();
                    for (JsonNode el : row) {
                        elements.add(el.asText());
                    }
                    rows.add("{" + String.join(", ", elements) + "}");
                }
                if (rows.size() <= 3 && String.join(", ", rows).length() <= 40) {
                    return "new int[][]{" + String.join(", ", rows) + "}";
                }
                return "new int[][]{\n" + elemSpaces
                    + String.join(",\n" + elemSpaces, rows)
                    + "\n" + rcurlySpaces + "}";
            }
            return "new int[][]{}";
        });

        handlebars.registerHelper("twelveDaysExpected", (context, options) -> {
            if (context instanceof JsonNode node && node.isArray()) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < node.size(); i++) {
                    String verse = node.get(i).asText() + "\n";
                    if (i > 0) {
                        sb.append("\n                        + \"\\n\"\n                        + ");
                    }
                    sb.append(breakStringIntoChunks(verse, 26));
                }
                return sb.toString();
            }
            return "\"\"";
        });

        handlebars.registerHelper("asPlants", (context, options) -> {
            if (context instanceof JsonNode node && node.isArray()) {
                java.util.List<String> list = new java.util.ArrayList<>();
                for (JsonNode item : node) {
                    list.add("Plant." + item.asText().toUpperCase());
                }
                String joined = String.join(", ", list);
                if (joined.length() > 50 || list.size() > 4) {
                    return "\n                        " + String.join(",\n                        ", list);
                }
                return joined;
            }
            return "";
        });

        handlebars.registerHelper("toYachtCategory", (context, options) -> {
            if (context == null) return "YACHT";
            String s = context instanceof JsonNode node ? node.asText() : context.toString();
            return s.trim().toUpperCase().replace(" ", "_").replace("-", "_").replace("\"", "");
        });

        handlebars.registerHelper("formatEtlInput", (context, options) -> {
            if (context instanceof JsonNode node && node.isObject()) {
                java.util.List<String> entries = new java.util.ArrayList<>();
                var fields = node.fields();
                while (fields.hasNext()) {
                    var entry = fields.next();
                    int score = Integer.parseInt(entry.getKey());
                    JsonNode letters = entry.getValue();
                    java.util.List<String> letterList = new java.util.ArrayList<>();
                    for (JsonNode l : letters) {
                        letterList.add("\"" + l.asText() + "\"");
                    }
                    entries.add("Map.entry(" + score + ", List.of(" + String.join(", ", letterList) + "))");
                }
                if (entries.size() == 1) {
                    return "Map.ofEntries(" + entries.get(0) + ")";
                }
                return "Map.ofEntries(\n                " + String.join(",\n                ", entries) + "\n        )";
            }
            return "Map.of()";
        });

        handlebars.registerHelper("formatEtlExpected", (context, options) -> {
            if (context instanceof JsonNode node && node.isObject()) {
                java.util.List<String> entries = new java.util.ArrayList<>();
                var fields = node.fields();
                while (fields.hasNext()) {
                    var entry = fields.next();
                    entries.add("Map.entry(\"" + entry.getKey() + "\", " + entry.getValue().asInt() + ")");
                }
                if (entries.size() <= 3) {
                    return "Map.ofEntries(" + String.join(", ", entries) + ")";
                }
                return "Map.ofEntries(\n                " + String.join(",\n                ", entries) + "\n        )";
            }
            return "Map.of()";
        });

        handlebars.registerHelper("bottleSongExpected", (context, options) -> {
            if (context instanceof JsonNode node && node.isArray()) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < node.size(); i++) {
                    String line = node.get(i).asText();
                    String lineWithNewline = line.isEmpty() ? "\\n" : (JavaTypeFormatter.escapeJavaString(line) + "\\n");
                    if (i > 0) {
                        sb.append("\n                        + ");
                    }
                    sb.append("\"").append(lineWithNewline).append("\"");
                }
                return sb.toString();
            }
            return "\"\"";
        });

        handlebars.registerHelper("as2DIntList", (context, options) -> {
            if (context instanceof JsonNode node && node.isArray()) {
                if (node.isEmpty()) {
                    return "List.of()";
                }
                java.util.List<String> innerLists = new java.util.ArrayList<>();
                for (JsonNode row : node) {
                    java.util.List<String> items = new java.util.ArrayList<>();
                    for (JsonNode el : row) {
                        items.add(el.asText());
                    }
                    innerLists.add("List.of(" + String.join(", ", items) + ")");
                }
                if (innerLists.size() <= 2 && String.join(", ", innerLists).length() <= 40) {
                    return "List.of(" + String.join(", ", innerLists) + ")";
                }
                return "List.of(\n                "
                    + String.join(",\n                ", innerLists)
                    + "\n        )";
            }
            return "List.of()";
        });

        handlebars.registerHelper("asIntList", (context, options) -> {
            if (context instanceof JsonNode node && node.isArray()) {
                if (node.isEmpty()) {
                    return "List.of()";
                }
                java.util.List<String> items = new java.util.ArrayList<>();
                for (JsonNode el : node) {
                    items.add(el.asText());
                }
                String joined = String.join(", ", items);
                if (joined.length() > 60 || items.size() > 10) {
                    return "List.of(\n                        "
                        + String.join(",\n                        ", items)
                        + "\n                )";
                }
                return "List.of(" + joined + ")";
            }
            return "List.of()";
        });

        handlebars.registerHelper("asLaserInfo", (context, options) -> {
            if (context instanceof JsonNode node) {
                return "new Prism.LaserInfo(" + node.get("x") + ", " + node.get("y") + ", " + node.get("angle") + ")";
            }
            if (context instanceof java.util.Map<?, ?> map) {
                return "new Prism.LaserInfo(" + map.get("x") + ", " + map.get("y") + ", " + map.get("angle") + ")";
            }
            return "new Prism.LaserInfo(0, 0, 0)";
        });

        handlebars.registerHelper("asPrismInfoList", (context, options) -> {
            if (context instanceof JsonNode node && node.isArray()) {
                if (node.isEmpty()) {
                    return "List.of()";
                }
                java.util.List<String> prisms = new java.util.ArrayList<>();
                for (JsonNode p : node) {
                    prisms.add("new Prism.PrismInfo(" + p.get("id") + ", " + p.get("x") + ", " + p.get("y") + ", " + p.get("angle") + ")");
                }
                if (prisms.size() <= 2 && String.join(", ", prisms).length() <= 60) {
                    return "List.of(" + String.join(", ", prisms) + ")";
                }
                return "List.of(\n                        "
                    + String.join(",\n                        ", prisms)
                    + "\n                )";
            }
            if (context instanceof java.util.Collection<?> col) {
                if (col.isEmpty()) {
                    return "List.of()";
                }
                java.util.List<String> prisms = new java.util.ArrayList<>();
                for (Object item : col) {
                    if (item instanceof java.util.Map<?, ?> p) {
                        prisms.add("new Prism.PrismInfo(" + p.get("id") + ", " + p.get("x") + ", " + p.get("y") + ", " + p.get("angle") + ")");
                    } else if (item instanceof JsonNode p) {
                        prisms.add("new Prism.PrismInfo(" + p.get("id") + ", " + p.get("x") + ", " + p.get("y") + ", " + p.get("angle") + ")");
                    }
                }
                if (prisms.size() <= 2 && String.join(", ", prisms).length() <= 60) {
                    return "List.of(" + String.join(", ", prisms) + ")";
                }
                return "List.of(\n                        "
                    + String.join(",\n                        ", prisms)
                    + "\n                )";
            }
            return "List.of()";
        });

        handlebars.registerHelper("asMatrixCoordinates", (context, options) -> {
            if (context instanceof JsonNode node && node.isArray()) {
                if (node.isEmpty()) {
                    return "Set.of()";
                }
                java.util.List<String> coords = new java.util.ArrayList<>();
                for (JsonNode item : node) {
                    coords.add("new MatrixCoordinate(" + item.get("row").asInt() + ", " + item.get("column").asInt() + ")");
                }
                return "Set.of(" + String.join(", ", coords) + ")";
            }
            return "Set.of()";
        });

        handlebars.registerHelper("asHexLongList", (context, options) -> {
            if (context instanceof JsonNode node && node.isArray()) {
                if (node.isEmpty()) return "List.of()";
                java.util.List<String> list = new java.util.ArrayList<>();
                for (JsonNode el : node) {
                    long val = el.asLong();
                    list.add("0x" + Long.toHexString(val) + "L");
                }
                if (list.size() <= 4 && String.join(", ", list).length() <= 45) {
                    return "List.of(" + String.join(", ", list) + ")";
                }
                return "List.of(\n                " + String.join(",\n                ", list) + "\n        )";
            }
            return "List.of()";
        });

        handlebars.registerHelper("asHexStringList", (context, options) -> {
            if (context instanceof JsonNode node && node.isArray()) {
                if (node.isEmpty()) return "List.of()";
                java.util.List<String> list = new java.util.ArrayList<>();
                for (JsonNode el : node) {
                    long val = el.asLong();
                    list.add("\"0x" + Long.toHexString(val) + "\"");
                }
                if (list.size() <= 4 && String.join(", ", list).length() <= 45) {
                    return "List.of(" + String.join(", ", list) + ")";
                }
                return "List.of(\n                " + String.join(",\n                ", list) + "\n        )";
            }
            return "List.of()";
        });

        handlebars.registerHelper("asKnapsackItems", (context, options) -> {
            if (context instanceof JsonNode node && node.isArray()) {
                if (node.isEmpty()) {
                    return "List.of()";
                }
                java.util.List<String> items = new java.util.ArrayList<>();
                for (JsonNode item : node) {
                    items.add("new Item(" + item.get("weight").asInt() + ", " + item.get("value").asInt() + ")");
                }
                if (items.size() <= 2) {
                    return "List.of(" + String.join(", ", items) + ")";
                }
                return "List.of(\n                " + String.join(",\n                ", items) + "\n        )";
            }
            return "List.of()";
        });

        handlebars.registerHelper("upper", (context, options) -> {
            if (context == null) return "";
            String s = context instanceof JsonNode node ? node.asText() : context.toString();
            return s.toUpperCase().replace("\"", "");
        });

        handlebars.registerHelper("houseExpected", (context, options) -> {
            if (context instanceof JsonNode node && node.isArray()) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < node.size(); i++) {
                    String verse = node.get(i).asText();
                    if (i > 0) {
                        sb.append("\n                        + \"\\n\"\n                        + ");
                    }
                    sb.append(breakStringIntoChunks(verse, 26));
                }
                return sb.toString();
            }
            return "\"\"";
        });

        handlebars.registerHelper("foodChainExpected", (context, options) -> {
            if (context instanceof JsonNode node && node.isArray()) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < node.size(); i++) {
                    String line = node.get(i).asText();
                    if (i > 0) {
                        sb.append("\n                        + \"\\n\"\n                        + ");
                    }
                    sb.append(breakStringIntoChunks(line, 26));
                }
                return sb.toString();
            }
            return "\"\"";
        });

        handlebars.registerHelper("field", (context, options) -> {
            String fieldName = options.param(0, "").toString();
            if (context instanceof JsonNode node && node.has(fieldName)) {
                JsonNode val = node.get(fieldName);
                if (val.isNumber()) {
                    return val.asText();
                }
                if (val.isBoolean()) {
                    return val.asBoolean();
                }
                return val.asText();
            }
            if (context instanceof java.util.Map<?, ?> map && map.containsKey(fieldName)) {
                Object val = map.get(fieldName);
                return val == null ? "" : val.toString();
            }
            return "";
        });

        handlebars.registerHelper("hasElements", (context, options) -> {
            if (context instanceof JsonNode node && node.isArray()) {
                return !node.isEmpty();
            }
            if (context instanceof java.util.Collection<?> col) {
                return !col.isEmpty();
            }
            if (context instanceof java.util.Map<?, ?> map) {
                return !map.isEmpty();
            }
            return false;
        });

        handlebars.registerHelper("formatAlphameticsExpected", (context, options) -> {
            if (context instanceof JsonNode node && node.isObject()) {
                java.util.List<String> entries = new java.util.ArrayList<>();
                node.fields().forEachRemaining(entry -> {
                    entries.add("entry('" + entry.getKey().charAt(0) + "', " + entry.getValue().asInt() + ")");
                });
                return "Map.ofEntries(\n                        "
                    + String.join(",\n                        ", entries)
                    + "\n                )";
            }
            if (context instanceof java.util.Map<?, ?> map) {
                java.util.List<String> entries = new java.util.ArrayList<>();
                map.forEach((k, v) -> {
                    entries.add("entry('" + k.toString().charAt(0) + "', " + v + ")");
                });
                return "Map.ofEntries(\n                        "
                    + String.join(",\n                        ", entries)
                    + "\n                )";
            }
            return "Map.of()";
        });

        handlebars.registerHelper("alphameticsPuzzle", (context, options) -> {
            String text = "";
            if (context instanceof JsonNode node) {
                text = node.asText();
            } else if (context != null) {
                text = context.toString();
            }
            return breakStringIntoChunks(text, 24);
        });

        handlebars.registerHelper("formatLedgerEntries", (context, options) -> {
            if (context instanceof JsonNode node && node.isArray()) {
                if (node.isEmpty()) {
                    return "new Ledger.LedgerEntry[]{}";
                }
                java.util.List<String> items = new java.util.ArrayList<>();
                for (JsonNode item : node) {
                    String date = item.get("date").asText();
                    String desc = JavaTypeFormatter.escapeJavaString(item.get("description").asText());
                    int amount = item.get("amountInCents").asInt();
                    items.add("ledger.createLedgerEntry(\"" + date + "\", \"" + desc + "\", " + amount + ")");
                }
                return "new Ledger.LedgerEntry[]{\n                        "
                    + String.join(",\n                        ", items)
                    + "\n                }";
            }
            return "new Ledger.LedgerEntry[]{}";
        });

        handlebars.registerHelper("ledgerLocale", (context, options) -> {
            if (context == null) return "en-US";
            String s = context instanceof JsonNode node ? node.asText() : context.toString();
            return s.replace("_", "-");
        });

        handlebars.registerHelper("formatLedgerExpected", (context, options) -> {
            if (context instanceof JsonNode node && node.isArray()) {
                if (node.isEmpty()) {
                    return "\"\"";
                }
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < node.size(); i++) {
                    String line = node.get(i).asText();
                    if (node.get(0).asText().startsWith("Datum")) {
                        line = line.replaceFirst("^(\\d{2})-(\\d{2})-(\\d{4})", "$1/$2/$3");
                    }
                    if (i > 0) {
                        sb.append("\n                        + ");
                    }
                    sb.append("\"").append(JavaTypeFormatter.escapeJavaString(line));
                    if (i < node.size() - 1) {
                        sb.append("\\n\"");
                    } else {
                        sb.append("\"");
                    }
                }
                return sb.toString();
            }
            return "\"\"";
        });

        handlebars.registerHelper("renderStopwatchCommands", (context, options) -> {
            if (context instanceof JsonNode node && node.isArray()) {
                java.util.List<String> statements = new java.util.ArrayList<>();
                for (JsonNode cmd : node) {
                    String name = cmd.path("command").asText();
                    if ("new".equals(name)) {
                        statements.add("SplitSecondStopwatch stopwatch = new SplitSecondStopwatch();");
                    } else if (cmd.has("by")) {
                        String by = JavaTypeFormatter.escapeJavaString(cmd.get("by").asText());
                        statements.add("stopwatch.advanceTime(\"" + by + "\");");
                    } else if (cmd.has("expected")) {
                        JsonNode exp = cmd.get("expected");
                        if (exp.isObject() && exp.has("error")) {
                            String error = JavaTypeFormatter.escapeJavaString(exp.get("error").asText());
                            statements.add("assertThatExceptionOfType(IllegalStateException.class)\n"
                                + "                .isThrownBy(stopwatch::" + name + ")\n"
                                + "                .withMessage(\"" + error + "\");");
                        } else if ("previousLaps".equals(name)) {
                            if (exp.isArray() && exp.isEmpty()) {
                                statements.add("assertThat(stopwatch.previousLaps()).isEmpty();");
                            } else if (exp.isArray()) {
                                java.util.List<String> laps = new java.util.ArrayList<>();
                                for (JsonNode lap : exp) {
                                    laps.add("\"" + JavaTypeFormatter.escapeJavaString(lap.asText()) + "\"");
                                }
                                statements.add("assertThat(stopwatch.previousLaps()).containsExactly(" + String.join(", ", laps) + ");");
                            }
                        } else {
                            String expectedStr = JavaTypeFormatter.escapeJavaString(exp.asText());
                            statements.add("assertThat(stopwatch." + name + "()).isEqualTo(\"" + expectedStr + "\");");
                        }
                    } else {
                        statements.add("stopwatch." + name + "();");
                    }
                }
                return String.join("\n        ", statements);
            }
            return "";
        });

        handlebars.registerHelper("asLocalDateList", (context, options) -> {
            if (context instanceof JsonNode node && node.isArray()) {
                if (node.isEmpty()) {
                    return "List.of()";
                }
                if (node.size() == 1) {
                    return "List.of(LocalDate.parse(\"" + node.get(0).asText() + "\"))";
                }
                java.util.List<String> items = new java.util.ArrayList<>();
                for (JsonNode item : node) {
                    items.add("LocalDate.parse(\"" + item.asText() + "\")");
                }
                String singleLine = "List.of(" + String.join(", ", items) + ")";
                if (singleLine.length() <= 80) {
                    return singleLine;
                }
                return "List.of(\n                        "
                    + String.join(",\n                        ", items)
                    + "\n                )";
            }
            return "List.of()";
        });

        handlebars.registerHelper("renderBankAccountCase", (context, options) -> {
            JsonNode ops = null;
            JsonNode expectedNode = null;
            if (context instanceof exercism.testgenerator.model.CanonicalCase c) {
                ops = c.input() != null ? c.input().path("operations") : null;
                expectedNode = c.expected();
            } else if (context instanceof exercism.testgenerator.model.RenderedTestCase r) {
                ops = r.rawCase().input() != null ? r.rawCase().input().path("operations") : null;
                expectedNode = r.rawCase().expected();
            } else if (context instanceof JsonNode rawCase) {
                ops = rawCase.path("input").path("operations");
                expectedNode = rawCase.path("expected");
            }
            if (ops == null || !ops.isArray()) return "";
            boolean hasError = expectedNode != null && expectedNode.has("error");

            java.util.List<String> lines = new java.util.ArrayList<>();
            lines.add("BankAccount bankAccount = new BankAccount();");

            int lastIndex = ops.size() - 1;
            for (int i = 0; i <= lastIndex; i++) {
                JsonNode op = ops.get(i);
                String operation = op.path("operation").asText();
                boolean isLast = (i == lastIndex);

                if (hasError && isLast) {
                    String call = switch (operation) {
                        case "open" -> "bankAccount.open()";
                        case "close" -> "bankAccount.close()";
                        case "deposit" -> "bankAccount.deposit(" + op.get("amount").asInt() + ")";
                        case "withdraw" -> "bankAccount.withdraw(" + op.get("amount").asInt() + ")";
                        case "balance" -> "bankAccount.getBalance()";
                        default -> "";
                    };
                    lines.add("assertThatExceptionOfType(BankAccountActionInvalidException.class)");
                    lines.add("        .isThrownBy(() -> " + call + ");");
                } else {
                    switch (operation) {
                        case "open" -> lines.add("bankAccount.open();");
                        case "close" -> lines.add("bankAccount.close();");
                        case "deposit" -> lines.add("bankAccount.deposit(" + op.get("amount").asInt() + ");");
                        case "withdraw" -> lines.add("bankAccount.withdraw(" + op.get("amount").asInt() + ");");
                        case "balance" -> {
                            if (!hasError && isLast) {
                                int expected = expectedNode.asInt();
                                lines.add("assertThat(bankAccount.getBalance()).isEqualTo(" + expected + ");");
                            }
                        }
                        case "concurrent" -> {
                            int num = op.path("number").asInt(1000);
                            lines.add("Random random = new Random();");
                            lines.add("Thread[] threads = new Thread[" + num + "];");
                            lines.add("for (int idx = 0; idx < " + num + "; idx++) {");
                            lines.add("    threads[idx] = new Thread(() -> {");
                            lines.add("        try {");
                            lines.add("            bankAccount.deposit(1);");
                            lines.add("            Thread.sleep(random.nextInt(10));");
                            lines.add("            bankAccount.withdraw(1);");
                            lines.add("        } catch (BankAccountActionInvalidException e) {");
                            lines.add("            fail(\"Exception should not be thrown: \" + e.getMessage());");
                            lines.add("        } catch (InterruptedException ignored) {");
                            lines.add("        }");
                            lines.add("    });");
                            lines.add("    threads[idx].start();");
                            lines.add("}");
                            lines.add("for (Thread thread : threads) {");
                            lines.add("    thread.join();");
                            lines.add("}");
                        }
                        default -> {}
                    }
                }
            }
            return String.join("\n        ", lines);
        });

        handlebars.registerHelper("renderBowlingCase", (context, options) -> {
            JsonNode input = null;
            JsonNode expected = null;
            if (context instanceof exercism.testgenerator.model.CanonicalCase c) {
                input = c.input();
                expected = c.expected();
            } else if (context instanceof exercism.testgenerator.model.RenderedTestCase r) {
                input = r.rawCase().input();
                expected = r.rawCase().expected();
            } else if (context instanceof JsonNode rawCase) {
                input = rawCase.path("input");
                expected = rawCase.path("expected");
            }
            if (input == null || expected == null) return "";
            boolean hasError = expected.has("error");

            JsonNode rollsNode = input.has("rolls") ? input.get("rolls") : input.get("previousRolls");
            java.util.List<String> rollInts = new java.util.ArrayList<>();
            if (rollsNode != null && rollsNode.isArray()) {
                for (JsonNode r : rollsNode) {
                    rollInts.add(String.valueOf(r.asInt()));
                }
            }

            java.util.List<String> lines = new java.util.ArrayList<>();
            lines.add("BowlingGame game = new BowlingGame();");
            String rollsArray;
            if (rollInts.isEmpty()) {
                rollsArray = "new int[]{}";
            } else if (rollInts.size() <= 8) {
                rollsArray = "new int[]{" + String.join(", ", rollInts) + "}";
            } else {
                java.util.List<String> rollChunks = new java.util.ArrayList<>();
                for (int i = 0; i < rollInts.size(); i += 10) {
                    int end = Math.min(i + 10, rollInts.size());
                    rollChunks.add(String.join(", ", rollInts.subList(i, end)));
                }
                rollsArray = "new int[]{\n            "
                    + String.join(",\n            ", rollChunks)
                    + "\n        }";
            }

            lines.add("int[] rolls = " + rollsArray + ";");
            lines.add("for (int pins : rolls) {");
            lines.add("    game.roll(pins);");
            lines.add("}");

            if (input.has("roll")) {
                int roll = input.get("roll").asInt();
                String error = JavaTypeFormatter.escapeJavaString(expected.get("error").asText());
                lines.add("assertThatExceptionOfType(IllegalStateException.class)");
                lines.add("        .isThrownBy(() -> game.roll(" + roll + "))");
                lines.add("        .withMessage(\"" + error + "\");");
            } else if (hasError) {
                String error = JavaTypeFormatter.escapeJavaString(expected.get("error").asText());
                lines.add("assertThatExceptionOfType(IllegalStateException.class)");
                lines.add("        .isThrownBy(game::score)");
                lines.add("        .withMessage(\"" + error + "\");");
            } else {
                int score = expected.asInt();
                lines.add("assertThat(game.score()).isEqualTo(" + score + ");");
            }
            return String.join("\n        ", lines);
        });

        handlebars.registerHelper("asCamiciaCards", (context, options) -> {
            if (context instanceof JsonNode node && node.isArray()) {
                if (node.isEmpty()) return "List.of()";
                java.util.List<String> quoted = new java.util.ArrayList<>();
                for (JsonNode item : node) {
                    quoted.add("\"" + JavaTypeFormatter.escapeJavaString(item.asText()) + "\"");
                }
                if (quoted.size() <= 8) {
                    return "List.of(" + String.join(", ", quoted) + ")";
                }
                java.util.List<String> lines = new java.util.ArrayList<>();
                for (int i = 0; i < quoted.size(); i += 10) {
                    int end = Math.min(i + 10, quoted.size());
                    lines.add(String.join(", ", quoted.subList(i, end)));
                }
                return "List.of(\n                        "
                    + String.join(",\n                        ", lines)
                    + "\n                )";
            }
            return "List.of()";
        });

        handlebars.registerHelper("asFlowerFieldBoard", (context, options) -> {
            if (context instanceof JsonNode node && node.isArray()) {
                if (node.isEmpty()) return "List.of()";
                if (node.size() == 1) {
                    return "List.of(\"" + JavaTypeFormatter.escapeJavaString(node.get(0).asText()) + "\")";
                }
                java.util.List<String> lines = new java.util.ArrayList<>();
                for (JsonNode r : node) {
                    lines.add("\"" + JavaTypeFormatter.escapeJavaString(r.asText()) + "\"");
                }
                return "List.of(\n                        "
                    + String.join(",\n                        ", lines)
                    + "\n                )";
            }
            return "List.of()";
        });

        handlebars.registerHelper("renderSchoolCase", (context, options) -> {
            String prop = "";
            JsonNode students = null;
            JsonNode expected = null;
            JsonNode desiredGradeNode = null;
            if (context instanceof exercism.testgenerator.model.CanonicalCase c) {
                prop = c.property();
                students = c.input() != null ? c.input().path("students") : null;
                expected = c.expected();
                desiredGradeNode = c.input() != null ? c.input().path("desiredGrade") : null;
            } else if (context instanceof exercism.testgenerator.model.RenderedTestCase r) {
                prop = r.property();
                students = r.rawCase().input() != null ? r.rawCase().input().path("students") : null;
                expected = r.rawCase().expected();
                desiredGradeNode = r.rawCase().input() != null ? r.rawCase().input().path("desiredGrade") : null;
            } else if (context instanceof JsonNode rawCase) {
                prop = rawCase.path("property").asText();
                students = rawCase.path("input").path("students");
                expected = rawCase.path("expected");
                desiredGradeNode = rawCase.path("input").path("desiredGrade");
            }
            if (students == null) return "";

            java.util.List<String> lines = new java.util.ArrayList<>();
            lines.add("School school = new School();");

            if ("add".equals(prop)) {
                if (students.isArray() && expected.isArray()) {
                    for (int i = 0; i < students.size(); i++) {
                        JsonNode s = students.get(i);
                        String name = s.get(0).asText();
                        int grade = s.get(1).asInt();
                        boolean exp = expected.get(i).asBoolean();
                        lines.add("assertThat(school.add(\"" + name + "\", " + grade + ")).is"
                            + (exp ? "True" : "False") + "();");
                    }
                }
            } else if ("roster".equals(prop)) {
                if (students.isArray()) {
                    for (JsonNode s : students) {
                        String name = s.get(0).asText();
                        int grade = s.get(1).asInt();
                        lines.add("school.add(\"" + name + "\", " + grade + ");");
                    }
                }
                if (expected.isArray() && expected.isEmpty()) {
                    lines.add("assertThat(school.roster()).isEmpty();");
                } else if (expected.isArray()) {
                    java.util.List<String> names = new java.util.ArrayList<>();
                    for (JsonNode n : expected) {
                        names.add("\"" + n.asText() + "\"");
                    }
                    lines.add("assertThat(school.roster()).containsExactly(" + String.join(", ", names) + ");");
                }
            } else if ("grade".equals(prop)) {
                if (students.isArray()) {
                    for (JsonNode s : students) {
                        String name = s.get(0).asText();
                        int grade = s.get(1).asInt();
                        lines.add("school.add(\"" + name + "\", " + grade + ");");
                    }
                }
                int desiredGrade = desiredGradeNode != null ? desiredGradeNode.asInt() : 0;
                if (expected.isArray() && expected.isEmpty()) {
                    lines.add("assertThat(school.grade(" + desiredGrade + ")).isEmpty();");
                } else if (expected.isArray()) {
                    java.util.List<String> names = new java.util.ArrayList<>();
                    for (JsonNode n : expected) {
                        names.add("\"" + n.asText() + "\"");
                    }
                    lines.add("assertThat(school.grade(" + desiredGrade + "))\n"
                        + "                .containsExactly(" + String.join(", ", names) + ");");
                }
            }
            return String.join("\n        ", lines);
        });

        handlebars.registerHelper("asHexIntList", (context, options) -> {
            if (context instanceof JsonNode node && node.isArray()) {
                if (node.isEmpty()) return "List.of()";
                java.util.List<String> hexItems = new java.util.ArrayList<>();
                for (JsonNode item : node) {
                    hexItems.add(item.asText());
                }
                if (hexItems.size() <= 8) {
                    return "List.of(" + String.join(", ", hexItems) + ")";
                }
                java.util.List<String> lines = new java.util.ArrayList<>();
                for (int i = 0; i < hexItems.size(); i += 8) {
                    int end = Math.min(i + 8, hexItems.size());
                    lines.add(String.join(", ", hexItems.subList(i, end)));
                }
                return "List.of(\n                        "
                    + String.join(",\n                        ", lines)
                    + "\n                )";
            }
            return "List.of()";
        });

        handlebars.registerHelper("renderDoublyLinkedListOperations", (context, options) -> {
            if (context instanceof JsonNode node && node.isArray()) {
                java.util.List<String> statements = new java.util.ArrayList<>();
                statements.add("DoublyLinkedList<Integer> list = new DoublyLinkedList<>();");
                for (JsonNode op : node) {
                    String operation = op.path("operation").asText();
                    if ("push".equals(operation)) {
                        statements.add("list.push(" + op.get("value").asInt() + ");");
                    } else if ("unshift".equals(operation)) {
                        statements.add("list.unshift(" + op.get("value").asInt() + ");");
                    } else if ("pop".equals(operation)) {
                        if (op.has("expected")) {
                            statements.add("assertThat(list.pop()).isEqualTo(" + op.get("expected").asInt() + ");");
                        } else {
                            statements.add("list.pop();");
                        }
                    } else if ("shift".equals(operation)) {
                        if (op.has("expected")) {
                            statements.add("assertThat(list.shift()).isEqualTo(" + op.get("expected").asInt() + ");");
                        } else {
                            statements.add("list.shift();");
                        }
                    }
                }
                return String.join("\n        ", statements);
            }
            return "";
        });

        handlebars.registerHelper("formatFrequencyTexts", (context, options) -> {
            if (context instanceof JsonNode node && node.isArray()) {
                if (node.isEmpty()) return "new String[]{}";
                if (node.size() > 10) {
                    boolean allEqual = true;
                    String first = node.get(0).asText();
                    for (JsonNode item : node) {
                        if (!first.equals(item.asText())) {
                            allEqual = false;
                            break;
                        }
                    }
                    if (allEqual) {
                        return "createIdenticalTexts(" + node.size() + ", \""
                            + JavaTypeFormatter.escapeJavaString(first) + "\")";
                    }
                }
                java.util.List<String> stringExprs = new java.util.ArrayList<>();
                for (JsonNode item : node) {
                    String text = item.asText();
                    if (text.length() > 60) {
                        stringExprs.add(breakStringIntoChunks(text, 16));
                    } else {
                        stringExprs.add("\"" + JavaTypeFormatter.escapeJavaString(text) + "\"");
                    }
                }
                return "new String[]{\n            "
                    + String.join(",\n            ", stringExprs)
                    + "\n        }";
            }
            return "new String[]{}";
        });

        handlebars.registerHelper("formatFrequencyExpected", (context, options) -> {
            if (context instanceof JsonNode node && node.isObject()) {
                if (node.isEmpty()) return "Map.of()";
                java.util.List<String> entries = new java.util.ArrayList<>();
                var it = node.fields();
                while (it.hasNext()) {
                    var entry = it.next();
                    String key = entry.getKey();
                    int count = entry.getValue().asInt();
                    String charLiteral = "'".equals(key) ? "'\\''" : ("\\".equals(key) ? "'\\\\'" : "'" + key + "'");
                    entries.add("Map.entry(" + charLiteral + ", " + count + ")");
                }
                if (entries.size() <= 8) {
                    java.util.List<String> pairs = new java.util.ArrayList<>();
                    var it2 = node.fields();
                    while (it2.hasNext()) {
                        var entry = it2.next();
                        String key = entry.getKey();
                        int count = entry.getValue().asInt();
                        String charLiteral = "'".equals(key) ? "'\\''" : ("\\".equals(key) ? "'\\\\'" : "'" + key + "'");
                        pairs.add(charLiteral + ", " + count);
                    }
                    return "Map.of(" + String.join(", ", pairs) + ")";
                }
                return "Map.ofEntries(\n                        "
                    + String.join(",\n                        ", entries)
                    + "\n                )";
            }
            return "Map.of()";
        });

        handlebars.registerHelper("asJigsawInfo", (context, options) -> {
            if (!(context instanceof JsonNode node)) return "null";
            java.util.List<String> calls = new java.util.ArrayList<>();
            calls.add("new JigsawInfo.Builder()");
            if (node.has("pieces")) calls.add(".pieces(" + node.get("pieces").asInt() + ")");
            if (node.has("border")) calls.add(".border(" + node.get("border").asInt() + ")");
            if (node.has("inside")) calls.add(".inside(" + node.get("inside").asInt() + ")");
            if (node.has("rows")) calls.add(".rows(" + node.get("rows").asInt() + ")");
            if (node.has("columns")) calls.add(".columns(" + node.get("columns").asInt() + ")");
            if (node.has("aspectRatio")) calls.add(".aspectRatio(" + node.get("aspectRatio").asDouble() + ")");
            if (node.has("format")) {
                calls.add(".format(\"" + JavaTypeFormatter.escapeJavaString(node.get("format").asText()) + "\")");
            }
            calls.add(".build()");
            return String.join("\n                ", calls);
        });

        handlebars.registerHelper("renderReactCase", (context, options) -> {
            CanonicalCase cCase = toCanonicalCase(context);
            if (cCase == null) return "";
            JsonNode input = cCase.input();
            JsonNode cells = input.path("cells");
            JsonNode operations = input.path("operations");

            java.util.List<String> lines = new java.util.ArrayList<>();

            // 1. Emit cells
            if (cells.isArray()) {
                for (JsonNode cell : cells) {
                    String name = JavaNamingHelper.toMethodName(cell.path("name").asText());
                    String type = cell.path("type").asText();
                    if ("input".equals(type)) {
                        int initialVal = cell.path("initial_value").asInt();
                        lines.add("var " + name + " = React.inputCell(" + initialVal + ");");
                    } else if ("compute".equals(type)) {
                        String fn = translateComputeFunction(cell.path("compute_function").asText());
                        JsonNode cellInputs = cell.path("inputs");
                        java.util.List<String> inNames = new java.util.ArrayList<>();
                        if (cellInputs.isArray()) {
                            for (JsonNode in : cellInputs) {
                                inNames.add(JavaNamingHelper.toMethodName(in.asText()));
                            }
                        }
                        String inList = "List.of(" + String.join(", ", inNames) + ")";
                        lines.add("var " + name + " = React.computeCell(" + fn + ", " + inList + ");");
                    }
                }
            }

            // 2. Analyze callbacks across operations
            java.util.Set<String> removedCallbacks = new java.util.HashSet<>();
            java.util.LinkedHashSet<String> allCallbacks = new java.util.LinkedHashSet<>();
            if (operations.isArray()) {
                for (JsonNode op : operations) {
                    String opType = op.path("type").asText();
                    if ("remove_callback".equals(opType)) {
                        removedCallbacks.add(op.path("name").asText());
                    }
                    if ("add_callback".equals(opType)) {
                        allCallbacks.add(op.path("name").asText());
                    }
                }
            }

            int totalCallbacks = allCallbacks.size();
            java.util.Map<String, String> cbValuesVar = new java.util.HashMap<>();
            int cbIdx = 1;
            for (String cb : allCallbacks) {
                if (totalCallbacks == 1) {
                    cbValuesVar.put(cb, "values");
                } else {
                    String num = cb.replaceAll("\\D+", "");
                    cbValuesVar.put(cb, num.isEmpty() ? ("values" + cbIdx) : ("values" + num));
                }
                cbIdx++;
            }

            // 3. Emit operations
            if (operations.isArray()) {
                for (int i = 0; i < operations.size(); i++) {
                    JsonNode op = operations.get(i);
                    String opType = op.path("type").asText();
                    String cellName = JavaNamingHelper.toMethodName(op.path("cell").asText());

                    if ("expect_cell_value".equals(opType)) {
                        int expVal = op.path("value").asInt();
                        lines.add("");
                        lines.add("assertThat(" + cellName + ".getValue()).isEqualTo(" + expVal + ");");
                    } else if ("add_callback".equals(opType)) {
                        String cbName = op.path("name").asText();
                        String vVar = cbValuesVar.get(cbName);
                        lines.add("");
                        lines.add("var " + vVar + " = new ArrayList<Integer>();");
                        if (removedCallbacks.contains(cbName)) {
                            lines.add("Consumer<Integer> " + cbName + " = " + vVar + "::add;");
                            lines.add(cellName + ".addCallback(" + cbName + ");");
                        } else {
                            lines.add(cellName + ".addCallback(" + vVar + "::add);");
                        }
                    } else if ("remove_callback".equals(opType)) {
                        String cbName = op.path("name").asText();
                        lines.add("");
                        lines.add(cellName + ".removeCallback(" + cbName + ");");
                    } else if ("set_value".equals(opType)) {
                        int setVal = op.path("value").asInt();
                        lines.add("");
                        lines.add(cellName + ".setValue(" + setVal + ");");

                        boolean hasExpectCallbacks = op.has("expect_callbacks");
                        boolean hasNotToBeCalled = op.has("expect_callbacks_not_to_be_called");

                        if (hasExpectCallbacks) {
                            JsonNode expCbs = op.get("expect_callbacks");
                            java.util.List<String> assertedVars = new java.util.ArrayList<>();
                            expCbs.fields().forEachRemaining(entry -> {
                                String cb = entry.getKey();
                                String vVar = cbValuesVar.get(cb);
                                int expectedVal = entry.getValue().asInt();
                                lines.add("assertThat(" + vVar + ").containsExactly(" + expectedVal + ");");
                                assertedVars.add(vVar);
                            });

                            boolean hasLaterOps = (i + 1 < operations.size());
                            if (hasLaterOps) {
                                for (String aVar : assertedVars) {
                                    lines.add(aVar + ".clear();");
                                }
                            }
                        }

                        if (hasNotToBeCalled) {
                            JsonNode notCbs = op.get("expect_callbacks_not_to_be_called");
                            if (notCbs.isArray()) {
                                for (JsonNode notCb : notCbs) {
                                    String cb = notCb.asText();
                                    String vVar = cbValuesVar.get(cb);
                                    lines.add("assertThat(" + vVar + ").isEmpty();");
                                }
                            }
                        }
                    }
                }
            }

            if (!lines.isEmpty() && lines.get(0).isEmpty()) {
                lines.remove(0);
            }
            return String.join("\n        ", lines);
        });

        handlebars.registerHelper("renderDotDslCase", (context, options) -> {
            CanonicalCase cCase = toCanonicalCase(context);
            if (cCase == null) return "";
            JsonNode textNode = cCase.input().path("text");
            if (!textNode.isArray()) return "";

            java.util.LinkedHashMap<String, String> graphAttrs = new java.util.LinkedHashMap<>();
            java.util.List<DotNode> nodes = new java.util.ArrayList<>();
            java.util.List<DotEdge> edges = new java.util.ArrayList<>();

            for (JsonNode lineNode : textNode) {
                String line = lineNode.asText().trim();
                if (line.isEmpty() || line.equals("graph {") || line.equals("}")) continue;
                if (line.endsWith(";")) line = line.substring(0, line.length() - 1).trim();

                if (line.startsWith("[") && line.endsWith("]")) {
                    String inside = line.substring(1, line.length() - 1).trim();
                    parseDotAttrs(inside, graphAttrs);
                    continue;
                }

                if (line.contains("--")) {
                    String attrPart = "";
                    String mainPart = line;
                    int bracketIdx = line.indexOf('[');
                    if (bracketIdx != -1 && line.endsWith("]")) {
                        attrPart = line.substring(bracketIdx + 1, line.length() - 1).trim();
                        mainPart = line.substring(0, bracketIdx).trim();
                    }
                    java.util.LinkedHashMap<String, String> edgeAttrs = new java.util.LinkedHashMap<>();
                    if (!attrPart.isEmpty()) {
                        parseDotAttrs(attrPart, edgeAttrs);
                    }
                    String[] parts = mainPart.split("\\s*--\\s*");
                    if (parts.length > 2) {
                        for (String part : parts) {
                            nodes.add(new DotNode(part.trim(), new java.util.LinkedHashMap<>()));
                        }
                    }
                    for (int i = 0; i < parts.length - 1; i++) {
                        edges.add(new DotEdge(parts[i].trim(), parts[i + 1].trim(), new java.util.LinkedHashMap<>(edgeAttrs)));
                    }
                    continue;
                }

                String attrPart = "";
                String nodeName = line;
                int bracketIdx = line.indexOf('[');
                if (bracketIdx != -1 && line.endsWith("]")) {
                    attrPart = line.substring(bracketIdx + 1, line.length() - 1).trim();
                    nodeName = line.substring(0, bracketIdx).trim();
                }
                java.util.LinkedHashMap<String, String> nodeAttrs = new java.util.LinkedHashMap<>();
                if (!attrPart.isEmpty()) {
                    parseDotAttrs(attrPart, nodeAttrs);
                }
                nodes.add(new DotNode(nodeName, nodeAttrs));
            }

            java.util.List<String> lines = new java.util.ArrayList<>();
            StringBuilder graphCall = new StringBuilder("Graph graph = new Graph(");
            if (!graphAttrs.isEmpty()) {
                graphCall.append(formatDotMapOf(graphAttrs));
            }
            graphCall.append(")");
            java.util.List<String> chainedCalls = new java.util.ArrayList<>();
            for (DotNode n : nodes) {
                if (n.attrs.isEmpty()) {
                    chainedCalls.add(".node(\"" + n.name + "\")");
                } else {
                    chainedCalls.add(".node(\"" + n.name + "\", " + formatDotMapOf(n.attrs) + ")");
                }
            }
            for (DotEdge e : edges) {
                if (e.attrs.isEmpty()) {
                    chainedCalls.add(".edge(\"" + e.start + "\", \"" + e.end + "\")");
                } else {
                    chainedCalls.add(".edge(\"" + e.start + "\", \"" + e.end + "\", " + formatDotMapOf(e.attrs) + ")");
                }
            }
            if (chainedCalls.isEmpty()) {
                lines.add(graphCall.toString() + ";");
            } else if (chainedCalls.size() == 1 && graphAttrs.isEmpty()) {
                lines.add(graphCall.toString() + chainedCalls.get(0) + ";");
            } else {
                lines.add(graphCall.toString());
                for (int i = 0; i < chainedCalls.size(); i++) {
                    String semi = (i == chainedCalls.size() - 1) ? ";" : "";
                    lines.add("        " + chainedCalls.get(i) + semi);
                }
            }

            lines.add("");

            if (nodes.isEmpty()) {
                lines.add("assertThat(graph.getNodes()).isEmpty();");
            } else if (nodes.size() == 1) {
                DotNode n = nodes.get(0);
                if (n.attrs.isEmpty()) {
                    lines.add("assertThat(graph.getNodes()).containsExactly(new Node(\"" + n.name + "\", Collections.emptyMap()));");
                } else {
                    lines.add("assertThat(graph.getNodes())");
                    lines.add("        .containsExactly(new Node(\"" + n.name + "\", " + formatDotMapOf(n.attrs) + "));");
                }
            } else {
                java.util.List<String> nodeExprs = new java.util.ArrayList<>();
                for (DotNode n : nodes) {
                    if (n.attrs.isEmpty()) {
                        nodeExprs.add("new Node(\"" + n.name + "\")");
                    } else {
                        nodeExprs.add("new Node(\"" + n.name + "\", " + formatDotMapOf(n.attrs) + ")");
                    }
                }
                lines.add("assertThat(graph.getNodes())");
                lines.add("        .containsExactlyInAnyOrder(");
                for (int i = 0; i < nodeExprs.size(); i++) {
                    String comma = (i == nodeExprs.size() - 1) ? ");" : ",";
                    lines.add("                " + nodeExprs.get(i) + comma);
                }
            }

            if (edges.isEmpty()) {
                lines.add("assertThat(graph.getEdges()).isEmpty();");
            } else if (edges.size() == 1) {
                DotEdge e = edges.get(0);
                if (e.attrs.isEmpty()) {
                    lines.add("assertThat(graph.getEdges())");
                    lines.add("        .containsExactly(new Edge(\"" + e.start + "\", \"" + e.end + "\"));");
                } else {
                    lines.add("assertThat(graph.getEdges())");
                    lines.add("        .containsExactly(new Edge(\"" + e.start + "\", \"" + e.end + "\", " + formatDotMapOf(e.attrs) + "));");
                }
            } else {
                java.util.List<String> edgeExprs = new java.util.ArrayList<>();
                for (DotEdge e : edges) {
                    if (e.attrs.isEmpty()) {
                        edgeExprs.add("new Edge(\"" + e.start + "\", \"" + e.end + "\")");
                    } else {
                        edgeExprs.add("new Edge(\"" + e.start + "\", \"" + e.end + "\", " + formatDotMapOf(e.attrs) + ")");
                    }
                }
                lines.add("assertThat(graph.getEdges())");
                lines.add("        .containsExactlyInAnyOrder(");
                for (int i = 0; i < edgeExprs.size(); i++) {
                    String comma = (i == edgeExprs.size() - 1) ? ");" : ",";
                    lines.add("                " + edgeExprs.get(i) + comma);
                }
            }

            if (graphAttrs.isEmpty()) {
                lines.add("assertThat(graph.getAttributes()).isEmpty();");
            } else if (graphAttrs.size() == 1) {
                var entry = graphAttrs.entrySet().iterator().next();
                lines.add("assertThat(graph.getAttributes()).containsEntry(\"" + entry.getKey() + "\", \"" + entry.getValue() + "\");");
            } else {
                lines.add("assertThat(graph.getAttributes())");
                lines.add("        .containsExactlyInAnyOrderEntriesOf(");
                lines.add("                " + formatDotMapOf(graphAttrs) + ");");
            }

            return String.join("\n        ", lines);
        });

        handlebars.registerHelper("renderRestApiCase", (context, options) -> {
            CanonicalCase cCase = toCanonicalCase(context);
            if (cCase == null) return "";
            JsonNode input = cCase.input();
            JsonNode expected = cCase.expected();
            String prop = cCase.property();
            String url = input.path("url").asText();
            JsonNode payload = input.path("payload");
            JsonNode dbUsers = input.path("database").path("users");

            java.util.List<String> lines = new java.util.ArrayList<>();

            String expectedCode = jsonNodeToOrgJson(expected, 16);
            if (expectedCode.contains("\n")) {
                lines.add("String expected = " + expectedCode);
                lines.add("        .toString();");
            } else {
                lines.add("String expected =");
                lines.add("        " + expectedCode + ".toString();");
            }

            lines.add("String url = \"" + JavaTypeFormatter.escapeJavaString(url) + "\";");

            boolean hasPayload = payload.isObject() && !payload.isEmpty();
            if (hasPayload) {
                String payloadCode = jsonNodeToOrgJson(payload, 16);
                lines.add("JSONObject payload = " + payloadCode + ";");
            }

            java.util.List<String> userVars = new java.util.ArrayList<>();
            if (dbUsers.isArray() && !dbUsers.isEmpty()) {
                for (JsonNode u : dbUsers) {
                    String name = u.path("name").asText();
                    String varName = JavaNamingHelper.toMethodName(name);
                    StringBuilder b = new StringBuilder();
                    b.append("User ").append(varName).append(" = User.builder().setName(\"").append(name).append("\")");
                    JsonNode owes = u.path("owes");
                    if (owes.isObject()) {
                        owes.fields().forEachRemaining(entry -> {
                            b.append(".owes(\"").append(entry.getKey()).append("\", ").append(entry.getValue().asDouble()).append(")");
                        });
                    }
                    JsonNode owedBy = u.path("owed_by");
                    if (!owedBy.isObject()) owedBy = u.path("owedBy");
                    if (owedBy.isObject()) {
                        owedBy.fields().forEachRemaining(entry -> {
                            b.append(".owedBy(\"").append(entry.getKey()).append("\", ").append(entry.getValue().asDouble()).append(")");
                        });
                    }
                    b.append(".build();");
                    lines.add(b.toString());
                    userVars.add(varName);
                }
            }

            String restApiInst = userVars.isEmpty() ? "new RestApi()" : "new RestApi(" + String.join(", ", userVars) + ")";
            String call = restApiInst + "." + prop + "(url" + (hasPayload ? ", payload" : "") + ")";
            lines.add("");
            lines.add("assertThat(" + call + ").isEqualTo(expected);");

            return String.join("\n        ", lines);
        });

        handlebars.registerHelper("renderRobotCase", (context, options) -> {
            exercism.testgenerator.model.CanonicalCase c = toCanonicalCase(context);
            if (c == null) return "";
            JsonNode input = c.input();
            JsonNode expected = c.expected();
            int startX = input.path("position").path("x").asInt();
            int startY = input.path("position").path("y").asInt();
            String startDir = input.path("direction").asText().toUpperCase();

            java.util.List<String> lines = new java.util.ArrayList<>();
            lines.add("Robot robot = new Robot(new GridPosition(" + startX + ", " + startY + "), Orientation." + startDir + ");");

            if ("move".equals(c.property())) {
                String inst = input.path("instructions").asText();
                if ("R".equals(inst)) {
                    lines.add("robot.turnRight();");
                } else if ("L".equals(inst)) {
                    lines.add("robot.turnLeft();");
                } else if ("A".equals(inst)) {
                    lines.add("robot.advance();");
                } else {
                    lines.add("robot.simulate(\"" + JavaTypeFormatter.escapeJavaString(inst) + "\");");
                }
            }

            int expX = expected.path("position").path("x").asInt();
            int expY = expected.path("position").path("y").asInt();
            String expDir = expected.path("direction").asText().toUpperCase();

            lines.add("assertThat(robot.getGridPosition()).isEqualTo(new GridPosition(" + expX + ", " + expY + "));");
            lines.add("assertThat(robot.getOrientation()).isEqualTo(Orientation." + expDir + ");");
            return String.join("\n        ", lines);
        });

        handlebars.registerHelper("renderTournamentCase", (context, options) -> {
            exercism.testgenerator.model.CanonicalCase c = toCanonicalCase(context);
            if (c == null) return "";
            JsonNode inputRows = c.input().path("rows");
            JsonNode expectedRows = c.expected();

            java.util.List<String> lines = new java.util.ArrayList<>();
            lines.add("Tournament tournament = new Tournament();");

            if (inputRows.isArray() && !inputRows.isEmpty()) {
                if (inputRows.size() == 1) {
                    lines.add("tournament.applyResults(\"" + JavaTypeFormatter.escapeJavaString(inputRows.get(0).asText()) + "\");");
                } else {
                    java.util.List<String> parts = new java.util.ArrayList<>();
                    for (JsonNode row : inputRows) {
                        parts.add("\"" + JavaTypeFormatter.escapeJavaString(row.asText()) + "\\n\"");
                    }
                    lines.add("tournament.applyResults(\n                "
                        + String.join(" +\n                ", parts) + "\n        );");
                }
            }

            if (expectedRows.isArray()) {
                java.util.List<String> parts = new java.util.ArrayList<>();
                for (JsonNode row : expectedRows) {
                    parts.add("\"" + JavaTypeFormatter.escapeJavaString(row.asText()) + "\\n\"");
                }
                if (parts.size() == 1) {
                    lines.add("assertThat(tournament.printTable()).isEqualTo(" + parts.get(0) + ");");
                } else {
                    lines.add("assertThat(tournament.printTable())\n"
                        + "                .isEqualTo(\n                        "
                        + String.join(" +\n                        ", parts) + ");");
                }
            }
            return String.join("\n        ", lines);
        });

        handlebars.registerHelper("renderTransposeCase", (context, options) -> {
            exercism.testgenerator.model.CanonicalCase c = toCanonicalCase(context);
            if (c == null) return "";
            JsonNode inputLines = c.input().path("lines");
            JsonNode expectedLines = c.expected();

            java.util.List<String> lines = new java.util.ArrayList<>();
            lines.add("Transpose transpose = new Transpose();");

            String inputExpr;
            if (!inputLines.isArray() || inputLines.isEmpty()) {
                inputExpr = "\"\"";
            } else if (inputLines.size() == 1) {
                inputExpr = "\"" + JavaTypeFormatter.escapeJavaString(inputLines.get(0).asText()) + "\"";
            } else {
                java.util.List<String> parts = new java.util.ArrayList<>();
                for (int i = 0; i < inputLines.size(); i++) {
                    String line = JavaTypeFormatter.escapeJavaString(inputLines.get(i).asText());
                    parts.add("\"" + line + (i < inputLines.size() - 1 ? "\\n\"" : "\""));
                }
                inputExpr = "\n                " + String.join(" +\n                ", parts);
            }

            String expectedExpr;
            if (!expectedLines.isArray() || expectedLines.isEmpty()) {
                expectedExpr = "\"\"";
            } else if (expectedLines.size() == 1) {
                expectedExpr = "\"" + JavaTypeFormatter.escapeJavaString(expectedLines.get(0).asText()) + "\"";
            } else {
                java.util.List<String> parts = new java.util.ArrayList<>();
                for (int i = 0; i < expectedLines.size(); i++) {
                    String line = JavaTypeFormatter.escapeJavaString(expectedLines.get(i).asText());
                    parts.add("\"" + line + (i < expectedLines.size() - 1 ? "\\n\"" : "\""));
                }
                expectedExpr = "\n                " + String.join(" +\n                ", parts);
            }

            lines.add("assertThat(transpose.transpose(" + inputExpr + "))\n"
                + "                .isEqualTo(" + expectedExpr + ");");
            return String.join("\n        ", lines);
        });

        handlebars.registerHelper("renderBinarySearchTreeCase", (context, options) -> {
            exercism.testgenerator.model.CanonicalCase c = toCanonicalCase(context);
            if (c == null) return "";
            String prop = c.property();
            JsonNode treeData = c.input().path("treeData");
            JsonNode expected = c.expected();

            java.util.List<String> lines = new java.util.ArrayList<>();
            lines.add("BinarySearchTree<String> binarySearchTree = new BinarySearchTree<>();");

            if ("sortedData".equals(prop)) {
                if (treeData.isArray() && !treeData.isEmpty()) {
                    java.util.List<String> items = new java.util.ArrayList<>();
                    for (JsonNode item : treeData) {
                        items.add("\"" + item.asText() + "\"");
                    }
                    lines.add("List<String> treeData = List.of(" + String.join(", ", items) + ");");
                    lines.add("treeData.forEach(binarySearchTree::insert);");
                }
                if (expected.isArray()) {
                    java.util.List<String> items = new java.util.ArrayList<>();
                    for (JsonNode item : expected) {
                        items.add("\"" + item.asText() + "\"");
                    }
                    lines.add("assertThat(binarySearchTree.getAsSortedList()).isEqualTo(List.of(" + String.join(", ", items) + "));");
                }
            } else if ("data".equals(prop)) {
                if (treeData.isArray() && !treeData.isEmpty()) {
                    for (JsonNode item : treeData) {
                        lines.add("binarySearchTree.insert(\"" + item.asText() + "\");");
                    }
                }
                if (treeData.size() == 1) {
                    lines.add("BinarySearchTree.Node<String> root = binarySearchTree.getRoot();");
                    lines.add("assertThat(root).isNotNull();");
                    lines.add("assertThat(root.getData()).isEqualTo(\"" + treeData.get(0).asText() + "\");");
                } else if (treeData.size() == 2) {
                    lines.add("BinarySearchTree.Node<String> root = binarySearchTree.getRoot();");
                    lines.add("assertThat(root).isNotNull();");
                    lines.add("assertThat(root.getData()).isEqualTo(\"" + treeData.get(0).asText() + "\");");
                    if (treeData.get(1).asText().compareTo(treeData.get(0).asText()) <= 0) {
                        lines.add("BinarySearchTree.Node<String> left = root.getLeft();");
                        lines.add("assertThat(left).isNotNull();");
                        lines.add("assertThat(left.getData()).isEqualTo(\"" + treeData.get(1).asText() + "\");");
                    } else {
                        lines.add("BinarySearchTree.Node<String> right = root.getRight();");
                        lines.add("assertThat(right).isNotNull();");
                        lines.add("assertThat(right.getData()).isEqualTo(\"" + treeData.get(1).asText() + "\");");
                    }
                } else {
                    java.util.List<String> items = new java.util.ArrayList<>();
                    for (JsonNode item : treeData) {
                        items.add("\"" + item.asText() + "\"");
                    }
                    lines.add("assertThat(binarySearchTree.getAsLevelOrderList()).isEqualTo(List.of(" + String.join(", ", items) + "));");
                }
            }
            return String.join("\n        ", lines);
        });

        handlebars.registerHelper("renderClockCase", (context, options) -> {
            exercism.testgenerator.model.CanonicalCase c = toCanonicalCase(context);
            if (c == null) return "";
            String prop = c.property();
            JsonNode input = c.input();
            JsonNode expected = c.expected();

            java.util.List<String> lines = new java.util.ArrayList<>();

            switch (prop) {
                case "create" -> {
                    int h = input.path("hour").asInt();
                    int m = input.path("minute").asInt();
                    lines.add("assertThat(new Clock(" + h + ", " + m + ").toString()).isEqualTo(\"" + expected.asText() + "\");");
                }
                case "add" -> {
                    int h = input.path("hour").asInt();
                    int m = input.path("minute").asInt();
                    int v = input.path("value").asInt();
                    lines.add("Clock clock = new Clock(" + h + ", " + m + ");");
                    lines.add("clock.add(" + v + ");");
                    lines.add("assertThat(clock.toString()).isEqualTo(\"" + expected.asText() + "\");");
                }
                case "subtract" -> {
                    int h = input.path("hour").asInt();
                    int m = input.path("minute").asInt();
                    int v = input.path("value").asInt();
                    lines.add("Clock clock = new Clock(" + h + ", " + m + ");");
                    lines.add("clock.add(" + (-v) + ");");
                    lines.add("assertThat(clock.toString()).isEqualTo(\"" + expected.asText() + "\");");
                }
                case "equal" -> {
                    int h1 = input.path("clock1").path("hour").asInt();
                    int m1 = input.path("clock1").path("minute").asInt();
                    int h2 = input.path("clock2").path("hour").asInt();
                    int m2 = input.path("clock2").path("minute").asInt();
                    lines.add("Clock clock1 = new Clock(" + h1 + ", " + m1 + ");");
                    lines.add("Clock clock2 = new Clock(" + h2 + ", " + m2 + ");");
                    if (expected.asBoolean()) {
                        lines.add("assertThat(clock1).isEqualTo(clock2);");
                    } else {
                        lines.add("assertThat(clock1).isNotEqualTo(clock2);");
                    }
                }
                default -> {}
            }
            return String.join("\n        ", lines);
        });

        handlebars.registerHelper("renderCryptoSquareCase", (context, options) -> {
            exercism.testgenerator.model.CanonicalCase c = toCanonicalCase(context);
            if (c == null) return "";
            String pt = c.input().path("plaintext").asText();
            String exp = c.expected().asText();

            java.util.List<String> lines = new java.util.ArrayList<>();
            String ptExpr = pt.length() > 60 ? breakStringIntoChunks(pt, 16) : "\"" + JavaTypeFormatter.escapeJavaString(pt) + "\"";
            String expExpr = exp.length() > 60 ? breakStringIntoChunks(exp, 16) : "\"" + JavaTypeFormatter.escapeJavaString(exp) + "\"";
            lines.add("CryptoSquare cryptoSquare = new CryptoSquare(" + ptExpr + ");");
            lines.add("assertThat(cryptoSquare.getCiphertext()).isEqualTo(" + expExpr + ");");
            return String.join("\n        ", lines);
        });

        handlebars.registerHelper("asDominoList", (context, options) -> {
            exercism.testgenerator.model.CanonicalCase c = toCanonicalCase(context);
            JsonNode dominoesNode = c != null ? c.input().path("dominoes")
                : (context instanceof JsonNode n ? n : null);
            if (dominoesNode == null || !dominoesNode.isArray() || dominoesNode.isEmpty()) {
                return "List.of()";
            }
            java.util.List<String> items = new java.util.ArrayList<>();
            for (JsonNode item : dominoesNode) {
                if (item.isArray() && item.size() >= 2) {
                    items.add("new Domino(" + item.get(0).asInt() + ", " + item.get(1).asInt() + ")");
                }
            }
            if (items.size() <= 3 && String.join(", ", items).length() <= 50) {
                return "List.of(" + String.join(", ", items) + ")";
            }
            return "List.of(\n                " + String.join(",\n                ", items) + "\n        )";
        });

        handlebars.registerHelper("renderGoCountingCase", (context, options) -> {
            exercism.testgenerator.model.CanonicalCase c = toCanonicalCase(context);
            if (c == null) return "";
            String prop = c.property();
            JsonNode input = c.input();
            JsonNode expected = c.expected();
            JsonNode boardNode = input.path("board");

            java.util.List<String> lines = new java.util.ArrayList<>();
            String boardStr;
            if (boardNode.isArray()) {
                java.util.List<String> bLines = new java.util.ArrayList<>();
                for (JsonNode b : boardNode) {
                    bLines.add("\"" + JavaTypeFormatter.escapeJavaString(b.asText()) + "\\n\"");
                }
                if (bLines.size() == 1) {
                    boardStr = "\"" + JavaTypeFormatter.escapeJavaString(boardNode.get(0).asText()) + "\"";
                } else {
                    boardStr = "\n                " + String.join(" +\n                ", bLines);
                }
            } else {
                boardStr = "\"\"";
            }

            lines.add("GoCounting gocounting = new GoCounting(" + boardStr + ");");

            if ("territory".equals(prop)) {
                int x = input.path("x").asInt();
                int y = input.path("y").asInt();
                if (expected.has("error")) {
                    lines.add("assertThatExceptionOfType(IllegalArgumentException.class)");
                    lines.add("        .isThrownBy(() -> gocounting.getTerritory(" + x + ", " + y + "))");
                    lines.add("        .withMessage(\"Invalid coordinate\");");
                } else {
                    String owner = expected.path("owner").asText().toUpperCase();
                    lines.add("assertThat(gocounting.getTerritoryOwner(" + x + ", " + y + ")).isEqualTo(Player."
                        + owner + ");");
                    JsonNode terr = expected.path("territory");
                    String setStr = formatPointSet(terr);
                    lines.add("assertThat(gocounting.getTerritory(" + x + ", " + y + ")).isEqualTo(" + setStr + ");");
                }
            } else if ("territories".equals(prop)) {
                lines.add("Set<Point> territoryBlack = " + formatPointSet(expected.path("territoryBlack")) + ";");
                lines.add("Set<Point> territoryWhite = " + formatPointSet(expected.path("territoryWhite")) + ";");
                lines.add("Set<Point> territoryNone = " + formatPointSet(expected.path("territoryNone")) + ";");
                lines.add("Map<Player, Set<Point>> expected = Map.of(");
                lines.add("        Player.BLACK, territoryBlack,");
                lines.add("        Player.WHITE, territoryWhite,");
                lines.add("        Player.NONE, territoryNone");
                lines.add(");");
                lines.add("assertThat(gocounting.getTerritories()).isEqualTo(expected);");
            }
            return String.join("\n        ", lines);
        });

        handlebars.registerHelper("asLocalDate", (context, options) -> {
            if (context == null) return "null";
            String s = context instanceof JsonNode n ? n.asText() : context.toString();
            s = s.replace("\"", "");
            String[] parts = s.split("-");
            if (parts.length == 3) {
                return "LocalDate.of(" + Integer.parseInt(parts[0]) + ", "
                    + Integer.parseInt(parts[1]) + ", " + Integer.parseInt(parts[2]) + ")";
            }
            return "LocalDate.parse(\"" + s + "\")";
        });

        handlebars.registerHelper("asStringList", (context, options) -> {
            if (context instanceof JsonNode node && node.isArray()) {
                if (node.isEmpty()) return "List.of()";
                java.util.List<String> list = new java.util.ArrayList<>();
                for (JsonNode item : node) {
                    list.add("\"" + JavaTypeFormatter.escapeJavaString(item.asText()) + "\"");
                }
                String joined = String.join(", ", list);
                if (joined.length() <= 50 && list.size() <= 3) {
                    return "List.of(" + joined + ")";
                }
                return "List.of(\n                "
                    + String.join(",\n                ", list)
                    + "\n        )";
            }
            return "List.of()";
        });

        handlebars.registerHelper("renderSgfCase", (context, options) -> {
            exercism.testgenerator.model.CanonicalCase c = toCanonicalCase(context);
            if (c == null) return "";
            String encoded = c.input().path("encoded").asText();
            JsonNode expected = c.expected();

            java.util.List<String> lines = new java.util.ArrayList<>();
            String encExpr;
            if (encoded.length() > 60) {
                encExpr = breakStringIntoChunks(encoded, 16);
            } else {
                encExpr = "\"" + JavaTypeFormatter.escapeJavaString(encoded) + "\"";
            }

            if (expected.has("error")) {
                lines.add("assertThatExceptionOfType(SgfParsingException.class)");
                lines.add("        .isThrownBy(() -> new SgfParsing().parse(" + encExpr + "));");
            } else {
                String nodeExpr = formatSgfNode(expected, 8);
                lines.add("SgfNode expected = " + nodeExpr + ";");
                lines.add("assertThat(new SgfParsing().parse(" + encExpr + ")).isEqualTo(expected);");
            }
            return String.join("\n        ", lines);
        });

        handlebars.registerHelper("renderSimpleLinkedListCase", (context, options) -> {
            exercism.testgenerator.model.CanonicalCase c = toCanonicalCase(context);
            if (c == null) return "";
            JsonNode init = c.input().path("initialValues");
            JsonNode ops = c.input().path("operations");

            java.util.List<String> lines = new java.util.ArrayList<>();
            if (init.isArray() && !init.isEmpty()) {
                java.util.List<String> initVals = new java.util.ArrayList<>();
                for (JsonNode v : init) initVals.add(v.asText());
                lines.add("SimpleLinkedList<Integer> list = new SimpleLinkedList<>(new Integer[]{"
                    + String.join(", ", initVals) + "});");
            } else {
                lines.add("SimpleLinkedList<Integer> list = new SimpleLinkedList<>();");
            }

            if (ops.isArray()) {
                for (JsonNode op : ops) {
                    String opName = op.path("operation").asText();
                    JsonNode exp = op.path("expected");
                    switch (opName) {
                        case "count" -> {
                            lines.add("assertThat(list.size()).isEqualTo(" + exp.asInt() + ");");
                        }
                        case "pop" -> {
                            if (exp.has("error")) {
                                lines.add("assertThatExceptionOfType(NoSuchElementException.class)"
                                    + ".isThrownBy(list::pop);");
                            } else {
                                lines.add("assertThat(list.pop()).isEqualTo(" + exp.asInt() + ");");
                            }
                        }
                        case "push" -> {
                            lines.add("list.push(" + op.path("value").asInt() + ");");
                        }
                        case "peek" -> {
                            if (exp.has("error")) {
                                lines.add("assertThatExceptionOfType(NoSuchElementException.class)"
                                    + ".isThrownBy(list::peek);");
                            } else {
                                lines.add("assertThat(list.peek()).isEqualTo(" + exp.asInt() + ");");
                            }
                        }
                        case "toList" -> {
                            if (exp.isArray() && exp.isEmpty()) {
                                lines.add("assertThat(list.toList()).isEmpty();");
                            } else if (exp.isArray()) {
                                java.util.List<String> vals = new java.util.ArrayList<>();
                                for (JsonNode v : exp) vals.add(v.asText());
                                lines.add("assertThat(list.toList()).containsExactly("
                                    + String.join(", ", vals) + ");");
                            }
                        }
                        case "reverse" -> {
                            lines.add("list.reverse();");
                        }
                        default -> {}
                    }
                }
            }
            return String.join("\n        ", lines);
        });

        handlebars.registerHelper("renderTreeBuildingCase", (context, options) -> {
            exercism.testgenerator.model.CanonicalCase c = toCanonicalCase(context);
            if (c == null) return "";
            JsonNode recordsNode = c.input().path("records");
            JsonNode expected = c.expected();

            java.util.List<String> lines = new java.util.ArrayList<>();
            lines.add("ArrayList<Record> records = new ArrayList<>();");
            if (recordsNode.isArray() && !recordsNode.isEmpty()) {
                for (JsonNode r : recordsNode) {
                    int rId = r.path("recordId").asInt();
                    int pId = r.path("parentId").asInt();
                    lines.add("records.add(new Record(" + rId + ", " + pId + "));");
                }
            }

            if (expected.has("error")) {
                lines.add("assertThatExceptionOfType(InvalidRecordsException.class)");
                lines.add("        .isThrownBy(() -> new BuildTree().buildTree(records));");
            } else if (!expected.has("node")) {
                lines.add("TreeNode root = new BuildTree().buildTree(records);");
                lines.add("assertThat(root).isNull();");
            } else {
                lines.add("TreeNode root = new BuildTree().buildTree(records);");
                lines.add("assertThat(root).isNotNull();");
                generateTreeAssertions(expected.path("node"), "root", lines);
            }
            return String.join("\n        ", lines);
        });

        handlebars.registerHelper("renderWordSearchCase", (context, options) -> {
            exercism.testgenerator.model.CanonicalCase c = toCanonicalCase(context);
            if (c == null) return "";
            JsonNode gridNode = c.input().path("grid");
            JsonNode wordsToSearch = c.input().has("wordsToSearchFor")
                ? c.input().path("wordsToSearchFor")
                : c.input().path("wordsToSearch");
            JsonNode expected = c.expected();

            java.util.List<String> lines = new java.util.ArrayList<>();
            lines.add("WordSearcher wordSearcher = new WordSearcher();");

            java.util.List<String> gridRows = new java.util.ArrayList<>();
            if (gridNode.isArray()) {
                for (JsonNode row : gridNode) {
                    gridRows.add("\"" + JavaTypeFormatter.escapeJavaString(row.asText()) + "\".toCharArray()");
                }
            }
            if (gridRows.size() <= 2) {
                lines.add("char[][] grid = new char[][]{" + String.join(", ", gridRows) + "};");
            } else {
                lines.add("char[][] grid = new char[][]{");
                for (int i = 0; i < gridRows.size(); i++) {
                    lines.add("        " + gridRows.get(i) + (i < gridRows.size() - 1 ? "," : ""));
                }
                lines.add("};");
            }

            java.util.List<String> words = new java.util.ArrayList<>();
            if (wordsToSearch.isArray()) {
                for (JsonNode w : wordsToSearch) {
                    words.add("\"" + JavaTypeFormatter.escapeJavaString(w.asText()) + "\"");
                }
            }
            if (words.size() <= 3 && String.join(", ", words).length() <= 50) {
                lines.add("Set<String> wordsToSearchFor = Set.of(" + String.join(", ", words) + ");");
            } else {
                lines.add("Set<String> wordsToSearchFor = Set.of(");
                lines.add("    " + String.join(",\n            ", words));
                lines.add(");");
            }

            lines.add("Map<String, Optional<WordLocation>> expectedLocations = new HashMap<>();");
            if (expected.isObject()) {
                expected.fields().forEachRemaining(entry -> {
                    String word = entry.getKey();
                    JsonNode loc = entry.getValue();
                    if (loc == null || loc.isNull()) {
                        lines.add("expectedLocations.put(\"" + word + "\", Optional.empty());");
                    } else {
                        int startCol = loc.path("start").path("column").asInt();
                        int startRow = loc.path("start").path("row").asInt();
                        int endCol = loc.path("end").path("column").asInt();
                        int endRow = loc.path("end").path("row").asInt();
                        lines.add("expectedLocations.put(\"" + word + "\", Optional.of(new WordLocation(");
                        lines.add("        new Pair(" + startCol + ", " + startRow + "),");
                        lines.add("        new Pair(" + endCol + ", " + endRow + ")");
                        lines.add(")));");
                    }
                });
            }

            lines.add("Map<String, Optional<WordLocation>> actualLocations = "
                + "wordSearcher.search(wordsToSearchFor, grid);");
            lines.add("assertThat(actualLocations).isEqualTo(expectedLocations);");

            return String.join("\n        ", lines);
        });

        handlebars.registerHelper("renderZipperCase", (context, options) -> {
            CanonicalCase c = toCanonicalCase(context);
            if (c == null) return "";
            java.util.List<String> lines = new java.util.ArrayList<>();

            if ("sameResultFromOperations".equals(c.property())) {
                JsonNode ops1 = c.input().path("operations");
                JsonNode ops2 = c.expected().path("operations");
                lines.add("Zipper zipper1 = binaryTree.getRoot()" + buildZipperNavPath(ops1) + ";");
                lines.add("Zipper zipper2 = binaryTree.getRoot()" + buildZipperNavPath(ops2) + ";");
                lines.add("assertThat(zipper1).isEqualTo(zipper2);");
                return String.join("\n        ", lines);
            }

            JsonNode ops = c.input().path("operations");
            if (!ops.isArray() || ops.isEmpty()) return "";

            if (ops.size() == 1 && "to_tree".equals(ops.get(0).path("operation").asText())) {
                lines.add("assertThat(zipper.toTree()).isEqualTo(binaryTree);");
                return String.join("\n        ", lines);
            }

            int mutationIdx = -1;
            for (int i = 0; i < ops.size(); i++) {
                String opName = ops.get(i).path("operation").asText();
                if (opName.startsWith("set_")) {
                    mutationIdx = i;
                    break;
                }
            }

            if (mutationIdx != -1) {
                JsonNode mutOp = ops.get(mutationIdx);
                String mutName = mutOp.path("operation").asText();
                JsonNode item = mutOp.path("item");

                boolean isSubtree = item.isObject() && (!item.path("left").isNull() || !item.path("right").isNull());
                if (isSubtree) {
                    int subVal = item.path("value").asInt();
                    lines.add("BinaryTree subtree = new BinaryTree(" + subVal + ");");
                    if (!item.path("left").isNull()) {
                        lines.add("subtree.getRoot().setLeft(new Zipper(" + item.path("left").path("value").asInt() + "));");
                    }
                    if (!item.path("right").isNull()) {
                        lines.add("subtree.getRoot().setRight(new Zipper(" + item.path("right").path("value").asInt() + "));");
                    }
                }

                lines.add("zipper = binaryTree.getRoot();");
                if (mutationIdx > 0) {
                    StringBuilder nav = new StringBuilder();
                    for (int i = 0; i < mutationIdx; i++) {
                        nav.append(".").append(ops.get(i).path("operation").asText());
                    }
                    lines.add("zipper = zipper" + nav.toString() + ";");
                }

                if ("set_value".equals(mutName)) {
                    lines.add("zipper.setValue(" + item.asInt() + ");");
                } else if ("set_left".equals(mutName)) {
                    if (item.isNull()) {
                        lines.add("zipper.setLeft(null);");
                    } else {
                        lines.add("zipper.setLeft(new Zipper(" + item.path("value").asInt() + "));");
                    }
                } else if ("set_right".equals(mutName)) {
                    if (item.isNull()) {
                        lines.add("zipper.setRight(null);");
                    } else if (isSubtree) {
                        lines.add("zipper.setRight(subtree.getRoot());");
                    } else {
                        lines.add("zipper.setRight(new Zipper(" + item.path("value").asInt() + "));");
                    }
                }

                JsonNode expVal = c.expected().path("value");
                String treeStr = formatZipperPrintTree(expVal);
                lines.add("String expected =");
                lines.add("        " + breakZipperString(treeStr) + ";");
                lines.add("assertThat(zipper.toTree().printTree()).isEqualTo(expected);");
                return String.join("\n        ", lines);
            }

            lines.add("zipper = binaryTree.getRoot();");
            JsonNode lastOp = ops.get(ops.size() - 1);
            String lastOpName = lastOp.path("operation").asText();

            StringBuilder nav = new StringBuilder();
            for (int i = 0; i < ops.size() - 1; i++) {
                nav.append(".").append(ops.get(i).path("operation").asText());
            }

            if ("value".equals(lastOpName)) {
                int expVal = c.expected().path("value").asInt();
                lines.add("assertThat(zipper" + nav.toString() + ".getValue()).isEqualTo(" + expVal + ");");
            } else if ("to_tree".equals(lastOpName)) {
                lines.add("assertThat(zipper" + nav.toString() + ".toTree()).isEqualTo(binaryTree);");
            } else {
                nav.append(".").append(lastOpName);
                lines.add("assertThat(zipper" + nav.toString() + ").isNull();");
            }

            return String.join("\n        ", lines);
        });

        handlebars.registerHelper("renderBookStoreCase", (context, options) -> {
            CanonicalCase c = toCanonicalCase(context);
            if (c == null) return "";
            JsonNode basket = c.input().path("basket");
            java.util.List<String> items = new java.util.ArrayList<>();
            if (basket.isArray()) {
                for (JsonNode item : basket) {
                    items.add(String.valueOf(item.asInt()));
                }
            }
            java.util.List<String> lines = new java.util.ArrayList<>();
            String basketExpr;
            if (items.isEmpty()) {
                basketExpr = "List.of()";
            } else if (items.size() <= 8) {
                basketExpr = "List.of(" + String.join(", ", items) + ")";
            } else {
                basketExpr = "List.of(\n                " + String.join(", ", items) + "\n        )";
            }
            lines.add("List<Integer> books = " + basketExpr + ";");
            double dollars = c.expected().asDouble() / 100.0;
            String dollarStr = String.format(java.util.Locale.ROOT, "%.2f", dollars);
            lines.add("assertThat(bookStore.calculateBasketCost(books))");
            lines.add("        .isCloseTo(" + dollarStr + ", offset(EQUALITY_TOLERANCE));");
            return String.join("\n        ", lines);
        });

        handlebars.registerHelper("renderChangeCase", (context, options) -> {
            CanonicalCase c = toCanonicalCase(context);
            if (c == null) return "";
            JsonNode coinsNode = c.input().path("coins");
            int target = c.input().path("target").asInt();
            java.util.List<String> coins = new java.util.ArrayList<>();
            if (coinsNode.isArray()) {
                for (JsonNode coin : coinsNode) {
                    coins.add(String.valueOf(coin.asInt()));
                }
            }
            String coinsExpr = "asList(" + String.join(", ", coins) + ")";
            java.util.List<String> lines = new java.util.ArrayList<>();
            lines.add("ChangeCalculator changeCalculator = new ChangeCalculator(" + coinsExpr + ");");
            lines.add("");

            if (c.expected().isObject() && c.expected().has("error")) {
                lines.add("assertThatExceptionOfType(IllegalArgumentException.class)");
                lines.add("        .isThrownBy(() -> changeCalculator.computeMostEfficientChange(" + target + "))");
                if (target < 0) {
                    lines.add("        .withMessage(\"Negative totals are not allowed.\");");
                } else {
                    lines.add("        .withMessage(\"The total " + target
                        + " cannot be represented in the given currency.\");");
                }
            } else if (c.expected().isArray()) {
                java.util.List<String> expCoins = new java.util.ArrayList<>();
                for (JsonNode coin : c.expected()) {
                    expCoins.add(String.valueOf(coin.asInt()));
                }
                if (expCoins.isEmpty()) {
                    lines.add("assertThat(changeCalculator.computeMostEfficientChange(" + target + "))");
                    lines.add("        .isEmpty();");
                } else {
                    lines.add("assertThat(changeCalculator.computeMostEfficientChange(" + target + "))");
                    lines.add("        .containsExactly(" + String.join(", ", expCoins) + ");");
                }
            }
            return String.join("\n        ", lines);
        });

        handlebars.registerHelper("renderCircularBufferCase", (context, options) -> {
            CanonicalCase c = toCanonicalCase(context);
            if (c == null) return "";
            int capacity = c.input().path("capacity").asInt();
            JsonNode ops = c.input().path("operations");
            java.util.List<String> lines = new java.util.ArrayList<>();
            lines.add("CircularBuffer<Integer> buffer = new CircularBuffer<>(" + capacity + ");");

            if (ops.isArray()) {
                for (JsonNode op : ops) {
                    String operation = op.path("operation").asText();
                    boolean shouldSucceed = op.path("should_succeed").asBoolean(true);
                    lines.add("");
                    switch (operation) {
                        case "write" -> {
                            int item = op.path("item").asInt();
                            if (shouldSucceed) {
                                lines.add("buffer.write(" + item + ");");
                            } else {
                                lines.add("assertThatExceptionOfType(BufferIOException.class)");
                                lines.add("        .isThrownBy(() -> buffer.write(" + item + "))");
                                lines.add("        .withMessage(\"Tried to write to full buffer\");");
                            }
                        }
                        case "read" -> {
                            if (shouldSucceed) {
                                int expected = op.path("expected").asInt();
                                lines.add("assertThat(buffer.read()).isEqualTo(" + expected + ");");
                            } else {
                                lines.add("assertThatExceptionOfType(BufferIOException.class)");
                                lines.add("        .isThrownBy(buffer::read)");
                                lines.add("        .withMessage(\"Tried to read from empty buffer\");");
                            }
                        }
                        case "overwrite" -> {
                            int item = op.path("item").asInt();
                            lines.add("buffer.overwrite(" + item + ");");
                        }
                        case "clear" -> {
                            lines.add("buffer.clear();");
                        }
                    }
                }
            }
            return String.join("\n        ", lines);
        });

        handlebars.registerHelper("renderComplexNumberCase", (context, options) -> {
            CanonicalCase c = toCanonicalCase(context);
            if (c == null) return "";
            String prop = c.property();
            JsonNode input = c.input();
            JsonNode expected = c.expected();
            java.util.List<String> lines = new java.util.ArrayList<>();

            java.util.function.Function<JsonNode, String> numStr = n -> {
                if (n == null) return "0.0";
                if (n.isTextual()) {
                    String t = n.asText();
                    return switch (t) {
                        case "pi" -> "Math.PI";
                        case "pi/4" -> "Math.PI / 4";
                        case "ln(2)" -> "Math.log(2.0)";
                        case "ln(2)/2" -> "Math.log(2.0) / 2";
                        case "e" -> "Math.E";
                        default -> t;
                    };
                }
                double d = n.asDouble();
                return (d == (long) d) ? String.format(java.util.Locale.ROOT, "%.1f", d) : String.valueOf(d);
            };

            switch (prop) {
                case "real" -> {
                    JsonNode z = input.path("z");
                    String r = numStr.apply(z.get(0));
                    String i = numStr.apply(z.get(1));
                    String exp = numStr.apply(expected);
                    lines.add("double expected = " + exp + ";");
                    lines.add("double actual = new ComplexNumber(" + r + ", " + i + ").getReal();");
                    lines.add("assertDoublesEqual(expected, actual, \"real\");");
                }
                case "imaginary" -> {
                    JsonNode z = input.path("z");
                    String r = numStr.apply(z.get(0));
                    String i = numStr.apply(z.get(1));
                    String exp = numStr.apply(expected);
                    lines.add("double expected = " + exp + ";");
                    lines.add("double actual = new ComplexNumber(" + r + ", " + i + ").getImaginary();");
                    lines.add("assertDoublesEqual(expected, actual, \"imaginary\");");
                }
                case "abs" -> {
                    JsonNode z = input.path("z");
                    String r = numStr.apply(z.get(0));
                    String i = numStr.apply(z.get(1));
                    String exp = numStr.apply(expected);
                    lines.add("double expected = " + exp + ";");
                    lines.add("double actual = new ComplexNumber(" + r + ", " + i + ").abs();");
                    lines.add("assertDoublesEqual(expected, actual, \"real\");");
                }
                case "conjugate" -> {
                    JsonNode z = input.path("z");
                    String r = numStr.apply(z.get(0));
                    String i = numStr.apply(z.get(1));
                    String expR = numStr.apply(expected.get(0));
                    String expI = numStr.apply(expected.get(1));
                    lines.add("ComplexNumber expected = new ComplexNumber(" + expR + ", " + expI + ");");
                    lines.add("ComplexNumber actual = new ComplexNumber(" + r + ", " + i + ").conjugate();");
                    lines.add("assertComplexNumbersEqual(expected, actual);");
                }
                case "exp" -> {
                    JsonNode z = input.path("z");
                    String r = numStr.apply(z.get(0));
                    String i = numStr.apply(z.get(1));
                    String expR = numStr.apply(expected.get(0));
                    String expI = numStr.apply(expected.get(1));
                    lines.add("ComplexNumber expected = new ComplexNumber(" + expR + ", " + expI + ");");
                    lines.add("ComplexNumber actual = new ComplexNumber(" + r + ", " + i + ").exponentialOf();");
                    lines.add("assertComplexNumbersEqual(expected, actual);");
                }
                case "add", "sub", "mul", "div" -> {
                    JsonNode z1 = input.path("z1");
                    JsonNode z2 = input.path("z2");
                    String r1 = numStr.apply(z1.get(0));
                    String i1 = numStr.apply(z1.get(1));
                    String r2 = numStr.apply(z2.get(0));
                    String i2 = numStr.apply(z2.get(1));
                    String expR = numStr.apply(expected.get(0));
                    String expI = numStr.apply(expected.get(1));
                    String method = switch (prop) {
                        case "add" -> "add";
                        case "sub" -> "subtract";
                        case "mul" -> "multiply";
                        case "div" -> "divide";
                        default -> prop;
                    };
                    lines.add("ComplexNumber expected = new ComplexNumber(" + expR + ", " + expI + ");");
                    lines.add("ComplexNumber actual = new ComplexNumber(" + r1 + ", " + i1 + ")"
                        + "." + method + "(new ComplexNumber(" + r2 + ", " + i2 + "));");
                    lines.add("assertComplexNumbersEqual(expected, actual);");
                }
            }
            return String.join("\n        ", lines);
        });

        handlebars.registerHelper("renderConnectCase", (context, options) -> {
            CanonicalCase c = toCanonicalCase(context);
            if (c == null) return "";
            JsonNode boardNode = c.input().path("board");
            java.util.List<String> rows = new java.util.ArrayList<>();
            if (boardNode.isArray()) {
                for (JsonNode row : boardNode) {
                    rows.add("\"" + JavaTypeFormatter.escapeJavaString(row.asText()) + "\"");
                }
            }
            String expWinner = switch (c.expected().asText()) {
                case "X" -> "Winner.PLAYER_X";
                case "O" -> "Winner.PLAYER_O";
                default -> "Winner.NONE";
            };
            java.util.List<String> lines = new java.util.ArrayList<>();
            lines.add("String[] board = new String[]{");
            for (int i = 0; i < rows.size(); i++) {
                lines.add("    " + rows.get(i) + (i < rows.size() - 1 ? "," : ""));
            }
            lines.add("};");
            lines.add("assertThat(new Connect(board).computeWinner()).isEqualTo(" + expWinner + ");");
            return String.join("\n        ", lines);
        });

        handlebars.registerHelper("renderListOpsCase", (context, options) -> {
            CanonicalCase c = toCanonicalCase(context);
            if (c == null) return "";
            String prop = c.property();
            java.util.List<String> lines = new java.util.ArrayList<>();

            java.util.function.Function<JsonNode, String> formatCharTree = new java.util.function.Function<>() {
                @Override
                public String apply(JsonNode node) {
                    if (node == null || node.isNull()) return "null";
                    if (!node.isArray()) {
                        return "'" + node.asText() + "'";
                    }
                    if (node.isEmpty()) {
                        return "List.of()";
                    }
                    java.util.List<String> items = new java.util.ArrayList<>();
                    for (JsonNode child : node) {
                        items.add(apply(child));
                    }
                    return "List.of(" + String.join(", ", items) + ")";
                }
            };

            switch (prop) {
                case "append" -> {
                    JsonNode list1 = c.input().path("list1");
                    JsonNode list2 = c.input().path("list2");
                    String l1 = JavaTypeFormatter.format(list1);
                    String l2 = JavaTypeFormatter.format(list2);
                    JsonNode exp = c.expected();
                    if (exp.isEmpty()) {
                        lines.add("assertThat(ListOps.append(" + l1 + ", " + l2 + ")).isEmpty();");
                    } else {
                        lines.add("assertThat(ListOps.append(" + l1 + ", " + l2 + "))");
                        lines.add("        .isEqualTo(" + JavaTypeFormatter.format(exp) + ");");
                    }
                }
                case "concat" -> {
                    JsonNode nested = c.input().has("lists") ? c.input().path("lists") : c.input().path("nested");
                    if (nested.isEmpty()) {
                        lines.add("assertThat(ListOps.concat(List.of())).isEmpty();");
                    } else if (nested.get(0).isArray() && !nested.get(0).isEmpty() && nested.get(0).get(0).isArray()) {
                        lines.add("List<List<List<Character>>> listOfNestedLists = List.of(");
                        for (int outerIdx = 0; outerIdx < nested.size(); outerIdx++) {
                            JsonNode outer = nested.get(outerIdx);
                            java.util.List<String> subItems = new java.util.ArrayList<>();
                            for (JsonNode inner : outer) {
                                subItems.add(formatCharTree.apply(inner));
                            }
                            if (subItems.isEmpty()) {
                                lines.add("        List.of()" + (outerIdx < nested.size() - 1 ? "," : ""));
                            } else {
                                lines.add("        List.of(");
                                for (int innerIdx = 0; innerIdx < subItems.size(); innerIdx++) {
                                    lines.add("                " + subItems.get(innerIdx) + (innerIdx < subItems.size() - 1 ? "," : ""));
                                }
                                lines.add("        )" + (outerIdx < nested.size() - 1 ? "," : ""));
                            }
                        }
                        lines.add(");");
                        java.util.List<String> expItems = new java.util.ArrayList<>();
                        for (JsonNode expItem : c.expected()) {
                            expItems.add(formatCharTree.apply(expItem));
                        }
                        lines.add("assertThat(ListOps.concat(listOfNestedLists))");
                        lines.add("        .isEqualTo(List.of(");
                        for (int i = 0; i < expItems.size(); i++) {
                            lines.add("                " + expItems.get(i) + (i < expItems.size() - 1 ? "," : ""));
                        }
                        lines.add("        ));");
                    } else {
                        java.util.List<String> inItems = new java.util.ArrayList<>();
                        for (JsonNode child : nested) {
                            inItems.add(formatCharTree.apply(child));
                        }
                        java.util.List<String> expChars = new java.util.ArrayList<>();
                        for (JsonNode child : c.expected()) {
                            expChars.add("'" + child.asText() + "'");
                        }
                        lines.add("List<List<Character>> listOfLists = List.of(");
                        for (int i = 0; i < inItems.size(); i++) {
                            lines.add("        " + inItems.get(i) + (i < inItems.size() - 1 ? "," : ""));
                        }
                        lines.add(");");
                        lines.add("assertThat(ListOps.concat(listOfLists)).containsExactly(" + String.join(", ", expChars) + ");");
                    }
                }
                case "filter" -> {
                    JsonNode list = c.input().path("list");
                    if (list.isEmpty()) {
                        lines.add("assertThat(ListOps.filter(List.<Integer>of(), integer -> integer % 2 == 1))");
                        lines.add("        .isEmpty();");
                    } else {
                        java.util.List<String> inVals = new java.util.ArrayList<>();
                        for (JsonNode v : list) inVals.add(String.valueOf(v.asInt()));
                        java.util.List<String> expVals = new java.util.ArrayList<>();
                        for (JsonNode v : c.expected()) expVals.add(String.valueOf(v.asInt()));
                        lines.add("assertThat(ListOps.filter(List.of(" + String.join(", ", inVals) + "), integer -> integer % 2 == 1))");
                        lines.add("        .containsExactly(" + String.join(", ", expVals) + ");");
                    }
                }
                case "length" -> {
                    JsonNode list = c.input().path("list");
                    if (list.isEmpty()) {
                        lines.add("assertThat(ListOps.size(List.of())).isEqualTo(0);");
                    } else {
                        lines.add("assertThat(ListOps.size(List.of(\"one\", \"two\", \"three\", \"four\"))).isEqualTo(4);");
                    }
                }
                case "map" -> {
                    JsonNode list = c.input().path("list");
                    if (list.isEmpty()) {
                        lines.add("assertThat(ListOps.map(List.<Integer>of(), integer -> integer + 1)).isEmpty();");
                    } else {
                        java.util.List<String> inVals = new java.util.ArrayList<>();
                        for (JsonNode v : list) inVals.add(String.valueOf(v.asInt()));
                        java.util.List<String> expVals = new java.util.ArrayList<>();
                        for (JsonNode v : c.expected()) expVals.add(String.valueOf(v.asInt()));
                        lines.add("assertThat(ListOps.map(List.of(" + String.join(", ", inVals) + "), integer -> integer + 1))");
                        lines.add("        .containsExactly(" + String.join(", ", expVals) + ");");
                    }
                }
                case "reverse" -> {
                    JsonNode list = c.input().path("list");
                    if (list.isEmpty()) {
                        lines.add("assertThat(ListOps.reverse(List.of())).isEmpty();");
                    } else if (list.get(0).isArray()) {
                        java.util.List<String> inItems = new java.util.ArrayList<>();
                        for (JsonNode child : list) inItems.add(formatCharTree.apply(child));
                        java.util.List<String> expItems = new java.util.ArrayList<>();
                        for (JsonNode child : c.expected()) expItems.add(formatCharTree.apply(child));
                        lines.add("List<List<Character>> listOfLists = List.of(");
                        for (int i = 0; i < inItems.size(); i++) {
                            lines.add("        " + inItems.get(i) + (i < inItems.size() - 1 ? "," : ""));
                        }
                        lines.add(");");
                        lines.add("assertThat(ListOps.reverse(listOfLists)).containsExactly(");
                        for (int i = 0; i < expItems.size(); i++) {
                            lines.add("        " + expItems.get(i) + (i < expItems.size() - 1 ? "," : ""));
                        }
                        lines.add(");");
                    } else {
                        java.util.List<String> inChars = new java.util.ArrayList<>();
                        for (JsonNode child : list) inChars.add("'" + child.asText() + "'");
                        java.util.List<String> expChars = new java.util.ArrayList<>();
                        for (JsonNode child : c.expected()) expChars.add("'" + child.asText() + "'");
                        lines.add("assertThat(ListOps.reverse(List.of(" + String.join(", ", inChars) + ")))");
                        lines.add("        .containsExactly(" + String.join(", ", expChars) + ");");
                    }
                }
                case "foldl" -> {
                    JsonNode list = c.input().path("list");
                    String fn = c.input().path("function").asText();
                    double init = c.input().path("initial").asDouble();
                    double exp = c.expected().asDouble();
                    if (list.isEmpty()) {
                        lines.add("assertThat(ListOps.foldLeft(List.<Double>of(), " + init + ", (acc, el) -> el * acc))");
                        lines.add("        .isEqualTo(" + exp + ");");
                    } else if (fn.contains("+")) {
                        java.util.List<String> inVals = new java.util.ArrayList<>();
                        for (JsonNode v : list) inVals.add(String.valueOf(v.asInt()));
                        lines.add("assertThat(ListOps.foldLeft(List.of(" + String.join(", ", inVals) + "), " + (int) init + ", Integer::sum))");
                        lines.add("        .isEqualTo(" + (int) exp + ");");
                    } else {
                        java.util.List<String> inVals = new java.util.ArrayList<>();
                        for (JsonNode v : list) inVals.add(String.format(java.util.Locale.ROOT, "%.1f", v.asDouble()));
                        lines.add("assertThat(ListOps.foldLeft(List.of(" + String.join(", ", inVals) + "), " + String.format(java.util.Locale.ROOT, "%.1f", init) + ", (acc, el) -> el / acc))");
                        lines.add("        .isEqualTo(" + exp + ");");
                    }
                }
                case "foldr" -> {
                    JsonNode list = c.input().path("list");
                    String fn = c.input().path("function").asText();
                    double init = c.input().path("initial").asDouble();
                    double exp = c.expected().asDouble();
                    if (list.isEmpty()) {
                        lines.add("assertThat(ListOps.foldRight(List.<Double>of(), " + init + ", (el, acc) -> el * acc))");
                        lines.add("        .isEqualTo(" + exp + ");");
                    } else if (fn.contains("+")) {
                        java.util.List<String> inVals = new java.util.ArrayList<>();
                        for (JsonNode v : list) inVals.add(String.valueOf(v.asInt()));
                        lines.add("assertThat(ListOps.foldRight(List.of(" + String.join(", ", inVals) + "), " + (int) init + ", Integer::sum))");
                        lines.add("        .isEqualTo(" + (int) exp + ");");
                    } else {
                        java.util.List<String> inVals = new java.util.ArrayList<>();
                        for (JsonNode v : list) inVals.add(String.format(java.util.Locale.ROOT, "%.1f", v.asDouble()));
                        lines.add("assertThat(ListOps.foldRight(List.of(" + String.join(", ", inVals) + "), " + String.format(java.util.Locale.ROOT, "%.1f", init) + ", (el, acc) -> el / acc))");
                        lines.add("        .isEqualTo(" + exp + ");");
                    }
                }
            }
            return String.join("\n        ", lines);
        });

        handlebars.registerHelper("renderOcrCase", (context, options) -> {
            CanonicalCase c = toCanonicalCase(context);
            if (c == null) return "";
            JsonNode rows = c.input().path("rows");
            java.util.List<String> rowLines = new java.util.ArrayList<>();
            if (rows.isArray()) {
                for (JsonNode r : rows) {
                    rowLines.add("\"" + JavaTypeFormatter.escapeJavaString(r.asText()) + "\"");
                }
            }
            java.util.List<String> lines = new java.util.ArrayList<>();
            String singleLineRows = "List.of(" + String.join(", ", rowLines) + ")";
            String rowsExpr;
            if (singleLineRows.length() > 50) {
                rowsExpr = "List.of(\n"
                    + "                " + String.join(",\n                ", rowLines)
                    + ")";
            } else {
                rowsExpr = singleLineRows;
            }
            if (c.expected().isObject() && c.expected().has("error")) {
                int numRows = rows.size();
                String msg = (numRows % 4 != 0)
                    ? "Number of input rows must be a positive multiple of 4"
                    : "Number of input columns must be a positive multiple of 3";
                lines.add("assertThatExceptionOfType(IllegalArgumentException.class)");
                lines.add("        .isThrownBy(() -> new OpticalCharacterReader().parse(" + rowsExpr + "))");
                lines.add("        .withMessage(\"" + msg + "\");");
            } else {
                lines.add("assertThat(new OpticalCharacterReader().parse(" + rowsExpr + "))");
                lines.add("        .isEqualTo(\"" + JavaTypeFormatter.escapeJavaString(c.expected().asText()) + "\");");
            }
            return String.join("\n        ", lines);
        });

        handlebars.registerHelper("renderPalindromeProductsCase", (context, options) -> {
            CanonicalCase c = toCanonicalCase(context);
            if (c == null) return "";
            int min = c.input().path("min").asInt();
            int max = c.input().path("max").asInt();
            String prop = c.property();
            java.util.List<String> lines = new java.util.ArrayList<>();

            if (c.expected().isObject() && c.expected().has("error")) {
                lines.add("assertThatExceptionOfType(IllegalArgumentException.class)");
                lines.add("        .isThrownBy(() -> palindromeCalculator.getPalindromeProductsWithFactors("
                    + min + ", " + max + "))");
                lines.add("        .withMessage(\"invalid input: min must be <= max\");");
            } else {
                lines.add("SortedMap<Long, List<List<Integer>>> palindromes =");
                lines.add("        palindromeCalculator.getPalindromeProductsWithFactors(" + min + ", " + max + ");");
                lines.add("");
                JsonNode expVal = c.expected().path("value");
                if (expVal == null || expVal.isNull() || !expVal.isNumber()) {
                    lines.add("assertThat(palindromes.isEmpty()).isTrue();");
                } else {
                    long val = expVal.asLong();
                    JsonNode factors = c.expected().path("factors");
                    java.util.List<String> pairs = new java.util.ArrayList<>();
                    if (factors.isArray()) {
                        for (JsonNode pair : factors) {
                            pairs.add("List.of(" + pair.get(0).asInt() + ", " + pair.get(1).asInt() + ")");
                        }
                    }
                    lines.add("List<List<Integer>> expected = List.of(");
                    for (int i = 0; i < pairs.size(); i++) {
                        lines.add("        " + pairs.get(i) + (i < pairs.size() - 1 ? "," : ""));
                    }
                    lines.add(");");
                    lines.add("long expectedValue = " + val + "L;");
                    String keyMethod = prop.equals("smallest") ? "palindromes.firstKey()" : "palindromes.lastKey()";
                    lines.add("checkPalindromeWithFactorsMatchesExpected(expected, expectedValue, palindromes, "
                        + keyMethod + ");");
                }
            }
            return String.join("\n        ", lines);
        });

        handlebars.registerHelper("renderPovCase", (context, options) -> {
            CanonicalCase c = toCanonicalCase(context);
            if (c == null) return "";
            String prop = c.property();
            JsonNode treeNode = c.input().path("tree");
            java.util.List<String> lines = new java.util.ArrayList<>();

            java.util.function.BiFunction<JsonNode, Integer, String> formatPovTree = new java.util.function.BiFunction<>() {
                @Override
                public String apply(JsonNode node, Integer depth) {
                    if (node == null || node.isNull()) return "null";
                    String label = "\"" + JavaTypeFormatter.escapeJavaString(node.path("label").asText()) + "\"";
                    JsonNode children = node.path("children");
                    if (children != null && children.isArray() && !children.isEmpty()) {
                        java.util.List<String> inlineChildren = new java.util.ArrayList<>();
                        for (JsonNode ch : children) {
                            inlineChildren.add(apply(ch, 0));
                        }
                        String inline = "Tree.of(" + label + ", List.of(" + String.join(", ", inlineChildren) + "))";
                        if (inline.length() <= 40) {
                            return inline;
                        }
                        String indent = "        ".repeat(depth + 2);
                        java.util.List<String> chList = new java.util.ArrayList<>();
                        for (JsonNode ch : children) {
                            chList.add(indent + apply(ch, depth + 1));
                        }
                        return "Tree.of(" + label + ",\n"
                            + indent + "List.of(\n"
                            + String.join(",\n", chList) + "))";
                    }
                    return "Tree.of(" + label + ")";
                }
            };

            lines.add("Tree tree = " + formatPovTree.apply(treeNode, 0) + ";");

            boolean isError = (c.expected().isObject() && c.expected().has("error")) || c.expected().isNull();
            if (prop.equals("fromPov")) {
                String from = "\"" + JavaTypeFormatter.escapeJavaString(c.input().path("from").asText()) + "\"";
                if (isError) {
                    lines.add("assertThatExceptionOfType(UnsupportedOperationException.class)");
                    lines.add("        .isThrownBy(() -> tree.fromPov(" + from + "))");
                    lines.add("        .withMessage(\"Tree could not be reoriented\");");
                } else {
                    lines.add("Tree expected = " + formatPovTree.apply(c.expected(), 0) + ";");
                    lines.add("assertThat(tree.fromPov(" + from + ")).isEqualTo(expected);");
                }
            } else if (prop.equals("pathTo")) {
                String from = "\"" + JavaTypeFormatter.escapeJavaString(c.input().path("from").asText()) + "\"";
                String to = "\"" + JavaTypeFormatter.escapeJavaString(c.input().path("to").asText()) + "\"";
                if (isError) {
                    lines.add("assertThatExceptionOfType(UnsupportedOperationException.class)");
                    lines.add("        .isThrownBy(() -> tree.pathTo(" + from + ", " + to + "))");
                    lines.add("        .withMessage(\"No path found\");");
                } else {
                    java.util.List<String> pathItems = new java.util.ArrayList<>();
                    if (c.expected().isArray()) {
                        for (JsonNode p : c.expected()) {
                            pathItems.add("\"" + JavaTypeFormatter.escapeJavaString(p.asText()) + "\"");
                        }
                    }
                    lines.add("List<String> expected = List.of(" + String.join(", ", pathItems) + ");");
                    lines.add("assertThat(tree.pathTo(" + from + ", " + to + ")).isEqualTo(expected);");
                }
            }
            return String.join("\n        ", lines);
        });

        handlebars.registerHelper("renderRationalCase", (context, options) -> {
            CanonicalCase c = toCanonicalCase(context);
            if (c == null) return "";
            String prop = c.property();
            JsonNode input = c.input();
            JsonNode exp = c.expected();
            java.util.List<String> lines = new java.util.ArrayList<>();

            switch (prop) {
                case "add", "sub", "mul", "div" -> {
                    JsonNode r1 = input.path("r1");
                    JsonNode r2 = input.path("r2");
                    String opMethod = switch (prop) {
                        case "add" -> "add";
                        case "sub" -> "subtract";
                        case "mul" -> "multiply";
                        case "div" -> "divide";
                        default -> prop;
                    };
                    lines.add("Rational expected = new Rational(" + exp.get(0).asInt() + ", "
                        + exp.get(1).asInt() + ");");
                    lines.add("Rational actual = new Rational(" + r1.get(0).asInt() + ", " + r1.get(1).asInt() + ")");
                    lines.add("        ." + opMethod + "(new Rational(" + r2.get(0).asInt() + ", "
                        + r2.get(1).asInt() + "));");
                    lines.add("assertThat(actual).isEqualTo(expected);");
                }
                case "abs" -> {
                    JsonNode r = input.path("r");
                    lines.add("Rational expected = new Rational(" + exp.get(0).asInt() + ", "
                        + exp.get(1).asInt() + ");");
                    lines.add("Rational actual = new Rational(" + r.get(0).asInt() + ", "
                        + r.get(1).asInt() + ").abs();");
                    lines.add("assertThat(actual).isEqualTo(expected);");
                }
                case "exprational" -> {
                    JsonNode r = input.path("r");
                    int n = input.path("n").asInt();
                    lines.add("Rational expected = new Rational(" + exp.get(0).asInt() + ", "
                        + exp.get(1).asInt() + ");");
                    lines.add("Rational actual = new Rational(" + r.get(0).asInt() + ", "
                        + r.get(1).asInt() + ").pow(" + n + ");");
                    lines.add("assertThat(actual).isEqualTo(expected);");
                }
                case "expreal" -> {
                    JsonNode r = input.path("r");
                    double x = input.path("x").asDouble();
                    String xStr = (x == (long) x) ? String.format(java.util.Locale.ROOT, "%.1f", x)
                        : String.valueOf(x);
                    double expD = exp.asDouble();
                    String expStr;
                    if (Math.abs(expD - 1.0 / 3) < 1e-6) {
                        expStr = "1.0 / 3";
                    } else if (expD == (long) expD) {
                        expStr = String.format(java.util.Locale.ROOT, "%.1f", expD);
                    } else {
                        expStr = String.valueOf(expD);
                    }
                    lines.add("double expected = " + expStr + ";");
                    lines.add("double actual = new Rational(" + r.get(0).asInt() + ", "
                        + r.get(1).asInt() + ").exp(" + xStr + ");");
                    lines.add("assertDoublesEqual(expected, actual);");
                }
                case "reduce" -> {
                    JsonNode r = input.path("r");
                    lines.add("Rational expected = new Rational(" + exp.get(0).asInt() + ", "
                        + exp.get(1).asInt() + ");");
                    lines.add("Rational actual = new Rational(" + r.get(0).asInt() + ", "
                        + r.get(1).asInt() + ");");
                    lines.add("assertThat(actual).isEqualTo(expected);");
                }
            }
            return String.join("\n        ", lines);
        });

        handlebars.registerHelper("renderRectanglesCase", (context, options) -> {
            CanonicalCase c = toCanonicalCase(context);
            if (c == null) return "";
            JsonNode linesNode = c.input().has("strings") ? c.input().path("strings") : c.input().path("lines");
            java.util.List<String> rows = new java.util.ArrayList<>();
            if (linesNode.isArray()) {
                for (JsonNode row : linesNode) {
                    rows.add("\"" + JavaTypeFormatter.escapeJavaString(row.asText()) + "\"");
                }
            }
            java.util.List<String> lines = new java.util.ArrayList<>();
            if (rows.isEmpty()) {
                lines.add("assertThat(new RectangleCounter().countRectangles(new String[]{}))");
                lines.add("        .isEqualTo(" + c.expected().asInt() + ");");
            } else {
                lines.add("String[] grid = new String[]{");
                for (int i = 0; i < rows.size(); i++) {
                    lines.add("    " + rows.get(i) + (i < rows.size() - 1 ? "," : ""));
                }
                lines.add("};");
                lines.add("assertThat(new RectangleCounter().countRectangles(grid))");
                lines.add("        .isEqualTo(" + c.expected().asInt() + ");");
            }
            return String.join("\n        ", lines);
        });

        handlebars.registerHelper("renderSimpleCipherCase", (context, options) -> {
            CanonicalCase c = toCanonicalCase(context);
            if (c == null) return "";
            JsonNode input = c.input();
            JsonNode expected = c.expected();
            String prop = c.property();

            java.util.List<String> lines = new java.util.ArrayList<>();
            boolean isRandom = !input.has("key");

            if (isRandom) {
                if (expected.isObject() && expected.has("match")) {
                    lines.add("assertThat(randomKeyCipher.getKey()).matches(\""
                        + JavaTypeFormatter.escapeJavaString(expected.get("match").asText()) + "\");");
                } else if ("encode".equals(prop)) {
                    String plain = input.path("plaintext").asText();
                    lines.add("String plainText = \"" + JavaTypeFormatter.escapeJavaString(plain) + "\";");
                    lines.add("String cipherText = randomKeyCipher.getKey().substring(0, " + plain.length() + ");");
                    lines.add("assertThat(randomKeyCipher.encode(plainText)).isEqualTo(cipherText);");
                } else if ("decode".equals(prop)) {
                    if ("cipher.encode".equals(input.path("ciphertext").asText())) {
                        String plain = input.path("plaintext").asText();
                        lines.add("String plainText = \"" + JavaTypeFormatter.escapeJavaString(plain) + "\";");
                        lines.add("assertThat(randomKeyCipher.decode(randomKeyCipher.encode(plainText)))");
                        lines.add("        .isEqualTo(plainText);");
                    } else {
                        String exp = expected.asText();
                        lines.add("String cipherText = \"" + JavaTypeFormatter.escapeJavaString(exp) + "\";");
                        lines.add("assertThat(randomKeyCipher.decode(randomKeyCipher.getKey().substring(0, " + exp.length() + ")))");
                        lines.add("        .isEqualTo(cipherText);");
                    }
                }
            } else {
                String key = input.path("key").asText();
                boolean useDefaultKey = "abcdefghij".equals(key);
                String cipherExpr = useDefaultKey ? "substitutionCipher" : ("new Cipher(\"" + JavaTypeFormatter.escapeJavaString(key) + "\")");

                if ("cipher.encode".equals(input.path("ciphertext").asText())) {
                    String plain = input.path("plaintext").asText();
                    lines.add("String plainText = \"" + JavaTypeFormatter.escapeJavaString(plain) + "\";");
                    lines.add("assertThat(" + cipherExpr + ".decode(" + cipherExpr + ".encode(plainText)))");
                    lines.add("        .isEqualTo(plainText);");
                } else if ("encode".equals(prop)) {
                    String plain = input.path("plaintext").asText();
                    lines.add("String plainText = \"" + JavaTypeFormatter.escapeJavaString(plain) + "\";");
                    lines.add("assertThat(" + cipherExpr + ".encode(plainText)).isEqualTo(\""
                        + JavaTypeFormatter.escapeJavaString(expected.asText()) + "\");");
                } else if ("decode".equals(prop)) {
                    String cipherText = input.path("ciphertext").asText();
                    lines.add("String plainText = \"" + JavaTypeFormatter.escapeJavaString(expected.asText()) + "\";");
                    lines.add("assertThat(" + cipherExpr + ".decode(\"" + JavaTypeFormatter.escapeJavaString(cipherText) + "\"))");
                    lines.add("        .isEqualTo(plainText);");
                }
            }
            return String.join("\n        ", lines);
        });

        handlebars.registerHelper("renderForthCase", (context, options) -> {
            CanonicalCase c = toCanonicalCase(context);
            if (c == null) return "";
            java.util.List<String> lines = new java.util.ArrayList<>();

            if ("evaluateBoth".equals(c.property())) {
                JsonNode firstInstrs = c.input().path("instructionsFirst");
                JsonNode secondInstrs = c.input().path("instructionsSecond");
                java.util.List<String> firstList = new java.util.ArrayList<>();
                java.util.List<String> secondList = new java.util.ArrayList<>();
                if (firstInstrs.isArray()) {
                    for (JsonNode in : firstInstrs) {
                        firstList.add("\"" + JavaTypeFormatter.escapeJavaString(in.asText()) + "\"");
                    }
                }
                if (secondInstrs.isArray()) {
                    for (JsonNode in : secondInstrs) {
                        secondList.add("\"" + JavaTypeFormatter.escapeJavaString(in.asText()) + "\"");
                    }
                }
                java.util.List<String> expFirst = new java.util.ArrayList<>();
                java.util.List<String> expSecond = new java.util.ArrayList<>();
                if (c.expected().isArray() && c.expected().size() >= 2) {
                    for (JsonNode in : c.expected().get(0)) {
                        expFirst.add(String.valueOf(in.asInt()));
                    }
                    for (JsonNode in : c.expected().get(1)) {
                        expSecond.add(String.valueOf(in.asInt()));
                    }
                }
                lines.add("ForthEvaluator firstInstance = new ForthEvaluator();");
                lines.add("ForthEvaluator secondInstance = new ForthEvaluator();");
                lines.add("");
                lines.add("assertThat(firstInstance.evaluateProgram(List.of(" + String.join(", ", firstList) + ")))");
                lines.add("        .containsExactly(" + String.join(", ", expFirst) + ");");
                lines.add("assertThat(secondInstance.evaluateProgram(List.of(" + String.join(", ", secondList) + ")))");
                lines.add("        .containsExactly(" + String.join(", ", expSecond) + ");");
                return String.join("\n        ", lines);
            }

            JsonNode instrs = c.input().path("instructions");
            java.util.List<String> instrList = new java.util.ArrayList<>();
            if (instrs.isArray()) {
                for (JsonNode in : instrs) {
                    instrList.add("\"" + JavaTypeFormatter.escapeJavaString(in.asText()) + "\"");
                }
            }
            String instrExpr = "List.of(" + String.join(", ", instrList) + ")";

            if (c.expected().isObject() && c.expected().has("error")) {
                String err = c.expected().path("error").asText();
                String msg;
                if (err.contains("zero") || instrList.stream().anyMatch(s -> s.contains("/ 0"))) {
                    msg = "Division by 0 is not allowed";
                } else if (err.contains("illegal") || instrList.stream().anyMatch(s -> s.matches("\".*:\\s*-?\\d+.*\""))) {
                    msg = "Cannot redefine numbers";
                } else if (instrList.stream().anyMatch(s -> s.contains("dup"))) {
                    msg = "Duplicating requires that the stack contain at least 1 value";
                } else if (instrList.stream().anyMatch(s -> s.contains("drop"))) {
                    msg = "Dropping requires that the stack contain at least 1 value";
                } else if (instrList.stream().anyMatch(s -> s.contains("swap"))) {
                    msg = "Swapping requires that the stack contain at least 2 values";
                } else if (instrList.stream().anyMatch(s -> s.contains("over"))) {
                    msg = "Overing requires that the stack contain at least 2 values";
                } else if (instrList.stream().anyMatch(s -> s.contains("+"))) {
                    msg = "Addition requires that the stack contain at least 2 values";
                } else if (instrList.stream().anyMatch(s -> s.contains("-"))) {
                    msg = "Subtraction requires that the stack contain at least 2 values";
                } else if (instrList.stream().anyMatch(s -> s.contains("*"))) {
                    msg = "Multiplication requires that the stack contain at least 2 values";
                } else if (instrList.stream().anyMatch(s -> s.contains("/"))) {
                    msg = "Division requires that the stack contain at least 2 values";
                } else {
                    msg = "No definition available for operator \\\"foo\\\"";
                }
                lines.add("assertThatExceptionOfType(IllegalArgumentException.class)");
                lines.add("        .isThrownBy(() -> forthEvaluator.evaluateProgram(" + instrExpr + "))");
                lines.add("        .withMessage(\"" + msg + "\");");
            } else {
                java.util.List<String> expInts = new java.util.ArrayList<>();
                if (c.expected().isArray()) {
                    for (JsonNode in : c.expected()) {
                        expInts.add(String.valueOf(in.asInt()));
                    }
                }
                lines.add("assertThat(forthEvaluator.evaluateProgram(" + instrExpr + "))");
                lines.add("        .containsExactly(" + String.join(", ", expInts) + ");");
            }
            return String.join("\n        ", lines);
        });

        handlebars.registerHelper("renderPythagoreanCase", (context, options) -> {
            CanonicalCase c = toCanonicalCase(context);
            if (c == null) return "";
            int n = c.input().path("n").asInt();
            JsonNode maxFactorNode = c.input().path("maxFactor");
            java.util.List<String> lines = new java.util.ArrayList<>();

            lines.add("List<PythagoreanTriplet> actual = PythagoreanTriplet");
            lines.add("        .makeTripletsList()");
            lines.add("        .thatSumTo(" + n + ")");
            if (maxFactorNode.isNumber()) {
                lines.add("        .withFactorsLessThanOrEqualTo(" + maxFactorNode.asInt() + ")");
            }
            lines.add("        .build();");

            JsonNode expTriplets = c.expected();
            java.util.List<String> triplets = new java.util.ArrayList<>();
            if (expTriplets.isArray()) {
                for (JsonNode tr : expTriplets) {
                    triplets.add("new PythagoreanTriplet(" + tr.get(0).asInt() + ", "
                        + tr.get(1).asInt() + ", " + tr.get(2).asInt() + ")");
                }
            }
            if (triplets.isEmpty()) {
                lines.add("List<PythagoreanTriplet> expected = List.of();");
            } else if (triplets.size() == 1) {
                lines.add("List<PythagoreanTriplet> expected = List.of(" + triplets.get(0) + ");");
            } else {
                lines.add("List<PythagoreanTriplet> expected = List.of(");
                for (int i = 0; i < triplets.size(); i++) {
                    lines.add("        " + triplets.get(i) + (i < triplets.size() - 1 ? "," : ""));
                }
                lines.add(");");
            }
            lines.add("assertThat(actual).isEqualTo(expected);");
            return String.join("\n        ", lines);
        });

        handlebars.registerHelper("renderCustomSetCase", (context, options) -> {
            CanonicalCase c = toCanonicalCase(context);
            if (c == null) return "";
            String prop = c.property();
            JsonNode input = c.input();
            JsonNode exp = c.expected();
            java.util.List<String> lines = new java.util.ArrayList<>();

            java.util.function.Function<JsonNode, String> formatSet = node -> {
                if (node == null || !node.isArray() || node.isEmpty()) {
                    return "new CustomSet<>(List.of())";
                }
                java.util.List<String> items = new java.util.ArrayList<>();
                for (JsonNode el : node) {
                    items.add(String.valueOf(el.asInt()));
                }
                return "new CustomSet<>(List.of(" + String.join(", ", items) + "))";
            };

            switch (prop) {
                case "empty" -> {
                    lines.add("CustomSet<Integer> customSet = " + formatSet.apply(input.path("set")) + ";");
                    lines.add("assertThat(customSet.isEmpty())." + (exp.asBoolean() ? "isTrue" : "isFalse") + "();");
                }
                case "contains" -> {
                    lines.add("CustomSet<Integer> customSet = " + formatSet.apply(input.path("set")) + ";");
                    int element = input.path("element").asInt();
                    lines.add("assertThat(customSet.contains(" + element + "))."
                        + (exp.asBoolean() ? "isTrue" : "isFalse") + "();");
                }
                case "subset" -> {
                    lines.add("CustomSet<Integer> customSet1 = " + formatSet.apply(input.path("set1")) + ";");
                    lines.add("CustomSet<Integer> customSet2 = " + formatSet.apply(input.path("set2")) + ";");
                    lines.add("assertThat(customSet2.isSubset(customSet1))."
                        + (exp.asBoolean() ? "isTrue" : "isFalse") + "();");
                }
                case "disjoint" -> {
                    lines.add("CustomSet<Integer> customSet1 = " + formatSet.apply(input.path("set1")) + ";");
                    lines.add("CustomSet<Integer> customSet2 = " + formatSet.apply(input.path("set2")) + ";");
                    lines.add("assertThat(customSet1.isDisjoint(customSet2))."
                        + (exp.asBoolean() ? "isTrue" : "isFalse") + "();");
                }
                case "equal" -> {
                    lines.add("CustomSet<Integer> customSet1 = " + formatSet.apply(input.path("set1")) + ";");
                    lines.add("CustomSet<Integer> customSet2 = " + formatSet.apply(input.path("set2")) + ";");
                    lines.add("assertThat(customSet1.equals(customSet2))."
                        + (exp.asBoolean() ? "isTrue" : "isFalse") + "();");
                }
                case "add" -> {
                    lines.add("CustomSet<Integer> customSet = " + formatSet.apply(input.path("set")) + ";");
                    int element = input.path("element").asInt();
                    lines.add("customSet.add(" + element + ");");
                    lines.add("CustomSet<Integer> expected = " + formatSet.apply(exp) + ";");
                    lines.add("assertThat(customSet.equals(expected)).isTrue();");
                }
                case "intersection" -> {
                    lines.add("CustomSet<Integer> customSet1 = " + formatSet.apply(input.path("set1")) + ";");
                    lines.add("CustomSet<Integer> customSet2 = " + formatSet.apply(input.path("set2")) + ";");
                    lines.add("CustomSet<Integer> actual = customSet1.getIntersection(customSet2);");
                    lines.add("CustomSet<Integer> expected = " + formatSet.apply(exp) + ";");
                    lines.add("assertThat(actual.equals(expected)).isTrue();");
                }
                case "difference" -> {
                    lines.add("CustomSet<Integer> customSet1 = " + formatSet.apply(input.path("set1")) + ";");
                    lines.add("CustomSet<Integer> customSet2 = " + formatSet.apply(input.path("set2")) + ";");
                    lines.add("CustomSet<Integer> actual = customSet1.getDifference(customSet2);");
                    lines.add("CustomSet<Integer> expected = " + formatSet.apply(exp) + ";");
                    lines.add("assertThat(actual.equals(expected)).isTrue();");
                }
                case "union" -> {
                    lines.add("CustomSet<Integer> customSet1 = " + formatSet.apply(input.path("set1")) + ";");
                    lines.add("CustomSet<Integer> customSet2 = " + formatSet.apply(input.path("set2")) + ";");
                    lines.add("CustomSet<Integer> actual = customSet1.getUnion(customSet2);");
                    lines.add("CustomSet<Integer> expected = " + formatSet.apply(exp) + ";");
                    lines.add("assertThat(actual.equals(expected)).isTrue();");
                }
            }
            return String.join("\n        ", lines);
        });

        handlebars.registerHelper("renderSatelliteCase", (context, options) -> {
            CanonicalCase c = toCanonicalCase(context);
            if (c == null) return "";
            JsonNode pre = c.input().path("preorder");
            JsonNode in = c.input().path("inorder");
            java.util.List<String> preChars = new java.util.ArrayList<>();
            if (pre.isArray()) {
                for (JsonNode ch : pre) {
                    preChars.add("'" + ch.asText() + "'");
                }
            }
            java.util.List<String> inChars = new java.util.ArrayList<>();
            if (in.isArray()) {
                for (JsonNode ch : in) {
                    inChars.add("'" + ch.asText() + "'");
                }
            }
            java.util.List<String> lines = new java.util.ArrayList<>();
            lines.add("List<Character> preorder = List.of(" + String.join(", ", preChars) + ");");
            lines.add("List<Character> inorder = List.of(" + String.join(", ", inChars) + ");");
            lines.add("");

            if (c.expected().isObject() && c.expected().has("error")) {
                String error = c.expected().path("error").asText();
                lines.add("assertThatExceptionOfType(IllegalArgumentException.class)");
                lines.add("        .isThrownBy(() -> satellite.treeFromTraversals(preorder, inorder))");
                lines.add("        .withMessage(\"" + JavaTypeFormatter.escapeJavaString(error) + "\");");
            } else {
                java.util.List<String> postChars = new java.util.ArrayList<>();
                java.util.function.Consumer<JsonNode> computePostorder = new java.util.function.Consumer<>() {
                    @Override
                    public void accept(JsonNode node) {
                        if (node == null || node.isNull() || node.isEmpty()) return;
                        accept(node.path("l"));
                        accept(node.path("r"));
                        postChars.add("'" + node.path("v").asText() + "'");
                    }
                };
                computePostorder.accept(c.expected());
                lines.add("Tree tree = satellite.treeFromTraversals(preorder, inorder);");
                lines.add("");
                lines.add("assertThat(tree.preorder()).containsExactlyElementsOf(preorder);");
                lines.add("assertThat(tree.inorder()).containsExactlyElementsOf(inorder);");
                if (postChars.isEmpty()) {
                    lines.add("assertThat(tree.postorder()).isEmpty();");
                } else {
                    lines.add("assertThat(tree.postorder()).containsExactly(" + String.join(", ", postChars) + ");");
                }
            }
            return String.join("\n        ", lines);
        });
    }

    private static exercism.testgenerator.model.CanonicalCase toCanonicalCase(Object context) {
        if (context instanceof exercism.testgenerator.model.CanonicalCase c) return c;
        if (context instanceof exercism.testgenerator.model.RenderedTestCase r) return r.rawCase();
        if (context instanceof JsonNode n) {
            return new exercism.testgenerator.model.CanonicalCase(
                n.path("uuid").asText(""),
                n.path("description").asText(""),
                n.path("property").asText(""),
                n.path("input"),
                n.path("expected"),
                java.util.List.of(),
                java.util.List.of()
            );
        }
        return null;
    }

    private static String breakStringIntoChunks(String text, int indentSpaces) {
        if (text.length() <= 80) {
            return "\"" + JavaTypeFormatter.escapeJavaString(text) + "\"";
        }
        String indent = " ".repeat(indentSpaces);
        StringBuilder sb = new StringBuilder();
        int start = 0;
        boolean first = true;
        while (start < text.length()) {
            int end = Math.min(start + 70, text.length());
            if (end < text.length()) {
                int lastSpace = text.lastIndexOf(' ', end);
                if (lastSpace > start + 30) {
                    end = lastSpace + 1;
                }
            }
            String chunk = text.substring(start, end);
            if (!first) {
                sb.append("\n").append(indent).append("+ ");
            }
            sb.append("\"").append(JavaTypeFormatter.escapeJavaString(chunk)).append("\"");
            first = false;
            start = end;
        }
        return sb.toString();
    }

    private static String formatPointSet(JsonNode pointsNode) {
        if (pointsNode == null || !pointsNode.isArray() || pointsNode.isEmpty()) {
            return "Set.of()";
        }
        java.util.List<String> pts = new java.util.ArrayList<>();
        for (JsonNode pt : pointsNode) {
            pts.add("new Point(" + pt.get(0).asInt() + ", " + pt.get(1).asInt() + ")");
        }
        return "Set.of(" + String.join(", ", pts) + ")";
    }

    private static String formatSgfNode(JsonNode node, int indent) {
        if (node == null || node.isNull()) return "null";
        JsonNode props = node.path("properties");
        JsonNode children = node.path("children");

        boolean hasProps = props.isObject() && !props.isEmpty();
        boolean hasChildren = children.isArray() && !children.isEmpty();

        if (!hasProps && !hasChildren) {
            return "new SgfNode()";
        }

        String propsExpr = formatSgfProperties(props);
        if (!hasChildren) {
            return "new SgfNode(" + propsExpr + ")";
        }

        java.util.List<String> childExprs = new java.util.ArrayList<>();
        for (JsonNode child : children) {
            childExprs.add(formatSgfNode(child, indent + 8));
        }
        if (propsExpr.length() + String.join(", ", childExprs).length() > 50) {
            String childrenList = "List.of(\n                        "
                + String.join(",\n                        ", childExprs)
                + "\n                )";
            return "new SgfNode(\n                " + propsExpr + ",\n                " + childrenList + "\n        )";
        }
        String childrenExpr = "List.of(" + String.join(", ", childExprs) + ")";
        return "new SgfNode(" + propsExpr + ", " + childrenExpr + ")";
    }

    private static String formatSgfProperties(JsonNode props) {
        if (props == null || !props.isObject() || props.isEmpty()) {
            return "Map.of()";
        }
        java.util.List<String> entries = new java.util.ArrayList<>();
        props.fields().forEachRemaining(entry -> {
            String key = "\"" + JavaTypeFormatter.escapeJavaString(entry.getKey()) + "\"";
            java.util.List<String> vals = new java.util.ArrayList<>();
            if (entry.getValue().isArray()) {
                for (JsonNode v : entry.getValue()) {
                    vals.add("\"" + JavaTypeFormatter.escapeJavaString(v.asText()) + "\"");
                }
            }
            entries.add(key + ", List.of(" + String.join(", ", vals) + ")");
        });
        if (entries.size() > 1) {
            return "Map.of(\n                " + String.join(",\n                ", entries) + "\n        )";
        }
        return "Map.of(" + String.join(", ", entries) + ")";
    }

    private static void generateTreeAssertions(JsonNode node, String accessPath, java.util.List<String> lines) {
        int id = node.has("id") ? node.path("id").asInt() : node.path("recordId").asInt();
        JsonNode children = node.path("children");
        java.util.List<String> childIds = new java.util.ArrayList<>();
        if (children.isArray() && !children.isEmpty()) {
            for (JsonNode ch : children) {
                int chId = ch.has("id") ? ch.path("id").asInt() : ch.path("recordId").asInt();
                childIds.add(String.valueOf(chId));
            }
        }
        if (childIds.isEmpty()) {
            lines.add("assertNode(" + accessPath + ", " + id + ");");
        } else {
            lines.add("assertNode(" + accessPath + ", " + id + ", " + String.join(", ", childIds) + ");");
            for (int i = 0; i < children.size(); i++) {
                generateTreeAssertions(children.get(i), accessPath + ".getChildren().get(" + i + ")", lines);
            }
        }
    }

    private static class DotNode {
        final String name;
        final java.util.Map<String, String> attrs;

        DotNode(String name, java.util.Map<String, String> attrs) {
            this.name = name;
            this.attrs = attrs;
        }
    }

    private static class DotEdge {
        final String start;
        final String end;
        final java.util.Map<String, String> attrs;

        DotEdge(String start, String end, java.util.Map<String, String> attrs) {
            this.start = start;
            this.end = end;
            this.attrs = attrs;
        }
    }

    private static void parseDotAttrs(String attrStr, java.util.Map<String, String> target) {
        java.util.regex.Pattern p = java.util.regex.Pattern.compile("([a-zA-Z0-9_]+)=(?:\"([^\"]*)\"|([^,\\s\\]]+))");
        java.util.regex.Matcher m = p.matcher(attrStr);
        while (m.find()) {
            String key = m.group(1);
            String val = m.group(2) != null ? m.group(2) : m.group(3);
            target.put(key, val);
        }
    }

    private static String formatDotMapOf(java.util.Map<String, String> map) {
        java.util.List<String> entries = new java.util.ArrayList<>();
        for (var e : map.entrySet()) {
            entries.add("\"" + e.getKey() + "\", \"" + JavaTypeFormatter.escapeJavaString(e.getValue()) + "\"");
        }
        return "Map.of(" + String.join(", ", entries) + ")";
    }

    private static String translateComputeFunction(String fn) {
        String expr = fn.trim();
        if (expr.startsWith("if ") && expr.contains(" then ") && expr.contains(" else ")) {
            int thenIdx = expr.indexOf(" then ");
            int elseIdx = expr.indexOf(" else ");
            String cond = expr.substring(3, thenIdx).trim();
            String thenPart = expr.substring(thenIdx + 6, elseIdx).trim();
            String elsePart = expr.substring(elseIdx + 6).trim();
            expr = cond + " ? " + thenPart + " : " + elsePart;
        }
        expr = expr.replaceAll("inputs\\[(\\d+)\\]", "list.get($1)");
        return "list -> " + expr;
    }

    private static String jsonNodeToOrgJson(JsonNode node, int indent) {
        String sp = " ".repeat(indent);
        if (node.isObject()) {
            if (node.isEmpty()) return "new JSONObject()";
            StringBuilder sb = new StringBuilder("new JSONObject()");
            var it = node.fields();
            while (it.hasNext()) {
                var entry = it.next();
                String key = entry.getKey().equals("owed_by") ? "owedBy" : entry.getKey();
                sb.append("\n").append(sp).append("        .put(\"").append(key).append("\", ");
                sb.append(jsonNodeToOrgJson(entry.getValue(), indent + 8)).append(")");
            }
            return sb.toString();
        } else if (node.isArray()) {
            if (node.isEmpty()) return "new JSONArray()";
            StringBuilder sb = new StringBuilder("new JSONArray()");
            for (JsonNode item : node) {
                sb.append("\n").append(sp).append("        .put(");
                sb.append(jsonNodeToOrgJson(item, indent + 8)).append(")");
            }
            return sb.toString();
        } else if (node.isTextual()) {
            return "\"" + JavaTypeFormatter.escapeJavaString(node.asText()) + "\"";
        } else if (node.isDouble() || (node.isNumber() && (node.asText().contains(".") || indent > 0))) {
            return String.format(java.util.Locale.US, "%.1f", node.asDouble());
        } else if (node.isIntegralNumber()) {
            return node.asText();
        } else if (node.isBoolean()) {
            return node.asBoolean() ? "true" : "false";
        }
        return "null";
    }

    private static String buildZipperNavPath(JsonNode ops) {
        if (ops == null || !ops.isArray()) return "";
        StringBuilder sb = new StringBuilder();
        for (JsonNode op : ops) {
            sb.append(".").append(op.path("operation").asText());
        }
        return sb.toString();
    }

    private static String formatZipperPrintTree(JsonNode node) {
        if (node == null || node.isNull()) {
            return "null";
        }
        int val = node.path("value").asInt();
        JsonNode left = node.path("left");
        JsonNode right = node.path("right");
        boolean leftNull = left == null || left.isNull();
        boolean rightNull = right == null || right.isNull();

        if (leftNull && rightNull) {
            return "value: " + val + ", left: null, right: null";
        } else if (leftNull) {
            return "value: " + val + ", left: null, right: { " + formatZipperPrintTree(right) + " }";
        } else if (rightNull) {
            return "value: " + val + ", left: { " + formatZipperPrintTree(left) + " }, right: null";
        } else {
            return "value: " + val + ", left: { " + formatZipperPrintTree(left) + " }, right: { " + formatZipperPrintTree(right) + " }";
        }
    }

    private static String breakZipperString(String s) {
        if (s == null) return "\"\"";
        String res = "\"" + JavaTypeFormatter.escapeJavaString(s) + "\"";
        if (res.length() <= 80) return res;
        return res
            .replace(", left: ", ", \" +\n                \"left: ")
            .replace(", right: ", ", \" +\n                \"right: ");
    }

    public String render(RenderedExercise exercise, Path exerciseDirectory) throws IOException {
        Path customTemplatePath = exerciseDirectory.resolve(".meta").resolve("template.hbs");
        Template template;

        if (Files.exists(customTemplatePath)) {
            String templateSource = Files.readString(customTemplatePath, StandardCharsets.UTF_8);
            template = handlebars.compileInline(templateSource);
        } else {
            // Load default template from classpath
            try (InputStream in = getClass().getResourceAsStream("/templates/default.hbs")) {
                if (in == null) {
                    throw new IOException("Default template '/templates/default.hbs' not found on classpath");
                }
                String defaultSource = new String(in.readAllBytes(), StandardCharsets.UTF_8);
                template = handlebars.compileInline(defaultSource);
            }
        }

        Context context = Context.newBuilder(exercise)
            .resolver(
                JsonNodeValueResolver.INSTANCE,
                MethodValueResolver.INSTANCE,
                FieldValueResolver.INSTANCE,
                JavaBeanValueResolver.INSTANCE,
                MapValueResolver.INSTANCE
            )
            .build();

        String rawRendered = template.apply(context);
        return cleanJavaFormatting(rawRendered);
    }

    public static String cleanJavaFormatting(String javaCode) {
        if (javaCode == null) return null;
        String text = javaCode.replace("\r\n", "\n").replace("\r", "\n");
        String[] lines = text.split("\n", -1);

        for (int i = 0; i < lines.length; i++) {
            lines[i] = lines[i].stripTrailing();
        }

        java.util.List<String> result = new java.util.ArrayList<>();
        boolean prevWasAnnotation = false;

        for (int i = 0; i < lines.length; i++) {
            String line = lines[i];
            String trimmed = line.trim();

            if (trimmed.isEmpty()) {
                if (prevWasAnnotation) {
                    int nextIdx = i + 1;
                    while (nextIdx < lines.length && lines[nextIdx].trim().isEmpty()) {
                        nextIdx++;
                    }
                    if (nextIdx < lines.length) {
                        String nextTrimmed = lines[nextIdx].trim();
                        if (nextTrimmed.startsWith("@") || nextTrimmed.startsWith("public ")
                                || nextTrimmed.startsWith("void ") || nextTrimmed.startsWith("private ")
                                || nextTrimmed.startsWith("protected ") || nextTrimmed.startsWith("default ")) {
                            continue;
                        }
                    }
                }

                if (!result.isEmpty() && result.get(result.size() - 1).isEmpty()) {
                    continue;
                }
                result.add(line);
                prevWasAnnotation = false;
            } else {
                result.add(line);
                prevWasAnnotation = trimmed.startsWith("@");
            }
        }

        while (!result.isEmpty() && result.get(result.size() - 1).isEmpty()) {
            result.remove(result.size() - 1);
        }
        return String.join("\n", result) + "\n";
    }
}
