import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class NaturalNumberTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testSmallPerfectNumberIsClassifiedCorrectly() {
        assertEquals(Classification.PERFECT, new NaturalNumber(6).getClassification());
    }

    @Ignore("Remove to run test")
    @Test
    public void testMediumPerfectNumberIsClassifiedCorrectly() {
        assertEquals(Classification.PERFECT, new NaturalNumber(28).getClassification());
    }

    @Ignore("Remove to run test")
    @Test
    public void testLargePerfectNumberIsClassifiedCorrectly() {
        assertEquals(Classification.PERFECT, new NaturalNumber(33550336).getClassification());
    }

    @Ignore("Remove to run test")
    @Test
    public void testSmallAbundantNumberIsClassifiedCorrectly() {
        assertEquals(Classification.ABUNDANT, new NaturalNumber(12).getClassification());
    }

    @Ignore("Remove to run test")
    @Test
    public void testMediumAbundantNumberIsClassifiedCorrectly() {
        assertEquals(Classification.ABUNDANT, new NaturalNumber(30).getClassification());
    }

    @Ignore("Remove to run test")
    @Test
    public void testLargeAbundantNumberIsClassifiedCorrectly() {
        assertEquals(Classification.ABUNDANT, new NaturalNumber(33550335).getClassification());
    }

    @Ignore("Remove to run test")
    @Test
    public void testSmallestPrimeDeficientNumberIsClassifiedCorrectly() {
        assertEquals(Classification.DEFICIENT, new NaturalNumber(2).getClassification());
    }

    @Ignore("Remove to run test")
    @Test
    public void testSmallestNonPrimeDeficientNumberIsClassifiedCorrectly() {
        assertEquals(Classification.DEFICIENT, new NaturalNumber(4).getClassification());
    }

    @Ignore("Remove to run test")
    @Test
    public void testMediumDeficientNumberIsClassifiedCorrectly() {
        assertEquals(Classification.DEFICIENT, new NaturalNumber(32).getClassification());
    }

    @Ignore("Remove to run test")
    @Test
    public void testLargeDeficientNumberIsClassifiedCorrectly() {
        assertEquals(Classification.DEFICIENT, new NaturalNumber(33550337).getClassification());
    }

    @Ignore("Remove to run test")
    @Test
    /*
     * The number 1 has no proper divisors (https://en.wikipedia.org/wiki/Divisor#Further_notions_and_facts), and the
     * additive identity is 0, so the aliquot sum of 1 should be 0. Hence 1 should be classified as deficient.
     */
    public void testThatOneIsCorrectlyClassifiedAsDeficient() {
        assertEquals(Classification.DEFICIENT, new NaturalNumber(1).getClassification());
    }

    @Ignore("Remove to run test")
    @Test
    public void testThatNonNegativeIntegerIsRejected() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("You must supply a natural number (positive integer)");

        new NaturalNumber(0);
    }

    @Ignore("Remove to run test")
    @Test
    public void testThatNegativeIntegerIsRejected() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("You must supply a natural number (positive integer)");

        new NaturalNumber(-1);
    }

}
