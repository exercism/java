import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RaindropConverterTest {

    private RaindropConverter raindropConverter = new RaindropConverter();

    @Test
    public void soundFor1Is1() {
        assertThat(raindropConverter.convert(1)).isEqualTo("1");
    }

    @Disabled("Remove to run test")
    @Test
    public void soundFor3IsPling() {
        assertThat(raindropConverter.convert(3)).isEqualTo("Pling");
    }

    @Disabled("Remove to run test")
    @Test
    public void soundFor5IsPlang() {
        assertThat(raindropConverter.convert(5)).isEqualTo("Plang");
    }

    @Disabled("Remove to run test")
    @Test
    public void soundFor7IsPlong() {
        assertThat(raindropConverter.convert(7)).isEqualTo("Plong");
    }

    @Disabled("Remove to run test")
    @Test
    public void soundFor6IsPlingAsItHasFactor3() {
        assertThat(raindropConverter.convert(6)).isEqualTo("Pling");
    }

    @Disabled("Remove to run test")
    @Test
    public void noSoundFor2Cubed() {
        assertThat(raindropConverter.convert(8)).isEqualTo("8");
    }

    @Disabled("Remove to run test")
    @Test
    public void soundFor9IsPlingAsItHasFactor3() {
        assertThat(raindropConverter.convert(9)).isEqualTo("Pling");
    }

    @Disabled("Remove to run test")
    @Test
    public void soundFor10IsPlangAsItHasFactor5() {
        assertThat(raindropConverter.convert(10)).isEqualTo("Plang");
    }

    @Disabled("Remove to run test")
    @Test
    public void soundFor14IsPlongAsItHasFactor7() {
        assertThat(raindropConverter.convert(14)).isEqualTo("Plong");
    }

    @Disabled("Remove to run test")
    @Test
    public void soundFor15IsPlingPlangAsItHasFactors3And5() {
        assertThat(raindropConverter.convert(15)).isEqualTo("PlingPlang");
    }

    @Disabled("Remove to run test")
    @Test
    public void soundFor21IsPlingPlongAsItHasFactors3And7() {
        assertThat(raindropConverter.convert(21)).isEqualTo("PlingPlong");
    }

    @Disabled("Remove to run test")
    @Test
    public void soundFor25IsPlangAsItHasFactor5() {
        assertThat(raindropConverter.convert(25)).isEqualTo("Plang");
    }

    @Disabled("Remove to run test")
    @Test
    public void soundFor27IsPlingAsItHasFactor3() {
        assertThat(raindropConverter.convert(27)).isEqualTo("Pling");
    }

    @Disabled("Remove to run test")
    @Test
    public void soundFor35IsPlangPlongAsItHasFactors5And7() {
        assertThat(raindropConverter.convert(35)).isEqualTo("PlangPlong");
    }

    @Disabled("Remove to run test")
    @Test
    public void soundFor49IsPlongAsItHasFactor7() {
        assertThat(raindropConverter.convert(49)).isEqualTo("Plong");
    }

    @Disabled("Remove to run test")
    @Test
    public void noSoundFor52() {
        assertThat(raindropConverter.convert(52)).isEqualTo("52");
    }

    @Disabled("Remove to run test")
    @Test
    public void soundFor105IsPlingPlangPlongAsItHasFactors3And5And7() {
        assertThat(raindropConverter.convert(105)).isEqualTo("PlingPlangPlong");
    }

    @Disabled("Remove to run test")
    @Test
    public void soundFor3125IsPlangAsItHasFactor5() {
        assertThat(raindropConverter.convert(3125)).isEqualTo("Plang");
    }

}
