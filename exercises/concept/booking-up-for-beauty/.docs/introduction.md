# Introduction

## Date-Time

The `java.time` package introduced in Java 8 contains several classes to work with dates and time.

### `LocalDate`

The `java.time.LocalDate` class represents a date without a time-zone in the [ISO-8601 calendar system][iso-8601], such as `2007-12-03`:

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

date.getDayOfMonth();
// => 3
```

A `LocalDate` instance has methods to add time units to it:

```exercism/note
These methods return a _new_ `LocalDate` instance and do not update the existing instance, as the `LocalDate` class is immutable.
```

```java
LocalDate date = LocalDate.of(2007, 12, 3);

date.addDays(3);
// => 2007-12-06
```

### `LocalDateTime`

The `java.time.LocalDateTime` class represents a date-time without a time-zone in the [ISO-8601 calendar system][iso-8601], such as `2007-12-03T10:15:30`:

```java
LocalDateTime datetime = LocalDateTime.of(2007, 12, 3, 10, 15, 30);
```

You can convert a `LocalDate` instance into a `LocalDateTime`:

```java
LocalDate date = LocalDate.of(2007, 12, 3);
LocalDateTime datetime = date.atTime(10, 15, 30);
datetime.toString();
// => "2007-12-03T10:15:30"
```

### Formatting datetimes

Both `LocalDate` and `LocalDateTime` use the [ISO-8601][iso-8601] standard notation when converting from and to a `String`.

```java
LocalDateTime datetime = LocalDateTime.of(2007, 12, 3, 10, 15, 30);
LocalDateTime parsed = LocalDateTime.parse("2007-12-03T10:15:30");

datetime.isEqual(parsed);
// => true
```

Attempting to parse a `LocalDate` or `LocalDateTime` from a `String` like this using a different format is not possible.
Instead, to format dates using a custom format, you should use the `java.time.format.DateTimeFormatter`:

```java
DateTimeFormatter parser = DateTimeFormatter.ofPattern("dd/MM/yyyy");
LocalDate date = LocalDate.parse("03/12/2007", parser);

DateTimeFormatter printer = DateTimeFormatter.ofPattern("MMMM d, yyyy");
printer.format(date);
// => "December 3, 2007"
```

[iso-8601]: https://en.wikipedia.org/wiki/ISO_8601
