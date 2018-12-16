import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

class BookStore {

    private static final int BOOK_PRICE = 8, MAX_GROUP_SIZE = 5;

    private static final double[] DISCOUNT_TIERS = {0, 5, 10, 20, 25};

    double calculateBasketCost(final List<Integer> books) {
        List<Integer> reorderedBooks = reorderBooks(books);
        return calculateBasketCost(reorderedBooks, 0);
    }

    private List<Integer> reorderBooks(final List<Integer> books) {
        // Counting how often a book number appears in the basket list
        HashMap<Integer, Integer> numberCount = new HashMap<>();
        for (Integer book : books) {
            numberCount.computeIfPresent(book, (key, value) -> value + 1);
            numberCount.putIfAbsent(book, 1);
        }

        return books.stream()
                .sorted((bookNumberOne, bookNumberTwo) -> {
                    Integer countOne = numberCount.get(bookNumberOne);
                    Integer countTwo = numberCount.get(bookNumberTwo);
                    // Books whose numbers appear more often should be in front of the basket list
                    if (countOne > countTwo) {
                        return -1;
                    } else if (countOne.equals(countTwo)) {
                        return 0;
                    } else {
                        return 1;
                    }
                })
                .collect(Collectors.toList());
    }

    private double calculateBasketCost(final List<Integer> books, final double priceSoFar) {
        if (books.size() == 0) {
            return priceSoFar;
        }

        List<Integer> availableBookNumbers = books.stream()
                .distinct()
                .collect(Collectors.toList());

        double minPrice = Double.MAX_VALUE;

        for (int i = 0; i < availableBookNumbers.size(); i++) {
            List<Integer> newGroupBooks = new ArrayList<>(availableBookNumbers.subList(0, i + 1));
            List<Integer> remainingBooks = new ArrayList<>(books);

            for (final Integer newGroupBook : newGroupBooks) {
                //noinspection UseBulkOperation - we want to remove _one_ of each book number,
                //not _all_ of each book number.
                remainingBooks.remove(newGroupBook);
            }

            double price = calculateBasketCost(remainingBooks, priceSoFar + costOfGroupSize(newGroupBooks.size()));
            minPrice = Math.min(minPrice, price);
        }

        return minPrice;
    }

    private double costOfGroupSize(int groupSize) {
        if (groupSize < 1 || groupSize > MAX_GROUP_SIZE) {
            throw new IllegalStateException("Invalid group size : " + groupSize);
        }

        return BOOK_PRICE * groupSize * (100 - DISCOUNT_TIERS[groupSize - 1]) / 100;
    }

}
