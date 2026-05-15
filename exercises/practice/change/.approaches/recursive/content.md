# Recursive

```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class ChangeCalculator {

    private final List<Integer> currencyCoins;

    ChangeCalculator(List<Integer> currencyCoins) {
        this.currencyCoins = List.copyOf(currencyCoins);
    }

    List<Integer> computeMostEfficientChange(int grandTotal) {
        if (grandTotal < 0) {
            throw new IllegalArgumentException("Negative totals are not allowed.");
        }
        if (grandTotal == 0) {
            return Collections.emptyList();
        }

        return currencyCoins.stream().map(coin -> {
                    int remaining = grandTotal - coin;
                    if (remaining == 0) {
                        return List.of(coin);
                    }

                    try {
                        List<Integer> result = new ArrayList<>(computeMostEfficientChange(remaining));
                        result.add(coin);
                        result.sort(Integer::compare);
                        return result;
                    } catch (IllegalArgumentException e) {
                        return Collections.<Integer>emptyList();
                    }
                })
                .filter(c -> !c.isEmpty())
                .min(Comparator.comparingInt(List::size))
                .orElseThrow(() -> new IllegalArgumentException("The total " + grandTotal + " cannot be represented in the given currency."));

    }
}
```

The recursive approach works by iterating through the available coins and recursively calling itself to find the most efficient change with it.
It starts by validating the `grandTotal` argument.
If valid, use a stream to go through the available coins and determines how much change is still required if the coin is included.
If no more change is required, the most efficient change consists simply of the coin on its own.
Otherwise it will recursively call itself to find the most efficient change for the remaining amount.
The recursive call is done in a `try-catch` block because the method throws an `IllegalArgumentionException` if the change can not be made.
An empty list is used to indicate when the change can not be made in the stream.
The stream filters out the empty list in the next step before finding the smallest list.
If the stream is empty, an `IllegalArgumentException` is thrown to indicate the change could not be made.
