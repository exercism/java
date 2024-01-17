import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;

import static org.assertj.core.api.Assertions.assertThat;

public class ResistorColorTrioTest {
    private ResistorColorTrio resistorColorTrio;

    @BeforeEach
    public void setup() {
        resistorColorTrio = new ResistorColorTrio();
    }

    @Test
    public void testOrangeAndOrangeAndBlack() {
        assertThat(
            resistorColorTrio.label(new String[]{"orange", "orange", "black"})
        ).isEqualTo("33 ohms");
    }
    
    @Disabled("Remove to run test")
    @Test
    public void testBlueAndGreyAndBrown() {
        assertThat(
            resistorColorTrio.label(new String[]{"blue", "grey", "brown"})
        ).isEqualTo("680 ohms");
    }
    
    @Disabled("Remove to run test")
    @Test
    public void testRedAndBlackAndRed() {
        assertThat(
            resistorColorTrio.label(new String[]{"red", "black", "red"})
        ).isEqualTo("2 kiloohms");
    }
    
    @Disabled("Remove to run test")
    @Test
    public void testGreenAndBrownAndOrange() {
        assertThat(
            resistorColorTrio.label(new String[]{"green", "brown", "orange"})
        ).isEqualTo("51 kiloohms");
    }
    
    @Disabled("Remove to run test")
    @Test
    public void testYellowAndVioletAndYellow() {
        assertThat(
            resistorColorTrio.label(new String[]{"yellow", "violet", "yellow"})
        ).isEqualTo("470 kiloohms");
    }
    
    @Disabled("Remove to run test")
    @Test
    public void testBlueAndVioletAndBlue() {
        assertThat(
            resistorColorTrio.label(new String[]{"blue", "violet", "blue"})
        ).isEqualTo("67 megaohms");
    }
    
    @Disabled("Remove to run test")
    @Test
    public void testBlackAndBlackAndBlack() {
        assertThat(
            resistorColorTrio.label(new String[]{"black", "black", "black"})
        ).isEqualTo("0 ohms");
    }

    @Disabled("Remove to run test")
    @Test
    public void testWhiteAndWhiteAndWhite() {
        assertThat(
            resistorColorTrio.label(new String[]{"white", "white", "white"})
        ).isEqualTo("99 gigaohms");
    }
    
    @Disabled("Remove to run test")
    @Test
    public void testFirstTwoColorsMakeAnInvalidOctalNumber() {
        assertThat(
            resistorColorTrio.label(new String[]{"black", "grey", "black"})
        ).isEqualTo("8 ohms");
    }

    @Disabled("Remove to run test")
    @Test
    public void testIgnoreExtraColors() {
        assertThat(
            resistorColorTrio.label(new String[]{"blue", "green", "yellow", "orange"})
        ).isEqualTo("650 kiloohms");
    }
}
