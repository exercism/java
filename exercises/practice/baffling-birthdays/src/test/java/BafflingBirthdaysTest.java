import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static java.time.Month.APRIL;
import static java.time.Month.AUGUST;
import static java.time.Month.DECEMBER;
import static java.time.Month.FEBRUARY;
import static java.time.Month.JANUARY;
import static java.time.Month.JULY;
import static java.time.Month.MAY;
import static java.time.Month.NOVEMBER;
import static java.time.Month.OCTOBER;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.data.Offset.offset;

public class BafflingBirthdaysTest {
    private BafflingBirthdays birthdays = new BafflingBirthdays();

    @Test
    @DisplayName("one birthdate")
    public void oneBirthdateTest() {
        assertThat(birthdays.sharedBirthday(List.of(
                LocalDate.of(2000, JANUARY, 1)
        ))).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("two birthdates with same year, month, and day")
    public void twoBirthdatesWithSameYearMonthAndDayTest() {
        assertThat(birthdays.sharedBirthday(List.of(
                LocalDate.of(2000, JANUARY, 1),
                LocalDate.of(2000, JANUARY, 1)
        ))).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("two birthdates with same year and month, but different day")
    public void twoBirthdatesWithSameYearAndMonthButDifferentDayTest() {
        assertThat(birthdays.sharedBirthday(List.of(
                LocalDate.of(2012, MAY, 9),
                LocalDate.of(2012, MAY, 17)
        ))).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("two birthdates with same month and day, but different year")
    public void twoBirthdatesWithSameMonthAndDayButDifferentYearTest() {
        assertThat(birthdays.sharedBirthday(List.of(
                LocalDate.of(1999, OCTOBER, 23),
                LocalDate.of(1988, OCTOBER, 23)
        ))).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("two birthdates with same year, but different month and day")
    public void twoBirthdatesWithSameYearButDifferentMonthAndDayTest() {
        assertThat(birthdays.sharedBirthday(List.of(
                LocalDate.of(2007, DECEMBER, 19),
                LocalDate.of(2007, APRIL, 27)
        ))).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("two birthdates with different year, month, and day")
    public void twoBirthdatesWithDifferentYearMonthAndDayTest() {
        assertThat(birthdays.sharedBirthday(List.of(
                LocalDate.of(1997, AUGUST, 4),
                LocalDate.of(1963, NOVEMBER, 23)
        ))).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("multiple birthdates without shared birthday")
    public void multipleBirthdatesWithoutSharedBirthdayTest() {
        assertThat(birthdays.sharedBirthday(List.of(
                LocalDate.of(1966, AUGUST, 29),
                LocalDate.of(1977, FEBRUARY, 12),
                LocalDate.of(2001, DECEMBER, 25),
                LocalDate.of(1980, NOVEMBER, 10)
        ))).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("multiple birthdates with one shared birthday")
    public void multipleBirthdatesWithOneSharedBirthdayTest() {
        assertThat(birthdays.sharedBirthday(List.of(
                LocalDate.of(1966, AUGUST, 29),
                LocalDate.of(1977, FEBRUARY, 12),
                LocalDate.of(2001, AUGUST, 29),
                LocalDate.of(1980, NOVEMBER, 10)
        ))).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("multiple birthdates with more than one shared birthday")
    public void multipleBirthdatesWithMoreThanOneSharedBirthdayTest() {
        assertThat(birthdays.sharedBirthday(List.of(
                LocalDate.of(1966, JULY, 29),
                LocalDate.of(1977, FEBRUARY, 12),
                LocalDate.of(2001, DECEMBER, 25),
                LocalDate.of(1980, JULY, 29),
                LocalDate.of(2019, FEBRUARY, 12)
        ))).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("generate requested number of birthdates")
    public void generateRequestedNumberOfBirthdatesTest() {
        int groupSize = 50;
        assertThat(birthdays.randomBirthdates(groupSize).size()).isEqualTo(groupSize);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("years are not leap years")
    public void yearsAreNotLeapYearsTest() {
        assertThat(birthdays.randomBirthdates(100)).noneMatch(LocalDate::isLeapYear);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("months are random")
    public void monthsAreRandomTest() {
        assertThat(birthdays.randomBirthdates(500).stream().map(LocalDate::getMonth).distinct())
                .hasSizeGreaterThanOrEqualTo(7);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("days are random")
    public void daysAreRandomTest() {
        assertThat(birthdays.randomBirthdates(500).stream().map(LocalDate::getDayOfMonth).distinct())
                .hasSizeGreaterThanOrEqualTo(11);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("estimated probability of at least one shared birthday case for one person")
    public void estimatedProbabilityOfAtLeastOneSharedBirthdayForOnePersonTest() {
        assertThat(birthdays.estimatedProbabilityOfSharedBirthday(1)).isEqualTo(0.0);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("estimated probability of at least one shared birthday case among ten people")
    public void estimatedProbabilityOfAtLeastOneSharedBirthdayAmongTenPeopleTest() {
        assertThat(birthdays.estimatedProbabilityOfSharedBirthday(10)).isCloseTo(11.694818, offset(1.0));
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("estimated probability of at least one shared birthday case among twenty-three people")
    public void estimatedProbabilityOfAtLeastOneSharedBirthdayAmongTwentyThreePeopleTest() {
        assertThat(birthdays.estimatedProbabilityOfSharedBirthday(23)).isCloseTo(50.729723, offset(1.0));
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("estimated probability of at least one shared birthday case among seventy people")
    public void estimatedProbabilityOfAtLeastOneSharedBirthdayAmongSeventyPeopleTest() {
        assertThat(birthdays.estimatedProbabilityOfSharedBirthday(70)).isCloseTo(99.915958, offset(1.0));
    }
}
