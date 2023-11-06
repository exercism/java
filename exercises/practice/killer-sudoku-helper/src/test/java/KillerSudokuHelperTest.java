import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class KillerSudokuHelperTest {

    private KillerSudokuHelper helper;

    @BeforeEach
    void setUp() {
        helper = new KillerSudokuHelper();
    }

    @Test
    @DisplayName("Trivial 1-digit cages -> 1 to 9")
    public void testTrivialOneDigitCages() {
        for (int n = 1; n <= 9; n++) {
            List<List<Integer>> expected = List.of(List.of(n));
            assertThat(helper.combinationsInCage(n, 1)).isEqualTo(expected);
        }
    }

    @Test
    @Disabled("Remove to run test")
    @DisplayName("Cage with sum 45 contains all digits 1:9")
    public void testCageWithSum45ContainsAllDigits() {
        List<List<Integer>> expected = List.of(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9));
        assertThat(helper.combinationsInCage(45, 9)).isEqualTo(expected);
    }

    @Test
    @Disabled("Remove to run test")
    @DisplayName("Cage with only 1 possible combination")
    public void testCageWithOnlyOnePossibleCombination() {
        List<List<Integer>> expected = List.of(List.of(1, 2, 4));
        assertThat(helper.combinationsInCage(7, 3)).isEqualTo(expected);
    }

    @Test
    @Disabled("Remove to run test")
    @DisplayName("Cage with several combinations")
    public void testCageWithSeveralCombinations() {
        List<List<Integer>> expected = List.of(
                List.of(1, 9),
                List.of(2, 8),
                List.of(3, 7),
                List.of(4, 6)
        );
        assertThat(helper.combinationsInCage(10, 2)).isEqualTo(expected);
    }

    @Test
    @Disabled("Remove to run test")
    @DisplayName("Cage with several combinations that is restricted")
    public void testCageWithSeveralCombinationsThatIsRestricted() {
        List<List<Integer>> expected = List.of(
                List.of(2, 8),
                List.of(3, 7)
        );
        assertThat(helper.combinationsInCage(10, 2, List.of(1, 4))).isEqualTo(expected);
    }
}

