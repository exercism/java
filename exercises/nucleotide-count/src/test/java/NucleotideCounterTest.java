import org.junit.Ignore;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

import java.util.Map;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class NucleotideCounterTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testEmptyDnaStringHasNoNucleotides() {
        NucleotideCounter nucleotideCounter = new NucleotideCounter("");
        Map<Character, Integer> counts = nucleotideCounter.nucleotideCounts();
        assertThat(counts, allOf(
                hasEntry('A', 0),
                hasEntry('C', 0),
                hasEntry('G', 0),
                hasEntry('T', 0)
        ));
    }

    @Ignore("Remove to run test")
    @Test
    public void testDnaStringHasOneNucleotide() {
        NucleotideCounter nucleotideCounter = new NucleotideCounter("G");
        Map<Character, Integer> counts = nucleotideCounter.nucleotideCounts();
        assertThat(counts, allOf(
                hasEntry('A', 0),
                hasEntry('C', 0),
                hasEntry('G', 1),
                hasEntry('T', 0)
        ));
    }

    @Ignore("Remove to run test")
    @Test
    public void testRepetitiveSequenceWithOnlyGuanine() {
        NucleotideCounter nucleotideCounter = new NucleotideCounter("GGGGGGG");
        Map<Character, Integer> counts = nucleotideCounter.nucleotideCounts();
        assertThat(counts, allOf(
                hasEntry('A', 0),
                hasEntry('C', 0),
                hasEntry('G', 7),
                hasEntry('T', 0)
        ));
    }

    @Ignore("Remove to run test")
    @Test
    public void testDnaStringHasMultipleNucleotide() {
        NucleotideCounter nucleotideCounter
            = new NucleotideCounter("AGCTTTTCATTCTGACTGCAACGGGCAATATGTCTCTGTGTGGATTAAAAAAAGAGTGTCTGATAGCAGC");
        Map<Character, Integer> counts = nucleotideCounter.nucleotideCounts();
        assertThat(counts, allOf(
                hasEntry('A', 20),
                hasEntry('C', 12),
                hasEntry('G', 17),
                hasEntry('T', 21)
        ));
    }

    @Ignore("Remove to run test")
    @Test
    public void testDnaStringHasInvalidNucleotides() {
        expectedException.expect(IllegalArgumentException.class);
        NucleotideCounter nucleotideCounter = new NucleotideCounter("AGXXACT");
    }
}
