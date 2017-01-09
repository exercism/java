import org.junit.Ignore;
import org.junit.Test;

import java.util.Map;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class NucleotideTest {

    @Test
    public void testEmptyDnaStringHasNoAdenosine() {
        DNA dna = new DNA("");
        assertThat(dna.count('A'), is(0));
    }

    @Ignore
    @Test
    public void testEmptyDnaStringHasNoNucleotides() {
        DNA dna = new DNA("");
        Map<Character, Integer> counts = dna.nucleotideCounts();
        assertThat(counts.size(), is(4));
        assertThat(counts, allOf(
                hasEntry('A', 0),
                hasEntry('C', 0),
                hasEntry('G', 0),
                hasEntry('T', 0)
        ));
    }

    @Ignore
    @Test
    public void testRepetitiveCytidineGetsCounted() {
        DNA dna = new DNA("CCCCC");
        assertThat(dna.count('C'), is(5));
    }

    @Ignore
    @Test
    public void testRepetitiveSequenceWithOnlyGuanosine() {
        DNA dna = new DNA("GGGGGGGG");
        Map<Character, Integer> counts = dna.nucleotideCounts();
        assertThat(counts.size(), is(4));
        assertThat(counts, allOf(
                hasEntry('A', 0),
                hasEntry('C', 0),
                hasEntry('G', 8),
                hasEntry('T', 0)
        ));
    }

    @Ignore
    @Test
    public void testCountsOnlyThymidine() {
        DNA dna = new DNA("GGGGGTAACCCGG");
        assertThat(dna.count('T'), is(1));
    }

    @Ignore
    @Test
    public void testCountsANucleotideOnlyOnce() {
        DNA dna = new DNA("CGATTGGG");
        dna.count('T');
        assertThat(dna.count('T'), is(2));
    }

    @Ignore
    @Test
    public void testDnaCountsDoNotChangeAfterCountingAdenosine() {
        DNA dna = new DNA("GATTACA");
        dna.count('A');
        Map<Character, Integer> counts = dna.nucleotideCounts();
        assertThat(counts.size(), is(4));
        assertThat(counts, allOf(
                hasEntry('A', 3),
                hasEntry('C', 1),
                hasEntry('G', 1),
                hasEntry('T', 2)
        ));
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void testValidatesNucleotides() {
        DNA dna = new DNA("GACT");
        dna.count('X');
    }

    @Ignore
    @Test
    public void testCountsAllNucleotides() {
        String s = "AGCTTTTCATTCTGACTGCAACGGGCAATATGTCTCTGTGTGGATTAAAAAAAGAGTGTCTGATAGCAGC";
        DNA dna = new DNA(s);
        Map<Character, Integer> counts = dna.nucleotideCounts();
        assertThat(counts.size(), is(4));
        assertThat(counts, allOf(
                hasEntry('A', 20),
                hasEntry('C', 12),
                hasEntry('G', 17),
                hasEntry('T', 21)
        ));
    }
}
