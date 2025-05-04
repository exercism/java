# Introduction

When working with `java.time` objects like `LocalDate`, you often need to perform complex date adjustments, such as finding the "second Tuesday of the month". Instead of calculating this manually, you can use **`TemporalAdjusters`**.

The `java.time.temporal.TemporalAdjusters` (note the plural 's') utility class provides static methods for many common date adjustments. You apply these adjustments using the `.with()` method on a temporal object (like `LocalDate`).

```exercism/note
Using `with(TemporalAdjuster)` returns a _new_ instance and does not update the existing instance, as `java.time` objects are immutable.
```

```java
import java.time.LocalDate;
import java.time.Month;
import java.time.DayOfWeek;
import java.time.temporal.TemporalAdjusters;

LocalDate date = LocalDate.of(2024, Month.AUGUST, 15); // 2024-08-15 (a Thursday)

// Use a predefined adjuster: find the last day of the month
LocalDate lastDay = date.with(TemporalAdjusters.lastDayOfMonth());
// => 2024-08-31
```

Here are some key adjusters useful for scheduling calculations:

### Finding Ordinal Day of Week

Use `dayOfWeekInMonth(int ordinal, DayOfWeek dayOfWeek)` to find the nth occurrence of a day of the week.

```java
// Find the second Tuesday of August 2024
LocalDate secondTuesday = date.with(TemporalAdjusters.dayOfWeekInMonth(2, DayOfWeek.TUESDAY));
// => 2024-08-13
```

### Finding First/Last Day of Week in Month

Use `firstInMonth(DayOfWeek dayOfWeek)` or `lastInMonth(DayOfWeek dayOfWeek)`.

```java
// Find the last Monday of August 2024
LocalDate lastMonday = date.with(TemporalAdjusters.lastInMonth(DayOfWeek.MONDAY));
// => 2024-08-26
```

### Finding Relative Occurrences ("Teenth" dates)

Use `nextOrSame(DayOfWeek dayOfWeek)`. This is useful for finding dates like the "teenth" days (13th-19th). Apply it to the 13th day of the month to find the target day of the week within that "teenth" range.

```java
LocalDate thirteenth = LocalDate.of(2024, Month.AUGUST, 13); // Tuesday the 13th

// Find the first Saturday on or after the 13th ("Teenth" Saturday)
LocalDate teenthSaturday = thirteenth.with(TemporalAdjusters.nextOrSame(DayOfWeek.SATURDAY));
// => 2024-08-17

// Find the first Tuesday on or after the 13th ("Teenth" Tuesday)
LocalDate teenthTuesday = thirteenth.with(TemporalAdjusters.nextOrSame(DayOfWeek.TUESDAY));
// => 2024-08-13 (returns the same date as it matches)
```

Using these adjusters from the `TemporalAdjusters` class can greatly simplify date manipulation tasks.
