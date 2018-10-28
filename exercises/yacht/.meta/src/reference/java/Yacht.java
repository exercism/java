import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

class Yacht {
    private int[] dice;
    private YachtCategory yachtCategory;

    Yacht(int[] dice, YachtCategory yachtCategory) {
        this.dice = dice;
        this.yachtCategory = yachtCategory;
    }

    int score() {
        switch(this.yachtCategory) {
            case ONES:
                return Arrays.stream(dice)
                        .filter(n -> n == 1)
                        .sum();
            case TWOS:
                return Arrays.stream(dice)
                        .filter(n -> n == 2)
                        .sum();
            case THREES:
                return Arrays.stream(dice)
                        .filter(n -> n == 3)
                        .sum();
            case FOURS:
                return Arrays.stream(dice)
                        .filter(n -> n == 4)
                        .sum();
            case FIVES:
                return Arrays.stream(dice)
                        .filter(n -> n == 5)
                        .sum();
            case SIXES:
                return Arrays.stream(dice)
                        .filter(n -> n == 6)
                        .sum();
            case FULL_HOUSE:
                Collection<Long> occurrences = Arrays.stream(dice)
                        .boxed()
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                        .values();
                return occurrences.contains(2L) && occurrences.contains(3L) ? Arrays.stream(dice).sum() : 0;
            case FOUR_OF_A_KIND:
                return Arrays.stream(dice)
                        .boxed()
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                        .entrySet()
                        .stream()
                        .filter(x -> x.getValue() >= 4)
                        .map(Map.Entry::getKey)
                        .findFirst()
                        .orElse(0) * 4;
            case LITTLE_STRAIGHT:
                Arrays.sort(dice);
                return Arrays.equals(dice, new int[]{ 1, 2, 3, 4, 5 }) ? 30 : 0;
            case BIG_STRAIGHT:
                Arrays.sort(dice);
                return Arrays.equals(dice, new int[]{ 2, 3, 4, 5, 6 }) ? 30 : 0;
            case CHOICE:
                return Arrays.stream(dice).sum();
            case YACHT:
                return (Arrays.stream(dice).distinct().count() == 1) ? 50 : 0;

            default: return 0;
        }
    }
}
