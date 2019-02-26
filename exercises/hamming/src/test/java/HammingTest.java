import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;


public class HammingTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testNoDistanceBetweenEmptyStrands() {
        assertEquals(0, new Hamming("", "").getHammingDistance());
    }

    @Ignore("Remove to run test")
    @Test
    public void testNoDistanceBetweenShortIdenticalStrands() {
        assertEquals(0, new Hamming("A", "A").getHammingDistance());
    }

    @Ignore("Remove to run test")
    @Test
    public void testCompleteDistanceInSingleLetterDifferentStrands() {
        assertEquals(1, new Hamming("G", "T").getHammingDistance());
    }

    @Ignore("Remove to run test")
    @Test
    public void testDistanceInLongIdenticalStrands() {
        assertEquals(0, new Hamming("GGACTGAAATCTG", "GGACTGAAATCTG").getHammingDistance());
    }

    @Ignore("Remove to run test")
    @Test
    public void testDistanceInLongDifferentStrands() {
        assertEquals(9, new Hamming("GGACGGATTCTG", "AGGACGGATTCT").getHammingDistance());
    }

    @Ignore("Remove to run test")
    @Test
    public void testValidatesFirstStrandNotLonger() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("leftStrand and rightStrand must be of equal length.");

        new Hamming("AATG", "AAA");
    }

    @Ignore("Remove to run test")
    @Test
    public void testValidatesSecondStrandNotLonger() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("leftStrand and rightStrand must be of equal length.");

        new Hamming("ATA", "AGTG");
    }

    @Ignore("Remove to run test")
    @Test
    public void testDisallowLeftEmptyStrand() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("left strand must not be empty.");

        new Hamming("", "G");
    }

    @Ignore("Remove to run test")
    @Test
    public void testDisallowRightEmptyStrand() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("right strand must not be empty.");

        new Hamming("G", "");
    }

}
