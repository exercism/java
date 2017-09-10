import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class DiamondPrinter {

    private static final int A_INT = (int) 'A';

    private static String blank(final int length) {
        return String.join("", Collections.nCopies(length, " "));
    }

    private static String reverse(final String string) {
        return new StringBuilder(string).reverse().toString();
    }

    List<String> printToList(final char chr) {
        final int nRows = 2 * ((int) chr - A_INT) + 1;

        final List<String> result = new ArrayList<>();

        // Populate the top rows.
        for (int nRow = 0; nRow < (nRows + 1) / 2; nRow++) {
            final char rowChr = (char) (A_INT + nRow);

            final String leftHalfOfRow  = blank((nRows - 1) / 2 - nRow) + rowChr + blank(nRow);
            final String rightHalfOfRow = reverse(leftHalfOfRow.substring(0, leftHalfOfRow.length() - 1));
            final String fullRow        = leftHalfOfRow + rightHalfOfRow;

            result.add(fullRow);
        }

        // Populate the bottom rows by 'reflecting' the top rows.
        for (int nRow = (nRows - 1) / 2 - 1; nRow >= 0; nRow--) {
            result.add(result.get(nRow));
        }

        return result;
    }

}
