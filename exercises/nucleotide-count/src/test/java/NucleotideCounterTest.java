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
    public void testEmptyDnaStringHasNoAdenine() {
        NucleotideCounter nucleotideCounter = new NucleotideCounter("");
        assertThat(nucleotideCounter.count('A'), is(0));
    }

    @Ignore("Remove to run test")
    @Test
    public void testEmptyDnaStringHasNoNucleotides() {
        NucleotideCounter nucleotideCounter = new NucleotideCounter("");
        Map<Character, Integer> counts = nucleotideCounter.nucleotideCounts();
        assertThat(counts.size(), is(4));
        assertThat(counts, allOf(
                hasEntry('A', 0),
                hasEntry('C', 0),
                hasEntry('G', 0),
                hasEntry('T', 0)
        ));
    }

    @Ignore("Remove to run test")
    @Test
    public void testRepetitiveCytosineGetsCounted() {
        NucleotideCounter nucleotideCounter = new NucleotideCounter("CCCCC");
        assertThat(nucleotideCounter.count('C'), is(5));
    }

    @Ignore("Remove to run test")
    @Test
    public void testRepetitiveSequenceWithOnlyGuanine() {
        NucleotideCounter nucleotideCounter = new NucleotideCounter("GGGGGGGG");
        Map<Character, Integer> counts = nucleotideCounter.nucleotideCounts();
        assertThat(counts.size(), is(4));
        assertThat(counts, allOf(
                hasEntry('A', 0),
                hasEntry('C', 0),
                hasEntry('G', 8),
                hasEntry('T', 0)
        ));
    }

    @Ignore("Remove to run test")
    @Test
    public void testCountsOnlyThymine() {
        NucleotideCounter nucleotideCounter = new NucleotideCounter("GGGGGTAACCCGG");
        assertThat(nucleotideCounter.count('T'), is(1));
    }

    @Ignore("Remove to run test")
    @Test
    public void testCountsANucleotideOnlyOnce() {
        NucleotideCounter nucleotideCounter = new NucleotideCounter("CGATTGGG");
        nucleotideCounter.count('T');
        assertThat(nucleotideCounter.count('T'), is(2));
    }

    @Ignore("Remove to run test")
    @Test
    public void testDnaCountsDoNotChangeAfterCountingAdenine() {
        NucleotideCounter nucleotideCounter = new NucleotideCounter("GATTACA");
        nucleotideCounter.count('A');
        Map<Character, Integer> counts = nucleotideCounter.nucleotideCounts();
        assertThat(counts.size(), is(4));
        assertThat(counts, allOf(
                hasEntry('A', 3),
                hasEntry('C', 1),
                hasEntry('G', 1),
                hasEntry('T', 2)
        ));
    }

    @Ignore("Remove to run test")
    @Test
    public void testValidatesNucleotides() {
        expectedException.expect(IllegalArgumentException.class);
        NucleotideCounter nucleotideCounter = new NucleotideCounter("GACT");
        nucleotideCounter.count('X');
    }

    @Ignore("Remove to run test")
    @Test
    public void testCountsAllNucleotides() {
        String s = "AGCTTTTCATTCTGACTGCAACGGGCAATATGTCTCTGTGTGGATTAAAAAAAGAGTGTCTGATAGCAGC";
        NucleotideCounter nucleotideCounter = new NucleotideCounter(s);
        Map<Character, Integer> counts = nucleotideCounter.nucleotideCounts();
        assertThat(counts.size(), is(4));
        assertThat(counts, allOf(
                hasEntry('A', 20),
                hasEntry('C', 12),
                hasEntry('G', 17),
                hasEntry('T', 21)
        ));
    }
}
