import org.junit.Test;
import org.junit.Ignore;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CryptoSquareTest {

    @Test
    public void emptyPlaintextResultsInEmptyCiphertext() {
        Crypto crypto = new Crypto("");
        String expectedOutput = "";

        assertEquals(expectedOutput, crypto.getCiphertext());
    }

    @Ignore("Remove to run test")
    @Test
    public void lettersAreLowerCasedDuringEncryption() {
        Crypto crypto = new Crypto("A");
        String expectedOutput = "a";

        assertEquals(expectedOutput, crypto.getCiphertext());
    }

    @Ignore("Remove to run test")
    @Test
    public void spacesAreRemovedDuringEncryption() {
        Crypto crypto = new Crypto(" b ");
        String expectedOutput = "b";

        assertEquals(expectedOutput, crypto.getCiphertext());
    }

    @Ignore("Remove to run test")
    @Test
    public void punctuationIsRemovedDuringEncryption() {
        Crypto crypto = new Crypto("@1,%!");
        String expectedOutput = "1";

        assertEquals(expectedOutput, crypto.getCiphertext());
    }

    @Ignore("Remove to run test")
    @Test
    public void nineCharacterPlaintextResultsInThreeChunksOfThreeCharacters() {
        Crypto crypto = new Crypto("This is fun!");
        String expectedOutput = "tsf hiu isn";

        assertEquals(expectedOutput, crypto.getCiphertext());
    }

    @Ignore("Remove to run test")
    @Test
    public void eightCharacterPlaintextResultsInThreeChunksWithATrailingSpace() {
        Crypto crypto = new Crypto("Chill out.");
        String expectedOutput = "clu hlt io ";

        assertEquals(expectedOutput, crypto.getCiphertext());
    }

    @Ignore("Remove to run test")
    @Test
    public void fiftyFourCharacterPlaintextResultsInSevenChunksWithTrailingSpaces() {
        Crypto crypto = new Crypto("If man was meant to stay on the ground, god would have given us roots.");
        String expectedOutput = "imtgdvs fearwer mayoogo anouuio ntnnlvt wttddes aohghn  sseoau ";

        assertEquals(expectedOutput, crypto.getCiphertext());
    }
}
