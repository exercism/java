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
    public void testAddAPositiveRationalNumberAndANegativeRationalNumber() {
        Rational expected = new Rational(-1, 6);
        Rational actual = new Rational(1, 2).add(new Rational(-2, 3));
        assertRationalsEqual(expected, actual);
    }

    @Test
    public void testAddTwoNegativeRationalNumbers() {
        Rational expected = new Rational(-7, 6);
        Rational actual = new Rational(-1, 2).add(new Rational(-2, 3));
        assertRationalsEqual(expected, actual);
    }

    @Test
    public void testAddARationalNumberToItsAdditiveInverse() {
        Rational expected = new Rational(0, 1);
        Rational actual = new Rational(1, 2).add(new Rational(-1, 2));
        assertRationalsEqual(expected, actual);
    }

    @Test
    public void testSubtractTwoPositiveRationalNumbers() {
        Rational expected = new Rational(-1, 6);
        Rational actual = new Rational(1, 2).subtract(new Rational(2, 3));
        assertRationalsEqual(expected, actual);
    }

    @Test
    public void testSubtractAPositiveRationalNumberAndANegativeRationalNumber() {
        Rational expected = new Rational(7, 6);
        Rational actual = new Rational(1, 2).subtract(new Rational(-2, 3));
        assertRationalsEqual(expected, actual);
    }

    @Test
    public void testSubtractTwoNegativeRationalNumbers() {
        Rational expected = new Rational(1, 6);
        Rational actual = new Rational(-1, 2).subtract(new Rational(-2, 3));
        assertRationalsEqual(expected, actual);
    }

    @Test
    public void testSubtractARationalNumberFromItself() {
        Rational expected = new Rational(0, 1);
        Rational actual = new Rational(1, 2).subtract(new Rational(1, 2));
        assertRationalsEqual(expected, actual);
    }

    @Test
    public void testMultiplyTwoPositiveRationalNumbers() {
        Rational expected = new Rational(1, 3);
        Rational actual = new Rational(1, 2).multiply(new Rational(2, 3));
        assertRationalsEqual(expected, actual);
    }

    @Test
    public void testMultiplyANegativeRationalNumberByAPositiveRationalNumber() {
        Rational expected = new Rational(-1, 3);
        Rational actual = new Rational(-1, 2).multiply(new Rational(2, 3));
        assertRationalsEqual(expected, actual);
    }

    @Test
    public void testMultiplyTwoNegativeRationalNumbers() {
        Rational expected = new Rational(1, 3);
        Rational actual = new Rational(-1, 2).multiply(new Rational(-2, 3));
        assertRationalsEqual(expected, actual);
    }

    @Test
    public void testMultiplyARationalNumberByItsReciprocal() {
        Rational expected = new Rational(1, 1);
        Rational actual = new Rational(1, 2).multiply(new Rational(2, 1));
        assertRationalsEqual(expected, actual);
    }

    @Test
    public void testMultiplyARationalNumberBy1() {
        Rational expected = new Rational(1, 2);
        Rational actual = new Rational(1, 2).multiply(new Rational(1, 1));
        assertRationalsEqual(expected, actual);
    }

    @Test
    public void testMultiplyARationalNumberBy0() {
        Rational expected = new Rational(0, 1);
        Rational actual = new Rational(1, 2).multiply(new Rational(0, 1));
        assertRationalsEqual(expected, actual);
    }

    @Test
    public void testDivideTwoPositiveRationalNumbers() {
        Rational expected = new Rational(3, 4);
        Rational actual = new Rational(1, 2).divide(new Rational(2, 3));
        assertRationalsEqual(expected, actual);
    }

    @Test
    public void testDivideAPositiveRationalNumberByANegativeRationalNumber() {
        Rational expected = new Rational(-3, 4);
        Rational actual = new Rational(1, 2).divide(new Rational(-2, 3));
        assertRationalsEqual(expected, actual);
    }

    @Test
    public void testDivideTwoNegativeRationalNumbers() {
        Rational expected = new Rational(3, 4);
        Rational actual = new Rational(-1, 2).divide(new Rational(-2, 3));
        assertRationalsEqual(expected, actual);
    }

    @Test
    public void testDivideARationalNumberBy1() {
        Rational expected = new Rational(1, 2);
        Rational actual = new Rational(1, 2).divide(new Rational(1, 1));
        assertRationalsEqual(expected, actual);
    }

    @Test
    public void testAbsoluteValueOfAPositiveRationalNumber() {
        Rational expected = new Rational(1, 2);
        Rational actual = new Rational(1, 2).abs();
        assertRationalsEqual(expected, actual);
    }

    @Test
    public void testAbsoluteValueOfANegativeRationalNumber() {
        Rational expected = new Rational(1, 2);
        Rational actual = new Rational(-1, 2).abs();
        assertRationalsEqual(expected, actual);
    }

    @Test
    public void testAbsoluteValueOf0() {
        Rational expected = new Rational(0, 1);
        Rational actual = new Rational(0, 1).abs();
        assertRationalsEqual(expected, actual);
    }

}
