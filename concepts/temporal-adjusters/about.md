# About

While the core `java.time` classes like `LocalDate` and `LocalDateTime` provide basic methods for adding or subtracting time units, more complex date adjustments often require more sophisticated logic (e.g., finding the "second Tuesday of the month" or the "last day of the year").

The `java.time.temporal` package provides the [`TemporalAdjuster`][temporaladjuster-docs] functional interface for this purpose. It represents a strategy for adjusting a temporal object (like a `LocalDate`). The [`TemporalAdjusters`][temporaladjusters-docs] (note the plural 's') utility class contains static factory methods providing many common, predefined adjuster implementations.

## Using TemporalAdjusters

Temporal objects like `LocalDate` and `LocalDateTime` have a `with()` method that accepts a `TemporalAdjuster`. This method returns a *new* temporal object with the adjustment applied.

```exercism/note
Using `with(TemporalAdjuster)` returns a _new_ instance and does not update the existing instance, as all `java.time` temporal classes are immutable.
```

```java
import java.time.LocalDate;
import java.time.Month;
import java.time.DayOfWeek;
import java.time.temporal.TemporalAdjusters;

LocalDate date = LocalDate.of(2024, Month.AUGUST, 15); // 2024-08-15 (a Thursday)

// Use a predefined adjuster from TemporalAdjusters
LocalDate firstDayOfNextMonth = date.with(TemporalAdjusters.firstDayOfNextMonth());
// => 2024-09-01

LocalDate nextSunday = date.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
// => 2024-08-18
```

## Common Predefined Adjusters

The `TemporalAdjusters` class provides many useful static methods. Here are some common examples:

### Finding Ordinal Day of Week

The `dayOfWeekInMonth(int ordinal, DayOfWeek dayOfWeek)` adjuster finds the nth occurrence of a specific day of the week within the month.

```java
LocalDate date = LocalDate.of(2024, Month.AUGUST, 15); // 2024-08-15

// Find the second Tuesday of August 2024
LocalDate secondTuesday = date.with(TemporalAdjusters.dayOfWeekInMonth(2, DayOfWeek.TUESDAY));
// => 2024-08-13

// Find the fourth Friday of August 2024
LocalDate fourthFriday = date.with(TemporalAdjusters.dayOfWeekInMonth(4, DayOfWeek.FRIDAY));
// => 2024-08-23
```

### Finding First/Last Day of Week in Month

The `firstInMonth(DayOfWeek dayOfWeek)` and `lastInMonth(DayOfWeek dayOfWeek)` adjusters find the first or last occurrence of a day of the week within the month.

```java
LocalDate date = LocalDate.of(2024, Month.AUGUST, 15); // 2024-08-15

// Find the first Sunday of August 2024
LocalDate firstSunday = date.with(TemporalAdjusters.firstInMonth(DayOfWeek.SUNDAY));
// => 2024-08-04

// Find the last Monday of August 2024
LocalDate lastMonday = date.with(TemporalAdjusters.lastInMonth(DayOfWeek.MONDAY));
// => 2024-08-26
```

### Finding First/Last Day of Month/Year

Simpler adjusters find the first or last day of the current month or year.

```java
LocalDate date = LocalDate.of(2024, Month.AUGUST, 15); // 2024-08-15

LocalDate firstDay = date.with(TemporalAdjusters.firstDayOfMonth());
// => 2024-08-01

LocalDate lastDay = date.with(TemporalAdjusters.lastDayOfMonth());
// => 2024-08-31

LocalDate lastDayOfYear = date.with(TemporalAdjusters.lastDayOfYear());
// => 2024-12-31
```

### Relative Adjustments (Next/Previous)

Adjusters like `next()`, `previous()`, `nextOrSame()`, and `previousOrSame()` find the next or previous occurrence of a given day of the week, relative to the current date.

- `next()`/`previous()`: Excludes the current date if it matches.
- `nextOrSame()`/`previousOrSame()`: Includes the current date if it matches.

```java
LocalDate thursday = LocalDate.of(2024, Month.AUGUST, 15); // A Thursday

// Find the next Sunday (exclusive)
LocalDate nextSunday = thursday.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
// => 2024-08-18

// Find the next Thursday (exclusive)
LocalDate nextThursday = thursday.with(TemporalAdjusters.next(DayOfWeek.THURSDAY));
// => 2024-08-22

// Find the next Thursday (inclusive) - returns the same date
LocalDate nextOrSameThursday = thursday.with(TemporalAdjusters.nextOrSame(DayOfWeek.THURSDAY));
// => 2024-08-15

// Find the previous Monday (exclusive)
LocalDate previousMonday = thursday.with(TemporalAdjusters.previous(DayOfWeek.MONDAY));
// => 2024-08-12
```

The `nextOrSame()` adjuster is particularly useful for finding dates in ranges like the "teenth" days (13th-19th) of a month, as seen in the Meetup exercise. Applying `nextOrSame(targetDayOfWeek)` to the 13th day of the month will find the correct "teenth" date.

## Custom Adjusters

Since `TemporalAdjuster` is a [`@FunctionalInterface`][functionalinterface-docs], you can create your own custom adjusters using lambda expressions for logic not covered by the predefined methods. The interface requires implementing a single method: `Temporal adjustInto(Temporal temporal)`.

```java
// Example: An adjuster that finds the next workday (Mon-Fri), skipping weekends.
TemporalAdjuster nextWorkday = temporal -> {
    LocalDate result = (LocalDate) temporal; // Assuming input is LocalDate
    do {
        result = result.plusDays(1);
    } while (result.getDayOfWeek() == DayOfWeek.SATURDAY || result.getDayOfWeek() == DayOfWeek.SUNDAY);
    return result;
};

LocalDate friday = LocalDate.of(2024, Month.AUGUST, 16);
LocalDate nextWorkdayDate = friday.with(nextWorkday);
// => 2024-08-19 (Monday)

LocalDate sunday = LocalDate.of(2024, Month.AUGUST, 18);
LocalDate nextWorkdayFromSunday = sunday.with(nextWorkday);
// => 2024-08-19 (Monday)
```

While custom adjusters are powerful, the predefined adjusters in the `TemporalAdjusters` class cover a wide range of common use cases.

[temporaladjuster-docs]: https://docs.oracle.com/javase/8/docs/api/java/time/temporal/TemporalAdjuster.html
[temporaladjusters-docs]: https://docs.oracle.com/javase/8/docs/api/java/time/temporal/TemporalAdjusters.html
[localdate-docs]: https://docs.oracle.com/javase/8/docs/api/java/time/LocalDate.html
[dayofweek-docs]: https://docs.oracle.com/javase/8/docs/api/java/time/DayOfWeek.html
[functionalinterface-docs]: https://docs.oracle.com/javase/8/docs/api/java/lang/FunctionalInterface.html
