import org.junit.Ignore;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OctalTest {

    @Test
    public void testCovertDecimalOneToOctal() {
        Octal octal = new Octal("1");
        assertThat(octal.getDecimal()).isEqualTo(1);
    }

    @Ignore("Remove to run test")
    @Test
    public void testCovertDecimalTenToOctal() {
        Octal octal = new Octal("10");
        assertThat(octal.getDecimal()).isEqualTo(8);
    }

    @Ignore("Remove to run test")
    @Test
    public void testCovertDecimalSeventeenToOctal() {
        Octal octal = new Octal("17");
        assertThat(octal.getDecimal()).isEqualTo(15);
    }

    @Ignore("Remove to run test")
    @Test
    public void testCovertElevenToOctal() {
        Octal octal = new Octal("11");
        assertThat(octal.getDecimal()).isEqualTo(9);
    }

    @Ignore("Remove to run test")
    @Test
    public void testCovertDecimalElevenWithZeroToOctal() {
        Octal octal = new Octal("011");
        assertThat(octal.getDecimal()).isEqualTo(9);
    }

    @Ignore("Remove to run test")
    @Test
    public void testThreeDigitDecimalToOctal() {
        Octal octal = new Octal("130");
        assertThat(octal.getDecimal()).isEqualTo(88);
    }

    @Ignore("Remove to run test")
    @Test
    public void testSmallFourDigitDecimalToOctal() {
        Octal octal = new Octal("2047");
        assertThat(octal.getDecimal()).isEqualTo(1063);
    }

    @Ignore("Remove to run test")
    @Test
    public void testLargeFourDigitDecimalToOctal() {
        Octal octal = new Octal("7777");
        assertThat(octal.getDecimal()).isEqualTo(4095);
    }

    @Ignore("Remove to run test")
    @Test
    public void testSevenDigitDecimalToOctal() {
        Octal octal = new Octal("1234567");
        assertThat(octal.getDecimal()).isEqualTo(342391);
    }

    @Ignore("Remove to run test")
    @Test
    public void testInvalidStringFirst() {
        Octal octal = new Octal("carrot");
        assertThat(octal.getDecimal()).isEqualTo(0);
    }

    @Ignore("Remove to run test")
    @Test
    public void testInvalidStringSecond() {
        Octal octal = new Octal("abc1z");
        assertThat(octal.getDecimal()).isEqualTo(0);
    }

    @Ignore("Remove to run test")
    @Test
    public void testInvalidDecimalEight() {
        Octal octal = new Octal("8");
        assertThat(octal.getDecimal()).isEqualTo(0);
    }

    @Ignore("Remove to run test")
    @Test
    public void testInvalidNumberNine() {
        Octal octal = new Octal("9");
        assertThat(octal.getDecimal()).isEqualTo(0);
    }

}
