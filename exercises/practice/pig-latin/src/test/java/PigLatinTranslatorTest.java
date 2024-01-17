import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PigLatinTranslatorTest {

    private PigLatinTranslator pigLatinTranslator;

    @BeforeEach
    public void setup() {
        pigLatinTranslator = new PigLatinTranslator();
    }

    @Test
    public void testWordBeginningWithA() {
        assertThat(pigLatinTranslator.translate("apple")).isEqualTo("appleay");
    }

    @Disabled("Remove to run test")
    @Test
    public void testWordBeginningWithE() {
        assertThat(pigLatinTranslator.translate("ear")).isEqualTo("earay");
    }

    @Disabled("Remove to run test")
    @Test
    public void testWordBeginningWithI() {
        assertThat(pigLatinTranslator.translate("igloo")).isEqualTo("iglooay");
    }

    @Disabled("Remove to run test")
    @Test
    public void testWordBeginningWithO() {
        assertThat(pigLatinTranslator.translate("object")).isEqualTo("objectay");
    }

    @Disabled("Remove to run test")
    @Test
    public void testWordBeginningWithU() {
        assertThat(pigLatinTranslator.translate("under")).isEqualTo("underay");
    }

    @Disabled("Remove to run test")
    @Test
    public void testWordBeginningWithVowelAndFollowedByQu() {
        assertThat(pigLatinTranslator.translate("equal")).isEqualTo("equalay");
    }

    @Disabled("Remove to run test")
    @Test
    public void testWordBeginningWithP() {
        assertThat(pigLatinTranslator.translate("pig")).isEqualTo("igpay");
    }

    @Disabled("Remove to run test")
    @Test
    public void testWordBeginningWithK() {
        assertThat(pigLatinTranslator.translate("koala")).isEqualTo("oalakay");
    }

    @Disabled("Remove to run test")
    @Test
    public void testWordBeginningWithX() {
        assertThat(pigLatinTranslator.translate("xenon")).isEqualTo("enonxay");
    }

    @Disabled("Remove to run test")
    @Test
    public void testWordBeginningWithQWithoutAFollowingU() {
        assertThat(pigLatinTranslator.translate("qat")).isEqualTo("atqay");
    }

    @Disabled("Remove to run test")
    @Test
    public void testChTreatedLikeAConsonantAtTheBeginningOfAWord() {
        assertThat(pigLatinTranslator.translate("chair")).isEqualTo("airchay");
    }

    @Disabled("Remove to run test")
    @Test
    public void testQuTreatedLikeAConsonantAtTheBeginningOfAWord() {
        assertThat(pigLatinTranslator.translate("queen")).isEqualTo("eenquay");
    }

    @Disabled("Remove to run test")
    @Test
    public void testQuAndAPrecedingConsonantTreatedLikeAConsonantAtTheBeginningOfAWord() {
        assertThat(pigLatinTranslator.translate("square")).isEqualTo("aresquay");
    }

    @Disabled("Remove to run test")
    @Test
    public void testThTreatedLikeAConsonantAtTheBeginningOfAWord() {
        assertThat(pigLatinTranslator.translate("therapy")).isEqualTo("erapythay");
    }

    @Disabled("Remove to run test")
    @Test
    public void testThrTreatedLikeAConsonantAtTheBeginningOfAWord() {
        assertThat(pigLatinTranslator.translate("thrush")).isEqualTo("ushthray");
    }

    @Disabled("Remove to run test")
    @Test
    public void testSchTreatedLikeAConsonantAtTheBeginningOfAWord() {
        assertThat(pigLatinTranslator.translate("school")).isEqualTo("oolschay");
    }

    @Disabled("Remove to run test")
    @Test
    public void testYtTreatedLikeAVowelAtTheBeginningOfAWord() {
        assertThat(pigLatinTranslator.translate("yttria")).isEqualTo("yttriaay");
    }

    @Disabled("Remove to run test")
    @Test
    public void testXrTreatedLikeAVowelAtTheBeginningOfAWord() {
        assertThat(pigLatinTranslator.translate("xray")).isEqualTo("xrayay");
    }

    @Disabled("Remove to run test")
    @Test
    public void testYTreatedLikeAConsonantAtTheBeginningOfAWord() {
        assertThat(pigLatinTranslator.translate("yellow")).isEqualTo("ellowyay");
    }

    @Disabled("Remove to run test")
    @Test
    public void testYTreatedLikeAVowelAtTheEndOfAConsonantCluster() {
        assertThat(pigLatinTranslator.translate("rhythm")).isEqualTo("ythmrhay");
    }

    @Disabled("Remove to run test")
    @Test
    public void testYAsSecondLetterInTwoLetterWord() {
        assertThat(pigLatinTranslator.translate("my")).isEqualTo("ymay");
    }

    @Disabled("Remove to run test")
    @Test
    public void testAWholePhrase() {
        assertThat(pigLatinTranslator.translate("quick fast run")).isEqualTo("ickquay astfay unray");
    }
}
