import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DartsTest {

    Darts darts = new Darts();
    @Test
    @DisplayName("Missed target")
    public void missedTarget() {
        assertThat(darts.score(-9, 9)).isEqualTo(0);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("On the outer circle")
    public void onTheOuterCircle() {
        assertThat(darts.score(0, 10)).isEqualTo(1);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("On the middle circle")
    public void onTheMiddleCircle() {
        assertThat(darts.score(-5, 0)).isEqualTo(5);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("On the inner circle")
    public void onTheInnerCircle() {
        assertThat(darts.score(0, -1)).isEqualTo(10);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Exactly on center")
    public void exactlyOnCentre() {
        assertThat(darts.score(0, 0)).isEqualTo(10);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Near the center")
    public void nearTheCentre() {
        assertThat(darts.score(-0.1, -0.1)).isEqualTo(10);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Just within the inner circle")
    public void justWithinTheInnerCircle() {
        assertThat(darts.score(0.7, 0.7)).isEqualTo(10);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Just outside the inner circle")
    public void justOutsideTheInnerCircle() {
        assertThat(darts.score(0.8, -0.8)).isEqualTo(5);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Just within the middle circle")
    public void justWithinTheMiddleCircle() {
        assertThat(darts.score(-3.5, 3.5)).isEqualTo(5);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Just outside the middle circle")
    public void justOutsideTheMiddleCircle() {
        assertThat(darts.score(-3.6, -3.6)).isEqualTo(1);
    }


    @Disabled("Remove to run test")
    @Test
    @DisplayName("Just within the outer circle")
    public void justWithinTheOuterCircle() {
        assertThat(darts.score(-7.0, 7.0)).isEqualTo(1);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Just outside the outer circle")
    public void justOutsideTheOuterCircle() {
        assertThat(darts.score(7.1, -7.1)).isEqualTo(0);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("Asymmetric position between the inner and middle circles")
    public void asymmetricPositionBetweenTheInnerAndMiddleCircles() {
        assertThat(darts.score(0.5, -4)).isEqualTo(5);
    }

}
