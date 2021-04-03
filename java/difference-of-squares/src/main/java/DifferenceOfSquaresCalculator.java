import java.util.stream.IntStream;
import java.lang.Math;


class DifferenceOfSquaresCalculator {

    int computeSquareOfSumTo(int input) {
        return (int) Math.pow(IntStream.rangeClosed(1, input).sum(), 2);
    }

    int computeSumOfSquaresTo(int input) {
        return IntStream.rangeClosed(1, input).map(n-> (int) Math.pow(n, 2)).sum();
    }

    int computeDifferenceOfSquares(int input) {
        return computeSquareOfSumTo(input) - computeSumOfSquaresTo(input);
    }

}
