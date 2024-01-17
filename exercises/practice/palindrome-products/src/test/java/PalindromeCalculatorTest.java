import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.SortedMap;
import java.util.stream.Collectors;

public class PalindromeCalculatorTest {

    private PalindromeCalculator palindromeCalculator = new PalindromeCalculator();

    @Test
    public void smallestPalindromeFromSingleDigitFactors() {
        List<List<Integer>> expected = Collections.unmodifiableList(
                Arrays.asList(
                        Arrays.asList(1, 1)
                )
        );
        long expectedValue = 1L;

        SortedMap<Long, List<List<Integer>>> palindromes = palindromeCalculator.getPalindromeProductsWithFactors(1, 9);

        checkPalindromeWithFactorsMatchesExpected(expected, expectedValue, palindromes, palindromes.firstKey());
    }

    @Disabled("Remove to run test")
    @Test
    public void largestPalindromeFromSingleDigitFactors() {
        List<List<Integer>> expected = Collections.unmodifiableList(
                Arrays.asList(
                        Arrays.asList(1, 9),
                        Arrays.asList(3, 3)
                )
        );
        long expectedValue = 9L;

        SortedMap<Long, List<List<Integer>>> palindromes = palindromeCalculator.getPalindromeProductsWithFactors(1, 9);

        checkPalindromeWithFactorsMatchesExpected(expected, expectedValue, palindromes, palindromes.lastKey());
    }

    @Disabled("Remove to run test")
    @Test
    public void largestPalindromeFromDoubleDigitFactors() {
        List<List<Integer>> expected = Collections.unmodifiableList(
                Arrays.asList(
                        Arrays.asList(91, 99)
                )
        );
        long expectedValue = 9009L;

        SortedMap<Long, List<List<Integer>>> palindromes = palindromeCalculator.getPalindromeProductsWithFactors(10,
                99);

        checkPalindromeWithFactorsMatchesExpected(expected, expectedValue, palindromes, palindromes.lastKey());
    }

    @Disabled("Remove to run test")
    @Test
    public void smallestPalindromeFromDoubleDigitFactors() {
        List<List<Integer>> expected = Collections.unmodifiableList(
                Arrays.asList(
                        Arrays.asList(11, 11)
                )
        );
        long expectedValue = 121L;

        SortedMap<Long, List<List<Integer>>> palindromes = palindromeCalculator.getPalindromeProductsWithFactors(10,
                99);

        checkPalindromeWithFactorsMatchesExpected(expected, expectedValue, palindromes, palindromes.firstKey());
    }

    @Disabled("Remove to run test")
    @Test
    public void largestPalindromeFromTripleDigitFactors() {
        List<List<Integer>> expected = Collections.unmodifiableList(
                Arrays.asList(
                        Arrays.asList(913, 993)
                )
        );
        long expectedValue = 906609L;

        SortedMap<Long, List<List<Integer>>> palindromes = palindromeCalculator.getPalindromeProductsWithFactors(100,
                999);

        checkPalindromeWithFactorsMatchesExpected(expected, expectedValue, palindromes, palindromes.lastKey());
    }

    @Disabled("Remove to run test")
    @Test
    public void smallestPalindromeFromTripleDigitFactors() {
        List<List<Integer>> expected = Collections.unmodifiableList(
                Arrays.asList(
                        Arrays.asList(101, 101)
                )
        );
        long expectedValue = 10201L;

        SortedMap<Long, List<List<Integer>>> palindromes = palindromeCalculator.getPalindromeProductsWithFactors(100,
                999);

        checkPalindromeWithFactorsMatchesExpected(expected, expectedValue, palindromes, palindromes.firstKey());
    }

    @Disabled("Remove to run test")
    @Test
    public void smallestPalindromeFromQuadDigitFactors() {
        List<List<Integer>> expected = Collections.unmodifiableList(
                Arrays.asList(
                        Arrays.asList(1001, 1001)
                )
        );
        long expectedValue = 1002001L;

        SortedMap<Long, List<List<Integer>>> palindromes = palindromeCalculator.getPalindromeProductsWithFactors(1000,
                9999);

        checkPalindromeWithFactorsMatchesExpected(expected, expectedValue, palindromes, palindromes.firstKey());
    }

    @Disabled("Remove to run test")
    @Test
    public void largestPalindromeFromQuadDigitFactors() {
        List<List<Integer>> expected = Collections.unmodifiableList(
                Arrays.asList(
                        Arrays.asList(9901, 9999)
                )
        );
        long expectedValue = 99000099L;

        SortedMap<Long, List<List<Integer>>> palindromes = palindromeCalculator.getPalindromeProductsWithFactors(1000,
                9999);

        checkPalindromeWithFactorsMatchesExpected(expected, expectedValue, palindromes, palindromes.lastKey());
    }

    @Disabled("Remove to run test")
    @Test
    public void emtpyResultSmallestNoPalindromeInRange() {

        SortedMap<Long, List<List<Integer>>> palindromes = palindromeCalculator.getPalindromeProductsWithFactors(1002,
                1003);
        assertThat(palindromes).isEmpty();
    }

    @Disabled("Remove to run test")
    @Test
    public void emptyResultLargestNoPalindromeInRange() {

        SortedMap<Long, List<List<Integer>>> palindromes = palindromeCalculator.getPalindromeProductsWithFactors(15,
                15);
        assertThat(palindromes).isEmpty();
    }

    @Disabled("Remove to run test")
    @Test
    public void errorSmallestMinIsMoreThanMax() {

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> palindromeCalculator.getPalindromeProductsWithFactors(10000, 1))
                .withMessage("invalid input: min must be <= max");
    }

    @Disabled("Remove to run test")
    @Test
    public void errorLargestMinIsMoreThanMax() {

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> palindromeCalculator.getPalindromeProductsWithFactors(2, 1))
                .withMessage("invalid input: min must be <= max");
    }


    private void checkPalindromeWithFactorsMatchesExpected(List<List<Integer>> expectedPalindromeFactors,
                                                           long expectedValueOfPalindrome,
                                                           SortedMap<Long, List<List<Integer>>> actualPalindromes,
                                                           long actualValueOfPalindrome) {
        assertThat(actualPalindromes)
                .isNotNull()
                .isNotEmpty();


        assertThat(actualValueOfPalindrome).isEqualTo(expectedValueOfPalindrome);


        List<List<Integer>> actualPalindromeFactors = actualPalindromes
                .get(actualValueOfPalindrome)
                .stream()
                .sorted((a, b) -> Integer.compare(a.get(0), b.get(0)))
                .collect(Collectors.toList());

        assertThat(actualPalindromeFactors).containsExactlyElementsOf(expectedPalindromeFactors);

    }
}
