import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ZebraPuzzleTest {

    @Test
    @DisplayName("resident who drinks water")
    public void residentWhoDrinksWater() {
        ZebraPuzzle zebraPuzzle = new ZebraPuzzle();
        assertThat(zebraPuzzle.getWaterDrinker()).isEqualTo("Norwegian");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("resident who owns zebra")
    public void residentWhoOwnsZebra() {
        ZebraPuzzle zebraPuzzle = new ZebraPuzzle();
        assertThat(zebraPuzzle.getZebraOwner()).isEqualTo("Japanese");
    }

}
