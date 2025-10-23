import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PigLatinTranslatorTest {

    private PigLatinTranslator pigLatinTranslator;

    @BeforeEach
    public void setup() {
        pigLatinTranslator = new PigLatinTranslator();
    }

    @Test
    @Disabled
    @DisplayName("word beginning with a")
    public void testWordBeginningWithA() {
        assertThat(pigLatinTranslator.translate("apple")).isEqualTo("appleay");
    }

    @Test
    @Disabled
    @DisplayName("word beginning with e")
    public void testWordBeginningWithE() {
        assertThat(pigLatinTranslator.translate("ear")).isEqualTo("earay");
    }

    @Test
    @Disabled
    @DisplayName("word beginning with i")
    public void testWordBeginningWithI() {
        assertThat(pigLatinTranslator.translate("igloo")).isEqualTo("iglooay");
    }

    @Test
    @Disabled
    @DisplayName("word beginning with o")
    public void testWordBeginningWithO() {
        assertThat(pigLatinTranslator.translate("object")).isEqualTo("objectay");
    }

    @Test
    @Disabled
    @DisplayName("word beginning with u")
    public void testWordBeginningWithU() {
        assertThat(pigLatinTranslator.translate("under")).isEqualTo("underay");
    }

    @Test
    @Disabled
    @DisplayName("word beginning with a vowel and followed by a qu")
    public void testWordBeginningWithVowelAndFollowedByQu() {
        assertThat(pigLatinTranslator.translate("equal")).isEqualTo("equalay");
    }

    @Test
    @Disabled
    @DisplayName("word beginning with p")
    public void testWordBeginningWithP() {
        assertThat(pigLatinTranslator.translate("pig")).isEqualTo("igpay");
    }

    @Test
    @Disabled
    @DisplayName("word beginning with k")
    public void testWordBeginningWithK() {
        assertThat(pigLatinTranslator.translate("koala")).isEqualTo("oalakay");
    }

    @Test
    @Disabled
    @DisplayName("word beginning with x")
    public void testWordBeginningWithX() {
        assertThat(pigLatinTranslator.translate("xenon")).isEqualTo("enonxay");
    }

    @Test
    @Disabled
    @DisplayName("word beginning with q without a following u")
    public void testWordBeginningWithQWithoutAFollowingU() {
        assertThat(pigLatinTranslator.translate("qat")).isEqualTo("atqay");
    }

    @Test
    @Disabled
    @DisplayName("word beginning with consonant and vowel containing qu")
    public void testWordBeginningWithConsonantAndVowelContainingQu() {
        assertThat(pigLatinTranslator.translate("liquid")).isEqualTo("iquidlay");
    }

    @Test
    @Disabled
    @DisplayName("word beginning with ch")
    public void testChTreatedLikeAConsonantAtTheBeginningOfAWord() {
        assertThat(pigLatinTranslator.translate("chair")).isEqualTo("airchay");
    }

    @Test
    @Disabled
    @DisplayName("word beginning with qu")
    public void testQuTreatedLikeAConsonantAtTheBeginningOfAWord() {
        assertThat(pigLatinTranslator.translate("queen")).isEqualTo("eenquay");
    }

    @Test
    @Disabled
    @DisplayName("word beginning with qu and a preceding consonant")
    public void testQuAndAPrecedingConsonantTreatedLikeAConsonantAtTheBeginningOfAWord() {
        assertThat(pigLatinTranslator.translate("square")).isEqualTo("aresquay");
    }

    @Test
    @Disabled
    @DisplayName("word beginning with th")
    public void testThTreatedLikeAConsonantAtTheBeginningOfAWord() {
        assertThat(pigLatinTranslator.translate("therapy")).isEqualTo("erapythay");
    }

    @Test
    @Disabled
    @DisplayName("word beginning with thr")
    public void testThrTreatedLikeAConsonantAtTheBeginningOfAWord() {
        assertThat(pigLatinTranslator.translate("thrush")).isEqualTo("ushthray");
    }

    @Test
    @Disabled
    @DisplayName("word beginning with sch")
    public void testSchTreatedLikeAConsonantAtTheBeginningOfAWord() {
        assertThat(pigLatinTranslator.translate("school")).isEqualTo("oolschay");
    }

    @Test
    @Disabled
    @DisplayName("word beginning with yt")
    public void testYtTreatedLikeAVowelAtTheBeginningOfAWord() {
        assertThat(pigLatinTranslator.translate("yttria")).isEqualTo("yttriaay");
    }

    @Test
    @Disabled
    @DisplayName("word beginning with xr")
    public void testXrTreatedLikeAVowelAtTheBeginningOfAWord() {
        assertThat(pigLatinTranslator.translate("xray")).isEqualTo("xrayay");
    }

    @Test
    @Disabled
    @DisplayName("y is treated like a consonant at the beginning of a word")
    public void testYTreatedLikeAConsonantAtTheBeginningOfAWord() {
        assertThat(pigLatinTranslator.translate("yellow")).isEqualTo("ellowyay");
    }

    @Test
    @Disabled
    @DisplayName("y is treated like a vowel at the end of a consonant cluster")
    public void testYTreatedLikeAVowelAtTheEndOfAConsonantCluster() {
        assertThat(pigLatinTranslator.translate("rhythm")).isEqualTo("ythmrhay");
    }

    @Test
    @Disabled
    @DisplayName("y as second letter in two letter word")
    public void testYAsSecondLetterInTwoLetterWord() {
        assertThat(pigLatinTranslator.translate("my")).isEqualTo("ymay");
    }

    @Test
    @Disabled
    @DisplayName("a whole phrase")
    public void testAWholePhrase() {
        assertThat(pigLatinTranslator.translate("quick fast run")).isEqualTo("ickquay astfay unray");
    }
}
