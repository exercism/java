import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class GrainsTest {

    private Grains grains = new Grains();

    @Test
    public void countAtSquare1() {
        BigInteger result = grains.grainsOnSquare(1);
        assertThat(result).isEqualTo(new BigInteger("1"));
    }

    @Disabled("Remove to run test")
    @Test
    public void countAtSquare2() {
        BigInteger result = grains.grainsOnSquare(2);
        assertThat(result).isEqualTo(new BigInteger("2"));
    }

    @Disabled("Remove to run test")
    @Test
    public void countAtSquare3() {
        BigInteger result = grains.grainsOnSquare(3);
        assertThat(result).isEqualTo(new BigInteger("4"));
    }

    @Disabled("Remove to run test")
    @Test
    public void countAtSquare4() {
        BigInteger result = grains.grainsOnSquare(4);
        assertThat(result).isEqualTo(new BigInteger("8"));
    }

    @Disabled("Remove to run test")
    @Test
    public void countAtSquare16() {
        BigInteger result = grains.grainsOnSquare(16);
        assertThat(result).isEqualTo(new BigInteger("32768"));
    }

    @Disabled("Remove to run test")
    @Test
    public void countAtSquare32() {
        BigInteger result = grains.grainsOnSquare(32);
        assertThat(result).isEqualTo(new BigInteger("2147483648"));
    }

    @Disabled("Remove to run test")
    @Test
    public void countAtSquare64() {
        BigInteger result = grains.grainsOnSquare(64);
        assertThat(result).isEqualTo(new BigInteger("9223372036854775808"));
    }

    @Disabled("Remove to run test")
    @Test
    public void errorOnNullBoardSize() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> grains.grainsOnSquare(0))
                .withMessage("square must be between 1 and 64");
    }

    @Disabled("Remove to run test")
    @Test
    public void errorOnNegativeBoardSize() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> grains.grainsOnSquare(-1))
                .withMessage("square must be between 1 and 64");
    }

    @Disabled("Remove to run test")
    @Test
    public void errorOnExcessiveBoardSize() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> grains.grainsOnSquare(65))
                .withMessage("square must be between 1 and 64");
    }

    @Disabled("Remove to run test")
    @Test
    public void totalNumberOfGrainsOnABoard() {
        BigInteger total = grains.grainsOnBoard();
        assertThat(total).isEqualTo(new BigInteger("18446744073709551615"));
    }

}
