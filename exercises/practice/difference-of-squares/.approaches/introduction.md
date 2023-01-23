```java
import java.util.stream.IntStream;

class DifferenceOfSquaresCalculator {

    int computeSquareOfSumTo(int input) {
        int sum = IntStream.rangeClosed(1, input).sum();
        return sum * sum;
    }
    
    int computeSumOfSquaresTo(int input) {
        return IntStream.rangeClosed(1, input)
            .map(num -> (int) Math.pow(num, 2))
            .sum();
    }
    
    int computeDifferenceOfSquares(int input) {
        return computeSquareOfSumTo(input) - computeSumOfSquaresTo(input);
    }
}
```

```java
class DifferenceOfSquaresCalculator {

    int computeSquareOfSumTo(int input) {
        int sum = (input * (input + 1)) / 2;
        return sum * sum;
    }

    int computeSumOfSquaresTo(int input) {
        return (input * (input + 1) * ((input * 2) + 1)) / 6;
    }

    int computeDifferenceOfSquares(int input) {
        return computeSquareOfSumTo(input) - computeSumOfSquaresTo(input);
    }

}
```
