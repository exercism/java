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
    @DisplayName("ay is added to words that begin with a vowel")
    public void testWordBeginningWithA() {
        assertThat(pigLatinTranslator.translate("apple")).isEqualTo("appleay");
    }

    @Test
    @DisplayName("ear is added to words starting with e")
    public void testWordBeginningWithE() {
        assertThat(pigLatinTranslator.translate("ear")).isEqualTo("earay");
    }

    @Test
    @DisplayName("ay is added to words starting with i")
    public void testWordBeginningWithI() {
        assertThat(pigLatinTranslator.translate("igloo")).isEqualTo("iglooay");
    }

    @Test
    @DisplayName("ay is added to words starting with o")
    public void testWordBeginningWithO() {
        assertThat(pigLatinTranslator.translate("object")).isEqualTo("objectay");
    }

    @Test
    @DisplayName("ay is added to words starting with u")
    public void testWordBeginningWithU() {
        assertThat(pigLatinTranslator.translate("under")).isEqualTo("underay");
    }

    @Test
    @DisplayName("word beginning with vowel and followed by qu")
    public void testWordBeginningWithVowelAndFollowedByQu() {
        assertThat(pigLatinTranslator.translate("equal")).isEqualTo("equalay");
    }

    @Test
    @DisplayName("word beginning with p added with ay at the end")
    public void testWordBeginningWithP() {
        assertThat(pigLatinTranslator.translate("pig")).isEqualTo("igpay");
    }

    @Test
    @DisplayName("word beginning with k added with ay at the end")
    public void testWordBeginningWithK() {
        assertThat(pigLatinTranslator.translate("koala")).isEqualTo("oalakay");
    }

    @Test
    @DisplayName("word beginning with x added with ay at the end")
    public void testWordBeginningWithX() {
        assertThat(pigLatinTranslator.translate("xenon")).isEqualTo("enonxay");
    }

    @Test
    @DisplayName("word beginning with q without a following u")
    public void testWordBeginningWithQWithoutAFollowingU() {
        assertThat(pigLatinTranslator.translate("qat")).isEqualTo("atqay");
    }

    @Test
    @DisplayName("word beginning with consonant and vowel containing qu")
    public void testWordBeginningWithConsonantAndVowelContainingQu() {
        assertThat(pigLatinTranslator.translate("liquid")).isEqualTo("iquidlay");
    }

    @Test
    @DisplayName("ch treated like a consonant")
    public void testChTreatedLikeAConsonantAtTheBeginningOfAWord() {
        assertThat(pigLatinTranslator.translate("chair")).isEqualTo("airchay");
    }

    @Test
    @DisplayName("qu treated like a consonant at the beginning of a word")
    public void testQuTreatedLikeAConsonantAtTheBeginningOfAWord() {
        assertThat(pigLatinTranslator.translate("queen")).isEqualTo("eenquay");
    }

    @Test
    @DisplayName("qu and a preceding consonant treated like a consonant at the beginning of a word")
    public void testQuAndAPrecedingConsonantTreatedLikeAConsonantAtTheBeginningOfAWord() {
        assertThat(pigLatinTranslator.translate("square")).isEqualTo("aresquay");
    }

    @Test
    @DisplayName("th treated like a consonant at the beginning of a word")
    public void testThTreatedLikeAConsonantAtTheBeginningOfAWord() {
        assertThat(pigLatinTranslator.translate("therapy")).isEqualTo("erapythay");
    }

    @Test
    @DisplayName("thr treated like a consonant at the beginning of a word")
    public void testThrTreatedLikeAConsonantAtTheBeginningOfAWord() {
        assertThat(pigLatinTranslator.translate("thrush")).isEqualTo("ushthray");
    }

    @Test
    @DisplayName("sch treated like a consonant at the beginning of a word")
    public void testSchTreatedLikeAConsonantAtTheBeginningOfAWord() {
        assertThat(pigLatinTranslator.translate("school")).isEqualTo("oolschay");
    }

    @Test
    @DisplayName("yt treated like a vowel at the beginning of a word")
    public void testYtTreatedLikeAVowelAtTheBeginningOfAWord() {
        assertThat(pigLatinTranslator.translate("yttria")).isEqualTo("yttriaay");
    }

    @Test
    @DisplayName("xr treated like a vowel at the beginning of a word")
    public void testXrTreatedLikeAVowelAtTheBeginningOfAWord() {
        assertThat(pigLatinTranslator.translate("xray")).isEqualTo("xrayay");
    }

    @Test
    @DisplayName("yt treated like a consonant at the beginning of a word")
    public void testYTreatedLikeAConsonantAtTheBeginningOfAWord() {
        assertThat(pigLatinTranslator.translate("yellow")).isEqualTo("ellowyay");
    }

    @Test
    @DisplayName("yt treated like a vowel at the end of a consonant cluster")
    public void testYTreatedLikeAVowelAtTheEndOfAConsonantCluster() {
        assertThat(pigLatinTranslator.translate("rhythm")).isEqualTo("ythmrhay");
    }

    @Test
    @DisplayName("y as second letter in two-letter word")
    public void testYAsSecondLetterInTwoLetterWord() {
        assertThat(pigLatinTranslator.translate("my")).isEqualTo("ymay");
    }

    @Test
    @DisplayName("a whole phrase")
    public void testAWholePhrase() {
        assertThat(pigLatinTranslator.translate("quick fast run")).isEqualTo("ickquay astfay unray");
    }
}
