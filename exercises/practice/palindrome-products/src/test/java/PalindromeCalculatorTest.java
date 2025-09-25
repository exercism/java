import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.SortedMap;
import java.util.stream.Collectors;

public class PalindromeCalculatorTest {

    private PalindromeCalculator palindromeCalculator = new PalindromeCalculator();

    @Test
    @DisplayName("find the smallest palindrome from single digit factors")
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
    @DisplayName("find the largest palindrome from single digit factors")
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
    @DisplayName("find the smallest palindrome from double digit factors")
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
    @DisplayName("find the largest palindrome from double digit factors")
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
    @DisplayName("find the largest palindrome from triple digit factors")
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
    @DisplayName("find the smallest palindrome from triple digit factors")
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
    @DisplayName("find the smallest palindrome from four digit factors")
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
    @DisplayName("find the largest palindrome from four digit factors")
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
    @DisplayName("empty result for smallest if no palindrome in the range")
    public void emtpyResultSmallestNoPalindromeInRange() {

        SortedMap<Long, List<List<Integer>>> palindromes = palindromeCalculator.getPalindromeProductsWithFactors(1002,
                1003);
        assertThat(palindromes).isEmpty();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("empty result for largest if no palindrome in the range")
    public void emptyResultLargestNoPalindromeInRange() {

        SortedMap<Long, List<List<Integer>>> palindromes = palindromeCalculator.getPalindromeProductsWithFactors(15,
                15);
        assertThat(palindromes).isEmpty();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("error result for smallest if min is more than max")
    public void errorSmallestMinIsMoreThanMax() {

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> palindromeCalculator.getPalindromeProductsWithFactors(10000, 1))
                .withMessage("invalid input: min must be <= max");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("error result for largest if min is more than max")
    public void errorLargestMinIsMoreThanMax() {

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> palindromeCalculator.getPalindromeProductsWithFactors(2, 1))
                .withMessage("invalid input: min must be <= max");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("smallest product does not use the smallest factor")
    public void smallestProductDoesNotUseTheSmallestFactor() {
        List<List<Integer>> expected = Collections.unmodifiableList(
                Arrays.asList(
                        Arrays.asList(3297, 3333)
                )
        );
        long expectedValue = 10988901L;

        SortedMap<Long, List<List<Integer>>> palindromes = palindromeCalculator.getPalindromeProductsWithFactors(3215,
                4000);

        checkPalindromeWithFactorsMatchesExpected(expected, expectedValue, palindromes, palindromes.firstKey());
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
