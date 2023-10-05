import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ProteinTranslatorTest {

    private ProteinTranslator proteinTranslator;

    @Before
    public void setUp() {
        proteinTranslator = new ProteinTranslator();
    }

    @Test
    public void testMethionineRnaSequence() {
        assertThat(proteinTranslator.translate("AUG")).containsExactly("Methionine");
    }

    @Ignore("Remove to run test")
    @Test
    public void testPhenylalanineRnaSequence1() {
        assertThat(proteinTranslator.translate("UUU")).containsExactly("Phenylalanine");
    }

    @Ignore("Remove to run test")
    @Test
    public void testPhenylalanineRnaSequence2() {
        assertThat(proteinTranslator.translate("UUC")).containsExactly("Phenylalanine");
    }

    @Ignore("Remove to run test")
    @Test
    public void testLeucineRnaSequence1() {
        assertThat(proteinTranslator.translate("UUA")).containsExactly("Leucine");
    }

    @Ignore("Remove to run test")
    @Test
    public void testLeucineRnaSequence2() {
        assertThat(proteinTranslator.translate("UUG")).containsExactly("Leucine");
    }

    @Ignore("Remove to run test")
    @Test
    public void testSerineRnaSequence1() {
        assertThat(proteinTranslator.translate("UCU")).containsExactly("Serine");
    }

    @Ignore("Remove to run test")
    @Test
    public void testSerineRnaSequence2() {
        assertThat(proteinTranslator.translate("UCC")).containsExactly("Serine");
    }

    @Ignore("Remove to run test")
    @Test
    public void testSerineRnaSequence3() {
        assertThat(proteinTranslator.translate("UCA")).containsExactly("Serine");
    }

    @Ignore("Remove to run test")
    @Test
    public void testSerineRnaSequence4() {
        assertThat(proteinTranslator.translate("UCG")).containsExactly("Serine");
    }

    @Ignore("Remove to run test")
    @Test
    public void testTyrosineRnaSequence1() {
        assertThat(proteinTranslator.translate("UAU")).containsExactly("Tyrosine");
    }

    @Ignore("Remove to run test")
    @Test
    public void testTyrosineRnaSequence2() {
        assertThat(proteinTranslator.translate("UAC")).containsExactly("Tyrosine");
    }

    @Ignore("Remove to run test")
    @Test
    public void testCysteineRnaSequence1() {
        assertThat(proteinTranslator.translate("UGU")).containsExactly("Cysteine");
    }

    @Ignore("Remove to run test")
    @Test
    public void testCysteineRnaSequence2() {
        assertThat(proteinTranslator.translate("UGC")).containsExactly("Cysteine");
    }

    @Ignore("Remove to run test")
    @Test
    public void testTryptophanRnaSequence1() {
        assertThat(proteinTranslator.translate("UGG")).containsExactly("Tryptophan");
    }

    @Ignore("Remove to run test")
    @Test
    public void testStopRnaSequence1() {
        assertThat(proteinTranslator.translate("UAA")).isEmpty();
    }

    @Ignore("Remove to run test")
    @Test
    public void testStopRnaSequence2() {
        assertThat(proteinTranslator.translate("UAG")).isEmpty();
    }

    @Ignore("Remove to run test")
    @Test
    public void testStopRnaSequence3() {
        assertThat(proteinTranslator.translate("UGA")).isEmpty();
    }

    @Ignore("Remove to run test")
    @Test
    public void testTranslationOfRnaToProteinList() {
        assertThat(proteinTranslator.translate("AUGUUUUGG"))
            .containsExactly("Methionine", "Phenylalanine", "Tryptophan");
    }

    @Ignore("Remove to run test")
    @Test
    public void testTranslationStopsIfStopCodonAtBeginning() {
        assertThat(proteinTranslator.translate("UAGUGG")).isEmpty();
    }

    @Ignore("Remove to run test")
    @Test
    public void testTranslationStopsIfStopCodonAtEnd1() {
        assertThat(proteinTranslator.translate("UGGUAG")).containsExactly("Tryptophan");
    }

    @Ignore("Remove to run test")
    @Test
    public void testTranslationStopsIfStopCodonAtEnd2() {
        assertThat(proteinTranslator.translate("AUGUUUUAA")).containsExactly("Methionine", "Phenylalanine");
    }

    @Ignore("Remove to run test")
    @Test
    public void testTranslationStopsIfStopCodonInMiddle1() {
        assertThat(proteinTranslator.translate("UGGUAGUGG")).containsExactly("Tryptophan");
    }

    @Ignore("Remove to run test")
    @Test
    public void testTranslationStopsIfStopCodonInMiddle2() {
        assertThat(proteinTranslator.translate("UGGUGUUAUUAAUGGUUU"))
            .containsExactly("Tryptophan", "Cysteine", "Tyrosine");
    }

}
