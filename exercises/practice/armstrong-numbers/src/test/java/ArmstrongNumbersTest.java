import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ArmstrongNumbersTest {

    private ArmstrongNumbers armstrongNumbers;

    @Before
    public void setup() {
        armstrongNumbers = new ArmstrongNumbers();
    }

    @Test
    public void zeroIsArmstrongNumber() {
        assertThat(armstrongNumbers.isArmstrongNumber(0))
                .isTrue();
    }

    @Ignore("Remove to run test")
    @Test
    public void singleDigitsAreArmstrongNumbers() {
        assertThat(armstrongNumbers.isArmstrongNumber(5))
                .isTrue();
    }

    @Ignore("Remove to run test")
    @Test
    public void noTwoDigitArmstrongNumbers() {
        assertThat(armstrongNumbers.isArmstrongNumber(10))
                .isFalse();
    }

    @Ignore("Remove to run test")
    @Test
    public void threeDigitNumberIsArmstrongNumber() {
        assertThat(armstrongNumbers.isArmstrongNumber(153))
                .isTrue();
    }

    @Ignore("Remove to run test")
    @Test
    public void threeDigitNumberIsNotArmstrongNumber() {
        assertThat(armstrongNumbers.isArmstrongNumber(100))
                .isFalse();
    }

    @Ignore("Remove to run test")
    @Test
    public void fourDigitNumberIsArmstrongNumber() {
        assertThat(armstrongNumbers.isArmstrongNumber(9474))
                .isTrue();
    }

    @Ignore("Remove to run test")
    @Test
    public void fourDigitNumberIsNotArmstrongNumber() {
        assertThat(armstrongNumbers.isArmstrongNumber(9475))
                .isFalse();
    }

    @Ignore("Remove to run test")
    @Test
    public void sevenDigitNumberIsArmstrongNumber() {
        assertThat(armstrongNumbers.isArmstrongNumber(9926315))
                .isTrue();
    }

    @Ignore("Remove to run test")
    @Test
    public void sevenDigitNumberIsNotArmstrongNumber() {
        assertThat(armstrongNumbers.isArmstrongNumber(9926314))
                .isFalse();
    }

}
