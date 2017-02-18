import org.junit.Test;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.rules.ExpectedException;


import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class PascalsTriangleTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
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

    @Ignore
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

    @Ignore
    @Test
    public void testExpectEmptyTriangle() {
        int[][] expectedOutput = new int[][]{

        };

        assertArrayEquals(expectedOutput, PascalsTriangle.computeTriangle(0));
    }

    @Ignore
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

    @Ignore
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

    @Ignore
    @Test
    public void testValidatesNotNegativeRows() {
        thrown.expect(IllegalArgumentException.class);
        PascalsTriangle.computeTriangle(-1);
    }
}
