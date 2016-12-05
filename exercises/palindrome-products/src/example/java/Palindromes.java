
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

public class Palindromes {

    public static class PalindromeSortedSetBuilder {

        private int minFactor = 1;
        private int maxFactor = 1;

        public PalindromeSortedSetBuilder() {
        }

        public PalindromeSortedSetBuilder withFactorsLessThanOrEqualTo(
                final int maxFactor) {
            this.maxFactor = maxFactor;
            return this;
        }

        public PalindromeSortedSetBuilder withFactorsGreaterThanOrEqualTo(
                final int minFactor) {
            this.minFactor = minFactor;
            return this;
        }

        public SortedMap<Long, List<List<Integer>>> build() {
            SortedMap<Long, List<List<Integer>>> palindromes = new TreeMap<>();
            long num;
            List<List<Integer>> factors;
            for (int i = this.maxFactor; i >= this.minFactor; i--) {
                for (int j = this.maxFactor; j >= i; j--) {
                    num = i * j;
                    if (isPalindrome(num)) {
                        factors = palindromes.get(num);
                        if (factors == null) {
                            factors = new ArrayList<>();
                        }
                        factors.add(Arrays.asList(i, j));
                        palindromes.put(num, factors);
                    }
                }
            }
            return Collections.unmodifiableSortedMap(palindromes);
        }

        // http://stackoverflow.com/questions/23984654/how-to-print-all-palindromes-upto-1000-without-using-any-string-stringbuilder
        private long reverseNumber(long number) {
            if (number < 10l) {
                return number;
            }
            long result = 0;
            long tmp = number;
            while (tmp > 0) {
                result = result * 10 + (tmp % 10);
                tmp /= 10;

            }
            return result;
        }

        private boolean isPalindrome(long number) {
            return number == reverseNumber(number);
        }
    }

    private Palindromes() {
    }

    public static PalindromeSortedSetBuilder getPalindromeSortedListBuilder() {
        return new PalindromeSortedSetBuilder();
    }
}
