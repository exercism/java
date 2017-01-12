public class Matrix {
    private int[][] matrix;

    public Matrix(String matrixAsString) {
        String[] rows = matrixAsString.split("\\n");
        matrix = new int[rows.length][];
        for (int i = 0; i < rows.length; i++) {
            String[] columnValues = rows[i].split(" ");
            matrix[i] = new int[columnValues.length];
            for (int j = 0; j < columnValues.length; j++) {
                matrix[i][j] = Integer.valueOf(columnValues[j]);
            }
        }
    }

    public int[] getRow(int rowNumber) {
        return matrix[rowNumber];
    }

    public int[] getColumn(int columnNumber) {
        int[] column = new int[matrix.length];
        for(int i = 0; i < matrix.length; i++) {
            column[i] = matrix[i][columnNumber];
        }
        return column;
    }

    public int getRowsCount() {
        return matrix.length;
    }

    public int getColumnsCount() {
        return matrix[0].length;
    }
}
