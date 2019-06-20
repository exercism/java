import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.SortedMap;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class PalindromeCalculatorTest {
    private PalindromeCalculator palindromeCalculator;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setup() {
        palindromeCalculator = new PalindromeCalculator();
    }

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

    @Ignore("Remove to run test")
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

    @Ignore("Remove to run test")
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

    @Ignore("Remove to run test")
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

    @Ignore("Remove to run test")
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

    @Ignore("Remove to run test")
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

    @Ignore("Remove to run test")
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

    @Ignore("Remove to run test")
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

    @Ignore("Remove to run test")
    @Test
    public void emtpyResultSmallestNoPalindromeInRange() {

        SortedMap<Long, List<List<Integer>>> palindromes = palindromeCalculator.getPalindromeProductsWithFactors(1002,
                                                                                                                 1003);
        assertTrue(palindromes.isEmpty());
    }

    @Ignore("Remove to run test")
    @Test
    public void emptyResultLargestNoPalindromeInRange() {

        SortedMap<Long, List<List<Integer>>> palindromes = palindromeCalculator.getPalindromeProductsWithFactors(15,
                                                                                                                 15);
        assertTrue(palindromes.isEmpty());
    }

    @Ignore("Remove to run test")
    @Test
    public void errorSmallestMinIsMoreThanMax() {

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("invalid input: min must be <= max");

        SortedMap<Long, List<List<Integer>>> palindromes = palindromeCalculator.getPalindromeProductsWithFactors(10000,
                                                                                                                 1);
    }

    @Ignore("Remove to run test")
    @Test
    public void errorLargestMinIsMoreThanMax() {

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("invalid input: min must be <= max");

        SortedMap<Long, List<List<Integer>>> palindromes = palindromeCalculator.getPalindromeProductsWithFactors(2, 1);
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
