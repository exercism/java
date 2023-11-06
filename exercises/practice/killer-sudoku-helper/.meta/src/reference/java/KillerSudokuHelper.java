import java.util.ArrayList;
import java.util.List;

public class KillerSudokuHelper {

    // Method to be called when no numbers are to be excluded.
    public List<List<Integer>> combinationsInCage(Integer cageSum, Integer cageSize) {
        // Call the main method with an empty exclude list.
        return combinationsInCage(cageSum, cageSize, new ArrayList<>());
    }

    // Main method that includes to exclude list in the parameters.
    public List<List<Integer>> combinationsInCage(Integer cageSum, Integer cageSize, List<Integer> exclude) {
        // The range of valid numbers for a standard Sudoku puzzle.
        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9));
        numbers.removeAll(exclude);

        return findCombinations(numbers, cageSum, cageSize, 0, new ArrayList<>());
    }

    // Helper method to recursively find the combinations.
    private List<List<Integer>> findCombinations(List<Integer> numbers, Integer cageSum, Integer cageSize,
                                                 Integer start,
                                                 List<Integer> current) {
        List<List<Integer>> results = new ArrayList<>();

        if (cageSize == 0) {
            // Base case: if the current combination sums up to the cage sum, add it to the results.
            if (sum(current) == cageSum) {
                results.add(new ArrayList<>(current));
            }
            return results;
        }

        for (int i = start; i < numbers.size(); i++) {
            // Choose the number at the current position.
            current.add(numbers.get(i));
            // Explore further with the chosen number.
            results.addAll(findCombinations(numbers, cageSum, cageSize - 1, i + 1, current));
            // Un-choose the number for backtracking.
            current.remove(current.size() - 1);
        }

        return results;
    }

    private int sum(List<Integer> list) {
        int sum = 0;
        for (int number : list) {
            sum += number;
        }
        return sum;
    }

}
