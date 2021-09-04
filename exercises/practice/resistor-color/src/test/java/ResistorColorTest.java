import org.junit.Before;
import org.junit.Test;
import org.junit.Ignore;
import static org.assertj.core.api.Assertions.assertThat;

public class ResistorColorTest {

    private ResistorColor resistorColor;

    @Before
    public void setup() {
        resistorColor = new ResistorColor();
    }

    @Test
    public void testBlackColorCode() {
        assertThat(resistorColor.colorCode("black")).isEqualTo(0);
    }

    @Ignore("Remove to run test")
    @Test
    public void testWhiteColorCode() {
        assertThat(resistorColor.colorCode("white")).isEqualTo(9);
    }

    @Ignore("Remove to run test")
    @Test
    public void testOrangeColorCode() {
        assertThat(resistorColor.colorCode("orange")).isEqualTo(3);
    }

    @Ignore("Remove to run test")
    @Test
    public void testColors() {
        assertThat(resistorColor.colors()).containsExactly(
                "black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"
        );
    }
}
