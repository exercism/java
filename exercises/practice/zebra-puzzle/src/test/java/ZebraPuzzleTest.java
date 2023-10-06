import org.junit.Ignore;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ZebraPuzzleTest {

    @Test
    public void residentWhoDrinksWater() {
        ZebraPuzzle zebraPuzzle = new ZebraPuzzle();
        assertThat(zebraPuzzle.getWaterDrinker()).isEqualTo("Norwegian");
    }

    @Ignore("Remove to run test")
    @Test
    public void residentWhoOwnsZebra() {
        ZebraPuzzle zebraPuzzle = new ZebraPuzzle();
        assertThat(zebraPuzzle.getZebraOwner()).isEqualTo("Japanese");
    }

}
