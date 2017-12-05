import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ArmstrongNumbersTest {

    private ArmstrongNumbers armstrongNumbers;

    @Before
    public void setup() {
        armstrongNumbers = new ArmstrongNumbers();
    }

    @Test
    public void singleDigitsAreArmstrongNumbers() {
        int input = 5;
        boolean expected = true;

        assertEquals(expected, armstrongNumbers.isArmstrongNumber(input));
    }

    @Ignore("Remove to run test")
    @Test
    public void noTwoDigitArmstrongNumbers() {
        int input = "10";
        boolean expected = false;

        assertEquals(expected, armstrongNumbers.isArmstrongNumber(input));
    }

    @Ignore("Remove to run test")
    @Test
    public void threeDigitNumberIsArmstrongNumber() {
        int input = "153";
        boolean expected = true;

        assertEquals(expected, armstrongNumbers.isArmstrongNumber(input));
    }

    @Ignore("Remove to run test")
    @Test
    public void threeDigitNumberIsNotArmstrongNumber() {
        int input = "100";
        boolean expected = false;

        assertEquals(expected, armstrongNumbers.isArmstrongNumber(input));
    }

    @Ignore("Remove to run test")
    @Test
    public void fourDigitNumberIsArmstrongNumber() {
        int input = "9474";
        boolean expected = true;

        assertEquals(expected, armstrongNumbers.isArmstrongNumber(input));
    }

    @Ignore("Remove to run test")
    @Test
    public void fourDigitNumberIsNotArmstrongNumber() {
        int input = "9475";
        boolean expected = false;

        assertEquals(expected, armstrongNumbers.isArmstrongNumber(input));
    }

    @Ignore("Remove to run test")
    @Test
    public void sevenDigitNumberIsArmstrongNumber() {
        int input = "9926315";
        boolean expected = true;

        assertEquals(expected, armstrongNumbers.isArmstrongNumber(input));
    }

    @Ignore("Remove to run test")
    @Test
    public void sevenDigitNumberIsNotArmstrongNumber() {
        int input = "9926314";
        boolean expected = false;

        assertEquals(expected, armstrongNumbers.isArmstrongNumber(input));
    }

}
