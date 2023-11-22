# Hints

## General

- You can use the [Random class][random-class] to generate random numbers.
- Read more in article: [Random Number Generators in Java 17][random-number-generators].

## Maze generation

You can use any algorithm to generate a perfect maze. The [recursive backtracker][recursive-backtracker] is a good choice.

## Box drawing characters

| Character | Name                                  | Unicode |
|:---------:|:--------------------------------------|:--------|
|     ┌     | box drawings light down and right     |  U+250C |
|     ─     | box drawings light horizontal         |  U+2500 |
|     ┬     | box drawings light down and horizontal|  U+252C |
|     ┐     | box drawings light down and left      |  U+2510 |
|     │     | box drawings light vertical           |  U+2502 |
|     └     | box drawings light up and right       |  U+2514 |
|     ┴     | box drawings light up and horizontal  |  U+2534 |
|     ┘     | box drawings light up and left        |  U+2518 |
|     ├     | box drawings light vertical and right |  U+2520 |
|     ⇨     | rightwards white arrow                |  U+21E8 |

[recursive-backtracker]: https://en.wikipedia.org/wiki/Maze_generation_algorithm
[random-class]: https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Random.html
[random-number-generators]: https://www.baeldung.com/java-17-random-number-generators
