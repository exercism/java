# Instructions

You have just started working at the front desk of a climbing gym.
Members buy memberships for a number of months and check in and out every time they visit.
The manager has asked you to write a helper that answers the questions members ask most often.

## 1. Work out when a membership ends

A membership that starts on a given date ends on the same day of the month, the given number of months later.
When that day does not exist in the end month, the membership ends on the last day of that month instead.

Implement the `FrontDesk.membershipEnd()` method that takes the start date of a membership and its number of months, and returns the date on which it ends:

```java
FrontDesk frontDesk = new FrontDesk();
frontDesk.membershipEnd(LocalDate.of(2024, 3, 10), 1);
// => LocalDate.of(2024, 4, 10)
frontDesk.membershipEnd(LocalDate.of(2025, 1, 31), 1);
// => LocalDate.of(2025, 2, 28)
```

## 2. Show how long a membership lasts

On the membership card, the gym prints how long the membership lasts in years, months and days.

Implement the `FrontDesk.membershipLength()` method that takes the start date and the end date of a membership, and returns the length of the membership as a `Period`:

```java
FrontDesk frontDesk = new FrontDesk();
frontDesk.membershipLength(LocalDate.of(2023, 3, 10), LocalDate.of(2024, 5, 25));
// => Period.of(1, 2, 15)
```

## 3. Count the days left on a membership

Members often ask how many days they have left before their membership ends.

Implement the `FrontDesk.daysLeft()` method that takes today's date and the end date of a membership, and returns the total number of days from today until the end date.
When the end date is today or has already passed, there are no days left, so the method returns `0`:

```java
FrontDesk frontDesk = new FrontDesk();
frontDesk.daysLeft(LocalDate.of(2024, 1, 15), LocalDate.of(2024, 3, 20));
// => 65
frontDesk.daysLeft(LocalDate.of(2024, 4, 2), LocalDate.of(2024, 3, 20));
// => 0
```

## 4. Measure a visit

The gym is open around the clock, and the turnstile records the date and time when a member checks in and out.

Implement the `FrontDesk.visitDuration()` method that takes the check-in and check-out date-times of a visit, and returns how long the visit lasted as a `Duration`:

```java
FrontDesk frontDesk = new FrontDesk();
frontDesk.visitDuration(LocalDateTime.of(2024, 3, 10, 23, 30), LocalDateTime.of(2024, 3, 11, 1, 15));
// => Duration.ofMinutes(105)
```

## 5. Print a visit on the receipt

The receipt shows the length of a visit in hours and minutes, like `1h 35m`.
The minutes are always written with two digits, any seconds are left out, and the hours are not limited to a single day.

Implement the `FrontDesk.formatVisit()` method that takes the duration of a visit and returns it in this format:

```java
FrontDesk frontDesk = new FrontDesk();
frontDesk.formatVisit(Duration.ofMinutes(95));
// => "1h 35m"
frontDesk.formatVisit(Duration.ofHours(2).plusMinutes(5));
// => "2h 05m"
frontDesk.formatVisit(Duration.ofHours(26).plusMinutes(10));
// => "26h 10m"
```
