import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RationalTest {

    // Helper methods

    private static final double DOUBLE_EQUALITY_TOLERANCE = 1e-15;

    private void assertDoublesEqual(double x, double y) {
        assertEquals(x, y, DOUBLE_EQUALITY_TOLERANCE);
    }

    private void assertRationalsEqual(Rational r1, Rational r2) {
        assertEquals(r1.getNumerator(), r2.getNumerator());
        assertEquals(r1.getDenominator(), r2.getDenominator());
    }

    // Tests

    @Test
    public void testAddTwoPositiveRationalNumbers() {
        Rational expected = new Rational(7, 6);
        Rational actual = new Rational(1, 2).add(new Rational(2, 3));
        assertRationalsEqual(expected, actual);
    }

    @Test
    @Ignore
    public void testAddAPositiveRationalNumberAndANegativeRationalNumber() {
        Rational expected = new Rational(-1, 6);
        Rational actual = new Rational(1, 2).add(new Rational(-2, 3));
        assertRationalsEqual(expected, actual);
    }

    @Test
    @Ignore
    public void testAddTwoNegativeRationalNumbers() {
        Rational expected = new Rational(-7, 6);
        Rational actual = new Rational(-1, 2).add(new Rational(-2, 3));
        assertRationalsEqual(expected, actual);
    }

    @Test
    @Ignore
    public void testAddARationalNumberToItsAdditiveInverse() {
        Rational expected = new Rational(0, 1);
        Rational actual = new Rational(1, 2).add(new Rational(-1, 2));
        assertRationalsEqual(expected, actual);
    }

    @Test
    @Ignore
    public void testSubtractTwoPositiveRationalNumbers() {
        Rational expected = new Rational(-1, 6);
        Rational actual = new Rational(1, 2).subtract(new Rational(2, 3));
        assertRationalsEqual(expected, actual);
    }

    @Test
    @Ignore
    public void testSubtractAPositiveRationalNumberAndANegativeRationalNumber() {
        Rational expected = new Rational(7, 6);
        Rational actual = new Rational(1, 2).subtract(new Rational(-2, 3));
        assertRationalsEqual(expected, actual);
    }

    @Test
    @Ignore
    public void testSubtractTwoNegativeRationalNumbers() {
        Rational expected = new Rational(1, 6);
        Rational actual = new Rational(-1, 2).subtract(new Rational(-2, 3));
        assertRationalsEqual(expected, actual);
    }

    @Test
    @Ignore
    public void testSubtractARationalNumberFromItself() {
        Rational expected = new Rational(0, 1);
        Rational actual = new Rational(1, 2).subtract(new Rational(1, 2));
        assertRationalsEqual(expected, actual);
    }

    @Test
    @Ignore
    public void testMultiplyTwoPositiveRationalNumbers() {
        Rational expected = new Rational(1, 3);
        Rational actual = new Rational(1, 2).multiply(new Rational(2, 3));
        assertRationalsEqual(expected, actual);
    }

    @Test
    @Ignore
    public void testMultiplyANegativeRationalNumberByAPositiveRationalNumber() {
        Rational expected = new Rational(-1, 3);
        Rational actual = new Rational(-1, 2).multiply(new Rational(2, 3));
        assertRationalsEqual(expected, actual);
    }

    @Test
    @Ignore
    public void testMultiplyTwoNegativeRationalNumbers() {
        Rational expected = new Rational(1, 3);
        Rational actual = new Rational(-1, 2).multiply(new Rational(-2, 3));
        assertRationalsEqual(expected, actual);
    }

    @Test
    @Ignore
    public void testMultiplyARationalNumberByItsReciprocal() {
        Rational expected = new Rational(1, 1);
        Rational actual = new Rational(1, 2).multiply(new Rational(2, 1));
        assertRationalsEqual(expected, actual);
    }

    @Test
    @Ignore
    public void testMultiplyARationalNumberByOne() {
        Rational expected = new Rational(1, 2);
        Rational actual = new Rational(1, 2).multiply(new Rational(1, 1));
        assertRationalsEqual(expected, actual);
    }

    @Test
    @Ignore
    public void testMultiplyARationalNumberByZero() {
        Rational expected = new Rational(0, 1);
        Rational actual = new Rational(1, 2).multiply(new Rational(0, 1));
        assertRationalsEqual(expected, actual);
    }

    @Test
    @Ignore
    public void testDivideTwoPositiveRationalNumbers() {
        Rational expected = new Rational(3, 4);
        Rational actual = new Rational(1, 2).divide(new Rational(2, 3));
        assertRationalsEqual(expected, actual);
    }

    @Test
    @Ignore
    public void testDivideAPositiveRationalNumberByANegativeRationalNumber() {
        Rational expected = new Rational(-3, 4);
        Rational actual = new Rational(1, 2).divide(new Rational(-2, 3));
        assertRationalsEqual(expected, actual);
    }

    @Test
    @Ignore
    public void testDivideTwoNegativeRationalNumbers() {
        Rational expected = new Rational(3, 4);
        Rational actual = new Rational(-1, 2).divide(new Rational(-2, 3));
        assertRationalsEqual(expected, actual);
    }

    @Test
    @Ignore
    public void testDivideARationalNumberByOne() {
        Rational expected = new Rational(1, 2);
        Rational actual = new Rational(1, 2).divide(new Rational(1, 1));
        assertRationalsEqual(expected, actual);
    }

    @Test
    @Ignore
    public void testAbsoluteValueOfAPositiveRationalNumber() {
        Rational expected = new Rational(1, 2);
        Rational actual = new Rational(1, 2).abs();
        assertRationalsEqual(expected, actual);
    }

    @Test
    @Ignore
    public void testAbsoluteValueOfANegativeRationalNumber() {
        Rational expected = new Rational(1, 2);
        Rational actual = new Rational(-1, 2).abs();
        assertRationalsEqual(expected, actual);
    }

    @Test
    @Ignore
    public void testAbsoluteValueOfZero() {
        Rational expected = new Rational(0, 1);
        Rational actual = new Rational(0, 1).abs();
        assertRationalsEqual(expected, actual);
    }

    @Test
    @Ignore
    public void testRaiseAPositiveRationalNumberToAPositiveIntegerPower() {
        Rational expected = new Rational(1, 8);
        Rational actual = new Rational(1, 2).pow(3);
        assertRationalsEqual(expected, actual);
    }

    @Test
    @Ignore
    public void testRaiseANegativeRationalNumberToAPositiveIntegerPower() {
        Rational expected = new Rational(-1, 8);
        Rational actual = new Rational(-1, 2).pow(3);
        assertRationalsEqual(expected, actual);
    }

    @Test
    @Ignore
    public void testRaiseZeroToAnIntegerPower() {
        Rational expected = new Rational(0, 1);
        Rational actual = new Rational(0, 1).pow(5);
        assertRationalsEqual(expected, actual);
    }

    @Test
    @Ignore
    public void testRaiseOneToAnIntegerPower() {
        Rational expected = new Rational(1, 1);
        Rational actual = new Rational(1, 1).pow(4);
        assertRationalsEqual(expected, actual);
    }

    @Test
    @Ignore
    public void testRaiseAPositiveRationalNumberToThePowerOfZero() {
        Rational expected = new Rational(1, 1);
        Rational actual = new Rational(-1, 2).pow(0);
        assertRationalsEqual(expected, actual);
    }

    @Test
    @Ignore
    public void testRaiseARealNumberToAPositiveRationalNumber() {
        double expected = 16.0;
        double actual = new Rational(4, 3).exp(8.0);
        assertDoublesEqual(expected, actual);
    }

    @Test
    @Ignore
    public void testRaiseARealNumberToANegativeRationalNumber() {
        double expected = 1.0 / 3;
        double actual = new Rational(-1, 2).exp(9);
        assertDoublesEqual(expected, actual);
    }

    @Test
    @Ignore
    public void testReduceAPositiveRationalNumberToLowestTerms() {
        Rational expected = new Rational(1, 2);
        Rational actual = new Rational(2, 4);
        assertRationalsEqual(expected, actual);
    }

    @Test
    @Ignore
    public void testReduceANegativeRationalNumberToLowestTerms() {
        Rational expected = new Rational(-2, 3);
        Rational actual = new Rational(-4, 6);
        assertRationalsEqual(expected, actual);
    }

    @Test
    @Ignore
    public void testReduceARationalNumberWithANegativeDenominatorToLowestTerms() {
        Rational expected = new Rational(-1, 3);
        Rational actual = new Rational(3, -9);
        assertRationalsEqual(expected, actual);
    }

    @Test
    @Ignore
    public void testReduceZeroToLowestTerms() {
        Rational expected = new Rational(0, 1);
        Rational actual = new Rational(0, 6);
        assertRationalsEqual(expected, actual);
    }

    @Test
    @Ignore
    public void testReduceAnIntegerToLowestTerms() {
        Rational expected = new Rational(-2, 1);
        Rational actual = new Rational(-14, 7);
        assertRationalsEqual(expected, actual);
    }

    @Test
    @Ignore
    public void testReduceOneToLowestTerms() {
        Rational expected = new Rational(1, 1);
        Rational actual = new Rational(13, 13);
        assertRationalsEqual(expected, actual);
    }
}
