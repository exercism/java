# Hints

## General

- The bird count per day is stored in a field named `birdsPerDay`.
- The bird count per day is an array that contains exactly 7 integers.

## 1. Check what the counts were last week

- As we keep the last week we just need to return the last week values.

## 2. Check how many birds visited today

- Remember that the counts are ordered by day from oldest to most recent, with the last element representing today.
- Accessing the last element can be done either by using its (fixed) index (remember to start counting from zero) or by calculating its index using the array's size.

## 3. Increment today's count

- Set the element representing today's count to today's count plus 1.

## 4. Check if there was a day with no visiting birds

- The array can be iterated over using a `for` loop.
- Another solution is to use the Java Stream Api.

## 5. Calculate the number of visiting birds for the first number of days

- A variable can be used to hold the count for the number of visiting birds.
- The array can be iterated over using a `for` loop.
- The variable can be updated inside the loop.
- Remember: arrays are indexed from `0`.

## 6. Calculate the number of busy days

- A variable can be used to hold the number of busy days.
- The array can be iterated over using a `foreach` loop.
- The variable can be updated inside the loop.
- A conditional statement can be used inside the loop.
