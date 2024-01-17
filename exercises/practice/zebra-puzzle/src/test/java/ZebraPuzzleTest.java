import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ZebraPuzzleTest {

    @Test
    public void residentWhoDrinksWater() {
        ZebraPuzzle zebraPuzzle = new ZebraPuzzle();
        assertThat(zebraPuzzle.getWaterDrinker()).isEqualTo("Norwegian");
    }

    @Disabled("Remove to run test")
    @Test
    public void residentWhoOwnsZebra() {
        ZebraPuzzle zebraPuzzle = new ZebraPuzzle();
        assertThat(zebraPuzzle.getZebraOwner()).isEqualTo("Japanese");
    }

}
