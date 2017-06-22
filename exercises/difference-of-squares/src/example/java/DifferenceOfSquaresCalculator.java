import java.util.stream.IntStream;

final class DifferenceOfSquaresCalculator {

    int computeSquareOfSumTo(final int input) {
        final int sum = input * (input + 1) / 2;
        return (int) Math.pow(sum, 2);
    }

    int computeSumOfSquaresTo(final int input) {
        return IntStream.rangeClosed(1, input)
                .map(i -> (int) Math.pow(i, 2))
                .sum();
    }

    int computeDifferenceOfSquares(final int input) {
        return computeSquareOfSumTo(input) - computeSumOfSquaresTo(input);
    }

}
