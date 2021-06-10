import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThrows;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Map;

public class NucleotideCounterTest {

    @Test
    public void testEmptyDnaStringHasNoNucleotides() {
        NucleotideCounter nucleotideCounter = new NucleotideCounter("");

        assertThat(nucleotideCounter.nucleotideCounts())
            .containsExactlyInAnyOrderEntriesOf(
                Map.of('A', 0, 'C', 0, 'G', 0, 'T', 0));
    }

    @Ignore("Remove to run test")
    @Test
    public void testDnaStringHasOneNucleotide() {
        NucleotideCounter nucleotideCounter = new NucleotideCounter("G");

        assertThat(nucleotideCounter.nucleotideCounts())
            .containsExactlyInAnyOrderEntriesOf(
                Map.of('A', 0, 'C', 0, 'G', 1, 'T', 0));
    }

    @Ignore("Remove to run test")
    @Test
    public void testRepetitiveSequenceWithOnlyGuanine() {
        NucleotideCounter nucleotideCounter = new NucleotideCounter("GGGGGGG");

        assertThat(nucleotideCounter.nucleotideCounts())
            .containsExactlyInAnyOrderEntriesOf(
                Map.of('A', 0, 'C', 0, 'G', 7, 'T', 0));
    }

    @Ignore("Remove to run test")
    @Test
    public void testDnaStringHasMultipleNucleotide() {
        NucleotideCounter nucleotideCounter
            = new NucleotideCounter("AGCTTTTCATTCTGACTGCAACGGGCAATATGTCTCTGTGTGGATTAAAAAAAGAGTGTCTGATAGCAGC");

        assertThat(nucleotideCounter.nucleotideCounts())
            .containsExactlyInAnyOrderEntriesOf(
                Map.of('A', 20, 'C', 12, 'G', 17, 'T', 21));
    }

    @Ignore("Remove to run test")
    @Test
    public void testDnaStringHasInvalidNucleotides() {
        assertThrows(
            IllegalArgumentException.class,
            () -> new NucleotideCounter("AGXXACT"));
    }
}
