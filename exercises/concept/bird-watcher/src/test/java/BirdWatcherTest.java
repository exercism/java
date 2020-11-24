import org.junit.Before;
import org.junit.Test;
import org.junit.Ignore;


import static org.assertj.core.api.Assertions.*;

public class BirdWatcherTest {

    private BirdWatcher birdWatcher;
    private int lastWeek[] = {0, 2, 5, 3, 7, 8, 4};

    @Before
    public void setUp() {
        birdWatcher = new BirdWatcher(lastWeek);
    }

    @Test
    public void itTestGetLastWeek() {
        assertThat(birdWatcher.getLastWeek().equals(lastWeek)).isTrue();
    }

    @Test
    @Ignore("Remove to run test")
    public void itTestGetToday() {
        assertThat(birdWatcher.getToday()).isEqualTo(lastWeek[lastWeek.length - 1]);
    }

    @Test
    @Ignore("Remove to run test")
    public void itShouldReturnZeroIfBirdWatcherLastWeekIsEmpty() {
        int[] lastWeekEmpty = new int[0];
        birdWatcher = new BirdWatcher(lastWeekEmpty);
        assertThat(birdWatcher.getToday()).isEqualTo(0);
    }

    @Test
    @Ignore("Remove to run test")
    public void itIncrementTodaysCount() {
        int currentTodayCount = birdWatcher.getToday();
        birdWatcher.incrementTodaysCount();
        assertThat(birdWatcher.getToday()).isEqualTo(currentTodayCount + 1);
    }

    @Test
    @Ignore("Remove to run test")
    public void itHasDayWithoutBirds() {
        assertThat(birdWatcher.hasDayWithoutBirds()).isTrue();
    }

    @Test
    @Ignore("Remove to run test")
    @Ignore
    public void itShouldNotHaveDaysWithoutBirds() {
        birdWatcher = new BirdWatcher(new int[]{1, 2, 5, 3, 7, 8, 4});
        assertThat(birdWatcher.hasDayWithoutBirds()).isFalse();
    }


    @Test
    @Ignore("Remove to run test")
    public void itTestGetCountForFirstDays() {
        assertThat(birdWatcher.getCountForFirstDays(4)).isEqualTo(10);
    }

    @Test
    @Ignore("Remove to run test")
    @Ignore
    public void itTestGetCountForMoreDaysThanTheArraySize() {
        assertThat(birdWatcher.getCountForFirstDays(10)).isEqualTo(29);
    }

    @Test
    @Ignore("Remove to run test")
    public void itTestGetCountForBusyDays() {
        assertThat(birdWatcher.getBusyDays()).isEqualTo(3);
    }

    @Test
    @Ignore("Remove to run test")
    @Ignore
    public void itShouldNotHaveBusyDays() {
        birdWatcher = new BirdWatcher(new int[]{1, 2, 3, 3, 2, 1, 4});
        assertThat(birdWatcher.getBusyDays()).isEqualTo(0);
    }
}
