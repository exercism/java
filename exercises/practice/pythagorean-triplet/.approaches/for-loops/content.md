# `for` loops

```java
import java.util.*;

public class PythagoreanTriplet {

    private final int a;
    private final int b;
    private final int c;

    private PythagoreanTriplet() {
        this.a = 0;
        this.b = 0;
        this.c = 0;
    }

    public PythagoreanTriplet(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public static PythagoreanTripletBuilder makeTripletsList() {
        return new PythagoreanTriplet().createBuilder();
    }

    private PythagoreanTripletBuilder createBuilder() {
        return new PythagoreanTripletBuilder();
    }

    public class PythagoreanTripletBuilder {
        private final List < PythagoreanTriplet > triplets = new ArrayList < > ();
        private int limit = 0;
        private int sum = 0;

        public PythagoreanTripletBuilder withFactorsLessThanOrEqualTo(int limit) {
            this.limit = limit;
            return this;
        }

        public PythagoreanTripletBuilder thatSumTo(int sum) {
            this.sum = sum;
            return this;
        }

        public List < PythagoreanTriplet > build() {
            if (limit == 0)
                limit = sum / 2;
            int start = (int) Math.sqrt(sum);
            for (int a = start; a <= limit; a++) {
                for (int b = a; b <= limit; b++) {
                    double c = Math.sqrt(a * a + b * b);
                    if (c % 1 == 0 && c <= limit && a + b + c == sum) {
                        triplets.add(new PythagoreanTriplet(a, b, (int) c));
                    }
                }
            }

            return triplets;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b, c);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof PythagoreanTriplet other)
            return this.hashCode() == other.hashCode();

        return false;
    }
}
```

Many approaches will return an object of some kind of separate "builder" `class` from the `makeTripletsList()` method of the `PythagoreanTriplet` class.
This particular code does this by instantiating a new object from its nested `PythagoreanTripletBuilder` `class`.
Since the nested class is not a [`static` `class`][static-class], a new instance of the `PythagoreanTriplet` `class` is first created,
and that object returns an instance of the `PythagoreanTripletBuilder` `class`.

`PythagoreanTripletBuilder` makes use of the [Fluent API][fluent-api] design so that its `withFactorsLessThanOrEqualTo()` and
`thatSumTo()` methods can be chained together.

The real work is done in its `build()` method.
If the `limit` has not been set by the `withFactorsLessThanOrEqualTo()` method, it is set to half of the desired sum.
Any higher limit would result in factors whose combined squared values would exceed the desired sum.
The starting value is set to be the square root of the desired sum, since any valid factor will be no less than the square root of the desired sum.
Constraining the starting and limit values instead of using `2` through the desired sum is a way of minimizing unneccesary calculations.

The first [`for` loop][for-loop] starts at the starting value for `a` and keeps looping while `a` is less than or equal to the `limit`.
The nested `for` loop starts at the value of `a` for `b` and keeps looping while `b` is less than or equal to the `limit`.
The factor for `c` is calculated from the square root of the `a` squared plus `b` squared.
Then a chain of boolean conditions is used to check if the values are a desired Pythagorean Triplet.

The first check is for determing if `c` is a whole number. If it is not, then the logical AND operator (`&&`)
[short circuits][short-circuit].
The second check is for determining that `c` is less than or equal to the `limit`.
The final check is for determing that the sum of `a`, `b`, and `c` is equal to the desired sum.

If all of the checks pass then a `PythagoreanTriplet` object is created and added to the output `List`.

After the loops finish, the output `List` is returned from the `build()` method.

[static-class]: https://www.geeksforgeeks.org/static-class-in-java/
[fluent-api]: https://dzone.com/articles/java-fluent-api-design
[for-loop]: https://www.geeksforgeeks.org/java-for-loop-with-examples/
[short-circuit]: https://www.geeksforgeeks.org/short-circuit-logical-operators-in-java-with-examples/
