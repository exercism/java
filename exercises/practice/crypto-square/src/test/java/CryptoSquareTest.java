import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CryptoSquareTest {

    @Test
    public void emptyPlaintextResultsInEmptyCiphertext() {
        CryptoSquare cryptoSquare = new CryptoSquare("");
        String expectedOutput = "";

        assertThat(cryptoSquare.getCiphertext()).isEqualTo(expectedOutput);
    }

    @Disabled("Remove to run test")
    @Test
    public void normalizationResultsInEmptyCiphertext() {
        CryptoSquare cryptoSquare = new CryptoSquare("... --- ...");
        String expectedOutput = "";

        assertThat(cryptoSquare.getCiphertext()).isEqualTo(expectedOutput);
    }

    @Disabled("Remove to run test")
    @Test
    public void lettersAreLowerCasedDuringEncryption() {
        CryptoSquare cryptoSquare = new CryptoSquare("A");
        String expectedOutput = "a";

        assertThat(cryptoSquare.getCiphertext()).isEqualTo(expectedOutput);
    }

    @Disabled("Remove to run test")
    @Test
    public void spacesAreRemovedDuringEncryption() {
        CryptoSquare cryptoSquare = new CryptoSquare(" b ");
        String expectedOutput = "b";

        assertThat(cryptoSquare.getCiphertext()).isEqualTo(expectedOutput);
    }

    @Disabled("Remove to run test")
    @Test
    public void punctuationIsRemovedDuringEncryption() {
        CryptoSquare cryptoSquare = new CryptoSquare("@1,%!");
        String expectedOutput = "1";

        assertThat(cryptoSquare.getCiphertext()).isEqualTo(expectedOutput);
    }

    @Disabled("Remove to run test")
    @Test
    public void nineCharacterPlaintextResultsInThreeChunksOfThreeCharacters() {
        CryptoSquare cryptoSquare = new CryptoSquare("This is fun!");
        String expectedOutput = "tsf hiu isn";

        assertThat(cryptoSquare.getCiphertext()).isEqualTo(expectedOutput);
    }

    @Disabled("Remove to run test")
    @Test
    public void eightCharacterPlaintextResultsInThreeChunksWithATrailingSpace() {
        CryptoSquare cryptoSquare = new CryptoSquare("Chill out.");
        String expectedOutput = "clu hlt io ";

        assertThat(cryptoSquare.getCiphertext()).isEqualTo(expectedOutput);
    }

    @Disabled("Remove to run test")
    @Test
    public void fiftyFourCharacterPlaintextResultsInSevenChunksWithTrailingSpaces() {
        CryptoSquare cryptoSquare = new CryptoSquare("If man was meant to stay on the ground, god would have " +
                "given us roots.");
        String expectedOutput = "imtgdvs fearwer mayoogo anouuio ntnnlvt wttddes aohghn  sseoau ";

        assertThat(cryptoSquare.getCiphertext()).isEqualTo(expectedOutput);
    }
}
