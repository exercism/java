import java.util.regex.Pattern;

class Matrix {
    private int[][] matrix;
    private static Pattern spacePattern = Pattern.compile(" ");
    private static Pattern newlinePattern = Pattern.compile("\\n");

    Matrix(String matrixAsString) {
        String[] rows = newlinePattern.split(matrixAsString);
        matrix = new int[rows.length][];
        for (int i = 0; i < rows.length; i++) {
            String[] columnValues = spacePattern.split(rows[i]);
            matrix[i] = new int[columnValues.length];
            for (int j = 0; j < columnValues.length; j++) {
                matrix[i][j] = Integer.parseInt(columnValues[j]);
            }
        }
    }

    int[] getRow(int rowNumber) {
        return matrix[rowNumber];
    }

    int[] getColumn(int columnNumber) {
        int[] column = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            column[i] = matrix[i][columnNumber];
        }
        return column;
    }
}
