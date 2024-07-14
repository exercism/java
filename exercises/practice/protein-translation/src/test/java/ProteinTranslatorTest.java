import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class ProteinTranslatorTest {

    private ProteinTranslator proteinTranslator;

    @BeforeEach
    public void setUp() {
        proteinTranslator = new ProteinTranslator();
    }

    @Test
    public void testEmptyRnaSequenceResultInNoproteins() {
        assertThat(proteinTranslator.translate("")).isEmpty();
    }

    @Disabled("Remove to run test")
    @Test
    public void testMethionineRnaSequence() {
        assertThat(proteinTranslator.translate("AUG")).containsExactly("Methionine");
    }

    @Disabled("Remove to run test")
    @Test
    public void testPhenylalanineRnaSequence1() {
        assertThat(proteinTranslator.translate("UUU")).containsExactly("Phenylalanine");
    }

    @Disabled("Remove to run test")
    @Test
    public void testPhenylalanineRnaSequence2() {
        assertThat(proteinTranslator.translate("UUC")).containsExactly("Phenylalanine");
    }

    @Disabled("Remove to run test")
    @Test
    public void testLeucineRnaSequence1() {
        assertThat(proteinTranslator.translate("UUA")).containsExactly("Leucine");
    }

    @Disabled("Remove to run test")
    @Test
    public void testLeucineRnaSequence2() {
        assertThat(proteinTranslator.translate("UUG")).containsExactly("Leucine");
    }

    @Disabled("Remove to run test")
    @Test
    public void testSerineRnaSequence1() {
        assertThat(proteinTranslator.translate("UCU")).containsExactly("Serine");
    }

    @Disabled("Remove to run test")
    @Test
    public void testSerineRnaSequence2() {
        assertThat(proteinTranslator.translate("UCC")).containsExactly("Serine");
    }

    @Disabled("Remove to run test")
    @Test
    public void testSerineRnaSequence3() {
        assertThat(proteinTranslator.translate("UCA")).containsExactly("Serine");
    }

    @Disabled("Remove to run test")
    @Test
    public void testSerineRnaSequence4() {
        assertThat(proteinTranslator.translate("UCG")).containsExactly("Serine");
    }

    @Disabled("Remove to run test")
    @Test
    public void testTyrosineRnaSequence1() {
        assertThat(proteinTranslator.translate("UAU")).containsExactly("Tyrosine");
    }

    @Disabled("Remove to run test")
    @Test
    public void testTyrosineRnaSequence2() {
        assertThat(proteinTranslator.translate("UAC")).containsExactly("Tyrosine");
    }

    @Disabled("Remove to run test")
    @Test
    public void testCysteineRnaSequence1() {
        assertThat(proteinTranslator.translate("UGU")).containsExactly("Cysteine");
    }

    @Disabled("Remove to run test")
    @Test
    public void testCysteineRnaSequence2() {
        assertThat(proteinTranslator.translate("UGC")).containsExactly("Cysteine");
    }

    @Disabled("Remove to run test")
    @Test
    public void testTryptophanRnaSequence1() {
        assertThat(proteinTranslator.translate("UGG")).containsExactly("Tryptophan");
    }

    @Disabled("Remove to run test")
    @Test
    public void testStopRnaSequence1() {
        assertThat(proteinTranslator.translate("UAA")).isEmpty();
    }

    @Disabled("Remove to run test")
    @Test
    public void testStopRnaSequence2() {
        assertThat(proteinTranslator.translate("UAG")).isEmpty();
    }

    @Disabled("Remove to run test")
    @Test
    public void testStopRnaSequence3() {
        assertThat(proteinTranslator.translate("UGA")).isEmpty();
    }

    @Disabled("Remove to run test")
    @Test
    public void testSequenceOfTwoProteinCodonsTranslatesIntoProteins() {
        assertThat(proteinTranslator.translate("UUUUUU")).containsExactly("Phenylalanine", "Phenylalanine");
    }

    @Disabled("Remove to run test")
    @Test
    public void testSequenceOfTwoDifferentProteinCodonsTranslatesIntoProteins() {
        assertThat(proteinTranslator.translate("UUAUUG")).containsExactly("Leucine", "Leucine");
    }

    @Disabled("Remove to run test")
    @Test
    public void testTranslationOfRnaToProteinList() {
        assertThat(proteinTranslator.translate("AUGUUUUGG"))
                .containsExactly("Methionine", "Phenylalanine", "Tryptophan");
    }

    @Disabled("Remove to run test")
    @Test
    public void testTranslationStopsIfStopCodonAtBeginning() {
        assertThat(proteinTranslator.translate("UAGUGG")).isEmpty();
    }

    @Disabled("Remove to run test")
    @Test
    public void testTranslationStopsIfStopCodonAtEnd1() {
        assertThat(proteinTranslator.translate("UGGUAG")).containsExactly("Tryptophan");
    }

    @Disabled("Remove to run test")
    @Test
    public void testTranslationStopsIfStopCodonAtEnd2() {
        assertThat(proteinTranslator.translate("AUGUUUUAA")).containsExactly("Methionine", "Phenylalanine");
    }

    @Disabled("Remove to run test")
    @Test
    public void testTranslationStopsIfStopCodonInMiddle1() {
        assertThat(proteinTranslator.translate("UGGUAGUGG")).containsExactly("Tryptophan");
    }

    @Disabled("Remove to run test")
    @Test
    public void testTranslationStopsIfStopCodonInMiddle2() {
        assertThat(proteinTranslator.translate("UGGUGUUAUUAAUGGUUU"))
                .containsExactly("Tryptophan", "Cysteine", "Tyrosine");
    }

    @Disabled("Remove to run test")
    @Test
    public void testSequenceOfTwoNonStopCodonsDoNotTranslateToAStopCodon() {
        assertThat(proteinTranslator.translate("AUGAUG"))
                .containsExactly("Methionine", "Methionine");
    }

    @Disabled("Remove to run test")
    @Test
    public void testNonExistingCodonCantTranslate() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> proteinTranslator.translate("AAA"))
                .withMessage("Invalid codon");
    }

    @Disabled("Remove to run test")
    @Test
    public void testUnknownAminoAcidsNotPartOfACodonCantTranslate() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> proteinTranslator.translate("XYZ"))
                .withMessage("Invalid codon");
    }

    @Disabled("Remove to run test")
    @Test
    public void testIncompleteRnaSequenceCantTranslate() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> proteinTranslator.translate("AUGU"))
                .withMessage("Invalid codon");
    }

    @Disabled("Remove to run test")
    @Test
    public void testIncompleteRnaSequenceCanTranslateIfValidUntilAStopCodon() {
        assertThat(proteinTranslator.translate("UUCUUCUAAUGGU")).containsExactly("Phenylalanine", "Phenylalanine");
    }
}
