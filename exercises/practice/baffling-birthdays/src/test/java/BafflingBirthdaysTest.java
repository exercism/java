import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.data.Offset.offset;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BafflingBirthdaysTest {
    private BafflingBirthdays birthdays = new BafflingBirthdays();

    @Test
    @DisplayName("one birthdate")
    public void oneBirthdateTest() {
        assertThat(birthdays.sharedBirthday(List.of("2000-01-01"))).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("two birthdates with same year, month, and day")
    public void twoBirthdatesWithSameYearMonthAndDayTest() {
        assertThat(birthdays.sharedBirthday(List.of("2000-01-01", "2000-01-01"))).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("two birthdates with same year and month, but different day")
    public void twoBirthdatesWithSameYearAndMonthButDifferentDayTest() {
        assertThat(birthdays.sharedBirthday(List.of("2012-05-09", "2012-05-17"))).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("two birthdates with same month and day, but different year")
    public void twoBirthdatesWithSameMonthAndDayButDifferentYearTest() {
        assertThat(birthdays.sharedBirthday(List.of("1999-10-23", "1988-10-23"))).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("two birthdates with same year, but different month and day")
    public void twoBirthdatesWithSameYearButDifferentMonthAndDayTest() {
        assertThat(birthdays.sharedBirthday(List.of("2007-12-19", "2007-04-27"))).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("two birthdates with different year, month, and day")
    public void twoBirthdatesWithDifferentYearMonthAndDayTest() {
        assertThat(birthdays.sharedBirthday(List.of("1997-08-04", "1963-11-23"))).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("multiple birthdates without shared birthday")
    public void multipleBirthdatesWithoutSharedBirthdayTest() {
        assertThat(birthdays.sharedBirthday(List.of("1966-07-29", "1977-02-12", "2001-12-25", "1980-11-10"))).isFalse();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("multiple birthdates with one shared birthday")
    public void multipleBirthdatesWithOneSharedBirthdayTest() {
        assertThat(birthdays.sharedBirthday(List.of("1966-07-29", "1977-02-12", "2001-07-29", "1980-11-10"))).isTrue();
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("multiple birthdates with more than one shared birthday")
    public void multipleBirthdatesWithMoreThanOneSharedBirthdayTest() {
        assertThat(birthdays.sharedBirthday(List.of(
                "1966-07-29",
                "1977-02-12",
                "2001-12-25",
                "1980-07-29",
                "2019-02-12"
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
        for (String birthdate : birthdays.randomBirthdates(100)) {
            LocalDate date = LocalDate.parse(birthdate);
            assertThat(date.isLeapYear()).isFalse();
            assertThat(date.getMonthValue() == 2 && date.getDayOfMonth() == 29).isFalse();
        }
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("months are random")
    public void monthsAreRandomTest() {
        Set<Integer> months = new HashSet<>();
        for (String birthdate : birthdays.randomBirthdates(500)) {
            LocalDate date = LocalDate.parse(birthdate);
            months.add(date.getMonthValue());
            if (months.size() >= 7) {
                break;
            }
        }
        assertThat(months).hasSizeGreaterThanOrEqualTo(7);
    }

    @Disabled("Remove to run test")
    @Test
    @DisplayName("days are random")
    public void daysAreRandomTest() {
        Set<Integer> days = new HashSet<>();
        for (String birthdate : birthdays.randomBirthdates(500)) {
            LocalDate date = LocalDate.parse(birthdate);
            days.add(date.getDayOfMonth());
            if (days.size() >= 11) {
                break;
            }
        }
        assertThat(days).hasSizeGreaterThanOrEqualTo(11);
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
