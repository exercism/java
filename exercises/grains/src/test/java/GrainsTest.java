import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class GrainsTest {

    private Grains grains;

    @Before
    public void setup() {
        grains = new Grains();
    }


    @Test
    public void countAtSquare1() {
        BigInteger result = grains.computeNumberOfGrainsOnSquare(1);
        assertEquals(new BigInteger("1"), result);
    }

    @Ignore("Remove to run test")
    @Test
    public void countAtSquare2() {
        BigInteger result = grains.computeNumberOfGrainsOnSquare(2);
        assertEquals(new BigInteger("2"), result);
    }

    @Ignore("Remove to run test")
    @Test
    public void countAtSquare3() {
        BigInteger result = grains.computeNumberOfGrainsOnSquare(3);
        assertEquals(new BigInteger("4"), result);
    }

    @Ignore("Remove to run test")
    @Test
    public void countAtSquare4() {
        BigInteger result = grains.computeNumberOfGrainsOnSquare(4);
        assertEquals(new BigInteger("8"), result);
    }

    @Ignore("Remove to run test")
    @Test
    public void countAtSquare16() {
        BigInteger result = grains.computeNumberOfGrainsOnSquare(16);
        assertEquals(new BigInteger("32768"), result);
    }

    @Ignore("Remove to run test")
    @Test
    public void countAtSquare32() {
        BigInteger result = grains.computeNumberOfGrainsOnSquare(32);
        assertEquals(new BigInteger("2147483648"), result);
    }

    @Ignore("Remove to run test")
    @Test
    public void countAtSquare64() {
        BigInteger result = grains.computeNumberOfGrainsOnSquare(64);
        assertEquals(new BigInteger("9223372036854775808"), result);
    }

    @Ignore("Remove to run test")
    @Test
    public void errorOnNullBoardSize() {
        try {
            grains.computeNumberOfGrainsOnSquare(0);
            fail("Grains#compute should have thrown");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(), "square must be between 1 and 64");
        }
    }

    @Ignore("Remove to run test")
    @Test
    public void errorOnNegativeBoardSize() {
        try {
            grains.computeNumberOfGrainsOnSquare(-1);
            fail("Grains#compute should have thrown");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(), "square must be between 1 and 64");
        }
    }

    @Ignore("Remove to run test")
    @Test
    public void errorOnExcessiveBoardSize() {
        try {
            grains.computeNumberOfGrainsOnSquare(65);
            fail("Grains#compute should have thrown");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(), "square must be between 1 and 64");
        }
    }

    @Ignore("Remove to run test")
    @Test
    public void totalNumberOfGrainsOnABoard() {
        BigInteger total = grains.computeTotalNumberOfGrainsOnBoard();
        assertEquals(new BigInteger("18446744073709551615"), total);
    }

}
