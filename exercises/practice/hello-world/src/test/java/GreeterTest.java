import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GreeterTest {

    @Test
    @DisplayName("Say Hi!")
    public void testThatGreeterReturnsTheCorrectGreeting() {
        assertThat(new Greeter().getGreeting()).isEqualTo("Hello, World!");
    }

}
