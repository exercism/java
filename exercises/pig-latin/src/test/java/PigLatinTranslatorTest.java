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
    public void testWordBeginningWithCh() {
        // Ch is treated like a single consonant
        assertEquals("airchay", pigLatinTranslator.translate("chair"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testWordBeginningWithQu() {
        // Qu is treated like a single consonant
        assertEquals("eenquay", pigLatinTranslator.translate("queen"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testWordBeginningWithQuAndAPrecedingConsonant() {
        // Qu and a single preceding consonant are treated like a single consonant
        assertEquals("aresquay", pigLatinTranslator.translate("square"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testWordBeginningWithTh() {
        // Th is treated like a single consonant
        assertEquals("erapythay", pigLatinTranslator.translate("therapy"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testWordBeginningWithThr() {
        // Thr is treated like a single consonant
        assertEquals("ushthray", pigLatinTranslator.translate("thrush"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testWordBeginningWithSch() {
        // Sch is treated like a single consonant
        assertEquals("oolschay", pigLatinTranslator.translate("school"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testWordBeginningWithYt() {
        // Yt is treated like a single vowel
        assertEquals("yttriaay", pigLatinTranslator.translate("yttria"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testWordBeginningWithXr() {
        // Xr is treated like a single vowel
        assertEquals("xrayay", pigLatinTranslator.translate("xray"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testYTreatedLikeAConsonantAtTheBeginningOfAWord() {
        // 'Y' is treated like a consonant at the beginning of a word
        assertEquals("ellowyay", pigLatinTranslator.translate("yellow"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testYTreatedLikeAVowelAtTheEndOfAConsonantCluster() {
        // 'Y' is treated like a vowel at the end of a consonant cluster
        assertEquals("ythmrhay", pigLatinTranslator.translate("rhythm"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testYAsSecondLetterInTwoLetterWord() {
        // 'Y' as second letter in a two letter word
        assertEquals("ymay", pigLatinTranslator.translate("my"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testAWholePhrase() {
        assertEquals("ickquay astfay unray", pigLatinTranslator.translate("quick fast run"));
    }

}
