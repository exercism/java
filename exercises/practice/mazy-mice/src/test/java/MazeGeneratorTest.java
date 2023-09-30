import org.junit.Before;
import org.junit.Test;
import org.junit.Ignore;

import java.util.Arrays;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class MazeGeneratorTest {
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
    private static final Dimensions RECTANGLE = new Dimensions(6, 18);
    private MazeGenerator sut;

    @Before
    void SetUp() {
        sut = new MazeGenerator();
    }

    @Test
    void mazeIsNotNull() {
        var maze = sut.generatePerfectMaze(RECTANGLE);

        assertThat(maze)
                .as("The maze is not null.")
                .isNotNull();

        Arrays.stream(maze)
                .map(String::new)
                .forEach(System.out::println);
    }

    @Ignore("Remove to run test")
    @Test
    void theDimensionsAreCorrect() {
        var maze = sut.generatePerfectMaze(RECTANGLE);

        assertThat(maze)
                .as("The dimensions of the maze are correct.")
                .hasDimensions(RECTANGLE.height(), RECTANGLE.width());
    }

    @Ignore("Remove to run test")
    @Test
    void aMazeIsDifferentEachTimeItIsGenerated() {
        var maze1 = sut.generatePerfectMaze(RECTANGLE);
        var maze2 = sut.generatePerfectMaze(RECTANGLE);

        assertThat(maze1)
                .as("Two mazes should not be equal")
                .isNotEqualTo(maze2);
    }

    @Ignore("Remove to run test")
    @Test
    void twoMazesWithSameSeedShouldBeEqual() {
        var maze1 = sut.generatePerfectMaze(RECTANGLE, 42);
        var maze2 = sut.generatePerfectMaze(RECTANGLE, 42);

        assertThat(maze1)
                .as("Two mazes with the same seed should be equal")
                .isEqualTo(maze2);
    }

    @Ignore("Remove to run test")
    @Test
    void twoMazesWithDifferentSeedsShouldNotBeEqual() {
        var maze1 = sut.generatePerfectMaze(RECTANGLE, 42);
        var maze2 = sut.generatePerfectMaze(RECTANGLE, 43);

        assertThat(maze1)
                .as("Two mazes with different seeds should not be equal")
                .isNotEqualTo(maze2);
    }

    @Ignore("Remove to run test")
    @Test
    void theMazeContainsOnlyValidCharacters() {
        var maze = sut.generatePerfectMaze(RECTANGLE);

        for (var row : maze) {
            for (var cell : row) {
                assertThat(cell)
                        .as("The maze contains only valid characters")
                        .isIn(ALLOWED_SYMBOLS);
            }
        }
    }

    @Ignore("Remove to run test")
    @Test
    void theMazeHasOnlyOneEntranceOnTheLeftSide() {
        var maze = sut.generatePerfectMaze(RECTANGLE);
        int entranceCount = countEntrances(maze);

        assertThat(entranceCount)
                .as("The maze has only one entrance on the left side")
                .isOne();
    }

    @Ignore("Remove to run test")
    @Test
    void theMazeHasASingleExitOnTheRightSideOfTheMaze() {
        var maze = sut.generatePerfectMaze(RECTANGLE);
        int exitCount = countExits(maze);

        assertThat(exitCount)
                .as("The maze has a single exit on the right side of the maze")
                .isOne();
    }

    @Ignore("Remove to run test")
    @Test
    void theMazeIsPerfect() {
        var maze = sut.generatePerfectMaze(RECTANGLE);

        assertThat(maze)
                .as("The dimensions of the maze are correct.")
                .hasDimensions(RECTANGLE.height(), RECTANGLE.width());

        assertThatMazeHasSinglePath(maze);
        assertThatMazeHasNoIsolatedSections(maze);
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
}
