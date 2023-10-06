import org.junit.Ignore;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TrinaryTest {

    @Test
    public void testNonTrinaryCharacterIsZero() {
        assertThat(Trinary.toDecimal("-")).isEqualTo(0);
    }

    @Ignore
    @Test
    public void testNonTrinaryNumberIsZero() {
        assertThat(Trinary.toDecimal("3")).isEqualTo(0);
    }

    @Ignore
    @Test
    public void testTrinaryWithNonTrinaryIsZero() {
        assertThat(Trinary.toDecimal("102-12")).isEqualTo(0);
    }

    @Ignore
    @Test
    public void testTrinary() {
        assertThat(Trinary.toDecimal("102012")).isEqualTo(302);
    }
}
