import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ArmstrongNumbersTest {

    private ArmstrongNumbers armstrongNumbers;

    @BeforeEach
    public void setup() {
        armstrongNumbers = new ArmstrongNumbers();
    }

    @Test
    public void zeroIsArmstrongNumber() {
        assertThat(armstrongNumbers.isArmstrongNumber(0))
                .isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    public void singleDigitsAreArmstrongNumbers() {
        assertThat(armstrongNumbers.isArmstrongNumber(5))
                .isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    public void noTwoDigitArmstrongNumbers() {
        assertThat(armstrongNumbers.isArmstrongNumber(10))
                .isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    public void threeDigitNumberIsArmstrongNumber() {
        assertThat(armstrongNumbers.isArmstrongNumber(153))
                .isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    public void threeDigitNumberIsNotArmstrongNumber() {
        assertThat(armstrongNumbers.isArmstrongNumber(100))
                .isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    public void fourDigitNumberIsArmstrongNumber() {
        assertThat(armstrongNumbers.isArmstrongNumber(9474))
                .isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    public void fourDigitNumberIsNotArmstrongNumber() {
        assertThat(armstrongNumbers.isArmstrongNumber(9475))
                .isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    public void sevenDigitNumberIsArmstrongNumber() {
        assertThat(armstrongNumbers.isArmstrongNumber(9926315))
                .isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    public void sevenDigitNumberIsNotArmstrongNumber() {
        assertThat(armstrongNumbers.isArmstrongNumber(9926314))
                .isFalse();
    }

}
