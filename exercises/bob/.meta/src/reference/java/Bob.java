/**
 * Bob is a lackadasical teenager.
 */
class Bob {
    String hey(String input) {
        input = normalize(input);
        if (isSilence(input)) {
            return "Fine. Be that way!";
        }
        if (isShout(input) && isQuestion(input)) {
            return "Calm down, I know what I'm doing!";
        }
        if (isShout(input)) {
            return "Whoa, chill out!";
        }
        if (isQuestion(input)) {
            return "Sure.";
        }
        return "Whatever.";
    }

    private static String normalize(String input) {
        return input.trim();
    }

    private static boolean isSilence(String input) {
        return input.equals("");
    }

    private static boolean isShout(String input) {
        final String upperCased = input.toUpperCase();
        final String lowerCased = input.toLowerCase();
        final boolean containsSomeLetters = !lowerCased.equals(upperCased);
        final boolean isAllUpperCase = upperCased.equals(input);
        return (containsSomeLetters && isAllUpperCase);
    }

    private static boolean isQuestion(String input) {
        return input.endsWith("?");
    }
}
