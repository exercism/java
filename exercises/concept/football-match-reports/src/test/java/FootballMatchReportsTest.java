import org.junit.Ignore;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class FootballMatchReportsTest {

    @Test
    public void test_goal() {
        assertThat(FootballMatchReports.onField(1).contentEquals("goalie"));
    }

    @Test
    @Ignore("Remove to run test")
    public void test_left_back() {
        assertThat(FootballMatchReports.onField(2).contentEquals("left back"));
    }

    @Test
    @Ignore("Remove to run test")
    public void test_right_back() {
        assertThat(FootballMatchReports.onField(5).contentEquals("right back"));
    }

    @Test
    @Ignore("Remove to run test")
    public void test_center_back() {
        assertThat(FootballMatchReports.onField(3).contentEquals("center back"));
        assertThat(FootballMatchReports.onField(4).contentEquals("center back"));
    }

    @Test
    @Ignore("Remove to run test")
    public void test_midfielder() {
        assertThat(FootballMatchReports.onField(6).contentEquals("midfielder"));
        assertThat(FootballMatchReports.onField(7).contentEquals("midfielder"));
        assertThat(FootballMatchReports.onField(8).contentEquals("midfielder"));
    }

    @Test
    @Ignore("Remove to run test")
    public void test_left_wing() {
        assertThat(FootballMatchReports.onField(9).contentEquals("left wing"));
    }

    @Test
    @Ignore("Remove to run test")
    public void test_striker() {
        assertThat(FootballMatchReports.onField(10).contentEquals("striker"));
    }

    @Test
    @Ignore("Remove to run test")
    public void test_right_wing() {
        assertThat(FootballMatchReports.onField(11).contentEquals("right wing"));
    }

    @Test(expected = IllegalArgumentException.class)
    @Ignore("Remove to run test")
    public void test_exception() {
        FootballMatchReports.onField(13);
    }

    @Test(expected = IllegalArgumentException.class)
    @Ignore("Remove to run test")
    public void test_exception_negative_number() {
        FootballMatchReports.onField(-1);
    }
}
