/**
 * Represents the dimensions of a maze.
 * <p>
 * Dimensions of a grid can be represented in cells or characters.
 * Rows and columns are used for cells, while width and height are used for characters.
 */
public record Dimensions(int rows, int columns) {
    /**
     * Returns the width of the maze in characters.
     *
     * @return the width of the maze
     */
    int width() {
        return 2 * columns + 1;
    }

    /**
     * Returns the height of the maze in characters.
     *
     * @return the height of the maze
     */
    int height() {
        return 2 * rows + 1;
    }
}
