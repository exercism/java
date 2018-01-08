import java.util.Arrays;

final class BaseConverter {

    private static final int MINIMUM_VALID_BASE = 2;

    private static final String INVALID_BASE_ERROR_MESSAGE = "Bases must be at least 2.";

    private final int numeral;

    BaseConverter(final int originalBase, final int[] originalDigits) {
        validateInputs(originalBase, originalDigits);
        this.numeral = computeNumeral(originalBase, originalDigits);
    }

    int[] convertToBase(final int newBase) {
        if (newBase < MINIMUM_VALID_BASE) {
            throw new IllegalArgumentException(INVALID_BASE_ERROR_MESSAGE);
        }

        final int largestExponent = computeLargestExponentForBase(newBase);
        final int[] result = new int[largestExponent + 1];
        int remainder = numeral;

        for (int currentExponent = largestExponent; currentExponent >= 0; currentExponent--) {
            final int coefficient = (int) Math.floor(remainder / Math.pow(newBase, currentExponent));

            result[largestExponent - currentExponent] = coefficient;

            remainder -= coefficient * Math.pow(newBase, currentExponent);
        }

        return result;
    }

    private void validateInputs(final int originalBase, final int[] originalDigits) {
        if (originalBase < MINIMUM_VALID_BASE) {
            throw new IllegalArgumentException(INVALID_BASE_ERROR_MESSAGE);
        }

        if (originalDigits.length == 0) {
            return;
        }

        if (Arrays.stream(originalDigits).min().getAsInt() < 0) {
            throw new IllegalArgumentException("Digits may not be negative.");
        }

        if (Arrays.stream(originalDigits).max().getAsInt() >= originalBase) {
            throw new IllegalArgumentException("All digits must be strictly less than the base.");
        }
    }

    private int computeNumeral(final int originalBase, final int[] originalDigits) {
        int result = 0;

        final int largestExponent = originalDigits.length - 1;

        for (int currentExponent = largestExponent; currentExponent >= 0; currentExponent--) {
            result += originalDigits[largestExponent - currentExponent] * Math.pow(originalBase, currentExponent);
        }

        return result;
    }

    private int computeLargestExponentForBase(final int newBase) {
        int result = 0;

        while (Math.pow(newBase, result + 1) < numeral) {
            result += 1;
        }

        return result;
    }

}
