# Design

Of the many available Java collection types, we chose to use the `array` collection type as the first collection type students will be taught for the following reasons:

- Arrays don't require the student to know about generics.
- Arrays are a common data type in many languages.
- Arrays have a fixed length. No complexity in adding or removing elements.
- Arrays have a simple shorthand syntax. No need to understand how constructors work to define an array.

## Learning objectives

- The existence of the `Array` type.
- Defining an array.
- Accessing elements in an array by index.
- Updating an element in an array by index.
- Iterating over elements in an array.
- Basic array functions (like finding the index of an element in an array).

## Out of scope

- Multi-dimensional/jagged arrays.
- Memory and performance characteristics of arrays.
- Enumerables.
- Iterators.

## Concepts

- `arrays`: know of the existence of the `Array` type; know how to define an array; know how to access elements in an array by index; know how to update an element in an array by index; know how to iterate over elements in an array; know of some basic functions (like finding the index of an element in an array).
- `for-loops`: know how to use a `for` loop to do iteration.
- `foreach-loops`: know how to iterate over a collection.

## Prerequisites

This exercise's prerequisites Concepts are:

- `classes`: know how to work with fields.
- `booleans`: know what a `boolean` is.
- `basics`: know how to work with `integers` and how to assign and update variables.

## Analyzer

This exercise could benefit from the following rules in the [analyzer]:

- `essential`: Verify that the solution does not hard-code the arrays used by the tests (`{2, 5, 0, 7, 4, 1 }`, `{0, 2, 5, 3, 7, 8, 4}`)
- `actionable`: If the student did not use `clone` in the constructor to make a copy of the array, instruct them to do so.
- `informative`: If the student used a different loop than a `For-Each` one in the methods `hasDayWithoutBirds` and `getBusyDays`, inform them that the solution can be improve using it.

[analyzer]: https://github.com/exercism/java-analyzer
