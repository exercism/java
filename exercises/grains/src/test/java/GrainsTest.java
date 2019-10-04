import org.junit.Ignore;
import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class GrainsTest {

    @Test
    public void countAtSquare1() {
        BigInteger result = Grains.computeNumberOfGrainsOnSquare(1);
        assertEquals(result, new BigInteger("1"));
    }

    @Test
    @Ignore("Remove to run test")
    public void countAtSquare2() {
        BigInteger result = Grains.computeNumberOfGrainsOnSquare(2);
        assertEquals(result, new BigInteger("2"));
    }

    @Test
    @Ignore("Remove to run test")
    public void countAtSquare3() {
        BigInteger result = Grains.computeNumberOfGrainsOnSquare(3);
        assertEquals(result, new BigInteger("4"));
    }

    @Test
    @Ignore("Remove to run test")
    public void countAtSquare4() {
        BigInteger result = Grains.computeNumberOfGrainsOnSquare(4);
        assertEquals(result, new BigInteger("8"));
    }

    @Test
    @Ignore("Remove to run test")
    public void countAtSquare16() {
        BigInteger result = Grains.computeNumberOfGrainsOnSquare(16);
        assertEquals(result, new BigInteger("32768"));
    }

    @Test
    @Ignore("Remove to run test")
    public void countAtSquare32() {
        BigInteger result = Grains.computeNumberOfGrainsOnSquare(32);
        assertEquals(result, new BigInteger("2147483648"));
    }

    @Test
    @Ignore("Remove to run test")
    public void countAtSquare64() {
        BigInteger result = Grains.computeNumberOfGrainsOnSquare(64);
        assertEquals(result, new BigInteger("9223372036854775808"));
    }

    @Test
    @Ignore("Remove to run test")
    public void errorOnNullBoardSize() {
        try {
            Grains.computeNumberOfGrainsOnSquare(0);
            fail("Grains#compute should have thrown");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(), "square must be between 1 and 64");
        }
    }

    @Test
    @Ignore("Remove to run test")
    public void errorOnNegativeBoardSize() {
        try {
            Grains.computeNumberOfGrainsOnSquare(-1);
            fail("Grains#compute should have thrown");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(), "square must be between 1 and 64");
        }
    }

    @Test
    @Ignore("Remove to run test")
    public void errorOnExcessiveBoardSize() {
        try {
            Grains.computeNumberOfGrainsOnSquare(65);
            fail("Grains#compute should have thrown");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(), "square must be between 1 and 64");
        }
    }

    @Test
    @Ignore("Remove to run test")
    public void totalNumberOfGrainsOnABoard() {
        BigInteger total = Grains.computeTotalNumberOfGrainsOnBoard();
        assertEquals(total, new BigInteger("18446744073709551615"));
    }

}
