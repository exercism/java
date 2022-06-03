import org.junit.Test;
import org.junit.Ignore;

import static org.assertj.core.api.Assertions.assertThat;

public class BinaryTest {

    private Binary binary;

    @Test
    public void testBinary0IsDecimal0() {
        binary = new Binary("0");
        assertThat(binary.getDecimal()).isEqualTo(0);
    }

    @Ignore("Remove to run test")
    @Test
    public void testBinary1IsDecimal1() {
        binary = new Binary("1");
        assertThat(binary.getDecimal()).isEqualTo(1);
    }

    @Ignore("Remove to run test")
    @Test
    public void testBinary10IsDecimal2() {
        binary = new Binary("10");
        assertThat(binary.getDecimal()).isEqualTo(2);
    }

    @Ignore("Remove to run test")
    @Test
    public void testBinary11IsDecimal3() {
        binary = new Binary("11");
        assertThat(binary.getDecimal()).isEqualTo(3);
    }

    @Ignore("Remove to run test")
    @Test
    public void testBinary100IsDecimal4() {
        binary = new Binary("100");
        assertThat(binary.getDecimal()).isEqualTo(4);
    }

    @Ignore("Remove to run test")
    @Test
    public void testBinary1001IsDecimal9() {
        binary = new Binary("1001");
        assertThat(binary.getDecimal()).isEqualTo(9);
    }

    @Ignore("Remove to run test")
    @Test
    public void testBinary11010IsDecimal26() {
        binary = new Binary("11010");
        assertThat(binary.getDecimal()).isEqualTo(26);
    }

    @Ignore("Remove to run test")
    @Test
    public void testBinary10001101000IsDecimal1128() {
        binary = new Binary("10001101000");
        assertThat(binary.getDecimal()).isEqualTo(1128);
    }

    @Ignore("Remove to run test")
    @Test
    public void testBinaryIgnoresLeadingZeros() {
        binary = new Binary("000011111");
        assertThat(binary.getDecimal()).isEqualTo(31);
    }

    @Ignore("Remove to run test")
    @Test
    public void test2NotValidBinaryDigit() {
        binary = new Binary("2");
        assertThat(binary.getDecimal()).isEqualTo(0);
    }

    @Ignore("Remove to run test")
    @Test
    public void testNumberContainingNonBinaryDigitInvalid() {
        binary = new Binary("01201");
        assertThat(binary.getDecimal()).isEqualTo(0);
    }

    @Ignore("Remove to run test")
    @Test
    public void testNumberWithTrailingNonBinaryCharactersInvalid() {
        binary = new Binary("10nope");
        assertThat(binary.getDecimal()).isEqualTo(0);
    }

    @Ignore("Remove to run test")
    @Test
    public void testNumberWithLeadingNonBinaryCharactersInvalid() {
        binary = new Binary("nope10");
        assertThat(binary.getDecimal()).isEqualTo(0);
    }

    @Ignore("Remove to run test")
    @Test
    public void testNumberWithInternalNonBinaryCharactersInvalid() {
        binary = new Binary("10nope10");
        assertThat(binary.getDecimal()).isEqualTo(0);
    }

    @Ignore("Remove to run test")
    @Test
    public void testNumberAndWordWhitespaceSeparatedInvalid() {
        binary = new Binary("001 nope");
        assertThat(binary.getDecimal()).isEqualTo(0);
    }

}
