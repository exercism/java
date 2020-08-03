import org.junit.Before;
import org.junit.Test;
import org.junit.Ignore;


import static org.assertj.core.api.Assertions.*;

public class BirdCountTest {

    private BirdCount birdCount;
    private int lastWeek[] = {0, 2, 5, 3, 7, 8, 4};

    @Before
    public void setUp() {
        birdCount = new BirdCount(lastWeek);
    }

    @Test
    public void itTestGetLastWeek() {
        assertThat(birdCount.getLastWeek().equals(lastWeek)).isTrue();
    }

    @Test
    @Ignore("Remove to run test")
    public void itTestGetToday() {
        assertThat(birdCount.getToday()).isEqualTo(lastWeek[lastWeek.length - 1]);
    }

    @Test
    @Ignore("Remove to run test")
    public void itShouldReturnZeroIfBirdCountLastWeekIsEmpty() {
        int[] lastWeekEmpty = new int[0];
        birdCount = new BirdCount(lastWeekEmpty);
        assertThat(birdCount.getToday()).isEqualTo(0);
    }

    @Test
    @Ignore("Remove to run test")
    public void itIncrementTodaysCount() {
        int currentTodayCount = birdCount.getToday();
        birdCount.incrementTodaysCount();
        assertThat(birdCount.getToday()).isEqualTo(currentTodayCount + 1);
    }

    @Test
    @Ignore("Remove to run test")
    public void itHasDayWithoutBirds() {
        assertThat(birdCount.hasDayWithoutBirds()).isTrue();
    }

    @Test
    @Ignore("Remove to run test")
    @Ignore
    public void itShouldNotHaveDaysWithoutBirds() {
        birdCount = new BirdCount(new int[]{1, 2, 5, 3, 7, 8, 4});
        assertThat(birdCount.hasDayWithoutBirds()).isFalse();
    }


    @Test
    @Ignore("Remove to run test")
    public void itTestGetCountForFirstDays() {
        assertThat(birdCount.getCountForFirstDays(4)).isEqualTo(10);
    }

    @Test
    @Ignore("Remove to run test")
    @Ignore
    public void itTestGetCountForMoreDaysThanTheArraySize() {
        assertThat(birdCount.getCountForFirstDays(10)).isEqualTo(29);
    }

    @Test
    @Ignore("Remove to run test")
    public void itTestGetCountForBusyDays() {
        assertThat(birdCount.getBusyDays()).isEqualTo(3);
    }

    @Test
    @Ignore("Remove to run test")
    @Ignore
    public void itShouldNotHaveBusyDays() {
        birdCount = new BirdCount(new int[]{1, 2, 3, 3, 2, 1, 4});
        assertThat(birdCount.getBusyDays()).isEqualTo(0);
    }
}
