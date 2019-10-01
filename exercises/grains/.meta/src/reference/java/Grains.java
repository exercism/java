import java.math.BigInteger;
import java.util.stream.IntStream;

class Grains {

    /**
     * Computes the number of grains on a given cell.
     *
     * @param cell cell to consider
     * @return the number of grains on this cell
     */
    static BigInteger compute(final int cell) {
        if (1 <= cell  && cell <= 64) {
            return BigInteger.valueOf(2).pow(cell - 1);
        } else {
            throw new IllegalArgumentException("square must be between 1 and 64");
        }
    }

    /**
     * Computes the total number of grains on the whole chessboard
     *
     * @return the total number of grains
     */
    static BigInteger computeTotal() {
        return IntStream.rangeClosed(1, 64)
                .mapToObj(Grains::compute)
                .reduce(
                        BigInteger.valueOf(0),
                        BigInteger::add);
    }

}
