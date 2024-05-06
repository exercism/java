class GameOfLife {
    public int[][] tick(int[][] matrix) {
        if (matrix.length == 0) {
            return matrix;
        }
        int rowCount = matrix.length;
        int columnCount = matrix[0].length;
        int[][] resultMatrix = new int[rowCount][columnCount];

        for (int row = 0; row < rowCount; row++) {
            for (int column = 0; column < columnCount; column++) {
                int liveNeighbors = countLiveNeighbors(matrix, row, column);

                if ((matrix[row][column] == 1 && (liveNeighbors == 2 || liveNeighbors == 3)) ||
                        (matrix[row][column] == 0 && liveNeighbors == 3)) {
                    resultMatrix[row][column] = 1;
                }
            }
        }
        return resultMatrix;
    }

    private int countLiveNeighbors(int[][] matrix, int row, int col) {
        int rowCount = matrix.length;
        int columnCount = matrix[0].length;
        int count = 0;

        for (int i = Math.max(0, row - 1); i <= Math.min(row + 1, rowCount - 1); i++) {
            for (int j = Math.max(0, col - 1); j <= Math.min(col + 1, columnCount - 1); j++) {
                if (i != row || j != col) {
                    count += matrix[i][j];
                }
            }
        }
        return count;
    }
}
