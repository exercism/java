import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.Ignore;
import org.junit.Test;

public class HammingTest {

    @Test
    public void testNoDistanceBetweenEmptyStrands() {
        assertThat(new Hamming("", "").getHammingDistance()).isEqualTo(0);
    }

    @Ignore("Remove to run test")
    @Test
    public void testNoDistanceBetweenShortIdenticalStrands() {
        assertThat(new Hamming("A", "A").getHammingDistance()).isEqualTo(0);
    }

    @Ignore("Remove to run test")
    @Test
    public void testCompleteDistanceInSingleLetterDifferentStrands() {
        assertThat(new Hamming("G", "T").getHammingDistance()).isEqualTo(1);
    }

    @Ignore("Remove to run test")
    @Test
    public void testDistanceInLongIdenticalStrands() {
        assertThat(new Hamming("GGACTGAAATCTG", "GGACTGAAATCTG").getHammingDistance()).isEqualTo(0);
    }

    @Ignore("Remove to run test")
    @Test
    public void testDistanceInLongDifferentStrands() {
        assertThat(new Hamming("GGACGGATTCTG", "AGGACGGATTCT").getHammingDistance()).isEqualTo(9);
    }

    @Ignore("Remove to run test")
    @Test
    public void testValidatesFirstStrandNotLonger() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Hamming("AATG", "AAA"))
                .withMessage("leftStrand and rightStrand must be of equal length.");
    }

    @Ignore("Remove to run test")
    @Test
    public void testValidatesSecondStrandNotLonger() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Hamming("ATA", "AGTG"))
                .withMessage("leftStrand and rightStrand must be of equal length.");
    }

    @Ignore("Remove to run test")
    @Test
    public void testDisallowLeftEmptyStrand() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Hamming("", "G"))
                .withMessage("left strand must not be empty.");
    }

    @Ignore("Remove to run test")
    @Test
    public void testDisallowRightEmptyStrand() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Hamming("G", ""))
                .withMessage("right strand must not be empty.");
    }

}
