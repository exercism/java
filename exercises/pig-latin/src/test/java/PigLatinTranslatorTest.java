import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PigLatinTranslatorTest {

    private PigLatinTranslator pigLatinTranslator;

    public PigLatinTranslatorTest() {
    }

    @Before
    public void setup() {
        pigLatinTranslator = new PigLatinTranslator();
    }

    @Test
    public void testWordsStartWithVowels() {
        assertEquals("appleay", pigLatinTranslator.translate("apple"));
        assertEquals("earay", pigLatinTranslator.translate("ear"));
        assertEquals("iglooay", pigLatinTranslator.translate("igloo"));
        assertEquals("objectay", pigLatinTranslator.translate("object"));
        assertEquals("underay", pigLatinTranslator.translate("under"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testWordsBeginWithVowelFollowedByQu() {
        assertEquals("equalay", pigLatinTranslator.translate("equal"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testGeneralWordsBeginWithConsonants() {
        assertEquals("igpay", pigLatinTranslator.translate("pig"));
        assertEquals("oalakay", pigLatinTranslator.translate("koala"));
        assertEquals("enonxay", pigLatinTranslator.translate("xenon"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testWordsBeginWithQWithoutFollowingU() {
        assertEquals("atqay", pigLatinTranslator.translate("qat"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testWordsWithPrefixTreatedAsSingleConsonant() {
        // Ch is treated like a single consonant
        assertEquals("airchay", pigLatinTranslator.translate("chair"));

        // Qu is treated like a single consonant
        assertEquals("eenquay", pigLatinTranslator.translate("queen"));

        // Qu and a single preceding consonant are treated like a single consonant
        assertEquals("aresquay", pigLatinTranslator.translate("square"));

        // Th is treated like a single consonant
        assertEquals("erapythay", pigLatinTranslator.translate("therapy"));

        // Thr is treated like a single consonant
        assertEquals("ushthray", pigLatinTranslator.translate("thrush"));

        // Sch is treated like a single consonant
        assertEquals("oolschay", pigLatinTranslator.translate("school"));

        // Yt is treated like a single vowel
        assertEquals("yttriaay", pigLatinTranslator.translate("yttria"));

        // Xr is treated like a single vowel
        assertEquals("xrayay", pigLatinTranslator.translate("xray"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testWordsStartWithY() {
        // 'Y' is treated like a consonant at the beginning of a word
        assertEquals("ellowyay", pigLatinTranslator.translate("yellow"));

        // 'Y' is treated like a vowel at the end of a consonant cluster
        assertEquals("ythmrhay", pigLatinTranslator.translate("rhythm"));

        // 'Y' as second letter in a two letter word
        assertEquals("ymay", pigLatinTranslator.translate("my"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testTranslationOfPhrases() {
        assertEquals("ickquay astfay unray", pigLatinTranslator.translate("quick fast run"));
    }

}
