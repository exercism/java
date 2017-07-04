class Coordinate {

    private final int x;

    private final int y;

    Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }

    Coordinate step(Direction direction) {
        return new Coordinate(x + direction.getDx(), y + direction.getDy());
    }

    boolean isWithinGridOfSize(int size) {
        return x >= 0
                && x < size
                && y >= 0
                && y < size;
    }

}
