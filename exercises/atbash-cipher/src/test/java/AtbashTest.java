import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AtbashTest {

    private Atbash atbash;

    @Before
    public void setup() {
        atbash = new Atbash();
    }

    @Test
    public void testEncodingSingleWord() {
        assertEquals("bvh", atbash.encode("yes"));
        assertEquals("ml", atbash.encode("no"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testEncodingWordsWithCapitalCases() {
        assertEquals("lnt", atbash.encode("OMG"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testEncodingWordsWithSpace() {
        assertEquals("lnt", atbash.encode("O M G"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testEncodingWordsLeadingToCodeWithSpace() {
        assertEquals("nrmwy oldrm tob", atbash.encode("mindblowingly"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testEncodingSentences() {
        assertEquals("gvhgr mt123 gvhgr mt", atbash.encode("Testing,1 2 3, testing."));
        assertEquals("gifgs rhurx grlm", atbash.encode("Truth is fiction."));
        assertEquals("gsvjf rxpyi ldmul cqfnk hlevi gsvoz abwlt",
                atbash.encode("The quick brown fox jumps over the lazy dog."));
    }

    @Ignore("Remove to run test")
    @Test
    public void testDecoding() {
        assertEquals("exercism", atbash.decode("vcvix rhn"));
        assertEquals("anobstacleisoftenasteppingstone", atbash.decode("zmlyh gzxov rhlug vmzhg vkkrm thglm v"));
        assertEquals("testing123testing", atbash.decode("gvhgr mt123 gvhgr mt"));
        assertEquals("thequickbrownfoxjumpsoverthelazydog",
                atbash.decode("gsvjf rxpyi ldmul cqfnk hlevi gsvoz abwlt"));
    }

}
