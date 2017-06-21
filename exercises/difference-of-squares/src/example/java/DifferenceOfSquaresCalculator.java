import java.util.stream.IntStream;

final class DifferenceOfSquaresCalculator {

    double computeSquareOfSumTo(final int input) {
        final double sum = input * (input + 1) / 2;
        return Math.pow(sum, 2);
    }

    double computeSumOfSquaresTo(final int input) {
        return IntStream.rangeClosed(1, input)
                .mapToDouble(value -> value)
                .map(i -> Math.pow(i, 2))
                .sum();
    }

    double computeDifferenceOfSquares(final int input) {
        return computeSquareOfSumTo(input) - computeSumOfSquaresTo(input);
    }

}
