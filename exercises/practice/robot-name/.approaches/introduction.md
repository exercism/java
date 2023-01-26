# Introduction

There are at least two idiomatic ways to solve Robot Name.
One approach is to randomly generate each new name and check it against a collection of used names.
If the name has already been used, then keep randomly generating a new name until it does not match a used name.
If the new name has not been used, then add it to the collection of used names.

Another approach is to generate all possible names, randomly shuffle them, and then take from them in sequence.
That approach avoids the collision of new names against used names.
The chance of collision increases as more used names are added.

## General guidance

Regardless of the approach used, one thing to consider is to generate the whole number at once instead of three separate digits.

## Approach: Randomly add to used names

```java
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class Robot {
    private static final Set < String > usedNames = new HashSet();
    private static final Random random = new Random();

    private String name;

    public Robot() {
        reset();
    }
    public String getName() {
        return name;
    }
    public void reset() {
        usedNames.remove(this.name);
        String name;
        while (usedNames.contains(name = generateName())) {
            continue;
        }
        usedNames.add(name);
        this.name = name;
    }
    private static String randomString(char fromChar, char toChar, int len) {
        return random.ints(fromChar, toChar + 1).limit(len)
            .mapToObj(ch -> Character.toString((char) ch))
            .collect(Collectors.joining());
    }
    private static String generateName() {
        return randomString('A', 'Z', 2) + randomString('0', '9', 3);
    }
}
```

For more information, check the [randomly add to used names approach][approach-random-add-to-used-names].

## Approach: Sequentially take from shuffled names

```java
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.stream.IntStream;

class Robot {
    private String name = RobotNameGen.GetName();
    
    public void reset() {
        name = RobotNameGen.GetName();
    }
    
    public String getName() {
        return name;
    }

    static class RobotNameGen {
        private static int namesIndex = -1;
        private static List < String > names = new ArrayList();
        
        static {
            IntStream.rangeClosed('A', 'Z')
                .forEach(letter1 -> IntStream.rangeClosed('A', 'Z').forEach(letter2 ->
                    IntStream.range(0, 1000).forEach(num ->
                        names.add(String.format("%c%c%03d", (char) letter1, (char) letter2, num)))));
            Collections.shuffle(names, new Random(System.currentTimeMillis()));
        }
        
        public static String GetName() {
            return names.get(++namesIndex);
        }
    }
}
```

For more information, check the [sequentially take from shuffled names approach][approach-sequential-take-from-shuffled-names].

## Which approach to use?

Benchmarking with the [Java Microbenchmark Harness][jmh] is currently outside the scope of this document,
but taking from shuffled names will avoid the collision that happens with checking a new randomly generated name against used names.
One advantage to checking randomly generated names against used names would be if only a few names were ever expected to be generated.
In that case, randomly generating names would use much less processing and memory than creating a collection of all possible names.

[approach-random-add-to-used-names]: https://exercism.org/tracks/java/exercises/robot-name/approaches/random-add-to-used-names
[approach-sequential-take-from-shuffled-names]: https://exercism.org/tracks/java/exercises/robot-name/approaches/sequential-take-from-shuffled-names
[jmh]: https://github.com/openjdk/jmh
