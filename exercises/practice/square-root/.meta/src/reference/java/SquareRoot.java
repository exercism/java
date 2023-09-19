public class SquareRoot {
    /**
     * Finds the square root of the given radicand using digit-by-digit calculation.
     *
     * @param radicand a natural number
     * @return square root of the given radicand
     * @see <a href="https://en.wikipedia.org/wiki/Methods_of_computing_square_roots#Binary_numeral_system_(base_2)">
     * Source on Wikipedia
     * </a>
     */
    public int squareRoot(int radicand) {
        int x = radicand;
        int c = 0;
        int d = 1 << 30;

        while (d > radicand) {
            d >>= 2;
        }

        while (d != 0) {
            if (x >= c + d) {
                x -= c + d;
                c = (c >> 1) + d;
            } else {
                c >>= 1;
            }
            d >>= 2;
        }

        return c;
    }
}
