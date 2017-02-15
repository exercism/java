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

        assertNotNull(palindromes);
        assertFalse(palindromes.isEmpty());

        long actualValue = palindromes.lastKey();
        assertEquals(expectedValue, actualValue);

        List<List<Integer>> actual = palindromes
                .get(palindromes.lastKey())
                .stream()
                .sorted((a, b) -> Integer.compare(a.get(0), b.get(0)))
                .collect(Collectors.toList());
        assertEquals(expected, actual);
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

        assertNotNull(palindromes);
        assertFalse(palindromes.isEmpty());

        long actualValue = palindromes.lastKey();
        assertEquals(expectedValue, actualValue);

        List<List<Integer>> actual = palindromes
                .get(palindromes.lastKey())
                .stream()
                .sorted((a, b) -> Integer.compare(a.get(0), b.get(0)))
                .collect(Collectors.toList());
        assertEquals(expected, actual);
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

        assertNotNull(palindromes);
        assertFalse(palindromes.isEmpty());

        long actualValue = palindromes.firstKey();
        assertEquals(expectedValue, actualValue);

        List<List<Integer>> actual = palindromes
                .get(palindromes.firstKey())
                .stream()
                .sorted((a, b) -> Integer.compare(a.get(0), b.get(0)))
                .collect(Collectors.toList());
        assertEquals(expected, actual);
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

        assertNotNull(palindromes);
        assertFalse(palindromes.isEmpty());

        long actualValue = palindromes.lastKey();
        assertEquals(expectedValue, actualValue);

        List<List<Integer>> actual = palindromes
                .get(palindromes.lastKey())
                .stream()
                .sorted((a, b) -> Integer.compare(a.get(0), b.get(0)))
                .collect(Collectors.toList());
        assertEquals(expected, actual);
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

        assertNotNull(palindromes);
        assertFalse(palindromes.isEmpty());

        long actualValue = palindromes.firstKey();
        assertEquals(expectedValue, actualValue);

        List<List<Integer>> actual = palindromes
                .get(palindromes.firstKey())
                .stream()
                .sorted((a, b) -> Integer.compare(a.get(0), b.get(0)))
                .collect(Collectors.toList());
        assertEquals(expected, actual);
    }
}
