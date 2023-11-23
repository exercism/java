# About

## Generating random values

There are multiple ways to generate random values in Java.

### Using `Random`

The [`java.util.Random`][java-util-random-docs] class provides several methods to generate pseudo-random values.

```java
Random random = new Random();

random.next(8); // Generates a random int with the given number of bits, in this case 8

random.nextInt(); // Generates a random int in the range Integer.MIN_VALUE through Integer.MAX_VALUE
random.nextInt(10); // Generates a random int in the range 0 to 10

random.nextFloat(); // Generates a random float in the range 0.0 to 1.0
random.nextDouble(); // Generates a random double in the range 0.0 to 1.0

random.nextBoolean(); // Generates a random boolean value
random.nextLong(); // Generates a random long value
```

Next to its default constructor, the `Random` class also has another constructor where a custom seed can be provided.
If two instances of Random are created with the same seed, and the same sequence of method calls is made for each, they will generate and return identical sequences of numbers.

### Using `Math.random()`

The [`Math.random()`][math-random-docs] method is a utility method to generate a random `Double` in the range from `0.0` to `1.0`.

### Using `ThreadLocalRandom`

The [`java.util.concurrent.ThreadLocalRandom`][thread-local-random-docs] class is an alternative for `java.util.Random` and is designed to be thread-safe.
This class has some extra utility methods to generate values that take both a lower and upper bound, making it a bit easier to work with.

```java
ThreadLocalRandom random = ThreadLocalRandom.current();

random.nextInt(10, 20); // Generates a random int in the range 10 to 20
random.nextLong(10, 20); // Generates a random long in the range 10 to 20

random.nextFloat(10.0, 20.0); // Generates a random float in the range 10 to 20
random.nextDouble(10.0, 20.0); // Generates a random double in the range 10 to 20
```

## Security

Random values are often used to generate sensitive values like passwords.
However, all of the methods to generate random values as described above are _not_ considered cryptographically secure.

In order to generate cryptographically strong random numbers, use the [`java.security.SecureRandom`][secure-random-docs] class.

[java-util-random-docs]: https://docs.oracle.com/javase/8/docs/api/java/util/Random.html
[math-random-docs]: https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html#random--
[thread-local-random-docs]: https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/ThreadLocalRandom.html
[secure-random-docs]: https://docs.oracle.com/javase/8/docs/api/java/security/SecureRandom.html
