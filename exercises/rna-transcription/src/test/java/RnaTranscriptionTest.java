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
        Assert.assertEquals("", rnaTranscription.transcribe(""));
    }

    @Ignore("Remove to run test")
    @Test
    public void testRnaTranscriptionOfCytosineIsGuanine() {
        Assert.assertEquals("G", rnaTranscription.transcribe("C"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testRnaTranscriptionOfGuanineIsCytosine() {
        Assert.assertEquals("C", rnaTranscription.transcribe("G"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testRnaTranscriptionOfThymineIsAdenine() {
        Assert.assertEquals("A", rnaTranscription.transcribe("T"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testRnaTranscriptionOfAdenineIsUracil() {
        Assert.assertEquals("U", rnaTranscription.transcribe("A"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testRnaTranscription() {
        Assert.assertEquals("UGCACCAGAAUU", rnaTranscription.transcribe("ACGTGGTCTTAA"));
    }
}
