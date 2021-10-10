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
        int input = 0;

        assertThat(armstrongNumbers.isArmstrongNumber(input)).isTrue();
    }

    @Ignore("Remove to run test")
    @Test
    public void singleDigitsAreArmstrongNumbers() {
        int input = 5;

        assertThat(armstrongNumbers.isArmstrongNumber(input)).isTrue();
    }

    @Ignore("Remove to run test")
    @Test
    public void noTwoDigitArmstrongNumbers() {
        int input = 10;

        assertThat(armstrongNumbers.isArmstrongNumber(input)).isFalse();
    }

    @Ignore("Remove to run test")
    @Test
    public void threeDigitNumberIsArmstrongNumber() {
        int input = 153;
        
        assertThat(armstrongNumbers.isArmstrongNumber(input)).isTrue();
    }

    @Ignore("Remove to run test")
    @Test
    public void threeDigitNumberIsNotArmstrongNumber() {
        int input = 100;
        
        assertThat(armstrongNumbers.isArmstrongNumber(input)).isFalse();
    }

    @Ignore("Remove to run test")
    @Test
    public void fourDigitNumberIsArmstrongNumber() {
        int input = 9474;
        
        assertThat(armstrongNumbers.isArmstrongNumber(input)).isTrue();
    }

    @Ignore("Remove to run test")
    @Test
    public void fourDigitNumberIsNotArmstrongNumber() {
        int input = 9475;
        
        assertThat(armstrongNumbers.isArmstrongNumber(input)).isFalse();
    }

    @Ignore("Remove to run test")
    @Test
    public void sevenDigitNumberIsArmstrongNumber() {
        int input = 9926315;
        
        assertThat(armstrongNumbers.isArmstrongNumber(input)).isTrue();
    }

    @Ignore("Remove to run test")
    @Test
    public void sevenDigitNumberIsNotArmstrongNumber() {
        int input = 9926314;
        
        assertThat(armstrongNumbers.isArmstrongNumber(input)).isFalse();
    }

}
