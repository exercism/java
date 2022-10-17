class Darts {

    private static final int RADIUS_CIRCLE_OUTER = 10;
    private static final int RADIUS_CIRCLE_MIDDLE = 5;
    private static final int RADIUS_CIRCLE_INNER = 1;

    int score(double x, double y) {
        if (RADIUS_CIRCLE_MIDDLE < distanceDartToOrigin(x, y)
                && distanceDartToOrigin(x, y) <= RADIUS_CIRCLE_OUTER) {
            return 1;
        } else if (RADIUS_CIRCLE_INNER < distanceDartToOrigin(x, y)
                && distanceDartToOrigin(x, y) <= RADIUS_CIRCLE_MIDDLE) {
            return 5;
        } else if (distanceDartToOrigin(x, y) <= RADIUS_CIRCLE_INNER) {
            return 10;
        }
        return 0;
    }

    private double distanceDartToOrigin(double x, double y) {
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }

}
