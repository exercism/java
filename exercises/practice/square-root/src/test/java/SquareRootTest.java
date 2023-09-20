import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SquareRootTest {
    @Test
    @DisplayName("Square root of 1")
    public void squareRootOf1() {
        assertThat(new SquareRoot().squareRoot(1))
                .isEqualTo(1);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Square root of 4")
    public void squareRootOf4() {
        assertThat(new SquareRoot().squareRoot(4))
                .isEqualTo(2);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Square root of 25")
    public void squareRootOf25() {
        assertThat(new SquareRoot().squareRoot(25))
                .isEqualTo(5);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Square root of 81")
    public void squareRootOf81() {
        assertThat(new SquareRoot().squareRoot(81))
                .isEqualTo(9);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Square root of 196")
    public void squareRootOf196() {
        assertThat(new SquareRoot().squareRoot(196))
                .isEqualTo(14);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Square root of 65025")
    public void squareRootOf65025() {
        assertThat(new SquareRoot().squareRoot(65025))
                .isEqualTo(255);
    }
}
