# About

Classes like `LocalDate` and `LocalDateTime` describe a _point_ in time.
The `java.time` package also has two classes that describe an _amount_ of time:

- [`Period`][period-docs] is a date-based amount of time in years, months and days, such as "2 months and 5 days".
- [`Duration`][duration-docs] is a time-based amount of time in seconds and nanoseconds, such as "1 hour and 30 minutes".

The difference matters because calendar units do not have a fixed length.
A month can have 28, 29, 30 or 31 days, so "one month" is not a fixed number of seconds.
A `Period` follows the calendar, while a `Duration` measures exact time.

| | `Period` | `Duration` |
| --- | --- | --- |
| Stores | years, months and days | seconds and nanoseconds |
| Used with | `LocalDate` | `LocalTime`, `LocalDateTime`, `Instant` |
| Example | "the membership lasts 1 month" | "the visit lasted 95 minutes" |
| `toString()` | `P1Y2M15D` | `PT1H35M` |

Both classes are immutable.
Methods such as `plusDays()` or `multipliedBy()` return a _new_ instance and leave the original unchanged.

## `Period`

### Creating a period

```java
Period.ofDays(10);
// => P10D

Period.ofWeeks(2);
// => P14D

Period.ofMonths(3);
// => P3M

Period.of(1, 2, 15);
// => P1Y2M15D
```

The result of `toString()` uses the [ISO-8601 duration format][iso-8601-durations]: `P` followed by the number of years (`Y`), months (`M`) and days (`D`).
There are no weeks in a `Period`: `Period.ofWeeks(2)` is stored as 14 days.
The same notation can be parsed back with `Period.parse()`:

```java
Period.parse("P1Y2M15D");
// => P1Y2M15D
```

### Adding a period to a date

A period is added to or subtracted from a date with `plus()` and `minus()`:

```java
LocalDate date = LocalDate.of(2024, 3, 10);

date.plus(Period.ofMonths(2));
// => 2024-05-10

date.minus(Period.ofDays(10));
// => 2024-02-29
```

The years are added first, then the months and then the days.
When adding years or months lands on a day that does not exist, the result is moved back to the last valid day of that month:

```java
LocalDate.of(2025, 1, 31).plus(Period.ofMonths(1));
// => 2025-02-28

LocalDate.of(2024, 2, 29).plus(Period.ofYears(1));
// => 2025-02-28
```

This also means that adding a period and then subtracting it again does not always give back the original date:

```java
LocalDate.of(2025, 1, 31).plus(Period.ofMonths(1)).minus(Period.ofMonths(1));
// => 2025-01-28
```

### The period between two dates

`Period.between()` returns the period from one date (inclusive) to another (exclusive).
The same result is available as `LocalDate.until()`:

```java
LocalDate start = LocalDate.of(2023, 3, 10);
LocalDate end = LocalDate.of(2024, 5, 25);

Period.between(start, end);
// => P1Y2M15D

start.until(end);
// => P1Y2M15D
```

The parts of a period are available through `getYears()`, `getMonths()` and `getDays()`.
These parts are independent of each other: `getDays()` returns only the days part, not the total number of days.
`toTotalMonths()` returns the years and months combined as a number of months, but there is no method for the total number of days, because that depends on which months are involved.

```java
Period period = Period.between(LocalDate.of(2024, 1, 15), LocalDate.of(2024, 3, 20));
// => P2M5D

period.getDays();
// => 5

period.toTotalMonths();
// => 2
```

### Normalizing a period

A period created with a factory method keeps its units exactly as given, and `equals()` compares the units one by one.
`normalized()` rolls months over into years, but it leaves the days alone:

```java
Period.ofMonths(14);
// => P14M

Period.ofMonths(14).equals(Period.of(1, 2, 0));
// => false

Period.ofMonths(14).normalized();
// => P1Y2M

Period.ofDays(45).normalized();
// => P45D
```

## Counting units with `ChronoUnit`

To get the total number of a single unit between two points in time, use the `between()` method on one of the constants of [`ChronoUnit`][chronounit-docs]:

```java
LocalDate start = LocalDate.of(2024, 1, 15);
LocalDate end = LocalDate.of(2024, 3, 20);

ChronoUnit.DAYS.between(start, end);
// => 65

ChronoUnit.WEEKS.between(start, end);
// => 9

ChronoUnit.MONTHS.between(start, end);
// => 2
```

Only complete units are counted, and the result is negative when the second argument is before the first one:

```java
ChronoUnit.DAYS.between(end, start);
// => -65
```

`ChronoUnit` works with time-based units and date-times too:

```java
ChronoUnit.MINUTES.between(
    LocalDateTime.of(2024, 3, 10, 18, 5),
    LocalDateTime.of(2024, 3, 10, 19, 40));
// => 95
```

## `Duration`

