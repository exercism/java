import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class GameOfLifeTest {
    @Test
    @DisplayName("Empty Matrix")
    public void testEmptyMatrix() {
        int[][] matrix = new int[][]{};
        assertThat(new GameOfLife().tick(matrix)).isEmpty();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Live cells with zero live neighbors die")
    public void testLiveCellsWithZeroLiveNeighborsDie() {
        int[][] matrix = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };

        int[][] expected = {
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        };

        assertThat(new GameOfLife().tick(matrix)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Live cells with only one live neighbor die")
    public void testLiveCellsWithOnlyOneLiveNeighborsDie() {
        int[][] matrix = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 1, 0}};

        int[][] expected = {
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        };

        assertThat(new GameOfLife().tick(matrix)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Live cells with two live neighbors stay alive")
    public void testLiveCellsWithTwoLiveNeighborsStayAlive() {
        int[][] matrix = {
                {1, 0, 1},
                {1, 0, 1},
                {1, 0, 1}
        };

        int[][] expected = {
                {0, 0, 0},
                {1, 0, 1},
                {0, 0, 0}
        };

        assertThat(new GameOfLife().tick(matrix)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Live cells with three live neighbors stay alive")
    public void testLiveCellsWithThreeLiveNeighborsStayAlive() {
        int[][] matrix = {
                {0, 1, 0},
                {1, 0, 0},
                {1, 1, 0}
        };

        int[][] expected = {
                {0, 0, 0},
                {1, 0, 0},
                {1, 1, 0}

        };

        assertThat(new GameOfLife().tick(matrix)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Dead cells with three live neighbors become alive")
    public void testDeadCellsWithThreeLiveNeighborsBecomeAlive() {
        int[][] matrix = {
                {1, 1, 0},
                {0, 0, 0},
                {1, 0, 0}
        };

        int[][] expected = {
                {0, 0, 0},
                {1, 1, 0},
                {0, 0, 0}
        };

        assertThat(new GameOfLife().tick(matrix)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Live cells with four or more neighbors die")
    public void testLiveCellsWithFourOrMoreNeighborsDie() {
        int[][] matrix = {
            {1, 1, 1},
            {1, 1, 1},
            {1, 1, 1}
        };

        int[][] expected = {
                {1, 0, 1},
                {0, 0, 0},
                {1, 0, 1}
        };

        assertThat(new GameOfLife().tick(matrix)).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Bigger Matrix")
    public void testBiggerMatrix () {
        int[][] matrix = {
                {1, 1, 0, 1, 1, 0, 0, 0},
                {1, 0, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 1, 1, 1},
                {0, 0, 0, 0, 0, 1, 1, 0},
                {1, 0, 0, 0, 1, 1, 0, 0},
                {1, 1, 0, 0, 0, 1, 1, 1},
                {0, 0, 1, 0, 1, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 1, 1}
        };

        int[][] expected = {
                {1, 1, 0, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 1, 0},
                {1, 0, 1, 1, 1, 1, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 1},
                {1, 1, 0, 0, 1, 0, 0, 1},
                {1, 1, 0, 1, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 1}
        };

        assertThat(new GameOfLife().tick(matrix)).isEqualTo(expected);
    }

}
