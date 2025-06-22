import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class PiecingItTogether {
    private final double epsilon = 1e-6;

    public PartialJigsawInformation getCompleteInformation(PartialJigsawInformation input) {
        Integer rows = input.getRows().orElse(null);
        Integer cols = input.getColumns().orElse(null);
        Integer pieces = input.getPieces().orElse(null);
        Integer border = input.getBorder().orElse(null);
        Integer inside = input.getInside().orElse(null);
        Double aspect = input.getAspectRatio().orElse(null);
        String format = input.getFormat().orElse(null);

        // Final information to be compared with the original input to detect inconsistencies
        PartialJigsawInformation result = null;

        // Check format and aspect ratio don't contradict each other or set aspect if format is square
        if (format != null && aspect != null) {
            if (!format.equals(getFormatFromAspect(aspect))) {
                throw new IllegalArgumentException("Contradictory data");
            }
        } else if ("square".equalsIgnoreCase(format)) {
            aspect = 1.0;
        }

        // Derive any missing value among pieces, border, and inside
        if (pieces != null && border != null && inside != null) {
            if (pieces != border + inside) {
                throw new IllegalArgumentException("Contradictory data");
            }
        } else if (pieces != null && border != null) {
            inside = pieces - border;
        } else if (border != null && inside != null) {
            pieces = border + inside;
        } else if (inside != null && pieces != null) {
            border = pieces - inside;
        }

        // Try to compute missing information using the numbers of rows and cols
        if (rows != null && cols != null) {
            result = fromRowsAndCols(rows, cols);
        } else if (rows != null) {
            Optional<Integer> possibleCols = calculateOtherSide(rows, true, pieces, border, inside, aspect);

            if (possibleCols.isPresent()) {
                cols = possibleCols.get();
                result = fromRowsAndCols(rows, cols);
            }
        } else if (cols != null) {
            Optional<Integer> possibleRows = calculateOtherSide(cols, false, pieces, border, inside, aspect);

            if (possibleRows.isPresent()) {
                rows = possibleRows.get();
                result = fromRowsAndCols(rows, cols);
            }
        }

        if (result != null) {
            checkConsistencyOrThrow(result, input);
            return result;
        }

        // Try to compute missing information using the value of aspect ratio
        if (aspect != null) {
            if (pieces != null) {
                double actualRows = Math.sqrt(pieces / aspect);
                rows = roundIfClose(actualRows);

                double actualCols = aspect * rows;
                cols = roundIfClose(actualCols);

                result = fromRowsAndCols(rows, cols);
                checkConsistencyOrThrow(result, input);
                return result;
            } else if (inside != null && inside == 0) {
                List<PartialJigsawInformation> validGuesses = new ArrayList<>();

                for (int fixed : List.of(1, 2)) {
                    tryGuessWithFixedSide(fixed, true, aspect, input).ifPresent(validGuesses::add);  // rows = fixed
                    tryGuessWithFixedSide(fixed, false, aspect, input).ifPresent(validGuesses::add); // cols = fixed
                }

                if (validGuesses.size() == 1) {
                    return validGuesses.getFirst();
                } else if (validGuesses.size() > 1) {
                    throw new IllegalArgumentException("Insufficient data");
                } else {
                    throw new IllegalArgumentException("Contradictory data");
                }
            }
        }

        if (pieces == null && border == null && (inside == null || inside == 0)) {
            throw new IllegalArgumentException("Insufficient data");
        }

        // Brute force as a last resort
        List<PartialJigsawInformation> validGuesses = new ArrayList<>();

        // Brute-force using pieces
        if (pieces != null) {
            for (int r = 1; r <= pieces; r++) {
                if (pieces % r != 0) {
                    continue; // cols must be integer
                }

                int c = pieces / r;
                tryGuess(r, c, input).ifPresent(validGuesses::add);
            }
        } else if (inside != null) {
            for (int r = 3; r <= inside + 2; r++) {
                int innerRows = r - 2;
                if (inside % innerRows != 0) {
                    continue;
                }

                int innerCols = inside / innerRows;
                int c = innerCols + 2;

                tryGuess(r, c, input).ifPresent(validGuesses::add);
            }
        } else {
            int max = Math.min(border, 1000);

            for (int r = 1; r <= max; r++) {
                for (int c = 1; c <= max; c++) {
                    tryGuess(r, c, input).ifPresent(validGuesses::add);
                }
            }
        }

        if (validGuesses.size() == 1) {
            return validGuesses.getFirst();
        } else if (validGuesses.size() > 1) {
            throw new IllegalArgumentException("Insufficient data");
        } else {
            throw new IllegalArgumentException("Contradictory data");
        }
    }

    private String getFormatFromAspect(double aspectRatio) {
        String format;

        if (Math.abs(aspectRatio - 1.0) < epsilon) {
            format = "square";
        } else if (aspectRatio < 1.0) {
            format = "portrait";
        } else {
            format = "landscape";
        }

        return format;
    }

    private Integer roundIfClose(double value) {
        double rounded = Math.round(value);

        if (Math.abs(value - rounded) < epsilon) {
            return (int) rounded;
        }

        throw new IllegalArgumentException("Contradictory data");
    }

    private int calculateOtherSideFromPieces(int knownSide, int pieces) {
        if (pieces <= 0 || pieces % knownSide != 0) {
            throw new IllegalArgumentException("Contradictory data");
        }

        return pieces / knownSide;
    }

    private int calculateOtherSideFromBorder(int knownSide, int border) {
        if (knownSide == 1) {
            return border;
        }

        if (knownSide == border) {
            return 1;
        }

        if ((border + 4 <= 2 * knownSide) || border % 2 != 0) {
            throw new IllegalArgumentException("Contradictory data");
        }

        return ((border + 4) - 2 * knownSide) / 2;
    }

    private int calculateOtherSideFromInside(int knownSide, int inside) {
        if (knownSide <= 2 || inside % (knownSide - 2) != 0) {
            throw new IllegalArgumentException("Contradictory data");
        }

        return (inside / (knownSide - 2)) + 2;
    }

    private Optional<Integer> calculateOtherSide(int knownSide, boolean isRowKnown, Integer pieces, Integer border, Integer inside, Double aspect) {
        if (pieces != null) {
            return Optional.of(calculateOtherSideFromPieces(knownSide, pieces));
        } else if (border != null) {
            return Optional.of(calculateOtherSideFromBorder(knownSide, border));
        } else if (aspect != null) {
            double raw = isRowKnown ? knownSide * aspect : knownSide / aspect;
            return Optional.of(roundIfClose(raw));
        } else if (inside != null) {
            if (inside == 0) {
                // When inside is zero and all other values (otherSide, pieces, border, aspect) are unknown,
                // it only tells us that either rows or cols is 1 or 2, but provides no way to infer the rest.
                // Since we can't make any further assumptions, we stop here.
                throw new IllegalArgumentException("Insufficient data");
            }

            return Optional.of(calculateOtherSideFromInside(knownSide, inside));
        }

        return Optional.empty();
    }

    private PartialJigsawInformation fromRowsAndCols(int rows, int cols) {
        int pieces = rows * cols;
        int border = (rows == 1 || cols == 1) ? pieces : 2 * (rows + cols - 2);
        int inside = pieces - border;
        double aspect = (double) cols / rows;
        String format = getFormatFromAspect(aspect);

        return new PartialJigsawInformation(pieces, border, inside, rows, cols, aspect, format);
    }

    /**
     * Verifies that all known values in the input match those in the computed result.
     * If any known value in the input contradicts the corresponding computed value,
     * an IllegalArgumentException is thrown.
     *
     * @param computed the fully inferred jigsaw information
     * @param input    the original partial input with possibly known values
     * @throws IllegalArgumentException if any known value in the input conflicts with the computed result
     */
    public void checkConsistencyOrThrow(PartialJigsawInformation computed, PartialJigsawInformation input) {
        if (!valuesMatch(computed.getPieces(), input.getPieces()) || !valuesMatch(computed.getBorder(), input.getBorder()) || !valuesMatch(computed.getInside(), input.getInside()) || !valuesMatch(computed.getRows(), input.getRows()) || !valuesMatch(computed.getColumns(), input.getColumns()) || !valuesMatch(computed.getAspectRatio(), input.getAspectRatio()) || !valuesMatch(computed.getFormat(), input.getFormat())) {
            throw new IllegalArgumentException("Contradictory data");
        }
    }

    /**
     * Attempts to compute a valid jigsaw configuration by fixing one dimension
     * (either rows or columns) and inferring the other using the aspect ratio.
     *
     * @param fixed      the known size of one side (either rows or columns)
     * @param isRowFixed true if the fixed value represents rows, false if columns
     * @param aspect     the desired aspect ratio (cols / rows)
     * @param input      the original input to check for consistency
     * @return an Optional containing a valid inferred configuration, or empty if the guess is invalid
     */
    private Optional<PartialJigsawInformation> tryGuessWithFixedSide(int fixed, boolean isRowFixed, double aspect, PartialJigsawInformation input) {
        try {
            int other = isRowFixed ? roundIfClose(fixed * aspect) : roundIfClose(fixed / aspect);

            int rows = isRowFixed ? fixed : other;
            int cols = isRowFixed ? other : fixed;

            PartialJigsawInformation guess = fromRowsAndCols(rows, cols);
            checkConsistencyOrThrow(guess, input);
            return Optional.of(guess);
        } catch (IllegalArgumentException ignored) {
            return Optional.empty();
        }
    }

    /**
     * Attempts to construct a jigsaw configuration using the specified number of rows and columns.
     * Returns a valid result only if the configuration is consistent with the input.
     *
     * @param rows  number of rows to try
     * @param cols  number of columns to try
     * @param input the original input to check for consistency
     * @return an Optional containing a valid configuration, or empty if inconsistent
     */
    private Optional<PartialJigsawInformation> tryGuess(int rows, int cols, PartialJigsawInformation input) {
        try {
            PartialJigsawInformation guess = fromRowsAndCols(rows, cols);
            checkConsistencyOrThrow(guess, input);
            return Optional.of(guess);
        } catch (IllegalArgumentException ignored) {
            return Optional.empty();
        }
    }

    /**
     * Compares two optional values for equality.
     * Returns true if either value is absent, or if both are present and equal.
     * Used to check consistency between inferred and input data.
     *
     * @param a   the first optional value
     * @param b   the second optional value
     * @param <T> the type of the contained values
     * @return true if the values are consistent (both missing or equal if present), false otherwise
     */
    private <T> boolean valuesMatch(Optional<T> a, Optional<T> b) {
        if (a.isPresent() && b.isPresent()) {
            return Objects.equals(a.get(), b.get());
        }

        return true;
    }
}