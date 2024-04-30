import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SpiralMatrixBuilderTest {

    private SpiralMatrixBuilder spiralMatrixBuilder;

    @BeforeEach
    public void setUp() {
        spiralMatrixBuilder = new SpiralMatrixBuilder();
    }

    @Test
    public void testEmptySpiral() {
        assertThat(spiralMatrixBuilder.buildMatrixOfSize(0)).isEmpty();
    }

    @Disabled("Remove to run test")
    @Test
    public void testTrivialSpiral() {
        int[][] expected = {
                {1}
        };

        assertThat(spiralMatrixBuilder.buildMatrixOfSize(1)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    public void testSpiralOfSize2() {
        int[][] expected = {
                {1, 2},
                {4, 3}
        };

        assertThat(spiralMatrixBuilder.buildMatrixOfSize(2)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    public void testSpiralOfSize3() {
        int[][] expected = {
                {1, 2, 3},
                {8, 9, 4},
                {7, 6, 5}
        };

        assertThat(spiralMatrixBuilder.buildMatrixOfSize(3)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    public void testSpiralOfSize4() {
        int[][] expected = {
                { 1,  2,  3,  4},
                {12, 13, 14,  5},
                {11, 16, 15,  6},
                {10,  9,  8,  7}
        };

        assertThat(spiralMatrixBuilder.buildMatrixOfSize(4)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    public void testSpiralOfSize5() {
        int[][] expected = {
                { 1,  2,  3,  4,  5},
                {16, 17, 18, 19,  6},
                {15, 24, 25, 20,  7},
                {14, 23, 22, 21,  8},
                {13, 12, 11, 10,  9}
        };

        assertThat(spiralMatrixBuilder.buildMatrixOfSize(5)).isEqualTo(expected);
    }

}
