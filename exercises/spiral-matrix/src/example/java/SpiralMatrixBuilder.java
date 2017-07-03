class SpiralMatrixBuilder {

    int[][] buildMatrixOfSize(int size) {
        if (size == 0) {
            return new int[][]{};
        }

        int[][] result = new int[size][size];
        int entryCount = (int) Math.pow(size, 2.0);

        Coordinate coord = new Coordinate(0, 0);
        Direction direction = Direction.RIGHT;

        for (int i = 0; i < entryCount; i++) {
            result[coord.getY()][coord.getX()] = i + 1;

            Coordinate maybeNextCoord = coord.step(direction);
            if (maybeNextCoord.isWithinGridOfSize(size) && result[maybeNextCoord.getY()][maybeNextCoord.getX()] == 0) {
                coord = maybeNextCoord;
            } else {
                direction = direction.turnRight();
                coord = coord.step(direction);
            }
        }

        return result;
    }

}
