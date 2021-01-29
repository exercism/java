import java.util.*;

final class BracketChecker {

    private static final Map<Character, Character> BRACKET_PAIR_MAP = new HashMap<Character, Character>() {
        { put('[', ']'); put('{', '}'); put('(', ')'); }
    };

    private static boolean isOpeningBracket(final char character) {
        return BRACKET_PAIR_MAP.containsKey(character);
    }

    private static boolean isClosingBracket(final char character) {
        return BRACKET_PAIR_MAP.values().contains(character);
    }

    private final String expression;

    BracketChecker(final String expression) {
        this.expression = expression;
    }

    boolean areBracketsMatchedAndNestedCorrectly() {
        final Stack<Character> bracketsStack = new Stack<>();

        for (final char character : expression.toCharArray()) {
            if (isOpeningBracket(character)) {
                bracketsStack.push(character);
            } else if (isClosingBracket(character)) {
                if (bracketsStack.isEmpty()) {
                    return false;
                }

                if (!BRACKET_PAIR_MAP.get(bracketsStack.pop()).equals(character)) {
                    return false;
                }
            }
        }

        return bracketsStack.isEmpty();
    }

}
