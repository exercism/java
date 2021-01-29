import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class ArmstrongNumbersTest {

    private ArmstrongNumbers armstrongNumbers;

    @Before
    public void setup() {
        armstrongNumbers = new ArmstrongNumbers();
    }

    @Test
    public void zeroIsArmstrongNumber() {
        int input = 0;

        assertTrue(armstrongNumbers.isArmstrongNumber(input));
    }

    @Ignore("Remove to run test")
    @Test
    public void singleDigitsAreArmstrongNumbers() {
        int input = 5;

        assertTrue(armstrongNumbers.isArmstrongNumber(input));
    }

    @Ignore("Remove to run test")
    @Test
    public void noTwoDigitArmstrongNumbers() {
        int input = 10;

        assertFalse(armstrongNumbers.isArmstrongNumber(input));
    }

    @Ignore("Remove to run test")
    @Test
    public void threeDigitNumberIsArmstrongNumber() {
        int input = 153;
        
        assertTrue(armstrongNumbers.isArmstrongNumber(input));
    }

    @Ignore("Remove to run test")
    @Test
    public void threeDigitNumberIsNotArmstrongNumber() {
        int input = 100;
        
        assertFalse(armstrongNumbers.isArmstrongNumber(input));
    }

    @Ignore("Remove to run test")
    @Test
    public void fourDigitNumberIsArmstrongNumber() {
        int input = 9474;
        
        assertTrue(armstrongNumbers.isArmstrongNumber(input));
    }

    @Ignore("Remove to run test")
    @Test
    public void fourDigitNumberIsNotArmstrongNumber() {
        int input = 9475;
        
        assertFalse(armstrongNumbers.isArmstrongNumber(input));
    }

    @Ignore("Remove to run test")
    @Test
    public void sevenDigitNumberIsArmstrongNumber() {
        int input = 9926315;
        
        assertTrue(armstrongNumbers.isArmstrongNumber(input));
    }

    @Ignore("Remove to run test")
    @Test
    public void sevenDigitNumberIsNotArmstrongNumber() {
        int input = 9926314;
        
        assertFalse(armstrongNumbers.isArmstrongNumber(input));
    }

}
