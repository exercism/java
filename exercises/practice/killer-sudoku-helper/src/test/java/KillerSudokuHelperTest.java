import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class KillerSudokuHelperTest {

    private final KillerSudokuHelper helper = new KillerSudokuHelper();

    @Test
    public void testTrivialOneDigitCages() {
        for (int n = 1; n <= 9; n++) {
            List<List<Integer>> expected = List.of(List.of(n));
            assertEquals(expected, helper.combinationsInCage(n, 1));
        }
    }

    @Test
    public void testCageWithSum45ContainsAllDigits() {
        List<List<Integer>> expected = List.of(asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        assertEquals(expected, helper.combinationsInCage(45, 9));
    }

    @Test
    public void testCageWithOnlyOnePossibleCombination() {
        List<List<Integer>> expected = List.of(asList(1, 2, 4));
        assertEquals(expected, helper.combinationsInCage(7, 3));
    }

    @Test
    public void testCageWithSeveralCombinations() {
        List<List<Integer>> expected = asList(
                asList(1, 9),
                asList(2, 8),
                asList(3, 7),
                asList(4, 6)
        );
        assertEquals(expected, helper.combinationsInCage(10, 2));
    }

    @Test
    public void testCageWithSeveralCombinationsThatIsRestricted() {
        List<List<Integer>> expected = asList(
                asList(2, 8),
                asList(3, 7)
        );
        assertEquals(expected, helper.combinationsInCage(10, 2, asList(1, 4)));
    }
}

