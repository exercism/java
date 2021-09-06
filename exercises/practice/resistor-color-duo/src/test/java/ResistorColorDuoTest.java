import org.junit.Before;
import org.junit.Test;
import org.junit.Ignore;

import static org.assertj.core.api.Assertions.assertThat;

public class ResistorColorDuoTest {
    private ResistorColorDuo resistorColorDuo;

    @Before
    public void setup() {
        resistorColorDuo = new ResistorColorDuo();
    }

    @Test
    public void testBrownAndBlack() {
        assertThat(
                resistorColorDuo.value(new String[]{"brown", "black"})
        ).isEqualTo(10);
    }

    @Ignore("Remove to run test")
    @Test
    public void testBlueAndGrey() {
        assertThat(
                resistorColorDuo.value(new String[]{ "blue", "grey" })
        ).isEqualTo(68);
    }

    @Ignore("Remove to run test")
    @Test
    public void testYellowAndViolet() {
        assertThat(resistorColorDuo.value(
                new String[]{ "yellow", "violet" })
        ).isEqualTo(47);
    }

    @Ignore("Remove to run test")
    @Test
    public void testOrangeAndOrange() {
        assertThat(
                resistorColorDuo.value(new String[]{ "orange", "orange" })
        ).isEqualTo(33);
    }

    @Ignore("Remove to run test")
    @Test
    public void testIgnoreAdditionalColors() {
        assertThat(
                resistorColorDuo.value(new String[]{ "green", "brown", "orange" })
        ).isEqualTo(51);
    }
}