### Creating a duration

```java
Duration.ofMinutes(90);
// => PT1H30M

Duration.ofSeconds(3725);
// => PT1H2M5S

Duration.ofDays(2);
// => PT48H

Duration.ofHours(2).plusMinutes(15);
// => PT2H15M
```

In the ISO-8601 notation, the `T` separates the date part from the time part.
A `Duration` has no date part, so its `toString()` always starts with `PT`.
`Duration.ofDays()` treats a day as exactly 24 hours.

A duration can also be parsed with `Duration.parse()`:

```java
Duration.parse("PT1H30M");
// => PT1H30M
```

### Adding a duration to a time

A duration is added to or subtracted from a `LocalTime`, a `LocalDateTime` or an `Instant` with `plus()` and `minus()`:

```java
LocalDateTime start = LocalDateTime.of(2024, 3, 10, 22, 30);

start.plus(Duration.ofMinutes(90));
// => 2024-03-11T00:00

LocalTime.of(23, 0).plus(Duration.ofHours(2));
// => 01:00
```

A `LocalTime` wraps around midnight, as the last example shows.

A `LocalDate` has no time, so it cannot be combined with a `Duration`:

```java
LocalDate.of(2024, 3, 10).plus(Duration.ofHours(1));
// => throws UnsupportedTemporalTypeException
```

### The duration between two times

`Duration.between()` returns the exact amount of time between two times or date-times:

```java
LocalDateTime checkIn = LocalDateTime.of(2024, 3, 10, 18, 5);
LocalDateTime checkOut = LocalDateTime.of(2024, 3, 10, 19, 40);

Duration.between(checkIn, checkOut);
// => PT1H35M

Duration.between(checkOut, checkIn);
// => PT-1H-35M
```

`Duration.between()` does not accept two `LocalDate` values, because a date has no seconds to measure:

```java
Duration.between(LocalDate.of(2024, 1, 15), LocalDate.of(2024, 3, 20));
// => throws UnsupportedTemporalTypeException
```

Use `Period.between()` or `ChronoUnit.DAYS.between()` for dates instead.

### Converting a duration

The `toXxx()` methods convert a duration to a _total_ amount of a single unit, rounded down:

```java
Duration duration = Duration.ofSeconds(5730); // 1 hour, 35 minutes and 30 seconds

duration.toHours();
// => 1

duration.toMinutes();
// => 95

duration.toSeconds();
// => 5730
```

The `toXxxPart()` methods split a duration into its parts, as on a clock:

```java
Duration duration = Duration.ofSeconds(5730);

duration.toHoursPart();
// => 1

duration.toMinutesPart();
// => 35

duration.toSecondsPart();
// => 30
```

`toHoursPart()` stops at 23, because the hours above that are counted by `toDaysPart()`.

### Comparing and calculating with durations

Durations can be compared with `compareTo()`, and checked with `isZero()` and `isNegative()`:

```java
Duration visit = Duration.ofMinutes(95);
Duration limit = Duration.ofHours(2);

visit.compareTo(limit) > 0;
// => false

Duration.between(LocalTime.of(10, 0), LocalTime.of(9, 0)).isNegative();
// => true
```

They also support arithmetic, such as `plus()`, `minus()`, `multipliedBy()` and `dividedBy()`:

```java
Duration.ofMinutes(20).multipliedBy(3);
// => PT1H

Duration.ofHours(2).dividedBy(Duration.ofMinutes(15));
// => 8
```

## `Period` or `Duration`?

For local dates and times, the choice is usually made for you: a date has no time to measure, and a time has no calendar.
The difference becomes visible with time zones.
When the clocks move forward for daylight saving time, a calendar day is only 23 hours long:

```java
ZonedDateTime noon = ZonedDateTime.of(2025, 3, 29, 12, 0, 0, 0, ZoneId.of("Europe/Amsterdam"));

noon.plus(Period.ofDays(1));
// => 2025-03-30T12:00+02:00[Europe/Amsterdam]

noon.plus(Duration.ofDays(1));
// => 2025-03-30T13:00+02:00[Europe/Amsterdam]
```

Adding a `Period` of one day keeps the time of day, while adding a `Duration` of one day adds exactly 24 hours.
Use a `Period` for amounts people think about in calendar terms ("the same time next month") and a `Duration` for elapsed time ("the parking ticket is valid for 2 hours").

[period-docs]: https://docs.oracle.com/en/java/javase/25/docs/api/java.base/java/time/Period.html
[duration-docs]: https://docs.oracle.com/en/java/javase/25/docs/api/java.base/java/time/Duration.html
[chronounit-docs]: https://docs.oracle.com/en/java/javase/25/docs/api/java.base/java/time/temporal/ChronoUnit.html
[iso-8601-durations]: https://en.wikipedia.org/wiki/ISO_8601#Durations
