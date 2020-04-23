import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Ignore;
import org.junit.Test;

import java.math.BigInteger;

public class GrainsTest {

    private Grains grains = new Grains();
    
    @Test
    public void countAtSquare1() {
        BigInteger result = grains.grainsOnSquare(1);
        assertEquals(new BigInteger("1"), result);
    }

    @Ignore("Remove to run test")
    @Test
    public void countAtSquare2() {
        BigInteger result = grains.grainsOnSquare(2);
        assertEquals(new BigInteger("2"), result);
    }

    @Ignore("Remove to run test")
    @Test
    public void countAtSquare3() {
        BigInteger result = grains.grainsOnSquare(3);
        assertEquals(new BigInteger("4"), result);
    }

    @Ignore("Remove to run test")
    @Test
    public void countAtSquare4() {
        BigInteger result = grains.grainsOnSquare(4);
        assertEquals(new BigInteger("8"), result);
    }

    @Ignore("Remove to run test")
    @Test
    public void countAtSquare16() {
        BigInteger result = grains.grainsOnSquare(16);
        assertEquals(new BigInteger("32768"), result);
    }

    @Ignore("Remove to run test")
    @Test
    public void countAtSquare32() {
        BigInteger result = grains.grainsOnSquare(32);
        assertEquals(new BigInteger("2147483648"), result);
    }

    @Ignore("Remove to run test")
    @Test
    public void countAtSquare64() {
        BigInteger result = grains.grainsOnSquare(64);
        assertEquals(new BigInteger("9223372036854775808"), result);
    }

    @Ignore("Remove to run test")
    @Test
    public void errorOnNullBoardSize() {
        IllegalArgumentException expected =
            assertThrows(
                IllegalArgumentException.class,
                () -> grains.grainsOnSquare(0));

        assertThat(expected)
            .hasMessage("square must be between 1 and 64");
    }

    @Ignore("Remove to run test")
    @Test
    public void errorOnNegativeBoardSize() {
        IllegalArgumentException expected =
            assertThrows(
                IllegalArgumentException.class,
                () -> grains.grainsOnSquare(-1));

        assertThat(expected)
            .hasMessage("square must be between 1 and 64");
    }

    @Ignore("Remove to run test")
    @Test
    public void errorOnExcessiveBoardSize() {
        IllegalArgumentException expected =
            assertThrows(
                IllegalArgumentException.class,
                () -> grains.grainsOnSquare(65));

        assertThat(expected)
            .hasMessage("square must be between 1 and 64");
    }

    @Ignore("Remove to run test")
    @Test
    public void totalNumberOfGrainsOnABoard() {
        BigInteger total = grains.grainsOnBoard();
        assertEquals(new BigInteger("18446744073709551615"), total);
    }

}
