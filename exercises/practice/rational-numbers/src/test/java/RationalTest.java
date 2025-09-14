import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

public class RationalTest {

    // Helper methods

    private static final double DOUBLE_EQUALITY_TOLERANCE = 1e-8;

    private void assertDoublesEqual(double x, double y) {
        assertThat(x).isCloseTo(y, within(DOUBLE_EQUALITY_TOLERANCE));
    }

    // Tests

    @Test
    @DisplayName("Add two positive rational numbers")
    public void testAddTwoPositiveRationalNumbers() {
        Rational expected = new Rational(7, 6);
        Rational actual = new Rational(1, 2).add(new Rational(2, 3));
        assertThat(actual).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Add a positive rational number and a negative rational number")
    public void testAddAPositiveRationalNumberAndANegativeRationalNumber() {
        Rational expected = new Rational(-1, 6);
        Rational actual = new Rational(1, 2).add(new Rational(-2, 3));
        assertThat(actual).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Add two negative rational numbers")
    public void testAddTwoNegativeRationalNumbers() {
        Rational expected = new Rational(-7, 6);
        Rational actual = new Rational(-1, 2).add(new Rational(-2, 3));
        assertThat(actual).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Add a rational number to its additive inverse")
    public void testAddARationalNumberToItsAdditiveInverse() {
        Rational expected = new Rational(0, 1);
        Rational actual = new Rational(1, 2).add(new Rational(-1, 2));
        assertThat(actual).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Subtract two positive rational numbers")
    public void testSubtractTwoPositiveRationalNumbers() {
        Rational expected = new Rational(-1, 6);
        Rational actual = new Rational(1, 2).subtract(new Rational(2, 3));
        assertThat(actual).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Subtract a positive rational number and a negative rational number")
    public void testSubtractAPositiveRationalNumberAndANegativeRationalNumber() {
        Rational expected = new Rational(7, 6);
        Rational actual = new Rational(1, 2).subtract(new Rational(-2, 3));
        assertThat(actual).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Subtract two negative rational numbers")
    public void testSubtractTwoNegativeRationalNumbers() {
        Rational expected = new Rational(1, 6);
        Rational actual = new Rational(-1, 2).subtract(new Rational(-2, 3));
        assertThat(actual).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Subtract a rational number from itself")
    public void testSubtractARationalNumberFromItself() {
        Rational expected = new Rational(0, 1);
        Rational actual = new Rational(1, 2).subtract(new Rational(1, 2));
        assertThat(actual).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Multiply two positive rational numbers")
    public void testMultiplyTwoPositiveRationalNumbers() {
        Rational expected = new Rational(1, 3);
        Rational actual = new Rational(1, 2).multiply(new Rational(2, 3));
        assertThat(actual).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Multiply a negative rational number by a positive rational number")
    public void testMultiplyANegativeRationalNumberByAPositiveRationalNumber() {
        Rational expected = new Rational(-1, 3);
        Rational actual = new Rational(-1, 2).multiply(new Rational(2, 3));
        assertThat(actual).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Multiply two negative rational numbers")
    public void testMultiplyTwoNegativeRationalNumbers() {
        Rational expected = new Rational(1, 3);
        Rational actual = new Rational(-1, 2).multiply(new Rational(-2, 3));
        assertThat(actual).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Multiply a rational number by its reciprocal")
    public void testMultiplyARationalNumberByItsReciprocal() {
        Rational expected = new Rational(1, 1);
        Rational actual = new Rational(1, 2).multiply(new Rational(2, 1));
        assertThat(actual).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Multiply a rational number by 1")
    public void testMultiplyARationalNumberByOne() {
        Rational expected = new Rational(1, 2);
        Rational actual = new Rational(1, 2).multiply(new Rational(1, 1));
        assertThat(actual).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Multiply a rational number by 0")
    public void testMultiplyARationalNumberByZero() {
        Rational expected = new Rational(0, 1);
        Rational actual = new Rational(1, 2).multiply(new Rational(0, 1));
        assertThat(actual).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Divide two positive rational numbers")
    public void testDivideTwoPositiveRationalNumbers() {
        Rational expected = new Rational(3, 4);
        Rational actual = new Rational(1, 2).divide(new Rational(2, 3));
        assertThat(actual).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Divide a positive rational number by a negative rational number")
    public void testDivideAPositiveRationalNumberByANegativeRationalNumber() {
        Rational expected = new Rational(-3, 4);
        Rational actual = new Rational(1, 2).divide(new Rational(-2, 3));
        assertThat(actual).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Divide two negative rational numbers")
    public void testDivideTwoNegativeRationalNumbers() {
        Rational expected = new Rational(3, 4);
        Rational actual = new Rational(-1, 2).divide(new Rational(-2, 3));
        assertThat(actual).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Divide a rational number by 1")
    public void testDivideARationalNumberByOne() {
        Rational expected = new Rational(1, 2);
        Rational actual = new Rational(1, 2).divide(new Rational(1, 1));
        assertThat(actual).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Absolute value of a positive rational number")
    public void testAbsoluteValueOfAPositiveRationalNumber() {
        Rational expected = new Rational(1, 2);
        Rational actual = new Rational(1, 2).abs();
        assertThat(actual).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Absolute value of a positive rational number with negative numerator and denominator")
    public void testAbsoluteValueOfAPositiveRationalNumberWithNegativeNumeratorAndDenominator() {
        Rational expected = new Rational(1, 2);
        Rational actual = new Rational(-1, -2).abs();
        assertThat(actual).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Absolute value of a negative rational number")
    public void testAbsoluteValueOfANegativeRationalNumber() {
        Rational expected = new Rational(1, 2);
        Rational actual = new Rational(-1, 2).abs();
        assertThat(actual).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("\"Absolute value of a negative rational number with negative denominator")
    public void testAbsoluteValueOfANegativeRationalNumberWithNegativeDenominator() {
        Rational expected = new Rational(1, 2);
        Rational actual = new Rational(1, -2).abs();
        assertThat(actual).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Absolute value of zero")
    public void testAbsoluteValueOfZero() {
        Rational expected = new Rational(0, 1);
        Rational actual = new Rational(0, 1).abs();
        assertThat(actual).isEqualTo(expected);
    }
    
    @Disabled("Remove to run test")
    @Test
    @DisplayName("Absolute value of a rational number is reduced to lowest terms")
    public void testAbsoluteValueOfARationalNumberIsReducedToLowestTerms() {
        Rational expected = new Rational(1, 2);
        Rational actual = new Rational(2, 4).abs();
        assertThat(actual).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Raise a positive rational number to a positive integer power")
    public void testRaiseAPositiveRationalNumberToAPositiveIntegerPower() {
        Rational expected = new Rational(1, 8);
        Rational actual = new Rational(1, 2).pow(3);
        assertThat(actual).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Raise a negative rational number to a positive integer power")
    public void testRaiseANegativeRationalNumberToAPositiveIntegerPower() {
        Rational expected = new Rational(-1, 8);
        Rational actual = new Rational(-1, 2).pow(3);
        assertThat(actual).isEqualTo(expected);
    }
    
    @Disabled("Remove to run test")
    @Test
    @DisplayName("Raise a positive rational number to a negative integer power")
    public void testRaiseAPositiveRationalNumberToANegativeIntegerPower() {
        Rational expected = new Rational(25, 9);
        Rational actual = new Rational(3, 5).pow(-2);
        assertThat(actual).isEqualTo(expected);
    }
    
    @Disabled("Remove to run test")
    @Test
    @DisplayName("\"Raise a negative rational number to an even negative integer power")
    public void testRaiseANegativeRationalNumberToAnEvenNegativeIntegerPower() {
        Rational expected = new Rational(25, 9);
        Rational actual = new Rational(-3, 5).pow(-2);
        assertThat(actual).isEqualTo(expected);
    }
    
    @Disabled("Remove to run test")
    @Test
    @DisplayName("Raise a negative rational number to an odd negative integer power")
    public void testRaiseANegativeRationalNumberToAnOddNegativeIntegerPower() {
        Rational expected = new Rational(-125, 27);
        Rational actual = new Rational(-3, 5).pow(-3);
        assertThat(actual).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Raise zero to an integer power")
    public void testRaiseZeroToAnIntegerPower() {
        Rational expected = new Rational(0, 1);
        Rational actual = new Rational(0, 1).pow(5);
        assertThat(actual).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Raise one to an integer power")
    public void testRaiseOneToAnIntegerPower() {
        Rational expected = new Rational(1, 1);
        Rational actual = new Rational(1, 1).pow(4);
        assertThat(actual).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Raise a positive rational number to the power of zero")
    public void testRaiseAPositiveRationalNumberToThePowerOfZero() {
        Rational expected = new Rational(1, 1);
        Rational actual = new Rational(-1, 2).pow(0);
        assertThat(actual).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Raise a real number to a positive rational number")
    public void testRaiseARealNumberToAPositiveRationalNumber() {
        double expected = 16.0;
        double actual = new Rational(4, 3).exp(8.0);
        assertDoublesEqual(expected, actual);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Raise a real number to a negative rational number")
    public void testRaiseARealNumberToANegativeRationalNumber() {
        double expected = 1.0 / 3;
        double actual = new Rational(-1, 2).exp(9);
        assertDoublesEqual(expected, actual);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Reduce a positive rational number to lowest terms")
    public void testReduceAPositiveRationalNumberToLowestTerms() {
        Rational expected = new Rational(1, 2);
        Rational actual = new Rational(2, 4);
        assertThat(actual).isEqualTo(expected);
    }
    
    @Disabled("Remove to run test")
    @Test
    @DisplayName("Reduce places the minus sign on the numerator")
    public void testReducePlacesTheMinusSignOnTheNumerator() {
        Rational expected = new Rational(-3, 4);
        Rational actual = new Rational(3, -4);
        assertThat(actual).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Reduce a negative rational number to lowest terms")
    public void testReduceANegativeRationalNumberToLowestTerms() {
        Rational expected = new Rational(-2, 3);
        Rational actual = new Rational(-4, 6);
        assertThat(actual).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Reduce a rational number with a negative denominator to lowest terms")
    public void testReduceARationalNumberWithANegativeDenominatorToLowestTerms() {
        Rational expected = new Rational(-1, 3);
        Rational actual = new Rational(3, -9);
        assertThat(actual).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Reduce zero to lowest terms")
    public void testReduceZeroToLowestTerms() {
        Rational expected = new Rational(0, 1);
        Rational actual = new Rational(0, 6);
        assertThat(actual).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Reduce an integer to lowest terms")
    public void testReduceAnIntegerToLowestTerms() {
        Rational expected = new Rational(-2, 1);
        Rational actual = new Rational(-14, 7);
        assertThat(actual).isEqualTo(expected);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Reduce one to lowest terms")
    public void testReduceOneToLowestTerms() {
        Rational expected = new Rational(1, 1);
        Rational actual = new Rational(13, 13);
        assertThat(actual).isEqualTo(expected);
    }
}
