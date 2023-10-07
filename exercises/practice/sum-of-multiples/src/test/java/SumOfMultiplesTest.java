import org.junit.Ignore;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SumOfMultiplesTest {

    @Test
    public void testNoMultiplesWithinLimit() {

        int[] set = {
            3,
            5
        };
        int output = new SumOfMultiples(1, set).getSum();
        assertThat(output).isEqualTo(0);

    }

    @Ignore("Remove to run test")
    @Test
    public void testOneFactorHasMultiplesWithinLimit() {

        int[] set = {
            3,
            5
        };
        int output = new SumOfMultiples(4, set).getSum();
        assertThat(output).isEqualTo(3);

    }

    @Ignore("Remove to run test")
    @Test
    public void testMoreThanOneMultipleWithinLimit() {

        int[] set = {
            3
        };
        int output = new SumOfMultiples(7, set).getSum();
        assertThat(output).isEqualTo(9);

    }

    @Ignore("Remove to run test")
    @Test
    public void testMoreThanOneFactorWithMultiplesWithinLimit() {

        int[] set = {
            3,
            5
        };
        int output = new SumOfMultiples(10, set).getSum();
        assertThat(output).isEqualTo(23);

    }

    @Ignore("Remove to run test")
    @Test
    public void testEachMultipleIsOnlyCountedOnce() {

        int[] set = {
            3,
            5
        };
        int output = new SumOfMultiples(100, set).getSum();
        assertThat(output).isEqualTo(2318);

    }

    @Ignore("Remove to run test")
    @Test
    public void testAMuchLargerLimit() {

        int[] set = {
            3,
            5
        };
        int output = new SumOfMultiples(1000, set).getSum();
        assertThat(output).isEqualTo(233168);

    }

    @Ignore("Remove to run test")
    @Test
    public void testThreeFactors() {

        int[] set = {
            7,
            13,
            17
        };
        int output = new SumOfMultiples(20, set).getSum();
        assertThat(output).isEqualTo(51);

    }

    @Ignore("Remove to run test")
    @Test
    public void testFactorsNotRelativelyPrime() {

        int[] set = {
            4,
            6
        };
        int output = new SumOfMultiples(15, set).getSum();
        assertThat(output).isEqualTo(30);

    }

    @Ignore("Remove to run test")
    @Test
    public void testSomePairsOfFactorsRelativelyPrimeAndSomeNot() {

        int[] set = {
            5,
            6,
            8
        };
        int output = new SumOfMultiples(150, set).getSum();
        assertThat(output).isEqualTo(4419);

    }

    @Ignore("Remove to run test")
    @Test
    public void testOneFactorIsAMultipleOfAnother() {

        int[] set = {
            5,
            25
        };
        int output = new SumOfMultiples(51, set).getSum();
        assertThat(output).isEqualTo(275);

    }

    @Ignore("Remove to run test")
    @Test
    public void testMuchLargerFactors() {

        int[] set = {
            43,
            47
        };
        int output = new SumOfMultiples(10000, set).getSum();
        assertThat(output).isEqualTo(2203160);

    }

    @Ignore("Remove to run test")
    @Test
    public void testAllNumbersAreMultiplesOf1() {

        int[] set = {
            1
        };
        int output = new SumOfMultiples(100, set).getSum();
        assertThat(output).isEqualTo(4950);

    }

    @Ignore("Remove to run test")
    @Test
    public void testNoFactorsMeanAnEmptySum() {

        int[] set = {};
        int output = new SumOfMultiples(10000, set).getSum();
        assertThat(output).isEqualTo(0);

    }

    @Ignore("Remove to run test")
    @Test
    public void testSumOfMultiplesOfZeroIsZero() {

        int[] set = {
            0
        };
        int output = new SumOfMultiples(1, set).getSum();
        assertThat(output).isEqualTo(0);

    }

    @Ignore("Remove to run test")
    @Test
    public void testFactorZeroDoesNotAffectTheSumOfMultiplesOfOtherFactors() {

        int[] set = {
            3,
            0
        };
        int output = new SumOfMultiples(4, set).getSum();
        assertThat(output).isEqualTo(3);

    }

    @Ignore("Remove to run test")
    @Test
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
