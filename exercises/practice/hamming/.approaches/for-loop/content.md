# `for` loop

```java
public class Hamming {

    private int difference = 0;

    public Hamming(String leftStrand, String rightStrand) {
        if (leftStrand.length() != rightStrand.length()) {
            throw new IllegalArgumentException("strands must be of equal length");
        }
        for (int i = 0; i < leftStrand.length(); i++){
            if (leftStrand.charAt(i) != rightStrand.charAt(i)){
                difference++;
            }
        }
    }

    public int getHammingDistance() {
        return difference;
    }
}
```

This approach starts be defining a [`private`][private] `int` variable to keep track of the difference between the strands.

After the validation code, the real work is done by the [`for` loop][for].
It iterates from `0` up to but not including the length of the left strand.
For each value of `i`, it compares the values of the elements in the two strands at the index of `i`.
If the values are different, the difference variable is incremented.

The `getHammingDistance()` method returns the difference variable, which is set to the correct value after the `for` loop is done.

[private]: https://en.wikibooks.org/wiki/Java_Programming/Keywords/private
[for]: https://docs.oracle.com/javase/tutorial/java/nutsandbolts/for.html
