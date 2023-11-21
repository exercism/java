# `while` loop

```java
class CollatzCalculator {

    int computeStepCount(int start) {
        if (start < 1) {
            throw new IllegalArgumentException("Only positive integers are allowed");
        }
        
        int steps = 0;

        while (start > 1) {
            if ((start & 1) == 1) {
                start = start * 3 + 1;
            } else {
                start >>= 1;
            }
            steps++;
        }
        return steps;
    }
}
```

This approach defines a `steps` variable initialized to `0` that will be incremented for each iteration of the [`while` loop][while-loop].
The `while` loop iterates as long as the input number is greater than `1`.
If the number is already `1` before control flow gets to the `while` loop, then the `while` loop won't run.

[Bitwise operators][bitwise-operators] are used to check if the number is odd and to divide it in half if it is even.
The bitwise AND operator (`&`) compares the number with `1` to see if it is odd.

~~~~exercism/note
Another way to go about checking if the number is even or odd is to see if it is evenly divided by `2`
by using the [modulo (also know as the remainder) operator](https://www.geeksforgeeks.org/modulo-or-remainder-operator-in-java/).
So, to see if it is even we could use `if (start % 2 == 0)`.
That might be slightly less performant but perhaps more readable for intent, especially for those who don't "speak binary".
~~~~

If the number is even, then the right shift equals operator (`>>=`) shifts all of the bits once to the right, which is the equivalent
of dividing the number by `2`.
Another way would be to use the division equals operator `start \= 2` which might be slighly less performant but more readable
for intent, especially for those who don't "speak binary".

After the condition for the `while` loop is satisifed, it ends and the value of `steps` is returned.

[while-loop]: https://www.geeksforgeeks.org/java-while-loop-with-examples/
[bitwise-operators]: https://www.geeksforgeeks.org/java-logical-operators-with-examples/
