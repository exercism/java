import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

final class LuhnValidator {

    private static final Pattern SPACE_PATTERN = Pattern.compile("\\s+");

    boolean isValid(final String candidate) {
        final String sanitizedCandidate = SPACE_PATTERN.matcher(candidate).replaceAll("");

        if (sanitizedCandidate.length() <= 1) {
            return false;
        }

        // We need to alter every second digit counting from the right. Reversing makes this easy!
        final String reversedSanitizedCandidate = reverse(sanitizedCandidate);

        final List<Integer> computedDigits = new ArrayList<>();

        for (int charIndex = 0; charIndex < reversedSanitizedCandidate.length(); charIndex++) {
            int inputDigit = Character.digit(reversedSanitizedCandidate.charAt(charIndex), 10);

            /*
             * Character.digit returns a negative int if the supplied character does not represent a digit with respect
             * to the given radix.
             */
            if (inputDigit < 0) {
                return false;
            }

            if (charIndex % 2 == 1) {
                inputDigit = 2 * inputDigit;

                if (inputDigit > 9) {
                    inputDigit -= 9;
                }
            }

            computedDigits.add(inputDigit);
        }

        final int digitSum = computedDigits.stream().mapToInt(Integer::intValue).sum();
        return digitSum % 10 == 0;
    }

    private String reverse(final String string) {
        return new StringBuilder(string).reverse().toString();
    }

}
