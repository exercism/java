import org.junit.Before;
import org.junit.Test;
import org.junit.Ignore;


import static org.assertj.core.api.Assertions.*;

public class BirdWatcherTest {

    private static final int DAY1 = 0;
    private static final int DAY2 = 2;
    private static final int DAY3 = 5;
    private static final int DAY4 = 3;
    private static final int DAY5 = 7;
    private static final int DAY6 = 8;
    private static final int TODAY = 4;

    private BirdWatcher birdWatcher;
    private int lastWeek[] = {DAY1, DAY2, DAY3, DAY4, DAY5, DAY6, TODAY};

    @Before
    public void setUp() {
        birdWatcher = new BirdWatcher(lastWeek);
    }

    @Test
    public void itTestGetLastWeek() {
        assertThat(birdWatcher.getLastWeek())
            .containsExactly(DAY1, DAY2, DAY3, DAY4, DAY5, DAY6, TODAY);
    }

    @Test
    @Ignore("Remove to run test")
    public void itTestGetToday() {
        assertThat(birdWatcher.getToday()).isEqualTo(TODAY);
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
        birdWatcher.incrementTodaysCount();
        assertThat(birdWatcher.getToday()).isEqualTo(TODAY + 1);
    }

    @Test
    @Ignore("Remove to run test")
    public void itHasDayWithoutBirds() {
        assertThat(birdWatcher.hasDayWithoutBirds()).isTrue();
    }

    @Test
    @Ignore("Remove to run test")
    public void itShouldNotHaveDaysWithoutBirds() {
        birdWatcher = new BirdWatcher(new int[]{1, 2, 5, 3, 7, 8, 4});
        assertThat(birdWatcher.hasDayWithoutBirds()).isFalse();
    }


    @Test
    @Ignore("Remove to run test")
    public void itTestGetCountForFirstDays() {
        assertThat(birdWatcher.getCountForFirstDays(4)).isEqualTo(DAY1 + DAY2 + DAY3 + DAY4);
    }

    @Test
    @Ignore("Remove to run test")
    public void itTestGetCountForMoreDaysThanTheArraySize() {
        assertThat(birdWatcher.getCountForFirstDays(10))
            .isEqualTo(DAY1 + DAY2 + DAY3 + DAY4 + DAY5 + DAY6 + TODAY);
    }

    @Test
    @Ignore("Remove to run test")
    public void itTestGetCountForBusyDays() {
        // DAY3, DAY5 and DAY6 are all >= 5 birds
        assertThat(birdWatcher.getBusyDays()).isEqualTo(3);
    }

    @Test
    @Ignore("Remove to run test")
    public void itShouldNotHaveBusyDays() {
        birdWatcher = new BirdWatcher(new int[]{1, 2, 3, 3, 2, 1, 4});
        assertThat(birdWatcher.getBusyDays()).isEqualTo(0);
    }
}
