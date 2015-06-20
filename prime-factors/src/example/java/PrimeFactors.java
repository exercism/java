import java.util.ArrayList;
import java.util.List;

public class PrimeFactors {

    public static List<Integer> getForNumber(double number) {
        List<Integer> primes = new ArrayList<>();
        int divisor = 2;

        while (number > 1) {
            while (number % divisor == 0) {
                primes.add(divisor);
                number /= divisor;
            }

            divisor++;
        }

        return primes;
    }
}
