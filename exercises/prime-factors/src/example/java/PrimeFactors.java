import java.util.ArrayList;
import java.util.List;

public class PrimeFactors {

    public static List<Long> getForNumber(long number) {
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
