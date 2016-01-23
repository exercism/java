import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CryptoSquareTest {

    @Test
    public void strangeCharactersAreStrippedDuringNormalization() {
        Crypto crypto = new Crypto("s#$%^&plunk");
        String expectedOutput = "splunk";

        assertEquals(expectedOutput, crypto.getNormalizedPlaintext());
    }

    @Test
    public void lettersAreLowerCasedDuringNormalization() {
        Crypto crypto = new Crypto("WHOA HEY!");
        String expectedOutput = "whoahey";

        assertEquals(expectedOutput, crypto.getNormalizedPlaintext());
    }

    @Test
    public void numbersAreKeptDuringNormalization() {
        Crypto crypto = new Crypto("1, 2, 3, GO!");
        String expectedOutput = "123go";

        assertEquals(expectedOutput, crypto.getNormalizedPlaintext());
    }

    @Test
    public void smallestSquareSizeIs2() {
        Crypto crypto = new Crypto("1234");
        int expectedOutput = 2;

        assertEquals(expectedOutput, crypto.getSquareSize());
    }

    @Test
    public void sizeOfTextWhoseLengthIsPerfectSquareIsItsSquareRoot() {
        Crypto crypto = new Crypto("123456789");
        int expectedOutput = 3;

        assertEquals(expectedOutput, crypto.getSquareSize());
    }

    @Test
    public void sizeOfTextWhoseLengthIsNoPerfectSquareIsNextBiggestSquareRoot() {
        Crypto crypto = new Crypto("123456789abc");
        int expectedOutput = 4;

        assertEquals(expectedOutput, crypto.getSquareSize());
    }

    @Test
    public void sizeIsDeterminedByNormalizedText() {
        Crypto crypto = new Crypto("Oh hey, this is nuts!");
        int expectedOutput = 4;

        assertEquals(expectedOutput, crypto.getSquareSize());
    }

    @Test
    public void segmentsAreSplitBySquareSize() {
        Crypto crypto = new Crypto("Never vex thine heart with idle woes");
        List<String> expectedOutput = Arrays.asList(new String[]{"neverv", "exthin", "eheart", "withid", "lewoes"});

        assertEquals(expectedOutput, crypto.getPlaintextSegments());
    }

    @Test
    public void segmentsAreSplitBySquareSizeUntilTextRunsOut() {
        Crypto crypto = new Crypto("ZOMG! ZOMBIES!!!");
        List<String> expectedOutput = Arrays.asList(new String[]{"zomg", "zomb", "ies"});

        assertEquals(expectedOutput, crypto.getPlaintextSegments());
    }

    @Test
    public void cipherTextCombinesTextByColumn() {
        Crypto crypto = new Crypto("First, solve the problem. Then, write the code.");
        String expectedOutput = "foeewhilpmrervrticseohtottbeedshlnte";

        assertEquals(expectedOutput, crypto.getCipherText());
    }

    @Test
    public void cipherTextSkipsCellsWithNoText() {
        Crypto crypto = new Crypto("Time is an illusion. Lunchtime doubly so.");
        String expectedOutput = "tasneyinicdsmiohooelntuillibsuuml";

        assertEquals(expectedOutput, crypto.getCipherText());
    }

    @Test
    public void normalizedCipherTextIsSplitByHeightOfSquare() {
        Crypto crypto = new Crypto("Vampires are people too!");
        String expectedOutput = "vrel aepe mset paoo irpo";

        assertEquals(expectedOutput, crypto.getNormalizedCipherText());
    }

    @Test
    public void normalizedCipherNotExactlyDivisibleBy5SpillsIntoSmallerSegment() {
        Crypto crypto = new Crypto("Madness, and then illumination.");
        String expectedOutput = "msemo aanin dnin ndla etlt shui";

        assertEquals(expectedOutput, crypto.getNormalizedCipherText());
    }

    @Test
    public void normalizedCipherIsSplitIntoSegmentsOfCorrectSize() {
        Crypto crypto = new Crypto("If man was meant to stay on the ground god would have given us roots");
        String expectedOutput = "imtgdvs fearwer mayoogo anouuio ntnnlvt wttddes aohghn sseoau";

        assertEquals(expectedOutput, crypto.getNormalizedCipherText());
    }

    @Test
    public void normalizedCipherTextIsSplitIntoSegmentsOfCorrectSizeWithPunctuation() {
        Crypto crypto = new Crypto("Have a nice day. Feed the dog & chill out!");
        String expectedOutput = "hifei acedl veeol eddgo aatcu nyhht";

        assertEquals(expectedOutput, crypto.getNormalizedCipherText());
    }
}
