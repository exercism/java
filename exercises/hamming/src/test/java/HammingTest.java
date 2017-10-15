import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class HammingTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testNoDistanceBetweenEmptyStrands() {
        assertEquals(0, new Hamming("", "").getHammingDistance());
    }

    @Ignore("Remove to run test")
    @Test
    public void testNoDistanceBetweenShortIdenticalStrands() {
        assertEquals(0, new Hamming("A", "A").getHammingDistance());
    }

    @Ignore("Remove to run test")
    @Test
    public void testNoDistanceBetweenLongIdenticalStrands() {
        assertEquals(0, new Hamming("GGACTGA", "GGACTGA").getHammingDistance());
    }

    @Ignore("Remove to run test")
    @Test
    public void testCompleteDistanceInSingleNucleotideStrand() {
        assertEquals(1, new Hamming("A", "G").getHammingDistance());
    }

    @Ignore("Remove to run test")
    @Test
    public void testCompleteDistanceInSmallStrand() {
        assertEquals(2, new Hamming("AG", "CT").getHammingDistance());
    }

    @Ignore("Remove to run test")
    @Test
    public void testSmallDistanceInSmallStrand() {
        assertEquals(1, new Hamming("AT", "CT").getHammingDistance());
    }

    @Ignore("Remove to run test")
    @Test
    public void testSmallDistanceInMediumStrand() {
        assertEquals(1, new Hamming("GGACG", "GGTCG").getHammingDistance());
    }

    @Ignore("Remove to run test")
    @Test
    public void testSmallDistanceInLongStrand() {
        assertEquals(2, new Hamming("ACCAGGG", "ACTATGG").getHammingDistance());
    }

    @Ignore("Remove to run test")
    @Test
    public void testNonUniqueCharacterInFirstStrand() {
        assertEquals(1, new Hamming("AGA", "AGG").getHammingDistance());
    }

    @Ignore("Remove to run test")
    @Test
    public void testNonUniqueCharacterInSecondStrand() {
        assertEquals(1, new Hamming("AGG", "AGA").getHammingDistance());
    }

    @Ignore("Remove to run test")
    @Test
    public void testSameNucleotidesInDifferentPositions() {
        assertEquals(2, new Hamming("TAG", "GAT").getHammingDistance());
    }

    @Ignore("Remove to run test")
    @Test
    public void testLargeDistanceInPermutedStrand() {
        assertEquals(4, new Hamming("GATACA", "GCATAA").getHammingDistance());
    }

    @Ignore("Remove to run test")
    @Test
    public void testLargeDistanceInOffByOneStrand() {
        assertEquals(9, new Hamming("GGACGGATTCTG", "AGGACGGATTCT").getHammingDistance());
    }

    @Ignore("Remove to run test")
    @Test
    public void testValidatesFirstStrandNotLonger() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("leftStrand and rightStrand must be of equal length.");

        new Hamming("AATG", "AAA");
    }

    @Ignore("Remove to run test")
    @Test
    public void testValidatesSecondStrandNotLonger() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("leftStrand and rightStrand must be of equal length.");

        new Hamming("ATA", "AGTG");
    }

}
