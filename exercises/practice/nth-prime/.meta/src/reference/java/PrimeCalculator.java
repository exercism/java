import java.util.stream.IntStream;

final class PrimeCalculator {
    int nth(int nth) {
        if (nth < 1) {
            throw new IllegalArgumentException();
        }

        int primesFound = 0;
        int possiblePrime = 1;

        while (primesFound < nth) {
            possiblePrime++;

            if (isPrime(possiblePrime)) {
                primesFound++;
            }
        }

        return possiblePrime;
    }

    private boolean isPrime(int n) {
        if (n == 1) {
            return false;
        }

        if (n == 2) {
            return true;
        }

        boolean divisible = IntStream
                .rangeClosed(2, (int) Math.ceil(Math.sqrt(n)))
                .anyMatch((int i) -> n % i == 0);

        return !divisible;
    }
}
