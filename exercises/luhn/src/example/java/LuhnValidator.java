import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

final class LuhnValidator {

    private static final Pattern SPACE_PATTERN = Pattern.compile("\\s+");

    boolean isValid(final String candidate) {
        final String sanitizedCandidate = SPACE_PATTERN.matcher(candidate).replaceAll("");

        final List<Integer> computedDigits = new ArrayList<>();

        for (int charIndex = 0; charIndex < sanitizedCandidate.length(); charIndex++) {
            int inputDigit = Character.digit(sanitizedCandidate.charAt(charIndex), 10);

            /*
             * Character.digit returns a negative int if the supplied character does not represent a digit with respect
             * to the given radix.
             */
            if (inputDigit < 0) {
                return false;
            }

            if (charIndex % 2 == 1) {
                /*
                 * Since our doubled input digit must lie in [2, 18], the operation
                 *
                 *   "subtract 9 from the doubled input digit if it exceeds 9 in value"
                 *
                 * is equivalent to applying the modulo operation below universally.
                 */
                inputDigit = (2 * inputDigit) % 9;
            }

            computedDigits.add(inputDigit);
        }

        final int digitSum = computedDigits.stream().mapToInt(Integer::intValue).sum();
        return digitSum > 0 && digitSum % 10 == 0;
    }

}
