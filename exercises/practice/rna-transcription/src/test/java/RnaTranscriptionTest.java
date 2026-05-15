import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RnaTranscriptionTest {

    private RnaTranscription rnaTranscription;

    @BeforeEach
    public void setUp() {
        rnaTranscription = new RnaTranscription();
    }

    @Test
    @DisplayName("Empty RNA sequence")
    public void testEmptyRnaSequence() {
        assertThat(rnaTranscription.transcribe("")).isEmpty();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("RNA complement of cytosine is guanine")
    public void testRnaTranscriptionOfCytosineIsGuanine() {
        assertThat(rnaTranscription.transcribe("C")).isEqualTo("G");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("RNA complement of guanine is cytosine")
    public void testRnaTranscriptionOfGuanineIsCytosine() {
        assertThat(rnaTranscription.transcribe("G")).isEqualTo("C");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("RNA complement of thymine is adenine")
    public void testRnaTranscriptionOfThymineIsAdenine() {
        assertThat(rnaTranscription.transcribe("T")).isEqualTo("A");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("RNA complement of adenine is uracil")
    public void testRnaTranscriptionOfAdenineIsUracil() {
        assertThat(rnaTranscription.transcribe("A")).isEqualTo("U");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("RNA complement")
    public void testRnaTranscription() {
        assertThat(rnaTranscription.transcribe("ACGTGGTCTTAA")).isEqualTo("UGCACCAGAAUU");
    }
}
