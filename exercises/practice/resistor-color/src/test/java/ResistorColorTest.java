import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;
import static org.assertj.core.api.Assertions.assertThat;

public class ResistorColorTest {

    private ResistorColor resistorColor;

    @BeforeEach
    public void setup() {
        resistorColor = new ResistorColor();
    }

    @Test
    @DisplayName("Black")
    public void testBlackColorCode() {
        assertThat(resistorColor.colorCode("black")).isEqualTo(0);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("white")
    public void testWhiteColorCode() {
        assertThat(resistorColor.colorCode("white")).isEqualTo(9);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Orange")
    public void testOrangeColorCode() {
        assertThat(resistorColor.colorCode("orange")).isEqualTo(3);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Colors")
    public void testColors() {
        assertThat(resistorColor.colors()).containsExactly(
                "black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"
        );
    }
}
