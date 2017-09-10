final class Robot {

    private GridPosition gridPosition;

    private Orientation orientation;

    Robot(final GridPosition initialGridPosition, final Orientation initialOrientation) {
        this.gridPosition = initialGridPosition;
        this.orientation = initialOrientation;
    }

    GridPosition getGridPosition() {
        return gridPosition;
    }

    Orientation getOrientation() {
        return orientation;
    }

    Robot advance() {
        switch (orientation) {
            case NORTH:
                gridPosition = new GridPosition(gridPosition.x, gridPosition.y + 1);
                break;
            case EAST:
                gridPosition = new GridPosition(gridPosition.x + 1, gridPosition.y);
                break;
            case SOUTH:
                gridPosition = new GridPosition(gridPosition.x, gridPosition.y - 1);
                break;
            case WEST:
                gridPosition = new GridPosition(gridPosition.x - 1, gridPosition.y);
                break;
        }

        return this;
    }

    Robot simulate(final String instructions) {
        for (final char instruction : instructions.toCharArray()) {
            switch (instruction) {
                case 'A':
                    advance();
                    break;
                case 'R':
                    turnRight();
                    break;
                case 'L':
                    turnLeft();
                    break;
                default:
                    throw new IllegalArgumentException(String.format("Invalid instruction: '%s'", instruction));
            }
        }

        return this;
    }

    Robot turnLeft() {
        final int newOrientationOrdinal = Math.floorMod(orientation.ordinal() - 1, Orientation.values().length);
        orientation = Orientation.values()[newOrientationOrdinal];
        return this;
    }

    Robot turnRight() {
        final int newOrientationOrdinal = Math.floorMod(orientation.ordinal() + 1, Orientation.values().length);
        orientation = Orientation.values()[newOrientationOrdinal];
        return this;
    }

}
