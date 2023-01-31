# `if`  statements

```java
import java.lang.Math;

class Darts {

    int score(double x, double y) {
        var radius = (Math.sqrt((x * x) + (y * y)));
        
        if (radius > 10)
            return 0;
        if (radius > 5)
            return 1;
        if (radius > 1)
            return 5;
        return 10;
    }
}
```

This approach starts by importing from packages for what is needed.

The `score()` function starts by calculating the radius of the dart throw.
Then the series of `if` statements compares the radius of the dart throw with the radius of the rings.

Note that the conditions proceed from the most likely to the least likely dart throw.
Since the area outside of the dart board is larger than the dart board itself,
there is more likelihood that the throw will be outside of the dart board
(especially if playing darts after being in the pub for a few hours).

Each ring's radius is represented by a [magic number][magic-numbers].
We see that the dart throw's radius is compared with `10`, but we don't know by looking at the code exactly what `10` stands for.

A variation of this approach could define some [`private`][private] [`static`][static] [`final`][final] variables to represent
each radius of the rings.
They would be `private` because they wouldn't need to be directly accessed from outside the class, and `final`
because their values wouldn't need to be changed once they were set.
They would be `static` because they wouldn't need to differ between object instantiations, so they could belong to the class itself.
The condition `radius > outerRing` would be more informative than `radius > 10`.

[magic-numbers]: https://en.wikipedia.org/wiki/Magic_number_(programming)
[private]: https://en.wikibooks.org/wiki/Java_Programming/Keywords/private
[final]: https://en.wikibooks.org/wiki/Java_Programming/Keywords/final
[static]: https://en.wikibooks.org/wiki/Java_Programming/Keywords/static
