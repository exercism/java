import org.junit.Before;
import org.junit.Test;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.rules.ExpectedException;


import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/*
 * version: 1.0.0
 */
public class PascalsTriangleGeneratorTest {

    private PascalsTriangleGenerator pascalsTriangleGenerator;

    @Before
    public void setUp() {
        pascalsTriangleGenerator = new PascalsTriangleGenerator();
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

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
    public void testValidatesNotNegativeRows() {
        thrown.expect(IllegalArgumentException.class);
        pascalsTriangleGenerator.generateTriangle(-1);
    }

}
