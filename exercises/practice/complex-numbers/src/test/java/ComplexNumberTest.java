import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.withPrecision;

public class ComplexNumberTest {

    // Test helpers

    private static final double DOUBLE_EQUALITY_TOLERANCE = 1e-15;

    private void assertDoublesEqual(double d1, double d2, String numberPart) {
        String errorMessage = "While testing " + numberPart + " part of number";

        assertThat(d1).as(errorMessage).isCloseTo(d2, withPrecision(DOUBLE_EQUALITY_TOLERANCE));
    }

    private void assertComplexNumbersEqual(ComplexNumber c1, ComplexNumber c2) {
        assertDoublesEqual(c1.getReal(), c2.getReal(), "real");
        assertDoublesEqual(c1.getImaginary(), c2.getImaginary(), "imaginary");
    }

    // Tests

    @Test
    @DisplayName("Real part of a purely real number")
    public void testRealPartOfPurelyRealNumber() {
        double expected = 1.0;
        double actual = new ComplexNumber(1.0, 0).getReal();
        assertDoublesEqual(expected, actual, "real");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Real part of a purely imaginary number")
    public void testRealPartOfPurelyImaginaryNumber() {
        double expected = 0.0;
        double actual = new ComplexNumber(0, 1.0).getReal();
        assertDoublesEqual(expected, actual, "real");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Real part of a number with real and imaginary part")
    public void testRealPartOfNumberWithRealAndImaginaryParts() {
        double expected = 1.0;
        double actual = new ComplexNumber(1.0, 2.0).getReal();
        assertDoublesEqual(expected, actual, "real");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Imaginary part of a purely real number")
    public void testImaginaryPartOfPurelyRealNumber() {
        double expected = 0.0;
        double actual = new ComplexNumber(1.0, 0).getImaginary();
        assertDoublesEqual(expected, actual, "imaginary");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Imaginary part of a purely imaginary number")
    public void testImaginaryPartOfPurelyImaginaryNumber() {
        double expected = 1.0;
        double actual = new ComplexNumber(0, 1.0).getImaginary();
        assertDoublesEqual(expected, actual, "imaginary");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Imaginary part of a number with real and imaginary part")
    public void testImaginaryPartOfNumberWithRealAndImaginaryParts() {
        double expected = 2.0;
        double actual = new ComplexNumber(1.0, 2.0).getImaginary();
        assertDoublesEqual(expected, actual, "imaginary");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Imaginary unit")
    public void testImaginaryUnitExhibitsDefiningProperty() {
        ComplexNumber expected = new ComplexNumber(-1.0, 0);
        ComplexNumber actual = new ComplexNumber(0, 1.0).multiply(new ComplexNumber(0, 1.0));
        assertComplexNumbersEqual(expected, actual);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Add purely real numbers")
    public void testAdditionWithPurelyRealNumbers() {
        ComplexNumber expected = new ComplexNumber(3.0, 0);
        ComplexNumber actual = new ComplexNumber(1.0, 0).add(new ComplexNumber(2.0, 0));
        assertComplexNumbersEqual(expected, actual);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Add purely imaginary numbers")
    public void testAdditionWithPurelyImaginaryNumbers() {
        ComplexNumber expected = new ComplexNumber(0, 3.0);
        ComplexNumber actual = new ComplexNumber(0, 1.0).add(new ComplexNumber(0, 2.0));
        assertComplexNumbersEqual(expected, actual);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Add numbers with real and imaginary part")
    public void testAdditionWithRealAndImaginaryParts() {
        ComplexNumber expected = new ComplexNumber(4.0, 6.0);
        ComplexNumber actual = new ComplexNumber(1.0, 2.0).add(new ComplexNumber(3.0, 4.0));
        assertComplexNumbersEqual(expected, actual);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Subtract purely real numbers")
    public void testSubtractionWithPurelyRealNumbers() {
        ComplexNumber expected = new ComplexNumber(-1.0, 0.0);
        ComplexNumber actual = new ComplexNumber(1.0, 0.0).subtract(new ComplexNumber(2.0, 0.0));
        assertComplexNumbersEqual(expected, actual);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Subtract purely imaginary numbers")
    public void testSubtractionWithPurelyImaginaryNumbers() {
        ComplexNumber expected = new ComplexNumber(0, -1.0);
        ComplexNumber actual = new ComplexNumber(0, 1.0).subtract(new ComplexNumber(0, 2.0));
        assertComplexNumbersEqual(expected, actual);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Subtract numbers with real and imaginary part")
    public void testSubtractionWithRealAndImaginaryParts() {
        ComplexNumber expected = new ComplexNumber(-2.0, -2.0);
        ComplexNumber actual = new ComplexNumber(1.0, 2.0).subtract(new ComplexNumber(3.0, 4.0));
        assertComplexNumbersEqual(expected, actual);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Multiply purely real numbers")
    public void testMultiplicationWithPurelyRealNumbers() {
        ComplexNumber expected = new ComplexNumber(2.0, 0);
        ComplexNumber actual = new ComplexNumber(1.0, 0).multiply(new ComplexNumber(2.0, 0));
        assertComplexNumbersEqual(expected, actual);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Multiply purely imaginary numbers")
    public void testMultiplicationWithPurelyImaginaryNumbers() {
        ComplexNumber expected = new ComplexNumber(-2.0, 0);
        ComplexNumber actual = new ComplexNumber(0, 1.0).multiply(new ComplexNumber(0, 2.0));
        assertComplexNumbersEqual(expected, actual);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Multiply numbers with real and imaginary part")
    public void testMultiplicationWithRealAndImaginaryParts() {
        ComplexNumber expected = new ComplexNumber(-5.0, 10.0);
        ComplexNumber actual = new ComplexNumber(1.0, 2.0).multiply(new ComplexNumber(3.0, 4.0));
        assertComplexNumbersEqual(expected, actual);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Divide purely real numbers")
    public void testDivisionWithPurelyRealNumbers() {
        ComplexNumber expected = new ComplexNumber(0.5, 0);
        ComplexNumber actual = new ComplexNumber(1.0, 0).divide(new ComplexNumber(2.0, 0));
        assertComplexNumbersEqual(expected, actual);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Divide purely imaginary numbers")
    public void testDivisionWithPurelyImaginaryNumbers() {
        ComplexNumber expected = new ComplexNumber(0.5, 0);
        ComplexNumber actual = new ComplexNumber(0, 1.0).divide(new ComplexNumber(0, 2.0));
        assertComplexNumbersEqual(expected, actual);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Divide numbers with real and imaginary part")
    public void testDivisionWithRealAndImaginaryParts() {
        ComplexNumber expected = new ComplexNumber(0.44, 0.08);
        ComplexNumber actual = new ComplexNumber(1.0, 2.0).divide(new ComplexNumber(3.0, 4.0));
        assertComplexNumbersEqual(expected, actual);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Absolute value of a positive purely real number")
    public void testAbsoluteValueOfPositivePurelyRealNumber() {
        double expected = 5.0;
        double actual = new ComplexNumber(5.0, 0).abs();
        assertDoublesEqual(expected, actual, "real");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Absolute value of a negative purely real number")
    public void testAbsoluteValueOfNegativePurelyRealNumber() {
        double expected = 5.0;
        double actual = new ComplexNumber(-5.0, 0).abs();
        assertDoublesEqual(expected, actual, "real");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Absolute value of a purely imaginary number with positive imaginary part")
    public void testAbsoluteValueOfPurelyImaginaryNumberWithPositiveImaginaryPart() {
        double expected = 5.0;
        double actual = new ComplexNumber(0, 5.0).abs();
        assertDoublesEqual(expected, actual, "real");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Absolute value of a purely imaginary number with negative imaginary part")
    public void testAbsoluteValueOfPurelyImaginaryNumberWithNegativeImaginaryPart() {
        double expected = 5.0;
        double actual = new ComplexNumber(0, -5.0).abs();
        assertDoublesEqual(expected, actual, "real");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Absolute value of a number with real and imaginary part")
    public void testAbsoluteValueOfNumberWithRealAndImaginaryParts() {
        double expected = 5.0;
        double actual = new ComplexNumber(3.0, 4.0).abs();
        assertDoublesEqual(expected, actual, "real");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Conjugate a purely real number")
    public void testConjugationOfPurelyRealNumber() {
        ComplexNumber expected = new ComplexNumber(5.0, 0);
        ComplexNumber actual = new ComplexNumber(5.0, 0).conjugate();
        assertComplexNumbersEqual(expected, actual);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Conjugate a purely imaginary number")
    public void testConjugationOfPurelyImaginaryNumber() {
        ComplexNumber expected = new ComplexNumber(0, -5.0);
        ComplexNumber actual = new ComplexNumber(0, 5.0).conjugate();
        assertComplexNumbersEqual(expected, actual);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Conjugate a number with real and imaginary part")
    public void testConjugationOfNumberWithRealAndImaginaryParts() {
        ComplexNumber expected = new ComplexNumber(1.0, -1.0);
        ComplexNumber actual = new ComplexNumber(1.0, 1.0).conjugate();
        assertComplexNumbersEqual(expected, actual);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Euler's identity/formula")
    public void testExponentialOfPurelyImaginaryNumber() {
        ComplexNumber expected = new ComplexNumber(-1.0, 0);
        ComplexNumber actual = new ComplexNumber(0, Math.PI).exponentialOf();
        assertComplexNumbersEqual(expected, actual);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Exponential of 0")
    public void testExponentialOfZero() {
        ComplexNumber expected = new ComplexNumber(1.0, 0);
        ComplexNumber actual = new ComplexNumber(0, 0).exponentialOf();
        assertComplexNumbersEqual(expected, actual);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Exponential of a purely real number")
    public void testExponentialOfPurelyRealNumber() {
        ComplexNumber expected = new ComplexNumber(Math.E, 0);
        ComplexNumber actual = new ComplexNumber(1.0, 0).exponentialOf();
        assertComplexNumbersEqual(expected, actual);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Exponential resulting in a number with real and imaginary part")
    public void testExponentialOfNumberWithRealAndImaginaryParts() {
        ComplexNumber expected = new ComplexNumber(1, 1);
        ComplexNumber actual = new ComplexNumber(Math.log(2.0) / 2, Math.PI / 4).exponentialOf();
        assertComplexNumbersEqual(expected, actual);
    }

}
