import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class GrainsTest {

    @Test
    public void countAtCell1() {
        final BigInteger result = Grains.compute(1);
        assertEquals(new BigInteger("1"), result);
    }

    @Test
    public void countAtCell2() {
        final BigInteger result = Grains.compute(2);
        assertEquals(new BigInteger("2"), result);
    }

    @Test
    public void countAtCell3() {
        final BigInteger result = Grains.compute(3);
        assertEquals(new BigInteger("4"), result);
    }

    @Test
    public void countAtCell4() {
        final BigInteger result = Grains.compute(4);
        assertEquals(new BigInteger("8"), result);
    }

    @Test
    public void countAtCell16() {
        final BigInteger result = Grains.compute(16);
        assertEquals(new BigInteger("32768"), result);
    }

    @Test
    public void countAtCell32() {
        final BigInteger result = Grains.compute(32);
        assertEquals(new BigInteger("2147483648"), result);
    }

    @Test
    public void countAtCell64() {
        final BigInteger result = Grains.compute(64);
        assertEquals(new BigInteger("9223372036854775808"), result);
    }

    @Test
    public void errorOnNullBoardSize() {
        try {
            Grains.compute(0);
            fail("Grains#compute should have thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("square must be between 1 and 64", e.getMessage());
        }
    }

    @Test
    public void errorOnNegativeBoardSize() {
        try {
            Grains.compute(-1);
            fail("Grains#compute should have thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("square must be between 1 and 64", e.getMessage());
        }
    }

    @Test
    public void errorOnExcessiveBoardSize() {
        try {
            Grains.compute(65);
            fail("Grains#compute should have thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("square must be between 1 and 64", e.getMessage());
        }
    }

    @Test
    public void totalNumberOfGrainsOnABoard() {
        final BigInteger total = Grains.computeTotal();
        assertEquals(new BigInteger("18446744073709551615"), total);
    }

}
