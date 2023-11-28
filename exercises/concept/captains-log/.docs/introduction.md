# Introduction

## Randomness

An instance of the `java.util.Random` class can be used to generate random numbers in Java.

### Random integers

A random integer can be generated using the `nextInt()` method.
This will generate a value in the range from `Integer.MIN_VALUE` to `Integer.MAX_VALUE`.

```java
Random random = new Random();

random.nextInt();
// => -1169335537
```

To limit the range of generated values, use `nextInt(int)`.
This will generate a value in the range from `0` (inclusive) to the given upper bound (exclusive).

For example, this will generate a random number from `0` through `9`.

```java
Random random = new Random();

random.nextInt(10);
// => 6
```

And this will generate a random number from `10` through `19`.

```java
Random random = new Random();

10 + random.nextInt(10);
// => 11
```

### Random doubles

A random double can be generated using the `nextDouble()` method.
This will generate a value in the range from `0.0` to `1.0`.

```java
Random random = new Random();

random.nextDouble();
// => 0.19250004204021398
```

And this will generate a random number from `100.0` to `200.0`.

```java
Random random = new Random();

100.0 + 100.0 * random.nextDouble();
// => 111.31849856260328
```
