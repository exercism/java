
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class PythagoreanTriplet {

    public static final String MAX_FACTOR = "maxFactor";
    public static final String MIN_FACTOR = "minFactor";
    public static final String SUM = "sum";

    private int a;
    private int b;
    private int c;

    public PythagoreanTriplet(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public static List<PythagoreanTriplet> createTripletsList(
            Map<String, Integer> searchData) {
        List<PythagoreanTriplet> triplets = new ArrayList<>();
        if (searchData == null || searchData.isEmpty()
                || !searchData.containsKey(MAX_FACTOR)) {
            return triplets;
        }
        final int maxFactor = searchData.get(MAX_FACTOR);
        Integer tmp = searchData.get(MIN_FACTOR);
        final int minFactor = (tmp == null) ? 1 : tmp;
        tmp = searchData.get(SUM);
        final int sum = (tmp == null) ? -1 : tmp;
        double sqrt;
        int floor;
        for (int n = minFactor; n < maxFactor; n++) {
            for (int m = n + 1; m < maxFactor; m++) {
                sqrt = Math.sqrt(n * n + m * m);
                floor = (int) Math.floor(sqrt);
                if (sqrt == floor) {
                    triplets.add(new PythagoreanTriplet(m, n, floor));
                }
            }
        }
        if (sum >= 0) {
            return triplets.stream()
                    .filter(t -> t.calculateSum() == sum)
                    .collect(Collectors.toList());
        }
        return triplets;
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

}
