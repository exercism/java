import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Sieve {

    private int maximalPrime;
    private List<Integer> primes;

    public Sieve(int maximalPrime) {
        this.maximalPrime = maximalPrime;
        this.primes = calculatePrimes();
    }

    public List<Integer> getPrimes() {
        return primes;
    }

    private List<Integer> calculatePrimes() {
        List<Integer> primes = new ArrayList<>();
        LinkedList<Integer> candidates = IntStream.range(2, maximalPrime + 1)
                .boxed()
                .collect(Collectors.toCollection(LinkedList::new));

        while (candidates.size() > 0) {
            Integer prime = candidates.remove();
            primes.add(prime);
            candidates = candidates.stream()
                    .filter(x -> x % prime != 0)
                    .collect(Collectors.toCollection(LinkedList::new));
        }

        return primes;
    }
}
