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

- `actionable`: If the solution hardcodes the number of planet classes in `randomPlanetClass`, instruct the student to use `length` method instead.
- `informative`: If the solution uses Java version >= 17 and [`RandomGenerator.nextDouble(double)`][nextDouble(double)], inform the student that they could use [`RandomGenerator.nextDouble(double, double)`][nextDouble(double, double)] to achieve a clearer solution.
- `informative`: If the solution uses Java version >= 17 and [`RandomGenerator.nextInt(int)`][nextInt(int)], inform the student that they could use [`RandomGenerator.nextInt(int, int)`][nextInt(int, int)] to achieve a clearer solution.
- `informative`: If the solution uses `String.format` in the `randomShipRegistryNumber` method, inform the student that this cause a small performance penalty compared to string concatenation.

If the solution does not receive any of the above feedback, it must be exemplar.
Leave a `celebratory` comment to celebrate the success!

[analyzer]: https://github.com/exercism/java-analyzer
[nextDouble(double)]: https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/random/RandomGenerator.html#nextDouble(double)
[nextDouble(double, double)]: https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/random/RandomGenerator.html#nextDouble(double,double)
[nextInt(int)]: https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/random/RandomGenerator.html#nextInt(int)
[nextInt(int, int)]: https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/random/RandomGenerator.html#nextInt(int,int)
