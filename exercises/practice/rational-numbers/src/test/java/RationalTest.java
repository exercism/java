import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RationalTest {

    // Helper methods

    private static final double DOUBLE_EQUALITY_TOLERANCE = 1e-15;

    private void assertDoublesEqual(double x, double y) {
        assertEquals(x, y, DOUBLE_EQUALITY_TOLERANCE);
    }

    // Tests

    @Test
    public void testAddTwoPositiveRationalNumbers() {
        Rational expected = new Rational(7, 6);
        Rational actual = new Rational(1, 2).add(new Rational(2, 3));
        assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void testAddAPositiveRationalNumberAndANegativeRationalNumber() {
        Rational expected = new Rational(-1, 6);
        Rational actual = new Rational(1, 2).add(new Rational(-2, 3));
        assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void testAddTwoNegativeRationalNumbers() {
        Rational expected = new Rational(-7, 6);
        Rational actual = new Rational(-1, 2).add(new Rational(-2, 3));
        assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void testAddARationalNumberToItsAdditiveInverse() {
        Rational expected = new Rational(0, 1);
        Rational actual = new Rational(1, 2).add(new Rational(-1, 2));
        assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void testSubtractTwoPositiveRationalNumbers() {
        Rational expected = new Rational(-1, 6);
        Rational actual = new Rational(1, 2).subtract(new Rational(2, 3));
        assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void testSubtractAPositiveRationalNumberAndANegativeRationalNumber() {
        Rational expected = new Rational(7, 6);
        Rational actual = new Rational(1, 2).subtract(new Rational(-2, 3));
        assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void testSubtractTwoNegativeRationalNumbers() {
        Rational expected = new Rational(1, 6);
        Rational actual = new Rational(-1, 2).subtract(new Rational(-2, 3));
        assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void testSubtractARationalNumberFromItself() {
        Rational expected = new Rational(0, 1);
        Rational actual = new Rational(1, 2).subtract(new Rational(1, 2));
        assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void testMultiplyTwoPositiveRationalNumbers() {
        Rational expected = new Rational(1, 3);
        Rational actual = new Rational(1, 2).multiply(new Rational(2, 3));
        assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void testMultiplyANegativeRationalNumberByAPositiveRationalNumber() {
        Rational expected = new Rational(-1, 3);
        Rational actual = new Rational(-1, 2).multiply(new Rational(2, 3));
        assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void testMultiplyTwoNegativeRationalNumbers() {
        Rational expected = new Rational(1, 3);
        Rational actual = new Rational(-1, 2).multiply(new Rational(-2, 3));
        assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void testMultiplyARationalNumberByItsReciprocal() {
        Rational expected = new Rational(1, 1);
        Rational actual = new Rational(1, 2).multiply(new Rational(2, 1));
        assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void testMultiplyARationalNumberByOne() {
        Rational expected = new Rational(1, 2);
        Rational actual = new Rational(1, 2).multiply(new Rational(1, 1));
        assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void testMultiplyARationalNumberByZero() {
        Rational expected = new Rational(0, 1);
        Rational actual = new Rational(1, 2).multiply(new Rational(0, 1));
        assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void testDivideTwoPositiveRationalNumbers() {
        Rational expected = new Rational(3, 4);
        Rational actual = new Rational(1, 2).divide(new Rational(2, 3));
        assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void testDivideAPositiveRationalNumberByANegativeRationalNumber() {
        Rational expected = new Rational(-3, 4);
        Rational actual = new Rational(1, 2).divide(new Rational(-2, 3));
        assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void testDivideTwoNegativeRationalNumbers() {
        Rational expected = new Rational(3, 4);
        Rational actual = new Rational(-1, 2).divide(new Rational(-2, 3));
        assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void testDivideARationalNumberByOne() {
        Rational expected = new Rational(1, 2);
        Rational actual = new Rational(1, 2).divide(new Rational(1, 1));
        assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void testAbsoluteValueOfAPositiveRationalNumber() {
        Rational expected = new Rational(1, 2);
        Rational actual = new Rational(1, 2).abs();
        assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void testAbsoluteValueOfAPositiveRationalNumberWithNegativeNumeratorAndDenominator() {
        Rational expected = new Rational(1, 2);
        Rational actual = new Rational(-1, -2).abs();
        assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void testAbsoluteValueOfANegativeRationalNumber() {
        Rational expected = new Rational(1, 2);
        Rational actual = new Rational(-1, 2).abs();
        assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void testAbsoluteValueOfANegativeRationalNumberWithNegativeDenominator() {
        Rational expected = new Rational(1, 2);
        Rational actual = new Rational(1, -2).abs();
        assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void testAbsoluteValueOfZero() {
        Rational expected = new Rational(0, 1);
        Rational actual = new Rational(0, 1).abs();
        assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void testRaiseAPositiveRationalNumberToAPositiveIntegerPower() {
        Rational expected = new Rational(1, 8);
        Rational actual = new Rational(1, 2).pow(3);
        assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void testRaiseANegativeRationalNumberToAPositiveIntegerPower() {
        Rational expected = new Rational(-1, 8);
        Rational actual = new Rational(-1, 2).pow(3);
        assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void testRaiseZeroToAnIntegerPower() {
        Rational expected = new Rational(0, 1);
        Rational actual = new Rational(0, 1).pow(5);
        assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void testRaiseOneToAnIntegerPower() {
        Rational expected = new Rational(1, 1);
        Rational actual = new Rational(1, 1).pow(4);
        assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void testRaiseAPositiveRationalNumberToThePowerOfZero() {
        Rational expected = new Rational(1, 1);
        Rational actual = new Rational(-1, 2).pow(0);
        assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void testRaiseARealNumberToAPositiveRationalNumber() {
        double expected = 16.0;
        double actual = new Rational(4, 3).exp(8.0);
        assertDoublesEqual(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void testRaiseARealNumberToANegativeRationalNumber() {
        double expected = 1.0 / 3;
        double actual = new Rational(-1, 2).exp(9);
        assertDoublesEqual(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void testReduceAPositiveRationalNumberToLowestTerms() {
        Rational expected = new Rational(1, 2);
        Rational actual = new Rational(2, 4);
        assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void testReduceANegativeRationalNumberToLowestTerms() {
        Rational expected = new Rational(-2, 3);
        Rational actual = new Rational(-4, 6);
        assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void testReduceARationalNumberWithANegativeDenominatorToLowestTerms() {
        Rational expected = new Rational(-1, 3);
        Rational actual = new Rational(3, -9);
        assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void testReduceZeroToLowestTerms() {
        Rational expected = new Rational(0, 1);
        Rational actual = new Rational(0, 6);
        assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void testReduceAnIntegerToLowestTerms() {
        Rational expected = new Rational(-2, 1);
        Rational actual = new Rational(-14, 7);
        assertEquals(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void testReduceOneToLowestTerms() {
        Rational expected = new Rational(1, 1);
        Rational actual = new Rational(13, 13);
        assertEquals(expected, actual);
    }
}
