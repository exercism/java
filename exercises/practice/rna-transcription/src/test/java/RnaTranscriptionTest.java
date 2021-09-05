import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RnaTranscriptionTest {

    private RnaTranscription rnaTranscription;

    @Before
    public void setUp() {
        rnaTranscription = new RnaTranscription();
    }

    @Test
    public void testEmptyRnaSequence() {
        assertThat(rnaTranscription.transcribe("")).isEmpty();
    }

    @Ignore("Remove to run test")
    @Test
    public void testRnaTranscriptionOfCytosineIsGuanine() {
        assertThat(rnaTranscription.transcribe("C")).isEqualTo("G");
    }

    @Ignore("Remove to run test")
    @Test
    public void testRnaTranscriptionOfGuanineIsCytosine() {
        assertThat(rnaTranscription.transcribe("G")).isEqualTo("C");
    }

    @Ignore("Remove to run test")
    @Test
    public void testRnaTranscriptionOfThymineIsAdenine() {
        assertThat(rnaTranscription.transcribe("T")).isEqualTo("A");
    }

    @Ignore("Remove to run test")
    @Test
    public void testRnaTranscriptionOfAdenineIsUracil() {
        assertThat(rnaTranscription.transcribe("A")).isEqualTo("U");
    }

    @Ignore("Remove to run test")
    @Test
    public void testRnaTranscription() {
        assertThat(rnaTranscription.transcribe("ACGTGGTCTTAA")).isEqualTo("UGCACCAGAAUU");
    }
}
