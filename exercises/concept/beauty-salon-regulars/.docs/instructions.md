# Instructions

The beauty salon in New York that you helped in the Booking Up For Beauty exercise has been doing well, and many of its clients have become regulars.
Instead of booking every visit separately, a regular has a standing arrangement: "every second Tuesday", "the last Friday of the month", and so on.
The owner has asked you for a helper that works out the dates behind these arrangements, as well as the dates of the salon's own monthly routine.

## 1. Find a regular's standing appointment

Implement the `SalonCalendar.standingAppointment()` method that takes a year, a month, an occurrence (`1` for the first, `2` for the second, and so on) and a day of the week.
It returns the date of that occurrence of the day of the week within the month:

```java
SalonCalendar calendar = new SalonCalendar();
calendar.standingAppointment(2024, Month.AUGUST, 2, DayOfWeek.TUESDAY);
// => LocalDate.of(2024, 8, 13)
```

## 2. Find a regular's last-of-the-month appointment

Some regulars prefer the last occurrence of their day in the month.
Implement the `SalonCalendar.lastAppointment()` method that takes a year, a month and a day of the week, and returns the date of the last occurrence of that day of the week within the month:

```java
SalonCalendar calendar = new SalonCalendar();
calendar.lastAppointment(2024, Month.AUGUST, DayOfWeek.FRIDAY);
// => LocalDate.of(2024, 8, 30)
```

## 3. Find the next available day for a walk-in

A client at the front desk asks for "the next Saturday".
If the day they ask on is already a Saturday, they mean that very day.
Implement the `SalonCalendar.nextAvailable()` method that takes a date and a day of the week, and returns the first date on or after the given date that falls on that day of the week:

```java
SalonCalendar calendar = new SalonCalendar();
calendar.nextAvailable(LocalDate.of(2024, 8, 15), DayOfWeek.SATURDAY);
// => LocalDate.of(2024, 8, 17)
calendar.nextAvailable(LocalDate.of(2024, 8, 17), DayOfWeek.SATURDAY);
// => LocalDate.of(2024, 8, 17)
```

## 4. Find the bookkeeping day

The salon closes its books on the last day of each month.
The salon is closed on weekends, though, so when the last day of the month falls on a Saturday or a Sunday, the books are closed on the Friday before.
Implement the `SalonCalendar.bookkeepingDay()` method that takes a year and a month, and returns the bookkeeping day of that month:

```java
SalonCalendar calendar = new SalonCalendar();
calendar.bookkeepingDay(2024, Month.SEPTEMBER);
// => LocalDate.of(2024, 9, 30)
calendar.bookkeepingDay(2024, Month.AUGUST);
// => LocalDate.of(2024, 8, 30)
```

## 5. Reuse the weekend rule for payday

Staff are paid on the 15th of every month, with the same weekend rule: when the 15th falls on a Saturday or a Sunday, payday is the Friday before.
Rather than writing the rule a second time, turn it into a reusable adjuster.

Implement the `SalonCalendar.precedingWorkday()` method that returns a `TemporalAdjuster` which leaves a weekday unchanged and moves a Saturday or a Sunday back to the preceding Friday.
Then implement the `SalonCalendar.payday()` method, which takes a year and a month, using that adjuster:

```java
SalonCalendar calendar = new SalonCalendar();
LocalDate.of(2024, 6, 15).with(calendar.precedingWorkday());
// => LocalDate.of(2024, 6, 14)
calendar.payday(2024, Month.JUNE);
// => LocalDate.of(2024, 6, 14)
calendar.payday(2024, Month.AUGUST);
// => LocalDate.of(2024, 8, 15)
```

Feel free to go back and use the adjuster in `bookkeepingDay()` as well.
