import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class GrainsTest {

    private Grains grains = new Grains();

    @Test
    @DisplayName("returns the number of grains on the square")
    public void countAtSquare1() {
        BigInteger result = grains.grainsOnSquare(1);
        assertThat(result).isEqualTo(new BigInteger("1"));
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("grains on square 2")
    public void countAtSquare2() {
        BigInteger result = grains.grainsOnSquare(2);
        assertThat(result).isEqualTo(new BigInteger("2"));
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("grains on square 3")
    public void countAtSquare3() {
        BigInteger result = grains.grainsOnSquare(3);
        assertThat(result).isEqualTo(new BigInteger("4"));
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("grains on square 4")
    public void countAtSquare4() {
        BigInteger result = grains.grainsOnSquare(4);
        assertThat(result).isEqualTo(new BigInteger("8"));
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("grains on square 16")
    public void countAtSquare16() {
        BigInteger result = grains.grainsOnSquare(16);
        assertThat(result).isEqualTo(new BigInteger("32768"));
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("grains on square 32")
    public void countAtSquare32() {
        BigInteger result = grains.grainsOnSquare(32);
        assertThat(result).isEqualTo(new BigInteger("2147483648"));
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("grains on square 64")
    public void countAtSquare64() {
        BigInteger result = grains.grainsOnSquare(64);
        assertThat(result).isEqualTo(new BigInteger("9223372036854775808"));
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("square 0 is invalid")
    public void errorOnNullBoardSize() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> grains.grainsOnSquare(0))
                .withMessage("square must be between 1 and 64");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("negative square is invalid")
    public void errorOnNegativeBoardSize() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> grains.grainsOnSquare(-1))
                .withMessage("square must be between 1 and 64");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("square greater than 64 is invalid")
    public void errorOnExcessiveBoardSize() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> grains.grainsOnSquare(65))
                .withMessage("square must be between 1 and 64");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("returns the total number of grains on the board")
    public void totalNumberOfGrainsOnABoard() {
        BigInteger total = grains.grainsOnBoard();
        assertThat(total).isEqualTo(new BigInteger("18446744073709551615"));
    }

}
