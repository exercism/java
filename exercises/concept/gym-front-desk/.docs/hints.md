# Hints

## General

- A [`Period`][period-docs] is an amount of time in years, months and days, and is used with dates.
- A [`Duration`][duration-docs] is an amount of time in seconds and nanoseconds, and is used with times and date-times.
- Both classes are immutable: their methods return a new instance and leave the original unchanged.

## 1. Work out when a membership ends

- There is a [factory method][period-ofmonths] that creates a `Period` of a number of months.
- A period can be added to a date with the date's [`plus()`][localdate-plus] method.
- `plus()` already moves a day that does not exist back to the last day of the month, so you do not need to handle it yourself.

## 2. Show how long a membership lasts

- There is a [static method][period-between] on `Period` that returns the period between two dates.

## 3. Count the days left on a membership

- The `getDays()` method of a `Period` only returns the days part of the period, not the total number of days.
- The [`between()`][chronounit-between] method of a [`ChronoUnit`][chronounit-docs] constant counts the total number of that unit between two dates.
- [`Math.max()`][math-max] returns the larger of two numbers.

## 4. Measure a visit

- There is a [static method][duration-between] on `Duration` that returns the duration between two date-times.

## 5. Print a visit on the receipt

- There is a [method][duration-tohours] that returns the total number of hours in a duration.
- There is a [method][duration-tominutespart] that returns only the minutes part of a duration, between 0 and 59.
- [`String.format()`][string-format] with the format specifier `%02d` writes a number with at least two digits, padding it with a leading zero.

[period-docs]: https://docs.oracle.com/en/java/javase/25/docs/api/java.base/java/time/Period.html
[duration-docs]: https://docs.oracle.com/en/java/javase/25/docs/api/java.base/java/time/Duration.html
[period-ofmonths]: https://docs.oracle.com/en/java/javase/25/docs/api/java.base/java/time/Period.html#ofMonths(int)
[localdate-plus]: https://docs.oracle.com/en/java/javase/25/docs/api/java.base/java/time/LocalDate.html#plus(java.time.temporal.TemporalAmount)
[period-between]: https://docs.oracle.com/en/java/javase/25/docs/api/java.base/java/time/Period.html#between(java.time.LocalDate,java.time.LocalDate)
[chronounit-docs]: https://docs.oracle.com/en/java/javase/25/docs/api/java.base/java/time/temporal/ChronoUnit.html
[chronounit-between]: https://docs.oracle.com/en/java/javase/25/docs/api/java.base/java/time/temporal/ChronoUnit.html#between(java.time.temporal.Temporal,java.time.temporal.Temporal)
[math-max]: https://docs.oracle.com/en/java/javase/25/docs/api/java.base/java/lang/Math.html#max(long,long)
[duration-between]: https://docs.oracle.com/en/java/javase/25/docs/api/java.base/java/time/Duration.html#between(java.time.temporal.Temporal,java.time.temporal.Temporal)
[duration-tohours]: https://docs.oracle.com/en/java/javase/25/docs/api/java.base/java/time/Duration.html#toHours()
[duration-tominutespart]: https://docs.oracle.com/en/java/javase/25/docs/api/java.base/java/time/Duration.html#toMinutesPart()
[string-format]: https://docs.oracle.com/en/java/javase/25/docs/api/java.base/java/lang/String.html#format(java.lang.String,java.lang.Object...)
