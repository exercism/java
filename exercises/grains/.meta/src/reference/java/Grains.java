import java.math.BigInteger;
import java.util.stream.IntStream;

class Grains {

    static BigInteger computeNumberOfGrainsOnSquare(final int square) {
        if (1 <= square  && square <= 64) {
            return BigInteger.valueOf(2).pow(square - 1);
        } else {
            throw new IllegalArgumentException("square must be between 1 and 64");
        }
    }

    static BigInteger computeTotalNumberOfGrainsOnBoard() {
        return IntStream.rangeClosed(1, 64)
                .mapToObj(Grains::computeNumberOfGrainsOnSquare)
                .reduce(
                        BigInteger.valueOf(0),
                        BigInteger::add);
        // Note that the following is also correct, using the sum of the elements of a geometric series
        // https://en.wikipedia.org/wiki/Geometric_progression#Geometric_series
        // return BigInteger.valueOf(2).pow(64).subtract(BigInteger.valueOf(1));
    }

}
