import java.util.*;
import java.util.function.Predicate;

public class Prism {

    public record LaserInfo(double x, double y, double angle, Integer prismId) {
        public LaserInfo(double x, double y, double angle) {
            this(x, y, angle, null);
        }
    }

    public record PrismInfo(int id, double x, double y, double angle) {
    }

    private static final int DECIMAL_PLACES = 3;

    private static final double ROUND_FACTOR = Math.pow(10, DECIMAL_PLACES);

    public static List<Integer> findSequence(LaserInfo laser, List<PrismInfo> prisms) {
        LaserInfo last = laser;
        Optional<PrismInfo> lastPrism = Optional.empty();
        List<Integer> sequence = new ArrayList<>();

        do {
            lastPrism = prisms.stream().filter(new TouchesPrism(last)).min(new CompareDistance(last));
            if (lastPrism.isPresent()) {
                PrismInfo nextPrism = lastPrism.get();
                sequence.add(nextPrism.id);
                last = new LaserInfo(nextPrism.x, nextPrism.y, normalizeDegrees(nextPrism.angle + last.angle), nextPrism.id);
            }
        } while (lastPrism.isPresent());
        return sequence;
    }

    private static double normalizeDegrees(double degrees) {
        if (degrees < 0) {
            return (degrees % 360) + 360;
        }
        return degrees % 360;
    }

    private static class CompareDistance implements Comparator<PrismInfo> {
        private final LaserInfo laser;

        public CompareDistance(LaserInfo laser) {
            this.laser = laser;
        }

        @Override
        public int compare(PrismInfo o1, PrismInfo o2) {
            final double d1 = Math.hypot(o1.x - laser.x, o1.y - laser.y);
            final double d2 = Math.hypot(o2.x - laser.x, o2.y - laser.y);
            return Double.compare(d1, d2);
        }
    }

    private static class TouchesPrism implements Predicate<PrismInfo> {
        private final LaserInfo laser;
        private final double sinAngle;
        private final double cosAngle;

        public TouchesPrism(LaserInfo laser) {
            this.laser = laser;

            double angleRadians = Math.toRadians(laser.angle);
            this.sinAngle = Math.sin(angleRadians);
            this.cosAngle = Math.cos(angleRadians);
        }

        @Override
        public boolean test(PrismInfo prism) {
            if (laser.prismId != null && laser.prismId == prism.id) {
                return false;
            }

            double dx = prism.x - laser.x;
            double dy = prism.y - laser.y;
            double hyp =  Math.hypot(dx, dy);

            return isClose(hyp * cosAngle, dx) && isClose(hyp * sinAngle, dy);
        }
    }

    private static boolean isClose(double a, double b) {
        return Math.abs(Math.round(a * ROUND_FACTOR - b * ROUND_FACTOR)) <= 1;
    }
}