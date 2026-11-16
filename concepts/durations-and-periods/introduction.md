# Introduction

Classes like `LocalDate` and `LocalDateTime` describe a _point_ in time.
The `java.time` package also has two classes that describe an _amount_ of time:

- `java.time.Period` is an amount of time in years, months and days, such as "2 months and 5 days".
- `java.time.Duration` is an amount of time in seconds and nanoseconds, such as "1 hour and 30 minutes".

A `Period` follows the calendar, so it is used with dates.
A `Duration` measures exact time, so it is used with times and date-times.

```exercism/note
Like the other `java.time` classes, `Period` and `Duration` are immutable.
Methods that look like they change them return a _new_ instance instead.
```

## `Period`

A `Period` is created with one of its static factory methods:

```java
Period.ofDays(10);
// => P10D

Period.ofMonths(3);
// => P3M

Period.of(1, 2, 15);
// => P1Y2M15D
```

The result of `toString()` uses the [ISO-8601][iso-8601-durations] notation: `P` (for "period") followed by the number of years (`Y`), months (`M`) and days (`D`).

A period can be added to or subtracted from a date:

```java
LocalDate date = LocalDate.of(2024, 3, 10);

date.plus(Period.ofMonths(2));
// => 2024-05-10

date.minus(Period.ofDays(10));
// => 2024-02-29
```

Because months have different lengths, adding months can land on a day that does not exist.
In that case the result is moved back to the last valid day of the month:

```java
LocalDate.of(2025, 1, 31).plus(Period.ofMonths(1));
// => 2025-02-28
```

`Period.between()` returns the period from one date (inclusive) to another (exclusive):

```java
LocalDate start = LocalDate.of(2023, 3, 10);
LocalDate end = LocalDate.of(2024, 5, 25);

Period period = Period.between(start, end);
// => P1Y2M15D

period.getYears();
// => 1
period.getMonths();
// => 2
period.getDays();
// => 15
```

## Counting units with `ChronoUnit`

A `Period` keeps its years, months and days apart.
So `getDays()` returns only the days _part_ of the period, not the total number of days.
To count the total number of a single unit between two dates, use the `between()` method of [`java.time.temporal.ChronoUnit`][chronounit-docs]:

```java
LocalDate start = LocalDate.of(2024, 1, 15);
LocalDate end = LocalDate.of(2024, 3, 20);

Period.between(start, end);
// => P2M5D

Period.between(start, end).getDays();
// => 5

ChronoUnit.DAYS.between(start, end);
// => 65
```

The result is negative when the second date is before the first one:

```java
ChronoUnit.DAYS.between(end, start);
// => -65
```

## `Duration`

A `Duration` is also created with static factory methods:

```java
Duration.ofMinutes(90);
// => PT1H30M

Duration.ofHours(2).plusMinutes(15);
// => PT2H15M
```

In the ISO-8601 notation, the `T` separates the date part from the time part, which is why durations are written as `PT...`.

A duration can be added to or subtracted from a date-time:

```java
LocalDateTime start = LocalDateTime.of(2024, 3, 10, 22, 30);

start.plus(Duration.ofMinutes(90));
// => 2024-03-11T00:00
```

`Duration.between()` returns the exact amount of time between two date-times:

```java
LocalDateTime checkIn = LocalDateTime.of(2024, 3, 10, 18, 5);
LocalDateTime checkOut = LocalDateTime.of(2024, 3, 10, 19, 40);

Duration.between(checkIn, checkOut);
// => PT1H35M
```

A duration can be converted to a single unit with methods such as `toHours()`, `toMinutes()` and `toSeconds()`.
These return the _total_ amount in that unit, rounded down:

```java
Duration duration = Duration.ofMinutes(95);

duration.toHours();
// => 1
duration.toMinutes();
// => 95
```

To split a duration into its parts, as on a clock, use the `toXxxPart()` methods instead:

```java
Duration duration = Duration.ofMinutes(95);

duration.toHoursPart();
// => 1
duration.toMinutesPart();
// => 35
```

[iso-8601-durations]: https://en.wikipedia.org/wiki/ISO_8601#Durations
[chronounit-docs]: https://docs.oracle.com/en/java/javase/25/docs/api/java.base/java/time/temporal/ChronoUnit.html
