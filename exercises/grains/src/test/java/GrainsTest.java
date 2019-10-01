import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class GrainsTest {

    @Test
    public void countAtCell1() {
        final BigInteger result = Grains.compute(1);
        assertEquals(result, new BigInteger("1"));
    }

    @Test
    public void countAtCell2() {
        final BigInteger result = Grains.compute(2);
        assertEquals(result, new BigInteger("2"));
    }

    @Test
    public void countAtCell3() {
        final BigInteger result = Grains.compute(3);
        assertEquals(result, new BigInteger("4"));
    }

    @Test
    public void countAtCell4() {
        final BigInteger result = Grains.compute(4);
        assertEquals(result, new BigInteger("8"));
    }

    @Test
    public void countAtCell16() {
        final BigInteger result = Grains.compute(16);
        assertEquals(result, new BigInteger("32768"));
    }

    @Test
    public void countAtCell32() {
        final BigInteger result = Grains.compute(32);
        assertEquals(result, new BigInteger("2147483648"));
    }

    @Test
    public void countAtCell64() {
        final BigInteger result = Grains.compute(64);
        assertEquals(result, new BigInteger("9223372036854775808"));
    }

    @Test
    public void errorOnNullBoardSize() {
        try {
            Grains.compute(0);
            fail("Grains#compute should have thrown");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(), "square must be between 1 and 64");
        }
    }

    @Test
    public void errorOnNegativeBoardSize() {
        try {
            Grains.compute(-1);
            fail("Grains#compute should have thrown");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(), "square must be between 1 and 64");
        }
    }

    @Test
    public void errorOnExcessiveBoardSize() {
        try {
            Grains.compute(65);
            fail("Grains#compute should have thrown");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(), "square must be between 1 and 64");
        }
    }

    @Test
    public void totalNumberOfGrainsOnABoard() {
        final BigInteger total = Grains.computeTotal();
        assertEquals(total, new BigInteger("18446744073709551615"));
    }

}
