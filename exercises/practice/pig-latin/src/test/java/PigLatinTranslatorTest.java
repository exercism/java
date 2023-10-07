import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PigLatinTranslatorTest {

    private PigLatinTranslator pigLatinTranslator;

    @Before
    public void setup() {
        pigLatinTranslator = new PigLatinTranslator();
    }

    @Test
    public void testWordBeginningWithA() {
        assertThat(pigLatinTranslator.translate("apple")).isEqualTo("appleay");
    }

    @Ignore("Remove to run test")
    @Test
    public void testWordBeginningWithE() {
        assertThat(pigLatinTranslator.translate("ear")).isEqualTo("earay");
    }

    @Ignore("Remove to run test")
    @Test
    public void testWordBeginningWithI() {
        assertThat(pigLatinTranslator.translate("igloo")).isEqualTo("iglooay");
    }

    @Ignore("Remove to run test")
    @Test
    public void testWordBeginningWithO() {
        assertThat(pigLatinTranslator.translate("object")).isEqualTo("objectay");
    }

    @Ignore("Remove to run test")
    @Test
    public void testWordBeginningWithU() {
        assertThat(pigLatinTranslator.translate("under")).isEqualTo("underay");
    }

    @Ignore("Remove to run test")
    @Test
    public void testWordBeginningWithVowelAndFollowedByQu() {
        assertThat(pigLatinTranslator.translate("equal")).isEqualTo("equalay");
    }

    @Ignore("Remove to run test")
    @Test
    public void testWordBeginningWithP() {
        assertThat(pigLatinTranslator.translate("pig")).isEqualTo("igpay");
    }

    @Ignore("Remove to run test")
    @Test
    public void testWordBeginningWithK() {
        assertThat(pigLatinTranslator.translate("koala")).isEqualTo("oalakay");
    }

    @Ignore("Remove to run test")
    @Test
    public void testWordBeginningWithX() {
        assertThat(pigLatinTranslator.translate("xenon")).isEqualTo("enonxay");
    }

    @Ignore("Remove to run test")
    @Test
    public void testWordBeginningWithQWithoutAFollowingU() {
        assertThat(pigLatinTranslator.translate("qat")).isEqualTo("atqay");
    }

    @Ignore("Remove to run test")
    @Test
    public void testChTreatedLikeAConsonantAtTheBeginningOfAWord() {
        assertThat(pigLatinTranslator.translate("chair")).isEqualTo("airchay");
    }

    @Ignore("Remove to run test")
    @Test
    public void testQuTreatedLikeAConsonantAtTheBeginningOfAWord() {
        assertThat(pigLatinTranslator.translate("queen")).isEqualTo("eenquay");
    }

    @Ignore("Remove to run test")
    @Test
    public void testQuAndAPrecedingConsonantTreatedLikeAConsonantAtTheBeginningOfAWord() {
        assertThat(pigLatinTranslator.translate("square")).isEqualTo("aresquay");
    }

    @Ignore("Remove to run test")
    @Test
    public void testThTreatedLikeAConsonantAtTheBeginningOfAWord() {
        assertThat(pigLatinTranslator.translate("therapy")).isEqualTo("erapythay");
    }

    @Ignore("Remove to run test")
    @Test
    public void testThrTreatedLikeAConsonantAtTheBeginningOfAWord() {
        assertThat(pigLatinTranslator.translate("thrush")).isEqualTo("ushthray");
    }

    @Ignore("Remove to run test")
    @Test
    public void testSchTreatedLikeAConsonantAtTheBeginningOfAWord() {
        assertThat(pigLatinTranslator.translate("school")).isEqualTo("oolschay");
    }

    @Ignore("Remove to run test")
    @Test
    public void testYtTreatedLikeAVowelAtTheBeginningOfAWord() {
        assertThat(pigLatinTranslator.translate("yttria")).isEqualTo("yttriaay");
    }

    @Ignore("Remove to run test")
    @Test
    public void testXrTreatedLikeAVowelAtTheBeginningOfAWord() {
        assertThat(pigLatinTranslator.translate("xray")).isEqualTo("xrayay");
    }

    @Ignore("Remove to run test")
    @Test
    public void testYTreatedLikeAConsonantAtTheBeginningOfAWord() {
        assertThat(pigLatinTranslator.translate("yellow")).isEqualTo("ellowyay");
    }

    @Ignore("Remove to run test")
    @Test
    public void testYTreatedLikeAVowelAtTheEndOfAConsonantCluster() {
        assertThat(pigLatinTranslator.translate("rhythm")).isEqualTo("ythmrhay");
    }

    @Ignore("Remove to run test")
    @Test
    public void testYAsSecondLetterInTwoLetterWord() {
        assertThat(pigLatinTranslator.translate("my")).isEqualTo("ymay");
    }

    @Ignore("Remove to run test")
    @Test
    public void testAWholePhrase() {
        assertThat(pigLatinTranslator.translate("quick fast run")).isEqualTo("ickquay astfay unray");
    }
}
