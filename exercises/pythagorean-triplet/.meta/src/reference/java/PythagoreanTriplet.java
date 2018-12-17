
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class PythagoreanTriplet {

    private int a;
    private int b;
    private int c;

    public PythagoreanTriplet(final int a, final int b, final int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public static TripletListBuilder makeTripletsList() {
        return new TripletListBuilder();
    }

    public int calculateSum() {
        return this.a + this.b + this.c;
    }

    public long calculateProduct() {
        return this.a * this.b * this.c;
    }

    public boolean isPythagorean() {
        return this.a * this.a + this.b * this.b == this.c * this.c;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b, c);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PythagoreanTriplet other = (PythagoreanTriplet) obj;
        if (this.a != other.a) {
            return false;
        }
        if (this.b != other.b) {
            return false;
        }
        if (this.c != other.c) {
            return false;
        }
        return true;
    }

    public static class TripletListBuilder {

        private static final int MAX_FACTOR_DEFAULT_VALUE = 0;
        private static final int SUM_DEFAULT_VALUE = -1;

        private int maxFactor = MAX_FACTOR_DEFAULT_VALUE;
        private int minFactor = 1;
        private int sum = SUM_DEFAULT_VALUE;

        public TripletListBuilder() {
        }

        public TripletListBuilder withFactorsLessThanOrEqualTo(
                final int maxFactor) {
            this.maxFactor = maxFactor;
            return this;
        }

        public TripletListBuilder withFactorsGreaterThanOrEqualTo(
                final int minFactor) {
            this.minFactor = minFactor;
            return this;
        }

        public TripletListBuilder thatSumTo(final int sum) {
            this.sum = sum;
            return this;
        }

        public List<PythagoreanTriplet> build() {
            List<PythagoreanTriplet> triplets = new ArrayList<>();
            if (this.maxFactor == MAX_FACTOR_DEFAULT_VALUE) {
                return triplets;
            }
            double sqrt;
            int floor;
            for (int n = minFactor; n < maxFactor; n++) {
                for (int m = n + 1; m < maxFactor; m++) {
                    sqrt = Math.sqrt(n * n + m * m);
                    floor = (int) Math.floor(sqrt);
                    if (sqrt == floor) {
                        triplets.add(new PythagoreanTriplet(n, m, floor));
                    }
                }
            }
            if (sum != SUM_DEFAULT_VALUE) {
                return triplets.stream()
                        .filter(t -> t.calculateSum() == sum)
                        .collect(Collectors.toList());
            }
            return triplets;
        }
    }
}
