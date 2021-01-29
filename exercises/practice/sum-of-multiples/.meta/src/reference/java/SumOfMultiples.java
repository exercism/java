import java.util.Arrays;
import java.util.stream.IntStream;

public class SumOfMultiples {
    private final int sum;

    public SumOfMultiples(int limit, int[] set) {
        sum = calculateSum(limit, set);
    }

    public int getSum() {
        return sum;
    }

    private int calculateSum(int limit, int[] set) {
        return IntStream.range(1, limit)
            .filter(n -> Arrays.stream(set).filter(s -> s != 0).anyMatch(s -> n % s == 0))
            .sum();
    }

}
