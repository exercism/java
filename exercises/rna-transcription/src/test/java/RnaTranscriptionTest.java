import org.junit.Assert;
import org.junit.Test;

public class RnaTranscriptionTest {

    @Test
    public void testRnaTranscriptionOfEmptyDnaIsEmptyRna() {
        Assert.assertEquals("", RnaTranscription.ofDna(""));
    }

    @Test
    public void testRnaTranscriptionOfCytosineIsGuanine() {
        Assert.assertEquals("G", RnaTranscription.ofDna("C"));
    }

    @Test
    public void testRnaTranscriptionOfGuanineIsCytosine() {
        Assert.assertEquals("C", RnaTranscription.ofDna("G"));
    }

    @Test
    public void testRnaTranscriptionOfThymineIsAdenine() {
        Assert.assertEquals("A", RnaTranscription.ofDna("T"));
    }

    @Test
    public void testRnaTranscriptionOfAdenineIsUracil() {
        Assert.assertEquals("U", RnaTranscription.ofDna("A"));
    }

    @Test
    public void testRnaTranscription() {
        Assert.assertEquals("UGCACCAGAAUU", RnaTranscription.ofDna("ACGTGGTCTTAA"));
    }
}
