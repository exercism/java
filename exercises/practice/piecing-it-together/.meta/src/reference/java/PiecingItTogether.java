import java.util.*;

public class PiecingItTogether {
    private static final double DOUBLE_EQUALITY_TOLERANCE = 1e-9;
    private static final int MAX_DIMENSION = 1000;

    public static JigsawInfo getCompleteInformation(JigsawInfo input) {
        List<JigsawInfo> validGuesses = new ArrayList<>();

        if (input.getPieces().isPresent()) {
            // If pieces is known, we only test divisors of pieces
            int pieces = input.getPieces().getAsInt();
            for (int rows = 1; rows <= pieces; rows++) {
                if (pieces % rows != 0) {
                    continue;
                }
                int columns = pieces / rows;
                createValidJigsaw(rows, columns, input).ifPresent(validGuesses::add);
            }
        } else if (input.getInside().isPresent() && input.getInside().getAsInt() > 0) {
            // If inside pieces is non-zero, we only test divisors of inside
            int inside = input.getInside().getAsInt();
            for (int innerRows = 1; innerRows <= inside; innerRows++) {
                if (inside % innerRows != 0) {
                    continue;
                }
                int innerColumns = inside / innerRows;
                createValidJigsaw(innerRows + 2, innerColumns + 2, input).ifPresent(validGuesses::add);
            }
        } else {
            // Brute force using border constraint if available
            int maxDimension = input.getBorder().isPresent()
                    ? Math.min(input.getBorder().getAsInt(), MAX_DIMENSION)
                    : MAX_DIMENSION;

            for (int rows = 1; rows <= maxDimension; rows++) {
                for (int columns = 1; columns <= maxDimension; columns++) {
                    createValidJigsaw(rows, columns, input).ifPresent(validGuesses::add);
                }
            }
        }

        if (validGuesses.size() == 1) {
            return validGuesses.get(0);
        } else if (validGuesses.size() > 1) {
            throw new IllegalArgumentException("Insufficient data");
        } else {
            throw new IllegalArgumentException("Contradictory data");
        }
    }

    private static String getFormatFromAspect(double aspectRatio) {
        if (Math.abs(aspectRatio - 1.0) < DOUBLE_EQUALITY_TOLERANCE) {
            return "square";
        } else if (aspectRatio < 1.0) {
            return "portrait";
        } else {
            return "landscape";
        }
    }

    private static JigsawInfo fromRowsAndCols(int rows, int columns) {
        int pieces = rows * columns;
        int border = (rows == 1 || columns == 1) ? pieces : 2 * (rows + columns - 2);
        int inside = pieces - border;
        double aspectRatio = (double) columns / rows;
        String format = getFormatFromAspect(aspectRatio);

        return new JigsawInfo.Builder()
                .pieces(pieces)
                .border(border)
                .inside(inside)
                .rows(rows)
                .columns(columns)
                .aspectRatio(aspectRatio)
                .format(format)
                .build();
    }

    /**
     * Verifies that all known values in the input match those in the computed result.
     * Returns false if any known value conflicts, true if all values are consistent.
     *
     * @param computed the fully inferred jigsaw information
     * @param input    the original partial input with possibly empty values
     * @return true if all values are consistent, false if any conflict exists
     */
    private static boolean isConsistent(JigsawInfo computed, JigsawInfo input) {
        return valuesMatch(computed.getPieces(), input.getPieces()) &&
                valuesMatch(computed.getBorder(), input.getBorder()) &&
                valuesMatch(computed.getInside(), input.getInside()) &&
                valuesMatch(computed.getRows(), input.getRows()) &&
                valuesMatch(computed.getColumns(), input.getColumns()) &&
                valuesMatch(computed.getAspectRatio(), input.getAspectRatio()) &&
                valuesMatch(computed.getFormat(), input.getFormat());
    }

    /**
     * Attempts to construct a valid jigsaw configuration using the specified number of rows and columns.
     * Returns a valid result only if the configuration is consistent with the input.
     *
     * @param rows    number of rows to try
     * @param columns number of columns to try
     * @param input   the original input to check for consistency
     * @return an Optional containing a valid configuration, or empty if inconsistent
     */
    private static Optional<JigsawInfo> createValidJigsaw(int rows, int columns, JigsawInfo input) {
        JigsawInfo candidate = fromRowsAndCols(rows, columns);
        return isConsistent(candidate, input) ? Optional.of(candidate) : Optional.empty();
    }

    private static <T> boolean valuesMatch(Optional<T> a, Optional<T> b) {
        if (a.isPresent() && b.isPresent()) {
            return Objects.equals(a.get(), b.get());
        }

        return true;
    }

    private static boolean valuesMatch(OptionalInt a, OptionalInt b) {
        if (a.isPresent() && b.isPresent()) {
            return a.getAsInt() == b.getAsInt();
        }

        return true;
    }

    private static boolean valuesMatch(OptionalDouble a, OptionalDouble b) {
        if (a.isPresent() && b.isPresent()) {
            return Double.compare(a.getAsDouble(), b.getAsDouble()) == 0;
        }

        return true;
    }
}
