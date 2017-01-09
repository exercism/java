import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class PigLatinTest {

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

                // First letter and ay are moved to the end of words that start with consonants
                {"pig", "igpay"},
                {"koala", "oalakay"},
                {"yellow", "ellowyay"},
                {"xenon", "enonxay"},

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

                // Phrases are translated
                {"quick fast run", "ickquay astfay unray"}
        });
    }

    public PigLatinTest(String englishPhrase, String pigLatinTranslation) {
        this.englishPhrase = englishPhrase;
        this.pigLatinTranslation = pigLatinTranslation;
    }


    @Test
    public void test() {
        assertEquals(pigLatinTranslation, PigLatin.translate(englishPhrase));
    }
}
