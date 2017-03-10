import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class RnaTranscriptionTest {

    private RnaTranscription rnaTranscription;

    @Before
    public void setUp() {
        rnaTranscription = new RnaTranscription();
    }

    @Test
    public void testRnaTranscriptionOfEmptyDnaIsEmptyRna() {
        Assert.assertEquals("", rnaTranscription.ofDna(""));
    }

    @Ignore
    @Test
    public void testRnaTranscriptionOfCytosineIsGuanine() {
        Assert.assertEquals("G", rnaTranscription.ofDna("C"));
    }

    @Ignore
    @Test
    public void testRnaTranscriptionOfGuanineIsCytosine() {
        Assert.assertEquals("C", rnaTranscription.ofDna("G"));
    }

    @Ignore
    @Test
    public void testRnaTranscriptionOfThymineIsAdenine() {
        Assert.assertEquals("A", rnaTranscription.ofDna("T"));
    }

    @Ignore
    @Test
    public void testRnaTranscriptionOfAdenineIsUracil() {
        Assert.assertEquals("U", rnaTranscription.ofDna("A"));
    }

    @Ignore
    @Test
    public void testRnaTranscription() {
        Assert.assertEquals("UGCACCAGAAUU", rnaTranscription.ofDna("ACGTGGTCTTAA"));
    }
}
