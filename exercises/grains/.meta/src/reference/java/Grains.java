import java.math.BigInteger;
import java.util.stream.IntStream;

class Grains {

    BigInteger onSquare(final int square) {
        if (1 <= square  && square <= 64) {
            return BigInteger.valueOf(2).pow(square - 1);
        } else {
            throw new IllegalArgumentException("square must be between 1 and 64");
        }
    }

    BigInteger onBoard() {
        return IntStream.rangeClosed(1, 64)
                .mapToObj(this::onSquare)
                .reduce(
                        BigInteger.valueOf(0),
                        BigInteger::add);
    }

}
