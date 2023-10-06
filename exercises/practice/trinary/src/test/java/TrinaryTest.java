import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.Ignore;

public class TrinaryTest {

    @Test
    public void testNonTrinaryCharacterIsZero() {
        assertEquals(0, Trinary.toDecimal("-"));
    }

    @Ignore
    @Test
    public void testNonTrinaryNumberIsZero() {
        assertEquals(0, Trinary.toDecimal("3"));
    }

    @Ignore
    @Test
    public void testTrinaryWithNonTrinaryIsZero() {
        assertEquals(0, Trinary.toDecimal("102-12"));
    }

    @Ignore
    @Test
    public void testTrinary() {
        assertEquals(302, Trinary.toDecimal("102012"));
    }
}
