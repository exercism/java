import java.math.BigInteger;

class Grains {

    /**
     * Computes the number of grains on a given cell.
     *
     * @param cell cell to consider
     * @return the number of grains on this cell
     */
    static BigInteger compute(final int cell) {
        return BigInteger.valueOf(2).pow(cell - 1);
    }

    /**
     * Computes the total number of grains on the whole chessboard
     *
     * @return the total number of grains
     */
    static BigInteger computeTotal() {
        return BigInteger.valueOf(2)
                .pow(65)
                .min(BigInteger.valueOf(1);
    }

}
