import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThrows;

public class FootballMatchReportsTest {

    @Test
    public void test_goal() {
        assertThat(FootballMatchReports.onField(1)).isEqualTo("goalie");
    }

    @Test
    public void test_left_back() {
        assertThat(FootballMatchReports.onField(2)).isEqualTo("left back");
    }

    @Test
    public void test_right_back() {
        assertThat(FootballMatchReports.onField(5)).isEqualTo("right back");
    }

    @Test
    public void test_center_back() {
        assertThat(FootballMatchReports.onField(3)).isEqualTo("center back");
        assertThat(FootballMatchReports.onField(4)).isEqualTo("center back");
    }

    @Test
    public void test_midfielder() {
        assertThat(FootballMatchReports.onField(6)).isEqualTo("midfielder");
        assertThat(FootballMatchReports.onField(7)).isEqualTo("midfielder");
        assertThat(FootballMatchReports.onField(8)).isEqualTo("midfielder");
    }

    @Test
    public void test_left_wing() {
        assertThat(FootballMatchReports.onField(9)).isEqualTo("left wing");
    }

    @Test
    public void test_striker() {
        assertThat(FootballMatchReports.onField(10)).isEqualTo("striker");
    }

    @Test
    public void test_right_wing() {
        assertThat(FootballMatchReports.onField(11)).isEqualTo("right wing");
    }

    @Test
    public void test_exception() {
        assertThrows(
            IllegalArgumentException.class,
            () -> FootballMatchReports.onField(13));
    }

    @Test
    public void test_exception_negative_number() {
        assertThrows(
            IllegalArgumentException.class,
            () -> FootballMatchReports.onField(-1));
    }
}
