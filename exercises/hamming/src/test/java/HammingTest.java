import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

public class HammingTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    @Test
    public void testNoDifferenceBetweenIdenticalStrands() {
        assertThat(new Hamming("A", "A").getHammingDistance(), is(0));
    }

    @Ignore("Remove to run test")
    @Test
    public void testHammingDistanceForSingleNucleotideStrand() {
        assertThat(new Hamming("A", "G").getHammingDistance(), is(1));
    }

    @Ignore("Remove to run test")
    @Test
    public void testHammingDistanceForSmallStrand() {
        assertThat(new Hamming("AG", "CT").getHammingDistance(), is(2));
    }

    @Ignore("Remove to run test")
    @Test
    public void testSmallHammingDistance() {
        assertThat(new Hamming("AT", "CT").getHammingDistance(), is(1));
    }

    @Ignore("Remove to run test")
    @Test
    public void testSmallHammingDistanceInLongerStrand() {
        assertThat(new Hamming("GGACG", "GGTCG").getHammingDistance(), is(1));
    }

    @Ignore("Remove to run test")
    @Test
    public void testValidatesFirstStrandNotLonger() {
        thrown.expect(IllegalArgumentException.class);
        new Hamming("AAAG", "AAA");
    }

    @Ignore("Remove to run test")
    @Test
    public void testValidatesOtherStrandNotLonger() {
        thrown.expect(IllegalArgumentException.class);
        new Hamming("AAA", "AAAG");
    }

    @Ignore("Remove to run test")
    @Test
    public void testLargeHammingDistance() {
        assertThat(new Hamming("GATACA", "GCATAA").getHammingDistance(), is(4));
    }

    @Ignore("Remove to run test")
    @Test
    public void testHammingDistanceInVeryLongStrand() {
        assertThat(new Hamming("GGACGGATTCTG", "AGGACGGATTCT").getHammingDistance(), is(9));
    }

}
