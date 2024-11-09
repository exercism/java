import java.util.List;
import java.util.ArrayList;

class ChangeCalculator {
    private final List<Integer> currencyCoins;

    ChangeCalculator(List<Integer> currencyCoins) {
        this.currencyCoins = currencyCoins;
    }

    List<Integer> computeMostEfficientChange(int grandTotal) {
        if (grandTotal < 0) 
            throw new IllegalArgumentException("Negative totals are not allowed.");

        List<List<Integer>> coinsUsed = new ArrayList<>(grandTotal + 1);
        coinsUsed.add(new ArrayList<Integer>());

        for (int i = 1; i <= grandTotal; i++) {
            List<Integer> bestCombination = null;
            for (int coin: currencyCoins) {
                if (coin <= i && coinsUsed.get(i - coin) != null) {
                    List<Integer> currentCombination = new ArrayList<>(coinsUsed.get(i - coin));
                    currentCombination.add(0, coin);
                    if (bestCombination == null || currentCombination.size() < bestCombination.size())
                        bestCombination = currentCombination;
                }
            }
            coinsUsed.add(bestCombination);
        }

        if (coinsUsed.get(grandTotal) == null)
            throw new IllegalArgumentException("The total " + grandTotal + " cannot be represented in the given currency.");

        return coinsUsed.get(grandTotal);
    }
}