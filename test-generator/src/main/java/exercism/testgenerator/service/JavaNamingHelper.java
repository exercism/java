package exercism.testgenerator.service;

import java.util.Set;

public class JavaNamingHelper {

    private static final Set<String> JAVA_KEYWORDS = Set.of(
        "abstract", "assert", "boolean", "break", "byte", "case", "catch", "char",
        "class", "const", "continue", "default", "do", "double", "else", "enum",
        "extends", "final", "finally", "float", "for", "goto", "if", "implements",
        "import", "instanceof", "int", "interface", "long", "native", "new", "package",
        "private", "protected", "public", "return", "short", "static", "strictfp",
        "super", "switch", "synchronized", "this", "throw", "throws", "transient",
        "try", "void", "volatile", "while", "record", "sealed", "permits", "yield",
        "var"
    );

    public static String toMethodName(String description) {
        if (description == null || description.isBlank()) {
            return "testMethod";
        }

        // Replace non-alphanumeric characters with spaces
        StringBuilder cleaned = new StringBuilder();
        for (char c : description.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                cleaned.append(c);
            } else {
                cleaned.append(' ');
            }
        }

        String[] parts = cleaned.toString().trim().split("\\s+");
        if (parts.length == 0 || parts[0].isEmpty()) {
            return "testMethod";
        }

        StringBuilder methodName = new StringBuilder();
        for (int i = 0; i < parts.length; i++) {
            String part = parts[i];
            if (part.isEmpty()) {
                continue;
            }
            if (methodName.length() == 0) {
                methodName.append(part.toLowerCase());
            } else {
                methodName.append(Character.toUpperCase(part.charAt(0)));
                if (part.length() > 1) {
                    methodName.append(part.substring(1).toLowerCase());
                }
            }
        }

        String result = methodName.toString();
        // If it starts with digit or is not a valid Java identifier start
        if (result.isEmpty() || !Character.isJavaIdentifierStart(result.charAt(0))) {
            result = "test" + Character.toUpperCase(result.charAt(0)) + (result.length() > 1 ? result.substring(1) : "");
        }

        // If it is a keyword, prefix with "test"
        if (JAVA_KEYWORDS.contains(result)) {
            result = "test" + Character.toUpperCase(result.charAt(0)) + result.substring(1);
        }

        // Cap method name length so that 'public void methodName() {' stays well within 120 chars
        if (result.length() > 65) {
            result = result.substring(0, 65);
        }

        return result;
    }

    public static String toPascalCase(String slug) {
        if (slug == null || slug.isBlank()) {
            return "";
        }
        String[] parts = slug.split("[-_\\s]+");
        StringBuilder sb = new StringBuilder();
        for (String part : parts) {
            if (!part.isEmpty()) {
                sb.append(Character.toUpperCase(part.charAt(0)));
                if (part.length() > 1) {
                    sb.append(part.substring(1).toLowerCase());
                }
            }
        }
        return sb.toString();
    }
}
