import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.Rule;

public class RnaTranscriptionTest {

    /*
    version: 2.0.0
     */

    @Rule
    public ExpectedException thrown = ExpectedException.none();

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

    @Ignore("Remove to run test")
    @Test
    public void testRnaTranscriptionOfRnaThrowsAnError() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Invalid input");
        rnaTranscription.transcribe("U");
    }

    @Ignore("Remove to run test")
    @Test
    public void testRnaTranscriptionOfInvalidInputThrowsAnError() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Invalid input");
        rnaTranscription.transcribe("BFV");
    }

    @Ignore("Remove to run test")
    @Test
    public void testRnaTranscriptionOfPartiallyInvalidInput() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Invalid input");
        rnaTranscription.transcribe("GCVV");
    }
}
