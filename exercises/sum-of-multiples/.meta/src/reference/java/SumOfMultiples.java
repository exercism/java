import java.util.Arrays;
import java.util.stream.IntStream;

public class SumOfMultiples {
    private final int sum;

    public SumOfMultiples(int number, int[] set) {
        sum = calculateSum(number, set);
    }

    public int getSum() {
        return sum;
    }

    private int calculateSum(int number, int[] set) {

        int sum = IntStream.range(1,number)
                .filter(i -> Arrays.stream(set).filter(j -> i % j == 0).count() > 0)
                .sum();

        return sum;
    }

}
