# Introduction

There are various idiomatic ways to solve Scrabble Score.
The approaches could be to use a series of `if` statements, or a single `switch` statement.
Another approach could be to look up the score in a `HashMap` from inside the `reduce()` method.

## General guidance

Regardless of the approach used, one thing to look out for is to whether to calculate the score in the constructor (or a method called by the constructor) or in the `getScore()` method.
A benefit to calculating in the constructor is that the score is calculated only once, no matter how many times `getScore()` is called.
A benefit to calculating in `getScore()` is that, if it is not called, then the calculation never has to be performed.
But then, in that case, why instantiate the `Scrabble` object at all?

## Approach: `if` statements

```java
class Scrabble {
    private final int score;
    
    Scrabble(String word) {
        word = word.toUpperCase();
        int score = 0;
        
        for (int i = 0; i < word.length(); i++) {
            var ltr = word.substring(i, i + 1);
            if ("AEIOULNRST".contains(ltr))
                score += 1;
            else if ("DG".contains(ltr))
                score += 2;
            else if ("BCMP".contains(ltr))
                score += 3;
            else if ("FHVWY".contains(ltr))
                score += 4;
            else if ("K".contains(ltr))
                score += 5;
            else if ("JX".contains(ltr))
                score += 8;
            else if ("QZ".contains(ltr))
                score += 10;
        }
        this.score = score;
    }
    
    int getScore() {
        return score;
    }
}
```

For more information, check the [`if` statements approach][approach-if-statements].

## Approach: `switch` statement

```java
class Scrabble {
    private final int score;
    
    Scrabble(String word) {
        word = word.toLowerCase();
        int score = 0;
        
        for (int i = 0; i < word.length(); i++) {
            switch (word.charAt(i)) {
            case 'a', 'e', 'i', 'o', 'u', 'l', 'n', 'r', 's', 't':
                score += 1;
                break;
            case 'd', 'g':
                score += 2;
                break;
            case 'b', 'c', 'm', 'p':
                score += 3;
                break;
            case 'f', 'h', 'v', 'w', 'y':
                score += 4;
                break;
            case 'k':
                score += 5;
                break;
            case 'j', 'x':
                score += 8;
                break;
            case 'q', 'z':
                score += 10;
                break;
            default:
                break;
            }
        }
        this.score = score;
    }
    
    int getScore() {
        return score;
    }
}
```

For more information, check the [`switch` statement approach][approach-switch-statement].

## Approach: `HashMap` with `reduce()`

```java
import java.util.HashMap;
import java.util.stream.IntStream;

class Scrabble {

    private final int savedScore;
    private final static HashMap < Integer, Integer > lookup = new HashMap(26);
    private final static String[] letters = {
        "AEIOULNRST",
        "DG",
        "BCMP",
        "FHVWY",
        "K",
        "JX",
        "QZ"
    };
    private final static int[] scores = {
        1,
        2,
        3,
        4,
        5,
        8,
        10
    };

    static {
        IntStream.range(0, letters.length)
            .forEach(index -> letters[index].chars().forEach(letter -> lookup.put(letter, scores[index])));
    }

    Scrabble(String word) {
        savedScore = word.toUpperCase().chars().reduce(0, (score, letter) -> score + lookup.get(letter));
    }

    int getScore() {
        return savedScore;
    }

}
```

For more information, check the [`HashMap` with `reduce()` approach][approach-map-reduce].

## Which approach to use?

Since benchmarking with the [Java Microbenchmark Harness][jmh] is currently outside the scope of this document, the choice between the approaches can be made by perceived readability.

[approach-if-statements]: https://exercism.org/tracks/java/exercises/scrabble-score/approaches/if-statements
[approach-switch-statement]: https://exercism.org/tracks/java/exercises/scrabble-score/approaches/switch-statement
[approach-map-reduce]: https://exercism.org/tracks/java/exercises/scrabble-score/approaches/map-reduce
[jmh]: https://github.com/openjdk/jmh
