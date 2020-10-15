import org.junit.Ignore;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class PlayAnalyzerTest {

    @Test
    public void test_goal() {
        assertThat(PlayAnalyzer.onField(1).contentEquals("goalie"));
    }

    @Test
    @Ignore("Remove to run test")
    public void test_left_back() {
        assertThat(PlayAnalyzer.onField(2).contentEquals("left back"));
    }

    @Test
    @Ignore("Remove to run test")
    public void test_right_back() {
        assertThat(PlayAnalyzer.onField(5).contentEquals("right back"));
    }

    @Test
    @Ignore("Remove to run test")
    public void test_center_back() {
        assertThat(PlayAnalyzer.onField(3).contentEquals("center back"));
        assertThat(PlayAnalyzer.onField(4).contentEquals("center back"));
    }

    @Test
    @Ignore("Remove to run test")
    public void test_midfielder() {
        assertThat(PlayAnalyzer.onField(6).contentEquals("midfielder"));
        assertThat(PlayAnalyzer.onField(7).contentEquals("midfielder"));
        assertThat(PlayAnalyzer.onField(8).contentEquals("midfielder"));
    }

    @Test
    @Ignore("Remove to run test")
    public void test_left_wing() {
        assertThat(PlayAnalyzer.onField(9).contentEquals("left wing"));
    }

    @Test
    @Ignore("Remove to run test")
    public void test_striker() {
        assertThat(PlayAnalyzer.onField(10).contentEquals("striker"));
    }

    @Test
    @Ignore("Remove to run test")
    public void test_right_wing() {
        assertThat(PlayAnalyzer.onField(11).contentEquals("right wing"));
    }

    @Test(expected = IllegalArgumentException.class)
    @Ignore("Remove to run test")
    public void test_exception() {
        PlayAnalyzer.onField(13);
    }

    @Test(expected = IllegalArgumentException.class)
    @Ignore("Remove to run test")
    public void test_exception_negative_number() {
        PlayAnalyzer.onField(-1);
    }
}
