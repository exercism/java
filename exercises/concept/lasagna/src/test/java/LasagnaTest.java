import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import utils.Lasagna;

import static org.assertj.core.api.Assertions.*;

public class LasagnaTest {

    @Test
    @Tag("task:1")
    @DisplayName("Implemented the expectedMinutesInOven method")
    public void implemented_expected_minutes_in_oven() {
        assertThat(new Lasagna().hasMethod("expectedMinutesInOven"))
                .withFailMessage("Method expectedMinutesInOven must be created")
                .isTrue();
        assertThat(new Lasagna().isMethodPublic("expectedMinutesInOven"))
                .withFailMessage("Method expectedMinutesInOven must be public")
                .isTrue();
        assertThat(new Lasagna().isMethodReturnType(int.class, "expectedMinutesInOven"))
                .withFailMessage("Method expectedMinutesInOven must return an int")
                .isTrue();
    }

    @Test
    @Tag("task:1")
    @DisplayName("The expectedMinutesInOven method returns the correct value")
    public void expected_minutes_in_oven() {
        assertThat(new Lasagna().expectedMinutesInOven()).isEqualTo(40);
    }

    @Test
    @Tag("task:2")
    @DisplayName("Implemented the remainingMinutesInOven method")
    public void implemented_remaining_minutes_in_oven() {
        assertThat(new Lasagna().hasMethod("remainingMinutesInOven", int.class))
                .withFailMessage("Method remainingMinutesInOven must be created")
                .isTrue();
        assertThat(new Lasagna().isMethodPublic("remainingMinutesInOven", int.class))
                .withFailMessage("Method remainingMinutesInOven must be public")
                .isTrue();
        assertThat(new Lasagna().isMethodReturnType(int.class, "remainingMinutesInOven", int.class))
                .withFailMessage("Method remainingMinutesInOven must return an int")
                .isTrue();
    }

    @Test
    @Tag("task:2")
    @DisplayName("The remainingMinutesInOven method calculates and returns the correct value")
    public void remaining_minutes_in_oven() {
        assertThat(new Lasagna().remainingMinutesInOven(25)).isEqualTo(15);
    }

    @Test
    @Tag("task:3")
    @DisplayName("Implemented the preparationTimeInMinutes method")
    public void implemented_preparation_time_in_minutes() {
        assertThat(new Lasagna().hasMethod("preparationTimeInMinutes", int.class))
                .withFailMessage("Method preparationTimeInMinutes must be created")
                .isTrue();
        assertThat(new Lasagna().isMethodPublic("preparationTimeInMinutes", int.class))
                .withFailMessage("Method preparationTimeInMinutes must be public")
                .isTrue();
        assertThat(new Lasagna().isMethodReturnType(int.class, "preparationTimeInMinutes", int.class))
                .withFailMessage("Method preparationTimeInMinutes must return an int")
                .isTrue();
    }

    @Test
    @Tag("task:3")
    @DisplayName("The preparationTimeInMinutes method calculates the correct value for single layer")
    public void preparation_time_in_minutes_for_one_layer() {
        assertThat(new Lasagna().preparationTimeInMinutes(1)).isEqualTo(2);
    }

    @Test
    @Tag("task:3")
    @DisplayName("The preparationTimeInMinutes method calculates the correct value for multiple layers")
    public void preparation_time_in_minutes_for_multiple_layers() {
        assertThat(new Lasagna().preparationTimeInMinutes(4)).isEqualTo(8);
    }

    @Test
    @Tag("task:4")
    @DisplayName("Implemented the totalTimeInMinutes method")
    public void implemented_total_time_in_minutes() {
        assertThat(new Lasagna().hasMethod("totalTimeInMinutes", int.class, int.class))
                .withFailMessage("Method totalTimeInMinutes must be created")
                .isTrue();
        assertThat(new Lasagna().isMethodPublic("totalTimeInMinutes", int.class, int.class))
                .withFailMessage("Method totalTimeInMinutes must be public")
                .isTrue();
        assertThat(new Lasagna().isMethodReturnType(int.class, "totalTimeInMinutes", int.class, int.class))
                .withFailMessage("Method totalTimeInMinutes must return an int")
                .isTrue();
    }

    @Test
    @Tag("task:4")
    @DisplayName("The totalTimeInMinutes method calculates the correct value for single layer")
    public void total_time_in_minutes_for_one_layer() {
        assertThat(new Lasagna().totalTimeInMinutes(1, 30)).isEqualTo(32);
    }

    @Test
    @Tag("task:4")
    @DisplayName("The totalTimeInMinutes method calculates the correct value for multiple layers")
    public void total_time_in_minutes_for_multiple_layers() {
        assertThat(new Lasagna().totalTimeInMinutes(4, 8)).isEqualTo(16);
    }
}
