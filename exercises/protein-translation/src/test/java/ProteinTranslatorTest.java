import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ProteinTranslatorTest {

    private ProteinTranslator proteinTranslator;

    @Before
    public void setUp() {
        proteinTranslator = new ProteinTranslator();
    }

    @Test
    public void testMethionineRnaSequence() {
        List<String> expected = Arrays.asList("Methionine");
        assertEquals(expected, proteinTranslator.translate("AUG"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testPhenylalanineRnaSequence1() {
        List<String> expected = Arrays.asList("Phenylalanine");
        assertEquals(expected, proteinTranslator.translate("UUU"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testPhenylalanineRnaSequence2() {
        List<String> expected = Arrays.asList("Phenylalanine");
        assertEquals(expected, proteinTranslator.translate("UUC"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testLeucineRnaSequence1() {
        List<String> expected = Arrays.asList("Leucine");
        assertEquals(expected, proteinTranslator.translate("UUA"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testLeucineRnaSequence2() {
        List<String> expected = Arrays.asList("Leucine");
        assertEquals(expected, proteinTranslator.translate("UUG"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testSerineRnaSequence1() {
        List<String> expected = Arrays.asList("Serine");
        assertEquals(expected, proteinTranslator.translate("UCU"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testSerineRnaSequence2() {
        List<String> expected = Arrays.asList("Serine");
        assertEquals(expected, proteinTranslator.translate("UCC"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testSerineRnaSequence3() {
        List<String> expected = Arrays.asList("Serine");
        assertEquals(expected, proteinTranslator.translate("UCA"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testSerineRnaSequence4() {
        List<String> expected = Arrays.asList("Serine");
        assertEquals(expected, proteinTranslator.translate("UCG"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testTyrosineRnaSequence1() {
        List<String> expected = Arrays.asList("Tyrosine");
        assertEquals(expected, proteinTranslator.translate("UAU"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testTyrosineRnaSequence2() {
        List<String> expected = Arrays.asList("Tyrosine");
        assertEquals(expected, proteinTranslator.translate("UAC"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testCysteineRnaSequence1() {
        List<String> expected = Arrays.asList("Cysteine");
        assertEquals(expected, proteinTranslator.translate("UGU"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testCysteineRnaSequence2() {
        List<String> expected = Arrays.asList("Cysteine");
        assertEquals(expected, proteinTranslator.translate("UGC"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testTryptophanRnaSequence1() {
        List<String> expected = Arrays.asList("Tryptophan");
        assertEquals(expected, proteinTranslator.translate("UGG"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testStopRnaSequence1() {
        List<String> expected = Arrays.asList();
        assertEquals(expected, proteinTranslator.translate("UAA"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testStopRnaSequence2() {
        List<String> expected = Arrays.asList();
        assertEquals(expected, proteinTranslator.translate("UAG"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testStopRnaSequence3() {
        List<String> expected = Arrays.asList();
        assertEquals(expected, proteinTranslator.translate("UGA"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testTranslationOfRnaToProteinList() {
        List<String> expected = Arrays.asList("Methionine", "Phenylalanine", "Tryptophan");
        assertEquals(expected, proteinTranslator.translate("AUGUUUUGG"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testTranslationStopsIfStopCodonAtBeginning() {
        List<String> expected = Arrays.asList();
        assertEquals(expected, proteinTranslator.translate("UAGUGG"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testTranslationStopsIfStopCodonAtEnd1() {
        List<String> expected = Arrays.asList("Tryptophan");
        assertEquals(expected, proteinTranslator.translate("UGGUAG"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testTranslationStopsIfStopCodonAtEnd2() {
        List<String> expected = Arrays.asList("Methionine", "Phenylalanine");
        assertEquals(expected, proteinTranslator.translate("AUGUUUUAA"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testTranslationStopsIfStopCodonInMiddle1() {
        List<String> expected = Arrays.asList("Tryptophan");
        assertEquals(expected, proteinTranslator.translate("UGGUAGUGG"));
    }

    @Ignore("Remove to run test")
    @Test
    public void testTranslationStopsIfStopCodonInMiddle2() {
        List<String> expected = Arrays.asList("Tryptophan", "Cysteine", "Tyrosine");
        assertEquals(expected, proteinTranslator.translate("UGGUGUUAUUAAUGGUUU"));
    }

}
