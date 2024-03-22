# Design

## Learning objectives

- Know how to generate a random `Integer`.
- Know how to generate a random `Double`.
- Know how to select a random element from a collection.

## Out of scope

- `java.util.SecureRandom`.

## Concepts

- `randomness`

## Prerequisites

- `strings`: know how to use string formatting.
- `numbers`: know how to apply basic mathematical operators.
- `arrays`: know how to retrieve array elements by their index.

## Analyzer

This exercise could benefit from the following rules in the [analyzer]:

- `essential`: If the student did not use the `nextInt` method in the `randomShipRegistryNumber` method, instruct the student to do so.
- `essential`: If the student did not use the `nextDouble` method in the `randomStardate` method, instruct the student to do so.
- `informative`: If the solution uses `String.format` in the `randomShipRegistryNumber` method, inform the student that this cause a small performance penalty compared to string concatenation.

If the solution does not receive any of the above feedback, it must be exemplar.
Leave a `celebratory` comment to celebrate the success!

[analyzer]: https://github.com/exercism/java-analyzer
