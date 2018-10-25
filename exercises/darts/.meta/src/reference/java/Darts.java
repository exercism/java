class Darts {

    private static final int R_CIRCLE_OUTER = 10;
    private static final int R_CIRCLE_MIDDLE = 5;
    private static final int R_CIRCLE_INNER = 1;

    private double x;
    private double y;

    Darts(double x, double y) {
        this.x = x;
        this.y = y;
    }

    int score() {
        if (R_CIRCLE_MIDDLE < distanceDartToOrigin()
                && distanceDartToOrigin() <= R_CIRCLE_OUTER) {
            return 1;
        } else if (R_CIRCLE_INNER < distanceDartToOrigin()
                && distanceDartToOrigin() <= R_CIRCLE_MIDDLE) {
            return 5;
        } else if (distanceDartToOrigin() <= R_CIRCLE_INNER) {
            return 10;
        }
        return 0;
    }

    private double distanceDartToOrigin() {
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }

}
