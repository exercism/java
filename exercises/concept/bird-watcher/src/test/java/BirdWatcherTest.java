import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BirdWatcherTest {

    @Test
    @Tag("task:1")
    @DisplayName("The getLastWeek method correctly returns last week's counts")
    public void itTestGetLastWeek() {
        assertThat(BirdWatcher.getLastWeek()).isEqualTo(new int[] {0, 2, 5, 3, 7, 8, 4});
    }

    @Test
    @Tag("task:2")
    @DisplayName("The getToday method correctly returns today's counts")
    public void itTestGetToday() {
        int[] counts = new int[] {8, 8, 9, 5, 4, 7, 10};
        BirdWatcher birdWatcher = new BirdWatcher(counts);
        assertThat(birdWatcher.getToday()).isEqualTo(10);
    }

    @Test
    @Tag("task:3")
    @DisplayName("The incrementTodaysCount method correctly increments today's counts")
    public void itIncrementTodaysCount() {
        int[] counts = new int[] {8, 8, 9, 2, 1, 6, 4};
        BirdWatcher birdWatcher = new BirdWatcher(counts);
        birdWatcher.incrementTodaysCount();
        assertThat(birdWatcher.getToday()).isEqualTo(5);
    }

    @Test
    @Tag("task:4")
    @DisplayName("The hasDayWithoutBirds method returns true when at least one day had no visits")
    public void itHasDayWithoutBirds() {
        int[] counts = new int[] {5, 5, 4, 0, 7, 6, 7};
        BirdWatcher birdWatcher = new BirdWatcher(counts);
        assertThat(birdWatcher.hasDayWithoutBirds()).isTrue();
    }

    @Test
    @Tag("task:4")
    @DisplayName("The hasDayWithoutBirds method returns false when no day had zero visits")
    public void itShouldNotHaveDaysWithoutBirds() {
        int[] counts = new int[] {4, 5, 9, 10, 9, 4, 3};
        BirdWatcher birdWatcher = new BirdWatcher(counts);
        assertThat(birdWatcher.hasDayWithoutBirds()).isFalse();
    }

    @Test
    @Tag("task:4")
    @DisplayName("The hasDayWithoutBirds method returns true if the last day has zero visits")
    public void itHasLastDayWithoutBirds() {
        int[] counts = new int[] {1, 2, 5, 3, 7, 8, 0};
        BirdWatcher birdWatcher = new BirdWatcher(counts);
        assertThat(birdWatcher.hasDayWithoutBirds()).isTrue();
    }

    @Test
    @Tag("task:5")
    @DisplayName("The getCountForFirstDays method returns correct visits' count for given number of days")
    public void itTestGetCountForFirstDays() {
        int[] counts = new int[] {5, 9, 12, 6, 8, 8, 17};
        BirdWatcher birdWatcher = new BirdWatcher(counts);
        assertThat(birdWatcher.getCountForFirstDays(4)).isEqualTo(32);
    }

    @Test
    @Tag("task:5")
    @DisplayName("The getCountForFirstDays method returns overall count when number of days is higher than array size")
    public void itTestGetCountForMoreDaysThanTheArraySize() {
        int[] counts = new int[] {5, 9, 12, 6, 8, 8, 17};
        BirdWatcher birdWatcher = new BirdWatcher(counts);
        assertThat(birdWatcher.getCountForFirstDays(10)).isEqualTo(65);
    }

    @Test
    @Tag("task:5")
    @DisplayName("The incrementTodaysCount method adds one to getCountForFirstDays method")
    public void itIncrementDoesNotChangeCountForOtherDays() {
        int[] counts = new int[] {5, 1, 0, 4, 2, 3, 0};
        BirdWatcher birdWatcher = new BirdWatcher(counts);

        int countPriorIncrement = birdWatcher.getCountForFirstDays(7);
        birdWatcher.incrementTodaysCount();
        int countAfterIncrement = birdWatcher.getCountForFirstDays(7);

        assertThat(countPriorIncrement).isEqualTo(15);
        assertThat(countAfterIncrement).isEqualTo(16);
    }

    @Test
    @Tag("task:6")
    @DisplayName("The getBusyDays method returns the correct count of busy days")
    public void itTestGetCountForBusyDays() {
        int[] counts = new int[] {4, 9, 5, 7, 8, 8, 2};
        BirdWatcher birdWatcher = new BirdWatcher(counts);
        assertThat(birdWatcher.getBusyDays()).isEqualTo(5);
    }

    @Test
    @Tag("task:6")
    @DisplayName("The getBusyDays method correctly returns zero in case of no busy days")
    public void itShouldNotHaveBusyDays() {
        int[] counts = new int[] {1, 2, 3, 3, 2, 1, 4};
        BirdWatcher birdWatcher = new BirdWatcher(counts);
        assertThat(birdWatcher.getBusyDays()).isEqualTo(0);
    }
}
