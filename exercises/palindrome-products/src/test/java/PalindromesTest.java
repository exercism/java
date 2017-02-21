import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.SortedMap;
import java.util.stream.Collectors;

import static junit.framework.TestCase.*;

public class PalindromesTest {

    @Test
    public void largestPalindromeFromSingleDigitFactors() {
        final List<List<Integer>> expected = Collections.unmodifiableList(
                Arrays.asList(
                        Arrays.asList(1, 9),
                        Arrays.asList(3, 3)
                )
        );
        final long expectedValue = 9l;

        final SortedMap<Long, List<List<Integer>>> palindromes = Palindromes.getPalindromeProductsWithFactors(1, 9);

        checkPalindromeWithFactorsMatchesExpected(expected, expectedValue, palindromes, palindromes.lastKey());
    }

    @Test
    @Ignore
    public void largestPalindromeFromDoubleDigitFactors() {
        final List<List<Integer>> expected = Collections.unmodifiableList(
                Arrays.asList(
                        Arrays.asList(91, 99)
                )
        );
        final long expectedValue = 9009l;

        final SortedMap<Long, List<List<Integer>>> palindromes = Palindromes.getPalindromeProductsWithFactors(10, 99);

        checkPalindromeWithFactorsMatchesExpected(expected, expectedValue, palindromes, palindromes.lastKey());
    }

    @Test
    @Ignore
    public void smallestPalindromeFromDoubleDigitFactors() {
        final List<List<Integer>> expected = Collections.unmodifiableList(
                Arrays.asList(
                        Arrays.asList(11, 11)
                )
        );
        final long expectedValue = 121l;

        final SortedMap<Long, List<List<Integer>>> palindromes = Palindromes.getPalindromeProductsWithFactors(10, 99);

        checkPalindromeWithFactorsMatchesExpected(expected, expectedValue, palindromes, palindromes.firstKey());
    }

    @Test
    @Ignore
    public void largestPalindromeFromTripleDigitFactors() {
        final List<List<Integer>> expected = Collections.unmodifiableList(
                Arrays.asList(
                        Arrays.asList(913, 993)
                )
        );
        final long expectedValue = 906609l;

        final SortedMap<Long, List<List<Integer>>> palindromes = Palindromes.getPalindromeProductsWithFactors(100, 999);

        checkPalindromeWithFactorsMatchesExpected(expected, expectedValue, palindromes, palindromes.lastKey());
    }

    @Test
    @Ignore
    public void smallestPalindromeFromTripleDigitFactors() {
        final List<List<Integer>> expected = Collections.unmodifiableList(
                Arrays.asList(
                        Arrays.asList(101, 101)
                )
        );
        final long expectedValue = 10201l;

        final SortedMap<Long, List<List<Integer>>> palindromes = Palindromes.getPalindromeProductsWithFactors(100, 999);

        checkPalindromeWithFactorsMatchesExpected(expected, expectedValue, palindromes, palindromes.firstKey());
    }

    private void checkPalindromeWithFactorsMatchesExpected(List<List<Integer>> expectedPalindromeFactors,
                                                           long expectedValueOfPalindrome,
                                                           SortedMap<Long, List<List<Integer>>> actualPalindromes,
                                                           long actualValueOfPalindrome) {
        assertNotNull(actualPalindromes);
        assertFalse(actualPalindromes.isEmpty());

        assertEquals(expectedValueOfPalindrome, actualValueOfPalindrome);

        List<List<Integer>> actualPalindromeFactors = actualPalindromes
                .get(actualValueOfPalindrome)
                .stream()
                .sorted((a, b) -> Integer.compare(a.get(0), b.get(0)))
                .collect(Collectors.toList());
        assertEquals(expectedPalindromeFactors, actualPalindromeFactors);
    }
}
