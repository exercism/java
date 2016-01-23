import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TrinaryTest {
    @Test
    public void testNonTrinaryCharacterIsZero() {
        assertEquals(0, Trinary.toDecimal("-"));
    }

    @Test
    public void testNonTrinaryNumberIsZero() {
        assertEquals(0, Trinary.toDecimal("3"));
    }

    @Test
    public void testTrinaryWithNonTrinaryIsZero() {
        assertEquals(0, Trinary.toDecimal("102-12"));
    }

    @Test
    public void testTrinary() {
        assertEquals(302, Trinary.toDecimal("102012"));
    }
}
