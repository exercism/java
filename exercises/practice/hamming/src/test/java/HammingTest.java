import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class HammingTest {

    @Test
    @DisplayName("empty strands")
    public void testNoDistanceBetweenEmptyStrands() {
        assertThat(new Hamming("", "").getHammingDistance()).isEqualTo(0);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("single letter identical strands")
    public void testNoDistanceBetweenShortIdenticalStrands() {
        assertThat(new Hamming("A", "A").getHammingDistance()).isEqualTo(0);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("single letter different strands")
    public void testCompleteDistanceInSingleLetterDifferentStrands() {
        assertThat(new Hamming("G", "T").getHammingDistance()).isEqualTo(1);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("long identical strands")
    public void testDistanceInLongIdenticalStrands() {
        assertThat(new Hamming("GGACTGAAATCTG", "GGACTGAAATCTG").getHammingDistance()).isEqualTo(0);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("long different strands")
    public void testDistanceInLongDifferentStrands() {
        assertThat(new Hamming("GGACGGATTCTG", "AGGACGGATTCT").getHammingDistance()).isEqualTo(9);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("disallow first strand longer")
    public void testValidatesFirstStrandNotLonger() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Hamming("AATG", "AAA"))
                .withMessage("strands must be of equal length");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("disallow second strand longer")
    public void testValidatesSecondStrandNotLonger() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Hamming("ATA", "AGTG"))
                .withMessage("strands must be of equal length");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("disallow left empty strand")
    public void testDisallowLeftEmptyStrand() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Hamming("", "G"))
                .withMessage("strands must be of equal length");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("disallow right empty strand")
    public void testDisallowRightEmptyStrand() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Hamming("G", ""))
                .withMessage("strands must be of equal length");
    }

}
