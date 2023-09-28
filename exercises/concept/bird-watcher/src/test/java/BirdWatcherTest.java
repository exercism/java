import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

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

    @BeforeEach
    public void setUp() {
        birdWatcher = new BirdWatcher(lastWeek);
    }

    @Test
    @Tag("task:1")
    @DisplayName("The getLastWeek method correctly returns last week's counts")
    public void itTestGetLastWeek() {
        assertThat(birdWatcher.getLastWeek())
            .containsExactly(DAY1, DAY2, DAY3, DAY4, DAY5, DAY6, TODAY);
    }

    @Test
    @Tag("task:2")
    @DisplayName("The getToday method correctly returns today's counts")
    public void itTestGetToday() {
        assertThat(birdWatcher.getToday()).isEqualTo(TODAY);
    }

    @Test
    @Tag("task:3")
    @DisplayName("The incrementTodaysCount method correctly increments today's counts")
    public void itIncrementTodaysCount() {
        birdWatcher.incrementTodaysCount();
        assertThat(birdWatcher.getToday()).isEqualTo(TODAY + 1);
    }

    @Test
    @Tag("task:4")
    @DisplayName("The hasDayWithoutBirds method returns true when day had no visits")
    public void itHasDayWithoutBirds() {
        assertThat(birdWatcher.hasDayWithoutBirds()).isTrue();
    }

    @Test
    @Tag("task:4")
    @DisplayName("The hasDayWithoutBirds method returns false when no day had zero visits")
    public void itShouldNotHaveDaysWithoutBirds() {
        birdWatcher = new BirdWatcher(new int[]{1, 2, 5, 3, 7, 8, 4});
        assertThat(birdWatcher.hasDayWithoutBirds()).isFalse();
    }


    @Test
    @Tag("task:5")
    @DisplayName("The getCountForFirstDays method returns correct visits' count for given number of days")
    public void itTestGetCountForFirstDays() {
        assertThat(birdWatcher.getCountForFirstDays(4)).isEqualTo(DAY1 + DAY2 + DAY3 + DAY4);
    }

    @Test
    @Tag("task:5")
    @DisplayName("The getCountForFirstDays method returns overall count when number of days is higher than array size")
    public void itTestGetCountForMoreDaysThanTheArraySize() {
        assertThat(birdWatcher.getCountForFirstDays(10))
            .isEqualTo(DAY1 + DAY2 + DAY3 + DAY4 + DAY5 + DAY6 + TODAY);
    }

    @Test
    @Tag("task:6")
    @DisplayName("The getBusyDays method returns the correct count of busy days")
    public void itTestGetCountForBusyDays() {
        // DAY3, DAY5 and DAY6 are all >= 5 birds
        assertThat(birdWatcher.getBusyDays()).isEqualTo(3);
    }

    @Test
    @Tag("task:6")
    @DisplayName("The getBusyDays method correctly returns zero in case of no busy days")
    public void itShouldNotHaveBusyDays() {
        birdWatcher = new BirdWatcher(new int[]{1, 2, 3, 3, 2, 1, 4});
        assertThat(birdWatcher.getBusyDays()).isEqualTo(0);
    }
}
