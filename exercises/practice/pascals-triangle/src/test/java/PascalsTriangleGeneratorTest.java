import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PascalsTriangleGeneratorTest {

    private PascalsTriangleGenerator pascalsTriangleGenerator =
        new PascalsTriangleGenerator();

    @Test
    @DisplayName("zero rows")
    public void testTriangleWithZeroRows() {
        int[][] expectedOutput = new int[][]{};

        assertThat(pascalsTriangleGenerator.generateTriangle(0)).isEqualTo(expectedOutput);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("single row")
    public void testTriangleWithOneRow() {
        int[][] expectedOutput = new int[][]{
            {1}
        };

        assertThat(pascalsTriangleGenerator.generateTriangle(1)).isEqualTo(expectedOutput);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("two rows")
    public void testTriangleWithTwoRows() {
        int[][] expectedOutput = new int[][]{
            {1},
            {1, 1}
        };

        assertThat(pascalsTriangleGenerator.generateTriangle(2)).isEqualTo(expectedOutput);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("three rows")
    public void testTriangleWithThreeRows() {
        int[][] expectedOutput = new int[][]{
            {1},
            {1, 1},
            {1, 2, 1}
        };

        assertThat(pascalsTriangleGenerator.generateTriangle(3)).isEqualTo(expectedOutput);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("four rows")
    public void testTriangleWithFourRows() {
        int[][] expectedOutput = new int[][]{
            {1},
            {1, 1},
            {1, 2, 1},
            {1, 3, 3, 1}
        };

        assertThat(pascalsTriangleGenerator.generateTriangle(4)).isEqualTo(expectedOutput);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("five rows")
    public void testTriangleWithFiveRows() {
        int[][] expectedOutput = new int[][]{
            {1},
            {1, 1},
            {1, 2, 1},
            {1, 3, 3, 1},
            {1, 4, 6, 4, 1}
        };

        assertThat(pascalsTriangleGenerator.generateTriangle(5)).isEqualTo(expectedOutput);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("six rows")
    public void testTriangleWithSixRows() {
        int[][] expectedOutput = new int[][]{
            {1},
            {1, 1},
            {1, 2, 1},
            {1, 3, 3, 1},
            {1, 4, 6, 4, 1},
            {1, 5, 10, 10, 5, 1}
        };

        assertThat(pascalsTriangleGenerator.generateTriangle(6)).isEqualTo(expectedOutput);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("ten rows")
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

        assertThat(pascalsTriangleGenerator.generateTriangle(10)).isEqualTo(expectedOutput);
    }
}
