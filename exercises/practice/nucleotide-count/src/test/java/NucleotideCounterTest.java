import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NucleotideCounterTest {

    @Test
    public void testEmptyDnaStringHasNoNucleotides() {
        NucleotideCounter nucleotideCounter = new NucleotideCounter("");

        assertThat(nucleotideCounter.nucleotideCounts())
            .containsExactlyInAnyOrderEntriesOf(
                Map.of('A', 0, 'C', 0, 'G', 0, 'T', 0));
    }

    @Disabled("Remove to run test")
    @Test
    public void testDnaStringHasOneNucleotide() {
        NucleotideCounter nucleotideCounter = new NucleotideCounter("G");

        assertThat(nucleotideCounter.nucleotideCounts())
            .containsExactlyInAnyOrderEntriesOf(
                Map.of('A', 0, 'C', 0, 'G', 1, 'T', 0));
    }

    @Disabled("Remove to run test")
    @Test
    public void testRepetitiveSequenceWithOnlyGuanine() {
        NucleotideCounter nucleotideCounter = new NucleotideCounter("GGGGGGG");

        assertThat(nucleotideCounter.nucleotideCounts())
            .containsExactlyInAnyOrderEntriesOf(
                Map.of('A', 0, 'C', 0, 'G', 7, 'T', 0));
    }

    @Disabled("Remove to run test")
    @Test
    public void testDnaStringHasMultipleNucleotide() {
        NucleotideCounter nucleotideCounter
            = new NucleotideCounter("AGCTTTTCATTCTGACTGCAACGGGCAATATGTCTCTGTGTGGATTAAAAAAAGAGTGTCTGATAGCAGC");

        assertThat(nucleotideCounter.nucleotideCounts())
            .containsExactlyInAnyOrderEntriesOf(
                Map.of('A', 20, 'C', 12, 'G', 17, 'T', 21));
    }

    @Disabled("Remove to run test")
    @Test
    public void testDnaStringHasInvalidNucleotides() {
        assertThatThrownBy(() -> new NucleotideCounter("AGXXACT"))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
