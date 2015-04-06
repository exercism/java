import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class PascalsTriangleTest {

    @Test
    public void testTriangleWithFourRows() {
        int[][] expectedOutput = new int[][]{
                {1},
                {1, 1},
                {1, 2, 1},
                {1, 3, 3, 1},
        };

        assertArrayEquals(expectedOutput, PascalsTriangle.computeTriangle(4));
    }

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

        assertArrayEquals(expectedOutput, PascalsTriangle.computeTriangle(6));
    }

    @Test
    public void testExpectEmptyTriangle() {
        int[][] expectedOutput = new int[][]{

        };

        assertArrayEquals(expectedOutput, PascalsTriangle.computeTriangle(0));
    }

    @Test
    public void testValidInput() {
        int[][] input = new int[][]{
                {1},
                {1, 1},
                {1, 2, 1},
                {1, 3, 3, 1},
                {1, 4, 6, 4, 1},
        };

        assertEquals(true, PascalsTriangle.isTriangle(input));
    }

    @Test
    public void testInvalidInput() {
        int[][] input = new int[][]{
                {1},
                {1, 1},
                {1, 2, 1},
                {1, 4, 4, 1},
        };

        assertEquals(false, PascalsTriangle.isTriangle(input));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidatesNotNegativeRows() {
        PascalsTriangle.computeTriangle(-1);
    }
}
