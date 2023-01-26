```java
class Scrabble {
    private int score = 0;
    Scrabble(String word) {
        word = word.toUpperCase();
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
    }
    int getScore() {
        return score;
    }
}
```

```java
class Scrabble {
    private int score = 0;
    Scrabble(String word) {
        word = word.toLowerCase();
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
    }
    int getScore() {
        return score;
    }
}
```

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
