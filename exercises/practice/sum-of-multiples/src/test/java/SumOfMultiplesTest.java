import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SumOfMultiplesTest {

    @Test
    @DisplayName("no multiples within limit")
    public void testNoMultiplesWithinLimit() {

        int[] set = {
            3,
            5
        };
        int output = new SumOfMultiples(1, set).getSum();
        assertThat(output).isEqualTo(0);

    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("one factor has multiples within limit")
    public void testOneFactorHasMultiplesWithinLimit() {

        int[] set = {
            3,
            5
        };
        int output = new SumOfMultiples(4, set).getSum();
        assertThat(output).isEqualTo(3);

    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("more than one multiple within limit")
    public void testMoreThanOneMultipleWithinLimit() {

        int[] set = {
            3
        };
        int output = new SumOfMultiples(7, set).getSum();
        assertThat(output).isEqualTo(9);

    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("more than one factor with multiples within limit")
    public void testMoreThanOneFactorWithMultiplesWithinLimit() {

        int[] set = {
            3,
            5
        };
        int output = new SumOfMultiples(10, set).getSum();
        assertThat(output).isEqualTo(23);

    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("each multiple is only counted once")
    public void testEachMultipleIsOnlyCountedOnce() {

        int[] set = {
            3,
            5
        };
        int output = new SumOfMultiples(100, set).getSum();
        assertThat(output).isEqualTo(2318);

    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("a much larger limit")
    public void testAMuchLargerLimit() {

        int[] set = {
            3,
            5
        };
        int output = new SumOfMultiples(1000, set).getSum();
        assertThat(output).isEqualTo(233168);

    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("three factors")
    public void testThreeFactors() {

        int[] set = {
            7,
            13,
            17
        };
        int output = new SumOfMultiples(20, set).getSum();
        assertThat(output).isEqualTo(51);

    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("factors not relatively prime")
    public void testFactorsNotRelativelyPrime() {

        int[] set = {
            4,
            6
        };
        int output = new SumOfMultiples(15, set).getSum();
        assertThat(output).isEqualTo(30);

    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("some pairs of factors relatively prime and some not")
    public void testSomePairsOfFactorsRelativelyPrimeAndSomeNot() {

        int[] set = {
            5,
            6,
            8
        };
        int output = new SumOfMultiples(150, set).getSum();
        assertThat(output).isEqualTo(4419);

    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("one factor is a multiple of another")
    public void testOneFactorIsAMultipleOfAnother() {

        int[] set = {
            5,
            25
        };
        int output = new SumOfMultiples(51, set).getSum();
        assertThat(output).isEqualTo(275);

    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("much larger factors")
    public void testMuchLargerFactors() {

        int[] set = {
            43,
            47
        };
        int output = new SumOfMultiples(10000, set).getSum();
        assertThat(output).isEqualTo(2203160);

    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("all numbers are multiples of 1")
    public void testAllNumbersAreMultiplesOf1() {

        int[] set = {
            1
        };
        int output = new SumOfMultiples(100, set).getSum();
        assertThat(output).isEqualTo(4950);

    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("no factors means an empty sum")
    public void testNoFactorsMeanAnEmptySum() {

        int[] set = {};
        int output = new SumOfMultiples(10000, set).getSum();
        assertThat(output).isEqualTo(0);

    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("the only multiple of 0 is 0")
    public void testSumOfMultiplesOfZeroIsZero() {

        int[] set = {
            0
        };
        int output = new SumOfMultiples(1, set).getSum();
        assertThat(output).isEqualTo(0);

    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("the factor 0 does not affect the sum of multiples of other factors")
    public void testFactorZeroDoesNotAffectTheSumOfMultiplesOfOtherFactors() {

        int[] set = {
            3,
            0
        };
        int output = new SumOfMultiples(4, set).getSum();
        assertThat(output).isEqualTo(3);

    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("solutions using include-exclude must extend to cardinality greater than 3")
    public void testSolutionsUsingIncludeExcludeMustExtendToCardinalityGreater3() {

        int[] set = {
            2,
            3,
            5,
            7,
            11
        };
        int output = new SumOfMultiples(10000, set).getSum();
        assertThat(output).isEqualTo(39614537);

    }

}
