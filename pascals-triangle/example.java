import java.util.Arrays;

public class PascalsTriangle {

    public static int[][] computeTriangle(int rows) {
        if (rows < 0) {
            throw new IllegalArgumentException("Rows can't be negative!");
        }

        int[][] triangle = new int[rows][];

        for (int i = 0; i < rows; i++) {
            triangle[i] = new int[i + 1];
            triangle[i][0] = 1;
            for (int j = 1; j < i; j++) {
                triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j];
            }
            triangle[i][i] = 1;
        }
        return triangle;
    }

    public static boolean isTriangle(int[][] triangle) {
        return Arrays.deepEquals(triangle, computeTriangle(triangle.length));
    }
}
