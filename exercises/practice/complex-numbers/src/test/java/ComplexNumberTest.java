import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ComplexNumberTest {

    // Test helpers

    private static final double DOUBLE_EQUALITY_TOLERANCE = 1e-15;

    private void assertDoublesEqual(double d1, double d2, String numberPart) {
        String errorMessage = "While testing " + numberPart + " part of number,";

        assertEquals(errorMessage, d1, d2, DOUBLE_EQUALITY_TOLERANCE);
    }

    private void assertComplexNumbersEqual(ComplexNumber c1, ComplexNumber c2) {
        assertDoublesEqual(c1.getReal(), c2.getReal(), "real");
        assertDoublesEqual(c1.getImag(), c2.getImag(), "imaginary");
    }

    // Tests

    @Test
    public void testRealPartOfPurelyRealNumber() {
        double expected = 1.0;
        double actual = new ComplexNumber(1.0, 0).getReal();
        assertDoublesEqual(expected, actual, "real");
    }

    @Ignore("Remove to run test")
    @Test
    public void testRealPartOfPurelyImaginaryNumber() {
        double expected = 0.0;
        double actual = new ComplexNumber(0, 1.0).getReal();
        assertDoublesEqual(expected, actual, "real");
    }

    @Ignore("Remove to run test")
    @Test
    public void testRealPartOfNumberWithRealAndImaginaryParts() {
        double expected = 1.0;
        double actual = new ComplexNumber(1.0, 2.0).getReal();
        assertDoublesEqual(expected, actual, "real");
    }

    @Ignore("Remove to run test")
    @Test
    public void testImaginaryPartOfPurelyRealNumber() {
        double expected = 0.0;
        double actual = new ComplexNumber(1.0, 0).getImag();
        assertDoublesEqual(expected, actual, "imaginary");
    }

    @Ignore("Remove to run test")
    @Test
    public void testImaginaryPartOfPurelyImaginaryNumber() {
        double expected = 1.0;
        double actual = new ComplexNumber(0, 1.0).getImag();
        assertDoublesEqual(expected, actual, "imaginary");
    }

    @Ignore("Remove to run test")
    @Test
    public void testImaginaryPartOfNumberWithRealAndImaginaryParts() {
        double expected = 2.0;
        double actual = new ComplexNumber(1.0, 2.0).getImag();
        assertDoublesEqual(expected, actual, "imaginary");
    }

    @Ignore("Remove to run test")
    @Test
    public void testImaginaryUnitExhibitsDefiningProperty() {
        ComplexNumber expected = new ComplexNumber(-1.0, 0);
        ComplexNumber actual = new ComplexNumber(0, 1.0).times(new ComplexNumber(0, 1.0));
        assertComplexNumbersEqual(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void testAdditionWithPurelyRealNumbers() {
        ComplexNumber expected = new ComplexNumber(3.0, 0);
        ComplexNumber actual = new ComplexNumber(1.0, 0).add(new ComplexNumber(2.0, 0));
        assertComplexNumbersEqual(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void testAdditionWithPurelyImaginaryNumbers() {
        ComplexNumber expected = new ComplexNumber(0, 3.0);
        ComplexNumber actual = new ComplexNumber(0, 1.0).add(new ComplexNumber(0, 2.0));
        assertComplexNumbersEqual(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void testAdditionWithRealAndImaginaryParts() {
        ComplexNumber expected = new ComplexNumber(4.0, 6.0);
        ComplexNumber actual = new ComplexNumber(1.0, 2.0).add(new ComplexNumber(3.0, 4.0));
        assertComplexNumbersEqual(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void testSubtractionWithPurelyRealNumbers() {
        ComplexNumber expected = new ComplexNumber(-1.0, 0.0);
        ComplexNumber actual = new ComplexNumber(1.0, 0.0).minus(new ComplexNumber(2.0, 0.0));
        assertComplexNumbersEqual(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void testSubtractionWithPurelyImaginaryNumbers() {
        ComplexNumber expected = new ComplexNumber(0, -1.0);
        ComplexNumber actual = new ComplexNumber(0, 1.0).minus(new ComplexNumber(0, 2.0));
        assertComplexNumbersEqual(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void testSubtractionWithRealAndImaginaryParts() {
        ComplexNumber expected = new ComplexNumber(-2.0, -2.0);
        ComplexNumber actual = new ComplexNumber(1.0, 2.0).minus(new ComplexNumber(3.0, 4.0));
        assertComplexNumbersEqual(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void testMultiplicationWithPurelyRealNumbers() {
        ComplexNumber expected = new ComplexNumber(2.0, 0);
        ComplexNumber actual = new ComplexNumber(1.0, 0).times(new ComplexNumber(2.0, 0));
        assertComplexNumbersEqual(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void testMultiplicationWithPurelyImaginaryNumbers() {
        ComplexNumber expected = new ComplexNumber(-2.0, 0);
        ComplexNumber actual = new ComplexNumber(0, 1.0).times(new ComplexNumber(0, 2.0));
        assertComplexNumbersEqual(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void testMultiplicationWithRealAndImaginaryParts() {
        ComplexNumber expected = new ComplexNumber(-5.0, 10.0);
        ComplexNumber actual = new ComplexNumber(1.0, 2.0).times(new ComplexNumber(3.0, 4.0));
        assertComplexNumbersEqual(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void testDivisionWithPurelyRealNumbers() {
        ComplexNumber expected = new ComplexNumber(0.5, 0);
        ComplexNumber actual = new ComplexNumber(1.0, 0).div(new ComplexNumber(2.0, 0));
        assertComplexNumbersEqual(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void testDivisionWithPurelyImaginaryNumbers() {
        ComplexNumber expected = new ComplexNumber(0.5, 0);
        ComplexNumber actual = new ComplexNumber(0, 1.0).div(new ComplexNumber(0, 2.0));
        assertComplexNumbersEqual(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void testDivisionWithRealAndImaginaryParts() {
        ComplexNumber expected = new ComplexNumber(0.44, 0.08);
        ComplexNumber actual = new ComplexNumber(1.0, 2.0).div(new ComplexNumber(3.0, 4.0));
        assertComplexNumbersEqual(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void testAbsoluteValueOfPositivePurelyRealNumber() {
        double expected = 5.0;
        double actual = new ComplexNumber(5.0, 0).abs();
        assertDoublesEqual(expected, actual, "real");
    }

    @Ignore("Remove to run test")
    @Test
    public void testAbsoluteValueOfNegativePurelyRealNumber() {
        double expected = 5.0;
        double actual = new ComplexNumber(-5.0, 0).abs();
        assertDoublesEqual(expected, actual, "real");
    }

    @Ignore("Remove to run test")
    @Test
    public void testAbsoluteValueOfPurelyImaginaryNumberWithPositiveImaginaryPart() {
        double expected = 5.0;
        double actual = new ComplexNumber(0, 5.0).abs();
        assertDoublesEqual(expected, actual, "real");
    }

    @Ignore("Remove to run test")
    @Test
    public void testAbsoluteValueOfPurelyImaginaryNumberWithNegativeImaginaryPart() {
        double expected = 5.0;
        double actual = new ComplexNumber(0, -5.0).abs();
        assertDoublesEqual(expected, actual, "real");
    }

    @Ignore("Remove to run test")
    @Test
    public void testAbsoluteValueOfNumberWithRealAndImaginaryParts() {
        double expected = 5.0;
        double actual = new ComplexNumber(3.0, 4.0).abs();
        assertDoublesEqual(expected, actual, "real");
    }

    @Ignore("Remove to run test")
    @Test
    public void testConjugationOfPurelyRealNumber() {
        ComplexNumber expected = new ComplexNumber(5.0, 0);
        ComplexNumber actual = new ComplexNumber(5.0, 0).conjugate();
        assertComplexNumbersEqual(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void testConjugationOfPurelyImaginaryNumber() {
        ComplexNumber expected = new ComplexNumber(0, -5.0);
        ComplexNumber actual = new ComplexNumber(0, 5.0).conjugate();
        assertComplexNumbersEqual(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void testConjugationOfNumberWithRealAndImaginaryParts() {
        ComplexNumber expected = new ComplexNumber(1.0, -1.0);
        ComplexNumber actual = new ComplexNumber(1.0, 1.0).conjugate();
        assertComplexNumbersEqual(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void testExponentialOfPurelyImaginaryNumber() {
        ComplexNumber expected = new ComplexNumber(-1.0, 0);
        ComplexNumber actual = new ComplexNumber(0, Math.PI).exponentialOf();
        assertComplexNumbersEqual(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void testExponentialOfZero() {
        ComplexNumber expected = new ComplexNumber(1.0, 0);
        ComplexNumber actual = new ComplexNumber(0, 0).exponentialOf();
        assertComplexNumbersEqual(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void testExponentialOfPurelyRealNumber() {
        ComplexNumber expected = new ComplexNumber(Math.E, 0);
        ComplexNumber actual = new ComplexNumber(1.0, 0).exponentialOf();
        assertComplexNumbersEqual(expected, actual);
    }

    @Ignore("Remove to run test")
    @Test
    public void testExponentialOfNumberWithRealAndImaginaryParts() {
        ComplexNumber expected = new ComplexNumber(-2.0, 0);
        ComplexNumber actual = new ComplexNumber(Math.log(2.0), Math.PI).exponentialOf();
        assertComplexNumbersEqual(expected, actual);
    }

}
