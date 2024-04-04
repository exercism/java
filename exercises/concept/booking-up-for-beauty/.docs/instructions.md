# Instructions

In this exercise you'll be working on an appointment scheduler for a beauty salon in New York that opened on September 15th in 2012.

## 1. Parse appointment date

Implement the `AppointmentScheduler.schedule()` method to parse a textual representation of an appointment date into the corresponding `LocalDateTime`:

```java
AppointmentScheduler scheduler = new AppointmentScheduler();
scheduler.schedule("7/25/2019 13:45:00");
// => LocalDateTime.of(2019, 7, 25, 13, 45, 0)
```

## 2. Check if an appointment has already passed

Implement the `AppointmentScheduler.hasPassed()` method that takes an appointment date and checks if the appointment was somewhere in the past:

```java
AppointmentScheduler scheduler = new AppointmentScheduler();
scheduler.hasPassed(LocalDateTime.of(1999, 12, 31, 9, 0, 0));
// => true
```

## 3. Check if appointment is in the afternoon

Implement the `AppointmentScheduler.isAfternoonAppointment()` method that takes an appointment date and checks if the appointment is in the afternoon (>= 12:00 and < 18:00):

```java
AppointmentScheduler scheduler = new AppointmentScheduler();
scheduler.isAfternoonAppointment(LocalDateTime.of(2019, 03, 29, 15, 0, 0))
// => true
```

## 4. Describe the time and date of the appointment

Implement the `AppointmentScheduler.getDescription()` method that takes an appointment date and returns a description of that date and time:

```java
AppointmentScheduler scheduler = new AppointmentScheduler();
scheduler.getDescription(LocalDateTime.of(2019, 03, 29, 15, 0, 0))
// => "You have an appointment on Friday, March 29, 2019, at 3:00 PM."
```

## 5. Return the anniversary date

Implement the `AppointmentScheduler.getAnniversaryDate()` method that returns this year's anniversary date, which is September 15th:

```java
AppointmentScheduler scheduler = new AppointmentScheduler();
scheduler.getAnniversaryDate()
// => LocalDate.of(<current year>, 9, 15)
```
