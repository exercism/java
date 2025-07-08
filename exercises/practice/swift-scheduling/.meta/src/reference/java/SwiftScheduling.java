import java.time.DayOfWeek;
import java.time.LocalDateTime;

import static java.time.DayOfWeek.*;

public class SwiftScheduling {
    public static LocalDateTime convertToDeliveryDate(LocalDateTime meetingStart, String description) {
        if ("NOW".equals(description)) {
            return meetingStart.plusHours(2);
        }

        if ("ASAP".equals(description)) {
            LocalDateTime sameDayAt1pm = toStartOfDay(meetingStart).withHour(13);

            if (meetingStart.isBefore(sameDayAt1pm)) {
                return toStartOfDay(meetingStart).withHour(17);
            } else {
                return toStartOfDay(meetingStart).plusDays(1).withHour(13);
            }
        }

        if ("EOW".equals(description)) {
            DayOfWeek day = meetingStart.getDayOfWeek();
            LocalDateTime deliveryDate = toStartOfDay(meetingStart);

            if (day == MONDAY || day == TUESDAY || day == WEDNESDAY) {
                deliveryDate = deliveryDate.withHour(17);
                while (deliveryDate.getDayOfWeek() != FRIDAY) {
                    deliveryDate = deliveryDate.plusDays(1);
                }
            } else if (day == THURSDAY || day == FRIDAY) {
                deliveryDate = deliveryDate.withHour(20);
                while (deliveryDate.getDayOfWeek() != SUNDAY) {
                    deliveryDate = deliveryDate.plusDays(1);
                }
            } else {
                throw new IllegalArgumentException("Invalid day of week");
            }

            return deliveryDate;
        }

        if (description.matches("\\d+M")) {
            int month = Integer.parseInt(description.substring(0, description.length() - 1));
            LocalDateTime targetMonth = toStartOfDay(meetingStart)
                    .withMonth(month)
                    .withDayOfMonth(1);

            if (!meetingStart.isBefore(targetMonth)) {
                targetMonth = targetMonth.plusYears(1);
            }

            LocalDateTime deliveryDate = targetMonth.withHour(8);
            while (isWeekend(deliveryDate)) {
                deliveryDate = deliveryDate.plusDays(1);
            }

            return deliveryDate;
        }

        if (description.matches("Q\\d")) {
            int quarter = Integer.parseInt(description.substring(1));
            LocalDateTime lastDayOfQuarter = getLastDayOfQuarter(meetingStart, quarter);

            if (!meetingStart.isBefore(lastDayOfQuarter.plusDays(1))) {
                lastDayOfQuarter = lastDayOfQuarter.plusYears(1);
            }

            LocalDateTime deliveryDate = lastDayOfQuarter.withHour(8);
            while (isWeekend(deliveryDate)) {
                deliveryDate = deliveryDate.minusDays(1);
            }

            return deliveryDate;
        }

        throw new IllegalArgumentException("Invalid description");
    }

    private static LocalDateTime toStartOfDay(LocalDateTime dateTime) {
        return dateTime.toLocalDate().atStartOfDay();
    }

    private static LocalDateTime getLastDayOfQuarter(LocalDateTime dateTime, int quarter) {
        int lastMonthOfQuarter = quarter * 3;
        return toStartOfDay(dateTime)
                .withMonth(lastMonthOfQuarter)
                .withDayOfMonth(1)
                .plusMonths(1)
                .minusDays(1);
    }

    private static boolean isWeekend(LocalDateTime date) {
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        return dayOfWeek == SATURDAY || dayOfWeek == SUNDAY;
    }
}
