import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

final class Matrix {

    private final List<List<Integer>> values;

    Matrix(final List<List<Integer>> values) {
        this.values = values;
    }

    Set<MatrixCoordinate> getSaddlePoints() {
        final Set<MatrixCoordinate> result = new HashSet<>();

        if (values.isEmpty()) {
            return result;
        }

        for (int row = 0; row < values.size(); row++) {
            for (int column = 0; column < values.get(0).size(); column++) {
                final int coordinateValue = values.get(row).get(column);

                if (coordinateValue == getRowMax(row) && coordinateValue == getColumnMin(column)) {
                    result.add(new MatrixCoordinate(row + 1, column + 1));
                }
            }
        }

        return result;
    }

    private int getRowMax(final int row) {
        return Collections.max(values.get(row));
    }

    private int getColumnMin(final int column) {
        return values.stream()
            .map(row -> row.get(column))
            .min(Integer::compareTo)
            .orElseThrow(() -> new IllegalArgumentException("Column cannot be empty"));
    }

}
