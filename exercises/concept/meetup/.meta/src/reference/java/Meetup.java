import java.time.LocalDate;
import java.time.DayOfWeek;


class Meetup {
    private final LocalDate startOfMonth;

    Meetup(int monthOfYear, int year) {
        startOfMonth = LocalDate.of(year, monthOfYear, 1);
    }

    LocalDate day(DayOfWeek dayOfWeek, MeetupSchedule schedule) {
        LocalDate current = cycleToNext(dayOfWeek, startOfMonth);
        switch (schedule) {
            case FIRST:
                break;
            case SECOND:
                current = current.plusWeeks(1);
                break;
            case THIRD:
                current = current.plusWeeks(2);
                break;
            case FOURTH:
                current = current.plusWeeks(3);
                break;
            case TEENTH:
                while (current.getDayOfMonth() < 13) {
                    current = current.plusWeeks(1);
                }
                break;
            case LAST:
                current = cycleToPrev(dayOfWeek, startOfMonth.plusMonths(1).minusDays(1));
                break;
            default:
                return null;
        }
        return current;
    }

    private LocalDate cycleToPrev(DayOfWeek dayOfWeek, LocalDate current) {
        while (current.getDayOfWeek() != dayOfWeek) {
            current = current.minusDays(1);
        }
        return current;
    }

    private LocalDate cycleToNext(DayOfWeek dayOfWeek, LocalDate current) {
        while (current.getDayOfWeek() != dayOfWeek) {
            current = current.plusDays(1);
        }
        return current;
    }
}
