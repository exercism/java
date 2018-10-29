enum Direction {

    UP   (0, -1),
    RIGHT(1,  0),
    DOWN (0,  1),
    LEFT (-1,  0);

    private final int dx;

    private final int dy;

    Direction(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    int getDx() {
        return dx;
    }

    int getDy() {
        return dy;
    }

    Direction turnRight() {
        return Direction.values()[(ordinal() + 1) % Direction.values().length];
    }

}
