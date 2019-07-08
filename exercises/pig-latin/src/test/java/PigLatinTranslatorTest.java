import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PigLatinTranslatorTest {

    private PigLatinTranslator pigLatinTranslator;

    @Before
    public void setup() {
        pigLatinTranslator = new PigLatinTranslator();
    }

    @Test
    public void testWordBeginningWithA() {
        assertEquals("appleay", pigLatinTranslator.translate("apple"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testWordBeginningWithE() {
        assertEquals("earay", pigLatinTranslator.translate("ear"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testWordBeginningWithI() {
        assertEquals("iglooay", pigLatinTranslator.translate("igloo"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testWordBeginningWithO() {
        assertEquals("objectay", pigLatinTranslator.translate("object"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testWordBeginningWithU() {
        assertEquals("underay", pigLatinTranslator.translate("under"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testWordBeginningWithVowelAndFollowedByQu() {
        assertEquals("equalay", pigLatinTranslator.translate("equal"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testWordBeginningWithP() {
        assertEquals("igpay", pigLatinTranslator.translate("pig"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testWordBeginningWithK() {
        assertEquals("oalakay", pigLatinTranslator.translate("koala"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testWordBeginningWithX() {
        assertEquals("enonxay", pigLatinTranslator.translate("xenon"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testWordBeginningWithQWithoutAFollowingU() {
        assertEquals("atqay", pigLatinTranslator.translate("qat"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testChTreatedLikeAConsonantAtTheBeginningOfAWord() {
        assertEquals("airchay", pigLatinTranslator.translate("chair"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testQuTreatedLikeAConsonantAtTheBeginningOfAWord() {
        assertEquals("eenquay", pigLatinTranslator.translate("queen"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testQuAndAPrecedingConsonantTreatedLikeAConsonantAtTheBeginningOfAWord() {
        assertEquals("aresquay", pigLatinTranslator.translate("square"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testThTreatedLikeAConsonantAtTheBeginningOfAWord() {
        assertEquals("erapythay", pigLatinTranslator.translate("therapy"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testThrTreatedLikeAConsonantAtTheBeginningOfAWord() {
        assertEquals("ushthray", pigLatinTranslator.translate("thrush"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testSchTreatedLikeAConsonantAtTheBeginningOfAWord() {
        assertEquals("oolschay", pigLatinTranslator.translate("school"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testYtTreatedLikeAVowelAtTheBeginningOfAWord() {
        assertEquals("yttriaay", pigLatinTranslator.translate("yttria"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testXrTreatedLikeAVowelAtTheBeginningOfAWord() {
        assertEquals("xrayay", pigLatinTranslator.translate("xray"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testYTreatedLikeAConsonantAtTheBeginningOfAWord() {
        assertEquals("ellowyay", pigLatinTranslator.translate("yellow"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testYTreatedLikeAVowelAtTheEndOfAConsonantCluster() {
        assertEquals("ythmrhay", pigLatinTranslator.translate("rhythm"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testYAsSecondLetterInTwoLetterWord() {
        assertEquals("ymay", pigLatinTranslator.translate("my"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testAWholePhrase() {
        assertEquals("ickquay astfay unray", pigLatinTranslator.translate("quick fast run"));
    }
}
