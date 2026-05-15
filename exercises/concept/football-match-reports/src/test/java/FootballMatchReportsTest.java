import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FootballMatchReportsTest {

    @Test
    @Tag("task:1")
    @DisplayName("The onField method returns the correct description of player with shirt number 1")
    public void testGoal() {
        assertThat(FootballMatchReports.onField(1)).isEqualTo("goalie");
    }

    @Test
    @Tag("task:1")
    @DisplayName("The onField method returns the correct description of player with shirt number 2")
    public void testLeftBack() {
        assertThat(FootballMatchReports.onField(2)).isEqualTo("left back");
    }

    @Test
    @Tag("task:1")
    @DisplayName("The onField method returns the correct description of player with shirt number 5")
    public void testRightBack() {
        assertThat(FootballMatchReports.onField(5)).isEqualTo("right back");
    }

    @Test
    @Tag("task:1")
    @DisplayName("The onField method returns the correct description of players with shirt numbers 3 and 4")
    public void testCenterBack() {
        assertThat(FootballMatchReports.onField(3)).isEqualTo("center back");
        assertThat(FootballMatchReports.onField(4)).isEqualTo("center back");
    }

    @Test
    @Tag("task:1")
    @DisplayName("The onField method returns the correct description of players with shirt numbers 6, 7 and 8")
    public void testMidfielder() {
        assertThat(FootballMatchReports.onField(6)).isEqualTo("midfielder");
        assertThat(FootballMatchReports.onField(7)).isEqualTo("midfielder");
        assertThat(FootballMatchReports.onField(8)).isEqualTo("midfielder");
    }

    @Test
    @Tag("task:1")
    @DisplayName("The onField method returns the correct description of player with shirt number 9")
    public void testLeftWing() {
        assertThat(FootballMatchReports.onField(9)).isEqualTo("left wing");
    }

    @Test
    @Tag("task:1")
    @DisplayName("The onField method returns the correct description of player with shirt number 10")
    public void testStriker() {
        assertThat(FootballMatchReports.onField(10)).isEqualTo("striker");
    }

    @Test
    @Tag("task:1")
    @DisplayName("The onField method returns the correct description of player with shirt number 11")
    public void testRightWing() {
        assertThat(FootballMatchReports.onField(11)).isEqualTo("right wing");
    }

    @Test
    @Tag("task:2")
    @DisplayName("The onField method returns 'invalid' for invalid shirt number")
    public void testException() {
        assertThat(FootballMatchReports.onField(13)).isEqualTo("invalid");
    }

    @Test
    @Tag("task:2")
    @DisplayName("The onField method returns 'invalid' for negative shirt number")
    public void testExceptionNegativeNumber() {
        assertThat(FootballMatchReports.onField(-1)).isEqualTo("invalid");
    }
}
