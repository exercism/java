import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TwoferTest {

    private Twofer twofer;

    @BeforeEach
    public void setup() {
        twofer = new Twofer();
    }

    @Test
    public void noNameGiven() {
        assertThat(twofer.twofer(null))
                .isEqualTo("One for you, one for me.");
    }

    @Disabled("Remove to run test")
    @Test
    public void aNameGiven() {
        assertThat(twofer.twofer("Alice"))
                .isEqualTo("One for Alice, one for me.");
    }

    @Disabled("Remove to run test")
    @Test
    public void anotherNameGiven() {
        assertThat(twofer.twofer("Bob"))
                .isEqualTo("One for Bob, one for me.");
    }

}
