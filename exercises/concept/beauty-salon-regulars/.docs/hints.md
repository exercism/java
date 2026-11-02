# Hints

## General

- The [`TemporalAdjusters`][temporaladjusters-docs] class (note the plural) is a collection of static methods that return ready-made adjusters.
- An adjuster is applied to a `LocalDate` with its [`with()`][localdate-with] method, which returns a new `LocalDate` and leaves the original unchanged.
- To adjust "within a month", start from any date in that month, for example its first day: `LocalDate.of(year, month, 1)`.

## 1. Find a regular's standing appointment

- There is an [adjuster][dayofweekinmonth-docs] that finds the n-th occurrence of a day of the week in the month of the date it is applied to.

## 2. Find a regular's last-of-the-month appointment

- There is an [adjuster][lastinmonth-docs] that finds the last occurrence of a day of the week in the month of the date it is applied to.

## 3. Find the next available day for a walk-in

- There are two adjusters that move forward to a given day of the week: one that always moves to a later date, and [one][nextorsame-docs] that keeps the date if it already matches.

## 4. Find the bookkeeping day

- There is an [adjuster][lastdayofmonth-docs] that moves to the last day of the month.
- A `LocalDate` can tell you its [day of the week][localdate-getdayofweek].
- When the last day falls on a weekend, there is an [adjuster][previous-docs] that moves back to the previous occurrence of a day of the week.

## 5. Reuse the weekend rule for payday

- [`TemporalAdjuster`][temporaladjuster-docs] is a functional interface with a single method, `adjustInto()`, so it can be implemented with a lambda.
- Inside the lambda, [`DayOfWeek.from()`][dayofweek-from] gives the day of the week of the temporal being adjusted.
- Adjusters can be chained: the result of applying one adjuster is a temporal you can apply another adjuster to.

[temporaladjusters-docs]: https://docs.oracle.com/en/java/javase/25/docs/api/java.base/java/time/temporal/TemporalAdjusters.html
[temporaladjuster-docs]: https://docs.oracle.com/en/java/javase/25/docs/api/java.base/java/time/temporal/TemporalAdjuster.html
[localdate-with]: https://docs.oracle.com/en/java/javase/25/docs/api/java.base/java/time/LocalDate.html#with(java.time.temporal.TemporalAdjuster)
[localdate-getdayofweek]: https://docs.oracle.com/en/java/javase/25/docs/api/java.base/java/time/LocalDate.html#getDayOfWeek()
[dayofweek-from]: https://docs.oracle.com/en/java/javase/25/docs/api/java.base/java/time/DayOfWeek.html#from(java.time.temporal.TemporalAccessor)
[dayofweekinmonth-docs]: https://docs.oracle.com/en/java/javase/25/docs/api/java.base/java/time/temporal/TemporalAdjusters.html#dayOfWeekInMonth(int,java.time.DayOfWeek)
[lastinmonth-docs]: https://docs.oracle.com/en/java/javase/25/docs/api/java.base/java/time/temporal/TemporalAdjusters.html#lastInMonth(java.time.DayOfWeek)
[nextorsame-docs]: https://docs.oracle.com/en/java/javase/25/docs/api/java.base/java/time/temporal/TemporalAdjusters.html#nextOrSame(java.time.DayOfWeek)
[lastdayofmonth-docs]: https://docs.oracle.com/en/java/javase/25/docs/api/java.base/java/time/temporal/TemporalAdjusters.html#lastDayOfMonth()
[previous-docs]: https://docs.oracle.com/en/java/javase/25/docs/api/java.base/java/time/temporal/TemporalAdjusters.html#previous(java.time.DayOfWeek)
