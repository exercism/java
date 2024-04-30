import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class MazeGeneratorTest {
    private static final char EMPTY_CELL = ' ';
    private static final Set<Character> ALLOWED_SYMBOLS = Set.of(
            EMPTY_CELL, // space
            '┌', // box drawings light down and right
            '─', // box drawings light horizontal
            '┬', // box drawings light down and horizontal
            '┐', // box drawings light down and left
            '│', // box drawings light vertical
            '└', // box drawings light up and right
            '┴', // box drawings light up and horizontal
            '┘', // box drawings light up and left
            '├', // box drawings light vertical and right
            '┤', // box drawings light vertical and left
            '┼', // box drawings light vertical and horizontal
            '⇨'  // rightwards white arrow
    );
    private static final char VISITED_CELL = '.';
    private static final int RECTANGLE_ROWS = 6;
    private static final int RECTANGLE_COLUMNS = 18;
    private static final int SEED_ONE = 42;
    private static final int SEED_TWO = 43;
    private MazeGenerator sut;

    @BeforeEach
    public void setup() {
        sut = new MazeGenerator();
    }

    @Test
    public void theDimensionsOfTheMazeAreCorrect() {
        var maze = sut.generatePerfectMaze(RECTANGLE_ROWS, RECTANGLE_COLUMNS);
        var expectedWidth = RECTANGLE_COLUMNS * 2 + 1;
        var expectedHeight = RECTANGLE_ROWS * 2 + 1;

        assertThat(maze)
                .as("The maze has the correct dimensions")
                .hasDimensions(expectedHeight, expectedWidth);
    }

    @Disabled("Remove to run test")
    @Test
    public void theMazeContainsOnlyValidCharacters() {
        var maze = sut.generatePerfectMaze(RECTANGLE_ROWS, RECTANGLE_COLUMNS);

        for (var row : maze) {
            for (var cell : row) {
                assertThat(cell)
                        .as("The maze contains only valid characters")
                        .isIn(ALLOWED_SYMBOLS);
            }
        }
    }

    @Disabled("Remove to run test")
    @Test
    public void theMazeHasOnlyOneEntranceOnTheLeftSide() {
        var maze = sut.generatePerfectMaze(RECTANGLE_ROWS, RECTANGLE_COLUMNS);
        int entranceCount = countEntrances(maze);

        assertThat(entranceCount)
                .as("The maze has only one entrance on the left side")
                .isOne();
    }

    @Disabled("Remove to run test")
    @Test
    public void theMazeHasSingleExitOnTheRightSideOfTheMaze() {
        var maze = sut.generatePerfectMaze(RECTANGLE_ROWS, RECTANGLE_COLUMNS);
        int exitCount = countExits(maze);

        assertThat(exitCount)
                .as("The maze has a single exit on the right side of the maze")
                .isOne();
    }

    @Disabled("Remove to run test")
    @Test
    public void aMazeIsDifferentEachTimeItIsGenerated() {
        var maze1 = sut.generatePerfectMaze(RECTANGLE_ROWS, RECTANGLE_COLUMNS);
        var maze2 = sut.generatePerfectMaze(RECTANGLE_ROWS, RECTANGLE_COLUMNS);

        assertThat(maze1)
                .as("Two mazes should not be equal")
                .isNotEqualTo(maze2);
    }

    @Disabled("Remove to run test")
    @Test
    public void twoMazesWithSameSeedShouldBeEqual() {
        var maze1 = sut.generatePerfectMaze(RECTANGLE_ROWS, RECTANGLE_COLUMNS, SEED_ONE);
        var maze2 = sut.generatePerfectMaze(RECTANGLE_ROWS, RECTANGLE_COLUMNS, SEED_ONE);

        assertThat(maze1)
                .as("Two mazes with the same seed should be equal")
                .isEqualTo(maze2);
    }

    @Disabled("Remove to run test")
    @Test
    public void twoMazesWithDifferentSeedsShouldNotBeEqual() {
        var maze1 = sut.generatePerfectMaze(RECTANGLE_ROWS, RECTANGLE_COLUMNS, SEED_ONE);
        var maze2 = sut.generatePerfectMaze(RECTANGLE_ROWS, RECTANGLE_COLUMNS, SEED_TWO);

        assertThat(maze1)
                .as("Two mazes with different seeds should not be equal")
                .isNotEqualTo(maze2);
    }

    @Disabled("Remove to run test")
    @Test
    public void theMazeIsPerfect() {
        var maze = sut.generatePerfectMaze(RECTANGLE_ROWS, RECTANGLE_COLUMNS);

        assertThatMazeHasSinglePath(maze);
        assertThatMazeHasNoIsolatedSections(maze);
    }

    @Disabled("Remove to run test")
    @Test
    public void theMazeIsPerfectWithSeed() {
        var maze = sut.generatePerfectMaze(RECTANGLE_ROWS, RECTANGLE_COLUMNS, SEED_ONE);

        assertThatMazeHasSinglePath(maze);
        assertThatMazeHasNoIsolatedSections(maze);
    }

    @Disabled("Remove to run test")
    @Test
    public void shouldThrowExceptionWhenRowsIsLessThanFive() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> sut.generatePerfectMaze(0, RECTANGLE_COLUMNS));
    }

    @Disabled("Remove to run test")
    @Test
    public void shouldThrowExceptionWhenColumnsIsLessThanFive() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> sut.generatePerfectMaze(RECTANGLE_ROWS, 0));
    }

    @Disabled("Remove to run test")
    @Test
    public void shouldThrowExceptionWhenRowsIsMoreThenHundred() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> sut.generatePerfectMaze(101, RECTANGLE_COLUMNS));
    }

    @Disabled("Remove to run test")
    @Test
    public void shouldThrowExceptionWhenColumnsIsMoreThenHundred() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> sut.generatePerfectMaze(RECTANGLE_ROWS, 101));
    }

    private void assertThatMazeHasSinglePath(char[][] maze) {
        assertMazeHasSinglePath(maze, 1, 1);
    }

    private void assertMazeHasSinglePath(char[][] maze, int x, int y) {
        var isEmptyCell = maze[x][y] == EMPTY_CELL;

        assertThat(isEmptyCell)
                .as("The maze has only one path")
                .withFailMessage("an extra passage detected at (%d, %d)", x, y)
                .isTrue();

        maze[x][y] = VISITED_CELL;

        for (var direction : Direction.values()) {
            if (maze[x + direction.dx()][y + direction.dy()] == EMPTY_CELL) {
                maze[x + direction.dx()][y + direction.dy()] = VISITED_CELL;
                assertMazeHasSinglePath(maze, x + 2 * direction.dx(), y + 2 * direction.dy());
            }
        }
    }

    private void assertThatMazeHasNoIsolatedSections(char[][] maze) {
        for (int row = 1; row < maze.length; row += 2) {
            for (int col = 1; col < maze[row].length; col += 2) {
                assertThat(maze[row][col])
                        .as("The maze has no isolated sections")
                        .withFailMessage("an isolated section detected at (%d, %d)", row, col)
                        .isEqualTo(VISITED_CELL);
            }
        }
    }

    private int countExits(char[][] maze) {
        int exitCount = 0;
        for (char[] row : maze) {
            if (row[row.length - 1] == '⇨') {
                exitCount++;
            }
        }
        return exitCount;
    }

    private int countEntrances(char[][] maze) {
        int entranceCount = 0;
        for (char[] row : maze) {
            if (row[0] == '⇨') {
                entranceCount++;
            }
        }
        return entranceCount;
    }

    private enum Direction {
        NORTH(0, 1),
        EAST(1, 0),
        SOUTH(0, -1),
        WEST(-1, 0);
        private final int dx;
        private final int dy;

        Direction(int dx, int dy) {
            this.dx = dx;
            this.dy = dy;
        }

        public int dx() {
            return dx;
        }

        public int dy() {
            return dy;
        }
    }
}
