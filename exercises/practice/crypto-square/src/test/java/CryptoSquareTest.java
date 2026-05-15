import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CryptoSquareTest {

    @Test
    @DisplayName("empty plaintext results in an empty ciphertext")
    public void emptyPlaintextResultsInEmptyCiphertext() {
        CryptoSquare cryptoSquare = new CryptoSquare("");
        String expectedOutput = "";

        assertThat(cryptoSquare.getCiphertext()).isEqualTo(expectedOutput);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("normalization results in empty plaintext")
    public void normalizationResultsInEmptyCiphertext() {
        CryptoSquare cryptoSquare = new CryptoSquare("... --- ...");
        String expectedOutput = "";

        assertThat(cryptoSquare.getCiphertext()).isEqualTo(expectedOutput);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Lowercase")
    public void lettersAreLowerCasedDuringEncryption() {
        CryptoSquare cryptoSquare = new CryptoSquare("A");
        String expectedOutput = "a";

        assertThat(cryptoSquare.getCiphertext()).isEqualTo(expectedOutput);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Remove spaces")
    public void spacesAreRemovedDuringEncryption() {
        CryptoSquare cryptoSquare = new CryptoSquare(" b ");
        String expectedOutput = "b";

        assertThat(cryptoSquare.getCiphertext()).isEqualTo(expectedOutput);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Remove punctuation")
    public void punctuationIsRemovedDuringEncryption() {
        CryptoSquare cryptoSquare = new CryptoSquare("@1,%!");
        String expectedOutput = "1";

        assertThat(cryptoSquare.getCiphertext()).isEqualTo(expectedOutput);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("9 character plaintext results in 3 chunks of 3 characters")
    public void nineCharacterPlaintextResultsInThreeChunksOfThreeCharacters() {
        CryptoSquare cryptoSquare = new CryptoSquare("This is fun!");
        String expectedOutput = "tsf hiu isn";

        assertThat(cryptoSquare.getCiphertext()).isEqualTo(expectedOutput);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("8 character plaintext results in 3 chunks, the last one with a trailing space")
    public void eightCharacterPlaintextResultsInThreeChunksWithATrailingSpace() {
        CryptoSquare cryptoSquare = new CryptoSquare("Chill out.");
        String expectedOutput = "clu hlt io ";

        assertThat(cryptoSquare.getCiphertext()).isEqualTo(expectedOutput);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("54 character plaintext results in 8 chunks, the last two with trailing spaces")
    public void fiftyFourCharacterPlaintextResultsInEightChunksWithTrailingSpaces() {
        CryptoSquare cryptoSquare = new CryptoSquare("If man was meant to stay on the ground, god would have " +
                "given us roots.");
        String expectedOutput = "imtgdvs fearwer mayoogo anouuio ntnnlvt wttddes aohghn  sseoau ";

        assertThat(cryptoSquare.getCiphertext()).isEqualTo(expectedOutput);
    }
}
