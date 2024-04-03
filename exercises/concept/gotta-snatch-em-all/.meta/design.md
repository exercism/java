# Design

## Learning objectives

- Get to know the `Set` interface.
- Know about the `HashSet` class.
- Know how the `add` method works.
- Know how to perform set operations like asymmetric difference, intersection and union.

## Out of scope

- More specific subtypes of `Set`, such as `OrderedSet` and `SequencedSet`.
- More advanced classes implementing the `Set` interface, such as `TreeSet` and `LinkedHashSet`.

## Concepts

- `sets`

## Prerequisites

This exercise's prerequisites Concepts are:

- `lists`
- `generic-types`

## Analyzer

This exercise could benefit from the following rules in the [analyzer].
If the solution does not receive any of the listed feedback, it must be exemplar.
Leave a `celebratory` comment to celebrate the success!

### Task 1

The idea behind this task is that the student knows how to convert from a `List` to a `Set`.
Ideally we want the student to use the `HashSet(Collection)` constructor.
If the solution instead creates a new empty set and manually `add` or `addAll` the items in the list, leave an `actionable` comment pointing to the `HashSet` constructor instead.

### Task 2

The solution should invoke and return the result of the `add` method.
If the solution manually checks for the existence of the item using `contains` and/or an `if` statement, leave an `essential` comment pointing to the signature of the `add` method.

### Task 3

The goal of this task is to calculate the [relative complement][set-relative-complement] or difference of two sets using the `removeAll` method.
If the solution manually loops through the contents of either set, leave an `essential` comment pointing to the `removeAll` method.

Since the sets passed to the `canTrade` method are mutable on purpose, the solution may call `removeAll` on passed sets directly.
If this is the case, leave an `informative` comment explaining that it's better not to mutate the sets directly.
Instead, they should create a copy by wrapping each set in a `new HashSet()`.

The solution may use Java Streams to find the difference between the sets.
This is also an acceptable solution and requires no feedback.

### Task 4

The goal of this task is to find the [intersection][set-intersection] of a list of sets using the `retainAll` method.
If the solution manually loops through the contents of any set, leave an `essential` comment pointing to the `retainAll` method.

The solution may use Java Streams to find the intersection of the sets.
This is also an acceptable solution and requires no feedback.

### Task 5

The goal of this task is to find the [union][set-union] of a list of sets using the `addAll` method.
If the solution manually loops through the contents of any set, leave an `essential` comment pointing to the `addAll` method.

The solution may use Java Streams to find the union of the sets.
This is also an acceptable solution and requires no feedback.

[analyzer]: https://github.com/exercism/java-analyzer
[set-relative-complement]: https://www.baeldung.com/java-set-operations#4-the-relative-complement-of-sets
[set-intersection]: https://www.baeldung.com/java-set-operations#2-the-intersection-of-sets
[set-union]: https://www.baeldung.com/java-set-operations#3-the-union-of-sets
