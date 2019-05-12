import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.assertEquals;

public class HexadecimalTest {


    @Test
    public void testOne() {
        int expected = 1;
        assertEquals(expected, Hexadecimal.toDecimal("1"));
    }

    @Ignore
    @Test
    public void testC() {
        int expected = 12;
        assertEquals(expected, Hexadecimal.toDecimal("c"));
    }

    @Ignore
    @Test
    public void test10() {
        int expected = 16;
        assertEquals(expected, Hexadecimal.toDecimal("10"));
    }

    @Ignore
    @Test
    public void testAf() {
        int expected = 175;
        assertEquals(expected, Hexadecimal.toDecimal("af"));
    }

    @Ignore
    @Test
    public void test100() {
        int expected = 256;
        assertEquals(expected, Hexadecimal.toDecimal("100"));
    }

    @Ignore
    @Test
    public void test19ace() {
        int expected = 105166;
        assertEquals(expected, Hexadecimal.toDecimal("19ace"));
    }

    @Ignore
    @Test
    public void testInvalid() {
        int expected = 0;
        assertEquals(expected, Hexadecimal.toDecimal("carrot"));
    }

    @Ignore
    @Test
    public void testBlack() {
        int expected = 0;
        assertEquals(expected, Hexadecimal.toDecimal("000000"));
    }

    @Ignore
    @Test
    public void testWhite() {
        int expected = 16777215;
        assertEquals(expected, Hexadecimal.toDecimal("ffffff"));
    }

    @Ignore
    @Test
    public void testYellow() {
        int expected = 16776960;
        assertEquals(expected, Hexadecimal.toDecimal("ffff00"));
    }
}
