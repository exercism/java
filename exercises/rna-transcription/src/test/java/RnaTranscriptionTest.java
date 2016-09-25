import org.junit.Assert;
import org.junit.Test;
import org.junit.Ignore;

public class RnaTranscriptionTest {


    @Test
    public void testRnaTranscriptionOfEmptyDnaIsEmptyRna() {
        Assert.assertEquals("", RnaTranscription.ofDna(""));
    }

    @Ignore
    @Test
    public void testRnaTranscriptionOfCytosineIsGuanine() {
        Assert.assertEquals("G", RnaTranscription.ofDna("C"));
    }

    @Ignore
    @Test
    public void testRnaTranscriptionOfGuanineIsCytosine() {
        Assert.assertEquals("C", RnaTranscription.ofDna("G"));
    }

    @Ignore
    @Test
    public void testRnaTranscriptionOfThymineIsAdenine() {
        Assert.assertEquals("A", RnaTranscription.ofDna("T"));
    }

    @Ignore
    @Test
    public void testRnaTranscriptionOfAdenineIsUracil() {
        Assert.assertEquals("U", RnaTranscription.ofDna("A"));
    }

    @Ignore
    @Test
    public void testRnaTranscription() {
        Assert.assertEquals("UGCACCAGAAUU", RnaTranscription.ofDna("ACGTGGTCTTAA"));
    }
}
