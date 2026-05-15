import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RaindropConverterTest {

    private RaindropConverter raindropConverter = new RaindropConverter();

    @Test
    @DisplayName("the sound for 1 is 1")
    public void soundFor1Is1() {
        assertThat(raindropConverter.convert(1)).isEqualTo("1");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("the sound for 3 is Pling")
    public void soundFor3IsPling() {
        assertThat(raindropConverter.convert(3)).isEqualTo("Pling");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("the sound for 5 is Plang")
    public void soundFor5IsPlang() {
        assertThat(raindropConverter.convert(5)).isEqualTo("Plang");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("the sound for 7 is Plong")
    public void soundFor7IsPlong() {
        assertThat(raindropConverter.convert(7)).isEqualTo("Plong");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("the sound for 6 is Pling as it has a factor 3")
    public void soundFor6IsPlingAsItHasFactor3() {
        assertThat(raindropConverter.convert(6)).isEqualTo("Pling");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("2 to the power 3 does not make a raindrop sound as 3 is the exponent not the base")
    public void noSoundFor2Cubed() {
        assertThat(raindropConverter.convert(8)).isEqualTo("8");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("the sound for 9 is Pling as it has a factor 3")
    public void soundFor9IsPlingAsItHasFactor3() {
        assertThat(raindropConverter.convert(9)).isEqualTo("Pling");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("the sound for 10 is Plang as it has a factor 5")
    public void soundFor10IsPlangAsItHasFactor5() {
        assertThat(raindropConverter.convert(10)).isEqualTo("Plang");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("the sound for 14 is Plong as it has a factor of 7")
    public void soundFor14IsPlongAsItHasFactor7() {
        assertThat(raindropConverter.convert(14)).isEqualTo("Plong");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("the sound for 15 is PlingPlang as it has factors 3 and 5")
    public void soundFor15IsPlingPlangAsItHasFactors3And5() {
        assertThat(raindropConverter.convert(15)).isEqualTo("PlingPlang");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("the sound for 21 is PlingPlong as it has factors 3 and 7")
    public void soundFor21IsPlingPlongAsItHasFactors3And7() {
        assertThat(raindropConverter.convert(21)).isEqualTo("PlingPlong");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("the sound for 25 is Plang as it has a factor 5")
    public void soundFor25IsPlangAsItHasFactor5() {
        assertThat(raindropConverter.convert(25)).isEqualTo("Plang");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("the sound for 27 is Pling as it has a factor 3")
    public void soundFor27IsPlingAsItHasFactor3() {
        assertThat(raindropConverter.convert(27)).isEqualTo("Pling");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("the sound for 35 is PlangPlong as it has factors 5 and 7")
    public void soundFor35IsPlangPlongAsItHasFactors5And7() {
        assertThat(raindropConverter.convert(35)).isEqualTo("PlangPlong");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("the sound for 49 is Plong as it has a factor 7")
    public void soundFor49IsPlongAsItHasFactor7() {
        assertThat(raindropConverter.convert(49)).isEqualTo("Plong");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("the sound for 52 is 52")
    public void noSoundFor52() {
        assertThat(raindropConverter.convert(52)).isEqualTo("52");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("the sound for 105 is PlingPlangPlong as it has factors 3, 5 and 7")
    public void soundFor105IsPlingPlangPlongAsItHasFactors3And5And7() {
        assertThat(raindropConverter.convert(105)).isEqualTo("PlingPlangPlong");
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("the sound for 3125 is Plang as it has a factor 5")
    public void soundFor3125IsPlangAsItHasFactor5() {
        assertThat(raindropConverter.convert(3125)).isEqualTo("Plang");
    }

}
