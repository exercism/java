import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class FootballMatchReportsTest {

    @Test
    @Tag("task:1")
    @DisplayName("The onField method returns the correct description of player with shirt number 1")
    public void test_goal() {
        assertThat(FootballMatchReports.onField(1)).isEqualTo("goalie");
    }

    @Test
    @Tag("task:1")
    @DisplayName("The onField method returns the correct description of player with shirt number 2")
    public void test_left_back() {
        assertThat(FootballMatchReports.onField(2)).isEqualTo("left back");
    }

    @Test
    @Tag("task:1")
    @DisplayName("The onField method returns the correct description of player with shirt number 5")
    public void test_right_back() {
        assertThat(FootballMatchReports.onField(5)).isEqualTo("right back");
    }

    @Test
    @Tag("task:1")
    @DisplayName("The onField method returns the correct description of players with shirt numbers 3 and 4")
    public void test_center_back() {
        assertThat(FootballMatchReports.onField(3)).isEqualTo("center back");
        assertThat(FootballMatchReports.onField(4)).isEqualTo("center back");
    }

    @Test
    @Tag("task:1")
    @DisplayName("The onField method returns the correct description of players with shirt numbers 6, 7 and 8")
    public void test_midfielder() {
        assertThat(FootballMatchReports.onField(6)).isEqualTo("midfielder");
        assertThat(FootballMatchReports.onField(7)).isEqualTo("midfielder");
        assertThat(FootballMatchReports.onField(8)).isEqualTo("midfielder");
    }

    @Test
    @Tag("task:1")
    @DisplayName("The onField method returns the correct description of player with shirt number 9")
    public void test_left_wing() {
        assertThat(FootballMatchReports.onField(9)).isEqualTo("left wing");
    }

    @Test
    @Tag("task:1")
    @DisplayName("The onField method returns the correct description of player with shirt number 10")
    public void test_striker() {
        assertThat(FootballMatchReports.onField(10)).isEqualTo("striker");
    }

    @Test
    @Tag("task:1")
    @DisplayName("The onField method returns the correct description of player with shirt number 11")
    public void test_right_wing() {
        assertThat(FootballMatchReports.onField(11)).isEqualTo("right wing");
    }

    @Test
    @Tag("task:2")
    @DisplayName("The onField method throws IllegalArgumentException for unknown shirt number")
    public void test_exception() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> FootballMatchReports.onField(13));
    }

    @Test
    @Tag("task:2")
    @DisplayName("The onField method throws IllegalArgumentException for negative shirt number")
    public void test_exception_negative_number() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> FootballMatchReports.onField(-1));
    }
}
