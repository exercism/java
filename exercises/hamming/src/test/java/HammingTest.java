import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Ignore;

public class HammingTest {
    

    @Test
    public void testNoDifferenceBetweenIdenticalStrands() {
        assertThat(Hamming.compute("A", "A"), is(0));
    }

    @Ignore
    @Test
    public void testCompleteHammingDistanceOfForSingleNucleotideStrand() {
        assertThat(Hamming.compute("A", "G"), is(1));
    }

    @Ignore
    @Test
    public void testCompleteHammingDistanceForSmallStrand() {
        assertThat(Hamming.compute("AG", "CT"), is(2)); 
    }

    @Ignore
    @Test
    public void testSmallHammingDistance() {
        assertThat(Hamming.compute("AT", "CT"), is(1));
    }

    @Ignore
    @Test
    public void testSmallHammingDistanceInLongerStrand() {
        assertThat(Hamming.compute("GGACG", "GGTCG"), is(1));
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void testValidatesFirstStrandNotLonger() {
        Hamming.compute("AAAG", "AAA");
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void testValidatesOtherStrandNotLonger() {
        Hamming.compute("AAA", "AAAG");
    }

    @Ignore
    @Test
    public void testLargeHammingDistance() {
        assertThat(Hamming.compute("GATACA", "GCATAA"), is(4));
    }

    @Ignore
    @Test
    public void testHammingDistanceInVeryLongStrand() {
        assertThat(Hamming.compute("GGACGGATTCTG", "AGGACGGATTCT"), is(9));
    }

}
