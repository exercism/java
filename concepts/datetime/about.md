# About

The `java.time` package introduced in Java 8 contains several classes to work with dates and time.

## `LocalDate`

The [`java.time.LocalDate`][localdate-docs] class represents a date without a time-zone in the [ISO-8601 calendar system][iso-8601], such as `2007-12-03`:

```java
LocalDate date = LocalDate.of(2007, 12, 3);
```

Dates can be compared to other dates:

```java
LocalDate date1 = LocalDate.of(2007, 12, 3);
LocalDate date2 = LocalDate.of(2007, 12, 4);

date1.isBefore(date2);
// => true

date1.isAfter(date2);
// => false
```

A `LocalDate` instance has getters to retrieve time portions from it:

```java
LocalDate date = LocalDate.of(2007, 12, 3);

date.getYear();
// => 2007

date.getMonthValue();
// => 12

date.getDayOfMonth();
// => 3
```

A `LocalDate` instance has methods to add time units to it.

```exercism/note
These methods return a _new_ `LocalDate` instance and do not update the existing instance, as the `LocalDate` class is immutable.
```

```java
LocalDate date = LocalDate.of(2007, 12, 3);

date.plusDays(3);
// => 2007-12-06

date.plusMonths(1);
// => 2008-01-03

date.plusYears(1);
// => 2008-12-03
```

## `LocalDateTime`

The [`java.time.LocalDateTime`][localdatetime-docs] class represents a date-time without a time-zone in the [ISO-8601 calendar system][iso-8601], such as `2007-12-03T10:15:30`:

```java
LocalDateTime datetime = LocalDateTime.of(2007, 12, 3, 10, 15, 30);

datetime.getYear();
// => 2007

datetime.getMonthValue();
// => 12

datetime.getDayOfMonth();
// => 3

datetime.getHours();
// => 10

datetime.getMinutes();
// => 15

datetime.getSeconds();
// => 30
```

Like the `LocalDate` class, a `LocalDateTime` instance has the same methods to compare to other `LocalDateTime`s and to add time units to it.

It is also possible to convert a `LocalDate` instance into a `LocalDateTime`:

```java
LocalDate date = LocalDate.of(2007, 12, 3);
LocalDateTime datetime = date.atTime(10, 15, 30);
datetime.toString();
// => "2007-12-03T10:15:30"
```

## Formatting datetimes

Both `LocalDate` and `LocalDateTime` use the [ISO-8601][iso-8601] standard notation when converting from and to a `String`.

```java
LocalDateTime datetime = LocalDateTime.of(2007, 12, 3, 10, 15, 30);
LocalDateTime parsed = LocalDateTime.parse("2007-12-03T10:15:30");

datetime.isEqual(parsed);
// => true
```

Attempting to parse a `LocalDate` or `LocalDateTime` from a `String` like this using a different format is not possible.
Instead, to format dates using a custom format, you should use the [`java.time.format.DateTimeFormatter`][datetimeformatter-docs]:

```java
DateTimeFormatter parser = DateTimeFormatter.ofPattern("dd/MM/yyyy");
LocalDate date = LocalDate.parse("03/12/2007", formatter);

DateTimeFormatter printer = DateTimeFormatter.ofPattern("MMMM d, yyyy");
printer.format(date);
// => "December 3, 2007"
```

[iso-8601]: https://en.wikipedia.org/wiki/ISO_8601
[localdate-docs]: https://docs.oracle.com/javase/8/docs/api/java/time/LocalDate.html
[localdatetime-docs]: https://docs.oracle.com/javase/8/docs/api/java/time/LocalDateTime.html
[datetimeformatter-docs]: https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html
