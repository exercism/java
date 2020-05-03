import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;
import org.junit.Ignore;

public class PascalsTriangleGeneratorTest {

    private PascalsTriangleGenerator pascalsTriangleGenerator =
        new PascalsTriangleGenerator();

    @Test
    public void testTriangleWithZeroRows() {
        int[][] expectedOutput = new int[][]{};

        assertArrayEquals(expectedOutput, pascalsTriangleGenerator.generateTriangle(0));
    }

    @Ignore("Remove to run test")
    @Test
    public void testTriangleWithOneRow() {
        int[][] expectedOutput = new int[][]{
            {1}
        };

        assertArrayEquals(expectedOutput, pascalsTriangleGenerator.generateTriangle(1));
    }

    @Ignore("Remove to run test")
    @Test
    public void testTriangleWithTwoRows() {
        int[][] expectedOutput = new int[][]{
            {1},
            {1, 1}
        };

        assertArrayEquals(expectedOutput, pascalsTriangleGenerator.generateTriangle(2));
    }

    @Ignore("Remove to run test")
    @Test
    public void testTriangleWithThreeRows() {
        int[][] expectedOutput = new int[][]{
            {1},
            {1, 1},
            {1, 2, 1}
        };

        assertArrayEquals(expectedOutput, pascalsTriangleGenerator.generateTriangle(3));
    }

    @Ignore("Remove to run test")
    @Test
    public void testTriangleWithFourRows() {
        int[][] expectedOutput = new int[][]{
            {1},
            {1, 1},
            {1, 2, 1},
            {1, 3, 3, 1}
        };

        assertArrayEquals(expectedOutput, pascalsTriangleGenerator.generateTriangle(4));
    }

    @Ignore("Remove to run test")
    @Test
    public void testTriangleWithFiveRows() {
        int[][] expectedOutput = new int[][]{
            {1},
            {1, 1},
            {1, 2, 1},
            {1, 3, 3, 1},
            {1, 4, 6, 4, 1}
        };

        assertArrayEquals(expectedOutput, pascalsTriangleGenerator.generateTriangle(5));
    }

    @Ignore("Remove to run test")
    @Test
    public void testTriangleWithSixRows() {
        int[][] expectedOutput = new int[][]{
            {1},
            {1, 1},
            {1, 2, 1},
            {1, 3, 3, 1},
            {1, 4, 6, 4, 1},
            {1, 5, 10, 10, 5, 1}
        };

        assertArrayEquals(expectedOutput, pascalsTriangleGenerator.generateTriangle(6));
    }

    @Ignore("Remove to run test")
    @Test
    public void testTriangleWithTenRows() {
        int[][] expectedOutput = new int[][]{
            {1},
            {1, 1},
            {1, 2, 1},
            {1, 3, 3, 1},
            {1, 4, 6, 4, 1},
            {1, 5, 10, 10, 5, 1},
            {1, 6, 15, 20, 15, 6, 1},
            {1, 7, 21, 35, 35, 21, 7, 1},
            {1, 8, 28, 56, 70, 56, 28, 8, 1},
            {1, 9, 36, 84, 126, 126, 84, 36, 9, 1}
        };

        assertArrayEquals(expectedOutput, pascalsTriangleGenerator.generateTriangle(10));
    }
}
