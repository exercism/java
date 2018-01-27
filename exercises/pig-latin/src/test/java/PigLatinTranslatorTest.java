import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class PigLatinTranslatorTest {

    private String englishPhrase;
    private String pigLatinTranslation;

    @Parameterized.Parameters(name = "{index}: expected \"{0}\" to translate to the pig latin phrase \"{1}\"")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                // Ay is added to words that start with vowels
                {"apple", "appleay"},
                {"ear", "earay"},
                {"igloo", "iglooay"},
                {"object", "objectay"},
                {"under", "underay"},

                // Word beginning with vowel follwed by a 'qu'
                {"equal", "equalay"},

                // First letter and ay are moved to the end of words that start with consonants
                {"pig", "igpay"},
                {"koala", "oalakay"},
                {"xenon", "enonxay"},

                // Word beginning with 'q' without a following 'u'
                {"qat", "atqay"},

                // Ch is treated like a single consonant
                {"chair", "airchay"},

                // Qu is treated like a single consonant
                {"queen", "eenquay"},

                // Qu and a single preceding consonant are treated like a single consonant
                {"square", "aresquay"},

                // Th is treated like a single consonant
                {"therapy", "erapythay"},

                // Thr is treated like a single consonant
                {"thrush", "ushthray"},

                // Sch is treated like a single consonant
                {"school", "oolschay"},

                // Yt is treated like a single vowel
                {"yttria", "yttriaay"},

                // Xr is treated like a single vowel
                {"xray", "xrayay"},

                // 'Y' is treated like a consonant at the beginning of a word
                {"yellow", "ellowyay"},

                // 'Y' is treated like a vowel at the end of a consonant cluster
                {"rhythm", "ythmrhay"},

                // 'Y' as second letter in a two letter word
                {"my", "ymay"},

                // Phrases are translated
                {"quick fast run", "ickquay astfay unray"}
        });
    }

    public PigLatinTranslatorTest(String englishPhrase, String pigLatinTranslation) {
        this.englishPhrase = englishPhrase;
        this.pigLatinTranslation = pigLatinTranslation;
    }

    @Test
    public void test() {
        assertEquals(pigLatinTranslation, new PigLatinTranslator().translate(englishPhrase));
    }

}
