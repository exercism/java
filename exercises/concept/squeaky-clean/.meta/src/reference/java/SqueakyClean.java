import java.util.Map;
import java.util.HashMap;

class SqueakyClean {
    private static Map<Character, Character> leetSpeakMap = new HashMap<>() {{
            put('3', 'e');
            put('4', 'a');
            put('0', 'o');
            put('1', 'l');
            put('7', 't');
        }};

    static String clean(String identifier) {
        final StringBuilder cleanIdentifier = new StringBuilder();
        boolean kebab = false;
        for (int i = 0; i < identifier.length(); i++) {
            final char ch = identifier.charAt(i);
            if (Character.isSpaceChar(ch)) {
                cleanIdentifier.append("_");
            } else if (Character.isDigit(ch)) {
                cleanIdentifier.append(leetSpeakMap.get(ch));
            } else if (ch == '-') {
                kebab = true;
            } else if (Character.isLetter(ch)) {
                cleanIdentifier.append(
                        kebab ? Character.toUpperCase(ch) : ch
                );
                kebab = false;
            }
        }
        return cleanIdentifier.toString();
    }
}
