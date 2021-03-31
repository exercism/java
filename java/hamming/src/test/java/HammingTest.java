import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Ignore;
import org.junit.Test;

public class HammingTest {

    @Test
    public void testNoDistanceBetweenEmptyStrands() {
        assertEquals(0, new Hamming("", "").getHammingDistance());
    }

    @Test
    public void testNoDistanceBetweenShortIdenticalStrands() {
        assertEquals(0, new Hamming("A", "A").getHammingDistance());
    }

    @Test
    public void testCompleteDistanceInSingleLetterDifferentStrands() {
        assertEquals(1, new Hamming("G", "T").getHammingDistance());
    }

    @Test
    public void testDistanceInLongIdenticalStrands() {
        assertEquals(0, new Hamming("GGACTGAAATCTG", "GGACTGAAATCTG").getHammingDistance());
    }

    @Test
    public void testDistanceInLongDifferentStrands() {
        assertEquals(9, new Hamming("GGACGGATTCTG", "AGGACGGATTCT").getHammingDistance());
    }

    @Test
    public void testValidatesFirstStrandNotLonger() {
        IllegalArgumentException expected =
                assertThrows(
                        IllegalArgumentException.class,
                        () -> new Hamming("AATG", "AAA"));

        assertThat(expected)
                .hasMessage("leftStrand and rightStrand must be of equal length.");
    }

    @Test
    public void testValidatesSecondStrandNotLonger() {
        IllegalArgumentException expected =
                assertThrows(
                        IllegalArgumentException.class,
                        () -> new Hamming("ATA", "AGTG"));

        assertThat(expected)
                .hasMessage("leftStrand and rightStrand must be of equal length.");
    }

    @Test
    public void testDisallowLeftEmptyStrand() {
        IllegalArgumentException expected =
                assertThrows(
                        IllegalArgumentException.class,
                        () -> new Hamming("", "G"));

        assertThat(expected)
                .hasMessage("left strand must not be empty.");
    }

    @Test
    public void testDisallowRightEmptyStrand() {
        IllegalArgumentException expected =
                assertThrows(
                        IllegalArgumentException.class,
                        () -> new Hamming("G", ""));

        assertThat(expected)
                .hasMessage("right strand must not be empty.");
    }

}
