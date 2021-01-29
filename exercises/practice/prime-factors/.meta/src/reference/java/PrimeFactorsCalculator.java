import java.util.ArrayList;
import java.util.List;

public class PrimeFactorsCalculator {

    public List<Long> calculatePrimeFactorsOf(long number) {
        List<Long> primes = new ArrayList<>();
        long divisor = 2;

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
