import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RnaTranscriptionTest {

    private RnaTranscription rnaTranscription;

    @BeforeEach
    public void setUp() {
        rnaTranscription = new RnaTranscription();
    }

    @Test
    public void testEmptyRnaSequence() {
        assertThat(rnaTranscription.transcribe("")).isEmpty();
    }

    @Disabled("Remove to run test")
    @Test
    public void testRnaTranscriptionOfCytosineIsGuanine() {
        assertThat(rnaTranscription.transcribe("C")).isEqualTo("G");
    }

    @Disabled("Remove to run test")
    @Test
    public void testRnaTranscriptionOfGuanineIsCytosine() {
        assertThat(rnaTranscription.transcribe("G")).isEqualTo("C");
    }

    @Disabled("Remove to run test")
    @Test
    public void testRnaTranscriptionOfThymineIsAdenine() {
        assertThat(rnaTranscription.transcribe("T")).isEqualTo("A");
    }

    @Disabled("Remove to run test")
    @Test
    public void testRnaTranscriptionOfAdenineIsUracil() {
        assertThat(rnaTranscription.transcribe("A")).isEqualTo("U");
    }

    @Disabled("Remove to run test")
    @Test
    public void testRnaTranscription() {
        assertThat(rnaTranscription.transcribe("ACGTGGTCTTAA")).isEqualTo("UGCACCAGAAUU");
    }
}
