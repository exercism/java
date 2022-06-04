import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

public class HammingTest {

    @Test
    public void testNoDistanceBetweenEmptyStrands() {
        assertThat(new Hamming("", "").getHammingDistance()).isEqualTo(0);
    }

    @Test
    public void testNoDistanceBetweenShortIdenticalStrands() {
        assertThat(new Hamming("A", "A").getHammingDistance()).isEqualTo(0);
    }

    @Test
    public void testCompleteDistanceInSingleLetterDifferentStrands() {
        assertThat(new Hamming("G", "T").getHammingDistance()).isEqualTo(1);
    }

    @Test
    public void testDistanceInLongIdenticalStrands() {
        assertThat(new Hamming("GGACTGAAATCTG", "GGACTGAAATCTG").getHammingDistance()).isEqualTo(0);
    }

    @Test
    public void testDistanceInLongDifferentStrands() {
        assertThat(new Hamming("GGACGGATTCTG", "AGGACGGATTCT").getHammingDistance()).isEqualTo(9);
    }

    @Test
    public void testValidatesFirstStrandNotLonger() {
        IllegalArgumentException expected = assertThrows(
                IllegalArgumentException.class,
                () -> new Hamming("AATG", "AAA"));

        assertThat(expected)
                .hasMessage("leftStrand and rightStrand must be of equal length.");
    }

    @Test
    public void testValidatesSecondStrandNotLonger() {
        IllegalArgumentException expected = assertThrows(
                IllegalArgumentException.class,
                () -> new Hamming("ATA", "AGTG"));

        assertThat(expected)
                .hasMessage("leftStrand and rightStrand must be of equal length.");
    }

    @Test
    public void testDisallowLeftEmptyStrand() {
        IllegalArgumentException expected = assertThrows(
                IllegalArgumentException.class,
                () -> new Hamming("", "G"));

        assertThat(expected)
                .hasMessage("left strand must not be empty.");
    }

    @Test
    public void testDisallowRightEmptyStrand() {
        IllegalArgumentException expected = assertThrows(
                IllegalArgumentException.class,
                () -> new Hamming("G", ""));

        assertThat(expected)
                .hasMessage("right strand must not be empty.");
    }

}
