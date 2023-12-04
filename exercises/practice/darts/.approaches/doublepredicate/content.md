# `DoublePredicate`

```java
import java.util.function.DoublePredicate;

class Darts {

    private static final double innerRing = 1.0;
    private static final double middleRing = 5.0;
    private static final double outerRing = 10.0;

    int score(double x, double y) {
        var pointRadius = (Math.sqrt((x * x) + (y * y)));
        DoublePredicate thrownOutside = ring -> pointRadius > ring;

        if (thrownOutside.test(outerRing))
            return 0;
        if (thrownOutside.test(middleRing))
            return 1;
        if (thrownOutside.test(innerRing))
            return 5;
        return 10;
    }
}
```

This approach starts by importing from packages for what is needed.

The `score()` function starts by defining some [`private`][private] [`static`][static] [`final`][final] variables to represent
each radius of the rings.

Then the radius of the dart throw is calculated and assigned to a variable.
A `DoublePredicate` is defined as a [lambda][lambda] that takes in a `double` value that represents the ring radius
and compares it with the dart throw radius.

~~~~exercism/note
Although the dart throw radius is not directly passed to the lambda, the lambda can use it.
To do so is called [capturing](https://www.geeksforgeeks.org/java-lambda-expression-variable-capturing-with-examples/) the variable.
To capture a variable, it must be in the enclosing [scope](https://www.geeksforgeeks.org/variable-scope-in-java/)
of the lambda, and it must be effectively `final`,
meaning that is is not changed in the course of the program.
~~~~

~~~~exercism/note
The reason `DoublePredicate` is used instead of `Predicate<Double>` is to avoid the
[autoboxing](https://docs.oracle.com/javase/tutorial/java/data/autoboxing.html)
that `Predicate<Double>` would do.
`DoublePredicate` handles its primitive `double` argument without boxing it.
This is also why the lambda is required to be given a specific target type instead of `var`,
since the same lambda could be used for either `DoublePredicate` or `Predicate<Double>`.
~~~~

A series of calls to the `DoublePredicate` is then made.

Note that the conditions proceed from the most likely to the least likely dart throw.
Since the area outside of the dart board is larger than the dart board itself,
there is more likelihood that the throw will be outside of the dart board
(especially if playing darts after being in the pub for a few hours).

The combination of meaningful names for each radius of the rings and the meaningful name for the `DoublePredicate`
result in statements that read much like a natural sentence.

[private]: https://en.wikibooks.org/wiki/Java_Programming/Keywords/private
[final]: https://en.wikibooks.org/wiki/Java_Programming/Keywords/final
[static]: https://en.wikibooks.org/wiki/Java_Programming/Keywords/static
[lambda]: https://www.geeksforgeeks.org/lambda-expressions-java-8/
