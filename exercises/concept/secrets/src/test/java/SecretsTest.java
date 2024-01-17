import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SecretsTest {

    @Test
    @Tag("task:1")
    @DisplayName("shift 8 back 2 places")
    public void shift8Back2Places() {
        assertThat(Secrets.shiftBack(8, 2)).isEqualTo(2);
    }


    @Test
    @Tag("task:1")
    @DisplayName("shift -2_144_333_657 back 3 places")
    public void  shiftNegativeNumberBack3Places() {
        assertThat(Secrets.shiftBack(-2_144_333_657, 3)).isEqualTo(268_829_204);
    }

    @Test
    @Tag("task:2")
    @DisplayName("set bits in 5")
    public void setBitsIn5() {
        assertThat(Secrets.setBits(5, 3)).isEqualTo(7);
    }

    @Test
    @Tag("task:2")
    @DisplayName("set bits in 5_652")
    public void setBitsIn5652() {
        assertThat(Secrets.setBits(5_652, 26_150)).isEqualTo(30_262);
    }

    @Test
    @Tag("task:3")
    @DisplayName("flip bits in 5")
    public void flipBitsIn5() {
        assertThat(Secrets.flipBits(5, 11)).isEqualTo(14);
    }

    @Test
    @Tag("task:3")
    @DisplayName("flip bits in 38_460")
    public void flipBitsIn38460() {
        assertThat(Secrets.flipBits(38_460, 15_471)).isEqualTo(43_603);
    }

    @Test
    @Tag("task:4")
    @DisplayName("clear bits from 5")
    public void clearBitsFrom5() {
        assertThat(Secrets.clearBits(5, 11)).isEqualTo(4);
    }

    @Test
    @Tag("task:4")
    @DisplayName("clear bits from 90")
    public void clearBitsFrom90() {
        assertThat(Secrets.clearBits(90, 240)).isEqualTo(10);
    }
}
