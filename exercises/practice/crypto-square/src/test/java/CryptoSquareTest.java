import org.junit.Test;
import org.junit.Ignore;

import static org.junit.Assert.assertEquals;

public class CryptoSquareTest {

    @Test
    public void emptyPlaintextResultsInEmptyCiphertext() {
        CryptoSquare cryptoSquare = new CryptoSquare("");
        String expectedOutput = "";

        assertEquals(expectedOutput, cryptoSquare.getCiphertext());
    }

    @Ignore("Remove to run test")
    @Test
    public void lettersAreLowerCasedDuringEncryption() {
        CryptoSquare cryptoSquare = new CryptoSquare("A");
        String expectedOutput = "a";

        assertEquals(expectedOutput, cryptoSquare.getCiphertext());
    }

    @Ignore("Remove to run test")
    @Test
    public void spacesAreRemovedDuringEncryption() {
        CryptoSquare cryptoSquare = new CryptoSquare(" b ");
        String expectedOutput = "b";

        assertEquals(expectedOutput, cryptoSquare.getCiphertext());
    }

    @Ignore("Remove to run test")
    @Test
    public void punctuationIsRemovedDuringEncryption() {
        CryptoSquare cryptoSquare = new CryptoSquare("@1,%!");
        String expectedOutput = "1";

        assertEquals(expectedOutput, cryptoSquare.getCiphertext());
    }

    @Ignore("Remove to run test")
    @Test
    public void nineCharacterPlaintextResultsInThreeChunksOfThreeCharacters() {
        CryptoSquare cryptoSquare = new CryptoSquare("This is fun!");
        String expectedOutput = "tsf hiu isn";

        assertEquals(expectedOutput, cryptoSquare.getCiphertext());
    }

    @Ignore("Remove to run test")
    @Test
    public void eightCharacterPlaintextResultsInThreeChunksWithATrailingSpace() {
        CryptoSquare cryptoSquare = new CryptoSquare("Chill out.");
        String expectedOutput = "clu hlt io ";

        assertEquals(expectedOutput, cryptoSquare.getCiphertext());
    }

    @Ignore("Remove to run test")
    @Test
    public void fiftyFourCharacterPlaintextResultsInSevenChunksWithTrailingSpaces() {
        CryptoSquare cryptoSquare = new CryptoSquare("If man was meant to stay on the ground, god would have " +
                                                     "given us roots.");
        String expectedOutput = "imtgdvs fearwer mayoogo anouuio ntnnlvt wttddes aohghn  sseoau ";

        assertEquals(expectedOutput, cryptoSquare.getCiphertext());
    }
}
