import org.junit.Test;
import org.junit.Ignore;

import static org.junit.Assert.assertEquals;

public class BinaryTest {

    private Binary binary;

    @Test
    public void testBinary0IsDecimal0() {
        binary = new Binary("0");
        assertEquals(0, binary.getDecimal());
    }

    @Ignore("Remove to run test")
    @Test
    public void testBinary1IsDecimal1() {
        binary = new Binary("1");
        assertEquals(1, binary.getDecimal());
    }

    @Ignore("Remove to run test")
    @Test
    public void testBinary10IsDecimal2() {
        binary = new Binary("10");
        assertEquals(2, binary.getDecimal());
    }

    @Ignore("Remove to run test")
    @Test
    public void testBinary11IsDecimal3() {
        binary = new Binary("11");
        assertEquals(3, binary.getDecimal());
    }

    @Ignore("Remove to run test")
    @Test
    public void testBinary100IsDecimal4() {
        binary = new Binary("100");
        assertEquals(4, binary.getDecimal());
    }

    @Ignore("Remove to run test")
    @Test
    public void testBinary1001IsDecimal9() {
        binary = new Binary("1001");
        assertEquals(9, binary.getDecimal());
    }

    @Ignore("Remove to run test")
    @Test
    public void testBinary11010IsDecimal26() {
        binary = new Binary("11010");
        assertEquals(26, binary.getDecimal());
    }

    @Ignore("Remove to run test")
    @Test
    public void testBinary10001101000IsDecimal1128() {
        binary = new Binary("10001101000");
        assertEquals(1128, binary.getDecimal());
    }

    @Ignore("Remove to run test")
    @Test
    public void testBinaryIgnoresLeadingZeros() {
        binary = new Binary("000011111");
        assertEquals(31, binary.getDecimal());
    }

    @Ignore("Remove to run test")
    @Test
    public void test2NotValidBinaryDigit() {
        binary = new Binary("2");
        assertEquals(0, binary.getDecimal());
    }

    @Ignore("Remove to run test")
    @Test
    public void testNumberContainingNonBinaryDigitInvalid() {
        binary = new Binary("01201");
        assertEquals(0, binary.getDecimal());
    }

    @Ignore("Remove to run test")
    @Test
    public void testNumberWithTrailingNonBinaryCharactersInvalid() {
        binary = new Binary("10nope");
        assertEquals(0, binary.getDecimal());
    }

    @Ignore("Remove to run test")
    @Test
    public void testNumberWithLeadingNonBinaryCharactersInvalid() {
        binary = new Binary("nope10");
        assertEquals(0, binary.getDecimal());
    }

    @Ignore("Remove to run test")
    @Test
    public void testNumberWithInternalNonBinaryCharactersInvalid() {
        binary = new Binary("10nope10");
        assertEquals(0, binary.getDecimal());
    }

    @Ignore("Remove to run test")
    @Test
    public void testNumberAndWordWhitespaceSeparatedInvalid() {
        binary = new Binary("001 nope");
        assertEquals(0, binary.getDecimal());
    }

}
